#Author: Naina Vaish
@demo
Feature: This feature file will cover all the regression testing for Headless POC on ireland store

  @test1
  Scenario Outline: As a customer, I want to be able to search for products in the search bar,so that it is easier for me to find the product(s) I am looking for
    Given user navigate to "<country>" store homepage and "does" accept the cookies
    When they click on the All CTA "Header.all_list"
    And I wait for "5" seconds
    Then a drop down list will appear, displaying all the different product groups & categories to choose from element "Header.all_list" is present on page
    And I wait for "5" seconds
    When they Click on All CTA AND select by visible text "<Category>" from dropdown "Header.anyCategory_dropdown"
    And I wait for "5" seconds
    And I take screenshot to verify the green space with All will change to the category selected and the customer can then search within that category

    Examples: 
      | country | user     | Category |
      | sg      | register | Switches |
      | us      | register | Sensors  |

  @test1_1
  Scenario: As a customer, I want to be able to search for products in the search bar,so that it is easier for me to find the product(s) I am looking for
    Given web site is launched successfully and user "does" accept the cookies
      When they click on the All CTA "Header.all_list"
    And I wait for "5" seconds
    Then a drop down list will appear, displaying all the different product groups & categories to choose from element "Header.all_list" is present on page
    And I wait for "5" seconds
    When they Click on All CTA AND select by visible text "Cable Assemblies" from dropdown "Header.anyCategory_dropdown"
    And I wait for "5" seconds
    And I take screenshot to verify the green space with All will change to the category selected and the customer can then search within that category

  @mobile @test2
  Scenario Outline: Running demo test on mobile
    Given user navigate to "<country>" store homepage and "does" accept the cookies

    Examples: 
      | country | user  |
      | uk      | login |

  @test3
  Scenario Outline: Searching Keyword
    Given web site is launched successfully and user "does" accept the cookies
    #And user enter value "<OrderCode>" in textbox "id@simpleSearchForm_searchTerm"
    And user enter value "<OrderCode>" in textbox "Home.searchBox_textbox"
    And We want to take screenshot  of this page to validate the changes
    And I wait for "5" seconds

    Examples: 
      | OrderCode |
      | 44X1579   |

  @test5
  Scenario Outline: Searching Keyword
    Given user navigate to "<Country>" store as "<Usertype>" user
    And I click "Register.register_link"
    And user enters "Password" for store "<Country>" from given file "Registeration.xlsx" at row "0" number for "Register.password_textbox"
    And I take screenshot

    Examples: 
      | Country | Usertype |
      | uk      | Guest    |

  @test6 @ui @sampletag
  Scenario: Demo for constants file picked up based on region and Dependency Injection
    Given web site is launched successfully
    Then I verify LHS categories on Homepage
