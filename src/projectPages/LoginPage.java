package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement signInButton;
	WebElement badCredentialsText;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getBadCredentialsText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	
	public void InputEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
		
	}
	public void InputPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
	}
	public void SignInButtonClick() {
		this.getSignInButton().click();
	}
	public String textFromLoginWithBadCredentials() {
		return this.getBadCredentialsText().getText();
	}
	public String textFromSignInButton () {
		return this.getSignInButton().getText();
	}
		
	
}