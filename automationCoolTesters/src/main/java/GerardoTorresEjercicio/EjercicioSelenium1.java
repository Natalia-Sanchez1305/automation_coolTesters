package GerardoTorresEjercicio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class EjercicioSelenium1 {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	
			
	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options= new ChromeOptions();
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
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
//		Reporter.log("Usuario Logeado",true);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
	}
	
	@AfterTest
	public void closeBrowser ()
	{
		driver.close();
		
		//	public static void main(String[] args) {
	}
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		//Sirve para maximizar la pantalla.
//		driver.manage().window().maximize();
//		//esto sirve para abrir primero una pagina y despues la que se ejecutara.
//		
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		
//		//Localizar el elemento de usuario para ingresarlo
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
//		
////		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
////		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
////		driver.findElement(By.name("txtUsername")).clear();
////		driver.findElement(By.name("txtUsername")).sendKeys("Admin3");
//	}
//
}
