package br.com.hibernatejpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.hibernatejpa.conexao.ConnectionFactory;
import br.com.hibernatejpa.dao.CategoriaDao;
import br.com.hibernatejpa.model.Categoria;

public class Categoriatest {

	public static void main(String[] args) {
		
			
		
			EntityManager em = new ConnectionFactory().getConnection();
			
			
	}

}
