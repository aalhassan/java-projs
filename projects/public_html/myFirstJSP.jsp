<% request.setAttribute("pageTitle", "My First JSP");%>
<%@ include file="HomeTop.jsp" %>
   
	<p>    Page accessed on :<font color="blue"> <%= new Date() %> </font> </p>
        <img src="images/thMilkyWay.jpeg" alt="Milky Way"/> <br/>
        <h5>The Beautiful Milky Way</h5>
   

<%@ include file="HomeBottom.jsp" %>

