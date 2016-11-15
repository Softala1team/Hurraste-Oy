package sovellus.controller;


import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.AktiviteettiImpl;
import sovellus.bean.Harrastus;
import sovellus.bean.HarrastusImpl;
import sovellus.dao.AktiviteettiDAOJdbcImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;

@Controller
@RequestMapping (value="/sovellus")
public class Kontrolleri {
	
	//-----------------------------
	@Inject
	private AktiviteettiDAOJdbcImpl ad;

	public AktiviteettiDAOJdbcImpl getAd() {
		return ad;
	}

	public void setAd(AktiviteettiDAOJdbcImpl ad) {
		this.ad = ad;
	}
	

	@Inject
	private HarrastusDAOJdbcImpl hd;

	public HarrastusDAOJdbcImpl getHd() {
		return hd;
	}

	public void setHd(HarrastusDAOJdbcImpl hd) {
		this.hd = hd;
	}
	
	//------------------------------
	
	//------------------------------
	//Variaabeleita
	//------------------------------
		

	
	//Luo tyhjä lomake käyttäjälle
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
	public String luoIlmoitusLomake(Model model){
		
		Harrastus tyhja_h = new HarrastusImpl();
		tyhja_h.setTapahtuma_nimi(" ");
		
		model.addAttribute("harraste", tyhja_h);
		
		return "luo_Ilmoitus";
	}
	
	//Luo tavallisen käyttäjän luoma harraste kalenteriin.
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.POST)
	public String luoHarraste(@ModelAttribute(value="harraste") @Valid HarrastusImpl harraste, BindingResult tulos){
		
		
			try {
				hd.lisaaTapahtuma(harraste);
			} catch (Exception e) {
				return "luo_Ilmoitus";
			}
		return "index";
			
	}
	
	//Ylläpitäjän työkalu uusien harrastusten luontiin?
	@RequestMapping(value="luoAktiviteetti", method=RequestMethod.POST)
	public void luoAktiviteetti(@ModelAttribute(value="aktiviteetti") AktiviteettiImpl aktiviteetti){
		
		
	}
	
	//Hakukoodit jalkapallolle
	
	//tietty
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, Model model){
		Harrastus harrastus = hd.haeTietty(tapahtuma_id);
		model.addAttribute("harrastus", harrastus);
		
		return "tapahtuma";
	}
	
	//kaikki jsoniin
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		

		List<JsonNode> json = hd.haeTapahtumatJson();	
		model.addAttribute("json", json);
			
		return "jalkapallo";
	}
	


}
