package projectTests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTests extends ProjectBaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
		driver.manage().window().maximize();
		


}
	@Test(priority = 0)
	public void UpdateAddress() {
		UserIsLogged();
		MyAccountPage.MyAddressButtonClick();
		AddressesPage.UpdateButtonClick();
		AddressesPage.AddressInputField(citacIzExcela.getStringData("MyATC1", 8, 2));
		AddressesPage.SaveButtonClick();
		String textForAssertion = citacIzExcela.getStringData("MyATC1", 11, 2);
		String actualText= AddressesPage.TextFromUpdatedAddress();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority=5)
	private void AddANewAddress() {
		MyAccountPage.MyAddressButtonClick();
		AddressesPage.AddANewAddressButtonClick();
		AddressesPage.AddressInputField(citacIzExcela.getStringData("MyATC2", 7, 2));
		AddressesPage.CityInputField(citacIzExcela.getStringData("MyATC2", 9, 2));
		AddressesPage.StateInputField();
		String PostalCode = String.valueOf(citacIzExcela.getIntegerData("MyATC2", 13, 2));
		String HomePhone = String.valueOf(citacIzExcela.getIntegerData("MyATC2", 15, 2));
		numbersFormFilling(PostalCode, HomePhone);
		AddressesPage.TextForNewAddressInputField(citacIzExcela.getStringData("MyATC2", 17, 2));
		AddressesPage.SaveButtonClick();
		String textForAssertion = citacIzExcela.getStringData("MyATC2", 20, 2);
		String actualText= AddressesPage.textFromAddressTitle();
		assertEquals(actualText, textForAssertion);

	}
	@Test (priority=10)
	private void deleteOneAddress() throws InterruptedException, AWTException {
		MyAccountPage.MyAddressButtonClick();
		AddressesPage.DeleteButtonClick();
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		String textForAssertion = citacIzExcela.getStringData("MyATC3", 8, 2);
		String actualText= AddressesPage.textFromAddANewAddress();
		assertEquals(actualText, textForAssertion);

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
	public void numbersFormFilling(String PostalCode, String HomePhone) {
		AddressesPage.PostalCodeInputField(PostalCode);
		AddressesPage.HomePhoneInputField(HomePhone);
	}
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {	
		driver.navigate().refresh();
	}
}
