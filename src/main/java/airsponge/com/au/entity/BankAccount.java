package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bank_account database table.
 * 
 */
@Entity
@Table(name="bank_account")
@NamedQuery(name="BankAccount.findAll", query="SELECT b FROM BankAccount b")
public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="account_holder", length=255)
	private String accountHolder;

	@Column(name="account_number", length=255)
	private String accountNumber;

	@Column(name="bank_name", length=255)
	private String bankName;

	@Column(length=255)
	private String bsb;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="bankAccount")
	private List<User> users;

	public BankAccount() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountHolder() {
		return this.accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBsb() {
		return this.bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setBankAccount(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setBankAccount(null);

		return user;
	}

}