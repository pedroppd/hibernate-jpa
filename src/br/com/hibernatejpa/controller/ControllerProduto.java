package br.com.hibernatejpa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hibernatejpa.dao.CategoriaDao;
import br.com.hibernatejpa.dao.ProdutoDao;
import br.com.hibernatejpa.model.Categoria;
import br.com.hibernatejpa.model.Produto;


@WebServlet({"/saveProduto", "/removeProduto", "/updateProduto", "/listProduto"})
public class ControllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerProduto() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/removeProduto")) {
			try {
				remove(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(request.getServletPath().equals("/listProduto")) {
			try {
				findForUpdate(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals("/saveProduto")) {
			try {
				save(request, response);
			} catch (Exception e) {	
				e.printStackTrace();
			}
		}else if (request.getServletPath().equals("/updateProduto")) {
			try {
			update(request, response);
			} catch (Exception e) {	
				e.printStackTrace();
			}
		}
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String nome = request.getParameter("nome");
		
		String tipo = request.getParameter("tipo");
		
		//String cat = request.getParameter("categoria");
		
		//Categoria categoria = new Categoria();
		
		//categoria.setDescricao(cat);
		
		Produto produto = new Produto();
		
		produto.setId(id);
		//produto.getCategoria().setDescricao(cat);
		produto.setNome(nome);
		produto.setTipo(tipo);
		
		ProdutoDao dao = new ProdutoDao();
		
		dao.merge(produto);
		
		response.sendRedirect("produto.jsp");
		
	}


	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Produto p = new Produto();
			CategoriaDao dao = new CategoriaDao();
			int idCategoria = Integer.parseInt(request.getParameter("categorias"));
			Categoria c = dao.findById(idCategoria);
					
			String nome = request.getParameter("nome");
			String tipo = request.getParameter("tipo");
			
			p.setNome(nome);
			p.setTipo(tipo);
			p.setCategoria(c);
			
			ProdutoDao dao1 = new ProdutoDao();
			
			dao1.save(p);
			
			response.sendRedirect("produto.jsp");
		
			
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	

	private void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ProdutoDao dao = new ProdutoDao();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			dao.remove(id);
			
			response.sendRedirect("produto.jsp");
		
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	private void findForUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  HttpSession session = request.getSession();
		
	  int id = Integer.parseInt(request.getParameter("id"));
	  
	  ProdutoDao dao = new ProdutoDao();
	  
	  Produto produto = dao.findById(id);
	  
	  session.setAttribute("produto", produto);
	  
	  response.sendRedirect("updateProduto.jsp");
		
	}

	

}
