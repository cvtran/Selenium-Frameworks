package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example2 {

	//@BeforeSuite method executes before all methods in the suite have executed
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("----- before suite -----");
	}
	
	//@AfterSuite method executes after all methods in the suite have executed
	@AfterSuite
	public void AfterSuite() {
		System.out.println("----- after suite----- ");
	}
	
	//@BeforeMethod method executes before every @test method in this class (executes once for each test method)
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("before method");
	}
	
	//@AfterMethod method executes after every @test method in this class (executes once for each test method)
	@AfterMethod
	public void AfterMethod() {
		System.out.println("after method \n");
	}
	
	@Parameters({"URL"})
	@Test
	public void WebLoginCarLoan(String urlName) {
		//selenium
		System.out.println("web login car");
		System.out.println(urlName);
	}
	
	@Test(groups = {"Mobile"})
	public void MobileLoginCarLoan() {
		//appium
		System.out.println("mobile login car");
	}
	
	@Test
	public void APILoginCarLoan() {
		//rest api automation
		System.out.println("api login car");
	}

}
