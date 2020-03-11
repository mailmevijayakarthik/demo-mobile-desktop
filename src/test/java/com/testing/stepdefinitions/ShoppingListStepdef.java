package com.testing.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.pageobject.ShoppingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingListStepdef extends BaseClass {

	List<String> ProductList = new ArrayList();
	

@Given("navigating to Google Shopping list page")
public void navigating_to_Google_Shopping_list_page() {
   driver.get(prop.getProperty("browserurl"));
   
   
}

@Given("Search {string} in the search bar")
public void search_in_the_search_bar(String searchtext) {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='query' or @name='q']")));
	
	driver.findElement(By.xpath("//input[@name='query' or @name='q']")).sendKeys("milk");
	driver.findElement(By.xpath("//input[@name='query' or @name='q']")).sendKeys(Keys.ENTER);
	
  
}

@Given("enable\\/check the Buy on Google option in shopping page")
public void enable_check_the_Buy_on_Google_option_in_shopping_page() {
	driver.findElement(By.cssSelector("span[title='Buy on Google']")).click();
  
}

@When("search for product less than {int}")
public void search_for_product_less_than(Integer int1) {
    ShoppingPage myshopping = new ShoppingPage(driver);
   
	
	List<WebElement> PriceResult = myshopping.getProductPrice();
	List<WebElement> ProductName = myshopping.getProductName();
	for(int i=0;i<PriceResult.size();i++) {
		String price = PriceResult.get(i).getText().replace("$", "");
		
		if(Double.valueOf(price)<int1) {
			ProductList.add(ProductName.get(i).getText());
		}
	}
	
	 
}

@Then("display the product falling under the given category")
public void display_the_product_falling_under_the_given_category() {
  System.out.println("Product List is :"+ ProductList);
  System.out.println("Total count :"+ ProductList.size() );
}

}
