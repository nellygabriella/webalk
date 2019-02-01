package com.application.movie.sevice.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.movie.entity.Genre;
import com.application.movie.repository.GenreRepository;
import com.application.movie.sevice.GenreService;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository genreRepository;
	
	public Genre addGenre(Genre genre) {
		
		return genreRepository.save(genre);
	}
	
	public Genre findGenreById(Integer id) {
		
		return genreRepository.findGenreById(id);
	}
	
	
	@Override
	public List<Genre> findAll() {
		Iterable<Genre> allGenre = genreRepository.findAll();
		
		List<Genre> genreList =new ArrayList<>();
		for(Genre genre : allGenre)
		{
			genreList.add(genre);
		}
		
		return genreList;
	}

	@Override
	public Genre findByGenre(String genre) {
		
		return genreRepository.findByGenre(genre);
	}

	@Override
	public void deleteGenre(Integer id) {
	
		this.genreRepository.deleteById(id);
		
	}
	
	
	
	
}
