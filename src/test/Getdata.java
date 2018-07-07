package test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testproject.base.TestBase;
import com.testproject.util.Xls_Reader;

public class Getdata {
	@Test
	public static void getdatamain() throws IOException
	{
		TestBase.intialize();
		Xls_Reader x = TestBase.xlsObjectIntialize("Testsuite_A");
		
		getdata(x,"Testcase_A1");
		
	}
	
	public static Object[][] getdata(Xls_Reader xls,String testCaseName)
	{
		if(!xls.isSheetExist(testCaseName))
		{
			xls =null;
			return new Object[1][0];
		}
		int row = xls.getRowCount(testCaseName);
		int col = xls.getColumnCount(testCaseName);
							
		Object[][] data = new Object[row-1][col-3];
		
		for(int rownum=2;rownum<=row;rownum++)
			for(int colnum=1;colnum<=col-3;colnum++)
			{	
				data[rownum-2][colnum-1] = xls.getCellData(testCaseName, colnum, rownum);
				
				
			}
					return data;
		}
}
