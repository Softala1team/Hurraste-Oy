package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.OsallistujaImpl;

/**
 * <p>T‰m‰ on OsallistujaDAO:n JdbcTemplatella toteuttava luokka.</p>
 * 
 * @author team
 * @version 1.0
 * 
 * */

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
	
		/**
		 * <p>Metodi <code>haeKaikki</code> hakee tiedot osallistujista tietokannasta ja k‰ytt‰‰ OsallistujaRowMapperia tehd‰kseen listan heist‰.</p>
		 * 
		 * @param sql				Toteutettava sql-lause.
		 * @param mappaaja			Luo osallistuja-oliot, jotka lis‰t‰‰n listaan.
		 * @param osallistujat		Lista, johon mappaajan luomat oliot kootaan.
		 * 
		 * @return palauttaa listan osallistujista.
		 * 
		 * */

	public List<OsallistujaImpl> haeKaikki() {
		
		String sql = "select * from OSALLISTUJA";
		RowMapper<OsallistujaImpl> mappaaja = new OsallistujaRowMapper();
		List<OsallistujaImpl> osallistujat =jdbcTemplate.query(sql, mappaaja);
		
		return osallistujat;
	}


	/**
	 * <p>Metodi <code>haeTietty</code> hakee tiedot tietyst‰ osallistujasta tietokannasta ja k‰ytt‰‰ OsallistujaRowMapperia luodakseen h‰net.</p>
	 * 
	 * @param sql				Toteutettava sql-lause.
	 * @param parametrit		Objektilista, johon otetaan talteen osallistujan id.
	 * @param mappaaja			Luo osallistuja-olion, joka palautetaan.
	 * @param o					Olio, jonka mappaaja luo.
	 * 
	 * @return palauttaa OsallistujaImpl-olion o.
	 * 
	 * */
	
	public OsallistujaImpl haeTietty(int osallistuja_id) {
		
		String sql = "select * from OSALLISTUJA where osallistuja_id = ?";
		
		Object[] parametrit = new Object[] { osallistuja_id };
		RowMapper<OsallistujaImpl> mappaaja = new OsallistujaRowMapper();
		
	    OsallistujaImpl o = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return o;
	}
	
	public List<OsallistujaImpl> haeOsallistujatTietysta(int tapahtumaId) {
		
		String sql = "select * from OSALLISTUJA where tapahtuma_id = ?";

		Object[] parametrit = new Object[] { tapahtumaId };
		RowMapper<OsallistujaImpl> mappaaja = new OsallistujaRowMapper();
		List<OsallistujaImpl> osallistujat =jdbcTemplate.query(sql, parametrit, mappaaja);
		
		return osallistujat;
	}

	/**
	 * <p>Metodi <code>lisaaOsallistuja</code> lis‰‰ uuden osallistuja-olion tiedot tietokantaan</p>
	 * 
	 * @param onnistuiko		Boolean, jolla otetaan selville onnistuiko vai ei.
	 * @param sql				Toteutettava sql-lause.
	 * @param parametrit		Objektilista, johon otetaan talteen osallistujan tiedot.
	 * @param o					Olio, jonka mappaaja luo.
	 * 
	 * @return palauttaa booleanin, jonka avulla kutsuva taho saa selville onnistuiko kantaan lis‰ys vai ei.
	 * 
	 * */

	public boolean lisaaOsallistuja(OsallistujaImpl o) {
		
		boolean onnistuiko = false;
		String sql="insert into OSALLISTUJA(tapahtuma_id, etunimi, sukunimi, puh_nro, email) values(?,?,?,?,?)";
		
		
		Object[] parametrit = new Object[] {o.getTapahtuma_id(), o.getEtunimi(), o.getSukunimi(), o.getPuh_nro(), o.getEmail()};
		
		try {
			jdbcTemplate.update(sql, parametrit);
		
		} catch (Exception e) {
			onnistuiko = false;
			
			return onnistuiko;
		}
		onnistuiko = true;
		return onnistuiko;
	}

	/**
	 * <p>Metodi <code>poistaOsallistuja</code> ottaa vastaan poistettavan osallistujaolion ja poistaa sen jdbcTemplatella tietokannasta k‰ytt‰en osallistujan id:t‰.</p>
	 * 
	 * @param pois			Osallistujan tunnus, joka halutaan poistaa.
	 * @param o				OsallistujaImpl-olio, joka poistetaan.
	 * @param sql			Toteutettava sql-lause.
	 * 
	 * 
	 * */

	public void poistaOsallistuja(OsallistujaImpl o) {
		
		int pois = o.getOsallistujaId();
		
		String sql="delete from OSALLISTUJA where osallistuja_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);		
	}

}
