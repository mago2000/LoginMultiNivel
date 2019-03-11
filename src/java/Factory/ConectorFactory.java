
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;

//classe de conexao 
public class ConectorFactory {
   
    private final String url_conexao = "jdbc:mysql://localhost/bdlogin";
    private final String usuario = "root";
    private final String senha = "";
    private Connection conexao = null;
    private boolean conectado = false;

    public Connection getConnection()
    {
        try { Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url_conexao, usuario, senha);            
            conectado = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO 1!!! Falha ao se conectar ao banco (ConnectionFactory): " + ex.getMessage());
            throw new RuntimeException("Erro em ConnectionFactory!", ex);
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO 2 !!!!  Classe não encontrada (ConnectionFactory): " + ex.getMessage());
            throw new RuntimeException("Erro em ConnectionFactory!", ex);
        }
        System.out.println(conectado);
        return conexao;
    }
    
    // teste de conexao com o banco
    public void testecon ()
    {
        if (conectado==true)
        {
            System.out.println("conectado com sucesso");
        
        }
        else
        {
            System.out.println("não conectou");
        
        }
    
    
    }
       
}
