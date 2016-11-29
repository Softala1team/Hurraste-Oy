package sovellus.bean;

public class OsallistujaImpl implements Osallistuja {

	private int osallistuja_id;
	private int tapahtuma_id;
	private String etunimi, sukunimi, puh_nro, email;
	

	public int getOsallistujaId() {
		return osallistuja_id;
	}


	public void setOsallistujaId(int osallistuja_id) {
		this.osallistuja_id = osallistuja_id;
	}


	public String getEtunimi() {
		return etunimi;
	}


	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}


	public int getOsallistuja_id() {
		return osallistuja_id;
	}


	public void setOsallistuja_id(int osallistuja_id) {
		this.osallistuja_id = osallistuja_id;
	}


	public String getSukunimi() {
		return sukunimi;
	}


	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}


	public String getPuh_nro() {
		return puh_nro;
	}


	public void setPuh_nro(String puh_nro) {
		this.puh_nro = puh_nro;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public int getTapahtuma_id() {
		return tapahtuma_id;
	}


	public void setTapahtuma_id(int tapahtuma_id) {
		this.tapahtuma_id = tapahtuma_id;
	}
	
	


	
	

}
