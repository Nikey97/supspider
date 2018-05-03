package cn.supspider.Utils;

public interface SendImpl {
		
		//发送必须传递一个目标地址
		public int Send(String receiveMailAccount,int code,int Id) throws Exception;
		
}
