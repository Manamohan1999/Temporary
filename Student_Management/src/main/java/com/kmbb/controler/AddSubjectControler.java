package com.kmbb.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmbb.model.AddSubjectDao;

/**
 * Servlet implementation class AddSubjectContoler
 */
@SuppressWarnings({ "restriction", "serial" })
public class AddSubjectControler extends HttpServlet {
	
	private String subjectID;
	private String subject;
	private String branch;
	private String shortName;

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddSubjectControler addSubject=new AddSubjectControler();
		addSubject.subjectID = request.getParameter("subjectID");
		addSubject.subject = request.getParameter("subject");
		addSubject.branch = request.getParameter("branch");
		addSubject.shortName = request.getParameter("shortName");
		
		new AddSubjectDao().addSubject(addSubject);
		request.setAttribute("result", "true");
		request.getRequestDispatcher("AddSubject.jsp").forward(request, response);
		
		
	}

}
