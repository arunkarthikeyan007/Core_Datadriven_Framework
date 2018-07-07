package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.testproject.util.Xls_Reader;

public class XlsIntializer {
	static Properties CONFIG = null;
	static Properties OR = null;
	static FileInputStream  file = null;
		
	public static void intialize( ) throws IOException 
	{
		CONFIG = new Properties();
		OR = new Properties();
		file = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\testproject\\config\\config.properties");
		CONFIG.load(file);
		file = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\testproject\\config\\OR.properties");
		OR.load(file);	
	}
	
	
	@Test
	public static void XlsIn() throws IOException
	{
			intialize( );	
			System.out.println(CONFIG.getProperty("Testsuitespath"));
			System.out.println(OR.getProperty("browser"));
		}
	@Test
	public static void XlsIntializermain() throws IOException
	{
			//xlsIntializer("Testsuites");
			Xls_Reader x1 = xlsIntialize("Testsuites");
			System.out.println(isSuiteRunnable(xlsIntialize("Testsuites"),"Testsuite_A"));
			
			Xls_Reader x2 = xlsIntialize("Testsuite_B");
			System.out.println(isTestRunnable(x2,"Testcase_B1"));
		}
	
	public static Xls_Reader xlsIntialize(String xlsname) throws IOException
	{
		intialize( );	
		String xlspath=CONFIG.getProperty(xlsname+"path");
		//System.out.println(xlspath);
			
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+xlspath);
		//System.out.println(x);
		return x;
	}
	
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName)
	{	
		boolean isExecutable = false;
		for(int i=2;i<=xls.getRowCount("Testsuites");i++)
			{
			String suite = xls.getCellData("Testsuites", "Test Suite Name", i);
			String runmode = xls.getCellData("Testsuites", "Run Mode", i);
			if(suiteName.equalsIgnoreCase(suite))
			{	if(runmode.equalsIgnoreCase("Y"))
					isExecutable = true;
				else
					isExecutable = false;
			}
	}	
		xls =null;
		return isExecutable;

	}
	
	public static boolean isTestRunnable(Xls_Reader xls,String testName)
	{ 	boolean isExecutable = false;
		for(int i=2;i<=xls.getRowCount("Testcases");i++)
		{ 
			if(xls.getCellData("Testcases", "Test Case Name", i).equalsIgnoreCase(testName))
			{	if(xls.getCellData("Testcases", "Run Mode", i).equalsIgnoreCase("Y"))
				isExecutable = true;
				else
					isExecutable = false;
			}
		}
		xls =null;
		return isExecutable;

	}
	
	
	
	
	
}
