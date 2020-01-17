package br.com.qintes.casadocodigo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.qintes.casadocodigo.dao.AutorDao;
import br.com.qintes.casadocodigo.dao.LivroDao;
import br.com.qintes.casadocodigo.model.Autor;
import br.com.qintes.casadocodigo.model.Livro;

@Model
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext context;
	
	private List<Integer> autoresId = new ArrayList<>();
	private List<Autor> autores = new ArrayList<>();
	
	
	public List<Autor> getAutores() {
		return autorDao.listarTodos();
	}
	
	@Transactional
	public String salvar() {
		autoresId.forEach(autorId -> {
			livro.getAutores().add(new Autor(autorId));
		});
		
		dao.salvar(livro);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livro/lista?faces-redirect=true";
	}
	
	public LivroDao getDao() {
		return dao;
	}

	public void setDao(LivroDao dao) {
		this.dao = dao;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
