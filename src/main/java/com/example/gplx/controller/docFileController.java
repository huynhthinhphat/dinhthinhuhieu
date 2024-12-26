package com.example.gplx.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.gplx.service.docFileService;

@RestController
public class docFileController {

	@Autowired
	private docFileService df;

	@GetMapping("/import")
	public String importQuestions() {
		try {
			// Đọc file từ đường dẫn tuyệt đối trên máy tính cá nhân
			String filePath = "C:\\Users\\phath\\Desktop\\200ch.txt"; // Đường dẫn file trên máy của bạn

			df.saveQuestionsFromTxt(filePath);
			return "Dữ liệu đã được import thành công!";
		} catch (IOException e) {
			e.printStackTrace();
			return "Đã xảy ra lỗi khi import dữ liệu.";
		}
	}
}
