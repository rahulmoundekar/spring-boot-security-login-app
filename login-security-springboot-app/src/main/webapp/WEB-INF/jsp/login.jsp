<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
	<div class="container">
		<form method="POST" action="/app-login" class="form-signin">
			<h2 class="form-heading">Log in</h2>
			<h5 style="color: red;" id="exceptionCause">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</h5>
			<h5 style="color: red;" id="exceptionCause">${errorMsg}</h5>
			<font color="green">${logout}</font>
			
			<div class="form-group">
				<input name="app_username" type="text" class="form-control"
					placeholder="Username" autofocus="true" /><br> <input
					name="app_password" type="password" class="form-control"
					placeholder="Password" /><br> <br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log
					In</button>
			</div>
		</form>
	</div>
</body>
</html>
