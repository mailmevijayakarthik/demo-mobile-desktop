package com.testing.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void before(Scenario scenario) {
	    System.out.println("------------------------------");
	    System.out.println("Starting - " + scenario.getName());
	    System.out.println("------------------------------");
	}
 
	@After
	public void after(Scenario scenario) {
	    System.out.println("------------------------------");
	    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
	    System.out.println("------------------------------");
	}
}
