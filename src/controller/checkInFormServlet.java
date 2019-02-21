package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkInFormServlet
 */
@WebServlet("/checkInFormServlet")
public class checkInFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkInFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorHelper authorHelper = new AuthorHelper();
		GenreHelper genreHelper = new GenreHelper();
		
		if(!authorHelper.showAllAuthors().isEmpty()) {
			request.setAttribute("allAuthors", authorHelper.showAllAuthors());
		} else {
			request.setAttribute("allAuthors", " ");
		}
		
		if(!genreHelper.showAllGenres().isEmpty()) {
			request.setAttribute("allGenres", genreHelper.showAllGenres());
		} else {
			request.setAttribute("allGenres", " ");
		}
		
		getServletContext().getRequestDispatcher("/addBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
