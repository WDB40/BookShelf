package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENRE")
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GENRE_ID")
	private int id;
	
	@Column(name="GENRE_NAME")
	private String name;
	
	@Column(name="GENRE_DESCRIPTION")
	private String description;

	public Genre() {
		super();
	}

	public Genre(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Genre(String name) {
		super();
		this.name = name;
		this.description = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
