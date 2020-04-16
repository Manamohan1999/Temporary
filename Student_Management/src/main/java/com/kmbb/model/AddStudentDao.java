package com.kmbb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kmbb.controler.AddStudentControler;
import com.kmbb.utility.DBConnection;

public class AddStudentDao {
	public void addStudent(AddStudentControler addStudent) throws ClassNotFoundException {
		try {
			System.out.println("In AddStudentDao");
			Connection con=DBConnection.getConnection();
			String querry="insert into student_details(RegdNo,Name,Password,Branch,Email,Phone,ParentsPhone,Gender,DOB,Matriculation,Intermediate,Address) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement smt=con.prepareStatement(querry);
			smt.setLong(1, addStudent.getRegd());
			smt.setString(2, addStudent.getName());
			smt.setString(3, addStudent.getPassword());
			smt.setString(4, addStudent.getBranch());
			smt.setString(5, addStudent.getEmail());
			smt.setLong(6, addStudent.getPhone());
			smt.setLong(7, addStudent.getParentPhone());
			smt.setString(8, addStudent.getGender());
			smt.setDate(9, addStudent.getDob());
			smt.setDouble(10, addStudent.getMatriculation());
			smt.setDouble(11, addStudent.getIntermediate());
			smt.setString(12, addStudent.getAddress());
			Boolean b=smt.execute();
			System.out.println(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

