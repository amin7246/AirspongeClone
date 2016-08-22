package airsponge.com.au.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(){
		UserDetails user = Helper.sessionCheck();
		if (user == null) {
			return "loginpage";
		} else {
			return "redirect:/logout.html";
		}
	}

}

