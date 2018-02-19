package com.wangdakeji.wongder.core.util;

import com.wangdakeji.wongder.core.exception.WongderExceptionEnum;
import com.wangdakeji.wongder.core.exception.WongderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * NIO way
	 */
	public static byte[] toByteArray(String filename) {

		File f = new File(filename);
		if (!f.exists()) {
			log.error("文件未找到！" + filename);
			throw new WongderException(WongderExceptionEnum.FILE_NOT_FOUND);
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			throw new WongderException(WongderExceptionEnum.FILE_READING_ERROR);
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				throw new WongderException(WongderExceptionEnum.FILE_READING_ERROR);
			}
			try {
				fs.close();
			} catch (IOException e) {
				throw new WongderException(WongderExceptionEnum.FILE_READING_ERROR);
			}
		}
	}
}