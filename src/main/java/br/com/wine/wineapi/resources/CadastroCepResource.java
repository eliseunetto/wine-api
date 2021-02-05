package br.com.wine.wineapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wine.wineapi.domain.CadastroCep;
import br.com.wine.wineapi.services.CadastroCepService;

@RestController
@RequestMapping("/cep")
public class CadastroCepResource {

	@Autowired
	private CadastroCepService cadastroCepService;

	@GetMapping
	public ResponseEntity<List<CadastroCep>> listar() {
		List<CadastroCep> cadastroCeps = cadastroCepService.findAll();

		return ResponseEntity.ok().body(cadastroCeps);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CadastroCep> buscar(@PathVariable Long id) {
		CadastroCep cadastroCep = cadastroCepService.findById(id);
		
		return ResponseEntity.ok().body(cadastroCep);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CadastroCep> atualizar(@PathVariable Long id, @RequestBody CadastroCep cadCepAtualizado) {
		CadastroCep cadastroCep = cadastroCepService.update(id, cadCepAtualizado);
		
		return ResponseEntity.ok().body(cadastroCep);
	}
	
	@PostMapping
	public ResponseEntity<CadastroCep> adicionar(@RequestBody CadastroCep cadCepNovo) {
		CadastroCep cadastroCep = cadastroCepService.create(cadCepNovo);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cadastroCep.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CadastroCep> apagar(@PathVariable Long id) {
		cadastroCepService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
