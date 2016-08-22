package airsponge.com.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import airsponge.com.au.entity.User;
import airsponge.com.au.service.UserService;

@Controller
public class IndexController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/index")
	public String index()
	{
		UserDetails user = Helper.sessionCheck();
		if (user == null) {
			return "loginpage";
		
		} else {
		
			User sessionUser = userService.findbyemail(user.getUsername());
			
			String sessionUserRole = sessionUser.getRole().getUrlname();
			
			if (sessionUserRole.equals("admin")) {
				return "redirect:/admin/users.html";
			} else {
				return "redirect:/user/dashboard.html";
			}
		}
		
	}

	
}
