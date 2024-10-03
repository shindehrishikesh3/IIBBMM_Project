@punchout @punchoutreg @api @ui
Feature: Punchout Regression tests

    @editBaskeCxml
    Scenario Outline:  <userType> User edits basket - cxml
        Given "<store>" environment is setup
        When post "punchoutLogin" request for "cxml" protocol with body "<punchoutloginBody>"
        Then status code "200"
        And response body contains status code "200" and text "OK"
        And response body contains cxml login url
        When I open response url in browser in iframe
        And click "Punchout.launch_link"
        And I wait for "5" seconds
        And switch to "iframe_a" iframe
        And take screenshot
        Then accept all cookies if asked
        # And skip feedback form if any
        And take screenshot
        And verify element "PunchoutHeader.companylogo_element" is present on page
        And register external user only if "<userType>" newly registered
        And verify user "PunchoutHeader.userFirstName_text" is logged in
        And take screenshot
        #----empty shopping cart-----
        And clear items from shopping cart if any present
        #------navigate to PLP through blank search & add product---
        And I wait for "15" seconds
        When I click the "Header.searchIcon_button"
        And I verify element "<categoryLink>" is present on page and display name of Category in report
        And I click "<categoryLink>"
        And I scroll till "CategoryPage.showAllProducts_button"
        And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
        Then verify in L0 Category Page element "CategoryPage.section_category" is present on page
        And I save the value of First Order code from PLP table
        And I scroll till "PLP.firstAdd_button"
        And I wait for "15" seconds
        And I click on Add button on PLP "PLP.secondAdd_button" using js
        And take screenshot
        And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
        And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
        And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
        And I wait "medium" duration for "ShoppingCart.product_image" element to "appear"
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
        #------Submit shopping cart page---
        And I wait "medium" duration for "Punchout_SubmitShoppingCart.top_SendBasket_button" element to "appear"
        And I verify element "Punchout_SubmitShoppingCart.top_SendBasket_button" is present on page
        And I verify text "Your basket will be returned to your purchasing system." in page "Punchout_SubmitShoppingCart.poLink_text"
        And verify order details table headers
        And verify "1" product rows in order details table
        #------Edit shopping cart page---
        And click Edit Basket "Punchout_SubmitShoppingCart.editBasket_button"
        And I wait "medium" duration for "ShoppingCart.product_image" element to "appear"
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        When I enter the ordercode saved from PLP to update the basket to place order
        And I wait for "5" seconds
        And I scroll till "ShoppingCart.updateBasket_button"
        And I click "ShoppingCart.updateBasket_button"
        And I wait "medium" duration for "ShoppingCart.loader_element" element to "disappear"
        And I wait for "15" seconds
        And I scroll till "Header.itemsInMiniBasket_text"
        And I verify mini shopping cart contains "2" items in "Header.itemsInMiniBasket_text"
        When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
        And I wait "medium" duration for "Punchout_SubmitShoppingCart.top_SendBasket_button" element to "appear"
        And I wait for "10" seconds
        And verify "2" product rows in order details table
        #And click on Send Basket "Punchout_SubmitShoppingCart.bottom_SendBasket_button"
        And take screenshot

        @ft @eu
        Examples:
            | store | userType         | punchoutloginBody                  | categoryLink                          |
            | uk    | Anonymous        | punchoutloginBody.xml              | BrowseForProducts.secondCategory_link |
            | uk    | Existing         | PunchoutLoginBody_NonAnonymous.xml | BrowseForProducts.secondCategory_link |
            | uk    | Newly registered | PunchoutLoginBody_RegisterUser.xml | BrowseForProducts.secondCategory_link |


        @ft @apac
        Examples:
            | store | userType         | punchoutloginBody                  | categoryLink                          |
            | sg    | Anonymous        | punchoutloginBody.xml              | BrowseForProducts.secondCategory_link |
            | sg    | Existing         | PunchoutLoginBody_NonAnonymous.xml | BrowseForProducts.secondCategory_link |
            | sg    | Newly registered | PunchoutLoginBody_RegisterUser.xml | BrowseForProducts.secondCategory_link |

        @ft @nwk
        Examples:
            | store | userType         | punchoutloginBody                  | categoryLink                         |
            | us    | Anonymous        | punchoutloginBody.xml              | BrowseForProducts.firstCategory_link |
            | us    | Existing         | PunchoutLoginBody_NonAnonymous.xml | BrowseForProducts.firstCategory_link |
            | us    | Newly registered | PunchoutLoginBody_RegisterUser.xml | BrowseForProducts.firstCategory_link |


    @editBaskeOCI
    Scenario Outline:  <userType> User edits basket - OCI
        Given "<store>" environment is setup
        When get punchoutSAPLogin url for "<companyType>" company with oci protocol
        When I open response url in browser in iframe
        And click "Punchout.launch_link"
        And I wait for "10" seconds
        And switch to "iframe_a" iframe
        And take screenshot
        Then accept all cookies if asked
        # And skip feedback form if any
        And take screenshot
        And verify element "PunchoutHeader.companylogo_element" is present on page
        And register external user only if "<userType>" newly registered
        And verify user "PunchoutHeader.userFirstName_text" is logged in
        And take screenshot
        #----empty shopping cart-----
        And clear items from shopping cart if any present
        #------navigate to PLP through keyword search & add product---
        And I enter value "bav99" in textbox "Header.searchBox_textbox"
        When I click the "Header.searchIcon_button"
        Then verify lister page header element "PLP.header_text" is present on page
        And I save the value of First Order code from PLP table
        And I scroll till "PLP.firstAdd_button"
        And I wait for "15" seconds
        And I click on Add button on PLP "PLP.secondAdd_button" using js
        And take screenshot
        And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
        And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
        And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
        And I wait "medium" duration for "ShoppingCart.product_image" element to "appear"
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
        #------Submit shopping cart page---
        And I wait "medium" duration for "Punchout_SubmitShoppingCart.top_SendBasket_button" element to "appear"
        And I verify element "Punchout_SubmitShoppingCart.top_SendBasket_button" is present on page
        And I verify text "Your basket will be returned to your purchasing system." in page "Punchout_SubmitShoppingCart.poLink_text"
        And verify order details table headers
        And verify "1" product rows in order details table
        #------Edit shopping cart page---
        And click Edit Basket "Punchout_SubmitShoppingCart.editBasket_button"
        And I wait "medium" duration for "ShoppingCart.product_image" element to "appear"
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        When I enter the ordercode saved from PLP to update the basket to place order
        And I wait for "5" seconds
        And I scroll till "ShoppingCart.updateBasket_button"
        And I click "ShoppingCart.updateBasket_button"
        And I wait "medium" duration for "ShoppingCart.loader_element" element to "disappear"
        And I wait for "15" seconds
        And I scroll till "Header.itemsInMiniBasket_text"
        And I verify mini shopping cart contains "2" items in "Header.itemsInMiniBasket_text"
        When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
        And I wait "medium" duration for "Punchout_SubmitShoppingCart.top_SendBasket_button" element to "appear"
        And I wait for "10" seconds
        And verify "2" product rows in order details table
        #And click on Send Basket "Punchout_SubmitShoppingCart.bottom_SendBasket_button"
        And take screenshot
        And I wait for "2" seconds
        @ft @eu
        Examples:
            | store | userType         | searchterm | companyType     |
            | uk    | Anonymous        | diode      | anonymous       |
            | uk    | Existing User    | diode      | existingUser    |
            | uk    | Newly Registered | diode      | newlyRegistered |


        @ft @apac
        Examples:
            | store | userType         | searchterm | companyType     |
            | sg    | Anonymous        | diode      | anonymous       |
            | sg    | Existing User    | diode      | existingUser    |
            | sg    | Newly Registered | diode      | newlyRegistered |

        @ft @nwk
        Examples:
            | store | userType         | searchterm | companyType     |
            | us    | Anonymous        | diode      | anonymous       |
            | us    | Existing User    | diode      | existingUser    |
            | us    | Newly Registered | diode      | newlyRegistered |
