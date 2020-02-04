package com.cos.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// 배운 어노테이션: Controller, Configuration, Repository

@Controller
public class imageController {

	@Value("${file.path}")
	private String fileRealPath;
	
	
	@PutMapping("/image/upload")
	public @ResponseBody String imageUpload(@RequestParam("imgFile") MultipartFile imgFile) {
		// 1. imgFile 출력
		
		System.out.println(imgFile.getOriginalFilename());
		System.out.println(imgFile.getContentType());
		System.out.println(imgFile.getSize());
		System.out.println(imgFile.getName());
		System.out.println();

		
		// 파일 이름 중복 방지
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+imgFile.getOriginalFilename();
		
		
		
		// 경로를 외부에 해두는 이유
		// 1. 타이밍이 안 맞는 경우를 대비하기 위해
		// 만약 static 폴더에 img폴더를 만들어서 저장하면 그 폴더에서 배포될 때는 target폴더로 옮겨져야 되는데, 이 방법은 시간이 오래걸린다.
		// 그러므로 폴더를 외부에 생성해서 페이지이동을 한다.(이 방법이 더 속도 빠르다)
		// 2. static에 넣으면 개발환경(테스트)때 엑박이 뜬다. 배포하고 나서는 상관이 없다.(이미 들어가 있는 사진은 상관없는데, 동적으로 들어간느 사진이 문제이다)
		// 그러므로 외부폴더에 만들어서 쓰는 게 더 좋다.
		// 이클립스에서 파일을 끌어와서 넣으면 target에 자동 복사해서 만들어주지만,
		// 이클립스 밖에서 실제 폴더에 파일을 끌어와서 넣어주면 target에 만들어주지 못한다.
		Path filePath = Paths.get(fileRealPath + uuidFilename);
		
		try {
			Files.write(filePath, imgFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "ok";
		
	}
}
