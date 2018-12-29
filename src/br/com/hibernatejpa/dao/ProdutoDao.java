package br.com.hibernatejpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hibernatejpa.conexao.ConnectionFactory;
import br.com.hibernatejpa.model.Produto;

public class ProdutoDao {
	
	public Produto save(Produto produto) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
		
			em.persist(produto);
			
			em.getTransaction().commit();

		}catch(Exception ex ) {
			em.getTransaction().rollback();
			throw ex;
		}finally {
			em.close();
		}
		
		return produto;
	}
	
	public Produto merge(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			
			em.merge(produto);
			
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			throw ex;
		}finally {
			em.close();
		}
		
		return produto;
	}
	
	
	public Produto findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;
		try {
			produto = em.find(Produto.class, id);
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			
		}
		
		return produto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;
		
		try {
			produtos = em.createQuery("from Produto p").getResultList();
			
		}catch(Exception ex ) {
			em.getTransaction().rollback();
			throw ex;
		}finally {
			em.close();
		}
		
		return produtos;
	}
	
	
	public Produto remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;
		try {
			
			produto = em.find(Produto.class, id);
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return produto;
	}
	
	
	public Produto update(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.merge(produto);
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return produto;
	}
	
	

}
