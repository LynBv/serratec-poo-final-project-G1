package com.folhadepagamento.com.folhadepagamento.fiscal;

public enum TabelaImpostoDeRenda {

	FAIXA1(0., 2259.20, 0.),
	FAIXA2(2259.21, 2826.65, 7.5),
	FAIXA3(2826.66, 3751.05, 15.),
	FAIXA4(3751.06, 4664.68, 22.5),
	FAIXA5(4664.69, null, 27.5);

	private Double valorMinimo;
	private Double valorMaximo;
	private Double aliquota;
	
	TabelaImpostoDeRenda(Double valorMinimo, Double valorMaximo, Double aliquota) {
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.aliquota = aliquota;

	}
	
	public Double getValorMinimo() {
		return valorMinimo;

	}

	public Double getValorMaximo() {
		return valorMaximo;

	}

	public Double getAliquota() {
		return aliquota;

	}

}

// Tabela de Imposto de Renda para o ano de 2024:
// Até R$ 2.259,20: Isento
// De R$ 2.259,21 até R$ 2.826,65: 7.5%
// De R$ 2.826,66 até R$ 3.751,05: 15%
// De R$ 3.751,06 até R$ 4.664,68: 22.5%
// Acima de R$ 4.664,68: 27.5%
