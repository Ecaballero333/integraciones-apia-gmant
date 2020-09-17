package uy.com.st.integration.common.logs;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IntegracionesLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    public static void setup(String nivelLog) throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }      
        Level nivel = obtenerNivelLog(nivelLog);
        logger.setLevel(nivel);
        String nombreArchivoLog = obtenerNomreArchivoLog();
        fileTxt = new FileHandler(nombreArchivoLog, true);

        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }
    
    public static void liberarArchivoLog() {
    	fileTxt.flush();
    	fileTxt.close();
    }
    
    private static Level obtenerNivelLog(String nivelLog) {
    	Level nivel = Level.INFO;
    	switch (nivelLog) {
		case "ALL":
			nivel = Level.ALL;
			break;
		case "CONFIG":
			nivel = Level.CONFIG;
			break;
		case "FINE":
			nivel = Level.FINE;
			break;
		case "FINER":
			nivel = Level.FINER;
			break;
		case "FINEST":
			nivel = Level.FINEST;
			break;
		case "INFO":
			nivel = Level.INFO;
			break;
		case "OFF":
			nivel = Level.OFF;
			break;
		case "SEVERE":
			nivel = Level.SEVERE;
			break;
		case "WARNING":
			nivel = Level.WARNING;
			break;
		}
    	return nivel;
    }
    
    private static String obtenerNomreArchivoLog() {
    	String pattern = "ddMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return "Integraciones-" +  simpleDateFormat.format(new Date()) + ".log";
	}

	public static String getSeparador() {
        return "**********************************************************************";
    }
    
    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
