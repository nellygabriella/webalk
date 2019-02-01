package com.application.movie.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.application.movie.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie,Integer>{
	
	public List<Movie> findByGenreId(Integer id);
	public List<Movie> findAll();
	Movie getById(Integer id);

}
