package io.codegitz.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class NoteUtil {
	/*
	 * 利用UUID生成主键
	 */
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		return id.replace("-", "");
	}
	
	public static String md5(String src) throws NoteException{
		
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			//MD5加密处理
			byte[] output=md.digest(src.getBytes());
			//Base64处理
			String ret=new String(output);
			ret = Base64.encodeBase64String(output);
			return ret;
		} catch (Exception e) {
			throw new NoteException("密码加密失败",e);

		}
		
	}
	
      public static void main(String[] args) throws NoteException {
		//System.out.println(md5("123456"));
		for (int i = 0; i < 4; i++) {
			System.out.println(createId());	
		}
		//System.out.println(md5(createId()));
	}
} 
