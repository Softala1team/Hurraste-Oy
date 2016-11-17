package sovellus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.OsallistujaImpl;
import sovellus.bean.HarrastusImpl;

public class OsallistujaRowMapper implements RowMapper<OsallistujaImpl>{


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
