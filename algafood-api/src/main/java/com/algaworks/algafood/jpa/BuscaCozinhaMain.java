package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
/*
 * Classe para testar chamadas ao banco
 */
public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		
		//inicia a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository= applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha =  cozinhaRepository.buscar(1L);
		
		System.out.printf("%d - %s", cozinha.getId(), cozinha.getNome());

	}

}
