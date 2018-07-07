package test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testproject.base.TestBase;
import com.testproject.util.Xls_Reader;

public class Getrownum {
	@Test
	public void methodmain() throws IOException
	{
		TestBase.intialize();
		Xls_Reader xls = TestBase.xlsObjectIntialize("Testsuite_A");
		//Getrownum(x,"Testcases","Testcase_A1");
	
		
		System.out.println(getrownum(xls,"Testcases","Testcase_A1"));
	}

	
	public static int getrownum(Xls_Reader xls,String sheetName, String testcasename)
	{	
		for( int i=2 ; i<=xls.getRowCount(sheetName);i++)
		{
			String celldata= xls.getCellData(sheetName, "Test Case Name", i);
			if(celldata.equalsIgnoreCase(testcasename))
			return i ;
		}
		return -1;
	}
}
