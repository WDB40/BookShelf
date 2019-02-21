package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;

/**
 * Servlet implementation class addAuthorServlet
 */
@WebServlet("/addAuthorServlet")
public class addAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthorHelper authorHelper = new AuthorHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Author author = new Author(firstName, lastName);
		
		authorHelper.addAuthor(author);
		
		getServletContext().getRequestDispatcher("/viewAllAuthorsServlet").forward(request, response);
	}

}
