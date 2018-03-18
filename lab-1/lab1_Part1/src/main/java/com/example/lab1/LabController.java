package com.example.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LabController {
	
	@GetMapping("/")
	public String hi(){
		return "hello";
	}
}
