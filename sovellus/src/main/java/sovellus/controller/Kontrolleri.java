package sovellus.controller;


import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.OsallistujaImpl;
import sovellus.bean.Harrastus;
import sovellus.bean.HarrastusImpl;
import sovellus.dao.OsallistujaDAOJdbcImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;

@Controller
@RequestMapping (value="/sovellus")
public class Kontrolleri {
	
	//-----------------------------
	@Inject
	private OsallistujaDAOJdbcImpl ad;

	public OsallistujaDAOJdbcImpl getAd() {
		return ad;
	}

	public void setAd(OsallistujaDAOJdbcImpl ad) {
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
		

	//Näytä etusivu
	@RequestMapping(value="etusivu", method=RequestMethod.GET)
	public String naytaEtusivu(){
		
		return "index";
	}
	
	
	//Luo tyhjä lomake käyttäjälle
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
	public String luoIlmoitusLomake(Model model){
		
		Harrastus tyhja_h = new HarrastusImpl();
		tyhja_h.setTapahtuma_nimi(" ");
		
		model.addAttribute("harraste", tyhja_h);
		
		return "luo_Ilmoitus";
	}
	
	//Luo lomake, jossa oikein syötetyt tiedot ovat näkyvissä
//	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
//	public String luoIlmoitusLomake2(Model model, HarrastusImpl h){
//				
//		return "luo_Ilmoitus";
//	}
	
	//Luo tavallisen käyttäjän luoma harraste kalenteriin.
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.POST)
	public String luoHarraste(@ModelAttribute(value="harraste") @Valid HarrastusImpl harraste, Model model){
		
		boolean onnistuiko;
		
		onnistuiko = hd.lisaaTapahtuma(harraste);
			if(onnistuiko == true){
				model.addAttribute("virheviesti", "Tapahtuman lisääminen onnistui!");
				
				luoIlmoitusLomake(model);
				return "luo_Ilmoitus";
			}else{
				model.addAttribute("virheviesti", "Tapahtui virhe! Ole hyvä ja yritä uudelleen.");
				
				luoIlmoitusLomake(model);
			}
			return "luo_Ilmoitus";
}
	
	//Ylläpitäjän työkalu uusien harrastusten luontiin?
	@RequestMapping(value="luoAktiviteetti", method=RequestMethod.POST)
	public void luoAktiviteetti(@ModelAttribute(value="aktiviteetti") OsallistujaImpl aktiviteetti){
		
		
	}
	
	//Hakukoodit jalkapallolle
	
	//tietty tapahtuma
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, Model model){
		Harrastus harrastus = hd.haeTietty(tapahtuma_id);
		model.addAttribute("harrastus", harrastus);
		
		return "tapahtuma";
	}
	//tietty tyyppi
	@RequestMapping(value="jalkapallo/{tapahtuman_tyyppi}", method=RequestMethod.GET)
	public String haeKaikkiTietysta(@PathVariable String tapahtuman_tyyppi, Model model) {
		
		List<JsonNode> json = hd.haeTapahtumatJsonTyyppi(tapahtuman_tyyppi);
		model.addAttribute("json", json);

		return "jalkapallo";
	}
	
	//kaikki jsoniin
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		

		List<JsonNode> json = hd.haeTapahtumatJson();	
		model.addAttribute("json", json);
			
		return "jalkapallo";
	}
	


}
