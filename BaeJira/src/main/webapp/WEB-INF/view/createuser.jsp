<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save User</title>

</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Crea utente</h2>
		</div>
		<div>Esito ${esito}</div>
	</div>

	<div id="container">
		<h3>Salva utente</h3>
	
		<form:form action="saveUser" modelAttribute="user" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="username" /></td>
					</tr>
				
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		
	
	</div>

</body>

</html>