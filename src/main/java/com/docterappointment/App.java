package com.docterappointment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.docterappointment.dao.CustomerDao;
import com.docterappointment.dao.AppointmentDao;
import com.docterappointment.dao.impl.CustomerDaoImpl;
import com.docterappointment.dao.impl.AppointmentDaoImpl;
import com.docterappointment.entity.Customer;
import com.docterappointment.entity.Appointment;
import com.docterappointment.exception.CustomerNotFoundException;
import com.docterappointment.exception.AppointmentNotFoundException;
import com.docterappointment.exception.SystemException;



public class App 
{
	private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        try {
        	while(true) {
        		System.out.println("\n *********WELCOME TO MAIN MENU********");
        		System.out.println("\n 1. Customer.");
				System.out.println("\n 2. Doctor.");
				System.out.println("\n 0. Exit");
				System.out.println("\n Enter your choice");
				
				int ch = Integer.parseInt(scanner.nextLine());
				switch (ch) {
				case 1:
					System.out.println("\n************Welcome To customer services************");
                    customerService();
                    System.out.println("\n************customer service Ended************");
                    
					break;
				case 2:
					System.out.println("\n************Welcome To Doctor services************");
                  DoctorService();
                    System.out.println("\n************Doctor services Ended************\n");
//				
					break;
				case 0:
					 System.exit(0);
					break;
				default:
					System.out.println("Try again");
					break;
				}

        	}
        
        }catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
    }
//                         CUSTOMER SERVICE
    private static void customerService() throws CustomerNotFoundException,SQLException {
		try {
			boolean flag = true;
			while(flag) {
				System.out.println("n *********WELCOME TO CUSTOMER SERVICE********");
				System.out.println("\n 1. Customer registration.");
				System.out.println("\n 2. Modify Customer Details.");
				System.out.println("\n 3. Delete Customer record");
				System.out.println("\n 4. View Single Record");
				System.out.println("\n 5. View all Records");
				System.out.println("\n 0. Exit");

				System.out.println("\n Enter your choice");
				
				int mp = Integer.parseInt(scanner.nextLine());
				
				switch(mp) {
				
				case 1:
					System.out.println("\n************Register customer service Started************");
					registerCustomer();
					System.out.println("\n************register customer service Ended************");
					break;
				case 2:
					System.out.println("\n************Modify customer service Started************");
					modifyCustomerDetails();
					System.out.println("\n************Modify customer service Ended************");
					break;
					
				case 3:
					System.out.println("\n************Delete customer service Started************");
					customerDelete();
					System.out.println("\n************Delete customer service Ended************");
					break;
					
				case 4:
					System.out.println("\n************ single record of customer service Started************");
					customerSingleRecord();
					System.out.println("\n************customer service Ended************");
					break;
				case 5:
					System.out.println("\n************All Customers Printing Started************");
					customerAllRecord();
					System.out.println("\n************customer service Ended************");
					break;
				case 0:
					flag = false;
				
				}
				
				
			}
			
		}catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
		
	}
    public static Customer createCustomer() throws SystemException{
    	Customer obj = new Customer();
    	try {
			System.out.println("Enter The First Name: ");
			String first_name = scanner.nextLine();
			obj.setFirstName(first_name);
			first_name = obj.getFirstName();
			System.out.println("Enter The Last Name: ");
			String last_name = scanner.nextLine();
			obj.setLastName(last_name);
			last_name = obj.getLastName();
			System.out.println("Enter The contactnumber: ");
		    Long contactNumber  = Long.parseLong(scanner.nextLine());
			obj.setMn(contactNumber);
			contactNumber = obj.getMn();
			System.out.println("Enter The gender: ");
			String gender = scanner.nextLine();
			obj.setGender(gender);
			gender = obj.getGender();
			System.out.println("Enter The email id: ");
			String emailId = scanner.nextLine();
			obj.setEmail(emailId);
			emailId = obj.getEmail();
			
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}

		return obj;
	}
    private static CustomerDao dao = new CustomerDaoImpl();
    private static void registerCustomer() {
		Customer createCustomer;
		try {
			createCustomer = createCustomer();
			dao.insert(createCustomer);
		} catch (SQLException e) {
			System.out.println(e);
		}catch (SystemException e) {
			System.out.println(e);
		}

	}

    public static void modifyCustomerDetails() {
    	System.out.println("\n Enter customer id to modify: ");
    	Customer obj = new Customer();
    	int customer_id = Integer.parseInt(scanner.nextLine());
    	obj.setId(customer_id);
    	System.out.println("\n Enter FirstName of Customer to update ");
    	String first_name = scanner.nextLine();
    	obj.setFirstName(first_name);
    	first_name = obj.getFirstName();
    	System.out.println("\n Enter LastName of Customer to update ");
    	String last_name = scanner.nextLine();
    	obj.setLastName(last_name);
    	last_name = obj.getLastName();
    	System.out.println("\n Enter Contact Number  of Customer to update ");
    	Long contactNumber= Long.parseLong(scanner.nextLine());
    	obj.setMn(contactNumber);
    	contactNumber = obj.getMn();
    	System.out.println("\n Enter gender of Customer to update ");
    	String gender= scanner.nextLine();
    	obj.setGender(gender);
    	gender = obj.getGender();
    	System.out.println("\n Enter email of Customer to update ");
    	String email = scanner.nextLine();
    	obj.setEmail(email);
    	email = obj.getEmail();
    	try {
    		if(dao.modify(obj)) {
    			System.out.println("\n Data has been Updated ");
    		}else {
    			System.out.println("\n Data has not been Updated");
    			}
    	}catch(SQLException | CustomerNotFoundException e){
    		System.err.println(e);
    		
    	}
    	return ;
    	
    }
    public static void customerDelete() {
    	System.out.println("\n ** Enter Customer Id To Delete **");
    	int customer_Id= Integer.parseInt(scanner.nextLine());
    	
    	try {
    		if(dao.delete(customer_Id)) {
    			System.out.println("\n Data has been deleted ");
    		}else {
    			System.out.println("\n No Data has been Found With Id :- "+customer_Id+"");
    		}
    	} catch(SQLException | CustomerNotFoundException e) {
    		System.err.println(e);
    	}
    	return ;
    }
    public static void customerSingleRecord() {
    	System.out.println("\n** Enter Customer Id **");
    	int id = Integer.parseInt(scanner.nextLine());
    	try {
    		Customer obj = dao.singleRecord(id);
    		System.out.println(obj);
    		
    	}catch(SQLException  | CustomerNotFoundException e) {
    		System.err.println(e);
    	}
    	
    	
    }
    public static void customerAllRecord() {
    	System.out.println("\n **Showing All Records** ");
    	try {
    		List<Customer> customerList = dao.allRecord();
    		for (Customer customers: customerList ) {
    			if(customers != null) {
    			System.out.println(customers+"\n");
    			}
    		}
    		
    	}catch(SQLException e) {
    		System.err.println(e);
    	}
    	return ;
    }
