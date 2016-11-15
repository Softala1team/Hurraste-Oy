package sovellus.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.HarrastusImpl;

public class HarrastusDAOJdbcImpl implements HarrastusDAO {

	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//---------------------------------------------
		
	public List<JsonNode> haeTapahtumatJson(){
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<JsonNode> mappaaja = new JsonKaantajaRowMapper();
		List<JsonNode> json = jdbcTemplate.query(sql, mappaaja);
		
		return json;
	}

	public HarrastusImpl haeTietty(int tapahtumaId) {

		String sql = "select * from TAPAHTUMA where tapahtuma_id = ?";
		
		Object[] parametrit = new Object[] { tapahtumaId };
		
		RowMapper<HarrastusImpl> mappaaja = new HarrastusRowMapper();
		
	    HarrastusImpl h = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return h;
	}

	public boolean lisaaTapahtuma(HarrastusImpl h) {
		
		boolean onnistui;
		final String sql="insert into TAPAHTUMA(osallistujamaara, max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, loppumis_aika, kuvaus, tapahtuma_paikka)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		

		Object[] parametrit = new Object[] {h.getOsallistujamaara(),h.getMax_osallistujamaara(), h.getTapahtuma_nimi(), h.getJar_nimi(),
				h.getPuh_num(), h.getEmail(), h.getTapahtuma_aika(), h.getLoppumis_aika(), h.getKuvaus(), h.getTapahtuma_paikka()};
		
			try {
				jdbcTemplate.update(sql, parametrit);
			} catch (Exception e) {
				onnistui = false;
				return onnistui;
			}
			onnistui = true;
			return onnistui;
	}

	public void poistaTapahtuma(HarrastusImpl h) {
		
		int pois = h.getTapahtumaId();
		
		String sql="delete from TAPAHTUMA where tapahtuma_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);
		
	}
	

}
