package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genre;

/**
 * Servlet implementation class genreNavigator
 */
@WebServlet("/genreNavigator")
public class genreNavigator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public genreNavigator() {
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
		
		GenreHelper genreHelper = new GenreHelper();
		String action = request.getParameter("action");
		
		if(action.equals("Add")) {
			getServletContext().getRequestDispatcher("/addGenre.jsp").forward(request, response);
		} else if(action.equals("Remove")) {
			getServletContext().getRequestDispatcher("/removeGenreServlet").forward(request,response);
		} else if(action.equals("Update")) {
			
			try {
				int genreID = Integer.parseInt(request.getParameter("id"));
				Genre genre = genreHelper.searchForGenreById(genreID);
				
				request.setAttribute("genre", genre);
			
				getServletContext().getRequestDispatcher("/updateGenre.jsp").forward(request, response);
			} catch (NumberFormatException exception) {
				System.out.println("Forgot to select a genre.");
				getServletContext().getRequestDispatcher("/viewAllGenresServlet").forward(request, response);
			}
		}
		
	}

}
