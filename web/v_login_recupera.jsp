<%-- 
    Document   : recupera_login
    Created on : 28/09/2018, 13:28:27
    Author     : picone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="./logar" method="post">
        
        <div>
            <input type="text" name="email" id="email" class="form-control" placeholder="E-mail" required="" />
        </div>
                <br>
                <br>
        <div>            
            <input type="submit"> 
        </div>
        </form>
    </body>
</html>
