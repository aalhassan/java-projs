<% request.setAttribute("pageTitle", "Lab33_Servlet");%>
<%@ include file="HomeTop.jsp" %>

<h2>Map on a JSP Page</h2>
<p>${myMap["number"]}</p>
<p>${myMap["text"]}</p>
${myMap["html"]}
<p>${myMap["aDate"]}</p>

<%@ include file="HomeBottom.jsp" %>

