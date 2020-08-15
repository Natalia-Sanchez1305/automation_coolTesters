package NataliaSanchez;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumEjemplo2 {
	
	String url = "https://opensource-demo.orangehrmlive.com";
	String user = "Admin";
	String password = "admin123";
	WebDriver driver;
	//Elementos
	@FindBy(id="txtUsername")
	WebElement txt_usuario;
	@FindBy(name="txtPassword")
	WebElement txt_contraseña;
	@FindBy(id="btnLogin")
	WebElement btn_login;
	@FindBy(id="welcome")
	WebElement btn_welcome;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement link_logout;
	@FindBy(xpath="//div[@id=mainMenu']")
	WebElement tbl_menu;
	
	@BeforeTest
	public void startWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver" , "chromedriver\\chromedriver.exe");
		driver = new ChromeDriver (options);
		PageFactory.initElements(driver, this);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void loginFail() {
		txt_usuario.sendKeys("Admin");
		txt_contraseña.sendKeys("admin12");
		btn_login.submit();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(15))
			.ignoring(NoSuchElementException.class);
					
			
			wait.until(ExpectedConditions.visibilityOf(tbl_menu));
			
				
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(tbl_menu));
//		wait.until(ExpectedConditions.elementToBeClickable(tbl_menu));
//		if (tbl_menu.isDisplayed()) {
//			Reporter.log("El login fue exitoso", true);
//		} else {
//			Reporter.log("El login No fue exitoso" , true);
//		}
//		if (driver.getPageSource().contains("Dashboard")) {
//			Reporter.log("El login fue éxitoso" , true);
//		} else {
//			Assert.assertTrue(false);
//		}

	}
	
	
	
	
	private FluentWait<WebDriver> withTimeout(Duration ofSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority=2)
	public void login() {
		txt_usuario.clear();
		txt_contraseña.clear();
		txt_usuario.sendKeys(user);
		Reporter.log("Usuario Ingresado:" + user, true);
		txt_contraseña.sendKeys(password);
		Reporter.log("Password Ingresado: " + password + "\n",true);
		btn_login.click();
		Reporter.log("Click en Login\n", true);
		
		if (tbl_menu.isDisplayed()) {
			//Reporter.log("El login fue exitoso", true);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tbl_menu));
		wait.until(ExpectedConditions.elementToBeClickable(tbl_menu));
		if (tbl_menu.isDisplayed()) {
		
		if (driver.getPageSource().contains("Dashboard")) {
			Reporter.log("El login fue éxitoso" , true);
			Assert.assertTrue(true,"El login fue éxitoso");
		}
	}
	
	
//	@AfterTest
//	public void closeBrowser() {
//		btn_welcome.click();
//		link_logout.click();
	//	driver.close();
		
	}
	
	/*
	*@Descripcion Metodo que resiva que un elemento exista
	*@Autor Natalia Sánchez Sánchez
	*@Date 01/08/2020
	*@Parametros WebElement
	**/
	
	public void verificarElemento(WebElement objecto) {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(objecto));
			wait.until(ExpectedConditions.elementToBeClickable(objecto));
			Reporter.log("El elemento existe:", true);
		} catch (Exception e) {
			Reporter.log("El elemento no existe:", true);
			e.printStackTrace();
		}
	}
		
		/*
		 * QDescripcion Metodo para hacer un scroll a un webElement 
		 * *@Autor Natalia Sánchez Sánchez
		 * @Date 01/08/2020
		 * @Parametros WebElement
		 */
		
		public void scrollToElement (WebElement objecto) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", objecto);
			} catch (Exception e) {
				Reporter.log("Scroll al elemento :", true);
				e.printStackTrace();
			}
			
		}
		
	}
	

/*
 * QDescripcion Metodo para ingresar texto
 * *@Autor Natalia Sánchez Sánchez
 * @Date 01/08/2020
 * @Parametros WebElement
 */

public void IngresarTexto (WebElement objecto , String texto) {
	try { verificarElemento (objecto);
	scrollToElement(objecto);
	objecto.sendKeys(texto);
		Reporter.log("El texto se ingreso correctamente :" + texto , true);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

}

}
