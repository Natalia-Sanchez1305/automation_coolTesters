package Loginorange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

	String url = "https://opensource-demo.orangehrmlive.com/";
	String user="Admin" ;
	String password="admin123";
	WebDriver driver;
	@BeforeTest
	
	public void startWebeDriver() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
		driver = new ChromeDriver (options);
		driver.get(url);
	}
	
	@Test (priority=1)
	public void loginFail() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).submit();
		
	}
	
	@Test(priority=2)
	public void Login(String user, String password) {
		
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("user");
		Reporter.log("usuario Ingresado" + user, true);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("password Ingresado" + password, true);
		driver.findElement(By.id("btnLogin")).submit();
		Reporter.log("clic en login" , true);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
	
//	public static void main(String[] args) {
//		
//			
//		// Crear objeto chromedriver
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		//driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
//		//driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin2");
//		//driver.findElement(By.name("txtUsername")).clear();
//		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//		
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		//driver.findElement(By.id("txtPassword")).clear();
//		//driver.findElement(By.name("txtPassword")).sendKeys("123");
//		
//		driver.findElement(By.id("btnLogin")).click();
		
		
//	}

}
