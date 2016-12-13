package sovellus.controller;


import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import sovellus.bean.OsallistujaImpl;
import sovellus.bean.Harrastus;
import sovellus.bean.HarrastusImpl;
import sovellus.dao.OsallistujaDAOJdbcImpl;
import sovellus.dao.HarrastusDAOJdbcImpl;

/**
 * <p>T‰m‰ on Kontrolleri, joka ohjaa sivun toimintaa.</p>
 * 
 * @author team
 * @version 1.0
 * 
 * @param ad	OsallistujaDAOJdbcTemplate-olio, jonka avulla k‰ytet‰‰n tietokantatoimintoja k‰sitelless‰ osallistujaa.
 * @param hd	HarrastusDAOJdbcTemplate-olio, jonka avulla k‰ytet‰‰n tietokantatoimintoja k‰sitelless‰ harrastuksia.
 * 
 * */
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
		

	/**
	 * <p>Metodi <code>naytaEtusivu</code> palauttaa etusivun. Ei k‰ytet‰ normaalisti.</p>
	 * 
	 * 
	 * @return palauttaa polun etusivun jsp-sivulle.
	 * 
	 * */
	
	//N‰yt‰ etusivu
	@RequestMapping(value="etusivu", method=RequestMethod.GET)
	public String naytaEtusivu(){
		
		return "index";
	}
	
	/**
	 * <p>Metodi <code>luoIlmoitusLomake</code> palauttaa tyhj‰n lomakkeen, jolla k‰ytt‰j‰ voi lis‰t‰ oman tapahtumansa.</p>
	 * 
	 * @param model		ModelMap-olio, jolla asetetaan attribuutteja jsp-sivulle.
	 * 
	 * @return palauttaa String-muotoisen polun etusivun jsp-sivulle.
	 * 
	 * */
	
	//Luo tyhj‰ ilmoituslomake k‰ytt‰j‰lle
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
	public String luoIlmoitusLomake(ModelMap model){
		
		/*Harrastus tyhja_h = new HarrastusImpl();
		tyhja_h.setTapahtuma_nimi("");*/
		
		model.addAttribute("harraste", new HarrastusImpl());
		
		return "luo_Ilmoitus";
	}
		
	
	/**
	 * <p>Metodi <code>luoHarraste</code> ottaa vastaan tapahtuman luontilomakkeeseen syˆtetyt tiedot ja yritt‰‰ lis‰t‰ ne tietokantaan.</p><br>
	 * <p>Riippuen kantaan lis‰‰misen, eli harrasteen luonnin, onnistumisesta n‰ytet‰‰n viesti. Lopuksi annetaan uusi tyhj‰ lomake.</p>
	 * 
	 * @param model		ModelMap-olio, jolla asetetaan attribuutteja jsp-sivulle.
	 * @param harraste	HarrastusImpl-olio, joka yritet‰‰n lis‰t‰ kantaan.
	 * 
	 * @return palauttaa String-muotoisen polun lomakkeen jsp-sivulle.
	 * 
	 * */
	
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
	
	
	/**
	 * <p>Metodi <code>luoOsallistumisLomake</code> palauttaa tyhj‰n lomakkeen, jolla k‰ytt‰j‰ voi osallistua tapahtumaan.</p>
	 * 
	 * @param model		ModelMap-olio, jolla asetetaan attribuutteja jsp-sivulle.
	 * 
	 * @return palauttaa String-muotoisen polun tapahtuman jsp-sivulle, jolla lomake sijaitsee.
	 * 
	 * */
	
	//Luo tyhj‰ osallistumislomake k‰ytt‰j‰lle
	@RequestMapping(value="osallistu", method=RequestMethod.GET)
	public String luoOsallistumisLomake(ModelMap model){

		model.addAttribute("osallistuja", new OsallistujaImpl());

		return "tapahtuma";
	}
	
	/**
	 * <p>Metodi <code>teeOsallistuminen</code> ottaa vastaan osallistujan lomakkeeseen syˆtetyt tiedot ja yritt‰‰ lis‰t‰ ne tietokantaan.</p><br>
	 * <p>Riippuen kantaan lis‰‰misen, eli osallistumisen lis‰‰misen, onnistumisesta n‰ytet‰‰n viesti. Lopuksi annetaan uusi tyhj‰ lomake.</p>
	 * 
	 * @param model			ModelMap-olio, jolla asetetaan attribuutteja jsp-sivulle.
	 * @param osallistuja	OsallistujaImpl-olio, joka yritet‰‰n lis‰t‰ kantaan.
	 * @param tapahtuma_id	Tapahtuma, johon osallistuja haluaa osallistua.
	 * 
	 * @return palauttaa String-muotoisen polun tapahtuman jsp-sivulle.
	 * 
	 * */
	
	//Lis‰‰ osallistuja tapahtumaan
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.POST)
	public String teeOsallistuminen(@ModelAttribute(value="{tapahtuma_id}") @Valid OsallistujaImpl osallistuja,@PathVariable Integer tapahtuma_id, ModelMap model){
		
		boolean ok = false;
				
		ok = ad.lisaaOsallistuja(osallistuja);
		
		if(ok == true){
			//model.addAttribute("vari", "DarkGreen");
			//model.addAttribute("viesti", "Olet osallistunut tapahtumaan!");
			
			//luoOsallistumisLomake(model);
		    return "redirect:/sovellus/"+tapahtuma_id;
			//^ muuten voi refreshaa sivun ja l‰hett‰‰ tiedot uudelleen ja menn‰ yli max osallistujam‰‰r‰n
		}else{
			model.addAttribute("vari", "red");
			model.addAttribute("viesti", "Osallistumisessa tapahtui virhe.");
			luoOsallistumisLomake(model);
		}
		
		haeTiettyHarrastus(tapahtuma_id, model);
		return "tapahtuma";
	}
	
	@RequestMapping(value = "/number",  method = RequestMethod.GET)
	public String category(){
	    return "number";
	}

	/**
	 * <p>Metodi <code>haeTiettyHarrastus</code> hakee tapahtuman sivulle tiedot kyseess‰ olevasta harrastuksesta kannasta. Lopuksi annetaan tyhj‰
	 * lomake <code>luoOsallistumisLomake</code>-metodilla.
	 * 
	 * @param model			ModelMap-olio, jolla asetetaan attribuutteja jsp-sivulle.
	 * @param tapahtuma_id	Tapahtuma, johon osallistuja haluaa osallistua.
	 * 
	 * @return palauttaa String-muotoisen polun tapahtuman jsp-sivulle.
	 * 
	 * @see luoOsallistumisLomake
	 * 
	 * */
		
	//Hae tietty tapahtuma
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, ModelMap model){
		
		Harrastus harrastus = hd.haeTietty(tapahtuma_id);
		model.addAttribute("harrastus", harrastus);

		List<OsallistujaImpl> osa = ad.haeOsallistujatTietysta(tapahtuma_id);

		String osallistujat="";
		int osallistujia=0;
		for (int i = 0; i < osa.size(); i++) {
			osallistujat+=osa.get(i).getEtunimi()+" "+osa.get(i).getSukunimi()+"<br>";
			osallistujia++;
		}
		model.addAttribute("osallistujat", osallistujat);
		model.addAttribute("osallistujia", osallistujia);
		
		luoOsallistumisLomake(model);
		
		return "tapahtuma";
	}
		
	/**
	 * <p>Metodi <code>haeKaikkiTietysta</code> hakee kaikki tietynlaiset tapahtumat ja tuo ne json-muodossa jsp:lle.
	 * 
	 * @param model					Model-olio, jolla asetetaan attribuutti jsp-sivulle.
	 * @param tapahtuman_tyyppi		Tapahtuman tietty tyyppi, jonka avulla se suodatetaan.
	 * 
	 * @return palauttaa String-muotoisen polun kalenterin jsp-sivulle.
	 * 
	 * */
	
	//Hae tietty tyyppi
	@RequestMapping(value="jalkapallo/{tapahtuman_tyyppi}", method=RequestMethod.GET)
	public String haeKaikkiTietysta(@PathVariable String tapahtuman_tyyppi, Model model) {
		
		List<JsonNode> json = hd.haeTapahtumatJsonTyyppi(tapahtuman_tyyppi);
		
		//osallistujam‰‰r‰t n‰kyviin. Ps. olen welho
				for (int i = 0; i < json.size(); i++) {
					List<OsallistujaImpl> osa = ad.haeOsallistujatTietysta(Integer.parseInt((json.get(i).get("tapahtuma_id")).toString()));
					((ObjectNode) json.get(i)).put("osallistujamaara", osa.size());
				}
		
		model.addAttribute("json", json);

		return "jalkapallo";
	}
	
	/**
	 * <p>Metodi <code>haeKaikkiListaan</code> hakee kaikki tapahtumat ja tuo ne listana admin-sivuille.
	 * 
	 * @param model					Model-olio, jolla asetetaan attribuutti jsp-sivulle.
	 * @param listTapahtuma			Lista, johon kootaan kaikki harrastukset.
	 * 
	 * @return palauttaa String-muotoisen polun admin-sivulle.
	 * 
	 * */
	
	//Hae kaikki admin-sivulle
	@RequestMapping(value="admin/{tapahtuman_tyyppi}", method=RequestMethod.GET)
	public String haeKaikkiListaan(@PathVariable String tapahtuman_tyyppi, Model model) {
		System.out.println("does this happen");
		List<HarrastusImpl> listTapahtuma = hd.haeKaikkiListaan();
		System.out.println(listTapahtuma);
		model.addAttribute("listTapahtuma", listTapahtuma);

		return "admin";
	}
	
	/**
	 * <p>Metodi <code>haeKaikki</code> hakee kaikki tapahtumat ja tuo ne json-muodossa jsp:lle.
	 * 
	 * @param model					Model-olio, jolla asetetaan attribuutti jsp-sivulle.
	 * @param json					JSON-objekti, johon on koottu kaikki tapahtumat/harrastukset.
	 * 
	 * @return palauttaa String-muotoisen polun kalenterin jsp-sivulle.
	 * 
	 * @see HarrastusDAOJdbcImpl
	 * 
	 * */
	
	//Hae kaikki jsoniin
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		

		List<JsonNode> json = hd.haeTapahtumatJson();
		
		//osallistujam‰‰r‰t n‰kyviin. Ps. olen welho
		for (int i = 0; i < json.size(); i++) {
			List<OsallistujaImpl> osa = ad.haeOsallistujatTietysta(Integer.parseInt((json.get(i).get("tapahtuma_id")).toString()));
			((ObjectNode) json.get(i)).put("osallistujamaara", osa.size());
		}
		
		model.addAttribute("json", json);
			
		return "jalkapallo";
	}

}
