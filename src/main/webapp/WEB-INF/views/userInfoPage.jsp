<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page session="false"%>
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 
 
    <h1>Message : ${message}</h1>
</body>
</html>