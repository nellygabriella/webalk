package com.application.movie.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.movie.entity.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer>  {
	
	public Actor findByName(String name);
	public Set<Actor> findActorById(Integer id);

}
