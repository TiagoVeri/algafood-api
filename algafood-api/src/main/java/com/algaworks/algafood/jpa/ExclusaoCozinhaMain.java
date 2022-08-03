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
public class ExclusaoCozinhaMain {
	
	public static void main(String[] args) {
		
		//inicia a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

		Cozinha c1 = new Cozinha();
		c1.setId(1L);
		
		cozinhaRepository.remover(c1);
		
		Cozinha c2 = cozinhaRepository.buscar(1L);
		System.out.printf("%d - %s\n", c2.getId(), c2.getNome());
		
	}

}
