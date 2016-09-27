package sovellus.controller;

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
@RequestMapping (value="/hurraste")
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
	
	//Luontikoodit jalkapallolle
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public void luoHarrastus(@ModelAttribute(value="harrastus") Harrastus harraste){	
	
	
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public void luoAktiviteetti(@ModelAttribute(value="aktiviteetti") Aktiviteetti aktiviteetti){
		
		
	}
	
	//Hakukoodit jalkapallolle
	
	@RequestMapping(value="{tapahtuma_id}", method=RequestMethod.GET)
	public String haeTiettyHarrastus(@PathVariable Integer tapahtuma_id, Model model){
		
		
		return "jalkapallo";
	}
	
	@RequestMapping(value="jalkapallo", method=RequestMethod.GET)
	public String haeKaikki(Model model) {
		
		List <Harrastus>harrasteet = hd.haeKaikki();
		model.addAttribute("harrasteet", harrasteet);
		
		return "jalkapallo";
	}
	
	

}
