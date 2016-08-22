package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vacuum database table.
 * 
 */
@Entity
@Table(name="vacuum")
@NamedQuery(name="Vacuum.findAll", query="SELECT v FROM Vacuum v")
public class Vacuum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String name;

	//bi-directional many-to-one association to WashRequest
	@OneToMany(mappedBy="vacuum")
	private List<WashRequest> washRequests;

	public Vacuum() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WashRequest> getWashRequests() {
		return this.washRequests;
	}

	public void setWashRequests(List<WashRequest> washRequests) {
		this.washRequests = washRequests;
	}

	public WashRequest addWashRequest(WashRequest washRequest) {
		getWashRequests().add(washRequest);
		washRequest.setVacuum(this);

		return washRequest;
	}

	public WashRequest removeWashRequest(WashRequest washRequest) {
		getWashRequests().remove(washRequest);
		washRequest.setVacuum(null);

		return washRequest;
	}

}