package cn.xdl.ovls.study.util;

import java.util.UUID;

/**
 * 生成一个8位的String格式  用户salt数据,用于加密
 * */
public class SaltUtil {

	public static String createSalt(){
		UUID uuid = UUID.randomUUID();
		String salt = uuid.toString().replaceAll("-", "").substring(0, 8);
		return salt;
	}
	
	public static void main(String[] args){
		System.out.println(createSalt());
	}
}
