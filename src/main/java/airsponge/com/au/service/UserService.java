package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderAddressComponent;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.GeocoderResult;

import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.DTO.WasherRegModel;
import airsponge.com.au.entity.Address;
import airsponge.com.au.entity.BankAccount;
import airsponge.com.au.entity.CarType;
import airsponge.com.au.entity.Electricity;
import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Vacuum;
import airsponge.com.au.entity.WashRequest;
import airsponge.com.au.entity.WashRequestItem;
import airsponge.com.au.entity.WashType;
import airsponge.com.au.entity.Washee;
import airsponge.com.au.entity.Washer;
import airsponge.com.au.entity.WaterSource;
import airsponge.com.au.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private AddressService addressService;

	@Autowired
	private WashRequestItemService washRequestItemService;

	@Autowired
	private WashStatusService washStatusService;

	@Autowired
	private WashTypeService washTypeService;

	@Autowired
	private CarTypeService carTypeService;

	@Autowired
	private WasherService washerService;

	@Autowired
	private WashRequestService washRequestService;

	@Autowired
	private VacuumService vacuumService;

	@Autowired
	private ElectricityService electricityService;

	@Autowired
	private WaterSourceService waterSourceService;

	@Autowired
	private WasheeService washeeService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BankaccountService bankaccountService;

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findbyid(int id) {
		return userRepository.findOne(id);
	}

	public User findbyemail(String email) {
		return userRepository.findByEmail(email);
	}

	public void save(User user) {
		userRepository.save(user);

	}

	public void RegisterWasher(WasherRegModel washerRegModel) {

		User newUser = new User();
		Washer newWasher = new Washer();
		Address newAdd = new Address();
		BankAccount newbankacc = new BankAccount();

		newAdd = setAddressValues(addressService.getGeoResponse(washerRegModel.getAddressLine1(),
				washerRegModel.getSuburb(), washerRegModel.getPostcode()));
		addressService.save(newAdd);

		// Saving BankAccount
		newbankacc.setAccountHolder(washerRegModel.getAccountHolder());
		newbankacc.setAccountNumber(washerRegModel.getAccountNumber());
		newbankacc.setBsb(washerRegModel.getBsb());
		newbankacc.setBankName(washerRegModel.getBankName());
		bankaccountService.save(newbankacc);

		// saving User
		newUser.setAddress(newAdd);
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		newUser.setDateRegistered(date);
		newUser.setBankAccount(newbankacc);
		newUser.setFirstName(washerRegModel.getFirstName());
		newUser.setLastName(washerRegModel.getLastName());
		newUser.setEmail(washerRegModel.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		newUser.setPassword(encoder.encode(washerRegModel.getPassword()));
		newUser.setPhone(washerRegModel.getPhone());
		newUser.setRole(roleService.findbyname("ROLE_WASHER"));
		this.save(newUser);

		// Saving Washer
		newWasher.setUser(newUser);
		newWasher.setTravelDistance(washerRegModel.getTravelDistance());
		newWasher.setHasVacuum(washerRegModel.getWasherHasVacuume());
		;
		washerService.save(newWasher);
	}

	public void RegisterWashee(WasheeRegModel washeeRegModel) {

		User newUser = new User();
		Washee newWashee = new Washee();
		Address newAdd = new Address();
		BankAccount newbankacc = new BankAccount();
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		// Saving address
		addressService.save(newAdd);

		// Saving BankAccount
		bankaccountService.save(newbankacc);

		// saving User
		newUser.setAddress(newAdd);
		newUser.setBankAccount(newbankacc);
		newUser.setDateRegistered(date);
		newUser.setFirstName(washeeRegModel.getFirstName());
		newUser.setLastName(washeeRegModel.getLastName());
		newUser.setEmail(washeeRegModel.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		newUser.setPassword(encoder.encode(washeeRegModel.getPassword()));
		newUser.setPhone(washeeRegModel.getPhone());
		newUser.setRole(roleService.findbyname("ROLE_WASHEE"));
		this.save(newUser);

		// Saving Washer
		newWashee.setUser(newUser);
		washeeService.save(newWashee);

		// saving wash Request location for the wash
		Address carloc = new Address();
		carloc = setAddressValues(addressService.getGeoResponse(washeeRegModel.getAddressLine1(),
				washeeRegModel.getSuburb(), washeeRegModel.getPostcode()));
		addressService.save(carloc);
		/*
		 * carloc.setAddressLine1(washeeRegModel.getAddressLine1());
		 * carloc.setCity(washeeRegModel.getCity());
		 * carloc.setPostcode(washeeRegModel.getPostcode());
		 * addressService.save(carloc);
		 */

		// water Source
		WaterSource ws = waterSourceService.findbyid(washeeRegModel.getWaterSource());

		// Electricity
		Electricity elec = electricityService.findbyid(washeeRegModel.getElectricity());

		// vacuum
		Vacuum vac = vacuumService.findbyid(washeeRegModel.getVacuum());

		// saving wash request
		WashRequest washReq = new WashRequest();
		washReq.setWashee(newWashee);
		washReq.setAddress(carloc);
		washReq.setWaterSource(ws);
		washReq.setVacuum(vac);
		washReq.setElectricity(elec);
		washReq.setDescription(washeeRegModel.getDescription());

		washReq.setRequestDate(date);
		washRequestService.save(washReq);

		// saving wash Item ==> currently only one

		// Car Type
		CarType cartype = carTypeService.findbyid(washeeRegModel.getCarType());

		// Wash Type
		WashType washtype = washTypeService.findbyid(washeeRegModel.getWashType());

		WashRequestItem washReqItem = new WashRequestItem();
		washReqItem.setWashRequest(washReq);
		washReqItem.setCarType(cartype);
		washReqItem.setCarDescription(washeeRegModel.getCardescription());
		washReqItem.setWashType(washtype);
		washReqItem.setWashStatus(washStatusService.findbyid(1));
		washRequestItemService.save(washReqItem);

	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public void update(WasheeRegModel washeeRegModel, String name) {
		User updateUser = userRepository.findByEmail(name);
		Address updateAddress = addressService.findbyid(updateUser.getAddress().getId());

		updateAddress = setAddressValues(addressService.getGeoResponse(washeeRegModel.getAddressLine1(),
				washeeRegModel.getSuburb(), washeeRegModel.getPostcode()));
		addressService.save(updateAddress);

		updateUser.setFirstName(washeeRegModel.getFirstName());
		updateUser.setLastName(washeeRegModel.getLastName());
		updateUser.setPhone(washeeRegModel.getPhone());
		save(updateUser);

		if (updateUser.getRole().getUrlname().equals("washer")) {
			Washer updatewasher = washerService.findbyuser(updateUser);
			updatewasher.setHasVacuum(washeeRegModel.getWasherHasVacuume());
			updatewasher.setTravelDistance(washeeRegModel.getTravelDistance());
			washerService.save(updatewasher);

			BankAccount updateBAcc = bankaccountService.findbyid(updateUser.getBankAccount().getId());
			updateBAcc.setAccountHolder(washeeRegModel.getAccountHolder());
			updateBAcc.setAccountNumber(washeeRegModel.getAccountNumber());
			updateBAcc.setBsb(washeeRegModel.getBsb());
			updateBAcc.setBankName(washeeRegModel.getBankName());
			bankaccountService.save(updateBAcc);

		}

	}

	public Address setAddressValues(GeocodeResponse geoResponse) {
		Address newAdd = new Address();
		if (geoResponse != null) {

			GeocoderResult result = geoResponse.getResults().get(0);

			for (GeocoderAddressComponent component : result.getAddressComponents()) {
				List<String> types = component.getTypes();
				String componentString = component.getLongName();
				if (types.contains("locality"))
					newAdd.setSuburb(componentString);
				if (types.contains("administrative_area_level_1"))
					newAdd.setState(componentString);
				if (types.contains("country"))
					newAdd.setCountry(componentString);
				if (types.contains("postal_code"))
					newAdd.setPostcode(componentString);
			}

			String formattedAddress = result.getFormattedAddress();
			newAdd.setFormattedAddress(formattedAddress);
			String[] addressArray = formattedAddress.split(",");
			int addressLength = addressArray.length;
			String addressLine = "";
			for (int i = 0; i < addressLength - 2; i++) {
				addressLine += addressArray[i];
			}
			newAdd.setAddressLine1(addressLine);

			GeocoderGeometry geometry = geoResponse.getResults().get(0).getGeometry();
			newAdd.setLatitude(geometry.getLocation().getLat().doubleValue());
			newAdd.setLongitude(geometry.getLocation().getLng().doubleValue());

		}
		return newAdd;
	}

}
