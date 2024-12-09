@Regression
Feature: Greenkart home page
  I want to use this template for my feature file

  @smokeTesting
  Scenario: search for vegatable or fruit with 3 characters check the result 
  and verify the same functionality in Top Deals page  
    Given Navigate to greenkart search page
    When User search with shortname of vegetable <veg> and extract the search result
    Then User search with same shortname of vegetable <veg> in Top Deals page and Result should match
    Examples: 
    | veg |
    | Tom |
   	#@tag2
		#Scenario Outline: Title of your scenario outline
		#Given I want to write a step with <name>
		#When I check for the <value> in step
		#Then I verify the <status> in step
		#
		#Examples: 
		#| name  | value | status  |
		#| name1 |     5 | success |
		#| name2 |     7 | Fail    |
