package test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {
	
	public WebDriver driver = null;
	public Properties prop = new Properties();
	
	@BeforeSuite
	public void Login() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chomedriver_win32\\chromedriver.exe");
		FileInputStream fis = new FileInputStream("C:\\Users\\Cam\\Documents\\GitHub\\Selenium-Frameworks\\GlobalEnvironmentalVariables\\src\\test\\datadriven.properties");
		prop.load(fis);
		
		//runs on a browser based on browser selection in datadriven.properties
		if(prop.getProperty("browser").contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (prop.getProperty("browser").contains("chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		System.out.println("login");
		//selenium code to login
		
	}
	
	@Test
	public void AppTest() {
		//selenium code to test application
		System.out.println("application testing");
	}
	
	@AfterSuite
	public void Logout() {
		//selenium code to logout
		System.out.println("logout");
		
		driver.quit();
	}
}
