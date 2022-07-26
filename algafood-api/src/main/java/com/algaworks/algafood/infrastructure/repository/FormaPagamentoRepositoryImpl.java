package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> listar(){
		//cria consulta e gera tipo List
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}
	
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento FormaPagamento) {
		return manager.merge(FormaPagamento);
	}
	
	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional
	@Override
	public void remover(FormaPagamento FormaPagamento) {
		FormaPagamento = buscar(FormaPagamento.getId());
		manager.remove(FormaPagamento);
	}

	
}
