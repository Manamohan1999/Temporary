package com.kmbb.controler;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmbb.model.AddStudentDao;
import com.kmbb.utility.MailOTP;
import com.kmbb.utility.OTPGenerator;

/**
 * Servlet implementation class AddStudentControler
 */
@SuppressWarnings({ "restriction", "serial" })
public class AddStudentControler extends HttpServlet {
	private long regd;
	private String name;
	private String password;
	private String branch;
	private String email;
	private long phone;
	private long parentPhone;
	private String gender;
	private String dob;
	private double matriculation;
	private double intermediate;
	private String address;
	
//  getters and setters
	
	public long getRegd() {
		return regd;
	}
	public void setRegd(long regd) {
		this.regd = regd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(long parentPhone) {
		this.parentPhone = parentPhone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		Date dd=Date.valueOf(dob);
		return dd;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getMatriculation() {
		return matriculation;
	}
	public void setMatriculation(double matriculation) {
		this.matriculation = matriculation;
	}
	public double getIntermediate() {
		return intermediate;
	}
	public void setIntermediate(double intermediate) {
		this.intermediate = intermediate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String email) {
		this.password=Integer.valueOf(OTPGenerator.getOTP()).toString();
		MailOTP.send(email, password);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddStudentControler studentControler=new AddStudentControler();
		studentControler.regd=Long.parseLong(request.getParameter("regdNo"));
		studentControler.name=request.getParameter("name");
		studentControler.branch=request.getParameter("branch");
		studentControler.email=request.getParameter("email");
		studentControler.phone=Long.parseLong(request.getParameter("phone"));
		studentControler.parentPhone=Long.parseLong(request.getParameter("parentPhone"));
		studentControler.gender=request.getParameter("gender");
		studentControler.dob=request.getParameter("dob");
		studentControler.matriculation=Double.parseDouble(request.getParameter("matriculation"));
		studentControler.intermediate=Double.parseDouble(request.getParameter("intermediate"));
		studentControler.address=request.getParameter("address");
		
		//setting the password and sending the password through mail
		studentControler.setPassword(studentControler.getEmail());
		
		try {
			new AddStudentDao().addStudent(studentControler);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(studentControler);
		
		RequestDispatcher rd=request.getRequestDispatcher("AddStudent.html");
		rd.forward(request, response);
		
	}
	
	@Override
	public String toString() {
		return "AddStudentControler [regd=" + regd + ", name=" + name + ", branch=" + branch + ", email=" + email
				+ ", phone=" + phone + ", parentPhone=" + parentPhone + ", gender=" + gender + ", dob=" + dob
				+ ", matriculation=" + matriculation + ", intermediate=" + intermediate + ", address=" + address + "]";
	}
	
}
