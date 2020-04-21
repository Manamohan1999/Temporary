package com.kmbb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kmbb.controler.AddSubjectControler;
import com.kmbb.utility.DBConnection;

public class AddSubjectDao {

	public void addSubject(AddSubjectControler addSubjecct) {
		try {
			Connection con=DBConnection.getConnection();
			String query="insert into subject_details(SubjectID,Subject,Branch,ShortName) values(?,?,?,?)";
			PreparedStatement smt=con.prepareStatement(query);
			smt.setString(1, addSubjecct.getSubjectID());
			smt.setString(2, addSubjecct.getSubject());
			smt.setString(3, addSubjecct.getBranch());
			smt.setString(4, addSubjecct.getShortName());
			Boolean b=smt.execute();
			System.out.println(b);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
