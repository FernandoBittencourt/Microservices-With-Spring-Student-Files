package com.example.lab1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@PostConstruct
	public void init(){		
		List<Team> list = new ArrayList<>();
		
	  	Team team = new Team();
	  	team.setId(0l);
	  	team.setLocation("Harlem");
	  	team.setName("Globetrotters");
	  	team.setMascot("Big G");
		list.add(team);
	  	
	  	team = new Team();
	  	team.setId(1l);
	  	team.setLocation("Washington");
	  	team.setName("Generals");
	  	list.add(team);

	  	teamRepository.saveAll(list);  	
	}
	
	@GetMapping("/teams")
	public Iterable<Team> getTeams(){		
	  	return teamRepository.findAll();
	}
}
