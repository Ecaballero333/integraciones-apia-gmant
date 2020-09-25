package uy.com.st.integration.common.logs.logger;

import java.io.PrintStream;

public final class SystemErrLogger
  extends AbstractLogger
{
  public SystemErrLogger(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public void log(String paramString)
  {
    System.err.println(paramString);
  }
}
