package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement signOutButton;
	WebElement MyAddressButton;
	WebElement MyPersonalInformationButton;
	WebElement MyWishlistButton;
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	
	public WebElement getMyAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
	}
	
	public WebElement getMyPersonalInformationButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
	}
	
	public WebElement getMyWishlistButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
	}
	
	public void SignOutButtonClick () {
		this.getSignOutButton().click();
	}
	public String TextFromSignOutButton() {
		return this.getSignOutButton().getText();
	}
	public void MyAddressButtonClick () {
		this.getMyAddressButton().click();
	}
	public void MyPersonalInformationButtonClick () {
		this.getMyPersonalInformationButton().click();
	}
	public void MyWishlistButtonClick() {
		this.getMyWishlistButton().click();
		
	}
	

}
