package com.application.movie.entity;


import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="movie")
public class Movie{
	
	Integer id;
	String title;
	String description;
	int year;
	Genre genre;
	
	private Set<Actor> cast;
	
	public Movie(){}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotNull
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotNull
	@Size(min=300)
	@Column(length=10000)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotNull
	@Min(1900)
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="genre_id")
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	@ManyToMany
    @JoinTable(
    name = "movie_actor",
    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id",
    referencedColumnName = "id"))
	public Set<Actor> getCast() {
		return cast;
	}

	public void setCast(Set<Actor> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", year=" + year + ", genre="
				+ genre + ", cast=" + cast + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getDescription()=" + getDescription() + ", getYear()=" + getYear() + ", getGenre()=" + getGenre()
				+ ", getCast()=" + getCast() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
