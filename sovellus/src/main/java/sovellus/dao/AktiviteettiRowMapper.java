package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.Aktiviteetti;
import sovellus.bean.Harrastus;

public class AktiviteettiRowMapper implements RowMapper<Aktiviteetti>{


	public Aktiviteetti mapRow(ResultSet rs, int rowNumber) throws SQLException {
		//Alustetaan aktiviteetti...
				Aktiviteetti a = new Aktiviteetti();
				
				//Lis‰t‰‰n arvot
				a.setAktiiviId(rs.getInt("aktiivi_id"));
				a.setAktiiviNimi(rs.getString("aktiivi_nimi"));

				//Palautetaan valmis harrastus!
		return a;
	}

}
