package com.application.movie.repository;




import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.movie.entity.Genre;


@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
	
	public List<Genre> findAll();
	public Genre findByGenre(String genre);
	public Genre findGenreById(Integer id);
	
}
