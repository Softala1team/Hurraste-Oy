package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.AktiviteettiImpl;

public class AktiviteettiDAOJdbcImpl implements AktiviteettiDAO {

	//JdbcTemplaten tarvitsemat konstruktorit...
	  
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		
	//---------------------------------------------
	
	

	public List<AktiviteettiImpl> haeKaikki() {
		
		String sql = "select * from AKTIVITEETTI";
		RowMapper<AktiviteettiImpl> mappaaja = new AktiviteettiRowMapper();
		List<AktiviteettiImpl> aktiviteetit =jdbcTemplate.query(sql, mappaaja);
		
		return aktiviteetit;
	}


	public AktiviteettiImpl haeTietty(int aktiivi_id) {
		
		String sql = "select * from AKTIVITEETTI where aktiivi_id = ?";
		
		Object[] parametrit = new Object[] { aktiivi_id };
		RowMapper<AktiviteettiImpl> mappaaja = new AktiviteettiRowMapper();
		
	    AktiviteettiImpl a = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return a;
	}


	public void lisaaAktiviteetti(AktiviteettiImpl a) {
		
		String sql="insert into AKTIVITEETTI(aktiivi_id, aktiivi_nimi) values (?, ?)";
		
		Object[] parametrit = new Object[] {a.getAktiiviId(), a.getAktiiviNimi()};
		
		jdbcTemplate.update(sql, parametrit);
	}


	public void poistaAktiviteetti(AktiviteettiImpl a) {
		
		int pois = a.getAktiiviId();
		
		String sql="delete from AKTIVITEETTI where aktiivi_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);		
	}

}
