package com.akshat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aliens")
public class AlienResource {
	
	@Autowired
	private AlienRepo repo;
	
	@RequestMapping("/getAll")
	public List<Alien> getAliens(){
		
		List<Alien> aliens = (List<Alien>) repo.findAll();
		
		
		return aliens;
	}

}
