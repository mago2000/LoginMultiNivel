
package Dao;

import Bean.LoginBean;
import Factory.ConectorFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao {
    Connection con;
  //constructor inicia a conexao
    public LoginDao() {
        this.con = new ConectorFactory().getConnection();       
    }
    
    //metodo cadastrar login caso o usuario não tenha conta
  public void cadastrarLogin(LoginBean login){
      //string sql com parametros
        String sql ="insert into login (nomeuser,emailuser,senhauser,niveluser) values(?,?,?,?)";
        try 
        {
            // ps recebe string com a conexao aberta
            PreparedStatement ps =  con.prepareStatement(sql);         
            //setado valores no values da string
            ps.setString(1,login.getNomeUser());
            ps.setString(2,login.getEmailUser());
            ps.setString(3,login.getSenhaUser());
            ps.setString(4,login.getNivelUser());
            //executando o insert de dados na base
            ps.executeUpdate();
            //encerra ps
            ps.close();
            //encerra a conexao
            con.close();
        } 
        catch (Exception e) 
        {
         throw new RuntimeException("Erro 1_D   " + e);
            //Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, e);
            
        }  
  
    }
  
  // metodo la logar no login recebendo parametro de usuario e login diferenciando maiusculo de minusculo
   public boolean logarLogin(String nome, String senha)
   {
       //string sql com parametros
        String sql = "select * from login where binary  nomeUser=? and binary  senhaUser=?";
        try 
        {
            // ps recebe string com a conexao aberta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);   
            //executando o  o select na base de dados
            ResultSet rs = ps.executeQuery();
            //rs verifica se encontrou ou não os dados
            if (rs.next()) {
                //caso encontre libera o login
                return true;
                
            } 
            else 
            {
                //caso não encontrado tente novamente o login
                return false;
            }
        } 
        catch (SQLException e)
        {
            //throw new RuntimeException("Erro 2_D   " + e);
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null,"Erro 2_D  " + e);
        }
        return false;
    }
   
    // verifica o nivel de acesso do usuario cadastrado na base
   public LoginBean nivelAcesso(String nome, String senha)
   {
   String nivel = "1";
   //instancia da classe login bean para dar acesso a get and set
   LoginBean lb = new LoginBean();
   //string sql verificando o nível de acesso
    String sql = "select niveluser from login where binary  nomeuser=? and binary  senhauser=?";
       try 
       {
           // ps recebe string com a conexao aberta
           PreparedStatement ps = con.prepareStatement(sql);
           //setado  valor na string sql
            ps.setString(1,nome);
            ps.setString(2,senha);
            //executando  e salvando valores noresul set
            ResultSet rs = ps.executeQuery();
            // verificando valor e salvando  na variavel de loginbean para retorno
            if (rs.next()) {
           lb.setNivelUser(nivel);
           }
       } 
       catch (Exception e) 
       {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null,"Erro 3_D  " + e);
       }
       return lb;   
   }
   
   //verifica se o email ja foi cadastrado algumas vez na base de dados
   public boolean verificarLogin( String email) 
   {
        String sql = "select * from login where binary emailuser=?";
        try
        {
            // ps recebe string com a conexao aberta
            PreparedStatement ps = con.prepareStatement(sql); 
            //setado  valor na string sql
            ps.setString(1, email);
            //executando  e salvando valores noresul set
            ResultSet rs = ps.executeQuery();
            // verificando valor e salvando  na variavel de loginbean para retorno
            if (rs.next()) {
                return true;
            }
            else 
            {
                return false;
            }
        } 
        catch (SQLException e) 
        {
            //throw new RuntimeException("Erro 1_D   " + e);
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null,"Erro 2_D  " + e);
        }
        return false;
    }
}
