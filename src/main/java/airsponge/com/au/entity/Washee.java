package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the washee database table.
 * 
 */
@Entity
@Table(name="washee")
@NamedQuery(name="Washee.findAll", query="SELECT w FROM Washee w")
public class Washee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to WashRequest
	@OneToMany(mappedBy="washee")
	private List<WashRequest> washRequests;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Washee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<WashRequest> getWashRequests() {
		return this.washRequests;
	}

	public void setWashRequests(List<WashRequest> washRequests) {
		this.washRequests = washRequests;
	}

	public WashRequest addWashRequest(WashRequest washRequest) {
		getWashRequests().add(washRequest);
		washRequest.setWashee(this);

		return washRequest;
	}

	public WashRequest removeWashRequest(WashRequest washRequest) {
		getWashRequests().remove(washRequest);
		washRequest.setWashee(null);

		return washRequest;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}