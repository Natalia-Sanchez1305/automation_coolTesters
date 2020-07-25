package perzamTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumEjemplo1 {
	/*
	 * Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/)
	 * Acceder correctamente al sistema (usuario:Admin password:admin123 )
	 * Validar que existen datos en la grafica del tab de Dashboard.
	 * salir del sistema.
	 */

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
		// Crear objeto chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.perzam.com.co/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		//Localizar el elemento de usuario
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin2");
		
	}

}
