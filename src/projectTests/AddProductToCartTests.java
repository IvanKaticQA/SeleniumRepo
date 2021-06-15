package projectTests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sun.security.action.GetIntegerAction;

public class AddProductToCartTests extends ProjectBaseTests {
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		logInValidCredentials();
	}
	@Test(priority = 0)
	public void VerifyThatUserCanAddProductToCart ()  {
		StorePage.DressesButtonClick();
		StorePage.CasualDressesButtonClick();
		StorePage.PrintedDressViewFromSubCategoryClick();
		StorePage.AddToCartButtonClick();
		assertEquals(true, driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).isEnabled());
		
	
	}
	@Test(priority = 5)
	public void VerifyThatUserCanChangeQuantityAndSizeBeforeAddingProductToCart () {
		StorePage.DressesButtonClick();
		StorePage.CasualDressesButtonClick();
		StorePage.PrintedDressViewFromSubCategoryClick();
		String number = String.valueOf(citacIzExcela.getIntegerData("APTC2", 9, 2));
		numbersFormFilling(number);
		StorePage.SizeCButtonClick();
		StorePage.AddToCartButtonClick();
		assertEquals(true, driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).isEnabled());
	}
	@Test(priority = 10)
	public void VerifyThatUserCanRemoveProductFromCart () throws InterruptedException {
	     VerifyThatUserCanAddProductToCart();
	     StorePage.ProceedToCheckoutButtonClick();
	     StorePage.RemoveItemFromCartButtonClick();
	     Thread.sleep(1000);
	     driver.navigate().refresh();
		 String actualText= StorePage.TextFromEmptyCart();
		 assertEquals(actualText, "Your shopping cart is empty.");
	     
	}
	@Test(priority= 15)
	public void VerifyThatUserCanAddFewDifferentProductsToCart () {
		StorePage.DressesButtonClick();
		StorePage.PrintedDressViewClick();
		StorePage.AddToCartButtonClick();
		StorePage.CloseWindowButtonClick();
		StorePage.DressesButtonClick();
		StorePage.PrintedSummerDressViewClick();
		StorePage.AddToCartButtonClick();
		StorePage.CloseWindowButtonClick();
		StorePage.DressesButtonClick();
		StorePage.PrintedChiffonDressViewClick();
		StorePage.AddToCartButtonClick();
		StorePage.ProceedToCheckoutButtonClick();
		String actualText= StorePage.TextFromTotalPrice();
		assertEquals(actualText, "$76.32");
	}
		
	
	
	
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {	
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	public void logInValidCredentials() {
		String email = citacIzExcela.getStringData("TC1", 5, 2);
		String textForAssertion = citacIzExcela.getStringData("TC1", 10, 2);
		String password = citacIzExcela.getStringData("TC1", 7, 2);
		logInFormFilling(email, password);
		String actualText= MyAccountPage.TextFromSignOutButton();
		assertEquals(actualText, textForAssertion);
		
	}
	public void logInFormFilling(String email, String password) {
		LoginPage.InputEmail(email);
		LoginPage.InputPassword(password);
		LoginPage.SignInButtonClick();
	}
	public void numbersFormFilling(String number) {
		StorePage.InputFieldQuantity(number);
		
	}
	

}
