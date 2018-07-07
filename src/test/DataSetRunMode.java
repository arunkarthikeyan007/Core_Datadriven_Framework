package test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testproject.base.TestBase;
import com.testproject.util.Xls_Reader;

public class DataSetRunMode {
	@Test
	public void methodmain() throws IOException
	{
		TestBase.intialize();
		Xls_Reader x = TestBase.xlsObjectIntialize("Testsuite_A");
		dataSetRunMode(x,"Testcase_A1");
		
		//String[] runmode = null;
		String[] runmode = dataSetRunMode(x,"Testcase_A1");
		
		System.out.println(runmode[0]);
	}

	
	public String[] dataSetRunMode(Xls_Reader x,String sheetName )
	{
		if(!x.isSheetExist(sheetName))
		return null;
		
		String[] runmode = new String[x.getRowCount(sheetName)-1];
		for(int i=2 ; i<=x.getRowCount(sheetName);i++)
		{
			runmode [i-2]= x.getCellData(sheetName, "Run Mode", i);
		}
		
		return runmode;
	}
}
