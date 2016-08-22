package airsponge.com.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.DTO.WasherRegModel;
import airsponge.com.au.entity.Address;
import airsponge.com.au.entity.BankAccount;
import airsponge.com.au.entity.CarType;
import airsponge.com.au.entity.DocumentType;
import airsponge.com.au.entity.Electricity;
import airsponge.com.au.entity.Refree;
import airsponge.com.au.entity.Role;
import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Vacuum;
import airsponge.com.au.entity.WashStatus;
import airsponge.com.au.entity.WashType;
import airsponge.com.au.entity.WaterSource;
import airsponge.com.au.service.AddressService;
import airsponge.com.au.service.BankaccountService;
import airsponge.com.au.service.CarTypeService;
import airsponge.com.au.service.DocumentTypeService;
import airsponge.com.au.service.ElectricityService;
import airsponge.com.au.service.RoleService;
import airsponge.com.au.service.UserService;
import airsponge.com.au.service.VacuumService;
import airsponge.com.au.service.WashStatusService;
import airsponge.com.au.service.WashTypeService;
import airsponge.com.au.service.WaterSourceService;

@Controller
public class databasesetupController{

	@Autowired 
	private UserService userService;
	
	@Autowired 
	private AddressService addressService;
	
	@Autowired 
	private CarTypeService carTypeService;
	
	@Autowired 
	private WashTypeService washTypeService;
	
	@Autowired 
	private WashStatusService washStatusService;
	
	@Autowired 
	private WaterSourceService waterSourceService;
	
	@Autowired 
	private ElectricityService electricityService;
	
	@Autowired 
	private VacuumService vacuumService;
	
	@Autowired 
	private DocumentTypeService documentTypeService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired 
	private BankaccountService bankaccountService;
	
	@RequestMapping("/databasesetup")
	public String database()
	{
		if(userService.findAll().isEmpty()){
			AddDBinitValues();
			addMockAdmin();		
			addMockWasher();
			addMockWashee();	
		}
		return "loginpage";
	}
	
private void AddDBinitValues() {
		initRoleData();
		initRefreeData();
		initDocumentTypeData();
		initWaterSourcesData();
		initVaccumData();
		initElectricityData();
		initCarTypeData();
		WashTypeData();
		WashStatusData(); 
	}

private void WashStatusData() {
	
	WashStatus ws1 = new WashStatus();
	ws1.setId(1);
	ws1.setStatus("pending for washer");
	washStatusService.save(ws1);
	
	WashStatus ws2 = new WashStatus();
	ws2.setId(2);
	ws2.setStatus("pending for commitment");
	washStatusService.save(ws2);
	
	WashStatus ws3 = new WashStatus();
	ws3.setId(1);
	ws3.setStatus("pending for wash");
	washStatusService.save(ws3);
	
	WashStatus ws4 = new WashStatus();
	ws4.setId(4);
	ws4.setStatus("pending for full payment");
	washStatusService.save(ws4);
	
	WashStatus ws5 = new WashStatus();
	ws5.setId(5);
	ws5.setStatus("Done");
	washStatusService.save(ws5);
	
	WashStatus ws6 = new WashStatus();
	ws6.setId(5);
	ws6.setStatus("failed");
	washStatusService.save(ws6);
	
}


private void WashTypeData() {
	
	WashType wt1 = new WashType();
	wt1.setId(1);
	wt1.setWash_type("interier vacuum");
	washTypeService.save(wt1);
	
	WashType wt2 = new WashType();
	wt2.setId(2);
	wt2.setWash_type("Interier wiping");
	washTypeService.save(wt2);
	
	WashType wt3 = new WashType();
	wt3.setId(3);
	wt3.setWash_type("van and wipe");
	washTypeService.save(wt3);
	
}



private void initCarTypeData() {
	
			CarType ct1 = new CarType();
			ct1.setId(1);
			ct1.setCarType("Sedan/hatchback");	
			carTypeService.save(ct1);
			
			CarType ct2 = new CarType();
			ct2.setId(2);
			ct2.setCarType("Wagon");	
			carTypeService.save(ct2);
			
			CarType ct3 = new CarType();
			ct3.setId(3);
			ct3.setCarType("SUV/Van");	
			carTypeService.save(ct3);
}


private void initVaccumData() {
	
			Vacuum v1 = new Vacuum();
			v1.setId(2);
			v1.setName("cordless");	
			vacuumService.save(v1);
			
			Vacuum v2 = new Vacuum();
			v2.setId(3);
			v2.setName("wired");	
			vacuumService.save(v2);
			
			
			Vacuum v3 = new Vacuum();
			v3.setId(1);
			v3.setName("no");	
			vacuumService.save(v3);
			
			Vacuum v4 = new Vacuum();
			v4.setId(4);
			v4.setName("Need to bring extension");	
			vacuumService.save(v4);
}

private void initElectricityData() {
	
	
			Electricity e1 = new Electricity();
			e1.setId(1);
			e1.setName("provided");	
			electricityService.save(e1);
			
			Electricity e2 = new Electricity();
			e2.setId(2);
			e2.setName("not provided");	
			electricityService.save(e2);
			
			Electricity e3 = new Electricity();
			e3.setId(3);
			e3.setName("need extention");	
			electricityService.save(e3);
}


private void initWaterSourcesData() {
	
			WaterSource ws1 = new WaterSource();
			ws1.setId(1);
			ws1.setName("Hose");	
			waterSourceService.save(ws1);
			
			WaterSource ws2 = new WaterSource();
			ws2.setId(2);
			ws2.setName("Tap");	
			waterSourceService.save(ws2);
			
			WaterSource ws3 = new WaterSource();
			ws3.setId(3);
			ws3.setName("None");	
			waterSourceService.save(ws3);
}

private void initDocumentTypeData() {

			DocumentType doc1 = new DocumentType();
			doc1.setId(1);
			doc1.setDocType("ProfilePic");	
			documentTypeService.save(doc1);
			
			DocumentType doc2 = new DocumentType();
			doc2.setId(2);
			doc2.setDocType("identification");	
			documentTypeService.save(doc2);
}

private void initRoleData() {
	
			Role adminrole = new Role();
			adminrole.setId(1);
			adminrole.setName("ROLE_ADMIN");
			adminrole.setUrlname("admin");
			roleService.save(adminrole);
		
			Role washerrole = new Role();
			washerrole.setId(2);
			washerrole.setName("ROLE_WASHER");
			washerrole.setUrlname("washer");
			roleService.save(washerrole);
			
			Role washeerole = new Role();
			washeerole.setId(3);
			washeerole.setName("ROLE_WASHEE");
			washeerole.setUrlname("washee");
			roleService.save(washeerole);
}

private void initRefreeData() {
	
	
			Refree refree1 = new Refree();
			refree1.setId(1);
			refree1.setName("Search engine");
			
			Refree refree2 = new Refree();
			refree2.setId(2);
			refree2.setName("Advertisment");
			
			Refree refree3 = new Refree();
			refree3.setId(3);
			refree3.setName("News article");
			
			Refree refree4 = new Refree();
			refree4.setId(4);
			refree4.setName("Social media");
			
			Refree refree5 = new Refree();
			refree5.setId(5);
			refree5.setName("Word of mouth");
}



//CREATE ADMIN
//	@org.springframework.context.annotation.Role(1)
	private void addMockAdmin() 
	{
		User newUser1 = new User();
		Address newAdd1 = new Address(); 
		BankAccount newbankacc1 = new BankAccount();
	
		newAdd1.setAddressLine1("adminAdd1");
		newAdd1.setCity("adminCity");
		newAdd1.setPostcode("adminPostcode");
		addressService.save(newAdd1);

		newbankacc1.setAccountHolder("adminBankHolder");
		newbankacc1.setAccountNumber("adminBankNumber");
		newbankacc1.setBsb("adminBankBsb");
		newbankacc1.setBankName("adminBankName");
		bankaccountService.save(newbankacc1);

		newUser1.setAddress(newAdd1);
		newUser1.setBankAccount(newbankacc1);
		newUser1.setFirstName("adminFirstName");
		newUser1.setLastName("adminLastName");
		newUser1.setEmail("admin");
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser1.setPassword(encoder.encode("admin"));
		newUser1.setPhone("adminPhone");
		newUser1.setRole(roleService.findbyname("ROLE_ADMIN"));
		userService.save(newUser1);
	}
	
