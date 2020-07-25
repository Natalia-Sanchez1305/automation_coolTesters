package javierEjercicioSelenium;

import java.util.concurrent.TimeUnit;

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
	String url = "http://opensource-demo.orangehrmlive.com";
	WebDriver driver;
	
	//Guardamos los elementos en variables 
	//WebElement txt_usuario 	= driver.findElement(By.id("txtUsername"));
	
	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get(url);
		
	}
	
	@Test (priority = 1)
	public void loginFail() {
		
		// Localizar el elemento de usuario para usarlo mediante el NAME
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin3");
				
		// Para encontrar el password
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
			
		//Para presionar el boton Login
		driver.findElement(By.id("btnLogin")).submit();
		
	}
	
	@Test (priority = 2)
	public void login() {
		
		// Localizar el elemento de usuario para usarlo mediante el NAME
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		Reporter.log("Ususario Ingresado", true);
				
		// Para encontrar el password
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			
		//Para presionar el boton Login
		driver.findElement(By.id("btnLogin")).submit();
		
	}
	
	@Test (priority = 3)
	public void logout() {
		
		// Localizar el elemento de usuario para usarlo mediante el NAME
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("welcome")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
//		
//		
//		
//		Reporter.log("Ususario Ingresado", true);
//				
//		// Para encontrar el password
//		driver.findElement(By.id("txtPassword")).clear();
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//			
//		//Para presionar el boton Login
//		driver.findElement(By.id("btnLogin")).submit();
		
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		//driver.close();
	}

}

	
//	public static void main (String[] arg) {
//		
//		/*System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		// crear objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.get("http://google.com");
//		// para movernos a otra URL
//		driver.navigate().to("http://opensource-demo.orangehrmlive.com");
//		// Localizar el elemento de usuario para usarlo mediante el ID
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin3");
//		
//		//Localizar el elemento de usuario para usarlo mediante XPATH
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
//		
//		// Localizar el elemento de usuario para usarlo mediante el NAME
//		driver.findElement(By.name("txtUsername")).clear();
//		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//		
//		// Para encontrar el password
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		
//		//Para presionar el boton Login
//		driver.findElement(By.id("btnLogin")).click();
//		
//		*/
//			
//	}

//}
