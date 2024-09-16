package com.folhadepagamento.com.folhadepagamento.entidade;

public enum TipoParentesco {

	FILHO("FILHO"),
	SOBRINHO("SOBRINHO"),
	OUTROS("OUTROS");

	private String descricao;

	TipoParentesco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao = descricao;
    }

	public static TipoParentesco obterParentesco(String descricao) {
		//Criei um método assim para que eu possa chamar na main
		//e buscar se tem ou não parentesco na linha para poder definir  se é funcionario ou dependente
		for (TipoParentesco tipoParentesco : TipoParentesco.values()) {
			if (tipoParentesco.toString().equals(descricao)) {
				return tipoParentesco;
			}
		}
		return null;
	}
	
}
