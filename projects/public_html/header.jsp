<%! 
 int pageCount = 0;
 void addCount() {
   pageCount++;
 }
%>
<% addCount(); %>
<html>
<head>
<title>The include Directive Demo</title>
<%@ page import= "java.util.*"%>
</head>
<body>
<center>
<h2>This is a demo for include directive</h2>
<p>This site has been visited <%= pageCount %> times.</p>
</center>
<br/><br/>
<!-- Begin  of content -->