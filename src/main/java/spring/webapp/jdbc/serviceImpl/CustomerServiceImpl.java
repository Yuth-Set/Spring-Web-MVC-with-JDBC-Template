package spring.webapp.jdbc.serviceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.webapp.jdbc.entities.Customer;
import spring.webapp.jdbc.service.CustomerService;

@Repository("jdbctemplate")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Customer> listCustomer() {
		
		String sql = "SELECT * FROM customer ORDER BY customer_id ASC";
		return jdbcTemplate.query(sql , new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customer_id"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				return customer;
			}
		});
	}

	@Override
	public Customer findCustomerById(int id) {
		String sql = "SELECT customer_id, firstname, lastname FROM customer WHERE customer_id = ?";
		return jdbcTemplate.query(sql , new Object[]{ id }, new ResultSetExtractor<Customer>() {

			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Customer customerDto = new Customer();
					customerDto.setId(rs.getInt("customer_id"));
					customerDto.setFirstname(rs.getString("firstname"));
					customerDto.setLastname(rs.getString("lastname"));
					return customerDto;
				}
				return null;
			}
		});
	}

	@Override
	public boolean isDeleteCustomer(int id) {
		String sql = "DELETE FROM customer WHERE customer_id=?";
		int result = jdbcTemplate.update(sql , new Object[]{ id });
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public boolean isInsertCustomer(Customer dto) {
		String sql = "INSERT INTO customer(firstname, lastname) VALUES(?, ?)";
		int result = jdbcTemplate.update(sql , new Object[]{dto.getFirstname(),dto.getLastname()});
		if(result > 0)
			return true;
		return false;
	}

	@Override
	public boolean isUpdaateCuatomer(Customer dto) {
		String sql = "UPDATE customer SET firstname=?,lastname=? WHERE customer_id=?";
		int result = jdbcTemplate.update(sql, new Object[]{dto.getFirstname(),dto.getLastname(),dto.getId()});
		if(result > 0)
			return true;
		return false;
	}

	@Override
	public int countRecordCustomer() {
		String sql = "SELECT COUNT(*) FROM customer";
		return jdbcTemplate.queryForObject(sql , Integer.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Customer> search(String keyword) {
		String key = "%"+ keyword+ "%";
		String sql = "SELECT * FROM customer WHERE firstname like ? or lastname like ? ORDER BY customer_id ASC";
		return jdbcTemplate.query(sql , new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customer_id"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				return customer;
			}
		}, new Object[]{ key, key });
	}

}
