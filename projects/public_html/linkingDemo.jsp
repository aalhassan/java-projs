<% request.setAttribute("pageTitle", "Linking Demo JSP");%>
<%@ include file="HomeTop.jsp" %>

<a href = "http://localhost:8080/java112/index.jsp">Wrong way to link to home page</a> <br/>
<a href = "/java112/index.jsp">Another wrong way to link to home page</a> <br/>
<a href = "/java112">The right way to link to the home page!</a> <br/>
<a href = "/java112/trivial">Right way to link to servlets</a> <br/>



<%@ include file="HomeBottom.jsp" %>
