package com.application.movie.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="genre")
public class Genre {
	
	Integer id;
	String genre;
	
	List<Movie> movie;
	
	
	public Genre()
	{
		
	}
	
	@Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@OneToMany(mappedBy="genre")
	public List<Movie> getMovie() {
		return movie;
	}
	
	
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
	
	
	

}
