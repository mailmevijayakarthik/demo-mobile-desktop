package com.testing.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.testing.stepdefinitions.BaseClass;

public class ShoppingPage extends BaseClass {

	

	public ShoppingPage(RemoteWebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//span[@class='qa708e IYWnmd']")
	private WebElement ResultListView;
	
	@FindBy(xpath="//span[@class='Ytbez']")
	private WebElement ResultGridView;

	@FindBy(xpath="//a[@class='AGVhpb']")
	private List<WebElement> productName;
	
	@FindBy(xpath="//span[@class='O8U6h']/span[@aria-hidden='true']")
	private List<WebElement> productPrice;
	
	@FindBy(xpath="//div[@class='vq3ore']")
	private WebElement productStars;
	
	@FindBy(xpath="//img[@class='TL92Hc']")
	private WebElement productImage;
	
	@FindBy(xpath="//div[@class='hBUZL CPJBKe']")
	private WebElement productDescription;

	public WebElement getResultListView() {
		return ResultListView;
	}

	public void setResultListView(WebElement resultListView) {
		ResultListView = resultListView;
	}

	public WebElement getResultGridView() {
		return ResultGridView;
	}

	public void setResultGridView(WebElement resultGridView) {
		ResultGridView = resultGridView;
	}

	public List<WebElement> getProductName() {
		return productName;
	}

	public void setProductName(List<WebElement> productName) {
		this.productName = productName;
	}

	public List<WebElement> getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(List<WebElement> productPrice) {
		this.productPrice = productPrice;
	}

	public WebElement getProductStars() {
		return productStars;
	}

	public void setProductStars(WebElement productStars) {
		this.productStars = productStars;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public void setProductImage(WebElement productImage) {
		this.productImage = productImage;
	}

	public WebElement getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(WebElement productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
	
	
	
}
