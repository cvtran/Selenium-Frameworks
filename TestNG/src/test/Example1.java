package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example1 {

	//@BeforeClass runs before any @test methods in the class
	@BeforeClass
	public void BeforeClass() {
		System.out.println("before class");
	}
	
	//@AfterClass runs after any @test methods in the class
	@AfterClass
	public void AfterClass() {
		System.out.println("after class");
	}
	
	@Test
	public void WebLoginHomeLoan() {
		//selenium
		System.out.println("web login home");
	}
	
	@Test(groups = {"Mobile"})
	public void MobileLoginHomeLoan() {
		//appium
		System.out.println("mobile login home");
	}
	
	@Test
	public void LoginAPIHomeLoan() {
		//rest api automation
		System.out.println("api login home");
	}
	
	//@BeforeTest method executes before all methods in the test have executed
	@BeforeTest
	public void BeforeTest() {
		System.out.println("before test");
	}
	
	//@AfterTest method executes after all methods in the test have executed
	@AfterTest
	public void AfterTest() {
		System.out.println("after test");
	}
}
