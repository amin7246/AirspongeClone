package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="address_line1", length=255)
	private String addressLine1;

	@Column(length=255)
	private String city;

	@Column(length=255)
	private String country;

	@Column(name="formatted_address", length=255)
	private String formattedAddress;

	private Double latitude;

	private Double longitude;

	@Column(length=255)
	private String postcode;

	@Column(length=255)
	private String state;

	@Column(length=255)
	private String suburb;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;

	//bi-directional many-to-one association to WashRequest
	@OneToMany(mappedBy="address")
	private List<WashRequest> washRequests;

	public Address() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFormattedAddress() {
		return this.formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSuburb() {
		return this.suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

	public List<WashRequest> getWashRequests() {
		return this.washRequests;
	}

	public void setWashRequests(List<WashRequest> washRequests) {
		this.washRequests = washRequests;
	}

	public WashRequest addWashRequest(WashRequest washRequest) {
		getWashRequests().add(washRequest);
		washRequest.setAddress(this);

		return washRequest;
	}

	public WashRequest removeWashRequest(WashRequest washRequest) {
		getWashRequests().remove(washRequest);
		washRequest.setAddress(null);

		return washRequest;
	}

}