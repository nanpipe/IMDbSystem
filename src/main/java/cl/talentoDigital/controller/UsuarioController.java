package cl.talentoDigital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;

import cl.talentoDigital.model.Role;
import cl.talentoDigital.model.Usuario;
import cl.talentoDigital.service.IUsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;

	
	@GetMapping("/new/addUsuario")
	public String addUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles",Role.values());
		return "/usuario/new/addUsuario";
	}
	
	@PostMapping("/new/saveUsuario")
	public RedirectView saveUsuario(Model model, @ModelAttribute Usuario usuarioView) {
		
		usuarioService.save(usuarioView);
		return new RedirectView("/usuario/logged/usuarios");
	}
	
	@GetMapping("/logged/usuarios")
	public ModelAndView usuarios(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/usuario/logged/usuarios");
		session.setAttribute("usuariosList", usuarioService.findAll());
		modelAndView.addObject("Username", userMapped());
		return modelAndView;
	}
	
	@GetMapping("/logged/usuario")
	public String UsuarioView(Model model) {
		model.addAttribute("Username", userMapped());
		model.addAttribute("viewUsuario", usuarioService.findByUsername(userMapped()).get());
		return "usuario/logged/usuario";
	}
	
	
	@GetMapping("/logged/editUsuario")
	public String editUsuarioView(Model model) {
		model.addAttribute("Username", userMapped());
		model.addAttribute("editUsuario", usuarioService.findByUsername(userMapped()).get());
		return "usuario/logged/editUsuario";
	}
	
	@PostMapping("/logged/editUsuario")
	public RedirectView editUsuario(Model model, @ModelAttribute Usuario editUsuarioView) {
		
		Usuario usuarioDB = usuarioService.findByUsername(userMapped()).get();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(encoder.matches(editUsuarioView.getPassword(), usuarioDB.getPassword()) ||  editUsuarioView.getPassword().length()<1 ) {
			editUsuarioView.setPassword(usuarioDB.getPassword());
			editUsuarioView.setPasswordConfirmation(usuarioDB.getPasswordConfirmation());
		}
		else {
			editUsuarioView.setPassword(encoder.encode(editUsuarioView.getPassword()));
			editUsuarioView.setPasswordConfirmation(encoder.encode(editUsuarioView.getPasswordConfirmation()));
		}
		
		usuarioService.update(new Usuario(
				usuarioDB.getId(),
				usuarioDB.getUserName(),
				editUsuarioView.getEmail(),
				editUsuarioView.getPassword(),
				editUsuarioView.getPasswordConfirmation(),
				usuarioDB.getRole(),
				usuarioDB.isActive()
				));
		return new RedirectView("/usuario/logged/usuario");
	}
	
	@GetMapping("/logged/deleteUsuario")
	public RedirectView deleteUsuario(Model model, @RequestParam String userName, @ModelAttribute Usuario deleteUsuarioView) {
		model.addAttribute("usuario", new Usuario());
		usuarioService.findByUsername(userName);
		usuarioService.delete(deleteUsuarioView);
		return new RedirectView("/logged/usuarios");
	}
	
	@PostMapping("/logged/buscar")
	public String findByEmail(Model model, @RequestParam String email) {
		usuarioService.findByEmailLike(email);
		return "logged/usuarios";
	}
	
	
	// para saber que usuario esta loggeado
	public String userMapped() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
}
