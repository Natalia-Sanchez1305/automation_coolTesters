package CarlosPruebaç;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEejemplo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
		//crear objeto Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

}
