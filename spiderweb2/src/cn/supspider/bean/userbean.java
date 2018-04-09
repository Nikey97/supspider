package cn.supspider.bean;

public class userbean {
		/*
		 * 该javabean用于管理页面的登录:
		 * 	
		 * 	变量属性:
		 * 
		 * 			name
		 * 
		 * 			password
		 * */
		private int id;
		private String name;
		private String password;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		@Override
		public String toString() {
			return "userbean [id=" + id + ", name=" + name + ", password=" + password + "]";
		}
}
