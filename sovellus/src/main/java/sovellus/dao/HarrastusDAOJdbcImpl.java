package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.HarrastusImpl;

public class HarrastusDAOJdbcImpl implements HarrastusDAO {

//-------------------------------------------
  
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//---------------------------------------------
	
	public List<HarrastusImpl> haeKaikki() {
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<HarrastusImpl> mappaaja = new HarrastusRowMapper();
		List<HarrastusImpl> harrastukset =jdbcTemplate.query(sql, mappaaja);
		
		return harrastukset;
	}

	public HarrastusImpl haeTietty(int tapahtumaId) {

		String sql = "select * from TAPAHTUMA where tapahtuma_id = ?";
		
		Object[] parametrit = new Object[] { tapahtumaId };
		RowMapper<HarrastusImpl> mappaaja = new HarrastusRowMapper();
		
	    HarrastusImpl h = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return h;
	}

	public void lisaaTapahtuma(HarrastusImpl h) {
		
		String sql="insert into TAPAHTUMA(osallistujamaara, max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, kuvaus, tapahtuma_paikka, aktiivi_id)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] parametrit = new Object[] {h.getOsallistujamaara(),h.getMax_osallistujamaara(), h.getTapahtuma_nimi(), h.getJar_nimi(),
				h.getPuh_num(), h.getEmail(), h.getTapahtuma_aika(), h.getKuvaus(), h.getTapahtuma_paikka(), h.getAktiiviId()};
		
		jdbcTemplate.update(sql, parametrit);

	}

	public void poistaTapahtuma(HarrastusImpl h) {
		
		int pois = h.getTapahtumaId();
		
		String sql="delete from TAPAHTUMA where tapahtuma_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);
		
	}

}
