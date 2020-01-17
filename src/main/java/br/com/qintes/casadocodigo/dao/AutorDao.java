package br.com.qintes.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.qintes.casadocodigo.model.Autor;

public class AutorDao {

	@PersistenceContext
	private EntityManager em;

	public List<Autor> listarTodos() {
		return em.createQuery("select a from Autor a", Autor.class).getResultList();
	}
}
