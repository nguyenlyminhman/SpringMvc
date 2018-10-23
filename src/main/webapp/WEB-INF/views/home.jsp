<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Login Spring!</h1>

	<form action="/spring/login" method="post">
		Username: <input name="username" type="text" /> 
		Password: <input name="password" type="password" />
		<input type="submit">
	</form>
</body>
</html>
