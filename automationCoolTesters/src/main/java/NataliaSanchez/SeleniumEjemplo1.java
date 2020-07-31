package NataliaSanchez;

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
	String user = "Admin";
	String password = "admin123";
	WebDriver driver;
	WebElement txt_Usuario = driver.findElement(By.id("txtUsername"));
	WebElement txt_password = driver.findElement(By.id("txtPassword"));
	
	
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
	public void loginFail() {
		txt_Usuario.sendKeys("Admin");
		txt_password.sendKeys("admin123");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12");
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void login(String user, String password) {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		Reporter.log("Usuario Ingresado:" + user + "\n" , true);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("Password Ingresado:" + password + "\n" , true);
		driver.findElement(By.id("btnLogin")).submit();
		Reporter.log("Clic en Login\n" , true);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
//	/*
//	*Entrar al sistema RH (https://opensource-demo.orangehrmlive.com)
//	*Acceder correctamente a el sistema (usuario:Admin Password:admin123)
//    *Validar que existen datos en la grafica del tab de Deshboard
//    *Salir del sistema 
//	 */
//	/*public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
//		//Crear objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");	
//		//localizar el elemento usuraio para ingresarlo
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
//		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
//		driver.findElement(By.name("txtUsername")).clear();
//		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//		//Localizar el elemento de password para ingresarlo
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		//Dar clic en el botón de login
//		driver.findElement(By.id("btnLogin")).click();
//		}*/

}
