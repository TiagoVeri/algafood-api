package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
/*
 * Classe para testar chamadas ao banco
 */
public class InclusãoRestauranteMain {
	
	public static void main(String[] args) {
		
		//inicia a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository RestauranteRepository= applicationContext.getBean(RestauranteRepository.class);

		Restaurante r1 = new Restaurante();
		Restaurante r2 = new Restaurante();
		r1.setNome("FeijoadaFood");
		r1.setTaxaFrete(new BigDecimal(2.99));
		r2.setNome("SushiFood");
		r2.setTaxaFrete(new BigDecimal(4.99));
		
		r1 = RestauranteRepository.salvar(r1);
		r2 = RestauranteRepository.salvar(r2);
		
		System.out.printf("%d - %s - %, .2f\n", r1.getId(), r1.getNome(), r1.getTaxaFrete());
		System.out.printf("%d - %s - %, .2f\n", r2.getId(), r2.getNome(), r2.getTaxaFrete());
	}

}
