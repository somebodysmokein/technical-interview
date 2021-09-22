package com.venky.interview.test.stepdefs;

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.venky.interview.test.Pages.BasePage;
import com.venky.interview.test.Pages.HomePage;
import com.venky.interview.test.Pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SamsungSearch {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  public static final String USERNAME = "venkateshrajesh_ciSvF2";
	  public static final String AUTOMATE_KEY = "yYL4eMYxgLnamiWvrTjB";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		
	@Given("^Environment is \"([^\"]*)\"$")
	  public void environment_is(String browser) throws Throwable {
		  if(browser.equalsIgnoreCase("Chrome"))
		  {
			  //System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  
		  }else if(browser.equalsIgnoreCase("FireFox"))
		  {
			  //System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			  	WebDriverManager.firefoxdriver().setup();
			    driver = new FirefoxDriver();
		  }else if(browser.equalsIgnoreCase("BrowserStack"))
		  {
			  	Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
				capsHashtable.put("browser", "chrome");
				capsHashtable.put("browser_version", "latest");
				capsHashtable.put("os", "Windows");
				capsHashtable.put("os_version", "10");
		    	capsHashtable.put("build", "browserstack-build-1");
				capsHashtable.put("name", "Thread 1");
				
				String key;
				DesiredCapabilities caps = new DesiredCapabilities();
				// Iterate over the hashtable and set the capabilities
				Set<String> keys = capsHashtable.keySet();
				Iterator<String> itr = keys.iterator();
				while (itr.hasNext()) {
		       		key = itr.next();
		       		caps.setCapability(key, capsHashtable.get(key));
		    	}
				
				
			  driver = new RemoteWebDriver(new URL(URL), caps);
			  
		  }
	    
	    
	  }
	
	
	@Given("^Flipkart WebPage is \"([^\"]*)\"$")
	  public void flipkart_WebPage_is(String homePageUrl) throws Throwable {
		  baseUrl = homePageUrl;
		  System.out.println(homePageUrl);
		  BasePage basPg=new BasePage(driver);
		  basPg.navigatetoUrl(baseUrl);		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  String title=basPg.getTitle();
		  System.out.println("Title of the webPage:"+title);
		  
	  }
	
	@When("^I login using username and password$")
	public void i_login_using_username_and_password()
	{
		LoginPage basPg=new LoginPage(driver);
		basPg.login("9677391457", "xxxxx", baseUrl);
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String srchTxt)
	{
		HomePage hmPg=new HomePage(driver);
		hmPg.searchforProduct(srchTxt);
	}
	
}
