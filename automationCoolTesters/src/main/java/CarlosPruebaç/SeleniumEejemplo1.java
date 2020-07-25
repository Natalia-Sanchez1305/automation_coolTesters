package CarlosPruebaç;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumEejemplo1 {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver driver;

	@BeforeTest
	public void startDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximazes");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(url);

	}

	@Test(priority = 1)
	public void loginFail() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1");
		driver.findElement(By.id("btnLogin")).submit();
	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).submit();
	}

	@AfterTest

	public void closebrowser() {
		driver.close();
	}
}

// 1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
// 2. Acceder correctamente al sistema (usuario:Admin password:admin123 )
// 3. Validar que existen datos en la grafica del tab de Dashboard.
// 5. salir del sistema.

//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
//		// crear objeto Chromedriver
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://google.com/");
//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//		// localizar elemento de usuario para ingreso
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).submit();
//	}
//
//}
