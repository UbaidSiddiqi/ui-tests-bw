package com.bookingwizard.BookingWizardPrototype;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	@Given("^I am in Tropics$")
	public void openTropics(){
	    
		System.out.println("This will open Tropics");
	}

	@When("^I do something$")
	public void performActionInTropics(){
	    
		System.out.println("I am doing something");
	}

	@Then("^I get angry$")
	public void getAnnoyed() {
	   
		System.out.println("Raaaaa");
	}

}
