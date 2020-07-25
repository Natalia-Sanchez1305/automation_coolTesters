package CarlosEjerciciosSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
//2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
//3. Validar que existen datos en la grafica del tab de Dashboard.



public class SeleniumEjemplo1 {
	String url = "https://opensource-demo.orangehrmlive.com/";
	String user="Admin";
	String password = "admin123"
	WebDriver driver;
	
	@BeforeTest
	public void startWebDriver()  {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
		
	}
	
	@Test(priority=1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).submit();  // de selenium
	}
	
	@Test(priority=2)
	public void login(String user, String password) {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Reporter.log("Usuario ingresado\n" + user, true);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Reporter.log("Password ingresado\n" + password, true);
		driver.findElement(By.id("btnLogin")).submit();  // de selenium
		Reporter.log("Clic en Login\n", true);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		//crear objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		// navigate permite cambiar de un url a otro
//		//otro forma mas comun pero menos optima? -->
//		//driver.get("https://opensource-demo.orangehrmlive.com/");
//		
//		//localizar el elemento de usuario para ingresarlo
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).submit();  // de selenium
//		//driver.findElement(By.id("btnLogin")).click(); // estandar
//	
////		driver.findElement(By.xpath("//input[id=\"txtUsername\"]")).clear();
////		driver.findElement(By.xpath("//input[id=\"txtUsername\"]")).sendKeys("Admin2");
////		
////		driver.findElement(By.xpath("txtUsername")).clear();
////		driver.findElement(By.xpath("txtUsername")).sendKeys("Admin3");
//
//		
//	};
}
