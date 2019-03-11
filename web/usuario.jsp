<%-- 
    Document   : usuario
    Created on : 09/03/2019, 20:02:15
    Author     : toddy
--%>
<%@page import ="Bean.LoginBean"%>

<%-- import para usar bibliotecas do jstl --%>
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
        
            <h1>Bem vindo a pagina Usuario </h1>
        
                   
                    <!-- exibindo nome de usuario em jstl assim evitar scriplets-->
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
                    
                    arrumar teste de do gestor para usuario para o mesmo enviar para pagina de restrito
                    
                    <p class="change_link"> Link teste para testar o método!
                                    <a href="gestor.jsp" class="to_register"> pagina gestor </a>
                                </p>
                    
    </body>
</html>
