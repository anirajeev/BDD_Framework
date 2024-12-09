@Regression
Feature: Offers Page Testcase
  I want to use this template for my feature file
  
Background:
Given Navigate to greenkart offers page

  @sanityTesting 
  Scenario: Verify whether Veg/fruit name column sorting the results while clicking
       	
    When User click on the Veg/fruit name column
    Then List should be sorted
  
  @sanityTesting    
  Scenario: Verify whether search bar provides the result
  
    When  User Enter <name>
    Then Respective search result should be listed <name>
    Examples:
    | name |
    | Rice |
    | Beans|