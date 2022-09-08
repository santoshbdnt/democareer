package com.employee.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.employee.model.HiringForm;
import com.employee.repository.Repository;

import antlr.StringUtils;

@Controller
public class HomeController {

	@Autowired
	private Repository repo;
	
	@RequestMapping("/")
	public String getHome() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String Register(@ModelAttribute HiringForm hf,HttpSession session,@RequestParam("fileDoc") MultipartFile multiPartFile) throws IOException {
		
		String fileName = org.springframework.util.StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		hf.setData(fileName);
		
		HiringForm hfId =  repo.save(hf);
		
		String uploadDir = "/Document/ "+hfId.getApplicationId(); 
		
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream is = multiPartFile.getInputStream()){
			Path filePaths = uploadPath.resolve(fileName);
			Files.copy(is, filePaths,StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			throw new IOException("Could not save uploading file : "+fileName);
		}
		session.setAttribute("message", "Congratulation your application is Submitted..");
		return "redirect:/";
	}
}
