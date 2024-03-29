package br.com.wine.wineapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CadastroCep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private CodigoLoja codLoja;

	private Long faixaInicio;
	private Long faixaFim;

	public CadastroCep() {
		super();
	}

	public CadastroCep(Long id, CodigoLoja codLoja, Long faixaInicio, Long faixaFim) {
		super();
		this.id = id;
		this.codLoja = codLoja;
		this.faixaInicio = faixaInicio;
		this.faixaFim = faixaFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CodigoLoja getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(CodigoLoja codLoja) {
		this.codLoja = codLoja;
	}

	public Long getFaixaInicio() {
		return faixaInicio;
	}

	public void setFaixaInicio(Long faixaInicio) {
		this.faixaInicio = faixaInicio;
	}

	public Long getFaixaFim() {
		return faixaFim;
	}

	public void setFaixaFim(Long faixaFim) {
		this.faixaFim = faixaFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroCep other = (CadastroCep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