//  ADVOCATE SERVICE
    public static void DoctorService() throws CustomerNotFoundException,AppointmentNotFoundException,SQLException{
    	try {
    		boolean flag = true;
    		while(flag) {
    			System.out.println("n *********WELCOME TO DOCTOR SERVICE********");
    			System.out.println("\n 1. Book an Appointment.");
		        System.out.println("\n 2. Modify Appointment Details.");
		        System.out.println("\n 3. Delete Appointment record");
		        System.out.println("\n 4. View Single Record");
		        System.out.println("\n 5. View all Records");
		        System.out.println("\n 0. Exit");

		        System.out.println("\n Enter your choice");
    		
    		int ch = Integer.parseInt(scanner.nextLine());
    		switch(ch) {
    		case 1:
    			System.out.println("\n ************ Book Appointment Service************ ");
    			bookAppointment();
    			System.out.println("\n ************ Book Appointment Service Ended************ ");
    			break;
    		case 2:
    			System.out.println("\n ************Modify Appointment Service************ ");
    			modifyAppointment();
    			System.out.println("\n ************Modify Appointment Service Ended************");
    			break;
    		case 3:
    			System.out.println("\n ************Delete Appointment Service************ ");
    			deleteAppointment();
    			System.out.println("\n ************Delete Appointment Service Ended************ ");
    			break;
    		case 4:
    			System.out.println("\n ************View Single Record Service************ ");
    			singleAppointment();
    			System.out.println("\n ************View Single Records Service Ended ");
    			break;
    		case 5:
    			System.out.println("\n ************View All Record Service************ ");
    		
    			allAppointment();
    			System.out.println("\n *************View All Records Service Ended ************");
    			break;
    		case 0:
    			flag = false ;
    			}
    		}
    	}
    		catch(NumberFormatException e) {
    			System.out.println(e);
    		}catch(Exception e) {
    			System.out.println(e);
    		}
    		
    	
    }
    private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
   
    public static void bookAppointment() throws SQLException,AppointmentNotFoundException, CustomerNotFoundException{
    	Appointment obj = new Appointment();
    	System.out.println("\n Enter Customer Id To Book Appointment");
    	int customer_Id=Integer.parseInt(scanner.nextLine());
//    	Customer customer_Obj = dao.singleRecord(customer_Id);
    	obj.setCustomerId(customer_Id);
    	System.out.println("\n Enter Doctor Id To Book Appointment");
    	int Doctor_Id=Integer.parseInt(scanner.nextLine());
    	obj.setDoctorId(Doctor_Id);
    	System.out.println("\n Enter doctor name To Book Aoppointment");
    	String D_Name = scanner.nextLine();
    	obj.setName(D_Name);
    	System.out.println("\n Enter address To Book Appointment ");
    	String address = scanner.nextLine();
    	obj.setAddress(address);
    	System.out.println("\n Enter date To Book Appointment");
    	String appointment_Date= scanner.nextLine();
    	obj.setAppointmentDate(appointment_Date);
    	System.out.println("appointment details are:CustomerId= "+customer_Id+" DoctorId= " + Doctor_Id + ",DoctorName= "+ D_Name + ",address= ,"+address+",appointDate= "+appointment_Date);
    	
    	try {
    		if(appointmentDao.bookAppointment(obj)) {
    			System.out.println("\n Data Has Been Inserted \n");
    		}
    	}catch(SQLException |AppointmentNotFoundException  e) {
    		System.err.println(e);
    	}
    	
    	return ;
    }
    
    public static void modifyAppointment() throws SQLException ,AppointmentNotFoundException{
    	Appointment obj = new Appointment();
    	System.out.println("\n Enter Appointment Id To Modify Details ");
    	int appointment_Id= Integer.parseInt(scanner.nextLine());
    	obj.setAppointmentId(appointment_Id);
        System.out.println("\n Enter new Docter Id To Modify ");
    	int Doctor_Id= Integer.parseInt(scanner.nextLine());
    	obj.setDoctorId(Doctor_Id);
    	System.out.println("\n Enter New Doctor name To Modify");
    	String Name = scanner.nextLine();
    	obj.setName(Name);
    	System.out.println("\n Enter New address To Modify");
    	String address = scanner.nextLine();
    	obj.setAddress(address);
    	System.out.println("\n Enter New Appointment Date To Modify");
    	String appointment_Date= scanner.nextLine();
    	obj.setAppointmentDate(appointment_Date);
    	try {
    		if(appointmentDao.modify(obj)) {
    			System.out.println("\n Updation Has Been Done \n");
    			return ;
    		}
    	}catch(SQLException |AppointmentNotFoundException e) {
    		System.err.println(e);
    	}
    	System.out.println("\n Updation Has Not Been Performed \n");
    	return ;
    	
    	
    	
    }
    public static void singleAppointment() throws SQLException,AppointmentNotFoundException{
    	System.out.println("Enter The Appointment Id \n");
    	int appointmentId= Integer.parseInt(scanner.nextLine());
    		
			try {
				Appointment obj = appointmentDao.singleRecord(appointmentId);
				System.out.println(obj);
				return ;
			} catch (AppointmentNotFoundException e) {
				
				System.err.println(e);
			}
			System.out.println("No Data Found With Id "+appointmentId);
    		return ;
    }
    public static void deleteAppointment() throws SQLException,AppointmentNotFoundException{
    	System.out.println("\n Enter Appointment Id To Delete");
    	int appointmentId = Integer.parseInt(scanner.nextLine());
    	try {
    		if(appointmentDao.delete(appointmentDao.singleRecord(appointmentId))){
    			System.out.println("\n Data Has Been Deleted \n");
    		}
    	}catch(SQLException | AppointmentNotFoundException e) {
    		System.out.println("Data Has Not Been Deleted \n");
    		System.err.println(e);
    	}
    }

    public static void allAppointment()throws SQLException,AppointmentNotFoundException{
    	System.out.println("\n Printing All Appointments \n");
    	try {
			List<Appointment> allAppointments= appointmentDao.allRecord();
			for(Appointment appointments: allAppointments)
				if(appointments != null) {
				System.out.println(appointments);
				}
				
		} catch (AppointmentNotFoundException e) {
			System.out.println("\n No Data\n");
			System.err.println(e);
			//e.printStackTrace();
		}
    	
    }
    	
    	

   
    
    	
    	
 }
    

    

