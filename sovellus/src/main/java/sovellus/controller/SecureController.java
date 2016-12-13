package sovellus.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sovellus.bean.HarrastusImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;


@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
	@Inject
	private HarrastusDAOJdbcImpl hd;

	public HarrastusDAOJdbcImpl getHd() {
		return hd;
	}

	public void setHd(HarrastusDAOJdbcImpl hd) {
		this.hd = hd;
	}
	

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String paasivu(Model model) {
		return "secure/admin";
	}
	
	//Hae kaikki admin-sivulle
	@RequestMapping(value="/admin")
	public String listTapahtuma(Model model) throws IOException {
		List<HarrastusImpl> listTapahtuma = hd.haeKaikkiListaan();
		model.addAttribute("listTapahtuma", listTapahtuma);

		return "admin";
	}

}
