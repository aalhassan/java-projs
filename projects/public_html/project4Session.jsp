<% request.setAttribute("pageTitle", "Project 4 Session");%>
<%@ include file="HomeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" scope="page" value="Mej Al"/>
<p>Session Count: ${project4SessionCounter}</p>
<%@ include file="HomeBottom.jsp" %>

