package com.cos.springboot.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// @AllArgsConstructor 해두면 DB에 id가 자동으로 증가하니까 내가 몰라서 오류가 난다.
public class Mem {

	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private Timestamp createTime;
	
	
	// id 빼고 생성자 만들기
	@Builder
	public Mem(String username, String password, String email, String profile, Timestamp createTime) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.createTime = createTime;
	}
}
