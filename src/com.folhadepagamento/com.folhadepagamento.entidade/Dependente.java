package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.exceptions.DependentException;

import java.time.LocalDate;

public class Dependente extends Pessoa {

    private TipoParentesco tipoParentesco;


    public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco) {
        super(nome, cpf, dataNascimento);
        if ((dataNascimento.getYear() - LocalDate.now().getYear()) < -18) {
            throw new DependentException(nome + " tem mais de 18 anos.");
        } else {
            this.tipoParentesco = tipoParentesco;
        }
    }

    public TipoParentesco getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(TipoParentesco tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }
}
