package cl.talentoDigital.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@GetMapping("/login")
	public ModelAndView login(HttpSession session) {
		
		return new ModelAndView("login");
	}
}


