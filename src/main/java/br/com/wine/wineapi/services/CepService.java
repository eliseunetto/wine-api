package br.com.wine.wineapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.wineapi.domain.CadastroCep;
import br.com.wine.wineapi.domain.Cep;
import br.com.wine.wineapi.repositories.CadastroCepRepository;
import br.com.wine.wineapi.services.exceptions.ObjectException;

@Service
public class CepService {

	@Autowired
	private CadastroCepRepository cadastroCepRepository;
	
	private List<CadastroCep> findAll() {
		return cadastroCepRepository.findAll();
	}
	
	public Cep findByCep(Long cep) {
		List<CadastroCep> cadsCeps = findAll();
	
		for (CadastroCep cadCep : cadsCeps) {
			if(cep >= cadCep.getFaixaInicio() && cep <= cadCep.getFaixaFim()) {
				Cep cepIdentificado = new Cep(cep, cadCep.getCodLoja());
				return cepIdentificado;
			}
		}
		throw new ObjectException("CEP: " + cep + " não foi encontrado!");
	}
}
