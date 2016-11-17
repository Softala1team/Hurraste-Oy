package sovellus.dao;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.HarrastusImpl;

public interface HarrastusDAO {
	
	public abstract List<JsonNode> haeTapahtumatJson();
	
	public abstract List<JsonNode> haeTapahtumatJsonTyyppi(String tapahtuman_tyyppi);
	
	public abstract HarrastusImpl haeTietty(int tapahtumaId);
	
	public abstract boolean lisaaTapahtuma(HarrastusImpl h);
	
	public abstract void poistaTapahtuma(HarrastusImpl h);

}
