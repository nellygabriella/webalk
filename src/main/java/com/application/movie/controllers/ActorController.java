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

import com.application.movie.entity.Actor;
import com.application.movie.model.ActorModel;
import com.application.movie.sevice.ActorService;


@Controller
@RequestMapping("/actor")
public class ActorController implements WebMvcConfigurer{
	
	private ActorService actorService;
	
	@Autowired
	public void setActorService(ActorService actorService) {
		this.actorService= actorService;
	}
	
	
	@GetMapping("")
	public String showForm(ActorModel actorModel)
	{
		return "actorform";
	}
	
	@PostMapping("")
	public String saveActor(@Valid ActorModel actorModel, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "actorform";
		}
		
		Actor actor = new Actor();
		
		actor.setName(actorModel.getName());
		System.out.println(actorModel.toString());
		
		actorService.addActor(actor);
		
		return "redirect:/actor/list";
	}
	
	@GetMapping("/list")
	@ResponseBody
	ModelAndView getAllActor() {
			
		Iterable<Actor> actorList = actorService.findAll();
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("actorlist");
		mav.addObject("actorList", actorList);
		
		return mav;
			
	}
	
	@GetMapping("deleteactor")
	public String deleteGenre(@RequestParam("id") Integer id)
	{
		actorService.deleteActor(id);
		
		return "redirect:/actor/list";
	}

}
