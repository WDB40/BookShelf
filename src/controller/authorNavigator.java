package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;

/**
 * Servlet implementation class authorNavigator
 */
@WebServlet("/authorNavigator")
public class authorNavigator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorNavigator() {
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
		String action = request.getParameter("action");
		
		if(action.equals("Add")) {
			getServletContext().getRequestDispatcher("/addAuthor.jsp").forward(request, response);
		}else if(action.equals("Remove")) {	
			getServletContext().getRequestDispatcher("/removeAuthorServlet").forward(request, response);
		}else if(action.equals("Update")) {
			
			try {
				int authorID = Integer.parseInt(request.getParameter("id"));
				Author author = authorHelper.searchForAuthorById(authorID);
				
				request.setAttribute("author", author);
				
				getServletContext().getRequestDispatcher("/updateAuthor.jsp").forward(request, response);
			}
			catch(NumberFormatException exception) {
				System.out.println("Forgot to select an author.");
				getServletContext().getRequestDispatcher("/viewAllAuthorsServlet").forward(request, response);
			}
		}
	}

}
