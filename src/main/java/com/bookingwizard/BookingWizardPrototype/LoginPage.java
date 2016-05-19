package com.bookingwizard.BookingWizardPrototype;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements
	@FindBy(id="RequestSource")
	private WebElement cboSelectBrand;
	
	@FindBy(id="Password")
	private WebElement txtPassword;
	
	@FindBy(name="ctl01")
	private WebElement btnEnter;
	
	public void login(String brand, String password){
		Select select = new Select(cboSelectBrand);
		select.selectByVisibleText(brand);
		txtPassword.sendKeys(password);
		btnEnter.click();
	}
}
