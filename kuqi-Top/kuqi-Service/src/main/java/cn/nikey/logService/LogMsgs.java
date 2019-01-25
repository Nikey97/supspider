package cn.nikey.logService;

public interface LogMsgs {
	/**  
	  * @Title: enclosing_method  
	  * @Description: 日志打印（异常）
	  * @user: Nikey 
	  * @param tags
	  * @date: 2018年11月28日 上午10:41:01    
	  */
	void logError(String msg);
	
	/**  
	  * @Title: logDug  
	  * @Description: 日志打印（信息） 
	  * @user: Nikey 
	  * @param tags
	  * @date: 2018年11月28日 上午10:41:36    
	  */
	void logInfo(String msg);
	
	/**  
	  * @Title: enclosing_method  
	  * @Description: 日志打印（调试）
	  * @user: Nikey 
	  * @param tags
	  * @date: 2018年11月28日 上午10:42:02    
	  */
	void logDug(String msg);
}
