package com.folhadepagamento.com.folhadepagamento.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteCalculos {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Elyn","1234", LocalDate.now(),6000.);
        Dependente d1 = new Dependente("ana","1234",LocalDate.now(),TipoParentesco.FILHO);
        Dependente d2 = new Dependente("ana","1234",LocalDate.now(),TipoParentesco.FILHO);
        f.adicionarDependente(d1);
        f.adicionarDependente(d2);
        f.gerarFolhaPagamento();
        System.out.println(f.toString());

    }
}
