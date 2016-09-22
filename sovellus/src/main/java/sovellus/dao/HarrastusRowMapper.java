package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.Harrastus;

public class HarrastusRowMapper implements RowMapper<Harrastus>{

	public Harrastus mapRow(ResultSet rs, int rowNum) throws SQLException {
		//Alustetaan harrastus...
		Harrastus h = new Harrastus();
		
		//Lis�t��n arvot
		h.setTapahtumaId(rs.getInt("tapahtuma_id"));
		h.setTapahtuma_nimi(rs.getString("tapahtuma_nimi"));
		h.setOsallistujamaara(rs.getInt("osallistujamaara"));
		h.setMax_osallistujamaara(rs.getInt("max_osallistujamaara"));
		h.setJar_nimi(rs.getString("jar_nimi"));
		h.setPuh_num(rs.getString("puh_num"));
		h.setEmail(rs.getString("email"));
		h.setTapahtuma_aika(rs.getString("tapahtuma_aika"));
		h.setTapahtuma_paikka(rs.getString("tapahtuma_paikka"));
		h.setKuvaus(rs.getString("kuvaus"));
		h.setAktiiviId(rs.getInt("aktiivi_id"));
		
		//Palautetaan valmis harrastus!
		return h;
	}

}
