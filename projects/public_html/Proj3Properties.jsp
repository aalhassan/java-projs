<% request.setAttribute("pageTitle", "Properties Data");%>
<%@ include file="HomeTop.jsp" %>

<h2>Http Properties Data</h2>
<table>
<%--
Set<String> propertyNames = request.getAttribute("propertyBeans").getProperyKeys();
for (String property : propertyNames) { %>
           <tr><td><%=property%></td><td>${myProperties[<%property%>]}</td></tr>
<%}--%>

    <tr><td>Author:</td><td>${myProperties["author"]}</td></tr>
    <tr><td>Author's Email Address:</td><td>${myProperties["author.email.address"]}</td></tr>
    <tr><td>Course Title:</td><td>${myProperties["course"]}</td></tr>
    <tr><td>Course Sesssion</td><td>${myProperties["author.session"]}</td></tr>
    <tr><td>Instructor</td><td>${myProperties["session.instructor"]}</td></tr>
    <tr><td>Project Description </td><td>${myProperties["project.description"]}</td></tr>
</table>


<%@ include file="HomeBottom.jsp" %>

