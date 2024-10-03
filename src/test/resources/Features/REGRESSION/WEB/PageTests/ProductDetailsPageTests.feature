@agileRegression @pdp
Feature:  PDP tests

    Background: Launch homepage for PDP regression check
        Given web site is launched successfully and user "does" accept the cookies
        Then customer accesses the website as "userType" user

    @pdpbuybox @eu @apac @nwk
    Scenario: Verify PDP buy box and description section for instock product
        Given I enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify element "PDP.productTitle_text" is present on page
        Then I verify element "PDP.productSubtitle_text" is present on page
        Then I verify element "PDP.addToCompare_link" is present on page
        And I take screenshot
        And I click on Add to compare link "PDP.addToCompare_link"
        And I verify element "PDP.comaparePageTitle_text" is present on page
        And user navigates back in the browser
        Then I verify element "PDP.manufacturerLogo_image" is present on page
        And I click on the manufacturer logo "PDP.manufacturerLogo_image"
        Then I verify element "PDP.manufacturerPageTitle_text" is present on page
        And user navigates back in the browser
        Then I verify below are displayed in "PDP.descriptionTable_list" table on PDP
            | Manufacturer         |
            | Manufacturer Part No |
            | Order Code           |
            | Technical Datasheet  |
        Then I verify values in the "PDP.detailsTableValues_list" table are not empty
        Then I verify element "PDPBuyBox.availabilityPriceContainer_element" is present on page
        And I verify element "PDPBuyBox.availabilityHeading_text" is present on page
        And I verify element "PDPBuyBox.cutOffTimeA_text" is present on "EUROPE,NEWARK" region/store
        And I verify element "PDPBuyBox.cutOffTimeB_text" is present on "EUROPE,NEWARK" region/store
        And I verify element "PDPBuyBox.availabilityList_text" is present on "APAC" region/store only
        Then I verify cutoff time tooltip is present on "EUROPE,NEWARK" region websites
        Then I verify element "PDPBuyBox.exclVatPrice_text" is present on page and display in report
        Then I verify element "PDPBuyBox.priceFor_text" is present on page and display 'Price For' in report
        Then I verify element "PDPBuyBox.multiple_text" is present on page and display 'Multiple' in report
        Then I verify element "PDPBuyBox.minimum_text" is present on page and display 'Minimum' in report
        And I verify element "PDPBuyBox.instock_icon" is present on page
        And I scroll down the page by pixels "100"
        # Removed as part of SD-1917 & SD-2346
        #And I verify element "PDPBuyBox.requestaQuote_link" is present on page
        #And I click "PDPBuyBox.requestaQuote_link"
        #And I verify element "PDPBuyBox.requestAQuoteTitle_text" is present on page
        #And user navigates back in the browser
        And I verify element "PDPBuyBox.qtyLabel_text" is present on page
        And I verify element "PDPBuyBox.qty_textbox" is present on page
        And I verify element "PDPBuyBox.addToCart_button" is present on page
        And I enter value "15" in textbox "PDPBuyBox.qty_textbox"
        And I wait for "2" seconds
        And I verify total price for entered quantity
        And I verify element "PDPBuyBox.addLineNote_link" is present on page
        And I verify element "PDPBuyBox.addtoFavourites_link" is present on page
        And I take screenshot

    @pdsections @eu @apac @nwk
    Scenario: Verify Product information, Product overview, technical docs and Legislation & Environmental sections for instock product
        Given I enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify element "PDP.productTitle_text" is present on page
        Then I scroll down the page by pixels "1000"
        And I take screenshot
        Then I verify element "PDP.productInfoSection_text" is present on page
        Then I verify element "PDP.attributes_checkbox" is present on page
        Then I verify element "PDP.findSimilarProducts_button" is present on page
        And I verify Technical Docs section header contains "Technical Documents" in page "PDP.technicalDocument_text"
        And I verify technical documents count matches with the header
        And I verify text "Product Overview" in page "PDP.productOverview_text"
        And I verify element "PDP.productOverviewBody_text" is present on page and display "content" in report
        And I verify text "Legislation and Environmental" in page "PDP.legislationEnvironmental_text"
        And I verify Legislation And Environmental section table is not empty
        And I scroll till "Home.footer_section"
        And I verify text "Community" in page "PDP.community_text"
        And I take screenshot

    @pdpsections @nacn @nafr @eu @apac @nwk
    Scenario: Verify customer review, Customer Q&A Exchange and related categories sections for instock product
        Given I enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I scroll down the page by pixels "1000"
        Then I scroll till "PDP.customerReview_text"
        And I take screenshot
        And I verify text "Customer Reviews" in page "PDP.customerReview_text"
        And I verify text "Customer Q&A Exchange" in page "PDP.customerQAExchange_text"
        And I scroll till "Home.footer_section"
        And I wait for "10" seconds
        And I verify text "Related Categories" in page "PDP.relatedCategories_text"
        And I click "PDP.firstRelatedCategory_link"
        And I verify element "Search.productsHeader_text" is present on page
        And user navigates back in the browser
        And I click "PDP.firstRelatedCategory_image"
        And I verify element "Search.productsHeader_text" is present on page

    @pdpaltsection @validationTests @eu @apac @nwk @live
    Scenario: Verify alternatives section on PDP for instock product
        Given I enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        And I scroll till "Home.customerSerive_label"
        And I wait for "5" seconds
        And I scroll till "PDP.alternativesTable_list"
        Then I verify below are displayed in "PDP.alternativesTable_list" table on PDP
            | Manufacturer Part Number   |
            | Order Code                 |
            | Manufacturer / Description |
            | Availability               |
            | Quantity                   |
        Then I scroll till "PDP.manufacturerPartNo_link"
        And I take screenshot
        And I verify link "PDP.manufacturerPartNo_link" is present
        And I verify element "PDP.manufacturerPartNo_image" is present on page
        #"SuggestedAlternatives_link" is been removed in alterantive section from discovery squad
	      #And I verify link "PDP.suggestedAlternatives_link" is present
        And I verify link "PDP.ordercode_link" is present
        And I verify link "PDP.manuDescription_link" is present
        And I verify element "PDP.availabilityFirstProduct_text" is present on page
        And I click "PDP.firstAddInAltSection_button"
        And I verify element "Header.miniShopcartProductAdded_element" is present on page

    @pdpassociatedsection @validationTests @eu @apac @nwk @live
    Scenario: Verify associated products section on PDP for instock product
        Given I enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I scroll down the page by pixels "3000"
        And I wait for "2" seconds
        And I scroll till "PDP.associatedProductsTable_list"
        Then I verify below are displayed in "PDP.associatedProductsTable_list" table on PDP
            | Manufacturer Part Number   |
            | Order Code                 |
            | Manufacturer / Description |
            | Availability               |
            | Quantity                   |
        Then I scroll till "PDP.manufacturerPartNoAssociatedProd_link"
        And I take screenshot
        And I verify link "PDP.manufacturerPartNoAssociatedProd_link" is present
        And I verify element "PDP.manufacturerPartNoAssociatedProd_image" is present on page
        And I verify link "PDP.ordercodeAssociatedProd_link" is present
        And I verify link "PDP.manuDescriptionAssociatedProd_link" is present
        And I verify element "PDP.availabilityFirstProdAssociatedProd_text" is present on page
        And I click "PDP.firstAddInAssociatedProdSection_button"
        And I verify element "Header.miniShopcartProductAdded_element" is present on page

    @productvideo @eu @apac @nwk
    Scenario: Verify product video on PDP
        Given I enter "productvideo" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        And I verify element "PDP.productGallery_image" is present on page
        And I click on "PDP.productVideo_icon"
        And I take screenshot
        Then I verify element "PDP.productVideoContainer_element" is present on page

		# not applicable in EU since Sprint 63
    @avnetdropshipcontainerproduct @apac @nwk
    Scenario: Verify avnet container product
        Given I enter "avnetdropshipcontainerproduct" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        And I verify element "PDP.avnetPricingContainer_element" is present on page
        And I scroll till "PDP.avnetPricingContainer_element"
        And I take screenshot
        And I verify text "Additional Avnet Stock" in page "PDP.additionalAvnetStock_text"
        And I verify element "PDP.avnetlogo_icon" is present on page
        Then I verify below are displayed in "PDP.avnetTableHeader_list" table on PDP
            | Availability |
            | Price(For)   |
        Then I verify link "PDP.avnetView_link" is present
        Then I verify element "PDP.avnetTooltip_icon" is present on page
        Then I click "PDP.avnetTooltip_icon"
        Then I verify element "PDP.avnetTooltip_text" is present on page and display in report
        And I take screenshot

   # not applicable in EU since Sprint 63
    @avnetpopup @apac @nwk
    Scenario Outline: Verify avnet pop up products
        Given I enter "<productType>" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify element "PDPBuyBox.avnetSection_element" is present on page
        And I verify element "PDPBuyBox.viewPricingAvailability_link" is present on page and display in report
        And I take screenshot
        And I click "PDPBuyBox.viewPricingAvailability_link"
        Then I verify element "PDPBuyBox.avnetPopupTitle_text" is present on page and display in report
        Then I verify element "PDPBuyBox.avnnetManufTitle_text" is present on page and display in report
        Then I verify below are displayed in "PDPBuyBox.avnetPopupTableHeader_list" table on PDP
            | Avnet Part Number   |
            | Availability        |
            | Price               |
            | For                 |
            | Purchase from Avnet |
        Then I verify link "PDPBuyBox.viewAvnet_link" is present
        Then I verify below are displayed in "PDPBuyBox.avnetPopupFooter_list" table on PDP
            | Avnet Terms & Conditions apply |
            | *Opens in a new window         |
        And I take screenshot
        Examples:
            | productType         |
            | avnetpopupproduct   |

    @product360image @eu @apac @nwk
    Scenario: Verify product 360 Image on PDP
        Given I enter "productImage360" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify element "PDP.product360image_icon" is present on page
        And I click "PDP.product360image_icon"
        And I take screenshot
        And I  click "PDP.product360ImageContainer_element"
        And I wait for "5" seconds
        And I verify element "PDP.product360ImageContainerCanvas_element" is present on page
        And I take screenshot

    @generalpackaging @eu @apac
    Scenario: Verify general packaging product PDP
        Given I enter "generalpackagintypeproduct" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify element "PDPBuyBox.packagingType_text" is present on page
        Then I verify text "Cut Tape" in page "PDPBuyBox.packagingTypeValue_text"
        And I take screenshot

    @additionalpackaging @eu
    Scenario: Verify additional packaging product PDP in Europe
		Given I enter "packagingoptionsproduct" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
		When I click the "Header.searchIcon_button"
		Then I verify element "PDPBuyBox.packagingType_text" is present on page
		Then I verify text "Re-Reel" in page "PDPBuyBox.packagingTypeValue_text"
		And I click "PDPBuyBox.additionalPackagingOptionsAvailable_link"
		And I verify below are displayed in "PDPBuyBox.packagingOptions_list" table.*
			| Cut Tape  |
			| Full Reel |
		And I verify link "PDPBuyBox.firstCheckStock_link" is present on page
		And I click on "PDPBuyBox.firstCheckStock_link"
		And I verify link "PDPBuyBox.firstCheckStockAndLeadTimes_link" is present
		And I click on "PDPBuyBox.firstCheckStockAndLeadTimes_link"
		And I verify link "PDPBuyBox.firstSeeCutOffTimes_link" is present
		And I click on "PDPBuyBox.firstSeeCutOffTimes_link"
		And I verify link "PDPBuyBox.deliveryInformation_link" is present
		And I take screenshot
		And I verify element "PDPBuyBox.packCalculations_element" is present on page and display in report
		And I scroll till "PDPBuyBox.packTotalPrice_text"
		And I take screenshot
		And I verify element "PDPBuyBox.packTotalPrice_text" is present on page and display in report
		And I verify element "PDPBuyBox.packagingPrefsRadio_list" is present on page
		And I verify text "*Note: If you have selected a re-reeled item a £3.50 charge will be applied." in page "PDPBuyBox.rereelingEAP1_text"
		And I verify element "PDPBuyBox.rereelingEAP2_text" is present on page and display in report
		And I verify element "PDPBuyBox.rereelMessage_text" is present on page and display in report
    
    @negative @eu @apac @nwk
    Scenario: Verify absence of product video on PDP
        Given I enter "productnovideo" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I verify absence of element "PDP.productVideo_icon"

    @negative @eu @apac @nwk
    Scenario: Verify absence of alternative products section on PDP
        Given I enter "noalternativeproducts" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I scroll down the page by pixels "1000"
        Then I verify absence of element "PDP.alternativesTable_list"

    @negative @eu @apac @nwk
    Scenario: Verify absence of related categories section on PDP
        Given I enter "norelatedcategories" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
        When I click the "Header.searchIcon_button"
        Then I scroll down the page by pixels "1000"
        And I verify absence of element "PDP.relatedCategories_text"
