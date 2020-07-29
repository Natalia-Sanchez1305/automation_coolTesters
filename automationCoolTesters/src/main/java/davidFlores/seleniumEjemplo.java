package davidFlores;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumEjemplo {
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	String user, password;

	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe"); 
		driver = new ChromeDriver(options);
		driver.get(url);
		user = "Admin";
		password = "admin123";
	}
	
	@Test(priority=1)
	public void loginFail() {
		WebElement txt_usuario = driver.findElement(By.id("txtUsername"));
		txt_usuario.sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Reporter.log("Usuario Ingresado" + "\n" + user + " " +  password, true);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=3)
	public void logout() throws InterruptedException{
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	

}
