package cn.xdl.ovls.study.util;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	//根据用户id生成一个token
	public String createToken(int userId){
		//创建一个key
		String key = userId+"_token";
		//先判断这个key是否在redis中存在token了，存在的话 就说明是已经有其他地方登陆了，就不需要再创建一个新的token
		//可以多浏览器同时登陆
		String token = (String) redisTemplate.opsForValue().get(key);		
		if(token==null){
			//没有其他前端登录
			//生成一个新的Token
			UUID uuid = UUID.randomUUID();
			token = userId+"_"+uuid.toString().replaceAll("-", "");
			//将Token存入redis
			redisTemplate.opsForValue().set(key, token, Constants.TOKEN_EXPRIE_HOUR, TimeUnit.HOURS);
		}
		return token;
	}
	
	/**
	 * 检测token是否正确
	 * 
	 * */
	public boolean checkToken(String token){
		if(token==null || "".equals(token)){
			return false;
		}
		String[] arr = token.split("_");
		if(arr.length!=2){
			return false;
		}
		//从redis中获取token
		String key = arr[0]+"_token";
		String r_token = (String) redisTemplate.opsForValue().get(key);
		//System.out.println(r_token);
		if(r_token==null){
			return false;
		}
		if(!token.equals(r_token)){
			return false;
		}
		//通过检测之后，重新计时
		redisTemplate.opsForValue().set(key, token, Constants.TOKEN_EXPRIE_HOUR, TimeUnit.HOURS);
		return true;
	}
	
	/**
	 * 注销token
	 * */
	public boolean clearToken(String token){
		if(token==null || "".equals(token)){
			return false;
		}
		String[] arr = token.split("_");
		if(arr.length!=2){
			return false;
		}
		//从redis中获取token
		String key = arr[0]+"_token";
		String r_token = (String) redisTemplate.opsForValue().get(key);
		if(r_token==null){
			return false;
		}
		if(!token.equals(r_token)){
			return false;
		}
		//将redis中的token删除
		redisTemplate.delete(key);
		return true;
	}
	
	public static void main(String[] args){
		TokenManager tm = new TokenManager();
		String token = tm.createToken(1);
		System.out.println(token);
	}
}
