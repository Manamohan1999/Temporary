package com.kmbb.controler;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmbb.model.AddUserDao;

/**
 * Servlet implementation class AddUserControler
 */
@SuppressWarnings({ "restriction", "serial", "unused" })
public class AddUserControler extends HttpServlet {
	private long ID;
	private String name;
	private String joiningDate;
	private String qualification;
	private int experience;
	private long contact;
	private String email;
	private String address;
	
//  Getters and Setteres
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoiningDate() throws ParseException {
		Date dd=Date.valueOf(joiningDate);
		return dd;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddUserControler userControler=new AddUserControler();
		userControler.ID = Long.parseLong(request.getParameter("ID"));
		userControler.name = request.getParameter("name");
		userControler.joiningDate = request.getParameter("joinDate");
		userControler.qualification = request.getParameter("qualification");
		userControler.experience = Integer.parseInt(request.getParameter("experience"));
		userControler.contact = Long.parseLong(request.getParameter("contact"));
		userControler.email = request.getParameter("email");
		userControler.address = request.getParameter("address");
		
		System.out.println(userControler);
		
		try {
			new AddUserDao().addUser(userControler);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("AddUser.html");
		rd.forward(request, response);
	}

	@Override
	public String toString() {
		return "AddUserControler [ID=" + ID + ", name=" + name + ", joiningDate=" + joiningDate + ", qualification="
				+ qualification + ", experience=" + experience + ", contact=" + contact + ", email=" + email
				+ ", address=" + address + "]";
	}
}
