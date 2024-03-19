package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)	{
		
		service.addEmp(e);
		session.setAttribute("msg","Emp added sucessfully");
		return "redirect:/";
	}
	
}
