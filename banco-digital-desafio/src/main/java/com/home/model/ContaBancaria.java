package com.home.model;

public abstract class ContaBancaria implements ContaBancariaInterface{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected double saldo;
    protected Cliente cliente;

    public ContaBancaria(Cliente cliente) {
        this.agencia = ContaBancaria.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo)
            throw new RuntimeException("Saldo insuficiente.");

        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, ContaBancariaInterface contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String getNomeCliente() {
        return cliente.getNome();
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
