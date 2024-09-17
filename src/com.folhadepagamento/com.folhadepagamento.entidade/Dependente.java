package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.exceptions.DependentException;

import java.time.LocalDate;
import java.time.Period;

public class Dependente extends Pessoa {

    private TipoParentesco tipoParentesco;


    public Dependente(String nome, String cpf, LocalDate dataNascimento, TipoParentesco tipoParentesco) {
        super(nome, cpf, dataNascimento);
       if (calcularIdade(dataNascimento) >= 18) {
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

    private int calcularIdade(LocalDate dataNascimento) {
        Period periodo = Period.between(dataNascimento, LocalDate.now());
        return periodo.getYears();
    }
}
