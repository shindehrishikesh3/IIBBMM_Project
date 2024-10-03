@agileRegression @plpReg
Feature: PLP tests

  Background: Launch homepage for PLP regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @staticFiler @Priority1 @eu @apac @nwk 
  Scenario: Verify Static Filters on PLP Page
    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And I get the Products found count before applying filters
    And user enter the value "vishay" in textbox "PLP.withinSearch_textbox"
    And I click on "PLP.withinSearch_button"
    And I get the Products found count before applying filters
    And I navigates back in the browser
    And I scroll till "PLP.manufactureSearch_textbox"
    And user enter the value "ABB - THOMAS" in textbox "PLP.manufactureSearch_textbox"
    And I click on "PLP.search_element"
    And I get the Products found count before applying filters
    And user take screenshot of the page
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedLeftView_section" is present on page
    And I click "Filters.clearAllFilters_link"
    And I wait for "5" seconds
    And I verify the Products found count after clearing all the filters
    And I click the toggle view from LEFT to TOP view "Filters.filterView_toggle"
    And user take screenshot of the page
    And I verify Filter Applied section element "Filters.filterView_toggle" is present on page
    When I select by index "1" from dropdown "Filters.filterManufacturer_section"
    And I click on "Filters.reset_link"
    And I get the Products found count before applying filters
    And user take screenshot of the page
    And I click on Show Result button "Filters.showResult_button" refreshed element
    When I select by index "3" from dropdown "Filters.filterManufacturer_section"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedTopView_section" is present on page
    And I click "Filters.clearAllFilters_link"
    And I wait for "5" seconds
    And I verify the Products found count after clearing all the filters
    And user take screenshot of the page
    And I click on Min dropdown "PLP.minimum_dropdown"
    When I select by index "1" from dropdown "PLP.minimum_dropdown"
    And user verify element "Filters.reset_link" is present on page
    And I click on "Filters.reset_link"
    And I wait for "4" seconds
    And I click on Max dropdown "PLP.maximum_dropdown"
    When I select by index "2" from dropdown "PLP.maximum_dropdown"
    And user verify element "Filters.reset_link" is present on page
    And I click on "Filters.reset_link"
    And I click on Min dropdown "PLP.minimum_dropdown"
    When I select by index "1" from dropdown "PLP.minimum_dropdown"
    And I click on Max dropdown "PLP.maximum_dropdown"
    And I wait for "4" seconds
    When I select by index "2" from dropdown "PLP.maximum_dropdown"
    And I scroll till "Filters.showResult_button"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I click on "Filters.reset_link"
    And I wait for "5" seconds
    And I scroll till "PLP.remember_checkbox"
    And I wait for "3" seconds
    And I click on "PLP.remember_checkbox" using js
    And I wait for "4" seconds
    And user take screenshot of the page
    And I click on "Filters.instock_checkbox" using js
    And I select instock sub radio button "PLP.rememberInstock_radio" if available
    And I scroll till "Filters.showResult_button"
    And I wait for "5" seconds
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user take screenshot of the page

  @PLP @Priority1 @eu @apac @nwk
  Scenario: Verify PLP Page
    When User navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And User verify element "PLP.header_text" is present on page
    And User verify element "Filters.filterView_toggle" is present on page
    And User verify element "PLP.pagination_element" is present on page
    #----- User verifies number of products on PLP ----#
    And User verify "25" products are listed in products table "PLP.allCompareCheck_checkbox"
    When User select by option "10" from dropdown "PLP.mySelectTop_dropdown"
    Then User verify "10" products are listed in products table "PLP.allCompareCheck_checkbox"
    When User select by option "50" from dropdown "PLP.mySelectTop_dropdown"
    Then User verify "50" products are listed in products table "PLP.allCompareCheck_checkbox"
    When User select by option "100" from dropdown "PLP.mySelectTop_dropdown"
    Then User verify "100" products are listed in products table "PLP.allCompareCheck_checkbox"
    #----- User verifies presence of table column headers ----#
    Then User verify below are displayed in "PLP.tableHeader_text" table
      | Manufacturer Part No       |
      | Order Code                 |
      | Description / Manufacturer |
      | Availability               |
      | Price For                  |
      | Price (ex VAT)             |
      | Quantity                   |
    When User click first manuafacturer part number "PLP.firstManufacturerPartNo_link"
    Then User wait for "3" seconds
    Then User verify element "PDP.productTitle_text" is present on page
    And User navigates back in the browser
    When User click first product description "PLP.manufacturerFirst_link"
    Then User verify element "PDP.productTitle_text" is present on page
    Then User wait for "3" seconds
    And User navigates back in the browser
    #----- User verifies sorting of Manufacturer Part No ----#
    When User click to sort Manufacturer Part No  in ascending order "PLP.manfacPartNoAscending_button"
    Then User verify current url contains "sort=P_MAN_PART_NUM"
    When User click to sort Manufacturer Part No in descending order "PLP.manfacPartNoDescending_button"
    Then User verify current url contains "sort=P_MAN_PART_NUM|1"
    #----- User verifies sorting of Order Code ----#
    When User click to sort Order Code in ascending order "PLP.orderCodeAscending_button"
    Then User verify current url contains "sort=P_PRODUCT_ID"
    When User click to sort Order Code in descending order "PLP.orderCodeDescending_button"
    Then User verify current url contains "sort=P_PRODUCT_ID|1"
    #----- User verifies sorting of Description / Manufacturer ----#
    When User click to sort Description / Manufacturer in ascending order "PLP.descriptionAscending_button"
    Then User verify current url contains "sort=P_MAN_BRAND_NAME"
    When User click to sort Description / Manufacturer in descending order "PLP.descriptionDescending_button"
    Then User verify current url contains "sort=P_MAN_BRAND_NAME|1"
    #----- User verifies sorting of Price ----#
    When User click to sort Price in ascending order "PLP.priceAscending_button"
    Then User verify current url contains "sort=P_PRICE"
    When User click to sort Price in descending order "PLP.priceDescending_button"
    Then User verify current url contains "sort=P_PRICE|1"
    #----- User verifies sorting of Availability ----#
    Then User click to sort Availability in ascending order "PLP.availabilityAscending_button"
    And User verify current url contains "sort=P_INVENTORY"
    Then User click to sort Availability in descending order "PLP.availabilityDescending_button"
    And User verify current url contains "sort=P_INVENTORY|1"
    #----- User adds product in to the basket ----#
    And I scroll till "PLP.tableHeader_text"
    Then User click Add button to add the product to the basket "PLP.firstAdd_button"
    And User wait for "3" seconds
    And User verify mini basket overlay element "PLP.miniBasketOverlay_element" is present on page
    #----- User verifies compares products page is displayed ----#
    Then User select first "4" checkbox from PLP table
    And User click "PLP.compareSlected_button"
    And User verify element "CompareProducts.CompareProducts_text" is present on page
    Then User click Back to previous page link "CompareProducts.backToPreviousPage_link"
    And User verify PLP table element "PLP.PLP_element" is present on page
    #----- User search and navigates to PLP ----#
    When User click company logo to go to home page "Header.companylogo_element"
    And User enter the value "saw oscillators" in textbox "Header.searchBox_textbox"
    And User click Search button "Header.searchIcon_button"
    Then User verify element "PLP.PLP_element" is present on page
    Then User clears text from textbox "Header.searchBox_textbox"
    When User enter the value "through hole resistors" in textbox "Header.searchBox_textbox"
    And User click Search button "Header.searchIcon_button"
    Then User wait for "5" seconds
    #-----This is a temporary step until the data file for different pages are available
    And User click Show Results button "CategoryPage.showAllProducts_button" only in "UK,CN,AU,US" store/region
    Then User verify element "PLP.PLP_element" is present on page

  @SearchCompareProductsPLP @Priority2 @eu @apac
  Scenario: Search Compare Products on PLP
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I wait for "3" seconds
    And user navigate to "c/development-boards-evaluation-tools/analogue-development-kit-accessories" page
    And I wait for "3" seconds
    And I take screenshot
    And I verify PLP table element "PLP.PLP_element" is present on page
    And I scroll down the page by pixels "1000"
    And I save the details of "10" product from PLP table
    And I scroll up the page by pixels "3500"
    And I select first "10" checkbox from PLP table
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    And I compare the saved details of "10" products from PLP table with compare product page
    And I click on "CompareProducts.backToPreviousPage_link"
    And I scroll down the page by pixels "1000"
    And I click on the next checkbox to compare "PLP.eleventhCompare_checkbox"
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    Then I verify the text displayed contains  "You've selected 11 products. You can compare up to 10 products at a time. The most recent 10 products will be shown." in "CompareProducts.CompareMessage_text"
    And I verify element "CompareProducts.rohsCertificateOfCompliance_icons" is present on page
    And click "CompareProducts.rohsCertificateOfCompliance_link" using js
    Then I wait for "3" seconds
    And I take screenshot
    And I click HTMLCertificate in product compliance certificate popup "CompareProducts.htmlCertificate_link"
    And I wait for "2" seconds
    Then I switched on Rohs window and verify customer name in application and Rohs Certificate
    And I wait for "2" seconds
    And I take screenshot
    Then I switch to parent window
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "10" in page "CompareProducts.orderCodeItem_text"
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "9" in page "CompareProducts.orderCodeItem_text"
    And I take screenshot
    And I click "PLP.firstAdd_button" using js
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I take screenshot
		And I click on delete all link "CompareProducts.deleteAll_link"
		Then I verify absence of element "CompareProducts.orderCodeItem_text"		
		
	@SearchCompareProductsPLP @Priority2 @nwk
  Scenario: Search Compare Products on PLP
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I wait for "3" seconds
    And user navigate to "c/automation-process-control/automation-signaling/audio-signal-indicator-units" page
    And I wait for "3" seconds
    And I take screenshot
    And I verify PLP table element "PLP.PLP_element" is present on page
    And I scroll down the page by pixels "1000"
    And I save the details of "10" product from PLP table
    And I scroll up the page by pixels "3500"
    And I select first "10" checkbox from PLP table
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    And I compare the saved details of "10" products from PLP table with compare product page
    And I click on "CompareProducts.backToPreviousPage_link"
    And I scroll down the page by pixels "1000"
    And I click on the next checkbox to compare "PLP.eleventhCompare_checkbox"
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    Then I verify the text displayed contains  "You've selected 11 products. You can compare up to 10 products at a time. The most recent 10 products will be shown." in "CompareProducts.CompareMessage_text"
    And I verify element "CompareProducts.rohsCertificateOfCompliance_icons" is present on page
    And click "CompareProducts.rohsCertificateOfCompliance_link" using js
    Then I wait for "3" seconds
    And I take screenshot
    And I click HTMLCertificate in product compliance certificate popup "CompareProducts.htmlCertificate_link"
    And I wait for "2" seconds
    Then I switched on Rohs window and verify customer name in application and Rohs Certificate
    And I wait for "2" seconds
    And I take screenshot
    Then I switch to parent window
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "10" in page "CompareProducts.orderCodeItem_text"
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "9" in page "CompareProducts.orderCodeItem_text"
    And I take screenshot
    And I click "PLP.firstAdd_button" using js
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I take screenshot
		And I click on delete all link "CompareProducts.deleteAll_link"
		Then I verify absence of element "CompareProducts.orderCodeItem_text"
