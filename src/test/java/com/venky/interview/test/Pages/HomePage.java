package com.venky.interview.test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(name="q")
	protected WebElement srchbar;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/div/section/div[3]/div/a")
	protected WebElement filterMob;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/label/div[1]")
	protected WebElement assured;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[4]")
	protected WebElement price;
	
	@FindBy(css="#container > div > div._36fx1h._6t1WkM._3HqJxg > div > div:nth-child(2)")
	List<WebElement> listofResults;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public ResultsPage searchforProduct(String srchTxt)
	{
		this.sendKeysifExist(srchbar, srchTxt);
		srchbar.sendKeys(Keys.ENTER);
		this.clickifExists(filterMob);
		this.clickifExists(assured);
		this.clickifExists(price);
		ResultsPage resultsPg=new ResultsPage(driver);
		int index=1;
		for(WebElement elt:listofResults)
		{
			System.out.println(driver.findElement(By.cssSelector("#container > div > div._36fx1h._6t1WkM._3HqJxg > div > div:nth-child(2) > div:nth-child("+index+")")).getText());
			index++;
		}
		return resultsPg;
	}
	
	
}
