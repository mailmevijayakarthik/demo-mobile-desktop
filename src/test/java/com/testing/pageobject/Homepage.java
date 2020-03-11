package com.testing.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.testing.stepdefinitions.BaseClass;

public class Homepage<List> extends BaseClass{
	
	
	public Homepage(RemoteWebDriver driver) {
	 super();
	 driver=this.driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Form Authentication']")
	private WebElement FormAuthentication;
	
	@FindBy(xpath="//a[text()='Add/Remove Elements']")
	private WebElement AddorRemove;
	
	@FindBy(xpath="//a[text()='Checkboxes']")
	private WebElement Checkboxes;
	
	
	
	@FindBy(xpath="//*[@id='content']/ul/li")
	private java.util.List<WebElement> singleElement;
	

	public WebElement getFormAuthentication() {
		return FormAuthentication;
	}


	public java.util.List<WebElement> getSingleElement() {
		return singleElement;
	}


	public WebElement getAddorRemove() {
		return AddorRemove;
	}


	public WebElement getCheckboxes() {
		return Checkboxes;
	}

	
	
	
	
	
}
