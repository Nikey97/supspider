package cn.supspider.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;

public class UtilMethods {
		
		//本类用于快速获取系统当前时间
		public String getNowSystemTime() {
			@SuppressWarnings("unused")
			Date date=new Date();
			@SuppressWarnings("unused")
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(date);
		}
		//发送邮件方法
		public int SendEmails(String to) {
			//定义属性
			String from;
			String password;
			String subject;
			String body;
			//
			Properties properties=new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.socketFactory.port", "465");
	        properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.port", "465");
			return 0;
		}
}
