package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sovellus.bean.Harrastus;

public class HarrastusDAO implements HarrastusDAOInterface {

//JdbcTemplaten tarvitsemat konstruktorit...
  
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//---------------------------------------------
	
	public List<Harrastus> haeKaikki() {
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<Harrastus> mappaaja = new HarrastusRowMapper();
		List<Harrastus> harrastukset =jdbcTemplate.query(sql, mappaaja);
		
		return harrastukset;
	}

	public Harrastus haeTietty(int tapahtumaId) {

		String sql = "select * from TAPAHTUMA where tapahtuma_id = ?";
		
		Object[] parametrit = new Object[] { tapahtumaId };
		RowMapper<Harrastus> mappaaja = new HarrastusRowMapper();
		
	    Harrastus h = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return h;
	}

	public int lisaaTapahtuma(Harrastus h) {
		
		String sql="insert into TAPAHTUMA(osallistujamaara, max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, kuvaus, tapahtuma_paikka, aktiivi_id)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] parametrit = new Object[] {h.getOsallistujamaara(),h.getMax_osallistujamaara(), h.getTapahtuma_nimi(), h.getJar_nimi(),
				h.getPuh_num(), h.getEmail(), h.getTapahtuma_aika(), h.getKuvaus(), h.getTapahtuma_paikka(), h.getAktiiviId()};
		
		jdbcTemplate.update(sql, parametrit);

		return 0;
	}

	public void poistaTapahtuma(Harrastus h) {
		
		int pois = h.getTapahtumaId();
		
		String sql="delete from TAPAHTUMA where tapahtuma_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);
		
	}

}
