package airsponge.com.au.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping("/accessdenied")
	public String accessDenied(){
		return "accessdenied";
	}
	
	@RequestMapping("/error")
	public String error(){
		return "error";
	}
}
