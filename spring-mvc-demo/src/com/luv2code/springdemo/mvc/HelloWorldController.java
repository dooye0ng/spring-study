package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String shoutDude(HttpServletRequest req, Model model) {
		String theName = req.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Hello " + theName + " !";
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}