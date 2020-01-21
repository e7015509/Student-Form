package studform.commonlib;

public class GlobalVariable {
	
	public String browser= null;
	public String myvutest = null;
	public String username = null;
	public String password = null;
		public String unitcode1 = null;
	
	public void global()
	{
		DataBroker TestData = new DataBroker();
		String [] csvCell;
		csvCell = TestData.ReadData();
		
		browser = csvCell[0];
		myvutest = csvCell[1];
		username =csvCell[2];
		password = csvCell[3];
		unitcode1 = csvCell[4];
}
}