package sovellus.dao;

import java.util.List;
import sovellus.bean.OsallistujaImpl;

public interface OsallistujaDAO {
	
	public abstract List<OsallistujaImpl> haeKaikki();
	
	public abstract OsallistujaImpl haeTietty(int osallistuja_id);
	
	public abstract boolean lisaaOsallistuja(OsallistujaImpl o, int osallisena_tapahtumaa);
	
	public abstract void poistaOsallistuja(OsallistujaImpl o);

}
