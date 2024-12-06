<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Bean</title>
</head>
<body>
	<jsp:useBean id="log" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty property="*" name="log"/>
	
	${log.login()}
	<c:choose>
		<c:when test="${log.user != null }">
		
			<c:choose>
		<c:when test="${log.user.role == 'admin' }">
				<c:redirect url="result.jsp" />
		
		</c:when>
		<c:otherwise>
				<c:redirect  url="candlist.jsp"/>
		</c:otherwise>
			
	</c:choose>
		
		</c:when>
		
		<c:otherwise>
				<h2>Login Failed</h2>
				<p>
					<a href="index.jsp"> Login Again</a>
				</p>
				
				
				
				
		</c:otherwise>
	
	</c:choose>
	
	

</body>
</html>