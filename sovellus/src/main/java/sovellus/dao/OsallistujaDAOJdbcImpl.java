package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.OsallistujaImpl;

public class OsallistujaDAOJdbcImpl implements OsallistujaDAO {

	//JdbcTemplaten tarvitsemat konstruktorit...
	  
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
	//---------------------------------------------
	
	

	public List<OsallistujaImpl> haeKaikki() {
		
		String sql = "select * from OSALLISTUJA";
		RowMapper<OsallistujaImpl> mappaaja = new OsallistujaRowMapper();
		List<OsallistujaImpl> osallistujat =jdbcTemplate.query(sql, mappaaja);
		
		return osallistujat;
	}


	public OsallistujaImpl haeTietty(int osallistuja_id) {
		
		String sql = "select * from OSALLISTUJA where osallistuja_id = ?";
		
		Object[] parametrit = new Object[] { osallistuja_id };
		RowMapper<OsallistujaImpl> mappaaja = new OsallistujaRowMapper();
		
	    OsallistujaImpl o = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return o;
	}


	public boolean lisaaOsallistuja(OsallistujaImpl o) {
		
		boolean onnistuiko = false;
		Object[] parametrit;
		String sql="insert into OSALLISTUJA(tapahtuma_id, etunimi, sukunimi, puh_nro, email) values(?,?,?,?,?)";
		
		if(o.getEtunimi() != null || o.getSukunimi() != null || o.getPuh_nro() != null || o.getEmail() != null){
			parametrit = new Object[] {o.getTapahtuma_id(), o.getEtunimi(), o.getSukunimi(), o.getPuh_nro(), o.getEmail()};
		}else{
			return onnistuiko;
		}
		
		try {
			jdbcTemplate.update(sql, parametrit);
		
		} catch (Exception e) {
			onnistuiko = false;
			
			return onnistuiko;
		}
		onnistuiko = true;
		return onnistuiko;
	}


	public void poistaOsallistuja(OsallistujaImpl o) {
		
		int pois = o.getOsallistujaId();
		
		String sql="delete from OSALLISTUJA where osallistuja_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);		
	}

}
