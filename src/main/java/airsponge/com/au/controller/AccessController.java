package airsponge.com.au.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import airsponge.com.au.DTO.ChangePasswordModel;
import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.DTO.WasherRegModel;
import airsponge.com.au.entity.Address;
import airsponge.com.au.entity.User;
import airsponge.com.au.entity.WashRequest;
import airsponge.com.au.entity.WashRequestItem;
import airsponge.com.au.entity.Washee;
import airsponge.com.au.entity.Washer;
import airsponge.com.au.service.AddressService;
import airsponge.com.au.service.AddressService.Tuple;
import airsponge.com.au.service.UserService;
import airsponge.com.au.service.WashRequestItemService;
import airsponge.com.au.service.WashRequestService;
import airsponge.com.au.service.WashStatusService;
import airsponge.com.au.service.WasheeService;
import airsponge.com.au.service.WasherService;
import javassist.expr.NewArray;

@Controller
public class AccessController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private WasherService washerService;

	@Autowired
	private WasheeService washeeService;

	@Autowired
	private WashRequestService washRequestService;

	@Autowired
	private WashRequestItemService washRequestItemService;

	@Autowired
	private WashStatusService washStatusService;

	private static final List<String> existingUserPages = Arrays.asList("dashboard", "profile");

	@ModelAttribute("washerRegModel")
	public WasherRegModel ConstructWasher() {
		return new WasherRegModel();
	}

	@ModelAttribute("washeeRegModel")
	public WasheeRegModel ConstructWashee() {
		return new WasheeRegModel();
	}

	@ModelAttribute("washeeRequestModel")
	public WasheeRegModel ConstructWasheeRequest() {
		return new WasheeRegModel();
	}

	@ModelAttribute("changePassModel")
	public ChangePasswordModel Constructpasswordchange() {
		return new ChangePasswordModel();
	}

	// @RequestMapping(value="/user/changepassword")
	// public String ShowpasswordChange(){
	// return "passwordchange";
	// }

	@RequestMapping(value = "/user/changepassword", method = RequestMethod.POST)
	public String DopasswordChange(@ModelAttribute("changePassModel") ChangePasswordModel changepassModel,
			Principal principal) {

		User user = userService.findbyemail(principal.getName());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(changepassModel.getCurrentPassword(), user.getPassword())) {
			user.setPassword(encoder.encode(changepassModel.getNewPassword()));
			userService.save(user);
			return "redirect:/user/changepassword.html?success=true";
		}

		return "redirect:/user/changepassword.html?success=false";
	}

	/// Used washeeRegModel for both profile forms to make it more consistent
	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public String updateUserProfile(@ModelAttribute("washeeRequestModel") WasheeRegModel washeeRegModel,
			Principal principal) {

		userService.update(washeeRegModel, principal.getName());
		return "redirect:/user/profile.html?success=true";
	}

	/// Used washeeRegModel for both profile forms to make it more consistent
	@RequestMapping(value = "/user/dashboard", method = RequestMethod.POST)
	public String doWasheRequestfromDash(@ModelAttribute("washeeRequestModel") WasheeRegModel washeeRegModel,
			Principal principal) {

		washRequestService.save(washeeRegModel, principal.getName());
		return "redirect:/user/dashboard.html";
	}

	@RequestMapping("/{role}/{type}")
	public String users(Model model, @PathVariable String role, @PathVariable String type) {

		UserDetails userDetails = Helper.sessionCheck();

		// if user is not logged in
		if (userDetails == null) {
			return "loginpage";

			// if user is logged in
		} else {
			return returnPageType(model, userDetails, role, type);
		}
	}

	@RequestMapping("/admin/{id}/{type}")
	public String detail(Model model, @PathVariable int id, @PathVariable String type) {

		UserDetails user = Helper.sessionCheck();
		if (user == null) {
			return "loginpage";
		} else {
			User sessionUser = userService.findbyemail(user.getUsername());

			if (sessionUser.getRole().getUrlname().equals("admin")) {

				User pageUser = userService.findbyid(id);
				return returnUserPageType(model, pageUser, type);

			} else {
				return "accessdenied";
			}

		}

	}

	/**
	 * Determine which page belongs to sessionUser and return it
	 * 
	 * @param model
	 * @param type
	 * @return sessionUser's own page (jsp)
	 */
	private String returnPageType(Model model, UserDetails userDetails, String role, String type) {
		User sessionUser = userService.findbyemail(userDetails.getUsername());

		// request an admin page
		if (role.equals("admin")) {

			// if session is admin
			if (sessionUser.getRole().getUrlname().equals("admin")) {

				return returnAdminPageType(model, sessionUser, type);

				// if session is not admin
			} else {
				return "accessdenied";
			}

			// request a user page
		} else if (role.equals("user")) {

			// if session is user
			if (!sessionUser.getRole().getUrlname().equals("admin")) {

				return returnUserPageType(model, sessionUser, type);

				// if session is not user
			} else {
				return "accessdenied";
			}

			// request non existing page
		} else {
			return "error";
		}
	}

	/**
	 * Determine which user page is requested
	 * 
	 * @param model
	 * @param sessionUser
	 * @param type
	 * @return user page (jsp)
	 */
	private String returnUserPageType(Model model, User sessionUser, String type) {
		User pageUser = sessionUser;

		String urlname = pageUser.getRole().getUrlname();

		if (type.equals("profile")) {
			if (urlname.equals("washer")) {
				Washer pageWasher = washerService.findbyuser(pageUser);
				model.addAttribute("pageWasher", pageWasher);
			} else if (urlname.equals("washee")) {
				Washee pageWashee = washeeService.findbyuser(pageUser);
				model.addAttribute("pageWashee", pageWashee);
			} else if (urlname.equals("admin")) {

			} else {
				return "error";
			}

			model.addAttribute("pageUser", pageUser);
			return urlname + "Profile";

		} else if (type.equals("dashboard")) {
			if (pageUser.getRole().getUrlname().equals("washee")) {

				WashRequest washRequest1 = new WashRequest();
				washRequest1.setAddress(addressService.findbyid(1));

				Washee pageWashee = washeeService.findbyuser(pageUser);
				List<WashRequest> AllRequests = washRequestService.findbywashee(pageWashee);

				List<WashRequestItem> PendingRequests = new ArrayList<WashRequestItem>();
				List<WashRequestItem> DoneRequests = new ArrayList<WashRequestItem>();

				for (WashRequest washRequest : AllRequests) {
					WashRequestItem washRequestItem = washRequestItemService.findbyWashRequest(washRequest).get(0);

					if (washRequestItem.getWashStatus().getId() == 4) {
						DoneRequests.add(washRequestItem);

					} else {
						PendingRequests.add(washRequestItem);
					}
				}

				model.addAttribute("pendingRequests", PendingRequests);
				model.addAttribute("doneRequests", DoneRequests);
				return urlname + "Dashboard";

			} else if (pageUser.getRole().getUrlname().equals("washer")) {

				Washer pageWasher = washerService.findbyuser(pageUser);
				List<WashRequestItem> AllWasherJobs = washRequestItemService.findbywasher(pageWasher);

				List<WashRequestItem> PendingRequests = new ArrayList<WashRequestItem>();
				List<WashRequestItem> DoneRequests = new ArrayList<WashRequestItem>();
				List<WashRequestItem> AllAvailablewashes = washRequestItemService.findAllPendingWash();

				for (WashRequestItem washRequestItem : AllWasherJobs) {
					if (washRequestItem.getWashStatus().getId() == 4) {
						DoneRequests.add(washRequestItem);
					} else {
						PendingRequests.add(washRequestItem);
					}
				}

				model.addAttribute("pendingRequests", PendingRequests);
				model.addAttribute("doneRequests", DoneRequests);
				model.addAttribute("availableRequests", AllAvailablewashes);

				return urlname + "Dashboard";
			} else {
				return "error";
			}

		} else if (type.equals("changepassword")) {
			return "changePassword";
		} else {
			return "error";
		}
	}

	/**
	 * Determine which admin page is requested
	 * 
	 * @param model
	 * @param sessionUser
	 * @param type
	 * @return user page (jsp)
	 */
	private String returnAdminPageType(Model model, User sessionUser, String type) {

		// request /admin/users
		if (type.equals("users")) {

			model.addAttribute("users", userService.findAll());
			return "users";

			// request /admin/requests
		} else if (type.equals("requests")) {

			List<WashRequest> AllRequests = washRequestService.findAll();

			List<WashRequestItem> PendingRequests = new ArrayList<WashRequestItem>();
			List<WashRequestItem> DoneRequests = new ArrayList<WashRequestItem>();

			for (WashRequest washRequest : AllRequests) {
				WashRequestItem washRequestItem = washRequestItemService.findbyWashRequest(washRequest).get(0);

				if (washRequestItem.getWashStatus().getId() == 4) {
					DoneRequests.add(washRequestItem);
				} else {
					PendingRequests.add(washRequestItem);
				}
			}

			model.addAttribute("pendingRequests", PendingRequests);
			model.addAttribute("doneRequests", DoneRequests);

			return "requests";

			// request /admin/profile
		} else if (type.equals("profile")) {

			User pageUser = sessionUser;
			model.addAttribute("pageUser", pageUser);
			return "adminProfile";

			// request non existing page
		} else {
			return "error";
		}

	}

	@RequestMapping("/user/remove/washeRequest/{id}")
	public String removeWashRequest(@PathVariable int id, Principal principal) {
		User user = userService.findbyemail(principal.getName());
		String userRole = user.getRole().getUrlname();
		WashRequestItem washRequestItem = washRequestItemService.findbyid(id);

		// check if user is deleting its own wash request
		if (user.getId() == washRequestItem.getWashRequest().getWashee().getUser().getId()
				|| userRole.equals("admin")) {
			// TODO
			// Should notify the washer( if there is any )
			washRequestService.cancel(washRequestItem.getWashRequest().getId(), washRequestItem.getId());
		}

		if (userRole.equals("admin")) {
			return "redirect:/admin/requests.html";
		} else {
			return "redirect:/user/dashboard.html";
		}
	}

	@RequestMapping("/user/jobs/washerRequest/{id}")
	public String GiveMeTheJobRequest(@PathVariable int id, Principal principal) {
		User user = userService.findbyemail(principal.getName());
		Washer washer = washerService.findbyuser(user);

		WashRequestItem washRequestItem = washRequestItemService.findbyid(id);
		washRequestItem.setWasher(washer);
		washRequestItem.setWashStatus(washStatusService.findbyid(2));
		washRequestItemService.save(washRequestItem);

		return "redirect:/user/dashboard.html";

	}

	@RequestMapping("/user/jobs/washerCancelRequest/{id}")
	public String CancelmyJobRequest(@PathVariable int id, Principal principal) {
		User user = userService.findbyemail(principal.getName());
		Washer washer = washerService.findbyuser(user);
		WashRequestItem washRequestItem = washRequestItemService.findbyid(id);

		if (user.getId() == washRequestItem.getWasher().getUser().getId()) {
			washRequestItem.setWasher(null);
			washRequestItem.setWashStatus(washStatusService.findbyid(1));
			washRequestItemService.save(washRequestItem);
		}
		return "redirect:/user/dashboard.html";
	}

	@RequestMapping("/request/findnearby/{id}")
	public String findNearbyWashers(@PathVariable int id, Principal principal) {
		WashRequest request = washRequestService.findbyid(id);
		Address address = request.getAddress();
		List<Washer> washers = addressService.findNearbyWashers(address);
		for (Washer washer : washers) {
			System.out.println(washer.getUser().getAddress().getFormattedAddress());
		}
		return "redirect:/admin/requests.html";
	}

}
