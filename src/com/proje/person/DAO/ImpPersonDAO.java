package com.proje.person.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.proje.person.model.Person;

public class ImpPersonDAO implements PersonDAO {

	private JdbcTemplate jdbcTemplate;
	public ImpPersonDAO(DataSource dataSource)
	{
	this.jdbcTemplate=new JdbcTemplate(dataSource);	
		
	}

	@Override
	public int save(Person person) {
		if (Unget(person.getTCKN())==null) {
		
		String sql="Insert into person(TCKN,name,surname,email,city,gender,age) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,person.getTCKN(),person.getName(),person.getSurname().toUpperCase(),person.getEmail(),person.getCity(),person.getGender(),person.getAge());
		
		
		}
		else { 
			return 0;
		}
	}

	@Override
	public int update(Person person) {
		String sql="Update person set TCKN=?,name=?,surname=?,email=?,city=?,gender=?,age=? where ID=?";
		return jdbcTemplate.update(sql,person.getTCKN(),person.getName(),person.getSurname(),person.getEmail(),person.getCity(),person.getGender(),person.getAge(),person.getId());
		
		
	}

	@Override
	public Person get(Integer id) {
		String sql="Select * from person where ID="+id;
		ResultSetExtractor<Person> extractor=new ResultSetExtractor<Person>() {
			
			@Override
			public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name =rs.getString("name");
					String surname =rs.getString("surname");
					String email =rs.getString("email");
					String city =rs.getString("city");
					String gender =rs.getString("gender");
					Integer age=rs.getInt("age");
					String tc=rs.getString("TCKN");
					return new Person(id,name,surname,email,city,gender,age,tc);
					
					
				}
				return null;
			}
		};
			
		return jdbcTemplate.query(sql, extractor);
	}
	@Override
	public Person Unget(String tc) {
		String sql="Select * from person where TCKN="+tc;
		ResultSetExtractor<Person> extractor=new ResultSetExtractor<Person>() {
			
			@Override
			public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id=rs.getInt("id");
					String name =rs.getString("name");
					String surname =rs.getString("surname");
					String email =rs.getString("email");
					String city =rs.getString("city");
					String gender =rs.getString("gender");
					Integer age=rs.getInt("age");
					String tc=rs.getString("TCKN");
					return new Person(id,name,surname,email,city,gender,age,tc);
					
					
				}
				return null;
			}
		};
			
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id ) {
		String sql="Delete from person where id="+id;
		
		return jdbcTemplate.update(sql);
	}
	@Override
	public List<Person> list() {
		String sql="Select * from person"+" order by name,surname";;
		RowMapper<Person> rowMapper=new RowMapper<Person>() {
			
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id=rs.getInt("ID");
				String name =rs.getString("name");
				String surname =rs.getString("surname");
				String email =rs.getString("email");
				String city =rs.getString("city");
				String gender =(rs.getString("gender"));
				Integer age=rs.getInt("age");
				String tc=rs.getString("TCKN");
				return new Person(id,name,surname,email,city,gender,age,tc);
				
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
		 
	}
}
