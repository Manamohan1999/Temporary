package com.kmbb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import com.kmbb.controler.AddUserControler;
import com.kmbb.utility.DBConnection;

public class AddUserDao {
	

	public void addUser(AddUserControler ac) throws ClassNotFoundException, ParseException{
		try {
			Connection con=DBConnection.getConnection();
			String querry="insert into faculty_details(TeacherID,Name,DateofJoining,Qualification,Experience,Contactno,Email,Address) values(?,?,?,?,?,?,?,?)";
			PreparedStatement smt=con.prepareStatement(querry);
			smt.setLong(1, ac.getID());
			smt.setString(2, ac.getName());
			smt.setDate(3, ac.getJoiningDate());
			smt.setString(4, ac.getQualification());
			smt.setInt(5, ac.getExperience());
			smt.setLong(6, ac.getContact());
			smt.setString(7, ac.getEmail());
			smt.setString(8, ac.getAddress());
			Boolean b=smt.execute();
			System.out.println(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}

