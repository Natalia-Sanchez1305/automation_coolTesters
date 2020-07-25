package ernestoEjercicioSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumEjemplo {
	
	String url = "https://opensource-demo.orangehrmlive.com";
	WebDriver driver;
	
	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start- maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
	}
	@Test(priority=1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Reporter.log("Usuario ingresado", true);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("btlogin")).submit();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		
	}

}


//public class SeleniumEjemplo1 {
//	
//	/*
//	 1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
//	 2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
//	 3. Validar que existen datos en la grafica del tab de Dashboard.
//	 5. salir del sistema.
//	 
//	 */
//	
//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		//crear objeto chromedriver	
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com.mx");
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
		

//	}
//
//}
