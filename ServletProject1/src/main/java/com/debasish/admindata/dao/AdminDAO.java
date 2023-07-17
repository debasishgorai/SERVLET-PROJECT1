package com.debasish.admindata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import com.debasish.admindata.dto.*;
//@WebServlet("/saveadmin")
public class AdminDAO {
private Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/m10_e3";
		String user="root";
		String password="1234";
	Connection con= DriverManager.getConnection(url,user,password);
		
	}
	catch(ClassNotFoundException| SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public String saveAdmin(Admindto dto) {
	String query="INSERT INTO admin(name,email,dept,password)"+"VALUES(?,?,?,?)";
	Connection con=getConnection();
	if(con!=null) {
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, dto.getName());
		
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	return "something went wrong";
	
}
public Admindto adminLogin(String email,String password) {
	String query="SELECT * FROM admin WHERE email=? AND "+"password=?";
	Connection con=getConnection();
	if(con!=null) {
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2,password);
			ResultSet set=ps.executeQuery();
			Admindto dto=new Admindto();
			while(set.next()) {
				dto.setId(set.getInt(1));
				dto.setName(set.getString(2));
				dto.setEmail(set.getString(3));
				dto.setDept(set.getString(4));
				dto.setPassword(set.getString(5));
			}
			con.close();
			return dto;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
	
	
	
}

}
