package raulEjercicioSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class seleniumEjercicio_1 {
	String url = "https://opensource-demo.orangehrmlive.com";
	WebDriver driver;
	String user = "Admin";
	String password = "admin123";
	
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
	public void failLogin() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Administrador");		
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");		
		driver.findElement(By.id("btnLogin")).submit();		
	}
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Reporter.log("Usuario Ingresado "+user+"\n",true);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("Password Ingresado "+password+"\\n",true);
		driver.findElement(By.id("btnLogin")).submit();		
	}
	@Test(priority=3)
	public void logout() {
		driver.findElement(By.id("welcome")).click();
		Reporter.log("Click welcome",true);
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		Reporter.log("Click Log Out",true);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");		
//		// crear objeto WebDriver
//		WebDriver driver = new ChromeDriver();	
//		driver.get("https://opensource-demo.orangehrmlive.com");		
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).clear();
//		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).submit();		
//	}

}
