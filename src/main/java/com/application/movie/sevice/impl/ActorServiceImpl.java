package com.application.movie.sevice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.movie.entity.Actor;
import com.application.movie.repository.ActorRepository;
import com.application.movie.sevice.ActorService;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public Actor addActor(Actor actor) {
		
		return actorRepository.save(actor);
	}

	@Override
	public Set<Actor> findActorById(Integer id) {
		
		return actorRepository.findActorById(id);
	}

	@Override
	public List<Actor> findAll() {
		
		Iterable<Actor> allActor = actorRepository.findAll();
		
		List<Actor> actorList =new ArrayList<>();
		for(Actor actor : allActor)
		{
			actorList.add(actor);
		}
		
		return actorList;
	}

	@Override
	public Actor findByName(String name) {
		
		return actorRepository.findByName(name);
	}

	@Override
	public void deleteActor(Integer id) {
	
		this.actorRepository.deleteById(id);
		
	}
}
