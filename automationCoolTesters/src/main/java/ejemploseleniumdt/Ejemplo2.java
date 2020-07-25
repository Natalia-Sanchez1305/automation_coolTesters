package ejemploseleniumdt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo2 {
	
	WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//abre el navegador y en tamaño completo
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		//localizar el elemento de usuario para ingresarlo
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Submit se puede usar tbm es parecido al click
	}

}
