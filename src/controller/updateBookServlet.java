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
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		
		String authorFirstName = request.getParameter("authorFirstName");
		String authorLastName = request.getParameter("authorLastName");
		Author author = new Author(authorFirstName, authorLastName);
		
		String genreName = request.getParameter("genre");
		Genre genre = new Genre(genreName);
		
		Book bookToUpdate = bookShelf.searchForBookById(tempId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setAuthor(author);
		bookToUpdate.setGenre(genre);
		
		bookShelf.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}
