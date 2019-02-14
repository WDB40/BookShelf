package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

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
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String authorFirstName = request.getParameter("authorFirstName");
		String authorLastName = request.getParameter("authorLastName");
		String genre = request.getParameter("genre");
		
		Book bookToCheckIn = new Book(title, genre, authorFirstName, authorLastName);
		
		BookShelf bookShelf = new BookShelf();
		
		bookShelf.addBook(bookToCheckIn);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
