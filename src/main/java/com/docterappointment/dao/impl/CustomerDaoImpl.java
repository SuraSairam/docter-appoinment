package com.docterappointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.docterappointment.entity.Customer;
import com.docterappointment.exception.CustomerNotFoundException;
import com.docterappointment.util.DBUtil;
import com.docterappointment.dao.CustomerDao;
//import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao{
    private final static String INSERT ="INSERT INTO Customer(first_name,last_name,contactNumber,gender,email) values(?,?,?,?,?)";
	private final static String UPDATE ="UPDATE Customer SET first_name=?,last_name=? ,contactNumber=?,gender=?,email=? where customer_id= ?";
	private final static String DELETE ="DELETE FROM CUSTOMER WHERE customer_Id = ?";
	private final static String SELECT_BY_ID = "SELECT * FROM CUSTOMER WHERE customer_id=?";
	private final static String SELECT_ALL = "SELECT * FROM CUSTOMER";
	
	
	 
	
	private Connection connection = DBUtil.getConnection();


	@Override
	public boolean insert(Customer obj) throws SQLException {
		PreparedStatement st = connection.prepareStatement(INSERT);
		st.setString(1, obj.getFirstName());
		st.setString(2,obj.getLastName());
		st.setLong(3, obj.getMn());
		st.setString(4, obj.getGender());
		st.setString(5, obj.getEmail());
		//System.out.println("called the function");
		int executeUpdate = st.executeUpdate();
		if(executeUpdate>0) {
			st.close();
			return true;
		}
		//System.out.println(not updated");
		st.close();
		return false;
	}

	@Override
    public  boolean modify(Customer obj) throws SQLException,CustomerNotFoundException {
		PreparedStatement st= connection.prepareStatement(UPDATE);
		
		st.setString(1, obj.getFirstName());
		st.setString(2,obj.getLastName());
		st.setLong(3, obj.getMn());
		st.setString(4, obj.getGender());
		st.setString(5, obj.getEmail());
		st.setInt(6,obj.getId());
		int executeUpdate = st.executeUpdate();
		st.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException, CustomerNotFoundException {
		PreparedStatement st= connection.prepareStatement(DELETE);
		st.setInt(1, id);
		int executeUpdate = st.executeUpdate();
		st.close();
		if(executeUpdate>0) {
			return true;
		}
		st.close();
		return false;	
	}

	@Override
	public List<Customer> allRecord() throws SQLException {
		List<Customer> myList = new ArrayList<Customer>();
		PreparedStatement st=connection.prepareStatement(SELECT_ALL);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Customer e = new Customer();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setMn(rs.getLong(4));
			e.setGender(rs.getString(5));
			e.setEmail(rs.getString(6));
			myList.add(e);
		}
		rs.close();
		st.close();
		return myList;
	}

	@Override
	public Customer singleRecord(int id) throws SQLException ,CustomerNotFoundException{
		PreparedStatement st = connection.prepareStatement(SELECT_BY_ID);
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			Customer e = new Customer();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setMn(rs.getLong(4));
			e.setGender(rs.getString(5));
			e.setEmail(rs.getString(6));
			
			
			st.close();
			return e;
		}
		else {
			System.out.println("No Record Found With Id :- "+id);
		}
		
		
		return null;
	}
	

}
