<!DOCTYPE html>
<html>
<head>
	<title>HelloWorld</title>	
</head>
<body>
	<h1>page : ${pageContext.request.contextPath }</h1>
	<h1>Student name : ${param.studentName }</h1>
	
	<br/>
	
	<h3>The message : ${requestScope.message }</h3>
</body>
</html>