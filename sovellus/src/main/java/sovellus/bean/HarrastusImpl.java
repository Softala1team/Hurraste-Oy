package sovellus.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



public class HarrastusImpl implements Harrastus {
	
	private int tapahtumaId,osallistujamaara, max_osallistujamaara,
				aktiiviId;
//	
//	private String tapahtuma_nimi, jar_nimi, puh_num, email, pvm,
//					tapahtuma_aika, loppumis_aika, tapahtuma_paikka, kuvaus;
	
	@NotNull
	@Size(max=100)
	private String tapahtuma_nimi;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private String tapahtuma_aika;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private String loppumis_aika;
	
	@NotNull
	@Size(min=1, max=255)
	private String jar_nimi;
	
	@Pattern(regexp="/d{10}")
	private String puh_num;
	
	@Pattern(regexp="/w{1,30}[.]/w{1,30}[@]/w{1,50}[.]/w{2,4}")
	private String email;
	
	private String tapahtuma_paikka, kuvaus, tapahtuma_tyyppi;
	
	
	
	public String getTapahtuma_tyyppi() {
		return tapahtuma_tyyppi;
	}

	public void setTapahtuma_tyyppi(String tapahtuma_tyyppi) {
		this.tapahtuma_tyyppi = tapahtuma_tyyppi;
	}

	public String getTapahtuma_aika() {
		return tapahtuma_aika;
	}

	public void setTapahtuma_aika(String tapahtuma_aika) {
		this.tapahtuma_aika = tapahtuma_aika;
	}

	public String getTapahtuma_paikka() {
		return tapahtuma_paikka;
	}

	public void setTapahtuma_paikka(String tapahtuma_paikka) {
		this.tapahtuma_paikka = tapahtuma_paikka;
	}

	public int getTapahtumaId() {
		return tapahtumaId;
	}

	public void setTapahtumaId(int tapahtumaId) {
		this.tapahtumaId = tapahtumaId;
	}

	public int getOsallistujamaara() {
		return osallistujamaara;
	}

	public void setOsallistujamaara(int osallistujamaara) {
		this.osallistujamaara = osallistujamaara;
	}

	public int getMax_osallistujamaara() {
		return max_osallistujamaara;
	}

	public void setMax_osallistujamaara(int max_osallistujamaara) {
		this.max_osallistujamaara = max_osallistujamaara;
	}

	public int getAktiiviId() {
		return aktiiviId;
	}

	public void setAktiiviId(int aktiiviId) {
		this.aktiiviId = aktiiviId;
	}

	public String getTapahtuma_nimi() {
		return tapahtuma_nimi;
	}

	public void setTapahtuma_nimi(String tapahtuma_nimi) {
		this.tapahtuma_nimi = tapahtuma_nimi;
	}

	public String getJar_nimi() {
		return jar_nimi;
	}

	public void setJar_nimi(String jar_nimi) {
		this.jar_nimi = jar_nimi;
	}

	public String getPuh_num() {
		return puh_num;
	}

	public void setPuh_num(String puh_num) {
		this.puh_num = puh_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public String getLoppumis_aika() {
		return loppumis_aika;
	}

	public void setLoppumis_aika(String loppumis_aika) {
		this.loppumis_aika = loppumis_aika;
	}

	

	
	

}
