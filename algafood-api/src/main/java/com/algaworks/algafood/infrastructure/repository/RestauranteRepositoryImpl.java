package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar(){
		//cria consulta e gera tipo List
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}
	
	@Transactional
	@Override
	public Restaurante salvar(Restaurante Restaurante) {
		return manager.merge(Restaurante);
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Restaurante Restaurante) {
		Restaurante = buscar(Restaurante.getId());
		manager.remove(Restaurante);
	}

	
}
