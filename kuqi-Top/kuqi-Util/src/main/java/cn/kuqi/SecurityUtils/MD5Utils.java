package cn.kuqi.SecurityUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MD5Utils{
	
	private static MessageDigest md5 = null;
	
	/**  
	  * @user: Nikey 
	  * @MethodName: getInstance
	  * @Description: 懒汉模式   
	  * @return MessageDigest     
	  * @date: 2018年11月10日 下午9:13:06  
	  * @todo: TODO
	  */
	public static MessageDigest getInstance(){
		if (md5 == null) {
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return md5;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: StrToMD5Method
	  * @Description: 加密字符串   
	  * @return String     
	  * @throws UnsupportedEncodingException 
	  * @date: 2018年11月5日 下午9:52:18  
	  * @todo: TODO
	  */
	public static String StrToMD5Method(String str) throws UnsupportedEncodingException {
		String s = null;
		MessageDigest md5 = getInstance();
		byte strs[] = md5.digest(str.getBytes("UTF-8"));
		s = Base64.getEncoder().encodeToString(strs);
		return s;
	}
	
	/**  
	  * @user: Nikey 
	  * @MethodName: MD5ToStrMethod
	  * @Description: 解密字符串  
	  * @return String     
	  * @date: 2018年11月5日 下午9:52:50  
	  * @todo: TODO
	  */
	//LGwAQ3tY/013WLCc5QAlig==
	public String MD5ToStrMethod(String MD5) {
		MessageDigest md5 = getInstance();
		
		return null;
	}
	
	
}
