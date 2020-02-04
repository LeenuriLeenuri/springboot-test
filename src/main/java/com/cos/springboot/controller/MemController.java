package com.cos.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemDeleteDto;
import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.dto.ResponseDto;
import com.cos.springboot.model.Mem;
import com.cos.springboot.repository.MemRepository;

@Controller
public class MemController {

	@Autowired
	private MemRepository memRepository;

	// 날릴 때 필요한 거: username, password, email
	// 1 건일 땐, RequestParam으로 받고, 여러 건이면 Dto로 받아라!!

	// api가 붙으면 페이지 리턴이 아니라, 데이터 리턴이다!!, 응답만 해주면 된다.
	// get이 아니면 모두 데이터를 던져라!!
	@PostMapping("/mem/api/join")
	public @ResponseBody ResponseEntity<?> memApiJoin(@Valid @RequestBody RequestMemJoinDto requestMemJoinDto, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			Map<String, String>errorMap = new HashMap<>();
			
			for(FieldError error: bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity <Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		int result = memRepository.save(requestMemJoinDto);

		if (result == 1) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(200, "ok"), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/mem/join")
	public String join(Model model) {
		return "mem/join";
	}

	@GetMapping("/mem")
	public String mems(Model model) {
		List<Mem> mems = memRepository.findAll();

		model.addAttribute("mems", mems);

		return "mem/list";
	}

	@GetMapping("/mem/{id}")
	public String update(@PathVariable int id, Model model) {
		Mem mem = memRepository.findByid(id);

		model.addAttribute("mem", mem);

		return "mem/update";
	}

	@PutMapping("/mem/api/update")
	// 뭘로 받을지 잘 모르면 <?>로 적으면 다 받을 수 있다.
	public @ResponseBody ResponseEntity<?> updateProc(@RequestBody RequestMemUpdateDto requestMemUpdateDto) {

		int result = memRepository.update(requestMemUpdateDto);

		if (result == 1) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/mem")
	public @ResponseBody ResponseEntity<?> delete(@RequestBody RequestMemDeleteDto requestMemDeleteDto) {
		int result = memRepository.delete(requestMemDeleteDto);

		if (result == 1) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}
}
