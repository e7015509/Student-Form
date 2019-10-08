package studform.formtests;
import java.io.IOException;

import org.testng.annotations.Test;

import studform.formactions.*;

public class PersonalDetailsTest extends PersonalDetailsAction {
	
	@Test(priority=1, description="Validate student id in the personal details section")
	public void studentid() throws IOException{
		validatestudentid();
	}

}
