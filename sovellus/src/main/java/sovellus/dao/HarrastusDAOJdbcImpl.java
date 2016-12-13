package sovellus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.JsonNode;

import sovellus.bean.HarrastusImpl;

/**
 * <p>T‰m‰ on HarrastusDAO:n JdbcTemplatella toteuttava luokka.</p>
 * 
 * @author team
 * @version 1.0
 * 
 * */

public class HarrastusDAOJdbcImpl implements HarrastusDAO {

	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//---------------------------------------------
		
	/**
	 * <p>Metodi <code>haeTapahtumatJson</code> hakee tiedot harrastuksista tietokannasta ja k‰ytt‰‰ JsonKaantajaRowMapperia tehd‰kseen JSON-objektin.</p>
	 * 
	 * @param sql		Toteutettava sql-lause.
	 * @param mappaaja	Json-k‰‰nt‰j‰, katso lis‰tietoja: @see JsonKaantajaRowMapper.
	 * @param json		Listamuotoinen JSON-objekti, joka tehd‰‰n jdbcTemplatea k‰ytt‰m‰ll‰.
	 * 
	 * @return palauttaa listamuotoisen JSON-objektin.
	 * 
	 * */
	
	public List<JsonNode> haeTapahtumatJson(){
		
		String sql = "select * from TAPAHTUMA where hyvaksytty is not null";
		RowMapper<JsonNode> mappaaja = new JsonKaantajaRowMapper();
		List<JsonNode> json = jdbcTemplate.query(sql, mappaaja);
		
		return json;
	}
	
	/**
	 * <p>Metodi <code>haeKaikkiListaan</code> hakee tiedot harrastuksista tietokannasta ja k‰ytt‰‰ HarrastusRowMapperia tehd‰kseen listan niist‰.</p>
	 * 
	 * @param sql		Toteutettava sql-lause.
	 * @param mappaaja	Harrastuksia k‰sittelev‰ RowMapper, katso lis‰tietoja: @see HarrastusRowMapper.
	 * @param harrastukset		Lista harrastuksista, joka muodostetaan mappaajalla.
	 * 
	 * @return palauttaa listan harrastuksista.
	 * 
	 * */
	
	public List<HarrastusImpl> haeKaikkiListaan(){
		
		String sql = "select * from TAPAHTUMA where hyvaksytty is not null";
		RowMapper<HarrastusImpl> map = new HarrastusRowMapper();
		List<HarrastusImpl> harrastukset = jdbcTemplate.query(sql, map);
		System.out.println(harrastukset);
		
		return harrastukset;
	}
	
	/* public List<HarrastusImpl> haeKaikkiAdminille(){
		
		String sql = "select * from TAPAHTUMA";
		RowMapper<HarrastusImpl> map = new HarrastusRowMapper();
		List<HarrastusImpl> adminille = jdbcTemplate.query(sql, map);
		
		return adminille;
	}*/
	
	/**
	 * <p>Metodi <code>haeTapahtumatJsonTyyppi</code> hakee tiedot tietyist‰ harrastuksista tietokannasta ja k‰ytt‰‰ JsonKaantajaRowMapperia tehd‰kseen JSON-objektin.</p>
	 * 
	 * @param tapahtuman_tyyppi	Etsitt‰vien tapahtumien tyyppi.
	 * @param sql		Toteutettava sql-lause.
	 * @param mappaaja	Json-k‰‰nt‰j‰, katso lis‰tietoja: @see JsonKaantajaRowMapper.
	 * @param json		Listamuotoinen JSON-objekti, joka tehd‰‰n jdbcTemplatea k‰ytt‰m‰ll‰.
	 * 
	 * @return palauttaa listamuotoisen JSON-objektin.
	 * 
	 * */
	
