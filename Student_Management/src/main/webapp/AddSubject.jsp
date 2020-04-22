<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="AddSubjectValidation.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="addSubjectControler" method="POST" onsubmit="return validate(this)">
		 	SubjectID:<input type="text" name="subjectID">
		 		<span id="subjectIDErr"></span><br>
		 	Subject:<input type="text" name="subject">
		 		<span id="subjectErr"></span><br>
		 	Branch:<select name="branch">
		 		<option value="">Select Branch</option>
		 		<option value="CSE">CSE</option>
		 		<option value="EEE">EEE</option>
		 		<option value="CIVIL">CIVIL</option>
		 		<option value="MECH">MECH</option>
		 	</select>
		 		<span id="branchErr"></span><br>
		 	ShortName:<input type="text" name="shortName">
		 		<span id="shortNameErr"></span><br>
		 	<%
		 		String s=(String)request.getAttribute("result");
		 		if(s!=null && s.equals("true")){
		 			out.println("<i>Subject Added</i><br>");
		 		}
		 	%>
		 	<input type="hidden" value="no" name="vflag"><br>
		 	<input type="submit" name="" value="Submit">
	</form>

</body>
</html>