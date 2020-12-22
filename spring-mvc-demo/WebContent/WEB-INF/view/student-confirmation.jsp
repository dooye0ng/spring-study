<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Confirmation</title>
</head>
<body>
	<h3>Student Confirmed : ${student.firstName } ${student.lastName }</h3>
	<h4>Country : ${student.country }</h4>
	<h4>Favorite Language : ${student.favoriteLanguage }</h4>
	<h4>Operating Systems :</h4>
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
			<li>${temp }</li>
		</c:forEach>
	</ul>
</body>
</html>