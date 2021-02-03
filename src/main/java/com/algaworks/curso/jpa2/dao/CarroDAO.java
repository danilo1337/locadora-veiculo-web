package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;


public class CarroDAO implements Serializable{
	
	@Inject
	private EntityManager em;
	
	public void salvar(Carro carro) {
		em.merge(carro);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos(){
		return em.createQuery("from Carro").getResultList();
	}
	
	@Transactional
	public void excluir (Carro carro) throws NegocioException{
		Carro objeto = em.find(Carro.class, carro.getCodigo());
		objeto.getNome();
		em.remove(objeto);
		em.flush();
	}

	public Carro buscarPeloCodigo(Long codigo) {
		return em.find(Carro.class, codigo);
	}
	
}
