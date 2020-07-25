package Enriquemendez;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Seleniumejemplo {
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/";
	String user="Admin,password";
	
	@BeforeTest
	public void startWebDriver() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver(options);
		driver.get(url);
	}
	
	@Test(priority=1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).submit();
	
	}
	
	@Test(priority=2)
	public void login(String user, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Reporter.log("Usuario Ingresado: " + user + "\n", true);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Reporter.log("Contraseña Ingresado: " + password + "\n", true);
		driver.findElement(By.id("btnLogin")).submit();
		Reporter.log("clic en Login\n", true);	
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.close();
		
	}
	
	
//	public static void main (String [] args) {
//	
//	
//	System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).submit();
//		
//		//puede ser .clic o .submit para dar click
//		
//		
//		
////		driver.findElement(By.id("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
////		driver.findElement(By.id("//input[@id=\"txtUsername\"]")).clear();
////		driver.findElement(By.id("//input[@id=\"txtUsername\"]")).sendKeys("Admin3");
////	
////	
//	}
}
