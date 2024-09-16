package com.folhadepagamento.com.folhadepagamento.fiscal;

import com.folhadepagamento.com.folhadepagamento.entidade.Dependente;

public interface CalculosFolhaDePagamento {

    public void calcularSalarioLiquido();

    public Double calcularInss();

    public Double calcularValorPorDependente();

    public Double calcularIR();
}

