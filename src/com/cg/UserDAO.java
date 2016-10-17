package com.cg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("myDAO")
public class UserDAO {

	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
	}
	public void add(UserDTO userDto) throws SQLException{
		
		/*Connection connection = dataSource.getConnection();
		PreparedStatement insertUserDto = connection.prepareStatement("insert into user values(?,?)");
		insertUserDto.setString(1, userDto.getUsername());
		insertUserDto.setString(2, userDto.getPassword());
		insertUserDto.executeUpdate();*/
	//	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
		BeanPropertySqlParameterSource sqlParameterSource;
		sqlParameterSource = new BeanPropertySqlParameterSource(userDto);
		
		String insertQuery = "insert into user (username,password) values(:username,:password)";
		
		namedParameterJdbcTemplate.update(insertQuery, sqlParameterSource);
		System.out.println(userDto.getEmail());
	}
	public String get(UserDTO userDto){
		
		BeanPropertySqlParameterSource sqlParameterSource;
		sqlParameterSource = new BeanPropertySqlParameterSource(userDto);
		
		String selectQuery = "select password from user where username=:username";
	//	namedParameterJdbcTemplate.execute(selectQuery,sqlParameterSource);
	//	namedParameterJdbcTemplate.update(selectQuery, sqlParameterSource);
		return null;
	}
	
	
}
