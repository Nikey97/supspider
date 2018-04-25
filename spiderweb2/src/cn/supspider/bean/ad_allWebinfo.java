package cn.supspider.bean;

public class ad_allWebinfo {
	
		private int number;
		private String web_Name;
		private String web_Keyword;
		private String web_Introduce;
		private int web_Open;
		
		
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getWeb_Name() {
			return web_Name;
		}
		public void setWeb_Name(String web_Name) {
			this.web_Name = web_Name;
		}
		public String getWeb_Keyword() {
			return web_Keyword;
		}
		public void setWeb_Keyword(String web_Keyword) {
			this.web_Keyword = web_Keyword;
		}
		public String getWeb_Introduce() {
			return web_Introduce;
		}
		public void setWeb_Introduce(String web_Introduce) {
			this.web_Introduce = web_Introduce;
		}
		public int getWeb_Open() {
			return web_Open;
		}
		public void setWeb_Open(int web_Open) {
			this.web_Open = web_Open;
		}
		
		@Override
		public String toString() {
			return "ad_allWebinfo [number=" + number + ", web_Name=" + web_Name + ", web_Keyword=" + web_Keyword
					+ ", web_Introduce=" + web_Introduce + ", web_Open=" + web_Open + "]";
		}	
}	
