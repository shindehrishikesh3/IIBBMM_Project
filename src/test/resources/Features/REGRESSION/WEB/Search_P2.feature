@validationTests
Feature: Search priority 2 validation tests

  @viewROHSCertificateRegression @Priority2 @eu @apac @nwk @live
  Scenario: Search - View ROHS certificate and displays users name
		    Given web site is launched successfully and user "does" accept the cookies
				And I wait for "2" seconds
		    And customer accesses the website as "register" user
		    And I save the newly registered "regular" user details
		  	And I verify element "Header.searchBox_textbox" is present on page
			  And I enter the value "bav99" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
				And I wait for "2" seconds
				And I verify PLP table element "PLP.PLP_element" is present on page
		    And I verify element "PLP.rohsCertificateOfCompliance_icons" is present on page
		    And I wait for "3" seconds
		    And I take screenshot
		    And click "PLP.rohsCertificateOfCompliance_link" using js
		    Then I wait for "3" seconds
		    And I take screenshot
		    And I click HTMLCertificate in product compliance certificate popup "PLP.htmlCertificate_link"
		    And I wait for "5" seconds
		    Then I switched on Rohs window and verify customer name in application and Rohs Certificate
		    And I wait for "3" seconds
		    And I take screenshot
		    Then I switch to parent window
		    And I wait for "3" seconds
		    And I click "PLP.firstAdd_button" using js
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I wait for "3" seconds
		    And I scroll till "ShoppingCart.rohsCertificateOfCompliance_icons"
		    And I wait for "3" seconds
		    And I take screenshot
		    Then I verify element "ShoppingCart.rohsCertificateOfCompliance_icons" is present on page
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then I click on logout option "Header.logout_button"

  @MPNSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Manufacturer Part Number Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ManufacturerPartNumber>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify element "PDP.manufPartNo_text" is present on page
		    And I take screenshot of search results page
		    Then I verify PDP page contains MNP "<ManufacturerPartNumber>" in "PDP.manufPartNo_text"
		
		    Examples: 
		      | ManufacturerPartNumber |
		      | ZBVB45                 |
		      | 22.22.8.230.4000       |
		      | ST5918M3008-A      |

  @DescriptiveSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Descriptive Keyword Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ProductDescription>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I take screenshot of the search results page
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    Then I verify element "Search.productsHeader_text" is present on page
		    And I verify search results product header contains "<ProductDescription>" in "Search.productsHeader_text"
		
		    Examples: 
		      | ProductDescription                        |
		      | chip resistor 10 kohm thick film          |
		      | trimpot, multi turn, cermet, top adjust   |
		      | shift register, 8 bit, serial to parallel |

  @ManufacturerSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Manufacturer Name Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ManufacturerName>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "5" seconds
		    And I take screenshot of the Manufacturer details page.
		    Then I verify current url contains "/b/"
		    Then I verify element "ManufacturerDetailsPage.ManufacturerName_imgText" is present on page
		    Then I verify element "ManufacturerDetailsPage.ManufacturerDescription_element" is present on page
		    Then I verify text "<ManufacturerName>" in page "ManufacturerDetailsPage.ManufacturerName_imgText" with attribute "alt"
		    And I verify element "ManufacturerDetailsPage.ManufacturerDescription_element" is present on page

		    Examples: 
		      | ManufacturerName |
		      | renesas          |
		      | Kemet            |
		      | 3M               |

  @StemmingSearch @Search @Priority2 @eu @apac @nwk @live
  Scenario Outline: Stemming Keyword Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    And I take screenshot to verify the correct search page is loaded
		    And I get the products found count for keyword search
		    And I clears text from textbox "Header.searchBox_textbox"
		    And user enter the value "<StemmingKeyword>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    And I take screenshot to verify the correct search page is loaded
		    And I get the products found count for stemming keyword search
		    Then I verify the product count equal or not for stemming search
		
		    Examples: 
		      | keyword  | StemmingKeyword |
		      | resistor | resistors       |
		      | register | registers       |

  

  

  @CompareProducts @Priority2 @eu @apac @nwk @live
  Scenario: Compare Products
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Header.searchIcon_button" is present on page
		    And I enter the value "bav99" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "2" seconds
		    And I verify PLP table element "PLP.PLP_element" is present on page
		    And I save the details of "5" product from PLP table
		    And I select first "5" checkbox from PLP table
		    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
		    And I wait for "2" seconds
		    And I verify element "CompareProducts.CompareProducts_text" is present on page
		    And I take screenshot
		    And I compare the saved details of "5" products from PLP table with compare product page
		    And I scroll till "CompareProducts.addToCart_button"
		    And I click on Add To cart icon "CompareProducts.addToCart_button"
		    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		    And I click on delete all link "CompareProducts.deleteAll_link"

    @NullResultPage @Priority2 @aditya @agileRegression @eu @apac @nwk
    Scenario Outline: Null search Results Page
            Given web site is launched successfully and user "does" accept the cookies
            Then customer accesses the website as "userType" user
            Given I verify element "Header.searchBox_textbox" is visible in DOM
            When user enter the value "<SearchTerm>" in textbox "Header.searchBox_textbox"
            Then I click  "Header.searchIcon_button" using js
            And I verify null result page is displayed
            And  I verify error message contains search term
            And I verify if the enter "<SearchTerm>" is part of the string that u see on the top of the page
            And I verify the espot image is available on null result page
            Then I scroll down the page by pixels "500"
            And I verify text "Search Tips" in page "NullResultPage.searchtips_label"
            Then I verify text of"Search Tips" is Not Bold "NullResultPage.searchtips_label"
            And I verify text "Can We Help?" in page "NullResultPage.searchPagehelp_label"
            Then I verify text of "Can We Help?" is Not Bold "NullResultPage.searchPagehelp_label"
            And I verify text "Popular Product Categories" in page "NullResultPage.ProductCategories_label"
            And user take screenshot of the page
            And user clears text from textbox "Header.searchBox_textbox"

            Examples:
                  | SearchTerm |
                  | shshshhs   |
                  | sdsadsad   |
                  | vdsdsahh   |
                  
        @QuickOrderUI @Priority2 @Search @eu @apac @nwk @live
        Scenario: Check the UI for the QuickOrder page
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Header.tools_link" is present on page
		    And I hover on element "Header.tools_link"
		    And I click on QuickBuy link from tools list "Header.quickBuy_link"
		    And I wait for "2" seconds
		    And I verify element "QuickBuy.quickBuy_icon" is present on page
		    And I verify element "QuickBuy.quickBuyPageTitle_text" is present on page
		    And I verify element "QuickBuy.BOMUpload_button" is present on page
		    And I verify element "QuickBuy.quickOrder_tab" is present on page
		    And I verify element "QuickBuy.quickPaste_button" is present on page
		    And I verify element "QuickBuy.addToAllBasket_button" is present on page
		    And I verify element "QuickBuy.OrderCode_column" is present on page
		    And I verify element "QuickBuy.Quantity_column" is present on page
		    And I verify element "QuickBuy.matchedPart_column" is present on page
		    And I verify element "QuickBuy.priceFor_column" is present on page
		    And I verify element "QuickBuy.price_column" is present on page	    
		    And I verify element "QuickBuy.availability_column" is present on page
		    And I verify element "QuickBuy.Description_column" is present on page
		    And I verify element "QuickBuy.stockDiscrepency_text" is present on page
		    And I verify element "QuickBuy.addRow_link" is present on page
		    
		    And I verify count of elements present as "5" in page "QuickBuy.defaultRowCount_textbox"
		    And I take screenshot of page
		    ###########################
		    
		     @QuickOrderFunctionality @Priority2 @Search @eu @apac @nwk @live
        Scenario: Check the basic functionalities of QuickOrder
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Header.tools_link" is present on page
		    And I hover on element "Header.tools_link"
		    And I click on QuickBuy link from tools list "Header.quickBuy_link"
		    
		    And I take screenshot of page
		    
		    Then I fill the form with different product code using given file "QuickOrderProduct.xlsx"	    
		    And I verify element "QuickBuy.matchedPartValue_text" is present on page and display its value in report
		    And I verify element "QuickBuy.priceForValue_text" is present on page and display its value in report
		    And I verify element "QuickBuy.priceValue1_text" is present on page and display its value in report
		    And I verify element "QuickBuy.availabilityValue_text" is present on page and display its value in report
		    And I verify element "QuickBuy.DescriptionValue_text" is present on page and display its value in report
		    And I verify element "QuickBuy.greenTick_icon" is present on page
		    And I click on the "QuickBuy.addToAllBasket_button"
		    Then I verify element "ShoppingCart.firstProductOnCart_text" is present on page    
		    Then I verify element "ShoppingCart.quantityFirstProduct_textbox" is present on page
		    And I take screenshot of page
		    And I wait for "3" seconds
		    And I click on "Header.tools_link"
		    And I click on QuickBuy link from tools list "Header.quickBuy_link"   
		    And I take screenshot of page
		    Then I wait for "5" seconds
		    #And I verify element "QuickBuy.successfullyDeleted_text" is present on page
		    And I click on add row link "QuickBuy.addRow_link"
		    And I wait for "3" seconds
		    Then I verify element "QuickBuy.addedNewRow_textbox" is present on page 
		    And I wait for "4" seconds
		    Then I check the limit for the addition of rows by adding rows "QuickBuy.addRow_link"
		    And I take screenshot of page
		    
		      
		    @QuickPaste @Priority2 @Search @eu @apac @nwk @live
        Scenario: Add items to the basket using quick paste
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Header.tools_link" is present on page
		    And I hover on element "Header.tools_link"
		    And I click on QuickBuy link from tools list "Header.quickBuy_link"
		    And I wait for "2" seconds
		    And I click quick Paste button on quick buy page "QuickBuy.quickPaste_button"
		    And I verify element "QuickBuy.quickPasteArea_textbox" is present on page
		    And I verify element "QuickBuy.copyPaste_text" is present on page
		    And I verify element "QuickBuy.quickPaste_image" is present on page
		    And I verify element "QuickBuy.belowAddToBasket_text" is present on page
        And I wait for "3" seconds
		    And I enter quick paste order details information by using given file "QuickBuyOrderDeatils.xlsx"
		    And I click on Add To Basket button "QuickBuy.addToCart_button"
		    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		    And I take screenshot of page
		    
		    @QuickBuyBOMUpload @Priority2 @Search @eu @apac @nwk @live
        Scenario: BOM Upload in the Quick Order UI
        Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "register" user
		    And I verify element "Header.tools_link" is present on page
		    And I hover on element "Header.tools_link"
		    And I click on QuickBuy link from tools list "Header.quickBuy_link"
		    And I wait for "2" seconds
   			And I click on BOM Upload "QuickBuy.bomUpload_button"
        And I wait for "2" seconds
        And I verify element "BOMUploadPage.bomUpload_element" is present on page
        And User scroll down the page by pixels "1000"
        And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
        And I upload the file "BOM_Test.xlsx" into the element "BOMUploadPage.uploadFile_text"
        And I wait for "10" seconds
    		And I navigates back in the browser
    		And I wait for "2" seconds
    		And I wait "long" duration for "BOMUploadPage.dateCreated_text" element to "appear"
    		And I verify element "BOMUploadPage.dateCreated_text" is present on page and display Date Created in report
   			And I verify element "BOMUploadPage.lastModified_text" is present on page and display last modifed date in report
   		  And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    		And I wait for "2" seconds
    		And I take screenshot of page
		    