package danielEjerciciosSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumEjemplo1 {
	String url = "https://opensource-demo.orangehrmlive.com";
	String user = "Admin";
	String password = "admin123";
	WebDriver driver;
	
	@BeforeTest
	public void startWebDriver() {
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
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("user");		
		Reporter.log("Usiario Ingresado: " + user, true);
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		Reporter.log("Password Ingresado: " + password + "\n", true);
		driver.findElement(By.id("btnLogin")).submit();
		Reporter.log("Click en Login", true);
	}
	
	@Test(priority=3)
	public void logout() {
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
	


	/*
		1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
		2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
		3. Validar que existen datos en la grafica del tab de Dashboard.
		5. salir del sistema.
	*/
	
//	public static void main(String[] args) {
//		/*
//		referenciamos a la ruta de la carpeta del chromedriver
//		chromedriver\\chromedriver.exe
//		se agregan como parametros el driver y la ruta (se pone doble slash por que es palabra reservada
//		*/		
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		//crear el objeto chromedriver
//		WebDriver driver = new ChromeDriver();
//		//nos movemos de una url a otra
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		//driver.get("https://opensource-demo.orangehrmlive.com/");
//		
//		//LOCALIZADORES
//		//son formas de localizar el elemento usuario para ingresar su valor
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		
//		//driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear();
//		//driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin2");
//		
//		//driver.findElement(By.name("txtUsername")).clear();
//		//driver.findElement(By.name("txtUsername")).sendKeys("Admin3");
//		
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
//		//driver.findElement(By.id("btnLogin")).submit();
		
//	}

//}
