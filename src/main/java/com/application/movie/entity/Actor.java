package com.application.movie.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {
	
	
	Integer id;
	String name;
	
	private Set<Movie> movie = new HashSet<>();
	
	public Actor() {}
	
	@Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "cast")
	public Set<Movie> getMovies() {
		return movie;
	}

	public void setMovies(Set<Movie> movie) {
		this.movie = movie;
	}

}
