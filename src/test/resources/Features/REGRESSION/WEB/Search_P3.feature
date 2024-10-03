@validationTests
Feature: Search priority 3 validation tests

      @leadTimeDisplay @AddToBasketUsingLHSNav @Priority3 @eu @apac @nwk @live
      Scenario: Search - Verify lead time display in product lister page by navigating from LHS nav
            Given web site is launched successfully and user "does" accept the cookies
            Then customer accesses the website as "guest" user
            And I verify element "Header.allProducts_link" is present on page
            And I hover on element all products header "Header.allProducts_link"
            And verify values in the "Home.lhsSuperCategories_list" table are not empty
            And I take screenshot
            And I scroll down the page by pixels "500"
            And I click ViewAllproducts link from LHS nav "Home.viewAllProducts"
    				And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
    				And I click "BrowseForProducts.secondCategory_link"
    				And I wait for "2" seconds
    				And I scroll till "CategoryPage.showAllProducts_button"
            And I click Show all Products button on category page "CategoryPage.showAllProducts_button"
            And I wait for "3" seconds
            And I verify element "PLP.PLP_element" is present on page
            And I take screenshot
            And I click "PLP.sortDescending_button"
            And I wait for "4" seconds
            And I take screenshot
            When I click on first instock availability link "PLP.firstInStock_link"
            And I wait for "2" seconds
            And I take screenshot
            Then I verify element "PLP.leadTime_popup" is present on page
            And I verify element "PLP.leadTimePopup_text" is present on page and display in report
            And I take screenshot
            And I click "PLP.firstManufacturerPartNo_link"
            And I wait for "3" seconds
            And I verify element "PDP.productTitle_text" is present on page and display in report
            And I scroll till "PDPBuyBox.addToCart_button"
            And I wait for "2" seconds
            And I click Add to cart button "PDPBuyBox.addToCart_button"
            And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
            And I scroll till "Header.miniBasket_link"
            And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"

      @FindSimilarProducts  @Priority3 @eu @apac @nwk @live 
      Scenario: Search - 'Find Similar products' from PDP page
            Given web site is launched successfully and user "does" accept the cookies
            And  customer accesses the website as "guest" user
            When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
            And I wait for "4" seconds
            And I click on Manufacturer Product Name in PLP page "PLP.manufacturerFirst_link"
            And I scroll till "PDP.findSimilarProducts_button"
            And I click on Find Similar Products "PDP.findSimilarProducts_button"
            And User switch to Filter window
            And I click on "Filters.sideMenuThirdCategory_link"
            And I get the Products found count before applying filters in Filter Tool tab
            And I apply filters in Filter Tool tab by checking checkbox "Filters.filterFirstproperty_checkbox"
            And I wait for "8" seconds
            And I click on "Filters.filtersAppliedArrow_button"
            And I click on remove filters in bottom Filters applied section "Filters.removeFilter_icon"
            And I click on "Filters.filtersAppliedArrow_button"
            And I apply filters in Filter Tool tab by checking checkbox "Filters.filterFirstproperty_checkbox"
            And I verify the Products found count after applying filters in Filter Tool tab
            And I click on Clear all filters button to clear Filters "Filters.clearAllFiltersinTooltab_button"
            And I wait for "4" seconds
            When I apply filters in Filter Tool tab by checking checkbox "Filters.filterFirstproperty_checkbox"
            And I wait for "5" seconds
            And User click on "Filters.applyFiltersinTooltab_button"
            And I wait for "8" seconds
            And I verify the Products found count after applying all the filters in PDP page
            And I take screenshot of the page

      @ChangingPerPageProductsAndPaginationOnPLP @Priority3 @eu @apac @nwk @live
      Scenario: Changing the products per page and perform pagination
            Given web site is launched successfully and user "does" accept the cookies
            And customer accesses the website as "guest" user
            When I click the "Header.searchIcon_button"
            And I wait for "3" seconds
  			 	  And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
 				    And I click "BrowseForProducts.secondCategory_link"
            And I scroll till "CategoryPage.showAllProducts_button"
            And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
            And I verify PLP table element "PLP.PLP_element" is present on page
            #---------------Changing the 'Per page product count' and validation------------
            And I verify "25" products are listed in products table "PLP.compareCheck_checkbox"
            Then I select by index "0" from dropdown "PLP.mySelectTop_dropdown"
            And I wait for "5" seconds
            And I verify PLP table element "PLP.PLP_element" is present on page
            And I verify "10" products are listed in products table "PLP.compareCheck_checkbox"
            Then I select by index "2" from dropdown "PLP.mySelectTop_dropdown"
            And I wait for "5" seconds
            And I verify PLP table element "PLP.PLP_element" is present on page
            And I verify "50" products are listed in products table "PLP.compareCheck_checkbox"
            #On PLP 10, 25,50 options available in dropdown to change pagination 
            #Then I select by index "3" from dropdown "PLP.mySelectTop_dropdown"
            #And I wait for "5" seconds
            #And I verify PLP table element "PLP.PLP_element" is present on page
            #And I verify "100" products are listed in products table "PLP.compareCheck_checkbox"
            Then I select by index "1" from dropdown "PLP.mySelectTop_dropdown"
            And I wait for "5" seconds
            And I verify PLP table element "PLP.PLP_element" is present on page
            And I verify "25" products are listed in products table "PLP.compareCheck_checkbox"
            #----------------Pagination--------------------------------------------------
            And I click on third Element Pagination "PLP.paginThird_element"
            And I wait for "2" seconds
            And verify current url contains "3"
            And I scroll till "PLP.supplierHeader_label"
            And I wait for "2" seconds
            And I click on previous arrow "PLP.paginPrewArrow_element"
            And I wait for "2" seconds
            And verify current url contains "2"
            And I click on next arrow "PLP.PaginNextArrow_element"
            And I wait for "2" seconds
            And verify current url contains "3"
            And I take screenshot

 @SpecialCharSearch @Priority3 @Search @eu @apac @nwk @live
  Scenario Outline: Special Char Keyword Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<specChar>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "5" seconds
		    Then I take screenshot of the search results page
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    And I verify search results product header contains "<specChar>" in "Search.productsHeader_text"
		
		    Examples: 
		      | specChar |
		      | 100°c    |
		      | ± 15%    |
