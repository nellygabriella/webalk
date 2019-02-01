package com.application.movie.sevice;




import java.util.List;

import com.application.movie.entity.Genre;


public interface GenreService {
	
	public Genre addGenre(Genre genre);
	
	public Genre findGenreById(Integer id);
	
	public List<Genre> findAll();
	
	public Genre findByGenre(String genre);
	
	public void deleteGenre(Integer id);

}
