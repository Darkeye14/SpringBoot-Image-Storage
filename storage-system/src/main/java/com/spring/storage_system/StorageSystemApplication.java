package com.spring.storage_system;

import com.spring.storage_system.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class StorageSystemApplication {

	@Autowired
	private StorageService service;
	public static void main(String[] args) {
		SpringApplication.run(StorageSystemApplication.class, args);
	}

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file ) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] img = service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(img);
	}
}
