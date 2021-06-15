package projectPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {
	WebDriver driver;
	WebElement WishlistNameInputField;
	WebElement SaveButton;
	WebElement DeleteWishlist;
	WebElement WishlistNameText;
	WebElement RefreshPage;
	WebElement PrintedChiffonDressProduct;
	WebElement AddProductToWishlist;
	WebElement AddedToCartCloseButton;
	WebElement ProductQuantity;
	public MyWishlistPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getWishlistNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getDeleteWishlist() {
		return driver.findElement(By.className("icon-remove"));
	}
	
	public WebElement getWishlistNameText() {
		return driver.findElement(By.id("wishlist"));
	}
	
	public WebElement getPrintedChiffonDressProduct() {
		return driver.findElement(By.xpath("//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/div/h5/a"));
	}
	
	public WebElement getAddProductToWishlist() {
		return driver.findElement(By.id("wishlist_button"));
	}
	
	public WebElement getAddedToCartCloseButton() {
		return driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
	}
	
	public WebElement getProductQuantity() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	public void WishlistNameInputField(String name) {
		this.getWishlistNameInputField().clear();
		this.getWishlistNameInputField().sendKeys(name);
	}
	public void SaveButtonClick() {
		this.getSaveButton().click();
	}
	public void DeleteWishlistButtonClick() {
		this.getDeleteWishlist().click();
	}
	public String TextFromFirstWishList() {
		return this.getWishlistNameText().getText();
		
	}
	
	public void PrintedChiffonDressClick() {
		this.getPrintedChiffonDressProduct().click();
		
	}
	public void AddProductToWishlistClick () {
		this.getAddProductToWishlist().click();
	}
	public void CloseButtonClick () {
		this.getAddedToCartCloseButton().click();
	}
	public void QuantityInputField(String broj) {
		this.getProductQuantity().clear();
		this.getProductQuantity().sendKeys(broj);
	}
	
	
	
	

}
