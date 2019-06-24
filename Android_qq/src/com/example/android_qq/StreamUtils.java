package com.example.android_qq;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtils {
	public static String parseStream(InputStream inputStream) {
		byte[] buffer = new byte[1024];
		int len = 0;
		// 2049
		// 1-1024
		// 1025-2048
		// 2049
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				arrayOutputStream.write(buffer, 0, len);
			}
			return arrayOutputStream.toString("utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
