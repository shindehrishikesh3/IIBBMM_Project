#Author: Vallari Kulkarni (modified-Naina)
@PDP @mobAgileRegression
Feature: PDP Regression

  Background: Launch homepage for PDP regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @instock @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP for instock product
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And I verify element "PDP.productHeading_text" is present on page and display its value in report
    And I verify element "PDP.productCatName_text" is present on page and display its value in report
    And I verify element "PDP.productAttributes_text" is present on page and display its value in report
    When scroll till "PDP.imagesSection_element"
    Then user verify text "Images" is visible for "PDP.imageSection_text"
    And I click on "PDP.imagesSection_element"
    And I verify that element "PDP.productImage_image" is present on page
    And I verify that element "PDP.thumbnailImageSection_element" is present on page
    And I click on "PDP.thumbnaiImage2_image"
    And I verify element "PDP.underImagetext_text" is present on page and display its value in report
    When scroll till "PDP.priceSection_element"
    #Then user verify text "Price" is visible for "PDP.priceSection_text"
    And I verify below are displayed in "PDP.priceTableAttribute_text" table on PDP
      | Price for               |
      | Minimum order quantity  |
      | Order multiple quantity |
      | Price                   |
    And I verify element "PDP.priceFor_text" is present on page and display its value in report
    And I verify element "PDP.price_text" is present on page and display its value in report
    And I verify that element "PDP.yourPartNo_link" is present on page
    When I click on "PDP.yourPartNo_link"
    Then I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    And I wait for "3" seconds
    When user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    Then user clears text from textbox "PDP.quantity_textbox"
    And I enter value "10" in textbox "PDP.quantity_textbox"
    When I click on "PDP.addToCart_button"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I wait for "5" seconds
    Then I click on "PDP.continueShopping_button"
    And I verify that element "PDP.price_list" is present on page
    When scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "Availability" is visible for "PDPBuyBox.availabilitySection_text"
    Then I verify element "PDPBuyBox.availableStock_text" is present on page and display its value in report
    And I verify element "PDPBuyBox.seeCutOffTime_link" is present on "EUROPE,NEWARK" region/store
    And I click on "PDPBuyBox.seeCutOffTime_link" only in "EUROPE,NEWARK" store/region
    And I verify element "PDPBuyBox.seeCutOffTime_text" is present on page and display its value in report
    And I wait for "5" seconds
    And I verify that element "PDPBuyBox.morestockinfo_text" is present on page
    And I click on "PDPBuyBox.availableStock_text"
    When scroll till "PDP.productInfoSection_element"
    Then user verify text "Product Information" is visible for "PDP.productInfoSection_text"
    And I verify element "PDP.manufacturerLogo_link" is present on page
    And I verify that element "PDP.prodInfo_table" is present on page
    And I verify that element "PDP.orderCode_text" is present on page and display its value in report
    And I verify that element "PDP.manufacturerName_link" is present on page and display its value in report
    When I click on "PDP.manufacturerName_link"
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    Then user navigates back in the browser
    And I verify that element "PDP.technicalDataSheet_text" is present on page
    When I click on "PDP.viewAllTechDoc_link"
    # Then user verify text "Technical Documents" is visible for "PDP.technicalDocSection_text"
    # And I verify that element "PDP.technicalDocSection_element" is present on page
    # And I click on "PDP.technicalDocSection_element"
    # Then I verify number of technical documents matches with the header
    When scroll till "PDP.productOverviewSection_element"
    Then user verify text "Product Overview" is visible for "PDP.productOverviewSection_text"
    And I verify that element "PDP.prodOverview_text" is present on page
    And I verify that element "PDP.viewAll_text" is present on page
    And I wait for "5" seconds
    When I click on "PDP.viewAllCategory_link"
    And I wait for "5" seconds
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    Then user navigates back in the browser
    And I wait for "3" seconds
    When scroll till "PDP.legislationAndEnvSection_element"
    Then user verify text "Legislation and Environmental" is visible for "PDP.legislationAndEnvSection_text"
    Then I click on "PDP.legislationAndEnvSection_element"
    And I verify that element "PDP.prodComplianceCert_link" is present on page
    And I click on "PDP.prodComplianceCert_link"
    And I wait for "3" seconds
    And I verify that element "PDP.pDFCert_link" is present on page
    And I verify that element "PDP.hTMLCert_link" is present on page
    And I click on "PDP.closeProdCompCert_button"

  @video @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Image section for video product
    Given I enter "video" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    When scroll till "PDP.imagesSection_element"
    And I click on "PDP.imagesSection_element"
    And I verify that element "PDP.thumbnailImageSection_element" is present on page
    And I verify that element "PDPBuyBox.videoImage_image" is present on page
    When I click on "PDPBuyBox.videoImage_image"
    Then I verify that element "PDPBuyBox.videoPopup_element" is present on page
    And I click on "PDPBuyBox.closeVideoPopup_element"

  @backorder @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for backorder product
    Given I enter "backorder" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And scroll till "PDPBuyBox.availabilitySection_element"
    Then user verify text "Available for back order" is visible for "PDPBuyBox.availableStock_text"
    And I click on "PDPBuyBox.contactWhenBackInStock_link"
    And I switch to "PDPBuyBox.contactMeBackIframe_element" frame
    And I verify element "PDPBuyBox.contactMeOverlyOrderCode_text" is present on page and display its value in report
    Then I switch to default frame
    And I wait for "3" seconds
    And I click on "PDPBuyBox.closeContactMeOverlay_button"
    And I verify element "PDPBuyBox.morestockinfo_text" is present on page and display its value in report

  @nls @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for No Longer Stocked product
    Given I enter "nls" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And scroll till "PDPBuyBox.availabilitySection_element"
    And I verify element "PDPBuyBox.nLSNLM_text" is present on page and display its value in report

  @nlm @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for No Longer Manufactured product
    Given I enter "nlm" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And scroll till "PDPBuyBox.availabilitySection_element"
    And I verify element "PDPBuyBox.nLSNLM_text" is present on page and display its value in report

  @directship @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for direct ship product
    Given I enter "directship" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And scroll till "PDPBuyBox.availabilitySection_element"
    And I verify element "PDPBuyBox.availableStock_text" is present on page and display its value in report
    And I verify that element "PDPBuyBox.usStock_link" is present on page
    And I click the "PDPBuyBox.usStock_link"
    And I verify element "PDPBuyBox.usStockPopup_text" is present on page and display its value in report
    And I click on "PDPBuyBox.availableStock_text"
    And I verify element "PDPBuyBox.deliveryCharge_text" is present on "EUROPE" region/store
    And I verify element "PDPBuyBox.deliveryMsg_text" is present on page and display its value in report
    And I verify element "PDPBuyBox.morestockinfo_text" is present on page and display its value in report

  @sds @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for Supplier Direct Ship product
    Given I enter "sds" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And scroll till "PDPBuyBox.availabilitySection_element"
    And I verify that element "PDPBuyBox.sDS_link" is present on page
    And I click the "PDPBuyBox.sDS_link"
    And I verify element "PDPBuyBox.sDSPopup_text" is present on page and display its value in report

  @supplierleadtime @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for available to supplier lead time product
    Given I enter "supplierleadtime" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "Available to supplier Lead Time" is visible for "PDPBuyBox.availableStock_text"
    And I verify element "PDPBuyBox.morestockinfo_text" is present on page and display its value in report
    And I verify element "PDPBuyBox.nonCancelNonReturn_text" is present on page and display its value in report

  @0stocksds @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for 0 stock Supplier Direct Ship product
    Given I enter "0stocksds" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "0 In stock" is visible for "PDPBuyBox.availableStock_text"
    And I verify that element "PDPBuyBox.sDS_link" is present on page
    And I click the "PDPBuyBox.sDS_link"
    And I verify element "PDPBuyBox.sDSPopup_text" is present on page and display its value in report

  @backorderdirectship @mobAgileRegression @eu @apac @nwk
  Scenario: Verify PDP Buybox for us stock product
    Given I enter "backorderdirectship" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "Available for back order" is visible for "PDPBuyBox.availableStock_text"
    And I verify that element "PDPBuyBox.usStock_link" is present on page
    And I click the "PDPBuyBox.usStock_link"
    And I verify element "PDPBuyBox.usStockPopup_text" is present on page and display its value in report
    And I click on "PDPBuyBox.availableStock_text"
    And I verify element "PDPBuyBox.deliveryCharge_text" is present on "EUROPE" region/store
    And I verify element "PDPBuyBox.deliveryMsg_text" is present on page and display its value in report
    And I verify element "PDPBuyBox.morestockinfo_text" is present on page and display its value in report

  @nameAndImgAccordian @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to verify whether Product name and details are displaying as expected
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    And I verify text color of Product Heading as "dark charcoal,#333333,PDP.productHeading_text"
    And I verify text of Product Heading is Bold "PDP.productHeading_text"
    And I verify text color of Product Heading as "black,#000000,PDP.productCatName_text"
    And I verify text color of Product Heading as "sonic silver,#000000,PDP.productCatName_text"
    When I click on "PDP.imagesSection_element"
    And I verify element "PDP.productImage_image" is visible in DOM
    Then I verify element "PDP.underImagetext_text" is visible in DOM

  @PriceAccordian @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to verify price section and details of the product
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    Then I scroll till "PDP.priceSection_element"
    And I wait for "3" seconds
    And I verify below are displayed in "PDP.priceTableAttribute_text" table on PDP
      | Price for               |
      | Minimum order quantity  |
      | Order multiple quantity |
      | Price                   |
    When I click on "PDP.yourPartNo_link"
    Then I verify element "PDP.yourPartNo_text" is visible in DOM
    And I verify element "PDP.yourPartNo_textbox" is visible in DOM
    And I verify element "PDP.lineNote_text" is visible in DOM
    And I verify element "PDP.lineNote_textbox" is visible in DOM
    When I click on "PDP.yourPartNo_link"
    When I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    When user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    And I verify background color of cart button as "green,#41c363,PDP.addToCart_button"
    Then user clears text from textbox "PDP.quantity_textbox"
    And I enter value "10" in textbox "PDP.quantity_textbox"
    When I click on "PDP.addToCart_button"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"

  @AvailabilityAccordian @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to check the availability of a product
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    Given scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "Availability" is visible for "PDPBuyBox.availabilitySection_text"
    Then I verify element "PDPBuyBox.availableStock_text" is present on page and display its value in report
    #And I verify element "PDPBuyBox.seeCutOffTime_link" is present on "EUROPE,NEWARK" region/store

  #And I click on "PDPBuyBox.seeCutOffTime_link"
  #Then I verify element "PDPBuyBox.seeCutOffTime_text" is present on page and display its value in report
  @ProductInfoAccordian @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to verify product information
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    Given scroll till "PDP.productInfoSection_element"
    And user verify text "Product Information" is visible for "PDP.productInfoSection_text"
    And I verify element "PDP.manufacturerLogo_link" is present on page
    And I verify element "PDP.manufacturerName_text" is present on page
    And I verify that element "PDP.prodInfo_table" is present on page
    And I verify that element "PDP.orderCode_text" is present on page and display its value in report
    When I click on "PDP.manufacturerName_link"
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    Then user navigates back in the browser
    And I verify that element "PDP.technicalDataSheet_text" is present on page
    When I click on "PDP.viewAllTechDoc_link"
    And I switch to technical docs window
    Then I take screenshot

  # Then user verify text "Technical Documents" is visible for "PDP.technicalDocSection_text"
  # And I verify that element "PDP.technicalDocSection_element" is present on page
  # And I click on "PDP.technicalDocSection_element"
  # Then I verify number of technical documents matches with the header
  @ProductOverviewAccordian @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to verify product overview
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    Given scroll till "PDP.productOverviewSection_element"
    And I verify text color of Product Heading as "dark charcoal,#333333,PDP.prodOverview_text"
    Then I verify that text in "PDP.viewAllCategory_link" contains the text in "PDP.manufacturerName_link"

  @Legislation @mobRegression @eu @apac @nwk @live
  Scenario: This scenario is to verify Legistation Accordian
    Given I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    Given scroll till "PDP.legislationAndEnvSection_element"
    When I click on "PDP.legislationAndEnvSection_element"
    And I wait for "3" seconds
    And I verify below are displayed for "EU,APAC" region or store in "PDP.legalContent_table" table
      | Country of Origin                       |
      | Tariff No                               |
      | RoHS Compliant                          |
      | RoHS Phthalates Compliant               |
      | Download Product Compliance Certificate |
      | Weight (kg)                             |
    And I verify below are displayed for "NEWARK" region or store in "PDP.legalContent_table" table
      | Authorized Distributor                  |
      | RoHS Compliant                          |
      | RoHS Phthalates Compliant               |
      | SVHC                                    |
      | Download Product Compliance Certificate |
    And I verify element "PDP.roHSCompliantIcon_element" is present on page
    When I click on "PDP.prodComplianceCert_link"
    And I verify element "PDP.pDFCert_link" is present on page
    And I verify element "PDP.hTMLCert_link" is present on page
    Then I click on "PDP.closeProdCompCert_button"
    And I wait for "2" seconds
    When I click on "PDP.prodComplianceCert_link"
    And I click on "PDP.hTMLCert_link"
    And I wait for "2" seconds
    And I switch to new window
    #And I wait "3" seconds for displaying new window
    Then I verify current url contains "GenerateRoHSCertificate"
