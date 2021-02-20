<%--
  Created by IntelliJ IDEA.
  User: strog
  Date: 18.02.2021
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.apress.bookapp.model.Book"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="css/BookApp.css" type="text/css" />
    <script src="js/BookApp.js"></script>
</head>

<body>
<div id="centered">

    <jsp:include page="header.jsp" flush="true" />
    <br />
    <jsp:include page="leftColumn.jsp" flush="true" />

    <jsp:include page="list.jsp" flush="true" />



</div>


</body>
</html>

