package projectTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sun.glass.events.KeyEvent;

import projectPages.AddressesPage;
import projectPages.LoginPage;
import projectTests.ExcelReader;
import projectPages.MyAccountPage;
import projectPages.MyPersonalInformationPage;
import projectPages.MyWishlistPage;
import projectPages.StorePage;

public class ProjectBaseTests {
	WebDriver driver;
	LoginPage LoginPage;
	ExcelReader citacIzExcela;
	MyAccountPage MyAccountPage;
	AddressesPage AddressesPage;
	MyPersonalInformationPage PersonalInformation;
	MyWishlistPage MyWishlistPage;
	StorePage StorePage;
	Robot robot;
	
	@BeforeClass
	public void preSihTestova() throws IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPage = new LoginPage (driver);
		MyAccountPage= new MyAccountPage(driver);
		AddressesPage = new AddressesPage(driver);
		PersonalInformation = new MyPersonalInformationPage(driver);
		MyWishlistPage = new MyWishlistPage(driver);
		StorePage= new StorePage(driver);
		robot = new Robot();
		citacIzExcela = new ExcelReader("data/TestPlan.xlsx");

	}
	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
}
