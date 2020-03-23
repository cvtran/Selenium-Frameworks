package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Example3 {
	
	//if test takes too long, set a timeOut so it wont fail
	//passes in data from getData
	@Test(timeOut = 400, dataProvider = "getData")
	public void WebSigninCarLoan(String username, String password) {
		//selenium
		System.out.println("web signin");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(enabled = false)
	public void WebSignoutCarLoan() {
		//selenium
		System.out.println("web sign out");
	}
	
	//dependsOnMethods makes sure that the test executes before this test
	@Test(dependsOnMethods = {"WebSigninCarLoan"})
	public void APICarLoan() {
		//rest api automation
		System.out.println("api login car");
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st username/password - good credit history
		//2nd username/password - no credit history
		//3rd username/password - fraudulent credit history
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "username1";
		data[0][1] = "password1";
		
		//2nd set
		data[1][0] = "username2";
		data[1][1] = "password2";
		
		//3rd set
		data[2][0] = "username3";
		data[2][1] = "password3";
		
		return data;
	}
}
