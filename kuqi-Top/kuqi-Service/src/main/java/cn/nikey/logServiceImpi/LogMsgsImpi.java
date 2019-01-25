package cn.nikey.logServiceImpi;


import org.apache.log4j.Logger;

import cn.nikey.logService.LogMsgs;

public class LogMsgsImpi implements LogMsgs {
	private static Logger logger = Logger.getLogger(LogMsgsImpi.class);
	
	public void logError(String msg) {
		logger.error(msg);
	}

	public void logInfo(String msg) {
		logger.info(msg);
	}

	public void logDug(String msg) {
		logger.debug(msg);
	}
	
	public static void main(String[] args) {
		LogMsgsImpi logMsgsImpi = new LogMsgsImpi();
		logMsgsImpi.logInfo("this is infomation");
		logMsgsImpi.logError("hava a mistake");
		logMsgsImpi.logDug("buging!");
	}

}
