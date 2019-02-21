package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Genre;

public class GenreHelper {
	
	private static EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("BookShelf");
	
	
	public void addGenre(Genre genre) {
		
		if(!this.genreExists(genre)) {
		
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			entityManager.persist(genre);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
	
	public List<Genre> showAllGenres(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Genre> allGenres = entityManager.createQuery(
												"SELECT genre "
												+ "FROM Genre genre")
				.getResultList();
		
		return allGenres;
	}
	
	public void removeGenre(Genre genre) {
		
		if(!this.activeGenre(genre)) {
		
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			
			TypedQuery<Genre> typedQuery = entityManager.createQuery(
															"SELECT genre "
															+ "FROM Genre genre "
															+ "WHERE genre.id = :selectedGenreId "
															+ 	"and genre.name = :selectedGenreName",
														Genre.class);
			
			typedQuery.setParameter("selectedGenreId", genre.getId());
			typedQuery.setParameter("selectedGenreName", genre.getName());
			
			Genre result = typedQuery.getSingleResult();
			
			entityManager.remove(result);
			
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
	
	public Genre searchForGenreById(int genreId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Genre found = entityManager.find(Genre.class, genreId);
		
		entityManager.close();
		
		return found;
	}
	
	public Genre searchForGenreByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Genre> typedQuery = entityManager.createQuery(
											"SELECT genre "
											+ "FROM Genre genre "
											+ "WHERE genre.name = :selectedGenreName",
										Genre.class);
		
		typedQuery.setParameter("selectedGenreName", name);
		
		List<Genre> found = typedQuery.getResultList();
		
		entityManager.close();
		
		if(found.isEmpty()) {
			return null;
		} else {
			return found.get(0);
		}
		
	}
	
	public void updateGenre(Genre genre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(genre);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	private boolean genreExists(Genre genre) {
		boolean exists = false;
		
		if(this.searchForGenreByName(genre.getName()) != null){
			exists = true;
		}
		
		return exists;
	}
	
	private boolean activeGenre(Genre genre) {
		boolean active = false;
		
		BookShelf bookShelf = new BookShelf();
		
		if(!bookShelf.searchForBookByGenre(genre).isEmpty()) {
			active = true;
		}
		
		return active;
	}
	
	public void cleanUp() {
		entityManagerFactory.close();
	}

}
