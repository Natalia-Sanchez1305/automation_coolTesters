package SeleniumEjemploVian;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EjemploSeleniumVian {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	
	
	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		
	}
	
	//testFail
	@Test(priority=1)
	public void loginFail() {
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Admin123");
	driver.findElement(By.id("btnLogin")).submit();
	}
	
	//TestOK
	@Test(priority=2)
	public void loginOk() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}

	//public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
		//		 WebDriver driver= new ChromeDriver();
			//	 driver.manage().window().maximize();
			//	 driver.get("https://opensource-demo.orangehrmlive.com/");
				 //localiza el elemento de usuario para ingresarlo
				 
			//	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			//	 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				// driver.findElement(By.id("btnLogin")).submit();



	//}

}
