package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.dto.RequestUserPutDto;
import com.cos.springboot.dto.ResponseData;

@Controller
@RequestMapping("/home")
public class HomeController {

	// localhost:8080/home/
	// localhost:8080/home
	// 슬러시(/)가 있는 거 없는 거 다 받아준다.
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	
	// localhost:8080/home/hello
	// ajax 쓸 필요 없이 a태그 하이퍼링크로 넘기면 된다.
	// GET은 페이지 이동 시 사용, SELECT 이용 시 사용
	@GetMapping("/hello")
	public String hello_get() {
		System.out.println("What's up?");
		// DB Select - model (DB 연결 시)
		return "hello";
	}
	
	@PostMapping("/hello")
	// ajax가 관여 못하게 @ResponseBody
	public @ResponseBody ResponseData hello_post(@RequestBody RequestUserDto requestUserDto) {
		// DB Insert 로직 필요 (DB 연결 시)
		System.out.println(requestUserDto.getId());
		return new ResponseData(200, "ok");
	}
	
	@DeleteMapping("/hello")
	public @ResponseBody ResponseData hello_delete(@RequestBody RequestUserDto requestUserDto) {
		// DB Delete 로직 필요 (DB 연결 시)
		System.out.println(requestUserDto.getId());
		return new ResponseData(200, "ok");
	}
	
	
	
	@PutMapping("/hello")
	public @ResponseBody ResponseData hello_put(@RequestBody RequestUserPutDto requestUserPutDto) {
		// DB Put 로직 필요 (DB 연결 시)
		System.out.println(requestUserPutDto.getUsername());
		System.out.println(requestUserPutDto.getPhone());
		return new ResponseData(200, "ok");
	}
}
