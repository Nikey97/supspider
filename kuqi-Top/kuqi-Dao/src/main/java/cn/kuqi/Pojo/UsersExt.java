package cn.kuqi.Pojo;

import java.util.List;

public class UsersExt extends Message{
	
		private List<Users> data;

		public List<Users> getData() {
			return data;
		}

		public void setData(List<Users> data) {
			this.data = data;
		}
}
