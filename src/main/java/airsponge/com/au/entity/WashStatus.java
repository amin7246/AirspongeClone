package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wash_status database table.
 * 
 */
@Entity
@Table(name="wash_status")
@NamedQuery(name="WashStatus.findAll", query="SELECT w FROM WashStatus w")
public class WashStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=250)
	private String status;

	//bi-directional many-to-one association to WashRequestItem
	@OneToMany(mappedBy="washStatus")
	private List<WashRequestItem> washRequestItems;

	public WashStatus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<WashRequestItem> getWashRequestItems() {
		return this.washRequestItems;
	}

	public void setWashRequestItems(List<WashRequestItem> washRequestItems) {
		this.washRequestItems = washRequestItems;
	}

	public WashRequestItem addWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().add(washRequestItem);
		washRequestItem.setWashStatus(this);

		return washRequestItem;
	}

	public WashRequestItem removeWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().remove(washRequestItem);
		washRequestItem.setWashStatus(null);

		return washRequestItem;
	}

}