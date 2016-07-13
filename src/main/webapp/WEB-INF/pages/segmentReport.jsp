<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home Page</title>
</head>

<body class="bodyCSS">
	<c:if test="${zeroSearchResults}">
		<h3 style="color: blue;">Your Search Did Not Produce Any Results.
			Please Modify Your Search And Try Again</h3>
	</c:if>

	<table border=1>
		<tr>

			<td width="200"><form:form method="get" action="segmentReport.htm"
					modelAttribute="user">

					<table>
						<tr>
							<td>User Id</td>
							<td><form:input path="userId" /></td>
						</tr>
						<tr>
							<td>User Name</td>
							<td><form:input path="userName" /></td>
						</tr>
						<tr>
							<td>Designation</td>
							<td><form:input path="desg" /></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="submit" />
							</td>
						</tr>
					</table>
				</form:form></td>
			<td><c:if test="${empty zeroSearchResults}">
					<table border="1" bordercolor="#006699"
						style="border-collapse: collapse; width: 500px;">
						<tbody>
							<tr bgcolor="lightblue">
								<th>UserId</th>
								<th>User Name</th>
								<th>Desgination</th>
							</tr>
							<c:forEach var="user1" items="${user}">
							<tr>
								<td><c:out value="${user1.userId}"></c:out>
								</td>
								<td><c:out value="${user1.userName}"></c:out>
								</td>
								<td><c:out value="${user1.desg}"></c:out></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if></td>
		</tr>

	</table>
</body>
</html>