	public List<JsonNode> haeTapahtumatJsonTyyppi(String tapahtuman_tyyppi){
		
		String sql = "select * from TAPAHTUMA where tapahtuman_tyyppi = ? and hyvaksytty is not null";
		Object[] parametrit = new Object[] { tapahtuman_tyyppi };
		RowMapper<JsonNode> mappaaja = new JsonKaantajaRowMapper();
		List<JsonNode> json = jdbcTemplate.query(sql, parametrit, mappaaja);
		
		return json;
	}

	/**
	 * <p>Metodi <code>haeTietty</code> hakee tiedot tietyst‰ harrastuksesta tietokannasta ja k‰ytt‰‰ HarrastusRowMapperia tehd‰kseen HarrastusImpl-olion niist‰.</p>
	 * 
	 * @param tapahtuma_id	Haettavan tapahtuman yksilˆiv‰ tunnus.
	 * @param sql			Toteutettava sql-lause.
	 * @param parametrit	Objektilista, johon kootaan haettavan tapahtuman id. 
	 * @param mappaaja		Harrastuksia k‰sittelev‰ RowMapper, katso lis‰tietoja: @see HarrastusRowMapper.
	 * @param h				HarrastusImpl-olio, johon tiedot haetaan.
	 * 
	 * @return palauttaa HarrastusImpl-olion h.
	 * 
	 * */
	
	public HarrastusImpl haeTietty(int tapahtumaId) {

		String sql = "select * from TAPAHTUMA where tapahtuma_id = ?";	
		Object[] parametrit = new Object[] { tapahtumaId };	
		RowMapper<HarrastusImpl> mappaaja = new HarrastusRowMapper();
	    HarrastusImpl h = jdbcTemplate.queryForObject(sql , parametrit, mappaaja);
		
		
		return h;
	}

	/**
	 * <p>Metodi <code>lisaaTapahtuma</code> ottaa vastaan tiedot lis‰tt‰v‰st‰ harrastuksesta ja lis‰‰ ne jdbcTemplatella tietokantaan.</p><br>
	 * <p>Riippuen onnistumisesta v‰litet‰‰n booleanin arvo eteenp‰in.</p>
	 * 
	 * @param h				HarrastusImpl-olio, joka lis‰t‰‰n.
	 * @param onnistui		Boolean, joka kertoo metodia kutsuvalle, onnistuiko tapahtuma vai ei.
	 * @param sql			Toteutettava sql-lause.
	 * @param parametrit	Objektilista, johon kootaan lis‰tt‰v‰n tapahtuman tiedot. 
	 * 
	 * @return palauttaa booleanin onnistui joko truena tai falsena.
	 * 
	 * */
	
	public boolean lisaaTapahtuma(HarrastusImpl h) {
		
		boolean onnistui;
		final String sql="insert into TAPAHTUMA(max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, loppumis_aika, kuvaus, tapahtuma_paikka, tapahtuman_tyyppi)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		

		Object[] parametrit = new Object[] {h.getMax_osallistujamaara(), h.getTapahtuma_nimi(), h.getJar_nimi(),
				h.getPuh_num(), h.getEmail(), h.getTapahtuma_aika(), h.getLoppumis_aika(), h.getKuvaus(), h.getTapahtuma_paikka(), h.getTapahtuman_tyyppi()};
		
			try {
				jdbcTemplate.update(sql, parametrit);
			
			} catch (Exception e) {
				onnistui = false;
				return onnistui;
			}
			onnistui = true;
			return onnistui;
	}

	/**
	 * <p>Metodi <code>poistaTapahtuma</code> ottaa vastaan poistettavan harrastusolion ja poistaa sen jdbcTemplatella tietokannasta.</p>
	 * 
	 * @param h				HarrastusImpl-olio, joka poistetaan.
	 * @param sql			Toteutettava sql-lause.
	 * 
	 * 
	 * */
	
	public void poistaTapahtuma(HarrastusImpl h) {
		
		int pois = h.getTapahtumaId();
		
		String sql="delete from TAPAHTUMA where tapahtuma_id='"+pois+"'";
		
		jdbcTemplate.execute(sql);
		
	}
	

}
