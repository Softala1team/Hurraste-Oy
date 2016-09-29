package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.Aktiviteetti;

public class AktiviteettiDAO implements AktiviteettiDAOInterface {

	//JdbcTemplaten tarvitsemat konstruktorit...
	  
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
	//---------------------------------------------
	
	

	public List<Aktiviteetti> haeKaikki() {
		
		String sql = "select * from AKTIVITEETTI";
		RowMapper<Aktiviteetti> mappaaja = new AktiviteettiRowMapper();
		List<Aktiviteetti> aktiviteetit =jdbcTemplate.query(sql, mappaaja);
		
		return aktiviteetit;
	}


	public Aktiviteetti haeTietty(int aktiivi_id) {
		
		String sql = "select * from AKTIVITEETTI where aktiivi_id = ?";
		
		Object[] parametrit = new Object[] { aktiivi_id };
		RowMapper<Aktiviteetti> mappaaja = new AktiviteettiRowMapper();
		
	    Aktiviteetti a = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return a;
	}


	public void lisaaAktiviteetti(Aktiviteetti a) {
		
		String sql="insert into AKTIVITEETTI(aktiivi_id, aktiivi_nimi) values (?, ?)";
		
		Object[] parametrit = new Object[] {a.getAktiiviId(), a.getAktiiviNimi()};
		
		jdbcTemplate.update(sql, parametrit);
	}


	public void poistaAktiviteetti(Aktiviteetti a) {
		
		int pois = a.getAktiiviId();
		
		String sql="delete from AKTIVITEETTI where aktiivi_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);		
	}

}
