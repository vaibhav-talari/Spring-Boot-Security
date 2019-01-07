<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Create an account</title>
</head>

<body>

	<div>

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2>Create your account</h2>
			<spring:bind path="name">
				<div>
					<form:input type="text" path="name" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>
			<br>

			<spring:bind path="password">
				<div>
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<br>
			<spring:bind path="roles">
				<p>1-Librarian</p>
				<p>2-Principle</p>

				<div>
					<form:radiobuttons items="${radio}" path="roles" delimiter="<br>" />
					<form:errors path="roles"></form:errors>
				</div>
			</spring:bind>
			<br>

			<button>Submit</button>
		</form:form>

	</div>
</body>
</html>