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
 * Servlet implementation class updateBookServlet
 */
@WebServlet("/updateBookServlet")
public class updateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookShelf bookShelf = new BookShelf();
		AuthorHelper authorHelper = new AuthorHelper();
		GenreHelper genreHelper = new GenreHelper();
		
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Integer authorId = Integer.parseInt(request.getParameter("author"));
		Integer genreId = Integer.parseInt(request.getParameter("genre"));
		
		String title = request.getParameter("title");
		
		Author author = authorHelper.searchForAuthorById(authorId);
		Genre genre = genreHelper.searchForGenreById(genreId);
		
		Book bookToUpdate = bookShelf.searchForBookById(bookId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setAuthor(author);
		bookToUpdate.setGenre(genre);
		
		bookShelf.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}
