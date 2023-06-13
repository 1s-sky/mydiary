package com.diary.mydiary.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.diary.mydiary.exceptions.WrongIdPasswordException;
import com.diary.mydiary.model.AuthInfo;
import com.diary.mydiary.model.User;

@Service
public class AuthService {
	
	private JdbcTemplate jdbcTemplate;
	
	public AuthService(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public AuthInfo authenticate(String id, String pw) {
		List<User> results = jdbcTemplate.query(
				"select * from user where id = ?",
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException{
						User user = new User(
								rs.getString("id"),
								rs.getString("pw"));
				
						return user;
					}
				},id);
				if (results.size() != 0){		// select된 데이터가 존재하고
					if(results.get(0).matchPassword(pw))		// 비밀번호가 일치하면
					return new AuthInfo(results.get(0).getId(),results.get(0).getPw());	// authinfo 객체를 생성
					
				}
				throw new WrongIdPasswordException();
	}
}

				

