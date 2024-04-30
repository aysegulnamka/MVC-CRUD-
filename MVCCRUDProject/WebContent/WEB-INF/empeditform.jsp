<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
	<h1>Edit Employee</h1>  
	<form:form method="POST" action="/MVCProject/editsave">    
		<table >    
			<tr>  
				<td>ID</td>    
				<td><form:hidden  path="id" /></td>  
			</tr>  
			 
			<tr>    
				<td>Name : </td>   
				<td><form:input path="first_name"  /></td>  
			</tr>  
			
			<tr>    
				<td>Surname : </td>   
				<td><form:input path="last_name"  /></td>  
			</tr>
			
			<tr>    
				<td>E-mail : </td>   
				<td><form:input path="email"  /></td>  
			</tr>
			
			<tr>    
				<td>Address : </td>   
				<td><form:input path="address"  /></td>  
			</tr>  
			
			<tr>    
				<td>Phone :</td>    
				<td><form:input path="phone_number" /></td>  
			</tr>     
			  
			<tr>    
				<td> </td>    
				<td><input type="submit" value="Edit Save" /></td>    
			</tr>    
		</table>    
	</form:form>    
</body>
</html>