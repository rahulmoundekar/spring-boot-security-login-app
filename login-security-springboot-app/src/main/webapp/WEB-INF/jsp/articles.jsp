<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<h3>User Articles Details</h3>
	<div>
		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form>
	</div>
	<br />
	<table>

		<c:forEach items="${userArticles}" var="article">
			<td>${article.articleId}:Id</td>
			<td>${article.title}:Title</td>
			<td>${article.category}:Category</td>
		</c:forEach>

	</table>
</body>
