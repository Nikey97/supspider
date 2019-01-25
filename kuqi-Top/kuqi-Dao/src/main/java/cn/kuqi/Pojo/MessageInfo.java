package cn.kuqi.Pojo;

public class MessageInfo {
	
		private int code;
		private String msg;
		private String status;
		private boolean pass;
		
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isPass() {
			return pass;
		}
		public void setPass(boolean pass) {
			this.pass = pass;
		}
}
