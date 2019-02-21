package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genre;

/**
 * Servlet implementation class updateGenreServlet
 */
@WebServlet("/updateGenreServlet")
public class updateGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGenreServlet() {
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
		// TODO Auto-generated method stub
		GenreHelper genreHelper = new GenreHelper();
		
		int genreID = Integer.parseInt(request.getParameter("id"));
		Genre genre = genreHelper.searchForGenreById(genreID);
		
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		
		genre.setName(name);
		genre.setDescription(desc);
		
		genreHelper.updateGenre(genre);
		
		getServletContext().getRequestDispatcher("/viewAllGenresServlet").forward(request, response);
	}

}
