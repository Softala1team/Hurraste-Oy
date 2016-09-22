package sovellus.dao;

import java.util.List;

import sovellus.bean.Harrastus;

public interface HarrastusDAOInterface {
	
	public abstract List<Harrastus> haeKaikki();
	
	public abstract Harrastus haeTietty(int tapahtumaId);
	
	public abstract void lisaaTapahtuma(Harrastus h);
	
	public abstract void poistaTapahtuma(Harrastus h);

}
