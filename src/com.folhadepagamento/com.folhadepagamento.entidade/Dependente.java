package com.folhadepagamento.com.folhadepagamento.entidade;

import java.time.LocalDate;

public class Dependente extends Pessoa{

    private TipoParentesco tipoParentesco;


    public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco) {
        super(nome, cpf, dataNascimento);
        this.tipoParentesco = tipoParentesco;
    }

    public TipoParentesco getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(TipoParentesco tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }
}
