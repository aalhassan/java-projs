<% request.setAttribute("pageTitle", "Lab42_JSP");%>
<%@ include file="HomeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" scope="page" value="Mej Al"/>
<p> My name is ${name} </p>

<%@ include file="HomeBottom.jsp" %>
