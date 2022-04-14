package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

 LoginPage lp = new LoginPage();
 DataFile df = new DataFile();	
 
  @BeforeMethod
  public void beforeMethod() {
	 lp.openBrowser();
	 lp.openLiginpage();
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
	  
  }
 @Test(priority = 1)
  public void loginwithwrongemailpassword() throws InterruptedException {
	  	lp.login(df.wrongEmail, df.wrongPassword);
		Assert.assertEquals(lp.readError(),df.globalError);
		
		
  }
  @Test(priority = 2)
  public void loginwithspcialchractor() throws InterruptedException {
	  	lp.login(df.emailWithSpecialChar, df.wrongPassword);
		Assert.assertEquals(lp.readEmailPasswordError(),df.emailErrSpeChar);
		
  }
  @Test(priority = 3)
  public void loginwithEmptyPasswrod() throws InterruptedException {
	  	lp.login(df.wrongEmail, "");
		Assert.assertEquals(lp.readEmailPasswordError(), df.emptyPasswordErr);	
  }
  @Test(priority = 4)
  public void loginwithemptyemail() throws InterruptedException {
	  	lp.login("",df.wrongPassword);
		Assert.assertEquals(lp.readEmailPasswordError(), df.emptyEmailErr);	
  }
}
