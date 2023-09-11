package com.docterappointment.entity;

public class Appointment {
	private int appointmentId;
	private int customerId;
	private int DocterId;  
	private String D_name;
	private String address;
	private String AppointmentDate;
//	public Appointment(int appointmentId, int customerId, int DocterId,String D_name,long D_contactNumber,String address,String AppointmentDate) {
//		super();
//		this.appointmentId = appointmentId;
//		this.customerId = customerId;
//		this.DocterId= DocterId;
//		this.D_name = D_name;
//		this.D_contactNumber = D_contactNumber;
//		this.address = address;
//		this.AppointmentDate = AppointmentDate;
//	}
//	public Appointment( int customerId, int DocterId,String D_name,long D_contactNumber,String address, String AppointmentDate) {
//		super();
//		//this.appointmentId = appointmentId;
//		this.customerId = customerId;
//		this.DocterId = DocterId;
//		this.D_name = D_name;
//		this.D_contactNumber = D_contactNumber;
//		this.address = address;
//		this.AppointmentDate = AppointmentDate;
//	}

	
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String AppointmentDate) {
		this.AppointmentDate = AppointmentDate;
	}
	public int getDoctorId() {
		return DocterId;
	}
	public void setDoctorId(int DocterId) {
		this.DocterId = DocterId;
	}
	public String getName() {
		return D_name;
	}
	public void setName(String D_name) {
		this.D_name = D_name;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
		public String getAddress() {
			return address;
	}
		public void setAddress(String address) {
			this.address = address;
	}
	
	@Override
	public String toString() {
		return "Appointment [ AppointmentId=" + appointmentId + ", CustomerId=" + customerId + "  DoctorId=" + DocterId + ",DoctorName=" +D_name+", Address="+ address +",AppointmentDate="
				+ AppointmentDate + "]";
	}
	

}
