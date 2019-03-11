package Factory;

public class TestCon {
    public static void main(String[] args) {
         // instancia da classe para uso dos metodos
        ConectorFactory c1 = new ConectorFactory();
        //chamando o teste de conexao antes de conectar
        c1.testecon();
        // fazendo a conexao
        c1.getConnection();
        // chamando o teste novamente
        c1.testecon();
        
    }
}
    

