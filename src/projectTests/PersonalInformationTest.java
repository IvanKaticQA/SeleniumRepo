package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInformationTest extends ProjectBaseTests{
	

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
		driver.manage().window().maximize();

}
	@Test(priority = 0)
	public void EditPersonalInformation() {
		UserIsLogged();
		MyAccountPage.MyPersonalInformationButtonClick();
		PersonalInformation.InputFirstName(citacIzExcela.getStringData("PITC1", 5, 2));
		PersonalInformation.InputLastName(citacIzExcela.getStringData("PITC1", 7, 2));
		PersonalInformation.InputEmailAddress(citacIzExcela.getStringData("PITC1", 9, 2));
		PersonalInformation.BirthDayDropBoxClick();
		PersonalInformation.BirthMonthDropBoxClick();
		PersonalInformation.BirthYearDropBoxClick();
		PersonalInformation.InputCurrentPassword(citacIzExcela.getStringData("PITC1", 17, 2));
		PersonalInformation.InputNewPassword(citacIzExcela.getStringData("PITC1", 19, 2));
		PersonalInformation.InputPasswordForConfirmation(citacIzExcela.getStringData("PITC1", 21, 2));
		PersonalInformation.SaveButtonClick();
		String textForAssertion = citacIzExcela.getStringData("PITC1", 24, 2);
		String actualText= PersonalInformation.TextFromSuccesfullyEditedPersonalInfromation();
		assertEquals(actualText, textForAssertion);
		
	}
	
	private void UserIsLogged () {
		String email = citacIzExcela.getStringData("TC1", 5, 2);
		String password = citacIzExcela.getStringData("TC1", 7, 2);
		logInFormFilling(email, password);
	}
	public void logInFormFilling(String email, String password) {
		LoginPage.InputEmail(email);
		LoginPage.InputPassword(password);
		LoginPage.SignInButtonClick();
	}
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {	
		driver.navigate().refresh();
	}
}
