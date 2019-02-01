package com.application.movie.sevice;

import java.util.List;
import java.util.Optional;

import com.application.movie.entity.Movie;


public interface MovieService {
	
	public List<Movie> getAllMovie();
	public void addMovie(Movie movie);
	public List<Movie> findByGenreId(Integer id);
	public Movie movieById(Integer id);
	public void deleteMovie(Integer id);
	public Optional<Movie> findById(Integer id);

}
