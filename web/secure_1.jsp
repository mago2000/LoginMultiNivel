<%-- 
    Document   : secure
    Created on : 10/03/2019, 20:35:03
    Author     : toddy
--%>

   <%       
    try 
    {
       
       String user = (String) session.getAttribute("usuario");
       
       // verifica se a sessio esta vazia 
        if (user.equals("")) {
            // se a session est� vazio o mesmo � direcionado para o login
            response.sendRedirect("v_login.jsp");
        }
             
    } catch (NullPointerException e) {
        response.sendRedirect("v_login.jsp");
    }

%>