package br.com.hibernatejpa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hibernatejpa.dao.CategoriaDao;
import br.com.hibernatejpa.model.Categoria;


@WebServlet({"/save", "/remove", "/update", "/list"})
public class ControllerCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerCategoria() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/update")) {   
			try {
				update(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(request.getServletPath().equals("/remove")) {
			try {
				remove(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(request.getServletPath().equals("/list")) {
			try {
				list(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		if(request.getServletPath().equals("/save")) {              //send for method save
			save(request, response);
			
		}else if(request.getServletPath().equals("/update")) {   
			try {
				update(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}




	
	
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			CategoriaDao dao = new CategoriaDao();
			dao.remove(id);
			
			response.sendRedirect("index.jsp");
			
		}catch(Exception ex) {
			throw ex;
		}
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {                                 //here we let's modify categoria
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			String descricao = request.getParameter("descricao");
			
			Categoria categoria = new Categoria();
			
			categoria.setId(id);
			categoria.setDescricao(descricao);
			
			CategoriaDao dao = new CategoriaDao();
			
			dao.merge(categoria);
			
			response.sendRedirect("index.jsp");
			
		}catch(Exception ex) {
			throw ex;
		}
	}
	

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Categoria categoria = new Categoria();
		categoria.setDescricao(request.getParameter("descricao"));
		
		CategoriaDao dao = new CategoriaDao();
		dao.save(categoria);
		
		response.sendRedirect("index.jsp");
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		//this method is for list all categoria for after can update in another form	
		try {
				
				HttpSession session = request.getSession();
			
				int id = Integer.parseInt(request.getParameter("id"));
				
				CategoriaDao dao = new CategoriaDao();
				
				Categoria categoria = dao.findById(id);
				
				session.setAttribute("categoria", categoria);
				
				
				
				response.sendRedirect("updateCategoria.jsp");
				
			}catch(Exception ex) {
				throw ex;
			}
		
	}


}
