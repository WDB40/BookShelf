package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Author;
import model.Book;
import model.Genre;

public class BookShelf {
	
	private static EntityManagerFactory entityManagerFactory 
		= Persistence.createEntityManagerFactory("BookShelf");
	
	private AuthorHelper authorHelper = new AuthorHelper();
	private GenreHelper genreHelper = new GenreHelper();
	
	public void addBook(Book book) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		book = this.setAuthor(book);
		book = this.setGenre(book);
		
		entityManager.getTransaction().begin();
		entityManager.merge(book);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Book> showAllBooks(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Book> allBooks = entityManager.createQuery(""
				+ "SELECT book "
				+ "FROM Book book")
				.getResultList();
		
		return allBooks;
	}
	
	public void removeBook(Book book) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		TypedQuery<Book> typedQuery = entityManager.createQuery(""
				+ "SELECT book "
					+ "FROM Book book "
					+ "WHERE book.id = :selectedBookId",
				Book.class);
				
		typedQuery.setParameter("selectedBookId", book.getId());
		
		Book result = typedQuery.getSingleResult();
		
		entityManager.remove(result);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	public Book searchForBookById(int bookId) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Book found = entityManager.find(Book.class, bookId);
		
		entityManager.close();
		
		return found;
	}
	
	public void updateBook(Book book) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		book = this.setAuthor(book);
		book = this.setGenre(book);
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(book);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Book> searchForBookByGenre(Genre genre){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Book> typedQuery = entityManager.createQuery(""
				+ "SELECT book "
				+ "FROM Book book "
				+ "WHERE book.genre = :selectedGenreId",
				Book.class);
		typedQuery.setParameter("selectedGenreId", genre.getId());
		
		List<Book> foundBooks = typedQuery.getResultList();
		
		entityManager.close();
		
		return foundBooks;
	}
	
	public List<Book> searchForBookByAuthor(Author author){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Book> typedQuery = entityManager.createQuery(""
				+ "SELECT book "
					+ "FROM Book book "
					+ "WHERE book.author.id = :selectedAuthorId ",
				Book.class);
		typedQuery.setParameter("selectedAuthorId", author.getId());
		
		List<Book> foundBooks = typedQuery.getResultList();
		
		entityManager.close();
		
		return foundBooks;
	}
	
	public List<Book> searchForBookByTitle(String title){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Book> typedQuery = entityManager.createQuery(""
				+ "SELECT book "
				+ "FROM Book book "
				+ "WHERE book.title = :selectedTitle",
				Book.class);
		typedQuery.setParameter("selectedTitle", title);
		
		List<Book> foundBooks = typedQuery.getResultList();
		
		entityManager.close();
		
		return foundBooks;
	}
	
	private Book setAuthor(Book book) {
		
		Author author = book.getAuthor();
		Author authorInDB = authorHelper.searchForAuthorByName(author.getFirstName(), author.getLastName());
		
		if(authorInDB != null) {
			book.setAuthor(authorInDB);
		}
		
		return book;
	}
	
	private Book setGenre(Book book) {
		Genre genre = book.getGenre();
		Genre genreInDB = genreHelper.searchForGenreByName(genre.getName());
		
		if(genreInDB != null) {
			book.setGenre(genreInDB);
		}
		return book;
	}
	
	public void cleanUp() {
		entityManagerFactory.close();
	}
}
