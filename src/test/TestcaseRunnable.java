package test;

import org.testng.annotations.Test;

import com.testproject.util.Xls_Reader;

public class TestcaseRunnable {
@Test
	public static void main(String[] args) {
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\testproject\\xls\\Testsuite_B.xlsx");
		System.out.println(isTestRunnable(x,"Testcase_B2"));
		
	}
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
}



//Test Suite Name
//Sl No