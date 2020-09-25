package uy.com.st.integration.common.logs.logger;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

abstract class AbstractLogger
  implements Logger
{
  protected int verboseLevel = 1;
  protected boolean showDescription = true;
  protected boolean errorLog = false;
  protected static String[] descriptions = new String[7];
  
  protected AbstractLogger()
  {
    this.showDescription = false;
  }
  
  protected AbstractLogger(boolean paramBoolean)
  {
    this.showDescription = paramBoolean;
  }
  
  public void setErrorLog(boolean paramBoolean)
  {
    this.errorLog = paramBoolean;
  }
  
  public boolean isErrorLog()
  {
    return this.errorLog;
  }
  
  public int getVerboseLevel()
  {
    return this.verboseLevel;
  }
  
  public void setVerboseLevel(int paramInt)
  {
    this.verboseLevel = paramInt;
  }
  
  public abstract void log(String paramString);
  
  public void log(String paramString, Throwable paramThrowable)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    PrintWriter localPrintWriter = new PrintWriter(localCharArrayWriter);
    localPrintWriter.println(paramString);
    if (paramThrowable != null)
    {
      localPrintWriter.print("  ");
      paramThrowable.printStackTrace(localPrintWriter);
    }
    log(localCharArrayWriter.toString());
  }
  
  public void log(String paramString, int paramInt)
  {
    if (this.verboseLevel >= paramInt)
    {
      String str;
      if (this.showDescription) {
        str = descriptions[paramInt] + " " + paramString;
      } else {
        str = paramString;
      }
      log(str);
    }
  }
  
  public void log(String paramString, Throwable paramThrowable, int paramInt)
  {
    if (this.verboseLevel >= paramInt)
    {
      String str;
      if (this.showDescription) {
        str = descriptions[paramInt] + " " + paramString;
      } else {
        str = paramString;
      }
      log(str, paramThrowable);
    }
  }
  
  static
  {
    descriptions[0] = "Panic:  ";
    descriptions[1] = "Error:  ";
    descriptions[2] = "Warning:";
    descriptions[3] = "Notice: ";
    descriptions[4] = "Phase:  ";
    descriptions[5] = "Trace:  ";
    descriptions[6] = "Debug:  ";
  }
}
