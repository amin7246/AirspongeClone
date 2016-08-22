package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wash_type database table.
 * 
 */
@Entity
@Table(name="wash_type")
@NamedQuery(name="WashType.findAll", query="SELECT w FROM WashType w")
public class WashType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=225)
	private String wash_type;

	//bi-directional many-to-one association to WashRequestItem
	@OneToMany(mappedBy="washType")
	private List<WashRequestItem> washRequestItems;

	public WashType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWash_type() {
		return this.wash_type;
	}

	public void setWash_type(String wash_type) {
		this.wash_type = wash_type;
	}

	public List<WashRequestItem> getWashRequestItems() {
		return this.washRequestItems;
	}

	public void setWashRequestItems(List<WashRequestItem> washRequestItems) {
		this.washRequestItems = washRequestItems;
	}

	public WashRequestItem addWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().add(washRequestItem);
		washRequestItem.setWashType(this);

		return washRequestItem;
	}

	public WashRequestItem removeWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().remove(washRequestItem);
		washRequestItem.setWashType(null);

		return washRequestItem;
	}

}