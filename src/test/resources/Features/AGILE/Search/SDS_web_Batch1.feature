@Agile_Search
Feature: Search and SOLR - Search Refinements

  Background: 
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "usertype" user
    And I verify element "Header.searchBox_textbox" is present on page

  @SDS-209 @Sprint_59
  Scenario Outline: Enlarge clickable target in the Typeahead
    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I take screenshot to view the search look ahead is dispalyed properly
    And I move to "Search.productsList_link" OnOffset and click.
    And I take screenshot of the page
    And I Check if link navigated to PDP so I verify Legislation And Environmental section table is not empty in PDP page
    Then I verify element "PDP.productTitle_text" is present on page
    And I wait for "5" seconds
    And I take screenshot of the page

    Examples: 
      | keyword |
      | sem     |
      | Dis     |
      | res     |
      | Sen     |

  @SDS-154 @Sprint_59
  Scenario: Search Lookahead and Keyword search
    And User enters "Manufacturer" keyword from file "SearchKeywords.xlsx" in searchbox and I verify data matching for manufacturer in Searchahead
    And I wait for "3" seconds

  @SDS-158 @Sprint_59
  Scenario: SDS-158 Campaign code search retrieving exact matched records in Search Results.
    When I enter "campaign-code" from file "SearchKeywords.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
    And I take screenshot to verify the correct search page is loaded
    Then I verify element "Search.productsHeader_text" is present on page and display 'Total Products found for search term' in report
    And I verify text "ProductsCount" in page "Search.productCount_text" from file "SearchKeywords.xlsx"
    And I wait for "5" seconds
    And I take screenshot of the page

  @SDS-241 @Sprint_60
  Scenario Outline: SDS-241 Keyword Search- To collect number of products retrieved
    Given User Enters SearchTerm from "<ExcelFile>" and collects the ProductCount Results in Excel
    And I wait for "5" seconds
    And I take screenshot of the page

    Examples: 
      | ExcelFile                      |
      | SearchTerm_Pending.xlsx |

  @SDS-235 @Sprint_60
  Scenario: SDS-235 Keyword with space search retrieving exact matched records in Search Results.
    Given User enters "SearchTerm" from file "SDS- 235_Keywords.xlsx" in searchbox and I verify Searchahead Suggestions
    And I wait for "5" seconds
    And I take screenshot of the page

  @SDS-231 @Sprint_60 @SearchFocus
  Scenario Outline: SDS-231 Activate Typeahead on search box focus
    Given User enter the value "<keyword>" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I take screenshot to view the search look ahead is dispalyed properly
    #----click elsewhere to lose focus----#
    And I click the "Header.wholeHeader_element"
    And I wait for "3" seconds
    #----click back to restore focus----#
    And I click the "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I take screenshot to view the search look ahead is dispalyed properly
    #----tab to lose focus----#
    When I press the tab key in "Header.searchBox_textbox"
    And I wait for "3" seconds
    #----shift-tab to restore focus----#
    When I press shift and tab in "Header.searchIcon_button"
    And I wait for "3" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I take screenshot to view the search look ahead is dispalyed properly
    #----click search variation----#
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "3" seconds
    And I take screenshot to show that I navigate to search results
    And I verify element "Header.searchBox_textbox" is present on page
    And I click on the searchbox textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify element "Search.response_search" is visible in DOM
    Then I take screenshot to view the search look ahead is dispalyed properly

    Examples: 
      | keyword |
      | leg     |
      | sem     |
      | Rap     |

  @SDS-306 @PageSizeParameter @Sprint_63
  Scenario Outline: To verify if Page Size parameter is removed from the URL
    Given I navigate to "browse-for-products" page
    And I wait for "3" seconds
    And click on random product link and navigate to PLP page
    And I wait for "5" seconds
    And I take screenshot
    Then I verify text "25" in page "PLP.selectedPageSize_element"
    And I select by visible text "<PageSize>" from dropdown "PLP.mySelectTop_dropdown"
    And I verify current url doesnot contain "<URLPageSizeParameter>"
    And I take screenshot
    And I click the "Header.searchIcon_button"
    And click on random product link and navigate to PLP page
    And I wait for "3" seconds
    And I take screenshot
    And I verify current url doesnot contain "<URLPageSizeParameter>"
    Then I verify text "<PageSize>" in page "PLP.selectedPageSize_element"
    And I wait for "3" seconds
    And I take screenshot
    And I navigate to "<PLPPageSizeParameter>" page
    Then I verify text "<PageSize>" in page "PLP.selectedPageSize_element"
    And I wait for "3" seconds
    And I take screenshot

    Examples: 
      | PageSize |  | URLPageSizeParameter |  | PLPPageSizeParameter                                                       |
      |       50 |  | ?pageSize=50         |  | c/automation-process-control/automation-signaling/prl/results?pageSize=100 |
      |      100 |  | ?pageSize=100        |  | c/automation-process-control/automation-signaling/prl/results?pageSize=50  |
      |       10 |  | ?pageSize=10         |  | c/automation-process-control/automation-signaling/prl/results?pageSize=25  |

  #Applicable only for UK, US, IN, AU stores
  @SDS-84 @PageRedirect @Sprint_63
  Scenario Outline: To verify if Page is redirected to natural results page
    Given User enter the value "<redirectSearchTerm>" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And verify current url contains "search?st="
    And I verify current url doesnot contain "ost="
    And I take screenshot

    Examples: 
      | redirectSearchTerm |
      | resistor           |
      | capacitor          |
      | mosfet             |
      | switch             |
      | cable              |
      | resistors          |
      | capacitors         |
      | mosfets            |
      | switches           |
      | cables             |

  @SDS-362 @Sprint_66
  Scenario: Delivery Surcharge Filter should not display on PLP, PDP, CLP
    When I navigate to "Category-Node-L1-1" page using details from json "pageUrls.json"
    And I wait for "3" seconds
    Then I verify element "Filters.staticFilterAvailability_section" is present on page
    And I verify absence of element "Filters.noDeliverySurcharge_checkbox"
    Then I take screenshot
    And I navigate to "browse-for-products" page using details from json "pageUrls.json"
    And click on random product link and navigate to PLP page
    And I wait for "5" seconds
    Then I verify element "Filters.staticFilterAvailability_section" is present on page
    And I verify absence of element "Filters.noDeliverySurcharge_checkbox"
    And I take screenshot
    And I click on Manufacturer Product Name in PLP page "PLP.manufacturerFirst_link"
    And I wait for "5" seconds
    And I take screenshot
    And I click the "PDP.findSimilarProducts_button"
    Then I verify element "PDP.filterPopup_element" is present on page
    And I wait for "5" seconds
    And I verify absence of element "Filters.noDeliverySurcharge_checkbox"
    And I take screenshot

  @SDS-411 @Sprint_67
  Scenario Outline: Show Related Categories at the top of the MCP if search term matches category name
    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify element "CategoryPage.firstRelatedCategory_text" is present on page
    And I scroll till "CategoryPage.categoryContainer_section"
    And I verify element "CategoryPage.categoryContainer_section" is present on page
    And I take screenshot
    And I scroll till "Filters.instock_checkbox"
    And I click the "Filters.instock_checkbox"
    And I click the "Filters.showResult_button"
    And I wait for "3" seconds
    Then I verify element "CategoryPage.secondRelatedCategory_text" is present on page
    And I take screenshot

    Examples: 
      | keyword          |
      | power supply     |
      | semiconductors   |
      | passives         |
      | Test             |
      | wires and cables |

  @SDS-411 @Sprint_67
  Scenario Outline: Do not Show Related Categories at the top of the MCP if search term does not match category name
    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify absence of element "CategoryPage.firstRelatedCategory_text"
    And I take screenshot

    Examples: 
      | keyword                    |
      | bav99                      |
      | diode                      |
      | bosch                      |
      | led street light connector |

  @SDS-410 @Sprint_68
  Scenario Outline: Do not Show Related Categories at the top of the MCP if search term does not match category name
    Given I navigate to "browse-for-products" page using details from json "pageUrls.json"
    And click on random product link and navigate to PLP page
    And I wait for "5" seconds
    And I element "PLP.sortBy_element" is present on page
    And I verify text "Sort by" in page "PLP.sortBy_label"
    And I verify text "Best Match" in page "PLP.defaultBestMatch_dropdown"
    And I click on "PLP.defaultBestMatch_dropdown"
    And I wait for "3" seconds
    And I take screenshot of the page
    Then I verify below are displayed in "PLP.sortBy_dropdown" table
      | Best Match        |
      | Price Low to High |
      | Price High to Low |
      | Stock Low to High |
      | Stock High to Low |
    And I click on "<SortByOption>"
    And I verify current url contains "<URL>"
    And I wait for "3" seconds
    And I take screenshot of the page
    And I click on "PLP.defaultBestMatch_dropdown"

    Examples: 
      | SortByOption               |  | URL                  |
      | PLP.bestMatch_dropdown     |  | /prl/results         |
      | PLP.priceAscSort_dropdown  |  | ?sort=P_PRICE        |
      | PLP.priceDescSort_dropdown |  | ?sort=P_PRICE\|1     |
      | PLP.stockAscSort_dropdown  |  | ?sort=P_INVENTORY    |
      | PLP.stockDescSort_dropdown |  | ?sort=P_INVENTORY\|1 |
      
  @SDS-567 @Sprint_71
  Scenario Outline: Show wildcard message when click in search bar
    Given I navigate to "<testpage>" page
    And I click the textbox "Header.searchBox_textbox"
    And element "Header.wildcard_text" is present on page
    And I take screenshot of the page
    Then I verify text contains "New Feature! Find more products using wildcards" in "Header.wildcard_text"
        
  Examples:
    | testpage             |
    | homepage             |
    | browse-for-products  |
    | Product-Details-Page |
    
  @SDS-567 @Sprint_71
  Scenario: Wildcard message no longer shows when it has been closed
    And I click the textbox "Header.searchBox_textbox"
    And element "Header.wildcard_text" is present on page
    And I click the button "Header.wildcardDismiss_button"
    And I verify absence of element "Header.wildcard_text"
    And I take screenshot of the page
    Then I navigate to "browse-for-products" page
    And I click the textbox "Header.searchBox_textbox"
    And I verify absence of element "Header.wildcard_text"
    And I take screenshot of the page
    Then I navigate to "Product-Details-Page" page
    And I click the textbox "Header.searchBox_textbox"
    And I verify absence of element "Header.wildcard_text"
    And I take screenshot of the page
