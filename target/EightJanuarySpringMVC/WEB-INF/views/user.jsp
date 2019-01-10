<html>

<head>
    <%@ page isELIgnored="false"%>
 </head>
<body>
<h2>Hello World!</h2>

<h2>Hello World!</h2>

<h2>Welcome to stackroute : ${greeting} Have a good day</h2>
<table border="1" width="70%" cellpadding="2">
		<tr>
			<th>UserName</th>
			<th>Password</th>
		</tr>
		  <c:forEach var="user" items="${userList}">
		  <tr>
			  <td>${user.name}</td>
			  <td>${user.password}</td>
		  </tr>
		  </c:forEach>
</table>
<a href="/">Enter more</a>
</body>
</html>
