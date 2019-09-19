<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring Boot MVC Security</title>
<link rel="stylesheet" href="/css/styles.css" />
</head>
<body>
	<h3>Access Denied Exception</h3>
	<div>
		<p>
			<font color="red">${errorMsg}</font>
		</p>
		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form>
	</div>
</body>
</html>
