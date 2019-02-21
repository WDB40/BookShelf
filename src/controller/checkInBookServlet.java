package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;
import model.Book;
import model.Genre;

/**
 * Servlet implementation class checkInBookServlet
 */
@WebServlet("/checkInBookServlet")
public class checkInBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkInBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorHelper authorHelper = new AuthorHelper();
		GenreHelper genreHelper = new GenreHelper();
		
		String title = request.getParameter("title");
		
		int authorID = Integer.parseInt(request.getParameter("author"));
		Author author = authorHelper.searchForAuthorById(authorID);
		
		int genreID = Integer.parseInt(request.getParameter("genre"));
		Genre genre = genreHelper.searchForGenreById(genreID);
		
		Book bookToCheckIn = new Book(title, author, genre);
		
		BookShelf bookShelf = new BookShelf();
		
		bookShelf.addBook(bookToCheckIn);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
