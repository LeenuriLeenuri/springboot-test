package com.cos.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Dto는 불변 데이터 아니다!!

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMemJoinDto {

	private String username;
	private String password;
	private String email;
	
}
