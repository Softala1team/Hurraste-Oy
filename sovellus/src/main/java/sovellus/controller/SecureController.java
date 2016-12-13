package sovellus.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import sovellus.bean.Harrastus;
import sovellus.bean.HarrastusImpl;
import sovellus.dao.HarrastusDAO;
import sovellus.dao.HarrastusDAOJdbcImpl;

import sovellus.bean.HarrastusImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;


@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	/**
	@Inject
	private HarrastusDAOJdbcImpl hd;

	public HarrastusDAOJdbcImpl getHd() {
		return hd;
	}

	public void setHd(HarrastusDAOJdbcImpl hd) {
		this.hd = hd;
	}
	*/
	
	@Inject
	private HarrastusDAOJdbcImpl hd;

	public HarrastusDAOJdbcImpl getHd() {
		return hd;
	}

	public void setHd(HarrastusDAOJdbcImpl hd) {
		this.hd = hd;
	}
	
	@Inject
	private HarrastusDAO dao;
	
	public HarrastusDAO getDao() {
		return dao;
	}

	public void setDao(HarrastusDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String paasivu(Model model) {
		List<HarrastusImpl> listTapahtuma = this.dao.haeKaikkiListaan();
		model.addAttribute("listTapahtuma", listTapahtuma);
		
		System.out.println(listTapahtuma);
		return "secure/admin";
	}
	
	@RequestMapping(value="{tapahtuma_id}", method = RequestMethod.GET)
	public String poistaTapahtuma(@PathVariable Integer tapahtuma_id, Model model) {
		
		HarrastusImpl h = hd.poistaTapahtuma(tapahtuma_id);
		model.addAttribute("h",h);
		return "secure/admin";
	}
	
	/**
	//Hae kaikki admin-sivulle
	@RequestMapping(value="/admin")
	public ModelAndView listTapahtuma(ModelAndView model) throws IOException {
		List<HarrastusImpl> listTapahtuma = hd.haeKaikkiListaan();
		model.addObject("listTapahtuma", listTapahtuma);
		model.setViewName("admin");

		return model;
	}*/

}
