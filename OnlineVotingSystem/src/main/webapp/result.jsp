<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<h2>Voting Result</h2>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
	${rb.fetchCandidates()}
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cc" items="${rb.candList}">
				<tr>
					<td>${cc.id}</td>
					<td>${cc.name}</td>
					<td>${cc.party}</td>
					<td>${cc.votes}</td>
					<td>
						<a href="editcand.jsp?id=${cc.id}">
							<img src="images/edit.png" alt="Edit" width="20" height="20"/>
						</a>
						<a href="delcand.jsp?id=${cc.id}">
							<img src="images/delete.png" alt="Delete" width="20" height="20"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
