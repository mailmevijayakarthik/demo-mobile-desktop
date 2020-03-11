package com.testing.stepdefinitions;

import cucumber.api.java.en.Given;

public class MyStepdefs extends BaseClass{
    @Given("navigate to google site")
    public void navigateToGoogleSite() {
    driver.get(prop.getProperty("browserurl"));
    }
}
