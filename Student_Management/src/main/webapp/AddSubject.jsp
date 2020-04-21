<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addSubjectControler" method="POST">
		 	SubjectID:<input type="text" name="subjectID"><br><br>
		 	Subject:<input type="text" name="subject"><br><br>
		 	Branch:<select name="branch">
		 		<option value="CSE">CSE</option>
		 		<option value="EEE">EEE</option>
		 		<option value="CIVIL">CIVIL</option>
		 		<option value="MECH">MECH</option>
		 	</select><br><br>
		 	ShortName:<input type="text" name="shortName"><br><br>
		 	<%
		 		String s=(String)request.getAttribute("result");
		 		if(s!=null && s.equals("true")){
		 			out.println("<i>Subject Added</i>");
		 		}
		 	%>
		 	<input type="submit" name="" value="Submit">
	</form>

</body>
</html>