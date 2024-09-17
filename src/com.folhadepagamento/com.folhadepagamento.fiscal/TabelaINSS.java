package com.folhadepagamento.com.folhadepagamento.fiscal;

import java.util.Scanner;

public enum TabelaINSS {

	FAIXA1(0., 1412.00, 7.5, 0.),
	FAIXA2(1412.01, 2666.68, 9., 21.18),
	FAIXA3(2666.69, 4000.03, 12., 101.18),
	FAIXA4(4000.04, 7786.02, 14., 181.18);

	private Double valorMinimo;
	private Double valorMaximo;
	private Double aliquota;
	private Double deducao;
	
	TabelaINSS(Double valorMinimo, Double valorMaximo, Double aliquota, Double deducao) {
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.aliquota = aliquota;
		this.deducao = deducao;
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

	public Double getDeducao() {
		return deducao;
	}

}

// Tabela de alíquotas de 2024:
// Até R$ 1.412,00: 7.5%
// De R$ 1.412,01 até R$ 2.666,68: 9%
// De R$ 2.666,69 até R$ 4.000,03: 12%
// De R$ 4.000,04 até R$ 7.786,02: 14%
