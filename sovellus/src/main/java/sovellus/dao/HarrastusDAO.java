package sovellus.dao;

import java.util.List;

import sovellus.bean.HarrastusImpl;

public interface HarrastusDAO {
	
	public abstract List<HarrastusImpl> haeKaikki();
	
	public abstract HarrastusImpl haeTietty(int tapahtumaId);
	
	public abstract void lisaaTapahtuma(HarrastusImpl h);
	
	public abstract void poistaTapahtuma(HarrastusImpl h);

}
