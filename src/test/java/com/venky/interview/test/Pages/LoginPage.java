package com.venky.interview.test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form")
	WebElement lgnForm;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement userName;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement pwrd;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	WebElement btn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void login(String username,String password,String url)
	{
		
		userName.sendKeys("9677391457");
		pwrd.sendKeys("Arcash@01");
		btn.click();
		
	}

	
}
