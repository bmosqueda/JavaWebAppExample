<%@ page import = "java.io.*,java.util.*" %>
<%@ page isELIgnored="false"%>

<%String title = "Accessing Request Param";%>
<html>
<body>
<h2>Hello World! LALALa${param.name }</h2>
<c:if test="${param.name == 'studytonight'}">
      <p>Welcome to ${param.name} </p>
    </c:if>
<div align = "center">
         <p>${param["username"]}</p>
      </div>
</body>
</html>