/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.LoginBean;
import Dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toddy
 */
@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        response.sendRedirect("v_login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {          
        // recebendo varivel da view  para ver qual função do usuario
        String funcao = request.getParameter("funcao");
        //instanciando classe de trabalo BEAN e DAO
        LoginDao log = new LoginDao();
        LoginBean lgb = new LoginBean();  
        
//************************************************************************************************************
        //se o valor de função for igual cadastrar novo usuario  para login
        if(funcao.equals("cadastrar"))
        {
            //recebendo parametros da v_loginCad jsp e armazendo nas variaveis usuario 
            String usuario = request.getParameter("user");
            //recebendo parametros da v_loginCad jsp e armazendo nas variaveis email
            String email = request.getParameter("email");
            //recebendo parametros da v_loginCad jsp e armazendo nas variaveis niveluser
            String niveluser =  request.getParameter("niveluser");
            //setando valores de varivais nos set da classe bean
            lgb.setNomeUser(usuario);
            lgb.setEmailUser(email);
            lgb.setNivelUser(niveluser);


             // verifica se o email já esta cadastrado
            if(log.verificarLogin(email))
            {
                //se sim evian para pagina recupera login
                 response.sendRedirect("v_login_recupera.jsp");
            }
            else
            {
                // se não recebe a senha      
                lgb.setSenhaUser(request.getParameter("senha"));
                // executa o metodo dao  de cadastro na base de dados
                log.cadastrarLogin(lgb);
                //envia o mesmo para a pagina de login efeutar o login
                response.sendRedirect("v_login.jsp");

            }
        } 
        
//************************************************************************************************************
        else if(funcao.equals("recuperalogin"))
        {
        // METODO A FAZER TO DO
         response.sendRedirect("v_login.jsp");
        }
        
//************************************************************************************************************
        //  caso  parametro funcao da view login seja logar
        else if (funcao.equals("logar"))
        {
            try 
            {       
                // verificando se parametro login ou senha estão vindo vazios
                if(request.getParameter("user").equals("")||request.getParameter("senha").equals(""))
                {
                    //caso sim retorna para pagina login
                    response.sendRedirect("v_login.jsp");
                }
                else
                { 
                    //se parametros forem direntes de vazios são feitos os request e armazenados e variaveis locais
                    String user =(request.getParameter("user"));
                    String senha = (request.getParameter("senha"));

                    // criando varivel de sessao
                    HttpSession session = request.getSession();
                    //executando metodo  no dao para ver se é um login valido 
                    if(log.logarLogin(user, senha))
                    {
                        // se o login é velido é  verificado o nível de acesso do usuario
                        lgb = log.nivelAcesso(user,senha);

                        // caso seja um  usuario é direcionado para pagina de usuario
                        if(lgb.getNivelUser().equals("1"))
                        {
                            response.sendRedirect("usuario.jsp");
                        }
                        else
                        {
                            // se nivel for diferente de 1 o mesmo vai para pagina de  gestor
                            response.sendRedirect("gestor.jsp");
                        }
                        session.setAttribute("usuario", user);
                        session.setAttribute("senha", senha); 
                        session.setAttribute("niveluser",lgb.getNivelUser()); 

                        // tempo de duração da session a mesma é destruida se não houve interação do usuraio apos um periodo maior q 60*5
                        session.setMaxInactiveInterval(60 * 5);

                     }
                    else
                    {
                        response.sendRedirect("v_login.jsp");
                    }
                }
            }                                
            catch (Exception e) 
            {
                throw new RuntimeException("Erro 1w" + e);            
            }

        }
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
