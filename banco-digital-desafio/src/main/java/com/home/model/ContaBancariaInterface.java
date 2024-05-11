package com.home.model;

public interface ContaBancariaInterface {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, ContaBancariaInterface contaDestino);
    void imprimirExtrato();
    String getNomeCliente();
}
