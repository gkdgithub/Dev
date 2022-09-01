package com.codewithgaurav.blog.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String uploadImage(MultipartFile file) throws IOException;

	public InputStream getResource(String fileName) throws FileNotFoundException;
}
