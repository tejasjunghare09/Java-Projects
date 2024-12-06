<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Bean</title>
</head>
<body>
	<jsp:useBean id="log" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty property="*" name="log"/>
	
	${log.login()}
	
	<c:choose>
		<c:when test="${log.getSave() ==1 }">
			Login Successfull !
			
		 <c:redirect url="candlist.jsp"/>
        
		</c:when>	
		<c:otherwise>
		Registration Failed. <br>
		Try Again ! <br>
			<script>
            setTimeout(function() {
                window.location.href = "index.jsp";
            }, 3000); 
        </script>	
		</c:otherwise>
		
	
	</c:choose>

</body>
</html>