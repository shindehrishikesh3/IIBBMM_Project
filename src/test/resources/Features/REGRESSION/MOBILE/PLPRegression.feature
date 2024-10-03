@PLP @mobAgileRegression @mobValidationTests
Feature: PLP Regression

	Background: Launch homepage for PLP regression check
  Given web site is launched successfully and user "does" accept the cookies
  
  @PLPMobileRegr @eu @apac @nwk @live
  Scenario: Verify Product Lister Page
 	When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
 	And I verify that element "Search.breadCrumb_element" is present on page
 	#--dropdown validation--#
 	When I verify SortBy dropdown element "PLP.sortby_dropdown" is present on page
  And I click on "PLP.sortby_dropdown"
  And I take screenshot
  And I verify dropdown list items in mobile "PLP SortBy" PLP page
  When I select by index "2" from dropdown "PLP.sortby_dropdown"
  And I wait for "3" seconds
  And verify url parameter value as "w/c/crystals-oscillators/crystals/prl/results?sort=P_PRODUCT_ID|1"
  And I navigates back in the browser
  And I wait for "3" seconds
  And I take screenshot.
  #--PageNavigation validation--#
  And I verify top pagination element "PLP.firstPagination_text" is present on page and display its value in report
  And I verify bottom pagination element "PLP.secondPagination_text" is present on page and display its value in report
  And I verify bottom page navigation element "PLP.pageNavigation_element" is present on page  
  #--Static Filter and search--#
 	Then I get the PLP Products found count before applying filters
 	When I click on refine results button to view the filter options "Filters.refineResults_button"
  And I scroll down the page by pixels "250"
 	And I click on the expand button of Static Filters Availability to see the options "Filters.plusSignOfAvailability_image"
  And I click on Instock checkbox to apply the filters "Filters.instock_checkbox"
  Then I verify element "Filters.filtersSelected_text" is present on page and display its value in report 
  And I click on Apply Filters button to see the resultant products count "Filters.applyFilters_button"
  And I wait for "3" seconds
  And I take screenshot.
  And I verify the PLP Products found count after applying filters
  And I verify element "Filters.filtersApplied_text" is present on page and display its value in report  
  When I verify element "Filters.searchWithinTermBox_textbox" is present on page
  And I enter value "ABS0" in textbox "Filters.searchWithinTermBox_textbox"
  And I click on "PLP.searchWithin_button"
  And user verify text "ABS0" is visible for "PLP.category_text"
  And user navigates back in the browser
  And I verify produts found count element "PLP.titleProductCount_value" is present on page and display its value in report
  And I take screenshot.
  #--PLP Page pdt validation--#
  And I verify first product element "PLP.firstPdt_element" is present on page
  And I verify that element "PLP.firstPdtDetails_element" is present on page
  And I scroll down the page by pixels "250" 
 	When I save the value of First Order code from PLP Page
 	And I verify element "PLP.firstManufacturerPartNo_link" is present on page and display its value in report
 	And I verify element "PLP.firstProdDetails_text" is present on page and display its value in report
 	And I verify that element "PLP.firstProdImage_link" is present on page
 	And I scroll down the page by pixels "200" 	
 	#--Clicking on Pdt to view PDP--#	
 	And I click "PLP.firstManufacturerPartNo_link"
 	And I wait for "3" seconds
 	And I take screenshot.
 	And I verify that element "PDP.productHeading_text" is present on page
 	And I navigates back in the browser
 	And I wait for "3" seconds
 	And I verify that element "Filters.refineResults_button" is present on page
 	#--Availability--# 	
 	And I verify that element "PLP.firstavailAndPrice_element" is present on page
 	And I verify that element "PLP.firstPdtStock_element" is present on page 
 	And I verify element "PLP.firstProdStock_text" is present on page and display its value in report
 	#--Price--#
 	And I verify that element "PLP.firstPdtPrice_element" is present on page 
 #	And I verify that element "PLP.firstProdMorePricing_link" is present on page  
 	And I verify and click from multiple "PLP.prodMorePricing_link" on any one link 
 	And I verify element "PLP.firstProdPricelist_text" is present on page and display its value in report
 	#--Extended Attributes--# 	
 	And I verify that element "PLP.firstProdExtAttr_section" is present on page
 	And I verify that element "PLP.firstProdExtendedAttr_link" is present on page 		
 	And I click on "PLP.firstProdExtendedAttr_link"
 	And I verify element "PLP.firstProdExtendedAttr_text" is present on page and display its value in report
 	And I take screenshot.
 	And I scroll down the page by pixels "200"  
 	#--RoHS--#	 	
	And I verify that element "PLP.firstROHSlogo_link" is present on page
  When I click on "PLP.firstROHSlogo_link"
  And I wait for "3" seconds
  And I verify element "PLP.roHSCertificatePopup_text" is present on page and display its value in report
  And I verify that element "PDP.pDFCert_link" is present on page
  And I verify that element "PDP.hTMLCert_link" is present on page
  And I take screenshot.
  Then I click on "PDP.closeProdCompCert_button" 	
  #--Adding Pdt to cart--#
 	When user verify text "Quantity" is visible for "PLP.firstProdQty_text"
  And I verify that element "PLP.firstProdQty_textbox" is present on page
  Then user clears text from textbox "PLP.firstProdQty_textbox"
  And I enter value "20" in textbox "PLP.firstProdQty_textbox"
  Then I click on "PLP.firstProdAdd_button"
 	And user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
 	And I take screenshot.
  And I click on "PDP.continueShopping_button"
  #--Full Availability--#
  #--CommentingSteps as click on full availability is not working--#
  #And I wait for "3" seconds
 	#And I scroll up the page by pixels "200" 
 	#And I verify that element "PLP.firstProdFullAvailability_link" is present on page 
 	#And I click on "PLP.firstProdFullAvailability_link"
 	#And I take screenshot.
 	#And I verify element "PLP.firstProdFullAvailability_text" is present on page and display its value in report
  
 	
 	
