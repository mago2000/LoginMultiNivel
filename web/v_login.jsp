<%-- 
    Document   : login
    Created on : 23/09/2018, 14:09:27
    Author     : picone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <!-- css retirado do exemplo pois  é um projeto de eestudo que faz parte de um projeto de estudo maior e com mais funções-->
        <!-- no modulo completo do projeto é utilizado Bootstrap de front-->
    </head>
     <%
         //valor da session
        try {
            String user = (String) session.getAttribute("usuario");
            
        } catch (NullPointerException e) {
            session.setAttribute("usuario", "");
            
        }
    %>
    <body class="login">
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">
                        <!-- enviando dados para o servlet Logar-->
                        <form action="./Logar" method="post">
                            <h1>Chamada online</h1>
                            <!-- valores hiden a serem enviados para o servlet-->
                            <input type="hidden" name="funcao" id="funcao" value="logar" />
                            <input type="hidden" name="niveluser" id="funcao" value=1 />             
                            <div>
                                <!-- impputs de usuario-->
                                <input type="text" name="user" id="user" class="form-control" placeholder="Usuário" required="user" />
                            </div>
                            </br>
                            </br>

                            <div>
                                <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required="" />
                            </div>
                            <div>
                            </br>
                                <!-- enviando valores dos inputs-->
                                <input type="submit"> 
                                <!--
                                <a class="btn btn-default submit" href="sistema.jsp">Log in</a>
                                <a class="reset_pass" href="#">Esqueceu a senha?</a>
                                -->
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                <p class="change_link">Novo no site?
                                    <a href="v_logincad.jsp" class="to_register"> Criar uma nova conta </a>
                                </p>

                                <div class="clearfix"></div>
                                <br />
                               <!-- TO DO  A FAZER E IMPLEMENTAR
                               <p class="change_link">Esqueceu sua senha?
                                    <a href="v_login_recupera.jsp" class="to_register">  Recuperar senha </a>
                                </p>
                               -->

                                <div class="clearfix"></div>
                                <br />
                                <div>
                                    <h1> Modelo de login em jsp,servlet e mysql</h1>
                                    <p>Criado por grupo Luis P</p>
                                </div>


                            </div>
                        </form>
                    <%session.setAttribute("user","user");%>                              
                </section>
            </div>    
    </body>
</html>
