package com.kh.app.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploader {

	// part 객체 받아서 서버에 저장
	public static String upload(Part f, String path) throws IOException {

		InputStream fis = f.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		String originName = f.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = UUID.randomUUID().toString() + ext;
		File target = new File(path + changeName);
		FileOutputStream fos = new FileOutputStream(target);

		int size = 0;
		byte[] buf = new byte[1024];
		while ((size = bis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}

		bis.close();
		fis.close();
		fos.close();
		
		return changeName;
	}
}
