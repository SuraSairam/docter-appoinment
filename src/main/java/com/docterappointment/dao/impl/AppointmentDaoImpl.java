package com.docterappointment.dao.impl;
import com.docterappointment.dao.AppointmentDao;
import com.docterappointment.entity.Appointment;
import com.docterappointment.exception.AppointmentNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;

import com.docterappointment.util.DBUtil;

public class AppointmentDaoImpl implements AppointmentDao{
	private static final String INSERT = "INSERT into Appointment(CustomerId,DoctorId,D_name,address,appointmentDate) values(?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Appointment set DoctorId=?,D_Name=?,address=?,appointmentDate=? WHERE appointmentId=?";
	private static final String DELETE = "DELETE from Appointment where appointmentId=?";
	private static final String SELECT_BY_ID = "SELECT * FROM Appointment where appointmentID=?";
	private static final String SELECT_ALL = "SELECT * FROM Appointment";
	Connection connection = DBUtil.getConnection();
	@Override
	public boolean bookAppointment(Appointment obj) throws  SQLException , AppointmentNotFoundException{
		PreparedStatement ps = connection.prepareStatement(INSERT);
//		ps.setInt(1,obj.getAppointmentId());
		ps.setInt(1,obj.getCustomerId());
		ps.setInt(2, obj.getDoctorId());
		ps.setString(3, obj.getName());
		ps.setString(4,obj.getAddress());
		ps.setString(5,obj.getAppointmentDate());
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}
		
    @Override
    public boolean modify(Appointment obj) throws SQLException , AppointmentNotFoundException{
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setInt(5,obj.getAppointmentId());
//		ps.setInt(1,obj.getCustomerId());
		ps.setInt(1, obj.getDoctorId());
		ps.setString(2, obj.getName());
		ps.setString(3,obj.getAddress());
		ps.setString(4,obj.getAppointmentDate());
		
		
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
		
	}
	@Override
	public boolean delete(Appointment obj) throws SQLException, AppointmentNotFoundException{
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1,obj.getAppointmentId());
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
		
	}
	@Override
	public Appointment singleRecord(int id) throws SQLException ,AppointmentNotFoundException{
//		List<Appointment> appointments = new ArrayList<Appointment>();
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
		System.out.println(id);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Appointment e = new Appointment();
			e.setAppointmentId(rs.getInt("appointmentId"));
			e.setCustomerId(rs.getInt("CustomerId"));
			e.setDoctorId(rs.getInt("DoctorId"));
			e.setName(rs.getString("D_name"));
			e.setAddress(rs.getString("address"));
			e.setAppointmentDate(rs.getString("appointmentDate"));
			
		rs.close();
		ps.close();
		return e;	
	}
		else{
			System.out.println("Appointment not found with id: "+id);
			
		}
		return null;
		
	}
	@Override
	public List<Appointment> allRecord() throws SQLException ,AppointmentNotFoundException{
		List<Appointment> appointments = new ArrayList<Appointment>();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Appointment e = new Appointment();
			e.setAppointmentId(rs.getInt(1));
			e.setCustomerId(rs.getInt(2));
			e.setDoctorId(rs.getInt(3));
			e.setName(rs.getString(4));
			e.setAddress(rs.getString(5));
			e.setAppointmentDate(rs.getString(6));
			
			
			appointments.add(e);
//			rs.close();
//			ps.close();
		}
		return appointments;
	}

}
