package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.HarrastusImpl;

/**
 * <p>T‰m‰ on HarrastusRowMapper, jonka avulla luodaan harrastus-olio.</p>
 * 
 * @author team
 * @version 1.0
 * 
 * */

public class HarrastusRowMapper implements RowMapper<HarrastusImpl>{

	/**
	 * <p><code>mapRow</code> lis‰‰ kaikki saamansa tiedot HarrastusImpl-olioon ja palauttaa olion lopuksi.</p>
	 * 
	 * @param rs		Kannasta saadut tulosrivit.
	 * @param rowNum	Tulosrivien m‰‰r‰.
	 * @param h			Luotava harrastus-olio.
	 * */
	
	public HarrastusImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		//Alustetaan harrastus...
		HarrastusImpl h = new HarrastusImpl();
		
		//Lis‰t‰‰n arvot
		h.setTapahtumaId(rs.getInt("tapahtuma_id"));
		h.setTapahtuma_nimi(rs.getString("tapahtuma_nimi"));
		h.setTapahtuman_tyyppi(rs.getString("tapahtuman_tyyppi"));
		h.setMax_osallistujamaara(rs.getInt("max_osallistujamaara"));
		h.setJar_nimi(rs.getString("jar_nimi"));
		h.setPuh_num(rs.getString("puh_num"));
		h.setEmail(rs.getString("email"));
		h.setTapahtuma_aika(rs.getString("tapahtuma_aika"));
		h.setLoppumis_aika(rs.getString("loppumis_aika"));
		h.setTapahtuma_paikka(rs.getString("tapahtuma_paikka"));
		h.setKuvaus(rs.getString("kuvaus"));
		
		//Palautetaan valmis harrastus!
		return h;
	}

}
