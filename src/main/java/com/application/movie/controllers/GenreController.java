package com.application.movie.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.application.movie.entity.Genre;
import com.application.movie.model.GenreModel;
import com.application.movie.sevice.GenreService;

@Controller
@RequestMapping("/genre")
public class GenreController implements WebMvcConfigurer{

	private GenreService genreService;
	
	@Autowired
	public void setGenreService(GenreService genreService) {
		this.genreService= genreService;
	}
	
	
	@GetMapping("")
	public String showForm(GenreModel genreModel)
	{
		return "genreform";
	}
	
	@PostMapping("")
	public String saveGenre(@Valid GenreModel genreModel, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "genreform";
		}
		
		Genre genre = new Genre();
		
		genre.setGenre(genreModel.getGenre());
		System.out.println(genreModel.toString());
		
		genreService.addGenre(genre);
		
		return "redirect:/genre/list";
	}
	
	@GetMapping("/list")
	@ResponseBody
	ModelAndView getAllGenre() {
			
		Iterable<Genre> genreList = genreService.findAll();
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("genrelist");
		mav.addObject("genreList", genreList);
		
		return mav;
			
	}
	
	@GetMapping("deletegenre")
	public String deleteGenre(@RequestParam("id") Integer id)
	{
		genreService.deleteGenre(id);
		
		return "redirect:/genre/list";
	}
	
	
	
}
