package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Contatos_JB;
import model.DAO;

/**
 * Servlet implementation class Post
 */
@WebServlet(urlPatterns = { "/editar", "/contato_editado", "/deletar" })
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO banco = new DAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		switch(url)
		{
		case "/editar":
			Contatos_JB contato = new Contatos_JB(Integer.parseInt(request.getParameter("id")),request.getParameter("nome"),request.getParameter("telefone"),request.getParameter("email"));
			request.setAttribute("contato", contato);
			RequestDispatcher rd = request.getRequestDispatcher("editarContato.jsp");
			rd.forward(request, response);
			break;
		case "/contato_editado":
			Contatos_JB contato_editado = new Contatos_JB();
			contato_editado.setIdcontato(Integer.parseInt(request.getParameter("id")));
			contato_editado.setNome(request.getParameter("nome"));
			contato_editado.setFone(request.getParameter("telefone"));
			contato_editado.setEmail(request.getParameter("email"));
			banco.atualizarContato(contato_editado);
			response.sendRedirect("contatos");
			break;
		case "/deletar":
			int id = Integer.parseInt(request.getParameter("id"));
			banco.deletarContato(id);
			response.sendRedirect("contatos");
			break;
		}
	}
}
