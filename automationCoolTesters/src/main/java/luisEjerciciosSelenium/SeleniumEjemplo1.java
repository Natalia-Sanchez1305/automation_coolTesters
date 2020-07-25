package luisEjerciciosSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Indicaciones del ejercicio
	/*
		1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
		2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
		3. Validar que existen datos en la grafica del tab de Dashboard.
		5. salir del sistema.
	*/

public class SeleniumEjemplo1 {
	String url = "http://opnersource-demo.orangehrmlive.com";
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
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
		
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
		
	//Indicaciones del ejercicio
	/*
		1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
		2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
		3. Validar que existen datos en la grafica del tab de Dashboard.
		5. salir del sistema.
	*/

//	public static void main(String[]args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		
//		//Crear objeto chromedriver
//		WebDriver driver = new ChromeDriver ();
//		
//		//Para abrir la ventana maximizada
//		driver.manage().window().maximize();
//		
//		//Para abrir en blanco o cualquier otra pagina el navegador
//		driver.get("https://www.google.com");
//		
//		//Para abrir ahora si la pagina que deseo ver
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		
//		//Localizar elemento de usuario para ingresarlo
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		
//		//Otra forma de localizar el elemento 'usuario' usando el xpath
//		//driver.findElement(By.xpath("//input[@id=\txtUsername\"]")).sendKeys("Admin")
//		
//		//Localizar elemento de password para ingresarlo
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		
//		//Otra forma de localizar el elemento 'password' usando el xpath
//		//driver.findElement(By.xpath("//input[@id=\txtPassword\"]")).sendKeys("admin123")
//		
//		//Localizar elemento del boton de login
//		driver.findElement(By.id("btnLogin")).click();
		
	}

	
	
	
