package airsponge.com.au.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Helper {
	public static UserDetails sessionCheck() {
		Authentication session = SecurityContextHolder.getContext().getAuthentication();
		if ((session instanceof AnonymousAuthenticationToken)) {
			return null;
		} else {
			UserDetails user = (UserDetails) session.getPrincipal();
			return user;
		}
	}
}
