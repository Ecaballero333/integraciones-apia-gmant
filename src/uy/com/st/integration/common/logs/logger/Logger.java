package uy.com.st.integration.common.logs.logger;

public abstract interface Logger
{
  public static final int PANIC = 0;
  public static final int ERROR = 1;
  public static final int WARNING = 2;
  public static final int NOTICE = 3;
  public static final int PHASE = 4;
  public static final int TRACE = 5;
  public static final int DEBUG = 6;
  
  public abstract void setErrorLog(boolean paramBoolean);
  
  public abstract boolean isErrorLog();
  
  public abstract int getVerboseLevel();
  
  public abstract void setVerboseLevel(int paramInt);
  
  public abstract void log(String paramString);
  
  public abstract void log(String paramString, Throwable paramThrowable);
  
  public abstract void log(String paramString, int paramInt);
  
  public abstract void log(String paramString, Throwable paramThrowable, int paramInt);
}
