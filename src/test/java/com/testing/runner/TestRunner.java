package com.testing.runner;


import com.testing.stepdefinitions.BaseClass;
import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@CucumberOptions(features=("./src/test/resources/features/MobileWeb.feature"),
        glue= {"com.testing.stepdefinitions"},
        strict = true,
        plugin= {"pretty","html:target/cucumber",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = {"@mobile"}
)

public class TestRunner extends BaseClass {

    @Parameters({ "browser" })
    @BeforeTest
    public static void setUpScenario(String browser) throws MalformedURLException {
        Initiaziation(browser);
    }

    @AfterTest
    public static void aftertest(){
        tearDown();
    }
}
