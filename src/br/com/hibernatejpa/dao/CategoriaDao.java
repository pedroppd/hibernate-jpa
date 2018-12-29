package br.com.hibernatejpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hibernatejpa.conexao.ConnectionFactory;
import br.com.hibernatejpa.model.Categoria;

public class CategoriaDao {

	
	//Method for save item in entity
	public Categoria save(Categoria c) {

		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return c;

	}
	
	
	//Method for update or save 
	public Categoria merge(Categoria c) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			
		}finally {
			em.close();
		}
		return c;
    }
	
	//method for find item of table by id
	public Categoria findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria =null;
		try {
			
			categoria = em.find(Categoria.class, id);
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			throw ex;
		}finally {
			em.close();
		}
		
		return categoria;
	}
	
	//Method for list all item of entity
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll(){
		
		EntityManager em = new ConnectionFactory().getConnection();
		List<Categoria> categorias =null;
		
		try {
			categorias = em.createQuery("from Categoria c").getResultList();
			
			
		}catch(Exception ex) {
			throw ex;
		}finally {
			em.close();
		}
		
		return categorias;
		
	}
	
	
	
	//Method for remove one item of entity
	public Categoria remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = null;
		try {
			 categoria = em.find(Categoria.class, id);
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			
			em.getTransaction().rollback();
			
		}finally {
			em.close();
			
		}
		
		return categoria;
	}
	
	
	
	
	
	

}



