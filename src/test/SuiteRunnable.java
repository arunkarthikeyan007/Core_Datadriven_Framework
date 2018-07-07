package test;

import org.testng.annotations.Test;

import com.testproject.util.Xls_Reader;

public class SuiteRunnable {
	@Test
	public static void suitemain()
	{
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\testproject\\xls\\Testsuites.xlsx");
		//isSuiteRunnable(x,"A Suite");
		System.out.println(isSuiteRunnable(x,"Testsuite_A"));

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
	

}


