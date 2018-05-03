package cn.supspider.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class UtilMethods implements SendImpl{
		//注入属性设置器
		//发送邮件的账户配置
		//注入时间到实例工厂
	   	private Date date=new Date();
		
		//注入时间格式化类
		private SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//本类用于快速获取系统当前时间
		public String getNowSystemTime() throws ParseException {
			return df.format(date);
		}
		//发送邮件方法
		public int Send(String receiveMailAccount,int verifity_code,int Id) throws Exception{
			
			String myEmailAccount = "netspider@yeah.net";
			String myEmailPassword = "1069yu";
			String myEmailSMTPHost = "smtp.yeah.net";
			
			Properties props=new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址(带采用spring解决)
	        props.setProperty("mail.smtp.auth", "true");
	        
			Session session = Session.getInstance(props);
			
			session.setDebug(true);  
			
			MimeMessage message=createMimeMessage(session,myEmailAccount,receiveMailAccount,Id,verifity_code);
			
			Transport transport=session.getTransport();
			
			transport.connect(myEmailAccount, myEmailPassword);
			
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
			
			return 1;
		}
		//发送邮件内容
		@SuppressWarnings("unused")
		private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,int Id,int verifity_code) throws Exception, Exception {
			
			MimeMessage message=new MimeMessage(session);
			
			message.setFrom(new InternetAddress(sendMail,"SupSpider邮件机器人-NO.9527","UTF-8"));
			
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveMail, "UTF-8"));
			
			message.setSubject("欢迎注册SupSpider资源搜索寨,请点击链接激活您的账户!","UTF-8");
			
			message.setContent("<!DOCTYPE html><html><head><meta charset=\"utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\"><title>邮件验证</title><style type=\"text/css\">html,body{width: 100%;height: 100%;margin: 0;padding: 0;}</style></head><body><div style=\"width: 100%;height: 70px;background: #6495ED;\"><span style=\"color: #fff; line-height: 70px; font-weight: 600; margin-left: 10px;\"><a href=\"#\" style=\"text-decoration: none;color: inherit;\">SupSpider</a></span></div><div style=\"width: 100%; height: 100%; background: #F5F5F5; text-indent: 15px;padding-top: 30px;\"><span style=\"font-size: 15px; color: #696969;\">我们做最新最优质的资源搜索，做好一个工具给您最优的用户体验。我们始终都是那句话：我们不生产资源，我们只是互联网资源的搬运工！欢迎关注官微，及时得到最新的资源动态。</span><a href=\"http://127.0.0.1:8080/spiderweb2/user_SignUpCheckout.action?id="+Id+"&code="+verifity_code+"\" style=\"display: block; margin-left: auto; margin-right: auto; width: 90px; height: 30px; margin-top: 30px; background: #7CCD7C; padding-top: 10px; text-decoration: none; color: #fff; border: 1px soild #EBEBEB;\">点击激活</a></div></body></html>","text/html;charset=UTF-8");
			
			message.setSentDate(new Date());
			
			message.saveChanges();
			
			return message;
		}
		
		//生成验证码
		public int CreateSuperCode() {
			int code=(int) ((Math.random()*9+1)*1000000);
			return code;
		}
		
		//匹配用户邮箱,返回邮箱提供商
		public String FindEmailContext(String Email) {
			String RuleQQ="[a-zA-Z0-9]{5,15}@qq.com";
			String Rule163="[a-zA-Z0-9]{5,15}@163.com";
			String RuleYeah="[a-zA-Z0-9]{5,15}@yeah.net";
			String Rule126="[a-zA-Z0-9]{5,15}@126.com";
			String RuleOutlook="[a-zA-Z0-9]{5,15}@outlook.com";
			Pattern pattern=Pattern.compile(RuleQQ);
			Matcher matcher=pattern.matcher(Email);
			Pattern pattern1=Pattern.compile(Rule163);
			Matcher matcher1=pattern1.matcher(Email);
			Pattern pattern2=Pattern.compile(RuleYeah);
			Matcher matcher2=pattern2.matcher(Email);
			Pattern pattern3=Pattern.compile(Rule126);
			Matcher matcher3=pattern3.matcher(Email);
			Pattern pattern4=Pattern.compile(RuleOutlook);
			Matcher matcher4=pattern4.matcher(Email);
			if(matcher.find()) {
				return "https://mail.qq.com/";
			}
			if(matcher1.find()) {
				return "https://mail.163.com/";
			}
			if(matcher2.find()) {
				return "https://www.yeah.net/";
			}
			if(matcher3.find()) {
				return "https://mail.126.com/";
			}
			if(matcher4.find()) {
				return "https://outlook.live.com/owa/";
			}
			return "index";
		}
		
//		public static void main(String[] args) throws ParseException {
//			UtilMethods utilMethods=new UtilMethods();
//			utilMethods.getNowSystemTime();
//		}
		
}