	private void addMockWasher() 
	{
		WasherRegModel newModel = new WasherRegModel();
		
		newModel.setFirstName("washerFirstName");
		newModel.setLastName("washerLastName");
		newModel.setEmail("washer");			
		newModel.setPassword("washer");
		newModel.setPhone("washerPhone");
		newModel.setAddressLine1("washerAdd1");
		newModel.setCity("washerCity");
		newModel.setSuburb("washerSuburb");
		newModel.setPostcode("washerPostcode");
		newModel.setState("washerState");
		newModel.setCountry("washerCountry");
		newModel.setAccountHolder("washerBankHolder");
		newModel.setAccountNumber("washerBankNumber");
		newModel.setBsb("washerBankBsb");
		newModel.setBankName("washerBankName");
		
		newModel.setTravelDistance(20);
		newModel.setWasherHasVacuume(false);
		
		userService.RegisterWasher(newModel);

	}
	
	private void addMockWashee() 
	{
		WasheeRegModel newModel = new WasheeRegModel();
		newModel.setFirstName("washeeFirstName");
		newModel.setLastName("washeeLastName");
		newModel.setEmail("washee");
		newModel.setPassword("washee");
		newModel.setPhone("washeePhone");
		newModel.setAddressLine1("washeeAdd1");
		newModel.setCity("washeeCity");
		newModel.setSuburb("washeeSuburb");
		newModel.setPostcode("washeePostcode");
		newModel.setState("washeeState");
		newModel.setCountry("washeeCountry");
		newModel.setAccountHolder("washeeBankHolder");
		newModel.setAccountNumber("washeeBankNumber");
		newModel.setBsb("washeeBankBsb");
		newModel.setBankName("washeeBankName");
		newModel.setCarType(1);
		newModel.setWashType(1);
		newModel.setWaterSource(2);
		newModel.setElectricity(2);
		newModel.setVacuum(1);
		
		newModel.setDescription("washerDescription");
		
		userService.RegisterWashee(newModel);
	}
	
}
