<%-- 
    Document   : cad_login
    Created on : 23/09/2018, 22:23:07
    Author     : picone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="login">
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">
                        
         <form action="./Logar" method="post">
              <div>
              <input type="hidden" name="funcao" id="funcao" value="cadastrar" />
              <input type="hidden" name="niveluser" id="niveluser" value="1" />             
              </div>
              <h1>CADASTRO</h1>
                            <div>
                                ${usuario}
                                <input type="text" name="user" id="user" class="form-control" placeholder="Usuário" required="" />
                            </div>
                            </br>
                           
                            <div>
                                <input type="text" name="email" id="email" class="form-control" placeholder="E-mail" required="" />
                            </div>
                            </br>
                           

                            <div>
                                <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required="" />
                            </div>
                            <div>
                            </br>
                                                   
                                <input type="submit" value="cadastrar"> 
                               <a href="v_login.jsp" class="to_register"> Faça seu login </a>
                                <!--
                                <a class="btn btn-default submit" href="sistema.jsp">Log in</a>
                                <a class="reset_pass" href="#">Esqueceu a senha?</a>
                                -->
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                
                                <div class="clearfix"></div>
                                <br />

                                <div>
                                    <h1><i class="fa fa-paw"></i> Sistema Chamada online</h1>
                                    <p>Sistema JSP! Criado por grupo codekill</p>
                                </div>


                            </div>
                        </form>
    </body>
</html>
