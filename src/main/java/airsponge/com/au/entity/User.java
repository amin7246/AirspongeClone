package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_registered")
	private Date dateRegistered;

	@Column(length=255)
	private String email;

	@Column(length=255)
	private String firstName;

	@Column(length=255)
	private String lastName;

	@Column(length=255)
	private String password;

	@Column(length=255)
	private String phone;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="user")
	private List<Document> documents;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="Address_id", nullable=false)
	private Address address;

	//bi-directional many-to-one association to BankAccount
	@ManyToOne
	@JoinColumn(name="bank_account_id", nullable=false)
	private BankAccount bankAccount;

	//bi-directional many-to-one association to Refree
	@ManyToOne
	@JoinColumn(name="refree_id")
	private Refree refree;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private Role role;

	//bi-directional many-to-one association to Washee
	@OneToMany(mappedBy="user")
	private List<Washee> washees;

	//bi-directional many-to-one association to Washer
	@OneToMany(mappedBy="user")
	private List<Washer> washers;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setUser(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setUser(null);

		return document;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Refree getRefree() {
		return this.refree;
	}

	public void setRefree(Refree refree) {
		this.refree = refree;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Washee> getWashees() {
		return this.washees;
	}

	public void setWashees(List<Washee> washees) {
		this.washees = washees;
	}

	public Washee addWashee(Washee washee) {
		getWashees().add(washee);
		washee.setUser(this);

		return washee;
	}

	public Washee removeWashee(Washee washee) {
		getWashees().remove(washee);
		washee.setUser(null);

		return washee;
	}

	public List<Washer> getWashers() {
		return this.washers;
	}

	public void setWashers(List<Washer> washers) {
		this.washers = washers;
	}

	public Washer addWasher(Washer washer) {
		getWashers().add(washer);
		washer.setUser(this);

		return washer;
	}

	public Washer removeWasher(Washer washer) {
		getWashers().remove(washer);
		washer.setUser(null);

		return washer;
	}

}