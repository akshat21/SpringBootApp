package com.akshat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{aid}")
	public Optional<Alien> getById(@PathVariable("aid") int id){
		
		return repo.findById(id);
	}
	
	@PostMapping("/")
	public Alien saveAlien(Alien alien) {
		return repo.save(alien);
	}
	
	@DeleteMapping("/{aid}")
	public boolean deleteAlien(@PathVariable("aid") int id) {
		
		Optional<Alien> a = repo.findById(id);
		if(a.isPresent()) {
			Alien b = 	a.get();
			repo.delete(b);
			return true ;
		};
	
		
		return false;
		
	}
	
	@PutMapping("/{aid}")
	public boolean updateAlienName(@PathVariable("aid") int id,@RequestBody AlienRequest req) {
		
		String updateNmae = req.getName();
		int Update_Point = req.getPoints();
		
		Optional<Alien> a = repo.findById(id);
		
		if(a.isPresent()) {
			Alien b = a.get();
			b.setName(updateNmae);
			b.setPoints(Update_Point);
			repo.save(b);
			return true ;
		};
		return false;
	}
	
	

}
