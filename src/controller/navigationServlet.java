package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String action = request.getParameter("action");
		BookShelf bookShelf = new BookShelf();
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
		} else if(action.equals("Check Out")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Book bookToCheckOut = bookShelf.searchForBookById(tempId);
				bookShelf.removeBook(bookToCheckOut);
			
			} catch (NumberFormatException exception) {
				System.out.println("Forgot to select a book.");
			
			} finally {
				getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
			}
		
		} else if(action.equals("Update")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Book bookToUpdate = bookShelf.searchForBookById(tempId);
				request.setAttribute("bookToUpdate", bookToUpdate);
				getServletContext().getRequestDispatcher("/updateBook.jsp").forward(request, response);
			
			} catch(NumberFormatException exception) {
				getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
				
			}
		
		} else if(action.equals("Check In")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
