package sovellus.bean;

/**
 * <p>T‰m‰ on Osallistujan m‰‰ritt‰v‰ rajapinta. "Todellinen", validi osallistuja totetuttaa v‰hint‰‰n n‰m‰ metodit</p>
 * 
 * @author team
 * @version 1.0
 * */

public interface Osallistuja {

	
	public abstract int getOsallistujaId();
	public abstract void setOsallistujaId(int osallistuja_id);

	
	public abstract String getEtunimi();
	public abstract void setEtunimi(String etunimi);

	
	public abstract String getSukunimi();
	public abstract void setSukunimi(String sukunimi);
	
}
