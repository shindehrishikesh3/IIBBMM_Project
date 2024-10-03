#Author: Naina Vaish
@search @mobAgileRegression @mobValidationTests
Feature: Search Pages
  
  This scenario will check all the search functionality in the website

  Background: Launch homepage for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "Guest" user

  @BlankSearch @Search @eu @apac @nwk @live
  Scenario: Verify Blank Search
    When user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    And user take screenshot of browse for product page page
    And user verify element "BrowseForProducts.firstCategory_image" is present on page
    And user verify element "BrowseForProducts.firstCategory_text" is present on page and display in report
    Then user verify link "BrowseForProducts.firstCategory_link" is present on page

  @CategorySearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify L0 and L1 Category Search
    When user enter the value "<L0Category>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    And user take screenshot of L0 Category Search page
    And verify absence of element "Search.breadCrumb_element"
    And user verify the message "<L0Category>" is present in multiple tags using innertext in page "Search.resultFoundForSearchTerm_text"
    Then user verify element "Filters.refineResults_button" is present on page
    And user clears text from textbox "Header.searchBox_textbox"
    When user enter the value "<L1Category>" in textbox "Header.searchBox_textbox"
    And user wait for "3" seconds
    #And user click the "Header.searchIcon_button"
    And click "Search.FirstOptionSelection" using js
    And user wait for "3" seconds
    And user take screenshot of L1 Category Search page
     And user verify element "Search.breadCrumb_element" is present on page and display 'breadcrumb value' in report
    And user verify text of "<L1Category>" in page "CategoryPage.category_heading"
    Then user verify element "MultiCategoryPage.multiCategories_section" is present on page

    Examples: 
      | L0Category         | L1Category |
      | Passive Components | Inductors  |

  @MPNSearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify Manufacturer Part Number Search
    When user enter the value "<ManufacturerPartNumber>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    Then user verify element "PDP.manufacturerPartNumber_label" is present on page
    And user verify text of "<ManufacturerPartNumber>" in page "PDP.manufacturerPartNumber_value"
    And user take screenshot of search results page
    Then user verify PDP page contains MNP "<ManufacturerPartNumber>" in "PDP.productHeading_text"

    Examples: 
      | ManufacturerPartNumber |
      | ZBVB45                 |
      | 22.22.8.230.4000       |
      | ST5918M3008-A          |

  @DescriptiveSearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify Descriptive Keyword Search
    When user enter the value "<ProductDescription>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    And user take screenshot of the search results page
    And user verify element "Search.breadCrumb_element" is present on page and display 'breadcrumb value' in report
    And user verify element "Search.resultFoundForSearchTerm_text" is present on page
    And user verify the message "<ProductDescription>" is present in multiple tags using innertext in page "Search.resultFoundForSearchTerm_text"

    Examples: 
      | ProductDescription                        |
      | chip resistor 10 kohm thick film          |
      | trimpot, multi turn, cermet, top adjust   |
      | shift register, 4 bit, serial to parallel |

  @ManufacturerSearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify Manufacturer Keyword Search
    When user enter the value "<ManufacturerName>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "5" seconds
    And user take screenshot of the Manufacturer details page.
    And user verify current url contains "/b/"
    And user verify element "ManufacturerDetailsPage.ManufacturerName_imgText" is present on page
    And user verify element "ManufacturerDetailsPage.ManufacturerDescription_element" is present on page
    And user verify text "<ManufacturerName>" in page "ManufacturerDetailsPage.ManufacturerName_imgText" with attribute "alt"
    And user verify element "ManufacturerDetailsPage.productListingFromBrand_section" is present on page
    Then user verify element "ManufacturerDetailsPage.showAllProducts_button" is present on page

    Examples: 
      | ManufacturerName |
      | renesas          |
      | Kemet            |
      | 3M               |

  @SpecialCharSearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify Special Character Keyword Search
    When user enter the value "<specChar>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "5" seconds
    And user take screenshot of the search results page
    #And verify absence of element "Search.breadCrumb_element"
    #And user verify element "Search.breadCrumb_element" is present on page and display 'breadcrumb value' in report
    Then user verify search results product header contains "<specChar>" in "Search.resultFoundForSearchTerm_text"

    Examples: 
      | specChar |
      | 1°c 1% |
      | ± 15%    |

  @StemmingSearch @Search @eu @apac @nwk @live
  Scenario Outline: Verify Stemming Keyword Search
    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    #And user verify element "Search.breadCrumb_element" is present on page and display 'breadcrumb value' in report
    And user take screenshot to verify the correct search page is loaded
    And user get the products found count for keyword search
    And user clears text from textbox "Header.searchBox_textbox"
    And user enter the value "<StemmingKeyword>" in textbox "Header.searchBox_textbox"
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    #And user verify element "Search.breadCrumb_element" is present on page and display 'breadcrumb value' in report
    And user take screenshot to verify the correct search page is loaded
    And user get the products found count for stemming keyword search
    Then user verify the product count equal or not for stemming search

    Examples: 
      | keyword  | StemmingKeyword |
      | resistor | resistors       |
      | register | registers       |
