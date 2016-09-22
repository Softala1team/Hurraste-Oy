package sovellus.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class HarrastusDAO implements HarrastusDAOInterface {

//	valmiit jutut tietokantaa varten
  
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public void haeKaikki() {
		
	}

	public int haeTietty() {

		return 0;
	}

	public int lisaaTapahtuma() {

		return 0;
	}

	public int poistaTapahtuma() {
		
		return 0;
	}

}
