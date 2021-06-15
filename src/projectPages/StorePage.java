package projectPages;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage {
	WebDriver driver;
	WebElement DressesButton;
	WebElement CasualDressesButton;
	WebElement PrintedDressView;
	WebElement PrintedSummerDressView;
	WebElement PrintedChiffonDressView;
	WebElement AddToCartButton;
	WebElement QuantityInputField;
	WebElement SizeDropDown;
	WebElement PrintedDressViewFromSubCategory;
	WebElement ProceedToCheckoutButton;
	WebElement RemoveItemFromCartIconButton;
	WebElement CloseWindowAfterAddingToCart;
	WebElement textFromTotalPrice;
	WebElement textFromEmptyCart;
	
	public StorePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getDressesButton() {
		return driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
	}
	public WebElement getCasualDressesButton() {
		return driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]")) ;
	}
	public WebElement getPrintedDressView() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
	}
	public WebElement getPrintedDressViewFromSubCategory() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li"));
	}
	public WebElement getPrintedSummerDressView() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a"));
	}
	public WebElement getPrintedChiffonDressView() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/h5/a"));
	}
	public WebElement getAddToCartButton() {
		return driver.findElement(By.id("add_to_cart"));
	}
	public WebElement getQuantityInputField() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	public WebElement getSizeDropDown() {
		return driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
	}
	
	
	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium"));
	}
	
	public WebElement getRemoveItemFromCartIconButton() {
		return driver.findElement(By.className("cart_quantity_delete"));
	}
			
	public WebElement getCloseWindowAfterAddingToCart() {
		return driver.findElement(By.className("cross"));
	}
	
	public WebElement getTextFromTotalPrice() {
		return driver.findElement(By.id("total_price"));
	}
	
	public WebElement getTextFromEmptyCart() {
		return driver.findElement(By.cssSelector(".alert.alert-warning"));
	}
	public void DressesButtonClick() {
		this.getDressesButton().click();
	}
	public void CasualDressesButtonClick() {
		this.getCasualDressesButton().click();
	}
	public void PrintedDressViewClick() {
		this.getPrintedDressView().click();
	}
	public void PrintedSummerDressViewClick() {
		this.getPrintedSummerDressView().click();
	}
	public void PrintedChiffonDressViewClick() {
		this.getPrintedChiffonDressView().click();
	}
	public void AddToCartButtonClick() {
		this.getAddToCartButton().click();
	}
	public void InputFieldQuantity(String number) {
		this.getQuantityInputField().clear();
		this.getQuantityInputField().sendKeys(number);
	}
	public void SizeCButtonClick() {
		this.getSizeDropDown().click();
	}
	public void PrintedDressViewFromSubCategoryClick() {
		this.getPrintedDressViewFromSubCategory().click();
	}
	public void ProceedToCheckoutButtonClick() {
		this.getProceedToCheckoutButton().click();
		
	}
	public void RemoveItemFromCartButtonClick() {
		this.getRemoveItemFromCartIconButton().click();
	}
	public void CloseWindowButtonClick () {
		this.getCloseWindowAfterAddingToCart().click();
	}
	public String TextFromTotalPrice () {
		return this.getTextFromTotalPrice().getText();
	}
	public String TextFromEmptyCart () {
		return this.getTextFromEmptyCart().getText();
	}

		
	}


