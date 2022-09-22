package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

//@WebServlet(urlPatterns={"/Controller","/main"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getServletPath();
		//System.out.println(action);
		if(action.equals("/main")) //comparação de string em java é feita com .equals ao invés de ==
		{
			contatos(request,response);
		} else if(action.equals("/inserir")) { 
			novoContato(request,response); // esse método deve ser criado dentro do servlet
		}
		}
	
	
	
		//Listar contatos
		protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("clientes.jsp");
			// Criando um objeto que irá receber os dados JavaBeans
			ArrayList<JavaBeans> lista = dao.listarContatos();
			// Teste de recebimento da lista
			
			
			/*for(int i = 0; i < lista.size() ;i++) {
				System.out.println(lista.get(i).getIdcon());
				System.out.println(lista.get(i).getNome());
				System.out.println(lista.get(i).getFone());
				System.out.println(lista.get(i).getEmail());
			}*/
			
			//Encaminhar a lista ao documento clientes.jsp
			request.setAttribute("contatos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
			rd.forward(request, response);
			
		} 
		
		/*dao.testeConexao();*/ //descomentar para testar a conexão
		
		//Novo contato
		protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//teste de recebimento dos dados do formulário
			
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("fone"));
			System.out.println(request.getParameter("email"));
			
			//setar as variáveis JavaBeans
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			
			//invocar o método inserirContato passando o objeto contato
			dao.inserirContato(contato);
			
			//redirecionar para o documento agenda.jsp
			response.sendRedirect("main");
		}

	

}
