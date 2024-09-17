package com.folhadepagamento.com.folhadepagamento.fiscal;

import com.folhadepagamento.com.folhadepagamento.entidade.Dependente;

public interface CalculosFolhaDePagamento {

    public void calcularSalarioLiquido();

    public void calcularInss();

    public void calcularValorPorDependente();

    public void calcularIR();
}

