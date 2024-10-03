#Author: pshinde@premierfarnell.com

@Rereel
Feature: Verify Re-reel on Newark sites - Web

  @RereelOnPLP @nwk
  Scenario: Verify that Re-reel option is displayed on PLP.
    Given web site is launched successfully and user "does" accept the cookies
    And I navigate to "w/c/passive-components/filters" page
    And I wait for "4" seconds
    Then I verify element "PLP.cutTape_radio" is present on page
    And I verify element "PLP.reReel_radio" is present on page
    And I verify element "PLP.cutTape_radio" is enabled
    And I take screenshot of Product Lister page
    And I extract number value from text "PLP.cutTape_text" element on page
    Then I enter extracted number in "PLP.secondQuantity_text" text box
    And I wait for "3" seconds
    Then I verify element "PLP.reReel_radio" is disabled
    And I take screenshot to verify Re-reel radio button is disabled
    And I extract number value from text "PLP.reReel_text" element on page
    Then I enter extracted number in "PLP.secondQuantity_text" text box
    And I wait for "3" seconds
    Then I verify element "PLP.reReel_radio" is enabled
    And I take screenshot to verify Re-reel radio button is enabled
    And I scroll till "PLP.firstAdd_button"
    And I wait for "3" seconds
    Then I click "PLP.reReel_radio"
    And I click "PLP.secondAdd_button"
    And I wait for "3" seconds
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    Then I click "ShoppingCart.shoppingCart_icon"
    And I wait for "3" seconds
    Then I verify element "ShoppingCart.packTypeRereel_icon" is present on page
    And I take screenshot to verify Re-reel icon is displayed
    Then I navigates back in the browser
    And I wait for "3" seconds
    Then I click "PLP.fullReelAvailable_link"
    And I verify element "PDP.productTitle_text" is present on page
    Then I click "ShoppingCart.shoppingCart_icon"
    Then I click "ShoppingCart.selectAll_link"
    And I click "ShoppingCart.deleteSelected_link"
    And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
    Then I navigate to "w/c/passive-components/filters" page
    And I extract number value from text "PLP.cutTape_text" element on page
    Then I enter extracted number in "PLP.secondQuantity_text" text box
    And I scroll till "PLP.firstAdd_button"
    And I click "PLP.secondAdd_button"
    And I wait for "3" seconds
    Then I click "ShoppingCart.shoppingCart_icon"
    And I verify text is equal to "ShoppingCart.quantityFirstProduct_textbox"
    Then I navigates back in the browser
    And I wait for "3" seconds
    And I extract number value from text "PLP.reReel_text" element on page
    Then I enter extracted number in "PLP.secondQuantity_text" text box
    And I scroll till "PLP.firstAdd_button"
    And I wait for "3" seconds
    Then I verify element "PLP.reReel_radio" is enabled
    And I take screenshot to verify Re-reel radio button is enabled
    Then I click "PLP.reReel_radio"
    And I click "PLP.secondAdd_button"
    And I wait for "3" seconds
    Then I click "ShoppingCart.shoppingCart_icon"
    And I verify text is equal to "ShoppingCart.quantityFirstProduct_textbox"

  @RereelOnPDP @nwk
  Scenario: Verify that Re-reel option is displayed on PDP.
  	Given web site is launched successfully and user "does" accept the cookies
  	When I enter "rereel" from json "26037_TestData.json" in searchbox
  	And I click "Header.searchIcon_button"
  	Then I verify element "PDP.productTitle_text" is present on page
  	And I scroll till "PDP.imageCaption_text"
  	And I wait for "3" seconds
  	And I verify element "PDP.cutTape_radio" is present on page
  	And I verify element "PDP.reReel_radio" is present on page
  	And I verify element "PDP.cutTape_radio" is enabled
  	And I scroll till "PDP.imageCaption_text"
  	And I take screenshot to verify Product Details page
  	And I wait for "3" seconds
  	Then I extract number value from text "PDP.minOrderQty_text" element on page
  	And I enter extracted number in "PDP.quantity_textbox" text box
  	And I click "PDP.addToCart_button"
  	Then I wait for "3" seconds
  	And I click "ShoppingCart.shoppingCart_icon"
    And I wait for "3" seconds
    Then I verify element "ShoppingCart.packTypeCutTape_icon" is present on page
    And I verify element "ShoppingCart.pkgOptAvail_link" is present on page
    And I verify text is equal to "ShoppingCart.quantityFirstProduct_textbox"
    And I take screenshot to verify Cut Tape icon is displayed
    Then I navigates back in the browser
    And I wait for "3" seconds
    And I scroll till "PDP.imageCaption_text"
  	And I wait for "3" seconds
  	Then I extract number value from text "PDP.reReel_text" element on page
  	Then I enter extracted number in "PDP.quantity_textbox" text box
  	And I wait for "3" seconds
  	And I verify element "PDP.reReel_radio" is enabled
  	Then I click "PDP.reReel_radio"
  	Then I click "PDP.addToCart_button"
  	And I wait for "3" seconds
  	Then I click "ShoppingCart.shoppingCart_icon"
    And I wait for "3" seconds
    Then I verify element "ShoppingCart.packTypeRereel_icon" is present on page
    And I take screenshot to verify Re-reel icon is displayed
    And I verify text is equal to "ShoppingCart.quantityFirstProduct_textbox"
    Then I click "ShoppingCart.pkgOptAvail_link"
    Then I verify element "PDP.productTitle_text" is present on page
    And I take screenshot to verify Product Details Page is displayed

  @RereelOnBOM @nwk
  Scenario: Verify that Re-reel option is displayed on BOM.
  	Given web site is launched successfully and user "does" accept the cookies
  	When customer accesses the website as "register" user
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "26037_BOM_TestData.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
  	Then I verify element "BOMUploadPage.firstPkgType_dropdown" is present on page
  	And I scroll till "BOMUploadPage.addToBasket_button"
  	And I wait for "2" seconds
  	And I verify text "Cut Tape" in page "BOMUploadPage.firstPkgType_dropdown"
  	Then I take screenshot to verify default Packaging Type is Cut Tape.
  	Then I click "BOMUploadPage.firstPkgType_dropdown"
  	And I wait for "2" seconds
  	And I verify element "BOMUploadPage.reReelPkgType_element" is present on page
  	Then I take screenshot to verify Re-reel packaging type is enabled
  	Then I extract number value from text "BOMUploadPage.minRereelPkgQty_text" element on page
  	And I enter extracted number in "BOMUploadPage.firstQty_textbox" text box
 		Then I click "BOMUploadPage.firstPkgType_dropdown"
  	And I wait for "2" seconds
  	And I verify "BOMUploadPage.reReelPkgType_element" is enabled in BOM page
  	Then I take screenshot to verify Re-reel packaging type is enabled
  	Then I click "BOMUploadPage.selectFirstRereel_text"
  	And I click "BOMUploadPage.allSelect_checkbox" checkbox
  	Then I click "BOMUploadPage.addToBasket_button"
  	And I wait for "2" seconds
  	Then I verify element "ShoppingCart.packTypeRereel_icon" is present on page
  	And I take screenshot to verify Re-reel icon is displayed
  	Then I click "ShoppingCart.selectAll_link"
    And I click "ShoppingCart.deleteSelected_link"
    And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
  	Then I navigates back in the browser
  	And I wait for "3" seconds
  	Then I click "BOMUploadPage.firstPkgType_dropdown"
  	Then I extract number value from text "BOMUploadPage.minCutTapePkgQty_text" element on page
  	And I enter extracted number in "BOMUploadPage.firstQty_textbox" text box
  	Then I verify border color of "textbox" as "Red,#d84442,BOMUploadPage.firstQty_textbox"
  	Then I take screenshot to verify the text box is highlighted
  	And I click "BOMUploadPage.allSelect_checkbox" checkbox
  	Then I click "BOMUploadPage.addToBasket_button"
  	And I wait for "2" seconds
  	Then I verify element "ShoppingCart.minOrderQtyError_text" is present on page
  	And I take screenshot to verify the error message

  @RereelBackOrderedMsg @nwk
  Scenario: Verify back ordered message for Re-reel on Shopping Cart.
  	Given web site is launched successfully and user "does" accept the cookies
  	When I enter "rereel" from json "26037_TestData.json" in searchbox
  	And I click "Header.searchIcon_button"
  	Then I verify element "PDP.productTitle_text" is present on page
  	Then I scroll till "PDP.imageCaption_text"
		And I wait for "3" seconds
  	And I take screenshot to verify PDP is displayed
  	Then I enter value "39000" in textbox "PDP.quantity_textbox"
  	And I wait for "2" seconds
  	Then I click "PDP.reReel_radio"
  	Then I click "PDP.addToCart_button"
  	And I wait for "3" seconds
  	Then I click "ShoppingCart.shoppingCart_icon"
    And I wait for "3" seconds
    Then I verify element "ShoppingCart.packTypeRereel_icon" is present on page
    And I verify element "ShoppingCart.backOrdered_text" is present on page
    Then I take screenshot to verify back ordered message is displayed

  @RereelPackOptionAvailLink @nwk
  Scenario: Display Packaging Option Available link on Shopping cart.
  	Given web site is launched successfully and user "does" accept the cookies
  	When I enter "rereel" from json "26037_TestData.json" in searchbox
  	And I click "Header.searchIcon_button"
  	Then I verify element "PDP.productTitle_text" is present on page
  	Then I scroll till "PDP.imageCaption_text"
		And I wait for "2" seconds
  	And I take screenshot to verify PDP is displayed
  	Then I enter value "39000" in textbox "PDP.quantity_textbox"
  	And I wait for "2" seconds
  	Then I click "PDP.reReel_radio"
  	Then I click "PDP.addToCart_button"
  	And I wait for "3" seconds
  	Then I click "ShoppingCart.shoppingCart_icon"
    And I wait for "3" seconds
  	Then I verify element "ShoppingCart.pkgOptAvail_link" is present on page
   	Then I click "ShoppingCart.pkgOptAvail_link"
    Then I verify element "PDP.productTitle_text" is present on page
    And I take screenshot to verify Product Details Page is displayed
