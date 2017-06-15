package it.gruppostudio.baeejira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gruppostudio.baeejira.service.RoleService;

@Controller
public class HomeController {
	// need to inject our customer service
	@Autowired
	private RoleService roleService;
	
    @RequestMapping(path= "/")    
    public String home(Model theModel){
    	theModel.addAttribute("roles", roleService.getRoles());
    	return "home";
    }
}
