package airsponge.com.au.DTO;
import java.util.Date;

import airsponge.com.au.entity.WashRequestItem;

public class WasheeRegModel {

	
	private String  email;
	private String  firstName;
	private String  lastName;
	private String  phone;
	private String  password;
	private Integer vacuum;
	private Integer waterSource;
	private Integer electricity; 
	private Integer carType;
	private Integer washType;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private String postcode;
	private String state;
	private String suburb;

	private String accountHolder;
	private String accountNumber;
	private String bankName;
	private String bsb;
	
	
	private Double totalPrice;
	private Double totalPriceAfterDiscont;
	private String description;
	private String cardescription;
	private Date requestDate;
	private Date washDate;
	
	private Integer travelDistance;
	private Boolean washerHasVacuume;
	
	
	public Integer getTravelDistance() {
		return travelDistance;
	}
	public void setTravelDistance(Integer travelDistance) {
		this.travelDistance = travelDistance;
	}
	public Boolean getWasherHasVacuume() {
		return washerHasVacuume;
	}
	public void setWasherHasVacuume(Boolean washerHasVacuume) {
		this.washerHasVacuume = washerHasVacuume;
	}
	public String getCardescription() {
		return cardescription;
	}
	public void setCardescription(String cardescription) {
		this.cardescription = cardescription;
	}
	public Integer getVacuum() {
		return vacuum;
	}
	public void setVacuum(Integer vacuum) {
		this.vacuum = vacuum;
	}

	public Integer getWaterSource() {
		return waterSource;
	}
	public void setWaterSource(Integer waterSource) {
		this.waterSource = waterSource;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
	public Integer getCarType() {
		return carType;
	}
	public void setCarType(Integer carType) {
		this.carType = carType;
	}
	public Integer getWashType() {
		return washType;
	}
	public void setWashType(Integer washType) {
		this.washType = washType;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTotalPriceAfterDiscont() {
		return totalPriceAfterDiscont;
	}
	public void setTotalPriceAfterDiscont(Double totalPriceAfterDiscont) {
		this.totalPriceAfterDiscont = totalPriceAfterDiscont;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getWashDate() {
		return washDate;
	}
	public void setWashDate(Date washDate) {
		this.washDate = washDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBsb() {
		return bsb;
	}
	public void setBsb(String bsb) {
		this.bsb = bsb;
	}
	
	
	
	
	
}
