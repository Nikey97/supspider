package cn.supspider.bean;


public class userFeedback {
		/*
		 * 用户反馈表(属性):
		 * 			储存用户id/用户名
		 * 			反馈标题
		 * 			反馈正题
		 * 			提交时间
		 * 			是否浏览
		 * */
		private int id;
		private String userName;
		private String title;
		private String context;
		private String submitTime;
		private int look;
		
		//维持外键
		private userinfo userinfo;
		public userinfo getUserinfo() {
			return userinfo;
		}
		public void setUserinfo(userinfo userinfo) {
			this.userinfo = userinfo;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getSubmitTime() {
			return submitTime;
		}
		public void setSubmitTime(String submitTime) {
			this.submitTime = submitTime;
		}
		public int getLook() {
			return look;
		}
		public void setLook(int look) {
			this.look = look;
		}
}
