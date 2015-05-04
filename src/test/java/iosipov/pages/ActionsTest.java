package iosipov.pages;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionsTest extends iosipov.pages.TestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Test
	public void addTest () throws Exception {
		WebDriver driver = new FirefoxDriver ();
		
		//login
		driver.get(baseUrl + "/php4dvd/");
	    WebElement usernameField = driver.findElement(By.id("username"));
	    usernameField.clear();
	    usernameField.sendKeys("admin");
	    WebElement passwordField = driver.findElement(By.name("password"));
	    passwordField.clear();
	    passwordField.sendKeys("admin");
	    driver.findElement(By.name("submit")).click();
	    
	    //perehod na formu Add
	    WebElement addBtn = driver.findElement(By.cssSelector("img[alt=\"Add movie\"]"));
	    addBtn.click();
	    
	    //WebElement imdId = driver.findElement(By.name("imdbid"));
	    //imdId.sendKeys("");
	    WebElement nameField = driver.findElement(By.name("name"));
	    nameField.sendKeys("Test movie 1");
	    driver.findElement(By.name("year")).sendKeys("2015");
	    WebElement submitBtn = driver.findElement(By.id("submit"));
	    submitBtn.click();
	    
	    //driver.quit();
	}
	
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

	  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

}
