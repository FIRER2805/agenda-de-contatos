package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Contatos_JB;
import model.DAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/main", "/novo_contato","/contatos"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Contatos_JB contato = new Contatos_JB();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String link = request.getServletPath();
		switch (link) 
		{
			// acessar home
			case "/main":
				response.sendRedirect("novoContato.jsp");
			break;
			
			// adicionar novo contato
			case "/novo_contato":
				contato.setNome(request.getParameter("nome"));
				contato.setFone(request.getParameter("telefone"));
				contato.setEmail(request.getParameter("email"));
				dao.inserirContato(contato);
				response.sendRedirect("index.jsp");
			break;
			case "/contatos":
				ArrayList<Contatos_JB> contatos = dao.contatos();
				request.setAttribute("contatos", contatos);
				RequestDispatcher rd = request.getRequestDispatcher("contatos.jsp");
				rd.forward(request, response);
				break;
			case "/editar":
				System.out.println(request.getParameter("idContato"));
				break;
		}
	}

}
