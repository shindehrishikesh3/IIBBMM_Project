@agileRegression
Feature: Manufacture page tests


  @ManufacturePage @eu @apac @nwk
  Scenario: Verify all manufacturers page and brand page
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user
	  When I navigate to "manufacturers" page
    And I wait for "4" seconds
    Then I verify manufacture page display in Ascending order
    And user take screenshot of the page
    Then I scroll down the page by pixels "15000"
    Then I verify '#' is moved to Bottom Of Page
    And user take screenshot of the page
    And I wait for "4" seconds
    Then I Verify current  Url  is contain brand name after clicking on any brand from manufacturer page
    And I wait for "4" seconds
    And I scroll till "ManufacturePage.showAllProduct_button"
    Then I click "ManufacturePage.showAllProduct_button"
    And I wait for "4" seconds
    Then element "ManufacturePage.manufacture_checkbox" is selected on page
    And user take screenshot of the page