package MaryOrtiz;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejercicio {
	String url = "http://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	String user;
	String password;

	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		user = "Admin";
		password = "admin123";
		
	}
	
	@Test(priority=1)
	public void logionFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void logion() {
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Reporter.log("Usuario ingresado: " + user , true);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("Password ingresado: " + password , true);
		driver.findElement(By.id("btnLogin")).submit();
		Reporter.log("Clic en login", true);
	}
	
	@Test(priority=3)
	public void logout() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.id("welcome")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
		Reporter.log("Clic en logout", true);
	}
	
	
	@AfterTest
	public void closeBrowser() {
		//driver.close();
		
	}
	
//
//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//			//Crear el objeto WebDriver
//		WebDriver driver = new ChromeDriver();
//			//Maximizar la pagina
//		driver.manage().window().maximize();
//		
//			//Abrir el navgeador y despues ingresar a la pagina
//		//driver.get("https://www.google.com");
//		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		
//			//Abrir directamente la pagina
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		
//			//Logearbis a la pagina
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).submit();
//		//driver.findElement(By.id("btnLogin")).click();
//		
//		
//			//Ingresar valor en el campo Username con diferentes selectores
//		//driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
//		//driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).clear();
//		//driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admnin2");
//		//driver.findElement(By.name("txtUsername")).clear();
//		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//		
//		
//		
//	}
}