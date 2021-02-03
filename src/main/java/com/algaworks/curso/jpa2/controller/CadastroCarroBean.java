package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.CadastroCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable{
	
	@Inject
	private CadastroCarroService cadastroCarroService;
	
	private Carro carro;
	
	
	public void salvar() {
		try {
			this.cadastroCarroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso");
			
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	
	@PostConstruct
	public void init() {limpar();}
	
	public void limpar() {this.carro = new Carro();}


	public Carro getCarro() {return carro;}

	public void setCarro(Carro carro) {this.carro = carro;}
	
	
}
