package com.venky.interview.test.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

	protected WebDriver driver;
	protected String title;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void navigatetoUrl(String url)
	{
		driver.navigate().to(url);
	}
	
	public String getTitle()
	{
		title=driver.getTitle();
		return title;
	}
	
	public void clickifExists(WebElement elt)
	{
		fluientWaitforElement(elt, 30, 5).click();; 
	}
	
	public void sendKeysifExist(WebElement elt,String txt)
	{
		fluientWaitforElement(elt, 30, 5).sendKeys(txt);;
	}
	
	
	
	public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {

	    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
	        .pollingEvery(pollingSec, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

	    for (int i = 0; i < 2; i++) {
	        try {
	            //fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='reportmanager-wrapper']/div[1]/div[2]/ul/li/span[3]/i[@data-original--title='We are processing through trillions of data events, this insight may take more than 15 minutes to complete.']")));
	        fWait.until(ExpectedConditions.visibilityOf(element));
	        fWait.until(ExpectedConditions.elementToBeClickable(element));
	        } catch (Exception e) {

	        System.out.println("Element Not found trying again - " + element.toString().substring(70));
	        e.printStackTrace();

	        }
	    }

	    return element;

	    }
}
