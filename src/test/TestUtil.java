package test;

import com.testproject.util.Xls_Reader;

public class TestUtil {
//****************************************************************************************************	
	//To find if suite is runnable
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName)
	{	
		boolean isExecutable = false;
		for(int i=2;i<=xls.getRowCount("Testsuites");i++)
			{
			if( xls.getCellData("Testsuites", "Test Suite Name", i).equalsIgnoreCase(suiteName))
			{	if(xls.getCellData("Testsuites", "Run Mode", i).equalsIgnoreCase("Y"))
					isExecutable = true;
				else
					isExecutable = false;
			}
	}	
		xls =null;
		return isExecutable;
}
//****************************************************************************************************	
	//To find if testcase is runnable
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
//****************************************************************************************************	
		//to get test data for testcase
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
