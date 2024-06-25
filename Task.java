import static org.testng.Assert.assertEquals;

import java.awt.print.Printable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void checkFields() {
		Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
	}

	@Test
	public void checkValidCreds() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		String str1 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
		assertEquals(str1, "Swag Labs");
	}

	@Test
	public void checkWrongCreds() {
		driver.findElement(By.id("user-name")).sendKeys("Hacker_Hoss");
		driver.findElement(By.id("password")).sendKeys("Easy123");
		driver.findElement(By.id("login-button")).click();

		String str2 = driver.findElement(By.className("error-message-container")).getText();
		assertEquals(str2, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void checkEmptyUser() {

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String str3 = driver.findElement(By.className("error-message-container")).getText();
		assertEquals(str3, "Epic sadface: Username is required");

	}

	@Test
	public void checkEmptyPass() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("login-button")).click();
		String str4 = driver.findElement(By.className("error-message-container")).getText();
		assertEquals(str4, "Epic sadface: Password is required");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
