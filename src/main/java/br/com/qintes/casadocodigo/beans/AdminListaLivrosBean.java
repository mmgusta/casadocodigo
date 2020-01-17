package br.com.qintes.casadocodigo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.qintes.casadocodigo.dao.LivroDao;
import br.com.qintes.casadocodigo.model.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao dao;
	
	private List<Livro> livros = new ArrayList<Livro>();

	public List<Livro> getLivros() {
		this.livros = dao.listar();
		return livros;
	}
	
	

}
