package com.suvikollc.resume_rag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suvikollc.resume_rag.entities.Jd;
import com.suvikollc.resume_rag.entities.Resume;
import com.suvikollc.resume_rag.service.FileService;
import com.suvikollc.resume_rag.service.VectorDBService;

@RestController
public class UploadController {

	@Autowired
	VectorDBService vectorDBService;

	@Autowired
	FileService fileService;

	@PostMapping("/resume/upload")
	public ResponseEntity<?> uploadResume(@RequestParam MultipartFile file) {

		if (file == null || file.isEmpty()) {
			return ResponseEntity.badRequest().body("File cannot be null or empty");
		}

		try {
			var newFile = fileService.uploadFile(file, Resume.class);
			return ResponseEntity.ok("Resume: " + newFile.toString() + " uploaded successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
		}

	}

	@PostMapping("/jd/upload")
	public ResponseEntity<?> uploadJd(@RequestParam MultipartFile file) {

		if (file == null || file.isEmpty()) {
			return ResponseEntity.badRequest().body("File cannot be null or empty");
		}

		try {
			var newFile = fileService.uploadFile(file, Jd.class);
			return ResponseEntity.ok("Resume: " + newFile.toString() + " uploaded successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
		}

	}

	@PostMapping("/upload")
	public String initiateDocumentsLoad() {

		vectorDBService.initiateDocumentLoad();

		return "Initiated document upload";

	}
}
