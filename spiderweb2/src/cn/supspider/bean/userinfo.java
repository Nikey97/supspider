package cn.supspider.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class userinfo {
		private int id;
		private String UserName;
		private String PassWord;
		private String Email;
		private String SignInTime;
		private String SignUpTime;
		private int Danned;
		private int active;
		private int code;
		
		//维持外键关系
		@SuppressWarnings("unused")
		private Set<userinfo> setfeedback=new HashSet<userinfo>();
		public Set<userinfo> getSetfeedback() {
			return setfeedback;
		}
		public void setSetfeedback(Set<userinfo> setfeedback) {
			this.setfeedback = setfeedback;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPassWord() {
			return PassWord;
		}
		public void setPassWord(String passWord) {
			PassWord = passWord;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getSignInTime() {
			return SignInTime;
		}
		public void setSignInTime(String signInTime) {
			SignInTime = signInTime;
		}
		public String getSignUpTime() {
			return SignUpTime;
		}
		public void setSignUpTime(String signUpTime) {
			SignUpTime = signUpTime;
		}
		public int getDanned() {
			return Danned;
		}
		public void setDanned(int danned) {
			Danned = danned;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		
}
