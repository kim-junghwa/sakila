package sakila.business.model;

import java.sql.Blob;

import sakila.address.model.Address;

public class Staff {
	private int staffId;
	private String firstName;
	private String lastName;
	private Address address;
	private Blob picture;
	private String email;
	private Store store;
	private int active;
	private String username;
	private String password;
	private String lastUpadate;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastUpadate() {
		return lastUpadate;
	}
	public void setLastUpadate(String lastUpadate) {
		this.lastUpadate = lastUpadate;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", picture=" + picture + ", email=" + email + ", store=" + store + ", active=" + active
				+ ", username=" + username + ", password=" + password + ", lastUpadate=" + lastUpadate + "]";
	}
	
}
