package uy.com.st.integration.common.logs;

import java.util.HashMap;
import java.util.Map;

import uy.com.st.integration.common.logs.logger.FileLogger;

public enum IntegracionesLog4j{
	LOG;
	private FileLogger _log;
	
	private IntegracionesLog4j(){
	}

	public static void log(String msg, Throwable t){
		LOG._log.log(msg, t);
	}
	
	public static void log(String msg){
		LOG._log.log(msg);
	}

	public static void setup(String pathLog, String nivelLog) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(FileLogger.PARAMETER_DIRECTORY, pathLog);
		map.put(FileLogger.PARAMETER_PREFIX, "MI_LOG");
		map.put(FileLogger.PARAMETER_DISPLAY_TIME, "true");
		map.put(FileLogger.PARAMETER_SUFFIX, ".log");
		map.put(FileLogger.PARAMETER_PERIODICITY, "Daily"); 
		LOG._log = new FileLogger(true, map);
	}	
		
}
