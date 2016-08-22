package airsponge.com.au.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.service.WashRequestService;

@Controller
public class RequestController {
//	@ModelAttribute("washeeRequestModel")
//	public WasheeRegModel ConstructWasheeRequest()
//	{
//		return new WasheeRegModel();
//	}
//	
//	@RequestMapping(value="/user/dashboard", method=RequestMethod.POST)
//	public String doWasheRequestfromDash(@ModelAttribute("washeeRequestModel") WasheeRegModel washeeRegModel, Principal principal){
//		
//		WashRequestService.save(washeeRegModel, principal.getName());
//		//userService.RegisterWasher(washerRegModel);
//		return "redirect:/user/dashboard.html";
//	}
	
}
