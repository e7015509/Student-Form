package studform.commonlib;

public class GlobalVariable {
	
	public String browser= null;
	public String A65formURL = null;
	public String expStudentidlbl = null;
	
	public void global()
	{
		DataBroker TestData = new DataBroker();
		String [] csvCell;
		csvCell = TestData.ReadData();
		
		browser = csvCell[0];
		A65formURL = csvCell[1];
		expStudentidlbl = csvCell[2];
}
}