<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Bean</title>
</head>
<body>

<%-- create bean object --%>
		<jsp:useBean id="reg" class="com.sunbeam.beans.RegisterBean"/>	
		<jsp:setProperty name="reg" property="*"  />
		
		${reg.register()}

	<c:choose>
		<c:when test="${reg.getSave()==1}">
			Registration Successfull !
			
			<script>
            setTimeout(function() {
                window.location.href = "index.jsp";
            }, 3000); 
        </script>
		</c:when>
		<c:otherwise>
			Registration Failed. <br>
			Try Again !
			<script>
            setTimeout(function() {
                window.location.href = "newuser.jsp";
            }, 3000); 
        </script>
		</c:otherwise>
		
	</c:choose>

		
</body>
</html>