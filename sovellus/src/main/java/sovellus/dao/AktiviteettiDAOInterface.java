package sovellus.dao;

import java.util.List;
import sovellus.bean.Aktiviteetti;

public interface AktiviteettiDAOInterface {
	
	public abstract List<Aktiviteetti> haeKaikki();
	
	public abstract Aktiviteetti haeTietty(int aktiivi_id);
	
	public abstract void lisaaAktiviteetti(Aktiviteetti a);
	
	public abstract void poistaAktiviteetti(Aktiviteetti a);

}
