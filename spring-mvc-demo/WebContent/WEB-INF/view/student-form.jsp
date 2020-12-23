<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Register</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name : <form:input path="firstName"/>
		<br/>
		
		Last name : <form:input path="lastName"/>
		<br/>
		
		Country :
		<form:select path="country">
			<form:options items="${student.countryOptions }"></form:options>
		</form:select>
		<br/>
		Favorite Language : 
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions }"/>
		<br/>
		
		Operating System Experience : 
		<form:checkboxes path="operatingSystems" items="${student.operatingSystemOptions }"/>
		<br/>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>