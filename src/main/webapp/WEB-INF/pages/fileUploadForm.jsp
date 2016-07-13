<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>RMDSS File Upload</title>
<style>
body {
	font-family: "Trebuchet MS";
}

h1 {
	font-size: 1.5em;
}
</style>



</head>
<body>
	<h1>Select valid xml file to upload</h1>

	<form:form method="post" action="save.htm" modelAttribute="uploadForm"
		enctype="multipart/form-data">

		<p>Select file to upload.</p>

		<table id="fileTable">
			<tr>
				<td><input name="files[0]" type="file" /></td>
			</tr>
		</table>
		<br />
		<input type="submit" value="Upload" />
	</form:form>

	<form:form method="post" action="saveUser.htm" modelAttribute="user">
		<table>
			<tr>
				<td>User Id</td>
				<td><form:input path="userId" />
				</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input path="userName" />
				</td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><form:input path="desg" />
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
