package test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jreport {
public static Logger Applog = null;

@Test
  public void loggs()
 { 	
	System.out.println("Hello");
	Applog = Logger.getLogger("devpinoyLogger");
	 Applog.debug("logs loaded");
	 
 }
 
}
