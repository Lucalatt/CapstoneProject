package it.epicode.lucal.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "home";
	}

}