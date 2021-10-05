package com.proje.person.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proje.person.DAO.PersonDAO;
import com.proje.person.model.Person;

@Controller
public class MainController {
	@Autowired
	private PersonDAO personDAO;
	@RequestMapping(value = "/")
	public String home()
	{
		
		
		return "index";
	}
	@RequestMapping(value="/list")
	public ModelAndView listPerson(ModelAndView model)
	{
		
	List<Person> listPerson=personDAO.list();
	model.addObject("listPerson",listPerson);
	model.setViewName("list");
		
		
		return model;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView RegisterPerson(ModelAndView model)
	{
		
	Person newPerson=new Person();
	model.addObject("person",newPerson);
	model.setViewName("register");
		
		
		return model;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute Person person)
	{ if(person.getId()==null) {
		personDAO.save(person);}
	else {
		personDAO.update(person);
	}
		
		
		return new ModelAndView("redirect:/list");
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView EditPerson(HttpServletRequest request )
	{
		Integer id =Integer.parseInt(request.getParameter("id"));
		Person person=personDAO.get(id);
		
		ModelAndView model=new ModelAndView("register");
		model.addObject("person",person);
		
		
		
		return model;
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView DeletePerson(@RequestParam Integer id )
	{
		
		personDAO.delete(id);
		return new ModelAndView("redirect:/list");
	}

}
