<% request.setAttribute("pageTitle", "Lab42_JSTL");%>
<%@ include file="HomeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" scope="page" value="Mej Al"/>
<p> My name is ${name} </p> <br/>
<h2>Map Items From Request</h2>

<table border="1"> 
<c:forEach var="item"  items="${myMap}" >
 <tr><td>${item}</td></tr>
</c:forEach>
</table>
<%@ include file="HomeBottom.jsp" %>

