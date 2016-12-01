package sovellus.dao;

import java.util.List;
import sovellus.bean.OsallistujaImpl;

public interface OsallistujaDAO {
	
	public abstract List<OsallistujaImpl> haeKaikki();
	
	public abstract OsallistujaImpl haeTietty(int osallistuja_id);
	
	public abstract List<OsallistujaImpl> haeOsallistujatTietysta(int tapahtumaId);
	
	public abstract boolean lisaaOsallistuja(OsallistujaImpl o);
	
	public abstract void poistaOsallistuja(OsallistujaImpl o);

}
