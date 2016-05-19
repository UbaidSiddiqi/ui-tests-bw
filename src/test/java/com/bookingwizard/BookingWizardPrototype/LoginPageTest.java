package com.bookingwizard.BookingWizardPrototype;

import junit.framework.Assert;

import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPageTest {

	//private web driver
	private static WebDriver driver;
	
	//Initialize WebDriver
	@BeforeClass
	public static void init(){
		 driver = new FirefoxDriver();
	}
	
	@Test
	public void test_navigateToLoginPage() {
		System.out.println("Navigating to Page");
		driver.navigate().to("https://qa.itropics.com/bookingwizard/launch.mvc");
		Assertions.assertThat(driver.getTitle().contains("iTropics Booking Wizard")).isTrue();
	}
	
	@Test
	public void test_login() throws Exception{
		System.out.println("Creating instance of logging page");
		LoginPage loginPage = new LoginPage(driver);
		
		System.out.println("Logging in");
		loginPage.login("Trafalgar Tours", "Demo123");
		
	}
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();
		
	}
}
