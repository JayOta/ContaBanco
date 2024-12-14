package banco;

public class Conta {
    public int numConta; // Um tipo de ID
    protected String tipo; // Tipos: CC(conta corrente) || CP(conta poupança);
    public String dono;
    public float saldo;
    public boolean status; // (Conta: aberta || Fechada)

    public void setNumConta(int num){
        this.numConta = num;
    }
    public int getNumConta(){
        return this.numConta;
    }
    public void setTipo(String tp){
        this.tipo = tp;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setDono(String d){
        this.dono = d;
    }
    public String getDono(){
        return this.dono;
    }
    public void setSaldo(float s){
        this.saldo = s;
    }
    public float getSaldo(){
        return this.saldo;
    }
    public void setStatus(boolean status){ // se conta == "aberta" -> status = true; senão -> status = false
        if(status == true){
            this.status = true;
        } else if (status == false){
            this.status = false;
        }
    }
    public boolean getStatus(){ 
        return this.status;
    }

    public Conta(){ // status = false; saldo = 0   
        this.status = false;
        setSaldo(0);
    }
    public void estadoAtual(){
        System.out.println("Informações da conta do(a): " + getDono());
        System.out.println("- Conta: " + this.getNumConta());
        System.out.println("- Tipo: " + this.getTipo());
        System.out.println("- Dono: " + this.getDono());
        System.out.println("- Saldo: " + this.getSaldo());
        System.out.println("- Status: " + this.getStatus());
        System.out.println();
    }
    public void abrirConta(String tp){ 
        // se conta == "CC" -> saldo_inicial = 50; se conta == "CP" -> saldo_inicial = 150;
        setTipo(tp);
        if(getTipo() == "CC"){
            setStatus(true);
            setSaldo(50);
            System.out.println("Conta aberta com sucesso!");
        } else if(getTipo() == "CP"){
            setStatus(true);
            setSaldo(150);
            System.out.println("Conta aberta com sucesso!");
        }
    }
    public void fecharConta(){ 
        // Dinheiro = 0; se dinheiro > 0 -> "Sacar dinheiro"; se dinheiro < 0 -> "Não é possível fechar a conta"
        if(getSaldo() > 0){
            System.out.print("Não é possível fechar a conta, saque seu dinheiro restante para fechá-la!\nDinheiro restante: " + this.saldo + "\n\n");
        }
        else if (getSaldo() < 0){
            System.out.println("A conta do(a)" + getDono() +" está individada, não é possível fechá-la!");
        } else {
            setStatus(false);
            System.out.println("A conta do(a) " + getDono() + " foi fechada com sucesso!\n");
        }
    }
    public void depositar(float din){
        setSaldo(getSaldo() + din);
        System.out.print(getDono() + " depositou R$" + din + "\nSaldo atual de: R$" + getSaldo() + "\n\n");
    }
    public void sacar(float din){
        // conta = "aberta"; se o saque for maior que o saldo -> "Não possível sacar, saldo não suficiente!"
        if(getStatus() == false){
            System.out.println("Não é possível sacar, pois sua conta está fechada");
        } else if(getStatus() == true) {
            if (din > getSaldo()){
                System.out.println("Não é possível sacar, saldo insuficiente!");
            }
            else {
                setSaldo(getSaldo() - din);
                System.out.print(getDono() + " sacou R$" + din + "\nSaldo atual de: R$" + getSaldo() + "\n\n");
            }
        }
    }
    public void pagarMensal(){
        // se conta == "CC" -> saldo -= 12; se conta == "CP" -> saldo -= 20;
        if (getTipo() == "CC"){
            setSaldo(getSaldo() - 12);
            System.out.println("O mensal do(a) " + getDono() + " foi pago com sucesso!\nSaldo atual de: R$" + getSaldo() + "\n\n");
        }
        else if (getTipo() == "CP"){
            setSaldo(getSaldo() - 20);
            System.out.println("O mensal do(a) " + getDono() + " foi pago com sucesso!\nSaldo atual de: R$" + getSaldo() + "\n\n");
        }
    }
}