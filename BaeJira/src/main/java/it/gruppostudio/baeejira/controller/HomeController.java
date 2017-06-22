package it.gruppostudio.baeejira.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gruppostudio.baeejira.model.Role;
import it.gruppostudio.baeejira.model.User;
import it.gruppostudio.baeejira.service.RoleService;
import it.gruppostudio.baeejira.service.UserService;

@Controller
public class HomeController {

	private static final Log log = LogFactory.getLog(HomeController.class);
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
    	
    	theModel.addAttribute("pageTitle", "Crea Utente");
    	
    	return setUserForm(theModel, theUser);
    }
    
    @GetMapping(path= "/edituser/{id}")    
    public String editUser(Model theModel, @PathParam("id") String userId) {

    	User theUser = userService.getUser(new Integer(userId));

    	theModel.addAttribute("pageTitle", "Modifica Utente");
    	return setUserForm(theModel, theUser);
    }
    
    private String setUserForm(Model theModel, User theUser) {

    	theModel.addAttribute("user",theUser);
    	
    	theModel.addAttribute("roles", roleService.getRoles());
    	return "createuser";
    }
    
    @PostMapping(path="saveUser")
    public String saveuser(Model theModel, @ModelAttribute("user") @Valid User theUser, BindingResult result ){

    	log.debug(theUser);
    	
    	// WA per correggere il mapping del form
    	List<Role> userRoles = new ArrayList<>();
    	for(Role role : theUser.getRoles()) {
    		if (role.getId() == null) {
    			userRoles.add(roleService.getRole(new Integer(role.getName())));
    		} else {
    			userRoles.add(role);
    		}
    	}
    	
    	theUser.setRoles(userRoles);
    	
    	userService.saveUser(theUser);
    	
    	// TODO: rimandare alla lista utenti
    	return "redirect:/createuser";
    }
    
}
