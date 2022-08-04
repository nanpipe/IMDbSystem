package cl.talentoDigital.fragmentController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

	@GetMapping("/fragments")
	public String getHome() {
		return "fragments.html";
	}

}
