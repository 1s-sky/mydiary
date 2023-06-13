package com.diary.mydiary.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.diary.mydiary.exceptions.DuplicatedIDException;
import com.diary.mydiary.model.User;

@Controller
public class SignupController {
	
	private JdbcTemplate jdbcTemplate;
	
	public SignupController(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// 커맨드 객체 사용
	@PostMapping("/submit")
	public String signup(@ModelAttribute("user") @Validated User user, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "signup";
		}
		
		// findAll 한 다음에 거기에 id가 있는지 확인해야겠다
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
				},user.getId());
		try {
			for(int i=0;i<results.size();i++) {

				if(results.get(i).getId().equals(user.getId())) {
					throw new DuplicatedIDException();
				}
			}
		} catch(DuplicatedIDException e) {
			errors.reject("duplicatedID");
			return "signup";
		}
		
		
		String sql = "INSERT INTO user (id, pw) values (?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getPw());
		
		return "";
		
	}
	
	@GetMapping("/submit")
	public String signupRedirect() {	
		return "redirect:/";
	}
}
