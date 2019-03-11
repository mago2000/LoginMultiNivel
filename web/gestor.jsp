<%-- 
    Document   : usuario
    Created on : 09/03/2019, 20:02:15
    Author     : toddy
--%>
<%@page import ="Bean.LoginBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/imports.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
     

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   <%@include file="/secure.jsp" %>

        <h1>Bem vindo a pagina gestor </h1>
        
            <h4> Exibindo usando jstl</h4>
                    <br>
                    <h5>${usuario}</h5>
                    
                    <br>
                    <h4> Exibindo usando java em jsp</h4>
                    <br>
                    <h5>
                    <%                    
                        out.print(session.getAttribute("usuario"));
                    %>    
                    </h5>
                      
                    
    </body>
</html>
