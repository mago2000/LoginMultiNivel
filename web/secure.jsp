<%-- 
    Document   : secure
    Created on : 10/03/2019, 20:35:03
    Author     : toddy
--%>

   <%       
    try 
    {
       
       String user = (String) session.getAttribute("usuario");
       String nivel = (String) session.getAttribute("niveluser");
       // verifica se a sessio esta vazia 
        if (user.equals("")) {
            // se a session está vazio o mesmo é direcionado para o login
            response.sendRedirect("v_login.jsp");
        }
       // verifica nível de acesso do usuario
        else if (nivel.equals("1"))
        {                    
            //se o nivel de usuario o mesmo é redirecionado para pagina de restrito
         response.sendRedirect("acessorestrito.jsp");
        
        }
    } catch (NullPointerException e) {
        response.sendRedirect("v_login.jsp");
    }

%>