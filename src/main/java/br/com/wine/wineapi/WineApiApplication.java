package br.com.wine.wineapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wine.wineapi.domain.CadastroCep;
import br.com.wine.wineapi.domain.CodigoLoja;
import br.com.wine.wineapi.repositories.CadastroCepRepository;

@SpringBootApplication
public class WineApiApplication implements CommandLineRunner {

	@Autowired
	private CadastroCepRepository cadastroCepRepository;

	public static void main(String[] args) {
		SpringApplication.run(WineApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CadastroCep c1 = new CadastroCep(null, CodigoLoja.LOJA_PINHEIROS, 10000000L, 20000000L);
		CadastroCep c2 = new CadastroCep(null, CodigoLoja.LOJA_PINHEIROS, 20000001L, 30000000L);
		CadastroCep c3 = new CadastroCep(null, CodigoLoja.LOJA_JARDINS, 30000001L, 40000000L);
		CadastroCep c4 = new CadastroCep(null, CodigoLoja.LOJA_JARDINS, 40000001L, 50000000L);
		
		cadastroCepRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}

}
