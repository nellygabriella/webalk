package com.application.movie.model;

import javax.validation.constraints.NotNull;

public class ActorModel {
	
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
