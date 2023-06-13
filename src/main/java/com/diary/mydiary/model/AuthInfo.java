package com.diary.mydiary.model;

// 로그인 성공 후 인증 상태 정보를 세션에 보관할 때 사용할 AuthInfo 클래스
public class AuthInfo {
	
	private String id;
	private String pw;
	
	public AuthInfo(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
}
