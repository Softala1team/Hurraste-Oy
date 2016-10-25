package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.AktiviteettiImpl;
import sovellus.bean.HarrastusImpl;

public class AktiviteettiRowMapper implements RowMapper<AktiviteettiImpl>{


	public AktiviteettiImpl mapRow(ResultSet rs, int rowNumber) throws SQLException {
		//Alustetaan aktiviteetti...
				AktiviteettiImpl a = new AktiviteettiImpl();
				
				//Lis‰t‰‰n arvot
				a.setAktiiviId(rs.getInt("aktiivi_id"));
				a.setAktiiviNimi(rs.getString("aktiivi_nimi"));

				//Palautetaan valmis harrastus!
		return a;
	}

}
