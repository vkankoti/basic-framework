package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	/*
	 * WebElement email = driver.findElement(By.name("usernameInput")); WebElement
	 * pass = driver.findElement(By.name("password")); WebElement sigInButton =
	 * driver.findElement(By.id("signIn")); WebElement globalError =
	 * driver.findElement(By.id("globalError")); WebElement emailPassError =
	 * driver.findElement(By.
	 * xpath("//div[@class='Errorstyle__ErrorText-canvas-core__swivz4-1 mSQlk Error__text']/span"
	 * ));
	 */
	 
	@FindBy(name = "usernameInput")
	public WebElement email;
	
	@FindBy(name = "password")
	public WebElement password;

	@FindBy(id = "signIn")
	public WebElement logInButton;

	@FindBy(id = "globalError")
	public WebElement globalError;

	@FindBy(xpath = "//div[@class='Errorstyle__ErrorText-canvas-core__swivz4-1 mSQlk Error__text']/span")
	public WebElement emailPassError;

	public void openBrowser() {
		/*
		 * Xls_Reader d = new Xls_Reader(
		 * "F:\\Selenium\\testing\\wetransfer_build-xml_2022-03-13_1322\\NikulTest.xlsx"
		 * ); String correctbrowser = d.getCellData("Data1", 1, 5);
		 * System.out.println(correctbrowser);
		 */
		String browser = "Firefox";
		if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "F:\\Selenium\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void openLiginpage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=mEuYLeBzd70&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoibUV1WUxlQnpkNzAiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0NjIzMDcxOCwiaWF0IjoxNjQ2MjI5NTE4LCJqdGkiOiI3MGM1OWRhZC0wYjE5LTRmZTAtYjQ4NC03ODFhYTBlN2JmZTkiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.L6ezvOD4P6Knrl49B-EDmZba_thdFQqzQ06zUpCtptm_9bjdAMRoYq-7IWe0VPPfA4xqT5AswjQDPx6rhVY3WcL-O2FtnnFJtM9Mcd0xZFXWYaA0iFNTfv0XruVFEWO4J6sW3pbdgMWhZG84a01mQ96cwBchNJByq56wSUFIlJ_OhLUVKLBdg5_uCt0jt6JPocpWAeuF7ouURukBuVoFkj5fZdN15bt27FRgiIP5ZzpvLJP3klaNyHeT1kL9vxroEKF-uQq_7XN2FTaMxSBCsyHH4mFDH5FC4kK5zqKCvyq-tf4jRf4wHnL5gkksYqeK1_PUB7IwDHxYrzgQSMwd6A&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // max time
	}

	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		logInButton.click();
		Thread.sleep(3000);
	}

	public String readError() {
		String actual = globalError.getText();
		System.out.println(actual);
		return actual;
	}

	public String readEmailPasswordError() {
		String actual = emailPassError.getText();
		System.out.println(actual);
		return actual;
	}

}
