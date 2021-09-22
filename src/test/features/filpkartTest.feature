#Feature Definition Template
@TestFlipkart
Feature: Flipkart Test - feature for validating Flipkart website with Samsung product
 	
  @001_Test_SamsungGalaxy_S10
  Scenario: Validate if we are able to search with Samsung Galaxy S10 in  Flipkart.com & check if results are published on the first page
  	Given Environment is "BrowserStack"
    Given Flipkart WebPage is "https://www.flipkart.com"
    When I login using username and password
    When I search for "Samsung Galaxy S10"
    
    
    
    
     
 