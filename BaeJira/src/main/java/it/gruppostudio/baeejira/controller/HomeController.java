package it.gruppostudio.baeejira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gruppostudio.baeejira.model.User;
import it.gruppostudio.baeejira.service.RoleService;
import it.gruppostudio.baeejira.service.UserService;

@Controller
public class HomeController {
	// need to inject our customer service
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
    @RequestMapping(path= "/")    
    public String home(Model theModel){
    	theModel.addAttribute("roles", roleService.getRoles());
    	return "home";
    }
    
    @GetMapping(path= "/createuser")    
    public String createuser(Model theModel){
    	
    	User theUser = new User();
    	theModel.addAttribute("user",theUser);
    	return "createuser";
    }
    
    @PostMapping(path="saveUser")
    public String saveuser(@ModelAttribute("user") User theUser, Model theModel ){
    	
    	theModel.addAttribute("esito","positivo");
    	
    	userService.saveUser(theUser);
    	
    	return "createuser";
    }
    
}
