package login.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.CommonsMethods;

public class Login extends CommonsMethods {
	
	@FindBy(id="txtUsername")
	WebElement txt_usuario;
	@FindBy(name="txtPassword")
	WebElement txt_contrasena;
	@FindBy(className="button")
	WebElement btn_iniciarSesion;
	@FindBy(xpath="//div[@id='content']/div[2]/span")
	WebElement label_title;
	@FindBy(xpath="//h1")
	WebElement label_dashboard;
	
	public Login(WebDriver driver) {
	    super(driver);
	}
	
	public void loginHRM(String userName, String password) throws Exception {
		reviewElement(label_title);
		setText(txt_usuario, userName);
		setText(txt_contrasena, password);
		clickObject(btn_iniciarSesion);
		reviewElement(label_dashboard);
		takeScreenShot("Login");
	}
	
	
	
	
	

}
