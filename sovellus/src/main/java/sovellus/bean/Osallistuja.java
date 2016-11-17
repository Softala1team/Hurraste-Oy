package sovellus.bean;

public interface Osallistuja {

	public abstract int getOsallistujaId();
	public abstract void setOsallistujaId(int osallistuja_id);
	
	public abstract String getEtunimi();
	public abstract void setEtunimi(String etunimi);
	
	public abstract String getSukunimi();
	public abstract void setSukunimi(String sukunimi);
	
}
