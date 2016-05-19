<% request.setAttribute("pageTitle", "Servlet Requests");%>
<%@ include file="HomeTop.jsp" %>

<h2>Http Request Data</h2>
<ul>

<li><font color="blue">Client Name: </font>&nbsp; ${myRequestData["client"]}</li>
<li><font color="blue">Client Ip:</font>&nbsp; ${myRequestData["clientIp"]}</li>
<li><font color="blue">Request Protocol: </font>&nbsp;${myRequestData["requestProtocol"]}</li>
<li><font color="blue">Request Method: </font>&nbsp;${myRequestData["httpRequestMethod"]}</li>
<li><font color="blue">Request URI: </font>&nbsp;${myRequestData["requestUri"]}</li>
<li><font color="blue">Request URL: </font>&nbsp;${myRequestData["requestUrl"]}</li>
<li><font color="blue">Server Name: </font>&nbsp;${myRequestData["serverName"]}</li>
<li><font color="blue">Server Port: </font>&nbsp;${myRequestData["serverPort"]}</li>
<li><font color="blue">Current Locale: </font>&nbsp;${myRequestData["currentLocale"]}</li>
<li><font color="blue">Query String: </font>&nbsp;${myRequestData["queryString"]}</li>
<li><font color="blue">Query Parameter: </font>&nbsp;${myRequestData["queryParameter"]}</li>
<li><font color="blue">User Agent: </font>&nbsp;${myRequestData["userAgent"]}</li>


</ul>


<%@ include file="HomeBottom.jsp" %>

