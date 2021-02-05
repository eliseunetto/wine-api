package br.com.wine.wineapi.domain;

public class Cep {

	private Long cep;
	private CodigoLoja codLoja;

	public Cep(Long cep, CodigoLoja codLoja) {
		super();
		this.cep = cep;
		this.codLoja = codLoja;
	}

	public Long getCep() {
		return cep;
	}

	public CodigoLoja getCodLoja() {
		return codLoja;
	}

}
