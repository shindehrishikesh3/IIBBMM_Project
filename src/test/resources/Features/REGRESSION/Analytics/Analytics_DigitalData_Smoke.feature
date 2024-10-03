@analyticstests
Feature: Analytics digitaldata Smoke Tests

  Background: 
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @digitaldata @analyticssmoke @homepagedigidata @live @guest
  Scenario Outline: Validation of digitaldata parameters for homepage
    When I navigate to "?icid=12348u398uh" page
    And I Execute digitaldata command for "homepage-pageload-1"
    Then verify below key values are exact match in "page" node
      | cname                | <cname_value>           |
      | pageNode             | Homepage:Home Page      |
      | repositoryPath       | Home                    |
      | section              | Homepage                |
      | internalCampaignCode | 12348u398uh             |
      | store                | <store_value>           |
      | locale.country       | <locale.country_value>  |
      | locale.currency      | <locale.currency_value> |
      | locale.language      | <locale.language_value> |
      | pageName             | {getPageTitle}          |
    Then verify below key values are exact match in "user" node
      | deviceType | desktop |
      | isLoggedIn | no      |
    When I click on "Header.companylogo_element"
    And I wait for "10" seconds
    When I navigate to "?cmp=93egdwjkfw" page
    And I Execute digitaldata command for "homepage-pageload-2"
    Then verify below key values are exact match in "page" node
      | externalCampaignCode | 93egdwjkfw |

    @eu
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value        |
      | FARNELL     | GB                   | GBP                   | en                    | target.farnell.com |

    @nwk
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value       |
      | NEWARK      | US                   | USD                   | en                    | target.newark.com |

    @apac
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value          |
      | ELEMENT14   | SG                   | SGD                   | en                    | target.element14.com |

  @digitaldata @analyticssmoke @pdpdigidata @live
  Scenario Outline: Validation of digitaldata parameters for pdp page
    Given I enter "instock" ordercode from json "orderCodes.json" in searchbox
    And I click "Header.searchIcon_button"
    And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
    And I take screenshot
    And I Execute digitaldata command for "PDP-pageload"
    And I wait for "20" seconds
    Then verify below key values are exact match in "page" node
      | cname           | <cname_value>               |
      | pageNode        | Product Detail:Product View |
      | section         | Product Detail              |
      | store           | <store_value>               |
      | locale.country  | <locale.country_value>      |
      | locale.currency | <locale.currency_value>     |
      | locale.language | <locale.language_value>     |
      | pageName        | {getPageTitle}              |
    Then verify below key values are exact match in "user" node
      | deviceType | desktop |
      | isLoggedIn | no      |
    And I wait for "10" seconds
    Then verify below key values are exact match in "page" node
      | pageNode  | Product Detail:Product View |
      | section   | Product Detail              |
      | pageLevel |                           5 |
    And verify below key string values are not empty for "product" node
      | productDetail.0.isNCNR                      |
      | productDetail[0].orderCode                  |
      | product.productDetail[0].manufacturerPartNo |
      | product.productDetail[0].stock              |
      | productDetail[0].minimumQuantity            |
      | productDetail[0].inStockQuantity            |
      | productDetail[0].packagingType              |
      | productDetail[0].manufacturer               |
      | productDetail[0].basePrice.native           |
      | productDetail[0].basePrice.reporting        |
      | productDetail[0].pricingType                |
      | categoryID                                  |
      | previousPurchase                            |
      | breadCrumbTarget                            |
      | productDetail[0].stockWareHouse.*           |
      | productDetail[0].stockMessage.*             |
    And verify breadcrumbs "productCategory.classCode" keys are not empty for "product" node

    @eu
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value        |
      | FARNELL     | GB                   | GBP                   | en                    | target.farnell.com |

    @nwk
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value       |
      | NEWARK      | US                   | USD                   | en                    | target.newark.com |

    @apac
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value          |
      | ELEMENT14   | SG                   | SGD                   | en                    | target.element14.com |

  @digitaldata @analyticssmoke @Basketdigidata @live
  Scenario Outline: Validation of digitaldata parameters for Basket page
    And I enter "instock" ordercode from json "orderCodes.json" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
    And I take screenshot
    When I click on "PDPBuyBox.addToCart_button" using js
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I wait for "10" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "10" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I wait for "10" seconds
    And I Execute digitaldata command for "PDP-pageload"
    Then verify below key values are exact match in "page" node
      | cname           | <cname_value>               |
      | pageNode        | Shopping Cart:Shopping Cart |
      | section         | Shopping Cart               |
      | store           | <store_value>               |
      | locale.country  | <locale.country_value>      |
      | locale.currency | <locale.currency_value>     |
      | locale.language | <locale.language_value>     |
      | pageName        | {getPageTitle}              |
      | repositoryPath  | ShoppingBasket              |
    Then verify below key values are exact match in "user" node
      | deviceType | desktop |
      | isLoggedIn | no      |

    @eu
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value        |
      | FARNELL     | GB                   | GBP                   | en                    | target.farnell.com |

    @nwk
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value       |
      | NEWARK      | US                   | USD                   | en                    | target.newark.com |

    @apac
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value          |
      | ELEMENT14   | SG                   | SGD                   | en                    | target.element14.com |

  @digitaldata @analyticssmoke @checkoutdigidata @live
  Scenario Outline: Validation of digitaldata parameters for checkout and orderconfirmation page
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
    And I Execute digitaldata command for "Checkout page"
    Then verify below key values are exact match in "page" node
      | cname           | <cname_value>              |
      | pageNode        | Checkout:Order Information |
      | section         | Checkout                   |
      | store           | <store_value>              |
      | locale.country  | <locale.country_value>     |
      | locale.currency | <locale.currency_value>    |
      | locale.language | <locale.language_value>    |
      | pageName        | {getPageTitle}             |
      | repositoryPath  | enhancedCheckout           |
    Then verify below key values are exact match in "user" node
      | deviceType | desktop |
      | isLoggedIn | yes     |
    And skip rest of the script in live environment
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
    And I enter PO number value "NewTradeACC" in textbox "Checkout.poNumber_textbox"
    And User take screenshot of the page
    And I wait for "10" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And take screenshot of the page
    And I wait for "10" seconds
    And I Execute digitaldata command for "Checkout page"
    Then verify below key values are exact match in "page" node
      | cname           | <cname_value>               |
      | pageNode        | Checkout:Order Confirmation |
      | section         | Checkout                    |
      | store           | <store_value>               |
      | locale.country  | <locale.country_value>      |
      | locale.currency | <locale.currency_value>     |
      | locale.language | <locale.language_value>     |
      | repositoryPath  | enhancedConf                |
    And verify below key string values are not empty for "transaction" node
      | webOrderId                 |
      | paymentMethod              |
      | transactionTotal.native    |
      | transactionTotal.reporting |

    @eu
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value        |
      | FARNELL     | GB                   | GBP                   | en                    | target.farnell.com |

    @nwk
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value       |
      | NEWARK      | US                   | USD                   | en                    | target.newark.com |

    @apac
    Examples: 
      | store_value | locale.country_value | locale.currency_value | locale.language_value | cname_value          |
      | ELEMENT14   | SG                   | SGD                   | en                    | target.element14.com |

  @digitaldata @analyticssmoke @BomDigidata @live
  Scenario Outline: Validate packaging options in digitaldata for BOM results page (EU Only)
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "2000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "20" seconds
    And User scroll till "BOMUploadPage.packageSelect_dropdown"
    And I click on BOM Packaging type dropdown "BOMUploadPage.packageSelect_dropdown" using js
    And I wait for "10" seconds
    And I Execute digitaldata command for "BOM Result page"
    Then verify below key values are exact match in "event" node
      | action      | BOM: Show Packaging Type |
      | type        | click                    |
      | pageSection | Packaging Options        |
      | linkType    | Combo box                |
    And select by index from packaging dropdown "BOMUploadPage.packageDetail_dropdown" without select tag
    And I wait for "20" seconds
    And I Execute digitaldata command for "BOM Result page"
    Then verify below key values are exact match in "event" node
      | action      | BOM: Select Packaging Type |
      | type        | click                      |
      | pageSection | Packaging Options          |
      | linkType    | List Options               |

    @eu
    Examples: 
      | bomFileName                         |
      | BOM_File_PackagingType_EU_APAC.xlsx |

  @digitaldata @analyticssmoke @BomUniqueid @live
  Scenario Outline: Validate BOM ID in digitaldata for BOM results page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "2000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "20" seconds
    And I Execute digitaldata command for "BOM Result page"
    And verify below key string values are not empty for "bomDetails" node
      | bomID |
    When customer accesses the website as "register" user
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And User scroll down the page by pixels "1000"
    And I wait for "2" seconds
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "20" seconds
    And I Execute digitaldata command for "BOM Result page"
    And verify below key string values are not empty for "bomDetails" node
      | bomID |

    @eu @nwk @apac
    Examples: 
      | bomFileName                         |
      | BOM_File_PackagingType_EU_APAC.xlsx |
