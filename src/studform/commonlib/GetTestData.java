package studform.commonlib;

public class GetTestData {
	
	public String filePath=System.getProperty("user.dir")+"\\TestData";
	public String fileName= "formsTestData.xslx";
		
	public void a65formtestdata() throws Throwable{
		
		ExcelDataConnector exceldata=new ExcelDataConnector();
		exceldata.readExcel(filePath, fileName, "formA65");
		
	}
}
