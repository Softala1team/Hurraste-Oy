package sovellus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sovellus.bean.Aktiviteetti;
import sovellus.bean.Harrastus;
import sovellus.dao.AktiviteettiDAO;
import sovellus.dao.HarrastusDAO;

@Controller
@RequestMapping (value="/sovellus")
public class Kontrolleri {
	
	//Injektoidaan AktiviteettiDAO
	@Inject
	private AktiviteettiDAO ad;

	public AktiviteettiDAO getAd() {
		return ad;
	}

	public void setAd(AktiviteettiDAO ad) {
		this.ad = ad;
	}
	
	//------------------------------
	//Injektoidaan HarrastusDAO
	@Inject
	private HarrastusDAO hd;

	public HarrastusDAO getHd() {
		return hd;
	}

	public void setHd(HarrastusDAO hd) {
		this.hd = hd;
	}
	
	//------------------------------
	
	//------------------------------
		//Variaabeleita
		//------------------------------
		
	/*
	private static final String VIEW_INDEX = "index";
		
		@RequestMapping(value="/index", method=RequestMethod.GET)
		public String Tervetuloa(Model model){
			
			model.addAttribute("viesti", "Tervetuloa!");
			
			return VIEW_INDEX;
		}
	*/
	
	//Luontikoodit jalkapallolle
	/*@RequestMapping(value="", method=RequestMethod.POST)
	public String luoHarrastusLomake(Model model){
		
		Harrastus dummy = new Harrastus();
		model.addAttribute("tyhja_harrastus", dummy);
		
		return "luo_Harraste";
	}*/
	@RequestMapping(value="luoIlmoitus", method=RequestMethod.GET)
	public String luoIlmoitusLomake(Model model){
		
		Aktiviteetti dummy = new Aktiviteetti();
		model.addAttribute("tyhja_aktiviteetti", dummy);
		
		return "luo_Ilmoitus";
	}
	
	//Vastaanota harrastuksen / aktiviteetin tiedot
	/*
	@RequestMapping(value="", method=RequestMethod.POST)
	public void luoHarrastus(@ModelAttribute(value="harrastus") Harrastus harraste){	
	
	
	}*/
	
	@RequestMapping(value="luoAktiviteetti", method=RequestMethod.POST)
	public void luoAktiviteetti(@ModelAttribute(value="aktiviteetti") Aktiviteetti aktiviteetti){
		
		
	}
	
	//Hakukoodit jalkapallolle
	
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, Model model){
		
		
		return "jalkapallo";
	}
	
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		
		ArrayList<Integer> ajat = new ArrayList<Integer>();
		
		for(int i=0;i<15;i++){
			
			int aika=8;
			ajat.add(aika);
			aika++;
			
		}
		
		List <Harrastus>harrasteet = hd.haeKaikki();
		model.addAttribute("harrasteet", harrasteet);
		model.addAttribute("ajat", ajat);
		
		System.out.println("||-------------------------------||");
		System.out.println("Kontrollerin listasta: "+harrasteet.get(0).getTapahtuma_nimi());
		System.out.println("||-------------------------------||");
		
		return "jalkapallo";
	}
	
	

}
