package com.bookingwizard.BookingWizardPrototype;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LaunchPage {
	
	private WebDriver driver;
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ddlSellingOffice")
	private WebElement cboSelectYourSellingOffice;
	
	@FindBy(id="txtTropicsUsername")
	private WebElement txtEnterTropicsUserName;
	
	@FindBy(id="txtTropicsEmail")
	private WebElement txtEnterYourEmail;
	
	@FindBy(id="optAnEndConsumer")
	private WebElement rdoConsumer;
	
	@FindBy(id="optTravelAgent")
	private WebElement rdoTravelAgent;
	
	@FindBy(id="txtTravelAgencyName")
	private WebElement txtTravelAgencyName;
	
	@FindBy(id="txtIATANumber")
	private WebElement txtIATANumber;
	
	@FindBy(id="txtAgencyCity")
	private WebElement txtAgencyCity;
	
	@FindBy(id="txtEmail")
	private WebElement txtTAEmail;
	
	@FindBy(id="txtInternationalTelCode")
	private WebElement txtTAPhoneNumberOne;

	@FindBy(id="txtAreaTelCode")
	private WebElement txtTAPhoneNumberTwo;
	
	@FindBy(id="txtBaseTelNumber")
	private WebElement txtTAPhoneNumberThree;
	
	@FindBy(id="btnTravelAgencySearch")
	private WebElement btnTravelAgencySearch;
	
	@FindBy(id="ddlTravelConsultants")
	private WebElement cboSelectTravelConsultant;
	
	@FindBy(id="ddlSelectBrochure")
	private WebElement cboSelectBrochure;
	
	@FindBy(id="txtFilterTourName")
	private WebElement txtFilterTourName;
	
	@FindBy(id="btnFilterTour")
	private WebElement btnDisplayTour;
	
	@FindBy(id="gvTravelAgency")
	private WebElement tblTravelAgencyResults;
	
	@FindBy(id="tblToursGrid")
	private WebElement tblDisplayTourResults;
	
	@FindBy(id="tblDeparturesGrid")
	private WebElement tblChooseDepartureResults;
	
	
	
	public void selectSellingOffice(String sellingOffice){
		
		Select select = new Select(cboSelectYourSellingOffice);
		select.selectByVisibleText(sellingOffice);
	}
	
	public void chooseConsumerBooking(){
		
		rdoConsumer.click();
	}
	
	public void chooseTravelAgencyBooking(){
		
		rdoTravelAgent.click();
	}
	
	public void chooseTravelAgency(String travelAgencyName, String travelConsultant, String agency){
		
		txtTravelAgencyName.sendKeys(travelAgencyName);
		btnTravelAgencySearch.click();
		
		List<WebElement> allrows = tblTravelAgencyResults.findElements(By.tagName("tr"));
		for(WebElement row:allrows)
		{
	       WebElement agencyName = row.findElements(By.tagName("td")).get(0);
	       if(agencyName.getText().equals(agency)){
	    	   WebElement selectTravelAgencyLink = row.findElement(By.className("tdSelectBtn"));
	    	   selectTravelAgencyLink.click();   
	       }
	    	   
		}
		
		Select selectTravelConsultant = new Select(cboSelectTravelConsultant);
		selectTravelConsultant.selectByVisibleText(travelConsultant);
				
	}
	
	public void chooseTour(String brochure, String tourName){
		
		Select selectBrochure = new Select(cboSelectTravelConsultant);
		selectBrochure.selectByVisibleText(brochure);
		txtFilterTourName.sendKeys(tourName);
		btnDisplayTour.click();
		
		List<WebElement> allrows = tblDisplayTourResults.findElements(By.tagName("tr"));
		for(WebElement row:allrows)
		{
	       WebElement productName = row.findElements(By.tagName("td")).get(0);
	       if(productName.getText().equals(tourName)){
	    	   WebElement selectTourLink = row.findElement(By.className("tdSelect"));
	    	   selectTourLink.click();   
	       }
	    	   
		}
		
	}
	
	public void chooseDeparture (String departureDate){
		
		List<WebElement> allrows = tblChooseDepartureResults.findElements(By.tagName("tr"));
		for(WebElement row:allrows)
		{
	       WebElement date = row.findElements(By.tagName("td")).get(0);
	       if(date.getText().equals(departureDate)){
	    	   WebElement selectDepartureLink = row.findElement(By.className("tdSelect"));
	    	   selectDepartureLink.click();   
	       }
	    	   
		}
		
		
	}
	
	
	
	
	

}
