@validationTests
Feature: Shopping basket validation tests

  @SavedShoppingBasket @Priority2 @agileRegression @eu @apac @nwk @live
  Scenario: Load, Save and Delete Basket
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "register" user
		    Then I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		    When I click on Instock checkbox "Filters.instock_checkbox" using js
		    And I wait for "3" seconds
        And I take screenshot of the page
		    And I click on Show Result Button "Filters.showResult_button" refreshed element
		    And I wait for "10" seconds
		    Then I scroll down the page by pixels "100"
		    And I click on Add product button in PLP page "PLP.firstAdd_button"
		    And I scroll till "PLP.tableHeader_text"
		    And I wait for "12" seconds
		    And User clears text from textbox "PLP.quantity_text"
		    And I enter Quantity value "30" in textbox "PLP.quantity_text"
		    And I wait for "3" seconds
		    And I click on Add product button in PLP page "PLP.firstAdd_button"
		    And I wait for "3" seconds
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I wait for "4" seconds
		    And I save ordercode and quantity of firstorder in ShoppingCart
		    And I take screenshot of the page
		    And I scroll till "ShoppingCart.save/loadBasket_button"
		    #------Saving First Basket with items in cart------#
		    Then I click on save Basket "ShoppingCart.save/loadBasket_button"
		    And I enter Basket name value "Basket1" in textbox "ShoppingCart.basketName_text"
		    And I click Save "ShoppingCart.saveBasket_button"
		    And I take screenshot of the page
		    And I wait for "8" seconds
		    And I scroll till "ShoppingCart.savedBasketconfirmation_message"
		    And I verify contains "Successfully saved" in "ShoppingCart.savedBasketconfirmation_message"
		    And I take screenshot of the page
		    And Check if element "ShoppingCart.savedBasketconfirmation_message" is present on page and display in report
		    #------Downloading Basket------#
		    And I scroll till "ShoppingCart.downloadBasket_button"
		    And I click on "ShoppingCart.downloadBasket_button" using js
		    And I wait for "2" seconds
		    Then I click on Download button in "ShoppingCart.downloadinPopup_button" using js
		    And I wait for "2" seconds
		    And I select by visible text to download the Basket "HTML" from dropdown "ShoppingCart.fileType_dropdown"
		    Then I click on Download button in "ShoppingCart.downloadinPopup_button" using js
		    And I take screenshot of the page
		    #-----Deleting Items in Cart------#
		    And I click on "ShoppingCart.selectAll_link"
		    And I click on "ShoppingCart.deleteAll_link"
		    And I take screenshot of the page
		    #-----Verifying First Saved Basket and Updating to Cart----------#
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I wait for "2" seconds
		    And I click on Saved Basket "Header.savedBasket_button"
		    And I scroll till "SavedBasket.update_button"
		    Then I click on Add to Current Shopping cart checkbox in "SavedBasket.addtoShoppingCart_checkbox"
		    And I take screenshot of the page
		    And I click on Update Button in "SavedBasket.update_button"
		    And I wait for "5" seconds
		    And I scroll till "ShoppingCart.firstProductOnCart_text"
		    And I take screenshot of the page
		    And I verify orderCode and quantity of firstorder in ShoppingCart updated from Basket
		    #-----Updating Quantity and Saving Second Basket---------#
		    And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
		    And I enter Quantity value "30" in textbox "ShoppingCart.quantityFirstProduct_textbox"
		    And I scroll till "ShoppingCart.save/loadBasket_button"
		    Then I click on save Basket "ShoppingCart.save/loadBasket_button"
		    And I wait for "4" seconds
		    Then I enter Basket name value "Basket2" in textbox "ShoppingCart.basketName_text"
		    And I take screenshot of the page
		    And I click Save "ShoppingCart.saveBasket_button"
		    And I wait for "3" seconds
		    And I verify contains "Successfully saved" in "ShoppingCart.savedBasketconfirmation_message"
		    And I take screenshot of the page
		    And I wait for "3" seconds
		    #-----Verifying Second Saved Basket and Deleting Cart-----#
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I wait for "2" seconds
		    And I click on Saved Basket "Header.savedBasket_button"
		    Then I click on Delete Cart checkbox in "SavedBasket.deleteCart_checkbox"
		    And I take screenshot of the page
		    And I click on Update Button in "SavedBasket.update_button"
		    #-----Verifying ViewAllSavedBasket-----#
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I scroll till "ShoppingCart.save/loadBasket_button"
		    Then I click on save Basket "ShoppingCart.save/loadBasket_button"
		    And I click on "ShoppingCart.viewAllSavedBasket_button"
		    And I wait for "4" seconds
		    #-----Deleting All the Saved Baskets-----#
		    And I click on "SavedBasket.deleteAllSavedBasket_checkbox"
		    And I take screenshot of the page
		    And I click on Update Button in "SavedBasket.update_button"
		    #-----Updating Quantity in cart and verifying Update Basket----#
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I scroll till "ShoppingCart.quantityFirstProduct_textbox"
		    And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
		    And I enter Quantity value "30" in textbox "ShoppingCart.quantityFirstProduct_textbox"
		    And I wait for "5" seconds
		    And I scroll till "ShoppingCart.updateBasket_button"
		    And I take screenshot of the page
		    And I click "ShoppingCart.updateBasket_button"
		    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		    And I wait for "3" seconds
		    And I scroll till "ShoppingCart.selectAll_link"
		    And I click on SelectAll checkbox on Shopping cart Page "ShoppingCart.selectAll_link"
		    And I click on Delete Button on Shopping cart Page "ShoppingCart.deleteAll_link"
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then User click on logout option "Header.logout_button"

  @EmailAndLoadShoppingBasket @Priority2 @eu @apac @nwk @live
  Scenario: Email and Load Basket
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "register" user
		    Then I navigate to "c/crystals-oscillators/crystals" page
		    When I click on Instock checkbox "Filters.instock_checkbox"
		    And I click on Show Result Button "Filters.showResult_button" refreshed element
		    And I wait for "10" seconds
		    And User clears text from textbox "PLP.quantity_text"
		    And I enter Quantity value "30" in textbox "PLP.quantity_text"
		    And I click on Add product button in PLP page "PLP.firstAdd_button" using js
		    And I wait for "5" seconds
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I wait for "4" seconds
		    And I scroll till "ShoppingCart.save/loadBasket_button"
		    Then I click on save Basket "ShoppingCart.save/loadBasket_button"
		    And I enter Basket name value "Basket1" in textbox "ShoppingCart.basketName_text"
		    And I click Save "ShoppingCart.saveBasket_button"
		    And I take screenshot of the page
		    And I wait for "8" seconds
		    And I scroll till "ShoppingCart.savedBasketconfirmation_message"
		    And I verify contains "Successfully saved" in "ShoppingCart.savedBasketconfirmation_message"
		    And I take screenshot of the page
		    #-----Email Basket------#
		    And user verify element "ShoppingCart.emailBasket_button" is present on page
		    And I take screenshot of Shopping cart page
		    And I click on "ShoppingCart.emailBasket_button"
		    And I wait for "10" seconds
		    And I switch to "ShoppingCart.emailShopingCartFrame_frame" frame
		    And I enter email value "pfuser@pfmail.com" in textbox "ShoppingCart.email_text"
		    And I enter message value "Test Email Basket" in textbox "ShoppingCart.message_text"
		    And I take screenshot of Email Shopping Basket Page
		    And I click on Submit Button "ShoppingCart.sendEmail_button"
		    And I wait for "5" seconds
		    And I verify contains "Your email has been sent." in "ShoppingCart.emailSuccessMessage_element"
		    And I take screenshot of the page
		    And I switch to default frame
		    And I click on "ShoppingCart.closeEmailShoppingCartFrame_link" using js
		    #-----Load Basket-----#
		    And I save ordercode and quantity of firstorder in ShoppingCart
		    And I click on "ShoppingCart.selectAll_link"
		    And I click on "ShoppingCart.deleteAll_link"
		    And I take screenshot of the page
		    And I wait for "5" seconds
		    And I scroll till "ShoppingCart.save/loadBasket_button"
		    Then I click on save Basket "ShoppingCart.save/loadBasket_button"
		    And I click on "ShoppingCart.loadBasket_button"
		    And I wait for "5" seconds
		    And I verify orderCode and quantity of firstorder in ShoppingCart updated from Basket
		    And I take screenshot of the page
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then User click on logout option "Header.logout_button"
