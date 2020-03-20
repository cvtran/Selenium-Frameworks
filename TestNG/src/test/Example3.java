package test;

import org.testng.annotations.Test;

public class Example3 {
	
	//if test takes too long, set a timeOut so it wont fail
	@Test(timeOut = 400)
	public void WebSigninCarLoan() {
		//selenium
		System.out.println("web signin");
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
}
