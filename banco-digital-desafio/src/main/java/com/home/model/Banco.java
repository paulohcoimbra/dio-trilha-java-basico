package com.home.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter @Setter @NoArgsConstructor
public class Banco {
    private String nome;
    private List<ContaBancaria> contas;

    public ContaBancaria findByAgenciaNumero(Integer agencia, Integer numero) {

        Optional<ContaBancaria> conta = contas.stream()
                            .filter(c -> c.getAgencia().equals(agencia) && c.getNumero().equals(numero))
                            .findFirst();

        if(!conta.isPresent())
            throw new RuntimeException("Conta não encontrada!");

        return conta.get();
    }

}
