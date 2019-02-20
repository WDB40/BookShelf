package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="AUTHOR")
	private Author author;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="GENRE")
	private Genre genre;
	
	public Book() {
		super();
	}

	public Book(String title, Author author, Genre genre) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}
}
