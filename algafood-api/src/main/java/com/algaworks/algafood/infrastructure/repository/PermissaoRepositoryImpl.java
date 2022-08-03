package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> listar(){
		//cria consulta e gera tipo List
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}
	
	@Transactional
	@Override
	public Permissao salvar(Permissao Permissao) {
		return manager.merge(Permissao);
	}
	
	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Transactional
	@Override
	public void remover(Permissao Permissao) {
		Permissao = buscar(Permissao.getId());
		manager.remove(Permissao);
	}

	
}
