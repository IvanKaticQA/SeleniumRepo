package projectPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addANewAddressButton;
	WebElement addressField;
	WebElement saveButton;
	WebElement cityField;
	WebElement stateField;
	WebElement postalCodeField;
	WebElement homePhoneField;
	WebElement titleForNewAddressField;
	WebElement textFromUpdatedAddress;
	WebElement testFromAddressTitle;
	public AddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[9]/a[1]/span"));
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[9]/a[2]/span"));
	}
	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
	}
	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"submitAddress\"]/span"));
	}
	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}
	public WebElement getStateField() {
		return driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
	}
	public WebElement getPostalCodeField() {
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getHomePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
	}
	public WebElement getTitleForNewAddressField() {
		return driver.findElement(By.id("alias"));
	}
	public WebElement getTestFromAddressTitle() {
		return driver.findElement(By.className("page-subheading"));
	}
	public WebElement getTextFromUpdatedAddress() {
		return driver.findElement(By.className("address_address1"));
	}
	
	public void UpdateButtonClick() {
		this.getUpdateButton().click();
	}
	public void DeleteButtonClick() {
		this.getDeleteButton();
	}
	public void AddANewAddressButtonClick() {
		this.getAddANewAddressButton().click();
	}
	public void AddressInputField(String address) {
		this.getAddressField().clear();
		this.getAddressField().sendKeys(address);
	}
	public void SaveButtonClick() {
		this.getSaveButton().click();
		
	}
	public void CityInputField(String city) {
		this.getCityField().clear();
		this.getCityField().sendKeys(city);

}
	public void StateInputField() {
		this.getStateField().click();
		
	}
	public void PostalCodeInputField(String PostalCode) {
		this.getPostalCodeField().clear();
		this.getPostalCodeField().sendKeys(PostalCode);
	}
	public void HomePhoneInputField(String homePhone) {
		this.getHomePhoneField().clear();
		this.getHomePhoneField().sendKeys(homePhone);
	}
	public void TextForNewAddressInputField(String text) {
		this.getTitleForNewAddressField().clear();
		this.getTitleForNewAddressField().sendKeys(text);
	}
	public String TextFromUpdatedAddress () {
		return this.getTextFromUpdatedAddress().getText();
	}
	public String textFromAddressTitle () {
		return this.getTestFromAddressTitle().getText();
	}
	public String textFromAddANewAddress () {
		return this.getAddANewAddressButton().getText();
	}

	}

