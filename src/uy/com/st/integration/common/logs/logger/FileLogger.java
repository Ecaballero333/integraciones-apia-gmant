package uy.com.st.integration.common.logs.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public final class FileLogger
  extends AbstractLogger
{
  private String Q = "";
  private String B;
  private String L;
  private String D;
  private int E;
  private boolean J = false;
  private PrintWriter M = null;
  public static final String PARAMETER_PREFIX = "prefix";
  public static final String PARAMETER_SUFFIX = "suffix";
  public static final String PARAMETER_DIRECTORY = "directory";
  public static final String PARAMETER_DISPLAY_TIME = "displayTime";
  public static final String PARAMETER_PERIODICITY = "periodicity";
  private static final String O = "Log.";
  private static final String F = ".log";
  private static final boolean P = true;
  private static final int I = 0;
  private static final int S = 1;
  private static final int K = 2;
  private static final int H = 3;
  private static final int N = 1;
  private static final SimpleDateFormat R = new SimpleDateFormat("yyyy-MM-dd");
  private static final SimpleDateFormat G = new SimpleDateFormat("yyyy-MM-'s'W");
  private static final SimpleDateFormat C = new SimpleDateFormat("yyyy-MM");
  
  public FileLogger(boolean paramBoolean, Map<String, String> paramMap)
  {
    super(paramBoolean);
    if (paramMap != null)
    {
      this.showDescription = paramBoolean;
      this.L = ((String)paramMap.get("prefix"));
      if (this.L == null) {
        this.L = "Log.";
      }
      this.D = ((String)paramMap.get("suffix"));
      if (this.D == null) {
        this.D = ".log";
      }
      this.B = ((String)paramMap.get("directory"));
      if (this.B == null) {
        throw new IllegalArgumentException("FileLogger: No directory parameter specified");
      }
      String str1 = (String)paramMap.get("periodicity");
      if (str1 == null) {
        this.E = 1;
      } else if (str1.equalsIgnoreCase("daily")) {
        this.E = 1;
      } else if (str1.equalsIgnoreCase("monthly")) {
        this.E = 3;
      } else if (str1.equalsIgnoreCase("weekly")) {
        this.E = 2;
      } else if (str1.equalsIgnoreCase("none")) {
        this.E = 0;
      } else {
        this.E = 1;
      }
      String str2 = (String)paramMap.get("displayTime");
      if (str2 == null) {
        this.J = true;
      } else {
        this.J = Boolean.valueOf(str2).booleanValue();
      }
      if (!this.L.endsWith(".")) {
        this.L += ".";
      }
      if (!this.D.startsWith(".")) {
        this.D = ("." + this.D);
      }
    }
    else
    {
      throw new NullPointerException("FileLogger: null parameters");
    }
  }
  
  public void log(String paramString)
  {
    Timestamp localTimestamp = new Timestamp(System.currentTimeMillis());
    String str1 = localTimestamp.toString().substring(0, 19);
    Date localDate = new Date(System.currentTimeMillis());
    String str2 = "";
    switch (this.E)
    {
    case 1: 
      str2 = R.format(localDate);
      if (!this.Q.equals(str2)) {
        synchronized (this)
        {
          A();
          this.Q = str2;
          B();
        }
      }
      break;
    case 2: 
      str2 = G.format(localDate);
      if (!this.Q.equals(str2)) {
        synchronized (this)
        {
          A();
          this.Q = str2;
          B();
        }
      }
      break;
    case 3: 
      str2 = C.format(localDate);
      if (!this.Q.equals(str2)) {
        synchronized (this)
        {
          A();
          this.Q = str2;
          B();
        }
      }
      break;
    case 0: 
      str2 = "NONE";
      if (!this.Q.equals(str2)) {
        synchronized (this)
        {
          A();
          this.Q = str2;
          B();
        }
      }
      break;
    }
    if (this.M != null)
    {
      if (this.J)
      {
        this.M.print(str1);
        this.M.print(" ");
      }
      this.M.println(paramString);
    }
  }
  
  private void A()
  {
    if (this.M == null) {
      return;
    }
    this.M.flush();
    this.M.close();
    this.M = null;
    this.Q = "";
  }
  
  private void B()
  {
    File localFile = new File(this.B);
    localFile.mkdirs();
    try
    {
      String str = null;
      if (this.E != 0) {
        str = localFile.getAbsolutePath() + File.separator + this.L + this.Q + this.D;
      } else {
        str = localFile.getAbsolutePath() + File.separator + this.L.substring(0, this.L.length() - 1) + this.D;
      }
      this.M = new PrintWriter(new FileWriter(str, true), true);
    }
    catch (IOException localIOException)
    {
      //Log.error("FileLoger open error: " + localIOException.toString());
      this.M = null;
    }
  }
}
