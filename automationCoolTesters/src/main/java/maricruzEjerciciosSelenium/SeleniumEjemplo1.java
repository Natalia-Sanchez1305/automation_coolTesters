package maricruzEjerciciosSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumEjemplo1 {
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

	@Test(priority = 2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Reporter.log ("Usuario Ingresado", true);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(priority = 1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		;
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).click();
	}

	@AfterTest
	public void closebrowser() {
		driver.close();
	}

//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		//driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
//		
////		driver.findElement(By.xpath("////input[@id=\"txtUsername\"]")).clear();
////		driver.findElement(By.xpath("////input[@id=\"txtUsername\"]")).sendKeys("Admin2");
////		
////		driver.findElement(By.name("txtUsername")).clear();
////		driver.findElement(By.name("txtUsername")).sendKeys("Admin2");
//		
//		
//		
//	}

}
