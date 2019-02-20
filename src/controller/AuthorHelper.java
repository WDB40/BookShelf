package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Author;

public class AuthorHelper {
	
	private static EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("BookShelf");
	
	public void addAuthor(Author author) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Author> showAllAuthors(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Author> allAuthors = entityManager.createQuery(
										"SELECT author "
										+ "FROM Author author")
				.getResultList();
				
		return allAuthors;
	}
	
	public void removeAuthor(Author author) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Author> typedQuery = entityManager.createQuery(
															"SELECT author "
															+ "FROM Author author "
															+ "WHERE author.id = :selectedAuthorId "
																+ "and author.firstName = :selectedAuthorFirstName "
																+ "and author.lastName = :selectedAuthorLastName",
														Author.class);
		typedQuery.setParameter("selectedAuthorId", author.getId());
		typedQuery.setParameter("selectedAuthorFirstName", author.getFirstName());
		typedQuery.setParameter("selectedAuthorLastName", author.getLastName());
		
		Author result = typedQuery.getSingleResult();
		
		entityManager.remove(result);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public Author searchForAuthorById(int authorId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Author found = entityManager.find(Author.class, authorId);
		
		entityManager.close();
		
		return found;
	}
	
	public Author searchForAuthorByName(String firstName, String lastName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Author> typedQuery = entityManager.createQuery(
											"SELECT author "
											+ "FROM Author author "
											+ "WHERE author.firstName = :authorFirstName "
												+ "and author.lastName = :authorLastName",
										Author.class);
		
		typedQuery.setParameter("authorFirstName", firstName);
		typedQuery.setParameter("authorLastName", lastName);
		
		List<Author> foundAuthor = typedQuery.getResultList();
				
		entityManager.close();
		
		if(foundAuthor.isEmpty()) {
			return null;
		} else {
			return foundAuthor.get(0);
		}
	}
	
	public void updateAuthor(Author author) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(author);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void cleanUp() {
		entityManagerFactory.close();
	}

}
