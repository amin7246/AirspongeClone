package airsponge.com.au.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the refree database table.
 * 
 */
@Entity
@Table(name="refree")
@NamedQuery(name="Refree.findAll", query="SELECT r FROM Refree r")
public class Refree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="refree")
	private List<User> users;

	public Refree() {
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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRefree(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRefree(null);

		return user;
	}

}