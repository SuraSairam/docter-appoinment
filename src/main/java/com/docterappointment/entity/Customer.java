package com.docterappointment.entity;

public class Customer extends Object {
	private int customer_id;
	private String first_name;
	private String last_name;
	private long   contactNumber;
	private String gender;
	private String emailId;
	
	public int getId() {
		return customer_id;	
	}
	public void setId(int id) {
		this.customer_id = id;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	public long getMn() {
		return contactNumber;	
	}
	public void setMn(long number) {
		this.contactNumber = number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String email) {
		this.emailId = email;
	}
//	public Customer(int customer_id,String first_name, String last_name, long contactNumber,String gender,String emailId) {
//		super();
//		this.customer_id = customer_id;
//		this.first_name= first_name;
//		this.last_name = last_name;
//		this.contactNumber = contactNumber;
//		this.gender = gender;
//		this.emailId = emailId;
//	}
//	public Customer(String first_name, String last_name, long contactNumber,String gender,String emailId) {
//		super();
////		this.customer_id = customer_id;
//		this.first_name= first_name;
//		this.last_name = last_name;
//		this.contactNumber = contactNumber;
//		this.gender = gender;
//		this.emailId = emailId;
//	}
	@Override
	public String toString() {
		return "Customers [id=" + customer_id + ", firstName=" + first_name + ", lastName=" + last_name + ", mobile_number=" + contactNumber +", gender=" + gender
				+ ",email_id= " + emailId +",]";
	}

}
