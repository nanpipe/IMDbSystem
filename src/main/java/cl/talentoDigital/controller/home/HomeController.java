package cl.talentoDigital.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@GetMapping("/userss")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("user/home");
	//	modelAndView.addObject("detalle", new DetalleDTO());
		modelAndView.addObject("valores", session.getAttribute("valores"));
		return modelAndView;
	}


}