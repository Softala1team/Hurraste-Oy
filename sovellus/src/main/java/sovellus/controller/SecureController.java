package sovellus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String paasivu(Model model) {
		return "secure/admin";
	}

}
