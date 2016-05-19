<% request.setAttribute("pageTitle", "Lab32_JSP");%>
<%@ include file="HomeTop.jsp" %>

 <h1>Request Information</h1>
<ul>  
    <li><font color="blue">Current Locale:</font>&nbsp; <%= request.getServerPort() %> </li>
    <li><font color="blue">Context Path:</font>&nbsp;<%= request.getContextPath() %> </li>
    <li><font color="blue">Server Name:</font>&nbsp; <%= request.getServerName() %> </li>
    <li><font color="blue">Request Scheme:</font>&nbsp; <%= request.getProtocol() %> </li>

</ul>	
   

<%@ include file="HomeBottom.jsp" %>

