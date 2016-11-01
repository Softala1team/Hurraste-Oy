package sovellus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sovellus.bean.AktiviteettiImpl;
import sovellus.bean.Harrastus;
import sovellus.bean.HarrastusImpl;
import sovellus.dao.AktiviteettiDAOJdbcImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;

@Controller
@RequestMapping (value="/sovellus")
public class Kontrolleri {
	
	//Injektoidaan AktiviteettiDAO
	@Inject
	private AktiviteettiDAOJdbcImpl ad;

	public AktiviteettiDAOJdbcImpl getAd() {
		return ad;
	}

	public void setAd(AktiviteettiDAOJdbcImpl ad) {
		this.ad = ad;
	}
	
	//------------------------------
	//Injektoidaan HarrastusDAO
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
		tyhja_h.setTapahtuma_nimi("tapahtuman nimi tähän");
		
		model.addAttribute("harraste", tyhja_h);
		
		return "luo_Ilmoitus";
	}
	
	//Luo tavallisen käyttäjän luoma harraste kalenteriin.
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.POST)
	public String luoHarraste(@ModelAttribute(value="harraste") HarrastusImpl harraste){
			
		hd.lisaaTapahtuma(harraste);
		
		return "index";	
	}
	
	//Ylläpitäjän työkalu uusien harrastusten luontiin?
	@RequestMapping(value="luoAktiviteetti", method=RequestMethod.POST)
	public void luoAktiviteetti(@ModelAttribute(value="aktiviteetti") AktiviteettiImpl aktiviteetti){
		
		
	}
	
	//Hakukoodit jalkapallolle
	
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, Model model){
		
		
		return "jalkapallo";
	}
	
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		

		List<JsonNode> json = hd.haeTapahtumatJson();	
		model.addAttribute("json", json);
			
		return "jalkapallo";
	}
	


}
