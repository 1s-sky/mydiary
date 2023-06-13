package com.diary.mydiary.model;

import jakarta.validation.constraints.NotBlank;

public class User {
	
	@NotBlank
	private String id;
	@NotBlank
	private String pw;
	//@NotEmpty
	//private String pw2;
	public User() {
		this.id = null;
		this.pw = null;
	}
	public User(String id, String pw) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	// 암호 일치 여부를 확인하기 위한 matchPassword()메서드
	public boolean matchPassword(String pw) {
		return this.pw.equals(pw);
	}

}
