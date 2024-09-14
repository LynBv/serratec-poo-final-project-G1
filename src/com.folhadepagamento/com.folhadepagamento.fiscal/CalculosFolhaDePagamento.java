package com.folhadepagamento.com.folhadepagamento.fiscal;

import com.folhadepagamento.com.folhadepagamento.entidade.Dependente;

public interface CalculosFolhaDePagamento {
	
	public void calcularSalarioLiquido(Double salarioBruto );
	
	public void calcularInss(Double salarioBruto, TabelaINSS tabelaINSS );
	
	public void calcularValorPorDependente(Double salarioBruto, Dependente numeroDependentes);
	
	public void calcularIR(Double salarioBruto, TabelaImpostoDeRenda tabelaImpostoDeRenda );
}
