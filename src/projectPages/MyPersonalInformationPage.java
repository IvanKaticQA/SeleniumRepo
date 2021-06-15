package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInformationPage {
	WebDriver driver;
	WebElement FirstNameInputField;
	WebElement LastNameInputField;
	WebElement EmailInputField;
	WebElement BirthDay;
	WebElement BirthMonth;
	WebElement BirthYear;
	WebElement CurrentPasswordInputField;
	WebElement NewPasswordInputField;
	WebElement ConfirmationPasswordInputField;
	WebElement SaveButton;
	WebElement TextFromSuccesfullyEditedPersonalInformation;
	public MyPersonalInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getBirthDay() {
		return driver.findElement(By.xpath("//*[@id=\"days\"]/option[7]"));
	}
	public WebElement getBirthMonth() {
		return driver.findElement(By.xpath("//*[@id=\"months\"]/option[9]"));
	}
	public WebElement getBirthYear() {
		return driver.findElement(By.xpath("//*[@id=\"years\"]/option[27]"));
	}
	public WebElement getCurrentPasswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getNewPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getConfirmationPasswordInputField() {
		return driver.findElement(By.id("confirmation"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	
	public WebElement getTextFromSuccesfullyEditedPersonalInformation() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}
	public void InputFirstName(String name) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(name);
	}
	public void InputLastName(String LastName) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(LastName);
	}
	public void InputEmailAddress(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}
	public void BirthDayDropBoxClick() {
		this.getBirthDay().click();
		
	}
	public void BirthMonthDropBoxClick() {
		this.getBirthMonth().click();
	}
	public void BirthYearDropBoxClick() {
		this.getBirthYear().click();
	}
	public void InputCurrentPassword(String CurrentPassword) {
		this.getCurrentPasswordInputField().clear();
		this.getCurrentPasswordInputField().sendKeys(CurrentPassword);
	}
	public void InputNewPassword(String NewPassword) {
		this.getNewPasswordInputField().clear();
		this.getNewPasswordInputField().sendKeys(NewPassword);
	}
	public void InputPasswordForConfirmation(String NewPassword) {
		this.getConfirmationPasswordInputField().clear();
		this.getConfirmationPasswordInputField().sendKeys(NewPassword);
		
	}
	public void SaveButtonClick() {
		this.getSaveButton().click();
	}
	public String TextFromSuccesfullyEditedPersonalInfromation () {
	 return	this.getTextFromSuccesfullyEditedPersonalInformation().getText();
	}
}
