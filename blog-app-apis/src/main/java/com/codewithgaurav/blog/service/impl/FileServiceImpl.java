/**
 * 
 */
package com.codewithgaurav.blog.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithgaurav.blog.service.FileService;

/**
 * @author kumar
 *
 */

@Service
public class FileServiceImpl implements FileService {

	@Value("${project.image}")
	private String path;

	@Override
	public String uploadImage(MultipartFile file) throws IOException {

		String originalName = file.getOriginalFilename();

		String randomId = UUID.randomUUID().toString();
		String fileName = randomId + originalName.substring(originalName.lastIndexOf("."));
		String filePath = path + File.separator + fileName;

		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}

		Files.copy(file.getInputStream(), Paths.get(filePath));
		return fileName;
	}

	@Override
	public InputStream getResource(String fileName) throws FileNotFoundException {
		String filePath = path + File.separator + fileName;
		return new FileInputStream(filePath);
	}

}
