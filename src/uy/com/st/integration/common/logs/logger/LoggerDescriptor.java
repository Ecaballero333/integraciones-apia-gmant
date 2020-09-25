package uy.com.st.integration.common.logs.logger;

import java.util.Map;

public class LoggerDescriptor
{
  public static final String TYPE_FILE = "File";
  public static final String TYPE_STANDARD_OUTPUT = "StandardOutput";
  public static final String TYPE_STANDARD_ERROR = "StandardError";
  public static final String LEVEL_PANIC = "PANIC";
  public static final String LEVEL_ERROR = "ERROR";
  public static final String LEVEL_WARNING = "WARNING";
  public static final String LEVEL_NOTICE = "NOTICE";
  public static final String LEVEL_PHASE = "PHASE";
  public static final String LEVEL_TRACE = "TRACE";
  public static final String LEVEL_DEBUG = "DEBUG";
  private String C;
  private String A;
  private boolean D;
  private boolean B;
  private Map<String, String> E;
  
  public LoggerDescriptor(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.C = paramString1;
    this.A = paramString2;
    this.D = paramBoolean1;
    this.B = paramBoolean2;
  }
  
  public void setParameters(Map<String, String> paramMap)
  {
    this.E = paramMap;
  }
  
  public Logger getLogger()
  {
    Object localObject = null;
    if ("File".equals(this.C)) {
      localObject = new FileLogger(this.D, this.E);
    } else if ("StandardOutput".equals(this.C)) {
      localObject = new SystemOutLogger(this.D);
    } else if ("StandardError".equals(this.C)) {
      localObject = new SystemErrLogger(this.D);
    }
    ((Logger)localObject).setErrorLog(this.B);
    int i = 1;
    if ("DEBUG".equals(this.A)) {
      i = 6;
    } else if ("ERROR".equals(this.A)) {
      i = 1;
    } else if ("NOTICE".equals(this.A)) {
      i = 3;
    } else if ("PANIC".equals(this.A)) {
      i = 0;
    } else if ("PHASE".equals(this.A)) {
      i = 4;
    } else if ("TRACE".equals(this.A)) {
      i = 5;
    } else if ("WARNING".equals(this.A)) {
      i = 2;
    }
    if (localObject != null) {
      ((Logger)localObject).setVerboseLevel(i);
    }
    return (Logger)localObject;
  }
}
