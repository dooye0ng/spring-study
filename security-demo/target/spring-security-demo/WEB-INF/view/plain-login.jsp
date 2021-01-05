<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>Login Page</h2>
	<hr>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
		  method="post">
		<c:if test="${param.error != null}">
			<p>error !</p>
		</c:if>
		<p>
			username : <input type="text" name="username">
		</p>
		<p>
			password : <input type="text" name="password">
		</p>

		<input type="submit" value="login !">
	</form:form>

</body>

</html>