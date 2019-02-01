package com.application.movie.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.application.movie.entity.Actor;
import com.application.movie.entity.Genre;

import lombok.Data;

@Data
public class MovieModel {

	@NotNull
	private String title;
	
	@NotNull
	@Size(min=300)
	private String description;
	
	@NotNull
	@Min(1900)
	private int year;
	
	private Genre genre;
	
	private Actor actor;


	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
}
