package test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testproject.base.TestBase;
import com.testproject.util.Xls_Reader;

public class ReportDataSetResult {
	
		@Test
		public static void setresultmain() throws IOException
		{
			TestBase.intialize();
			Xls_Reader x = TestBase.xlsObjectIntialize("Testsuite_A");
			
			reportDataSetResult(x,"Testcase_A1",2,"Pass");
			
		}

	public static void reportDataSetResult(Xls_Reader xls,String testCaseName, int rowNum, String result)
	{
		xls.setCellData(testCaseName, "Result", rowNum, result);
	}
}
