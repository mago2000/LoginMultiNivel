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
        <!-- importando pagina com codigo de verificação d nivel e sessao-->
         <%@include file="/secure_1.jsp" %>
        
        <h1>Voce tentou acessar uma pagina restrita. faça novamente o login</h1>
                                                                    
                    
                                    <a href="v_login.jsp" class="to_register"> pagina login </a>
                                </p>
                    
    </body>
</html>
