package airsponge.com.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.DTO.WasherRegModel;
import airsponge.com.au.entity.User;
import airsponge.com.au.service.UserService;


@Controller
public class UserController {
	
	
	@Autowired 
	private UserService userService;
	
	
	@ModelAttribute("washerRegModel")
	public WasherRegModel ConstructWasher()
	{
		return new WasherRegModel();
	}
	
	@ModelAttribute("washeeRegModel")
	public WasheeRegModel ConstructWashee()
	{
		return new WasheeRegModel();
	}

	
	@RequestMapping("/washerregister")
	public String showWasherRegister(Model model){
		return "washer-register";
	}
	
	
	@RequestMapping("/washeeregister")
	public String showWasheeRegister(Model model){
		return "washee-register";
		
	}
	
	
	@RequestMapping(value="/washerregister", method=RequestMethod.POST)
	public String doRegisterinControllerWasher(@ModelAttribute("washerRegModel") WasherRegModel washerRegModel){
		
		userService.RegisterWasher(washerRegModel);
		return "redirect:/washerregister.html?success=true";
	}
	
	
	@RequestMapping(value="/washeeregister", method=RequestMethod.POST)
	public String doRegisterinControllerWashee(@ModelAttribute("washeeRegModel") WasheeRegModel washeeRegModel){
		
		userService.RegisterWashee(washeeRegModel);
		return "redirect:/washeeregister.html?success=true";
	}
	

}
