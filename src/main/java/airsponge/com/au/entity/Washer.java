package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the washer database table.
 * 
 */
@Entity
@Table(name="washer")
@NamedQuery(name="Washer.findAll", query="SELECT w FROM Washer w")
public class Washer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="has_vacuum")
	private Boolean hasVacuum;

	@Column(name="travel_distance")
	private Integer travelDistance;

	//bi-directional many-to-one association to WashRequestItem
	@OneToMany(mappedBy="washer")
	private List<WashRequestItem> washRequestItems;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Washer() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getHasVacuum() {
		return this.hasVacuum;
	}

	public void setHasVacuum(Boolean hasVacuum) {
		this.hasVacuum = hasVacuum;
	}

	public Integer getTravelDistance() {
		return this.travelDistance;
	}

	public void setTravelDistance(Integer travelDistance) {
		this.travelDistance = travelDistance;
	}

	public List<WashRequestItem> getWashRequestItems() {
		return this.washRequestItems;
	}

	public void setWashRequestItems(List<WashRequestItem> washRequestItems) {
		this.washRequestItems = washRequestItems;
	}

	public WashRequestItem addWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().add(washRequestItem);
		washRequestItem.setWasher(this);

		return washRequestItem;
	}

	public WashRequestItem removeWashRequestItem(WashRequestItem washRequestItem) {
		getWashRequestItems().remove(washRequestItem);
		washRequestItem.setWasher(null);

		return washRequestItem;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}