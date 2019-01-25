package cn.kuqi.test;

import java.io.UnsupportedEncodingException;

import cn.kuqi.SecurityUtils.MD5Utils;

public class MD5Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		MD5Utils md5Utils = new MD5Utils();
		String s = md5Utils.StrToMD5Method("yujian"+"@#.....*%$#!!56779");
		System.out.println(s);
	}
}	
