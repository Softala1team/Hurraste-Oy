package sovellus.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sovellus.bean.HarrastusImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;

@Controller
@RequestMapping(value="/secure/admin")
public class AdminController {
	
	@Inject
	private HarrastusDAOJdbcImpl hd;

	public HarrastusDAOJdbcImpl getHd() {
		return hd;
	}

	public void setHd(HarrastusDAOJdbcImpl hd) {
		this.hd = hd;
	}

	/*
	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String paasivu(Model model) {

		return "secure/admin";
	}*/
	
	@RequestMapping(value="/admin/haeKaikki", method=RequestMethod.GET)	
	public String haeKaikkiListaan(@PathVariable Model model) {
		
		//System.out.println("does this happen");
		List<HarrastusImpl> listTapahtuma = hd.haeKaikkiListaan();
		//System.out.println(listTapahtuma);
		model.addAttribute("listTapahtuma", listTapahtuma);

		return "admin";
	}
}