package cn.supspider.bean;

public class userinfo {
		private int id;
		private String UserName;
		private String PassWord;
		private String Email;
		private String SignInTime;
		private String SignUpTime;
		
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
		
		
		@Override
		public String toString() {
			return "userinfo [id=" + id + ", UserName=" + UserName + ", PassWord=" + PassWord + ", Email=" + Email
					+ ", SignInTime=" + SignInTime + ", SignUpTime=" + SignUpTime + "]";
		}
}
