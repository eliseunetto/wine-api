package br.com.wine.wineapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.wineapi.domain.CadastroCep;
import br.com.wine.wineapi.repositories.CadastroCepRepository;
import br.com.wine.wineapi.services.exceptions.ObjectException;

@Service
public class CadastroCepService {

	@Autowired
	private CadastroCepRepository cadastroCepRepository;
	
	public List<CadastroCep> findAll() {
		return cadastroCepRepository.findAll();
	}

	public CadastroCep findById(Long id) {
		Optional<CadastroCep> cadastroCep = cadastroCepRepository.findById(id);
		
		return cadastroCep.orElseThrow(() -> new ObjectException("Objeto não encontrato! Id: " + id + ", Tipo: " + CadastroCep.class.getName()));
	}

	public CadastroCep update(Long id, CadastroCep cadCepAtualizado) {
		CadastroCep cadastroCep = findById(id);
		cadastroCep.setCodLoja(cadCepAtualizado.getCodLoja());
		cadastroCep.setFaixaInicio(cadCepAtualizado.getFaixaInicio());
		cadastroCep.setFaixaFim(cadCepAtualizado.getFaixaFim());
		
		validateCep(cadastroCep);
		
		return cadastroCepRepository.save(cadastroCep);
	}

	public CadastroCep create(CadastroCep cadCepNovo) {
		validateCep(cadCepNovo);
		cadCepNovo.setId(null);
		return cadastroCepRepository.save(cadCepNovo);
	}

	public void delete(Long id) {
		findById(id);
		cadastroCepRepository.deleteById(id);
	}
	
	private void validateCep(CadastroCep cadCepNovo) {
		List<CadastroCep> cadsCeps = findAll();
		String msg;
		
		for (CadastroCep cadCep : cadsCeps) {
			if(cadCepNovo.getFaixaInicio() <= cadCep.getFaixaFim()) {
				msg = messageFaxaCepError(cadCep.getCodLoja().toString());
				throw new ObjectException(msg);
			}
		}
	}

	private String messageFaxaCepError(String lojaCep) {
		String[] loja = lojaCep.split("_");
		return "Erro! Essa faixa de CEP conflita com a faixa de CEP da loja de " + loja[1].substring(0, 1) + loja[1].substring(1).toLowerCase();
	}
	
}
