package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.fiscal.CalculosFolhaDePagamento;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements CalculosFolhaDePagamento {

    private String profissao;
    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoINSS;
    private Double descontoIR;
    private Dependente numeroDependente;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String profissao, Double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.profissao = profissao;
        this.salarioBruto = salarioBruto;
    }

    public Double getDescontoIR() {
        return descontoIR;
    }

    public void setDescontoIR(Double descontoIR) {
        this.descontoIR = descontoIR;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public Double getDescontoINSS() {
        return descontoINSS;
    }

    public void setDescontoINSS(Double descontoINSS) {
        this.descontoINSS = descontoINSS;
    }

    public Dependente getNumeroDependente() {
        return numeroDependente;
    }

    public void setNumeroDependente(Dependente numeroDependente) {
        this.numeroDependente = numeroDependente;
    }
}
