package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discount database table.
 * 
 */
@Entity
@Table(name="discount")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=45)
	private String name;

	private Double value;

	//bi-directional many-to-one association to WashRequest
	@OneToMany(mappedBy="discount")
	private List<WashRequest> washRequests;

	public Discount() {
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

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<WashRequest> getWashRequests() {
		return this.washRequests;
	}

	public void setWashRequests(List<WashRequest> washRequests) {
		this.washRequests = washRequests;
	}

	public WashRequest addWashRequest(WashRequest washRequest) {
		getWashRequests().add(washRequest);
		washRequest.setDiscount(this);

		return washRequest;
	}

	public WashRequest removeWashRequest(WashRequest washRequest) {
		getWashRequests().remove(washRequest);
		washRequest.setDiscount(null);

		return washRequest;
	}

}