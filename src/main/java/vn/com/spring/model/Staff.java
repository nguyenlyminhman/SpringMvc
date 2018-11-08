package vn.com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Staff" database table.
 * 
 */
@Entity
@Table(name="\"Staff\"")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String address;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String phone;

	private String role;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="staff")
	private List<Contact> contacts;

	//bi-directional many-to-one association to StaffOrder
	@OneToMany(mappedBy="staff")
	private List<StaffOrder> staffOrders;

	public Staff() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setStaff(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setStaff(null);

		return contact;
	}

	public List<StaffOrder> getStaffOrders() {
		return this.staffOrders;
	}

	public void setStaffOrders(List<StaffOrder> staffOrders) {
		this.staffOrders = staffOrders;
	}

	public StaffOrder addStaffOrder(StaffOrder staffOrder) {
		getStaffOrders().add(staffOrder);
		staffOrder.setStaff(this);

		return staffOrder;
	}

	public StaffOrder removeStaffOrder(StaffOrder staffOrder) {
		getStaffOrders().remove(staffOrder);
		staffOrder.setStaff(null);

		return staffOrder;
	}

}