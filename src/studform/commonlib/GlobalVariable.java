package studform.commonlib;

public class GlobalVariable {
	
	public String browser = null;
	public String MYVUlink = null;
	public String username = null;
	public String password  = null;
	public String studyperiod = null;
	public String unitcode = null;
	
	public void a65formtestdata() throws Throwable{
		ExcelDataConnector exceldata=new ExcelDataConnector();
		String sheetName = "formA65";
		browser=exceldata.getExcelRowData(sheetName, 1, 0);
		MYVUlink=exceldata.getExcelRowData(sheetName, 1, 1);
		username=exceldata.getExcelRowData(sheetName, 1, 2);
		password=exceldata.getExcelRowData(sheetName, 1, 3);
		studyperiod=exceldata.getExcelRowData(sheetName, 1, 4);
		unitcode=exceldata.getExcelRowData(sheetName, 1, 5);
	}
}
