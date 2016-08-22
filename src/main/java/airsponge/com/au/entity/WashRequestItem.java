package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wash_request_item database table.
 * 
 */
@Entity
@Table(name="wash_request_item")
@NamedQuery(name="WashRequestItem.findAll", query="SELECT w FROM WashRequestItem w")
public class WashRequestItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="car_description", length=255)
	private String carDescription;

	private Double price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_date")
	private Date requestDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="wash_date")
	private Date washDate;

	//bi-directional many-to-one association to CarType
	@ManyToOne
	@JoinColumn(name="car_type_id", nullable=false)
	private CarType carType;

	//bi-directional many-to-one association to WashRequest
	@ManyToOne
	@JoinColumn(name="washRequest_id", nullable=false)
	private WashRequest washRequest;

	//bi-directional many-to-one association to WashStatus
	@ManyToOne
	@JoinColumn(name="wash_status_id", nullable=false)
	private WashStatus washStatus;

	//bi-directional many-to-one association to WashType
	@ManyToOne
	@JoinColumn(name="wash_type_id", nullable=false)
	private WashType washType;

	//bi-directional many-to-one association to Washer
	@ManyToOne
	@JoinColumn(name="washer_id")
	private Washer washer;

	public WashRequestItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarDescription() {
		return this.carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getWashDate() {
		return this.washDate;
	}

	public void setWashDate(Date washDate) {
		this.washDate = washDate;
	}

	public CarType getCarType() {
		return this.carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public WashRequest getWashRequest() {
		return this.washRequest;
	}

	public void setWashRequest(WashRequest washRequest) {
		this.washRequest = washRequest;
	}

	public WashStatus getWashStatus() {
		return this.washStatus;
	}

	public void setWashStatus(WashStatus washStatus) {
		this.washStatus = washStatus;
	}

	public WashType getWashType() {
		return this.washType;
	}

	public void setWashType(WashType washType) {
		this.washType = washType;
	}

	public Washer getWasher() {
		return this.washer;
	}

	public void setWasher(Washer washer) {
		this.washer = washer;
	}

}