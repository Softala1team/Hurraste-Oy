package sovellus.bean;

/**
 * <p>T�m� on Harrastuksen m��ritt�v� rajapinta. "Todellinen", validi harrastus totetuttaa v�hint��n n�m� metodit</p>
 * 
 * @author team
 * @version 1.0
 * */


public interface Harrastus {
	
	public abstract int getTapahtumaId();
	public abstract void setTapahtumaId(int tapahtuma_id);

	public abstract void setTapahtuma_nimi(String tapahtuma_nimi);
		

}
