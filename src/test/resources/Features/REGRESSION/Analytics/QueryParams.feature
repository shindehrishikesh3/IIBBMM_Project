@analyticstests @analyticsValidation
Feature: Analytics /ss query param Tests

    @regression  @enablePerfLogs @eu @apac @nwk @homepagepdp @live
    Scenario: Verify query parameters homepage & PDP
        Given web site is launched successfully and user "does" accept the cookies
        And I wait for "10" seconds
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "Homepage-pageLoad-1"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged Out         |
            | pageName | Homepage:Home Page |
        Given I enter "instock" ordercode from json "orderCodes.json" in searchbox
        And I click "Header.searchIcon_button"
        And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
        And I take screenshot
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "PDP-pageLoad"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged Out                  |
            | pageName | Product Detail:Product View |
            | events   | ProdView,event16,event259   |
            | c6       | Header Search    					 |
            | c7       | 1                           |
            | c14      | In stock                    |
            | v33      | In stock                    |
        Then below query string parameter key exists and its value matches regex
            | v158 | [a-zA-Z0-9-]+ |
        When I click on "Header.companylogo_element"
        And I wait for "10" seconds
        And I take screenshot
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "Homepage-pageLoad-2"
        Then below query string parameter key exists and its value is a exact match
            | v3     | Logged Out |
            | events | event260,event117   |
        Then below query string parameter key exists and its value starts with text
            | products | ; |
        Then below query string parameter key exists and its value matches regex
            | v158 | [a-zA-Z0-9-]+ |
        Then query string parameter key "products" value contains keyword "eVar128" with "1" occurances
        Given I enter "instock2" ordercode from json "orderCodes.json" in searchbox
        And I click the "Header.searchIcon_button"
        And I wait for "10" seconds
        And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
        And I take screenshot
        When I click on "Header.companylogo_element"
        And I wait for "10" seconds
        And I take screenshot
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "Homepage-pageLoad-3"
        Then below query string parameter key exists and its value is a exact match
            | v3     | Logged Out |
            | events | event260,event117   |
        Then below query string parameter key exists and its value starts with text
            | products | ; |
        Then below query string parameter key exists and its value matches regex
            | v158 | [a-zA-Z0-9-]+ |
        Then query string parameter key "products" value contains keyword "eVar128" with "2" occurances

    @regression @enablePerfLogs @eu @apac @nwk @regshoppingcart @live
    Scenario: Verify query parameters Shopping basket page
        Given web site is launched successfully and user "does" accept the cookies
        And I enter "instock" ordercode from json "orderCodes.json" in searchbox
        And I click the "Header.searchIcon_button"
        And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
        And I take screenshot
        When I click on "PDPBuyBox.addToCart_button" using js
        And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
        And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
        And I wait for "10" seconds
        And I take screenshot
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "cart-addition"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged Out                  |
            | pageName | Product Detail:Product View |
            | events   | scAdd,event259              |
            | c14      | In stock                    |
        Then below query string parameter key exists and its value starts with text
            | products | ;{orderCode} |
        Then query string parameters key1 "c13" and key2 "v19" have exact same values
        Then below query string parameter key exists and its value matches regex
            | v158 | [a-zA-Z0-9-]+ |
        And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
        And I wait for "3" seconds
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        And I wait for "10" seconds
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "cart-page-load"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged Out                  |
            | events   | scView,event151,event152=1,event259 |
            | pageName | Shopping Cart:Shopping Cart |
            | v133     | 1                           |
        Then below query string parameter key exists and its value matches regex
            | v158 | [a-zA-Z0-9-]+ |
        Then below query string parameter key exists and its value starts with text
            | products | ;{orderCode} |

    @regression @enablePerfLogs @checkoutanalytics
    Scenario Outline: Verify query parameters checkout pages
        Given web site is launched successfully and user "does" accept the cookies
        And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
        And I wait for "3" seconds
        And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
        And I enter "instock" ordercode in quick add part number textbox
        And I scroll till "ShoppingCart.updateBasket_button"
        And I click "ShoppingCart.updateBasket_button"
        And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
        And I wait for "3" seconds
        And I scroll till "Header.itemsInMiniBasket_text"
        And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
        When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
        And I wait for "4" seconds
        And login as "regular" user
        And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
        And I wait for "10" seconds
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "order-info-page-load"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged In                  |
            | pageName | Checkout:Order Information |
            | products | ;{orderCode}               |
            | c1       | Standard                   |
            | c2       | <c2_value>                 |
            | v2       | <v2_value>                 |
            | v1       | Standard                   |
            | v21      | Standard                   |
        Then below query string parameter key exists and its value matches regex
            | events | scCheckout, event17=[0-9.]+,event259, event2                                                                                      |
            | v42    | \{wid:[0-9]+,time:[0-9-T:]+,mktg:0\\\|0\\\|0\\\|0,iBuy:0,orderValue:[0-9.,]+,order:[0-9]+,locale:(en_UK\|en_US\|en_SG)\} |
            | v43    | \{skus:[a-zA-Z0-9-]+,qtys:[0-9.]+,lineValues:.[0-9.]+\}                                                                  |
            | v158   | [a-zA-Z0-9-]+                                                                                                            |
        And click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
        And would like to open a new Trade Account
        And click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
        And I wait for "5" seconds
        And refresh browser
        And click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
        And I wait for "8" seconds
        Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
        #And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
        And I wait for "3" seconds
        And I scroll till "Checkout.deliverySectionContinue_button"
        And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
        And I wait for "8" seconds
        And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
        Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
        And I select trade account radio button and click continue button in section 4 payment method
        Then I verify element "Checkout.editPaymentDetails_button" is present except in "ph" region/store
        And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
        And I wait for "3" seconds
        And User take screenshot of the page
        And I enter PO number value "TradeAcc" in textbox "Checkout.poNumber_textbox"
        And User take screenshot of the page
        And I wait for "10" seconds
        And User checks terms and conditions checkbox and click on Submit Order button
        And user take screenshot of the page
        And I verify order confirmation message is present on page and display 'Thank you for your order' in report
        And take screenshot of the page
        And I wait for "10" seconds
        And get performance logs
        Then verify "/ss" call exists
        Then get all query string parameters for "order-confirmation-page-load"
        Then below query string parameter key exists and its value is a exact match
            | v3       | Logged In                   |
            | pageName | Checkout:Order Confirmation |
            | c1       | Standard                    |
            | c2       | <c2_value>                  |
            | v2       | <v2_value>                  |
            | v1       | Standard                    |
            | v21      | Standard                    |
            | v54      | <v54_value>                 |
            | v25      | <v25_value>                 |
            | v24      | PFTradeAccount              |
        Then below query string parameter key exists and its value starts with text
            | products | ;{orderCode} |
        Then below query string parameter key exists and its value contains text
            | products | eVar141 |
        Then below query string parameter key exists and its value matches regex
            | events     | purchase, event18=0.00, event19=[0-9.,]+, event20=, event21=[0-9.,]*, event31=[0-9.,]+, event32=[0-9.,]+,event259 |
            | purchaseID | [0-9]+                                                                                                   |
            | v4         | [0-9]+                                                                                                   |
            | v5         | [A-Z_]+                                                                                                  |
            | v158       | [a-zA-Z0-9-]+                                                                                            |
            | v22        | [0-9]+                                                                                                   |
        @eu
        Examples:
            | c2_value | v2_value | v54_value | v25_value                |
            | en_UK    | en_UK    | GBP       | Same day dispatch (free) |
        @apac
        Examples:
            | c2_value | v2_value | v54_value | v25_value         |
            | en_SG    | en_SG    | SGD       | Standard Delivery |
        @nwk
        Examples:
            | c2_value | v2_value | v54_value | v25_value                                                         |
            | en_US    | en_US    | USD       | Newark Flat Rate (Over $150 USD Ships Free) (Order by 9:00 PM EST) |

