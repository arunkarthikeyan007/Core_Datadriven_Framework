package test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testproject.base.TestBase;
import com.testproject.util.Xls_Reader;

public class RunnableCommon extends TestBase {
	static Xls_Reader x ;
@Test
	public static void suitecommonmain() throws IOException
	{
//		 x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\testproject\\xls\\Testsuites.xlsx");
//		System.out.println(isRunnable(x,"Testsuites","Testsuite_A"));
//
//		 x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\testproject\\xls\\Testsuite_A.xlsx");
//		System.out.println(isRunnable(x,"Testcases","Testcase_A1"));

		intialize();
		//xlsObjectIntialize("Testsuites");
		System.out.println(isRunnable(xlsObjectIntialize("Testsuites"),"Testsuites","Testsuite_B"));
		}
	
	public static boolean isRunnable(Xls_Reader xls,String sheetname,String testName)
	{	
		boolean isExecutable = false;
		for(int i=2;i<=xls.getRowCount(sheetname);i++)
			{
			//String suite = xls.getCellData(sheetname, 1, i);
			//String runmode = xls.getCellData(sheetname, "Run Mode", i);
			
			if(xls.getCellData(sheetname, 1, i).equalsIgnoreCase(testName))
			{	if(xls.getCellData(sheetname, "Run Mode", i).equalsIgnoreCase("Y"))
					isExecutable = true;
				else
					isExecutable = false;
			}
	}	
		xls =null;
		return isExecutable;

	}
	
}
