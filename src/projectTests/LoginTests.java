package projectTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projectTests.ProjectBaseTests;

public class LoginTests extends ProjectBaseTests{
	
		@BeforeMethod
		public void preSvakogTesta() {
			driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			driver.manage().window().maximize();
	
		

}
		
		@Test(priority = 0)
		public void logInValidCredentials() {
			String email = citacIzExcela.getStringData("TC1", 5, 2);
			String textForAssertion = citacIzExcela.getStringData("TC1", 10, 2);
			String password = citacIzExcela.getStringData("TC1", 7, 2);
			logInFormFilling(email, password);
			String actualText= MyAccountPage.TextFromSignOutButton();
			assertEquals(actualText, textForAssertion);
			
		}
		@Test(priority = 5)
		private void VerifyThatUserCanLogOut() {
			logInValidCredentials();
			MyAccountPage.SignOutButtonClick();
			String textForAssertion = citacIzExcela.getStringData("TC4", 11, 2);
			String actualText= LoginPage.textFromSignInButton();
			assertEquals(actualText, textForAssertion);

		}
		@Test (priority = 7)
		private void VerifyThatUserCantLogInWithInvalidEmail () {
			String email = citacIzExcela.getStringData("TC2", 5, 2);
			String textForAssertion = citacIzExcela.getStringData("TC2", 10, 2);
			String password = citacIzExcela.getStringData("TC2", 7, 2);
			logInFormFilling(email, password);
			String actualText= LoginPage.textFromLoginWithBadCredentials();
			assertEquals(actualText, textForAssertion);
		}
		@Test (priority = 8)
		private void VerifyThatUserCantLogInWithInvalidPassword () {
			String email = citacIzExcela.getStringData("TC2", 5, 3);
			String textForAssertion = citacIzExcela.getStringData("TC2", 10, 3);
			String password = citacIzExcela.getStringData("TC2", 7, 3);
			logInFormFilling(email, password);
			String actualText= LoginPage.textFromLoginWithBadCredentials();
			assertEquals(actualText, textForAssertion);
		}
		@Test (priority = 9)
		private void VerifyThatUserCantLogInWithInvalidCredentials () {
			String email = citacIzExcela.getStringData("TC2", 5, 4);
			String textForAssertion = citacIzExcela.getStringData("TC2", 10, 4);
			String password = citacIzExcela.getStringData("TC2", 7, 4);
			logInFormFilling(email, password);
			String actualText= LoginPage.textFromLoginWithBadCredentials();
			assertEquals(actualText, textForAssertion);
		}@Test (priority = 10)
		private void VerifyThatUserCantLogInWithOutCredentials () {
			String textForAssertion = citacIzExcela.getStringData("TC3", 5, 2);
			LoginPage.SignInButtonClick();
			String actualText= LoginPage.textFromLoginWithBadCredentials();
			assertEquals(actualText, textForAssertion);
		}
		
		
		public void logInFormFilling(String email, String password) {
			LoginPage.InputEmail(email);
			LoginPage.InputPassword(password);
			LoginPage.SignInButtonClick();
			
		}
		
	
	@AfterMethod
	public void posleSvakogTesta() throws InterruptedException {	
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

