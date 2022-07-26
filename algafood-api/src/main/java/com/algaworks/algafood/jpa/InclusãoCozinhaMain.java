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
public class InclusãoCozinhaMain {
	
	public static void main(String[] args) {
		
		//inicia a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository= applicationContext.getBean(CozinhaRepository.class);

		Cozinha c1 = new Cozinha();
		Cozinha c2 = new Cozinha();
		c1.setNome("Brasileira");
		c2.setNome("Japonesa");
		
		c1 = cozinhaRepository.salvar(c1);
		c2 = cozinhaRepository.salvar(c2);
		
		System.out.printf("%d - %s\n", c1.getId(), c1.getNome());
		System.out.printf("%d - %s\n", c2.getId(), c2.getNome());
	}

}
