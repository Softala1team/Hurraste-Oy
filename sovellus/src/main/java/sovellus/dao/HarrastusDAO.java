package sovellus.dao;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.HarrastusImpl;

/**
 * <p>T‰m‰ on HarrastusDAO:n m‰‰ritt‰v‰ rajapinta, eli "todellisen" HarrastusDAO:n on toteutettava n‰m‰ metodit.</p>
 * 
 * @author team
 * @version 1.0 
 * */

public interface HarrastusDAO {

	public List<HarrastusImpl> haeKaikkiListaan();
	
	public abstract List<JsonNode> haeTapahtumatJson();
	
	public abstract List<JsonNode> haeTapahtumatJsonTyyppi(String tapahtuman_tyyppi);
	
	public abstract HarrastusImpl haeTietty(int tapahtumaId);
	
	public abstract boolean lisaaTapahtuma(HarrastusImpl h);
	
	public abstract void poistaTapahtuma(HarrastusImpl h);

}
