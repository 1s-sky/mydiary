package com.diary.mydiary.controller;

import jakarta.validation.constraints.NotBlank;

// 폼에 입력한 값을 전달받기 위한 LoginCommand 클래스
public class LoginCommand {
	
	@NotBlank
	private String id;
	@NotBlank
	private String pw;
	private boolean rememberId;
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
	public boolean isRememberId() {
		return rememberId;
	}
	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}
}
