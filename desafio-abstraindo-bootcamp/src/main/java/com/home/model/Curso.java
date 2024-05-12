package com.home.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Curso extends Conteudo{
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
}
