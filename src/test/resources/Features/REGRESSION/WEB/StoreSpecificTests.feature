Feature: Miscellanous store centric tests


	@chinaOnly @Priority3 @payOnDelivery @agileRegression
	Scenario Outline: China Website Checkout Using "<paymentOption>"
		Given web site is launched successfully and user "does" accept the cookies
		#----User registers on the site----#
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		#----Find a product and add to basket----#
		When I click the "Header.searchIcon_button"
		And I wait for "3" seconds
		And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
		And I click "BrowseForProducts.secondCategory_link"
		And I scroll till "CategoryPage.showAllProducts_button"
		And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
		Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
		And I save the value of First Order code from PLP table
		#----Go to basket----#
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
		And I wait for "3" seconds
		When I enter the ordercode saved from PLP to update the basket to place order
		And I scroll till "ShoppingCart.updateBasket_button"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I wait for "3" seconds
		And I scroll till "Header.itemsInMiniBasket_text"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		#----Checkout----#
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		And I click on Continue button on Payment Methods section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		#---shipping method add special instructions & click go on
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I wait for "3" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		#----for payment details based on scenario----#
		And I verify scenario radio button element "<radioButtonName>" is present on page
		And I click on scenario radio button "<radioButtonName>"
		And I take screenshot of the page
		And I wait for "3" seconds
		And I scroll till "Checkout.invoiceTypeChina_radio"
		And I wait for "3" seconds
		And I take screenshot of the page
		And I click on freeTextInvoice radio button "Checkout.invoiceTypeChina_radio"
		And I enter value "<paymentOption>" in textbox "Checkout.freeTextInvoice_text"
		And I enter value "Englishname" in textbox "Checkout.invoiceEnglishName_text"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And I click on paymentDetailsSectionContinue button "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And I take screenshot of the page
		#----submit order----#
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		#----validate----#
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page
		Examples:
			| paymentOption    | radioButtonName                  |
			| Cash On Delivery | Checkout.cashOnDelivery_radio    |
			| Trade Account    | Checkout.tradeAccountChina_radio |
			| Bank Transfer    | Checkout.bankTransfer_radio      |
			| Card On Delivery | Checkout.cardOnDelivery_radio    |


	@chinaOnly @Priority3 @UnionPay @agileRegression
	Scenario Outline: China Website Checkout Using Unionpay
		Given web site is launched successfully and user "does" accept the cookies
		#----User registers on the site----#
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		#----Find a product and add to basket----#
		When I click the "Header.searchIcon_button"
		And I wait for "3" seconds
		And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
		And I click "BrowseForProducts.secondCategory_link"
		And I scroll till "CategoryPage.showAllProducts_button"
		And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
		Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
		And I save the value of First Order code from PLP table
		#----Go to basket----#
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
		And I wait for "3" seconds
		When I enter the ordercode saved from PLP to update the basket to place order
		And I scroll till "ShoppingCart.updateBasket_button"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I wait for "3" seconds
		And I scroll till "Header.itemsInMiniBasket_text"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		#----Checkout----#
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		And I click on Continue button on Payment Methods section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		#---shipping method add special instructions & click go on
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I wait for "3" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		#----for payment details select Unionpay ----#
		And I verify unionPay radio button element "Checkout.unionPay_radio" is present on page
		And I click on unionPay radio button "Checkout.unionPay_radio"
		And I take screenshot of the page
		And I wait for "3" seconds
		And I scroll till "Checkout.invoiceTypeChina_radio"
		And I wait for "3" seconds
		And I take screenshot of the page
		And I click on freeTextInvoice radio button "Checkout.invoiceTypeChina_radio"
		And I enter value "Unionpay Test" in textbox "Checkout.freeTextInvoice_text"
		And I enter value "Englishname" in textbox "Checkout.invoiceEnglishName_text"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And I click on paymentDetailsSectionContinue button "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And I take screenshot of the page
		#----submit order----#
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		#----unionpay new window----#
		And I wait "60" seconds for Unionpay new window
		And I switch to Unionpay window
		And I click on sendAnyway button "Checkout.sendAnyway_button"
		And I enter the "unionpay" card "cardnumber" in textbox "Checkout.creditCardNum_textbox" from json "creditCards.json"
		And I click on next button "Checkout.next_button"
		And I enter the "unionpay" card "expirymonth" in textbox "Checkout.expireMonth_textbox" from json "creditCards.json"
		And I enter the "unionpay" card "expiryyear" in textbox "Checkout.expireYear_textbox" from json "creditCards.json"
		And I enter the "unionpay" card "cv2" in textbox "Checkout.cvn2_textbox" from json "creditCards.json"
		And I click on get code button "Checkout.getSMSCode_button"
		And I wait for "120" seconds
		And I enter the "unionpay" card "smscode" in textbox "Checkout.smsCode_textbox" from json "creditCards.json"
		And I wait for "20" seconds
		And I click on agreement checkbox button "Checkout.agreement_checkbox"
		And I click on complete payment button "Checkout.completeUnionPay_button"
		Then I wait for "20" seconds
		And I verify element "Checkout.unionPaySuccess_element" is present on page
		And I click on return to merchant button "Checkout.returnToMerchant_button"
		Then I switch to parent window
		Then I wait for "60" seconds
		#----validate----#
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page

	@cpchomepageheader @cpcHomepage @gajanan
	Scenario: Verify header section in CPC homepage
		And I verify element "Header.companylogo_element" is present on page
		Then I verify element "Header.searchIcon_button" is present on page
		# Commented this part as All_list search bar has issue for automate
		#And I verify element "Header.all_list" is present on page
		#And I wait for "5" seconds
		#And I click on all button "Header.all_list" using js
		#And I wait for "5" seconds
		#And I click on "Header.category_dropdown" using js
		#And I click the "Header.searchIcon_button" using js
		#And I wait for "3" seconds
		#And I take screenshot
		#And I verify Results header element "Search.productsHeader_text" is present on page
		#And I take screenshot to verify the correct search page is loaded
		#And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Header.allProducts_link" is present on page
		And I click the "Header.allProducts_link"
		And I wait for "5" seconds
		And verify values in the "Home.lhsSuperCategories_list" table are not empty
		And I wait for "3" seconds
		And I verify element "Home.featuredAccess_link" is present on page
		And I hover on element "Home.featuredAccess_link"
		And I click on "Home.FirstFeaturedAccess_link" using js
		And I wait for "5" seconds
		And I verify element "Home.FirstFeaturedAccess_text" is present on page
		And I verify element "Home.cpcTools_link" is present on page
		And I hover on element "Home.cpcTools_link"
		Then I verify below are displayed in "Home.cpcTools_list" table
			| Quick Buy             |
			| Quick Paste           |
			| Part Finder           |
			| Request a Quote       |
			| Remote Control Finder |
		And I click the "Home.cpcQuickBuy_link"
		And I wait for "3" seconds
		And verify url parameter value as "quick-order"
		And user navigates back in the browser
		And I verify element "Home.cpcResource_link" is present on page
		And I hover on element "Home.cpcResource_link"
		And I wait for "5" seconds
		And verify values in the "Home.cpcResource_list" table are not empty
		And I verify element "Home.deliveryInfo_link" is present on page
		And I click the "Home.deliveryInfo_link"
		And I verify current url contains "help-delivery-information"
		And user navigates back in the browser
		And I verify element "Home.collectInStore_link" is present on page
		And I click the "Home.collectInStore_link"
		And I verify current url contains "click-collect"
		And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Header.myAccount_dropdown" is present on page
		And I hover on element "Header.myAccount_dropdown"
		Then I verify below are displayed in "Header.cpcMyAccount_list" table
			| Managing Your Account     |
			| Order History             |
			| Order Preferences         |
			| Apply for a Trade Account |
			| Profile Information       |
			| Addresses                 |
			| Quotes                    |
			| Saved Baskets             |
			| Change Password           |
			| Product Notifications     |
			| Marketing Preferences     |
		And I verify element "Header.cpcFlag_link" is present on page
		And I click on flag icon "Header.cpcFlag_link"
		And I wait for "3" seconds
		And I select by index "1" from dropdown "Header.country_dropdown"
		And I click on continue button "Header.continue_button"
		And I take screenshot
		And user navigates back in the browser
		And I verify element "ShoppingCart.shoppingCart_icon" is present on page
		And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
		And I click the "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And user navigates back in the browser
		And I wait for "5" seconds
		And I take screenshot

	@cpcpagecentre @cpcHomepage @gajanan  @cpcOnly
	Scenario: Verify center section in CPC home page
		And I scroll till "Home.cpcSubCategory_list"
		And I take screenshot
		And I wait for "3" seconds
		Then I verify below are displayed in "Home.cpcSubCategory_list" table
			| Audio Visual |
			| Cables       |
			| Computing    |
			| Maker        |
			| Electrical   |
			| Components   |
			| Leisure      |
			| Security     |
			| Test         |
			| Tools        |
		And I wait for "3" seconds
		And I click the "Home.cpcSubCategoryAudioVisual_link"
		And I verify current url contains "audio-visual" to check SubCategoryAudioVisual_link page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I scroll till "Home.cpcFreeUKDelivery_tab"
		And I verify element "Home.cpcFreeUKDelivery_tab" is present on page
		And I click the "Home.cpcFreeUKDelivery_tab"
		And I verify current url contains "help-delivery-information" to check delivery information page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "3" seconds
		And I verify element "Home.cpcCollectDelivery_tab" is present on page
		And I click the "Home.cpcCollectDelivery_tab"
		And I verify current url contains "click-collect" to check click and collect delivery page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I verify element "Home.cpcNeedSomehelp_tab" is present on page
		And I click the "Home.cpcNeedSomehelp_tab"
		And I verify current url contains "contact-us" to check need help contact us page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I scroll till "Home.trade_tab"
		And I take screenshot
		And I verify element "Home.trade_tab" is present on page
		And I verify element "Home.quote_tab" is present on page
		And I verify element "Home.delivery_tab" is present on page
		And I verify element "Home.contact_tab" is present on page
		And I verify element "Home.counter_tab" is present on page
		And I verify element "Home.catalogue_tab" is present on page
		And I verify element "Home.publication_tab" is present on page
		And I verify element "Home.emails_tab" is present on page
		And I verify element "Home.manufacturers_tab" is present on page

	@cpchomepagefooter @cpcHomepage @gajanan  @cpcOnly
	Scenario: Verify footer section in CPC home page
		Given user navigate to "cpc" store homepage and "does" accept the cookies
		And I scroll till "Home.visa_image"
		And I take screenshot
		Then I verify element "Home.visa_image" is present on page
		Then I verify element "Home.masterCard_image" is present on page
		Then I verify element "Home.americanExpress_image" is present on page
		Then I verify element "Home.tradeAccount_image" is present on page
		Then I verify element "Home.youtube_icon" is present on page
		Then I verify element "Home.facebook_icon" is present on page
		Then I verify element "Home.twitter_icon" is present on page
		Then I verify element "Home.linkedin_icon" is present on page
		Then I verify element "Home.cpcPrivacyStatement_link" is present on page
		And I click the "Home.cpcPrivacyStatement_link"
		And I verify current url contains "privacy-statement" to check Privacy Statement page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcTermsOfAccess_link" is present on page
		And I click the "Home.cpcTermsOfAccess_link"
		And I verify current url contains "terms-of-access" to check Terms Of Access page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcTermsOfPurchase_link" is present on page
		And I click the "Home.cpcTermsOfPurchase_link"
		And I verify current url contains "terms-of-purchase" to check Terms Of Purchase page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcCookieSettings_link" is present on page
		And I click the "Home.cpcCookieSettings_link"
		And I take screenshot
		And user navigates back in the browser

	@chinahomepageheader @chinaHomepage @gajanan @agileRegression @chinaOnly
	Scenario: Verify header section in China home page
		Given user navigate to "cn" store homepage and "does" accept the cookies
		And I refresh browser
		And I verify element "Header.companylogo_element" is present on page
		And I verify element "Header.offer_link" is present on page
		And I click on offertab "Header.offer_link"
		And verify url parameter value as "special-offers"
		And I verify current url contains "special-offers"
		And I take screenshot
		And I wait for "3" seconds
		And user navigates back in the browser
		And I verify element "Header.contactus_link" is present on page
		And I click on contactus "Header.contactus_link"
		And I wait for "3" seconds
		And I take screenshot
		And I verify current url contains "contact-us"
		And user navigates back in the browser
		And I verify element "Header.help_link" is present on page
		And I click on helptab "Header.help_link"
		And I verify current url contains "help"
		And I take screenshot
		And I wait for "3" seconds
		And user navigates back in the browser
		And I verify element "Header.trackOrders_link" is present on page
		And I click on trackordertab "Header.trackOrders_link"
		And I verify element "Header.trackorderheader_text" is present on page
		And I wait for "3" seconds
		And I take screenshot
		And user navigates back in the browser
		And I verify element "Header.flag_link" is present on page
		And I click on flag icon "Header.flag_link"
		And I wait for "3" seconds
		Then I verify element "Header.country_text" is present on page
		And I select by index "4" from dropdown "Header.country_dropdown"
		And I click on continue button "Header.continue_button"
		And I wait for "10" seconds
		And I take screenshot
		And user navigates back in the browser
		Then I verify element "Header.searchIcon_button" is present on page
		# Commented this part as All_list search bar has issue for automate
		#And I verify element "Header.all_list" is present on page
		#And I click on all button "Header.all_list"
		#And I click on "Header.category_dropdown"
		#And I click the "Header.searchIcon_button"
		#And I wait for "3" seconds
		#And I take screenshot
		#And I verify Results header element "Search.productsHeader_text" is present on page
		#And I take screenshot to verify the correct search page is loaded
		#And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Header.myAccount_dropdown" is present on page
		And I hover on element "Header.myAccount_dropdown"
		Then I verify below are displayed in "Header.myAccountHeaders_text" table
			| My Orders    |
			| Buying Tools |
			| My Profile   |
		And I take screenshot
		And I verify dropdown list items in "My Account" menu
		And I wait for "5" seconds
		And I verify element "ShoppingCart.shoppingCart_icon" is present on page
		And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
		And I click the "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And user navigates back in the browser
		And I wait for "5" seconds
		And I take screenshot
		And I verify element "Header.allProducts_link" is present on page
		And I wait for "3" seconds
		And I take screenshot
		And verify values in the "Home.lhsSuperCategories_list" table are not empty
		And I wait for "3" seconds
		And I verify element "Home.manufacturers_link" is present on page
		And I hover on element "Home.manufacturers_link"
		And verify text "Popular Manufacturers" in page "Home.popularmanufacturer_label"
		And I verify element "Home.resource_link" is present on page
		And I hover on element "Home.resource_link"
		And verify values in the "Home.resources_list" table are not empty
		And I verify element "Header.communities_link" is present on page
		And I hover on element "Header.communities_link"
		And I wait for "3" seconds
		And I verify element "Home.element14_image" is present on page
		And I verify element "Home.favorites_link" is present on page
		And I verify element "Header.tools_link" is present on page
		And I hover on element "Header.tools_link"
		And I wait for "5" seconds
		Then I verify below are displayed in "Header.tools_list" table
			| Quick Buy               |
			| Parts List (BOM) Upload |
			| Request a Quote         |
			| Browser Search Tools    |
			| All Buying Tools        |

	@chinahomepagefooter @chinaHomepage @gajanan @agileRegression @chinaOnly
	Scenario: Verify footer section in China home page
		Given user navigate to "cn" store homepage and "does" accept the cookies
		And I refresh browser
		And I scroll till "Home.weChat_image"
		And I take screenshot
		Then I verify element "Home.weChat_image" is present on page
		Then I verify element "Home.aliPay_image" is present on page
		Then I verify element "Home.cardOnDelivery_image" is present on page
		Then I verify element "Home.tradeAccount_image" is present on page
		Then I verify element "Home.cardbanktransfer_image" is present on page
		Then I verify element "Home.cardOnDelivery_image" is present on page
		Then I verify element "Home.privacy_link" is present on page
		And I click the "Home.privacy_link"
		And I verify current url contains "privacy-statement" to check Privacy Statement page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "8" seconds
		Then I verify element "Home.chinaLegalNotice_link" is present on page
		And I click the "Home.chinaLegalNotice_link" using js
		And I wait for "5" seconds
		And I verify current url contains "legal" to check legal notice page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "7" seconds
		Then I verify element "Home.chinaTermAndCondition_link" is present on page
		And I click the "Home.chinaTermAndCondition_link"
		And I verify current url contains "terms-and-conditions" to check Terms Of Purchase page get open
		And I take screenshot

  @chinapagecentre @agileRegression @chinaOnly
  Scenario: Verify center section in china home page
    Given user navigate to "cn" store homepage and "does" accept the cookies
    And I verify at right side section of page for login User name text box element "Login.username_textbox" is present on page
    And I verify at right side section of page for login password text box element "Login.password_textbox" is present on page
    And I verify at right side section of page login button element "Home.login_button" is present on page
    And I verify at right side section of page forgot username link element "Login.forgotUsername_link" is present on page
    And I verify at right side section of page forgot password link element "Login.forgotPassword_link" is present on page
    And I verify at right side section of page register user link element "Home.register_link" is present on page
    And verify values in the "Home.rightFixedMenuSectionlink_list" table are not empty
    And I verify element "Home.topSearches_tab" is present on page
    And verify values in the "Home.topTradingSearchTermstab_list" table are not empty
    And I click the "Home.firstTopTradingSearchTerms_link" using js
    And I verify element "PLP.PLP_element" is present on page
    And user navigates back in the browser
    And I click the "Home.topHotSearchProducts_tab" using js
    And verify values in the "Home.topHotSearchProducts_list" table are not empty
    And I click the "Home.secondTopHotSearchProducts_link" using js
    And I verify element "PDP.productTitle_text" is present on page and display in report
    And user navigates back in the browser
    And I scroll till "Home.specialOffersFirstSection_element"
    And I take screenshot
    And I verify element "Home.specialOffersFirstSection_element" is present on page
    And I verify element "Home.specialOffersFirstSectionSeeMore_link" is present on page
    And I click the "Home.specialOffersFirstSectionSeeMore_link" using js
    And I verify current url contains "special-offers" to check special offers page get open
    And I take screenshot
    And user navigates back in the browser
    And verify values in the "Home.specialOffersFirstSection_list" table are not empty
    And I take screenshot
    Then I click the "Home.firstSpecialOffer_link" using js
    And I verify element "PLP.PLP_element" is present on page
    And user navigates back in the browser
    And I scroll till "Home.weChat_image"
    And I wait for "5" seconds
    And I scroll till "Home.popularProductsSecondSection_element"
    And I take screenshot
    And I verify element "Home.popularProductsSecondSection_element" is present on page
    And verify values in the "Home.popularProductsSecondSection_list" table are not empty
    Then I click the "Home.secondpopularProduct_link" using js
    And I verify element "PLP.PLP_element" is present on page
    And user navigates back in the browser
    And I scroll till "Home.manufacturersThirdSection_list"
    And I verify element "Home.manufacturersThirdSection_element" is present on page
    And I verify "24" products are listed in products table "Home.manufacturersThirdSection_list"
    And I verify link "Home.manufacturersThirdSection_list" is present in manufacturersThirdSection
    And I click the "Home.firstManufacturer_link" using js
    And I verify current url contains "aim-tti-instruments" to check manufacturers page get open
    And user navigates back in the browser
    And I scroll till "Home.exclusiveBrandUnderstandMore_link"
    And I verify element "Home.exclusiveBrandForthSection_element" is present on page
    Then I click the "Home.exclusiveBrandUnderstandMore_link" using js
    #And I verify current url contains "exclusive-brands" to check manufacturers page get open
    And I take screenshot to verify user navigate to correct page
    And user navigates back in the browser
    And I wait for "10" seconds
    And I scroll till "Home.cableAndConnecterRightsectionHeading_element"
    And I wait for "8" seconds
    And I take screenshot
    And I verify count of elements present as "9" in page "Home.superCategoriesFifthSection_element"
    Then I verify below are displayed in "Home.superCategoriesLeftsideHeading_text" table
      | Connectors & Cable                        |
      | Semiconductors                            |
      | Passives                                  |
      | Development Boards and Evaluation Kits    |
      | Optoelectronics & LED Lighting Components |
      | electronics                               |
      | Power and Circuits                        |
      | Test and Measurement                      |
      | Tools & Production Supply                 |
    And I verify "54" products are listed in products table "Home.superCategoriesRightSection_list"
    And I verify cable and connecter superCategories right section heading element "Home.cableAndConnecterRightsectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.cableAndConnecterSuperCategorieSection_list"
    And I click the "Home.firstcableAndConnecterSection_link" using js
    And I verify current url contains "d-sub-connectors" to check first cableAndConnecterSection page get open
    And user navigates back in the browser
    And I verify Semiconductors superCategories right section heading element "Home.semiconductorsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.semiconductorsSection__list"
    And I click the "Home.firstSemiconductorsSection_link" using js
    And I verify current url contains "semiconductors-discretes" to check first semiconductorsSection page get open
    And user navigates back in the browser
    And I verify Passive superCategories right section heading element "Home.passivesSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.passivesSection__list"
    And I click the "Home.firstPassivesSection_link" using js
    And I verify current url contains "passive-components" to check first Passive Section page get open
    And user navigates back in the browser
    And I verify Development Boards and Evaluation Kits superCategories right section heading element "Home.devBoardsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.devBoardsSection__list"
    And I click the "Home.thirdDevBoardSection_link" using js
    And I verify current url contains "development-boards" to check first Development Boards and Evaluation Kits Section page get open
    And user navigates back in the browser
    And I verify Optoelectronics & LED Lighting Components right section heading element "Home.optoelectronicsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.optoelectronicsSection__list"
    And I click the "Home.firstOptoelectronicsSection_link" using js
    And I verify current url contains "optoelectronics-displays" to check first Optoelectronics & LED Lighting Components Section page get open
    And user navigates back in the browser
    And I verify Electronics right section heading element "Home.electronicsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.electronicsSection__list"
    And I click the "Home.firstElectronicsSection_link" using js
    And I verify current url contains "switches-relays" to check first Electronic Section page get open
    And user navigates back in the browser
    And I verify Power and Circuits right section heading element "Home.powerandCircuitsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.powerandCircuitsSection__list"
    And I click the "Home.firstPowerandCircuitsSection_link" using js
    And I verify current url contains "power-line" to check first Power and Circuits Section page get open
    And user navigates back in the browser
    And I verify Test & Measurement right section heading element "Home.test&MeasurementSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.test&MeasurementSection__list"
    And I click the "Home.firstTest&MeasurementSection_link" using js
    And I verify current url contains "test-measurement" to check first Test & Measurement Section page get open
    And user navigates back in the browser
    And I verify Tools & Production Supply right section heading element "Home.toolsSectionHeading_element" is present on page
    And I verify "6" products are listed in products table "Home.toolsSectionHeading__list"
    And I click the "Home.firstToolsSection_link" using js
    And I verify current url contains "chemicals-adhesives" to check first Tools & Production Supply Section page get open
    And user navigates back in the browser
    And I wait for "5" seconds
    And I scroll till "Home.featuredProductsSection_element"
    And I take screenshot
    And verify text "Featured Products" in page "Home.featuredProductsSection_element"
    And I verify element "Home.featuredProductsPrevButton_link" is present on page
    And I click the "Home.featuredProductsPrevButton_link" using js
    And I take screenshot to verify featured products previous button is working
    And I verify element "Home.featuredProductsNextButton_link" is present on page
    And I click the "Home.featuredProductsNextButton_link" using js
    And I take screenshot to verify featured products next button is working


    @PlaceAnOrderWithAccount @Priority1 @agileRegression @nacn @namx @eu @apac @nwk @ieonly
	  Scenario: Synced user place an order with account for IE store specifically
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "contract" user
		And Verify user is logged in on Home page successfully
		And I clear items from shopping cart if any present
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click Account Summary from the dropdown "Header.accountSummary_link"
		And I wait for "2" seconds
		And I scroll till "AccountSummary.backOfficeAccount_text"
		And I take screenshot to view the Account Summary page
		Then I verify element "AccountSummary.backOfficeAccount_text" is present on page and display 'Back Office Account number Synched' in report
		And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And I enter ordercode in textbox "ShoppingCart.firstOrderCode_textbox"
		And I verify text "1" in page "ShoppingCart.quantity_textbox" with attribute "value"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And User click on Continue button on Payment Method "Checkout.paymentdetailContinue_button"		
		Then I verify edit button element "Checkout.editPaymentMethod_button" is present on page
		And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
		And I wait for "2" seconds
		And User take screenshot of the page
		And I wait for "8" seconds
		And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And User click on Continue button on Invoice & Delivery Address "Checkout.addressSectionContinue_button"	
    Then I verify edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    #And User click on Confirm Address button on Delivery Section "Checkout.confirmAddress_button"			
		And I wait for "2" seconds		
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"		
		And I wait for "8" seconds
		Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
		And I verify element "Checkout.paymentDetails_text" is present on page and display its value in report
    And User click on Continue button on Payment Details "Checkout.paymentDetailsSectionContinue_button"		
		And I wait for "3" seconds
		And I enter PO number value "syncedTradeAccountOrder" in textbox "Checkout.poNumber_textbox"
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "3" seconds
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And I take screenshot of the page
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click on "Header.logout_button"
