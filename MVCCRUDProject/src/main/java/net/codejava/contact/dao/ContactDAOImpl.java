package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	private JdbcTemplate jdbcTemplate; 
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (first_name, last_name, email, address, phone_number) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getFirst_name(), c.getLast_name(), c.getEmail(), c.getAddress(), c.getPhone_number());
	}

	@Override
	public int update(Contact c) {
		String sql = "UPDATE Contact SET first_name=?, last_name=?, email=?, address=?, phone_number=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, c.getFirst_name(), c.getLast_name(), c.getEmail(), c.getAddress(), c.getPhone_number(), c.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM Contact WHERE contact_id=" + id;
		
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			 
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone_number = rs.getString("phone_number");
				
					return new Contact(id, first_name, last_name, email, address, phone_number);
				}
				
				return null;
			}
		};
			
			return jdbcTemplate.query(sql,  extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Contact WHERE contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM Contact";
		
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone_number = rs.getString("phone_number");
			
				return new Contact(id, first_name, last_name, email, address, phone_number);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
