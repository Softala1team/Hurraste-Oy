
package sovellus.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * <p>T�m� on Json-k��nt�j�, jonka avulla luodaan JSON-objekti sille annetuista tiedoista.</p>
 * 
 * @param mapper	jackson-pluginin ObjectMapper, jolla luodaan lista mihin JSON-objektit luodaan.
 * 
 * @author kdonald, GitHub
 * 
 * */

public class JsonKaantajaRowMapper implements RowMapper<JsonNode> {
	

	ObjectMapper mapper = new ObjectMapper();
	
    public JsonNode mapRow(ResultSet rs, int rowNum) throws SQLException {

        ObjectNode objectNode = mapper.createObjectNode();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int index = 1; index <= columnCount; index++) {

            String column = JdbcUtils.lookupColumnName(rsmd, index);
            Object value = rs.getObject(column);

            if (value == null) {

                objectNode.putNull(column);

            } else if (value instanceof Integer) {

                objectNode.put(column, (Integer) value);

            } else if (value instanceof String) {

                objectNode.put(column, (String) value);                

            } else if (value instanceof Boolean) {

                objectNode.put(column, (Boolean) value);           

            } else if (value instanceof Date) {

                objectNode.put(column, ((Date) value).getTime());                

            } else if (value instanceof Long) {

                objectNode.put(column, (Long) value);                

            } else if (value instanceof Double) {

                objectNode.put(column, (Double) value);                

            } else if (value instanceof Float) {

                objectNode.put(column, (Float) value);                

            } else if (value instanceof BigDecimal) {

                objectNode.put(column, (BigDecimal) value);

            } else if (value instanceof Byte) {

                objectNode.put(column, (Byte) value);

            } else if (value instanceof byte[]) {

                objectNode.put(column, (byte[]) value);                

            } else {

                throw new IllegalArgumentException("Unmappable object type: " + value.getClass());

            }

        }

        return objectNode;

    }

}
