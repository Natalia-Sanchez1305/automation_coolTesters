package cindyEjerciciosSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumEjemplo1 {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	String user = "Admin";
	String password = "admin123";
	
		
	@BeforeTest
	
	public void starWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--star-maximazed");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		 
		
	}
	
	@Test(priority=1)
	public void loginFail() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)	
	public void login() {		
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("user");
		Reporter.log("Usuario Ingresado" + user , true);
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

// public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		
//		//crear un objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize(); 
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		//localizar el elemento de usuario para ingresarlo
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		
		
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
//		
//		driver.findElement(By.name("txtUsername")).clear();
//		driver.findElement(By.name("txtUsername")).sendKeys("Admin3");
//		
//		driver.findElement(By.id("txtPassword")).clear();
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
	}


