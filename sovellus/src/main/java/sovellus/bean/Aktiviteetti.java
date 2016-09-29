package sovellus.bean;

public class Aktiviteetti implements AktiviteettiInterface {

	private int aktiivi_id;
	private String aktiivi_nimi;
	

	public int getAktiiviId() {
		return aktiivi_id;
	}


	public void setAktiiviId(int aktiivi_id) {
		this.aktiivi_id = aktiivi_id;
	}


	public String getAktiiviNimi() {
		return aktiivi_nimi;
	}


	public void setAktiiviNimi(String aktiivi_nimi) {
		this.aktiivi_nimi = aktiivi_nimi;
	}

}
