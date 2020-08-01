package perzamTest1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
 * 1. Entrar al sistema de HR (https://opensource-demo.orangehrmlive.com/) 
 * 2. Acceder correctamente al sistema (usuario:Admin password:admin123 ) 
 * 3. Validar que existen datos en la grafica del tab de Dashboard. 5. salir del sistema.
 */
public class SeleniumEjemplo4 {
    String url = "https://opensource-demo.orangehrmlive.com";
    String user="Admin";
    String password = "admin123";
    WebDriver driver;
    WebDriverWait wait;
    //elementos
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
    @FindBy(xpath="//div[@id='mainMenu']")
    WebElement tbl_menu;
    
    @BeforeTest
    public void startWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
    }
    
    @Test(priority=1)
    public void loginFail() {
        txt_usuario.sendKeys("Admin");
        txt_contraseña.sendKeys("admin12");
        btn_login.submit();
        
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(7))
//                .ignoring(NoSuchElementException.class);
//                
//        wait.until(ExpectedConditions.visibilityOf(tbl_menu));
    
        wait.until(ExpectedConditions.visibilityOf(tbl_menu));
        wait.until(ExpectedConditions.elementToBeClickable(tbl_menu));
        if(driver.getPageSource().contains("Dashboard")) {
            Reporter.log("El login fue exitoso", true);
        }else {
            Assert.assertTrue(false, "El login No fue exitoso");
        }
    }
    
    @Test(priority=2)
    public void login() {
        txt_usuario.clear();
        txt_contraseña.clear();
        txt_usuario.sendKeys(user);
        Reporter.log("Usuario Ingresado: " + user , true);
        txt_contraseña.sendKeys(password);
        Reporter.log("Password Ingresado: " + password +"\n" , true);
        btn_login.click();
        Reporter.log("Click en Login\n", true);
        
    
        wait.until(ExpectedConditions.visibilityOf(tbl_menu));
        wait.until(ExpectedConditions.elementToBeClickable(tbl_menu));
        
        if(tbl_menu.isDisplayed()) {
            Reporter.log("El login fue exitoso", true);
        }
        
//        if(driver.getPageSource().contains("Dashboard")) {
//            Reporter.log("El login fue exitoso", true);
//            Assert.assertTrue(true, "El login fue exitoso");
//        }
        
    }
    
    @AfterTest
    public void closeBrowser() {
        btn_welcome.click();
        link_logout.click();
//        driver.close();
    }
    

 


}
