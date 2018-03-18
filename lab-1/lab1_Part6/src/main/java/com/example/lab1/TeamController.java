package com.example.lab1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@PostConstruct
	public void init(){
		List<Team> list = new ArrayList<>();

	  	Set<Player> set = new HashSet<>();
	  	set.add(new Player("Big Easy", "Showman"));
	  	set.add(new Player("Buckets", "Guard"));
	  	set.add(new Player("Dizzy", "Guard"));
	  	
	  	list.add(new Team("Harlem", "Globetrotters", set));
	  	list.add(new Team("Washington","Generals",null));

	  	teamRepository.saveAll(list);  	
	}
	
	@GetMapping("/teams")
	public Iterable<Team> getTeams(){		
	  	return teamRepository.findAll();
	}
}
