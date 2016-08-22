package airsponge.com.au.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import airsponge.com.au.DTO.ChangePasswordModel;
import airsponge.com.au.DTO.WasheeRegModel;
import airsponge.com.au.entity.User;
import airsponge.com.au.service.UserService;

public class ChangePasswordController {

	
	@Autowired 
	private UserService userService;
	
	
	
	
	
}
