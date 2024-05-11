package com.home.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Banco {
    private String nome;
    private List<ContaBancaria> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public ContaBancaria findByAgenciaNumero(Integer agencia, Integer numero) {

        Optional<ContaBancaria> conta = contas.stream()
                            .filter(c -> c.getAgencia().equals(agencia) && c.getNumero().equals(numero))
                            .findFirst();

        if(!conta.isPresent())
            throw new RuntimeException("Conta não encontrada!");

        return conta.get();
    }

}
