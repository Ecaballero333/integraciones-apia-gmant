package uy.com.st.integration.common.logs.logger;

import java.io.PrintStream;

public final class SystemOutLogger
  extends AbstractLogger
{
  public SystemOutLogger(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public void log(String paramString)
  {
    System.out.println(paramString);
  }
}
