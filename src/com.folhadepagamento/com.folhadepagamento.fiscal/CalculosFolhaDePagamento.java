package com.folhadepagamento.com.folhadepagamento.fiscal;

public interface CalculosFolhaDePagamento {
	
	public void calcularSalarioLiquido(Double salarioBruto );
	
	public void calcularInss(Double salarioBruto );
	
	public void calcularValorPorDependente(Double salarioBruto);
	
	public void calcularIR();
}
