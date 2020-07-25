package davidFlores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicChromeDriverTest {
	
	  public static void main(String[] args) { // TODO Auto-generated method stub
	  System.setProperty("webdriver.chrome.driver",
	  "chromedriver\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com");
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  //driver.findElement(By.id("btnLogin")).submit();
	  
	  //driver.findElement(By.id("txtUsername")).clear();
	  
	  //driver.findElement(By.name("txtUsername")).sendKeys("Admin2");
	  //driver.findElement(By.name("txtUsername")).clear();
	  
	  //driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin3");
	  //driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).clear(); }
	 

	  }
	  	  
}
