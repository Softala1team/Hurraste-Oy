package sovellus.dao;

import java.util.List;
import sovellus.bean.AktiviteettiImpl;

public interface AktiviteettiDAO {
	
	public abstract List<AktiviteettiImpl> haeKaikki();
	
	public abstract AktiviteettiImpl haeTietty(int aktiivi_id);
	
	public abstract void lisaaAktiviteetti(AktiviteettiImpl a);
	
	public abstract void poistaAktiviteetti(AktiviteettiImpl a);

}
