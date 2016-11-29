package sovellus.controller;


import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.Osallistuja;
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
		

	//N‰yt‰ etusivu
	@RequestMapping(value="etusivu", method=RequestMethod.GET)
	public String naytaEtusivu(){
		
		return "index";
	}
	
	
	//Luo tyhj‰ ilmoituslomake k‰ytt‰j‰lle
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
	public String luoIlmoitusLomake(ModelMap model){
		
		/*Harrastus tyhja_h = new HarrastusImpl();
		tyhja_h.setTapahtuma_nimi("");*/
		
		model.addAttribute("harraste", new HarrastusImpl());
		
		return "luo_Ilmoitus";
	}
		
	
	//Luo tavallisen k‰ytt‰j‰n luoma harraste kalenteriin.
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.POST)
	public String luoHarraste(@ModelAttribute(value="harraste") @Valid HarrastusImpl harraste, ModelMap model){
		
		boolean onnistuiko;
		
		onnistuiko = hd.lisaaTapahtuma(harraste);
			if(onnistuiko == true){
				model.addAttribute("viesti", "Tapahtuman lis‰‰minen onnistui!");
				model.addAttribute("vari", "DarkGreen");
				
				luoIlmoitusLomake(model);
				
			}else{
				model.addAttribute("viesti", "Tapahtui virhe! Ole hyv‰ ja yrit‰ uudelleen.");
				model.addAttribute("vari", "red");
				
				luoIlmoitusLomake(model);
			}
			return "luo_Ilmoitus";
}
	
	//Luo tyhj‰ osallistumislomake k‰ytt‰j‰lle
	@RequestMapping(value="osallistu", method=RequestMethod.GET)
	public String luoOsallistumisLomake(ModelMap model){

		model.addAttribute("osallistuja", new OsallistujaImpl());

		return "tapahtuma";
	}
	
	//Lis‰‰ osallistuja tapahtumaan
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.POST)
	public String teeOsallistuminen(@ModelAttribute(value="{tapahtuma_id}") @Valid OsallistujaImpl osallistuja,@PathVariable Integer tapahtuma_id, ModelMap model){
		
		boolean ok = false;
				
		ok = ad.lisaaOsallistuja(osallistuja);
		
		if(ok == true){
			model.addAttribute("vari", "DarkGreen");
			model.addAttribute("viesti", "Olet osallistunut tapahtumaan!");
			
			luoOsallistumisLomake(model);
			
		}else{
			model.addAttribute("vari", "red");
			model.addAttribute("viesti", "Osallistumisessa tapahtui virhe.");
			
			luoOsallistumisLomake(model);
		}
		
		haeTiettyHarrastus(tapahtuma_id, model);
		return "tapahtuma";
	}

		
	//Hae tietty tapahtuma
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, ModelMap model){
		
		Harrastus harrastus = hd.haeTietty(tapahtuma_id);
		model.addAttribute("harrastus", harrastus);
		
		luoOsallistumisLomake(model);
		
		return "tapahtuma";
	}
		
	//Hae tietty tyyppi
	@RequestMapping(value="jalkapallo/{tapahtuman_tyyppi}", method=RequestMethod.GET)
	public String haeKaikkiTietysta(@PathVariable String tapahtuman_tyyppi, Model model) {
		
		List<JsonNode> json = hd.haeTapahtumatJsonTyyppi(tapahtuman_tyyppi);
		model.addAttribute("json", json);

		return "jalkapallo";
	}
	
	//Hae kaikki jsoniin
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		

		List<JsonNode> json = hd.haeTapahtumatJson();	
		model.addAttribute("json", json);
			
		return "jalkapallo";
	}

}
