package sovellus.dao;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.HarrastusImpl;

public interface HarrastusDAO {
	
	public abstract List<JsonNode> haeTapahtumatJson();
	
	public abstract HarrastusImpl haeTietty(int tapahtumaId);
	
	public abstract boolean lisaaTapahtuma(HarrastusImpl h);
	
	public abstract void poistaTapahtuma(HarrastusImpl h);

}
