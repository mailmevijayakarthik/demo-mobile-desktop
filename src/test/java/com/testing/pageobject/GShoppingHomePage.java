package com.testing.pageobject;

import com.testing.stepdefinitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GShoppingHomePage extends BaseClass {


    public GShoppingHomePage(RemoteWebDriver driver) {
        super();
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//button[@class='navToggle mat-focus-indicator mat-icon-button mat-button-base']//gx-icon[@class='gxIcon']")
    private WebElement BarMenu;


    public WebElement getBarMenu() {
        return BarMenu;
    }

    public void setBarMenu(WebElement barMenu) {
        BarMenu = barMenu;
    }




}
