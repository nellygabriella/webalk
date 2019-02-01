package com.application.movie.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.application.movie.entity.Movie;
import com.application.movie.sevice.ActorService;
import com.application.movie.sevice.GenreService;
import com.application.movie.sevice.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController implements WebMvcConfigurer{
	
private MovieService movieService;
	
	private GenreService genreService;
	
	private ActorService actorService;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/movieresults").setViewName("movieresults");
	}
	
	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService= movieService;
	}
	
	@Autowired
	public void setGenreService(GenreService genreService) {
		this.genreService= genreService;
	}
	
	@Autowired
	public void setActorService(ActorService actorService) {
		this.actorService= actorService;
	}
	
	
	@GetMapping("")
	public String showForm(Model model) {
		
		if (!model.containsAttribute("movie")){
			
			model.addAttribute("movie", new Movie());
			model.addAttribute("genre", genreService.findAll());
			model.addAttribute("cast", actorService.findAll());
		}
		
		return "movieform";
	}
	
	@PostMapping("")
	public String saveMovie(@ModelAttribute("movie") @Valid Movie movie, BindingResult bindingResult, RedirectAttributes ra)
	{
		if(bindingResult.hasErrors()) {
			ra.addFlashAttribute("org.springframework.validation.BindingResult.movie", bindingResult);
			ra.addFlashAttribute("movie", movie);
			
			return "redirect:/movieform";
		}else {
			
			this.movieService.addMovie(movie);
			return "redirect:/movie/list";
			
		}
		
		
	}
	
	@GetMapping("/list")
	
	public String getAllMovie(Model model) {
		
		List<Movie> movies = movieService.getAllMovie();
		
		model.addAttribute("movies", movies);
		
		return "movielistform";
		
	}
	
	@GetMapping("/editmovie")
	public String editMovie(@RequestParam("id") Integer id, Model model)
	{
		if(!model.containsAttribute("movie")) {
			Movie movie = movieService.movieById(id);
			model.addAttribute("movie", movie);
			model.addAttribute("genre", genreService.findAll());
			model.addAttribute("cast", actorService.findAll());
		}else {
			model.addAttribute("movie");
			model.addAttribute("genre");
			model.addAttribute("cast");
		}
		
		return "movieform";
		
	}
	
	@GetMapping("/deletemovie")
	public String deleteMovie(@RequestParam("id") Integer id) {
		
		movieService.deleteMovie(id);
		
		return "redirect:/movie/list";
	}
	
	
	
	@PostMapping("/updatemovie")
	public String updateMovie(@RequestParam("id") Integer id, @Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, RedirectAttributes ra) {
		
		
		
		if(movie.getTitle()==null && bindingResult.hasErrors())
		{
			ra.addFlashAttribute("org.springframework.validation.BindingResult.movie", bindingResult);
			ra.addFlashAttribute("movie", movieService.movieById(id));
			ra.addFlashAttribute("genre", genreService.findAll());
			ra.addFlashAttribute("cast", actorService.findAll());
			return "redirect:/editmovie?id=" + id;
		}else {
			
			movieService.deleteMovie(id);
			
			this.movieService.addMovie(movie);
			return "redirect:/movie/list";
			
		}
		
	}
}
