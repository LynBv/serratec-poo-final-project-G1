package com.folhadepagamento.com.folhadepagamento.fiscal;

import java.util.Scanner;

public enum TabelaINSS {
		
	FAIXA1(0., 1412.00, 7.5),
	FAIXA2(1412.01, 2666.68, 9),
	FAIXA3(2666.69, 4000.03, 12),
	FAIXA4(4000.04, 7786.02, 14),
	FAIXA5(7786.03, null, 14)
		
	private Double valorMinimo;
	private Double valorMaximo;
	private Double aliquota;
	
}

// Tabela de alíquotas de 2024:
// Até R$ 1.412,00: 7.5%
// De R$ 1.412,01 até R$ 2.666,68: 9%
// De R$ 2.666,69 até R$ 4.000,03: 12%
// De R$ 4.000,04 até R$ 7.786,02: 14%
