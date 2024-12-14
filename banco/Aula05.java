package banco;

public class Aula05 {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setNumConta(1111);
        conta.setDono("Joao");
        conta.abrirConta("CC");
        
        Conta conta2 = new Conta();
        conta2.setNumConta(2222);
        conta2.setDono("Maria");
        conta2.abrirConta("CP");

        conta2.pagarMensal();

        conta.estadoAtual();
        conta2.estadoAtual();

    }
    

}
