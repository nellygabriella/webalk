package com.application.movie.sevice;

import java.util.List;
import java.util.Set;

import com.application.movie.entity.Actor;

public interface ActorService {

	public Actor addActor(Actor actor);
	
	public Set<Actor> findActorById(Integer id);
	
	public List<Actor> findAll();
	
	public Actor findByName(String name);
	
	public void deleteActor(Integer id);
}
