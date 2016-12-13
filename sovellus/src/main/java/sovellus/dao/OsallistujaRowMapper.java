package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.OsallistujaImpl;
import sovellus.bean.HarrastusImpl;

/**
 * <p>T‰m‰ on OsallistujaRowMapper, jonka avulla luodaan osallistuja-olio.</p>
 * 
 * @author team
 * @version 1.0
 * 
 * */

public class OsallistujaRowMapper implements RowMapper<OsallistujaImpl>{

	/**
	 * <p><code>mapRow</code> lis‰‰ kaikki saamansa tiedot OsallistujaImpl-olioon ja palauttaa olion lopuksi.</p>
	 * 
	 * @param rs		Kannasta saadut tulosrivit.
	 * @param rowNum	Tulosrivien m‰‰r‰.
	 * @param h			Luotava osallistuja-olio.
	 * */
	
	public OsallistujaImpl mapRow(ResultSet rs, int rowNumber) throws SQLException {
		
				OsallistujaImpl o = new OsallistujaImpl();
				
				//Lis‰t‰‰n arvot
				o.setEtunimi(rs.getString("etunimi"));
				o.setSukunimi(rs.getString("sukunimi"));
				o.setPuh_nro(rs.getString("puh_nro"));
				o.setEmail(rs.getString("email"));

				
		return o;
	}

}
