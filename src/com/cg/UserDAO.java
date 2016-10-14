package com.cg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("myDAO")
public class UserDAO {

	@Autowired
	DataSource dataSource;
	
	public void add(UserDTO userDto) throws SQLException{
		
		Connection connection = dataSource.getConnection();
		PreparedStatement insertUserDto = connection.prepareStatement("insert into user values(?,?)");
		insertUserDto.setString(1, userDto.getUsername());
		insertUserDto.setString(2, userDto.getPassword());
		insertUserDto.executeUpdate();
		System.out.println(userDto.getEmail());
	}
	
	
	
}
