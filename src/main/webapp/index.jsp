<%-- 
    Document   : index
    Created on : 30/10/2017, 15:53:17
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/_css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>      
        <script src="recursos/_js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
      <body>
        <header>
            <jsp:include page="WEB-INF/jsp/header.jsp" />
        </header>
        <c:if test="${not empty page}">
            <jsp:include page="WEB-INF/jsp/paginas/${page}" flush="true" />                            
        </c:if>
        <c:if test="${empty page}"> 
            <jsp:include page="WEB-INF/jsp/paginas/dashboard.jsp" />
        </c:if>
       
      </body>
</html>