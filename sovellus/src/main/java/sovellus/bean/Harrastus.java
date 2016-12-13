package sovellus.bean;

/**
 * <p>Tämä on Harrastuksen määrittävä rajapinta. "Todellinen", validi harrastus totetuttaa vähintään nämä metodit</p>
 * 
 * @author team
 * @version 1.0
 * */


public interface Harrastus {
	
	public abstract int getTapahtumaId();
	public abstract void setTapahtumaId(int tapahtuma_id);

	public abstract void setTapahtuma_nimi(String tapahtuma_nimi);
		

}
