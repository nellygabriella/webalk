package com.application.movie.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GenreModel {
	
	@NotNull
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
