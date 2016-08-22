package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.entity.Address;
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
import airsponge.com.au.repository.WashRequestItemRepository;
import airsponge.com.au.repository.WashRequestRepository;

@Service
@Transactional
public class WashRequestService {

	@Autowired
	private WashRequestRepository washRequestRepository;

	@Autowired
	private WashRequestItemRepository washRequestItemRepository;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@Autowired
	private WasheeService washeeService;

	@Autowired
	private WashRequestItemService washRequestItemService;

	@Autowired
	private WashStatusService washStatusService;

	@Autowired
	private WashTypeService washTypeService;

	@Autowired
	private CarTypeService carTypeService;

	@Autowired
	private VacuumService vacuumService;

	@Autowired
	private ElectricityService electricityService;

	@Autowired
	private WaterSourceService waterSourceService;

	public List<WashRequest> findAll() {
		return washRequestRepository.findAll();
	}

	public WashRequest findbyid(int id) {
		return washRequestRepository.findOne(id);
	}

	public void save(WashRequest washRequest) {
		washRequestRepository.save(washRequest);

	}

	public void save(WasheeRegModel washeeRegModel, String username) {

		User user = userService.findbyemail(username);
		Washee washee = washeeService.findbyuser(user);
		// saving wash Request location for the wash
		Address carloc = new Address();
		carloc = userService.setAddressValues(addressService.getGeoResponse(washeeRegModel.getAddressLine1(),
				washeeRegModel.getSuburb(), washeeRegModel.getPostcode()));
		addressService.save(carloc);

		// water Source
		WaterSource ws = waterSourceService.findbyid(washeeRegModel.getWaterSource());

		// Electricity
		Electricity elec = electricityService.findbyid(washeeRegModel.getElectricity());

		// vacuum
		Vacuum vac = vacuumService.findbyid(washeeRegModel.getVacuum());

		// saving wash request
		WashRequest washReq = new WashRequest();
		washReq.setWashee(washee);
		washReq.setAddress(carloc);
		washReq.setWaterSource(ws);
		washReq.setVacuum(vac);
		washReq.setElectricity(elec);

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		washReq.setRequestDate(date);
		save(washReq);

		// saving wash Item ==> currently only one

		// Car Type
		CarType cartype = carTypeService.findbyid(washeeRegModel.getCarType());

		// Wash Type
		WashType washtype = washTypeService.findbyid(washeeRegModel.getWashType());

		WashRequestItem washReqItem = new WashRequestItem();
		washReqItem.setWashRequest(washReq);
		washReqItem.setCarType(cartype);
		washReqItem.setWashType(washtype);
		washReqItem.setWashStatus(washStatusService.findbyid(1));
		washRequestItemService.save(washReqItem);
	}

	public List<WashRequest> findbywashee(Washee washee) {
		return washRequestRepository.findByWashee(washee);
	}

	public void cancel(int washrquestID, int washrequestItemID) {
		washRequestItemRepository.delete(washrequestItemID);
		washRequestRepository.delete(washrquestID);
	}
}
