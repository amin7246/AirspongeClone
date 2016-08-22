package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the wash_request database table.
 * 
 */
@Entity
@Table(name="wash_request")
@NamedQuery(name="WashRequest.findAll", query="SELECT w FROM WashRequest w")
public class WashRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String description;

	@Column(name="number_of_cars")
	private Integer numberOfCars;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_date")
	private Date requestDate;

	@Column(name="total_price")
	private Double totalPrice;

	@Column(name="total_price_after_discount")
	private Double totalPriceAfterDiscount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="wash_date")
	private Date washDate;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Discount
	@ManyToOne
	@JoinColumn(name="discount_id")
	private Discount discount;

	//bi-directional many-to-one association to Electricity
	@ManyToOne
	@JoinColumn(name="electricity_id")
	private Electricity electricity;

	//bi-directional many-to-one association to Vacuum
	@ManyToOne
	@JoinColumn(name="vacuum_id")
	private Vacuum vacuum;

	//bi-directional many-to-one association to Washee
	@ManyToOne
	@JoinColumn(name="washee_id", nullable=false)
	private Washee washee;

	//bi-directional many-to-one association to WaterSource
	@ManyToOne
	@JoinColumn(name="water_source_id", nullable=false)
	private WaterSource waterSource;

	//bi-directional many-to-one association to WashRequestItem
	@OneToMany(mappedBy="washRequest")
	private List<WashRequestItem> washRequestItems;

	public WashRequest() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfCars() {
		return this.numberOfCars;
	}

	public void setNumberOfCars(Integer numberOfCars) {
		this.numberOfCars = numberOfCars;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalPriceAfterDiscount() {
		return this.totalPriceAfterDiscount;
	}

	public void setTotalPriceAfterDiscount(Double totalPriceAfterDiscount) {
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}

	public Date getWashDate() {
		return this.washDate;
	}

	public void setWashDate(Date washDate) {
		this.washDate = washDate;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Electricity getElectricity() {
		return this.electricity;
	}

	public void setElectricity(Electricity electricity) {
		this.electricity = electricity;
	}

	public Vacuum getVacuum() {
		return this.vacuum;
	}

	public void setVacuum(Vacuum vacuum) {
		this.vacuum = vacuum;
	}

	public Washee getWashee() {
		return this.washee;
	}

	public void setWashee(Washee washee) {
		this.washee = washee;
	}

	public WaterSource getWaterSource() {
		return this.waterSource;
	}

	public void setWaterSource(WaterSource waterSource) {
		this.waterSource = waterSource;
	}

	public List<WashRequestItem> getWashRequestItems() {
		return this.washRequestItems;
	}

	public void setWashRequestItems(List<WashRequestItem> washRequestItems) {
		this.washRequestItems = washRequestItems;
	}

	public WashRequestItem addWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().add(washRequestItem);
		washRequestItem.setWashRequest(this);

		return washRequestItem;
	}

	public WashRequestItem removeWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().remove(washRequestItem);
		washRequestItem.setWashRequest(null);

		return washRequestItem;
	}

}