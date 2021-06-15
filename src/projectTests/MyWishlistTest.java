package projectTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class MyWishlistTest extends ProjectBaseTests{
	
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
		driver.manage().window().maximize();
}
	@Test(priority = 0)
	public void VerifyThatUserCanMakeWishlist () throws InterruptedException {
		UserIsLogged();
		MyAccountPage.MyWishlistButtonClick();
		MyWishlistPage.WishlistNameInputField(citacIzExcela.getStringData("MWTC1", 6, 2));
		MyWishlistPage.SaveButtonClick();
		Thread.sleep(1000);
		assertEquals(true, driver.findElement(By.id("block-history")).isDisplayed());

	}
	
	
	
	@Test(priority=5)
	public void VerifyThatUserCanAddProductToWishlist() {		
		MyAccountPage.MyWishlistButtonClick();
		MyWishlistPage.PrintedChiffonDressClick();
		MyWishlistPage.AddProductToWishlistClick();
		assertEquals(true, driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).isDisplayed() );
		MyWishlistPage.CloseButtonClick();
		
		
	}
	@Test(priority=7)
	public void VerifyThatUserCanChangeQuantityOfProductBeforeAddingToWishlist() {		
		MyAccountPage.MyWishlistButtonClick();
		MyWishlistPage.PrintedChiffonDressClick();
		String Broj = String.valueOf(citacIzExcela.getIntegerData("MWTC6", 7, 2));
		numbersFormFilling(Broj);
		MyWishlistPage.AddProductToWishlistClick();
		assertEquals(true, driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).isDisplayed() );
		MyWishlistPage.CloseButtonClick();
	}
	
	@Test(priority=15)
	public void VerifyThatUserCanDeleteWishlist () throws InterruptedException, AWTException {
	MyAccountPage.MyWishlistButtonClick();
	MyWishlistPage.DeleteWishlistButtonClick();
	Thread.sleep(500);
	robot.keyPress(KeyEvent.VK_ENTER);
	
	
	
	}
	@Test(priority = 10)
	public void VerifyThatUserCanMakeMultipleWishlists () throws InterruptedException, AWTException {
		MyAccountPage.MyWishlistButtonClick();
		MyWishlistPage.WishlistNameInputField(citacIzExcela.getStringData("MWTC4", 6, 2));
		MyWishlistPage.SaveButtonClick();
		assertEquals(true, driver.findElement(By.id("block-history")).isDisplayed());	
		MyWishlistPage.WishlistNameInputField(citacIzExcela.getStringData("MWTC4", 9, 2));
		MyWishlistPage.SaveButtonClick();
		assertEquals(true, driver.findElement(By.id("block-history")).isDisplayed());
		MyWishlistPage.WishlistNameInputField(citacIzExcela.getStringData("MWTC4", 12, 2));
		MyWishlistPage.SaveButtonClick();
		assertEquals(true, driver.findElement(By.id("block-history")).isDisplayed());
		
	}
	
public void UserIsLogged () {
	String email = citacIzExcela.getStringData("TC1", 5, 2);
	String password = citacIzExcela.getStringData("TC1", 7, 2);
	logInFormFilling(email, password);
}
public void logInFormFilling(String email, String password) {
	LoginPage.InputEmail(email);
	LoginPage.InputPassword(password);
	LoginPage.SignInButtonClick();
}
public void numbersFormFilling(String Broj) {
	MyWishlistPage.QuantityInputField(Broj);


}

}

