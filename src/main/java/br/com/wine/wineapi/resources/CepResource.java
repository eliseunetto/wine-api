package br.com.wine.wineapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wine.wineapi.domain.Cep;
import br.com.wine.wineapi.services.CepService;

@RestController
@RequestMapping("/buscaCep")
public class CepResource {

	@Autowired
	private CepService cepService;
	
	@GetMapping(value = "/{cep}")
	public ResponseEntity<Cep> buscar(@PathVariable Long cep) {
		Cep cepBuscado = cepService.findByCep(cep);
		
		return ResponseEntity.ok().body(cepBuscado);
	}
}
