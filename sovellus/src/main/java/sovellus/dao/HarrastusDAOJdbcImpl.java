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
		
		String sql = "select * from TAPAHTUMA where hyvaksytty is not null";
		RowMapper<JsonNode> mappaaja = new JsonKaantajaRowMapper();
		List<JsonNode> json = jdbcTemplate.query(sql, mappaaja);
		
		return json;
	}
	
	public List<HarrastusImpl> haeKaikkiListaan(){
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<HarrastusImpl> map = new HarrastusRowMapper();
		List<HarrastusImpl> harrastukset = jdbcTemplate.query(sql, map);
		System.out.println(harrastukset);
		
		return harrastukset;
	}
	
/**	public List<HarrastusImpl> haeKaikkiAdminille(){
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<HarrastusImpl> map = new HarrastusRowMapper();
		List<HarrastusImpl> adminille = jdbcTemplate.query(sql, map);
		
		return adminille;
	}*/
	
	public List<JsonNode> haeTapahtumatJsonTyyppi(String tapahtuman_tyyppi){
		
		String sql = "select * from TAPAHTUMA where tapahtuman_tyyppi = ? and hyvaksytty is not null";
		Object[] parametrit = new Object[] { tapahtuman_tyyppi };
		RowMapper<JsonNode> mappaaja = new JsonKaantajaRowMapper();
		List<JsonNode> json = jdbcTemplate.query(sql, parametrit, mappaaja);
		
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
		final String sql="insert into TAPAHTUMA(max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, loppumis_aika, kuvaus, tapahtuma_paikka, tapahtuman_tyyppi)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		

		Object[] parametrit = new Object[] {h.getMax_osallistujamaara(), h.getTapahtuma_nimi(), h.getJar_nimi(),
				h.getPuh_num(), h.getEmail(), h.getTapahtuma_aika(), h.getLoppumis_aika(), h.getKuvaus(), h.getTapahtuma_paikka(), h.getTapahtuman_tyyppi()};
		
				
//		List<String> status = new ArrayList<String>();
//		
//		for (int i=0;i<parametrit.length;i++){
//			if(parametrit[i] == ""){
//				status.add("tyhja"+i);
//			}else if(parametrit[i] != ""){
//				status.add("taysi"+i);
//			}
//		}
		
		
			try {
				jdbcTemplate.update(sql, parametrit);
			
			} catch (Exception e) {
				onnistui = false;
				return onnistui;
			}
			onnistui = true;
			return onnistui;
	}

	/*public void poistaTapahtuma(int tapahtumaId) {
		
		int pois = h.getTapahtumaId();
		
		System.out.println("Look at this");
		
		String sql="delete from TAPAHTUMA where tapahtuma_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);
		
	}*/
	
	
	public HarrastusImpl poistaTapahtuma(int tapahtumaId) {

		String sql = "delete from TAPAHTUMA where tapahtuma_id=?";
		
		Object[] parametrit = new Object[] { tapahtumaId };
		
		RowMapper<HarrastusImpl> mappaaja = new HarrastusRowMapper();
		
	    HarrastusImpl h = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return h;
	}
	
	public void hyvaksyTapahtuma(HarrastusImpl h) {
		
		int hyvaksy = h.getTapahtumaId();
		
		String sql="update TAPAHTUMA SET hyvaksytty=1 WHERE tapahtuma_id='"+hyvaksy+"'";
		
		jdbcTemplate.execute(sql);
	}


	

}
