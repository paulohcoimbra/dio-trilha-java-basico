package model;

public class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public Conta() {

    }

    public Conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Olá " + this.nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "+ this.agencia +", conta "+ this.numero +" e seu saldo " + this.saldo + " já está disponível para saque.";
    }
}
