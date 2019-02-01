package com.application.movie.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.movie.entity.Movie;
import com.application.movie.repository.MovieRepository;
import com.application.movie.sevice.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	private MovieRepository movieRepository;
	
	@Autowired
	public void setMovieRepository(MovieRepository movieRepository)
	{
		this.movieRepository = movieRepository;
	}
	
	@Override
	public List<Movie> getAllMovie() {
		return this.movieRepository.findAll();
	}

	@Override
	public void addMovie(Movie movie) {
		
		this.movieRepository.save(movie);
	}

	@Override
	public List<Movie> findByGenreId(Integer id) {
		
		return movieRepository.findByGenreId(id);
		
	}

	@Override
	public Movie movieById(Integer id) {
		
		return movieRepository.getById(id);
	}

	@Override
	public void deleteMovie(Integer id) {
		
		movieRepository.deleteById(id);
	}

	@Override
	public Optional<Movie> findById(Integer id) {
		
		return movieRepository.findById(id);
	}
	
	

}
