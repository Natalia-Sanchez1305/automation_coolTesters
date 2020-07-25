package perzamTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumEjemplo1 {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;
	String user="Admin", password="admin123";
	
	@BeforeTest
	public void starDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--Start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);
	}
	
	@Test(priority=1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("adadadadada");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Reporter.log("Usuario Ingresado", true);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("Password Ingresado", true);
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@AfterTest
	public void closeBrower() {
		driver.close();
	}
	
	/*
	 * Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
	 * Acceder correctamente al sistema (usuario:Admin password:admin123 )
	 * Validar que existen datos en la grafica del tab de Dashboard.
	 * salir del sistema.
	 */

//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		// Crear objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://www.google.com.co/");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		//Localizar el elemento de usuario
//		//driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear(); // Ejemplo Xpath
//		//driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin"); // Ejemplo Xpath
//		driver.findElement(By.id("txtUsername")).clear();
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).clear();
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
//		driver.findElement(By.xpath("//a[@id=\"menu_admin_viewAdminModule\"]")).click();
//		
//	}

}
