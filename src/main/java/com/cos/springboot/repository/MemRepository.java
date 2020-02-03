package com.cos.springboot.repository;

import java.util.List;

import com.cos.springboot.dto.RequestMemDeleteDto;
import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.model.Mem;

// MapperScan에 의해서 알아서 메모리에 로드됨.(DataAccessConfig에 있는 것을 로드)
public interface MemRepository {

	// 리턴 타입과 함수이름만 적어주면 돌아가지 않는다.
	// 쿼리문을 mem.xml에 작성해야 한다.
	
	// 사용자 전체 보기
	List<Mem> findAll();
	
	// 상세보기
	// id로 받기
	Mem findByid(int id);
	
	// 회원가입
	int save(RequestMemJoinDto mem);
	
	// 회원 수정
	int update(RequestMemUpdateDto requestMemUpdateDto);
	
	// 회원 탈퇴
	int delete(RequestMemDeleteDto requestMemDeleteDto);
}
