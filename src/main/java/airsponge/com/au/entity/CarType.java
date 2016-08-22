package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the car_type database table.
 * 
 */
@Entity
@Table(name="car_type")
@NamedQuery(name="CarType.findAll", query="SELECT c FROM CarType c")
public class CarType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="car_type", length=255)
	private String carType;

	//bi-directional many-to-one association to WashRequestItem
	@OneToMany(mappedBy="carType")
	private List<WashRequestItem> washRequestItems;

	public CarType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public List<WashRequestItem> getWashRequestItems() {
		return this.washRequestItems;
	}

	public void setWashRequestItems(List<WashRequestItem> washRequestItems) {
		this.washRequestItems = washRequestItems;
	}

	public WashRequestItem addWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().add(washRequestItem);
		washRequestItem.setCarType(this);

		return washRequestItem;
	}

	public WashRequestItem removeWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().remove(washRequestItem);
		washRequestItem.setCarType(null);

		return washRequestItem;
	}

}