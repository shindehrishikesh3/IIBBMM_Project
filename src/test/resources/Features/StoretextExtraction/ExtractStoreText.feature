@extractStoretext
Feature: To extract the list of Storetext across different pages

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across different pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user get the store text keys of "HeaderPart" page for element "StoreTextKeys.header_element"
    And user navigate to "<url1>" page
    And user get the store text keys of "LoginPage" page for element "StoreTextKeys.login_page"
    And user navigate to "<url2>" page
    And user get the store text keys of "RegisterPage" page for element "StoreTextKeys.register_page"
    Examples:
      | url1  | url2     |
      | login | register |

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across top navigation pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user get all the store text keys of "HomePage" page
    And user navigate to "<url1>" page
    And user get all the store text keys of "LoginPage" page
    And user navigate to "<url2>" page
    And user get all the store text keys of "RegisterPage" page
    And user navigate to "<url3>" page
    And user get all the store text keys of "ReducedPrices" page
    And user navigate to "<url4>" page
    And user get all the store text keys of "Offers" page
    And user navigate to "<url5>" page
    And user get all the store text keys of "ContactUs" page
    And user navigate to "<url6>" page
    And user get all the store text keys of "Help" page
    And user navigate to "<url7>" page
    And user get all the store text keys of "TrackOrders" page
    And user navigate to "<url8>" page
    And user get all the store text keys of "ApplyForTradeAccount" page
    Examples:
    | url1  | url2     | url3          | url4                        | url5    | url6|url7|url8|
    | login | register | clearance?ICID=PromoS-clearance | special-offers | contact-us |help|webapp/wcs/stores/servlet/UnauthenticatedOrderDetailsForm|https://www-uk-ftprdeu.farnell.com/trade-account-my-account|

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across different product search pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user navigate to "<url1>" page
    And user get all the store text keys of "BrowseProducts" page
    And user navigate to "<url2>" page
    And user get all the store text keys of "ResistorSerachPage" page
    And user navigate to "<url3>" page
    And user get all the store text keys of "PLPSearchPage" page
    And user navigate to "<url4>" page
    And user get all the store text keys of "PDPSearchPage" page
    And user click on "ShoppingCart.shoppingCart_icon"
    And user get all the store text keys of "CartPage" page
    Examples:
    | url1  | url2     | url3          | url4                        |
    | browse-for-products | search?st=res | w/search/prl/results?st=res | 2329841 |

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across different buying tools pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user navigate to "<url1>" page
    And user get all the store text keys of "InteractiveCatalogues" page
    And user navigate to "<url2>" page
    And user get all the store text keys of "BOMUpload" page
    And user navigate to "<url3>" page
    And user get all the store text keys of "QuickOrder" page
    And user navigate to "<url4>" page
    And user get all the store text keys of "RequestAQuote" page
    And user navigate to "<url5>" page
    And user get all the store text keys of "IBuy" page
    And user navigate to "<url6>" page
    And user get all the store text keys of "PurchaseToPay" page
    And user navigate to "<url7>" page
    And user get all the store text keys of "EpassAPI" page
    And user navigate to "<url8>" page
    And user get all the store text keys of "EInvoicing" page
    And user navigate to "<url9>" page
    And user get all the store text keys of "BrowserSearchTools" page
    And user navigate to "<url10>" page
    And user get all the store text keys of "PartsFinderTool" page
    And user navigate to "<url11>" page
    And user get all the store text keys of "IntegratedSearch" page
    And user navigate to "<url12>" page
    And user get all the store text keys of "Toolbar" page
    And user navigate to "<url13>" page
    And user get all the store text keys of "MobileSolutions" page
    And user navigate to "<url14>" page
    And user get all the store text keys of "PurchasingSolutions" page
    Examples:
    | url1  | url2| url3| url4|url5|url6|url7|url8|url9|url10|url11|url12|url13|url14|
    | interactive-catalogues | parts-list-bom-beta | quick-order | request-a-quote |ibuy|purchase-to-pay|epass-api|einvoicing|browser-search-tools|parts-finder-tool|integrated-search|toolbar|mobile-solutions|purchasing_solutions|


  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across contact us pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user navigate to "<url1>" page
    And user get all the store text keys of "TechnicalSupport" page
    And user navigate to "<url2>" page
    And user get all the store text keys of "WhatsTheProblem" page
    And user navigate to "<url3>" page
    And user get all the store text keys of "EmailSignup" page
    Examples:
    | url1  | url2| url3|
    | technical-support | whats-the-problem | email-signup |

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys across help centre pages
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user navigate to "<url1>" page
    And user get all the store text keys of "RequestAnInvoice" page
    And user navigate to "<url2>" page
    And user get all the store text keys of "DeliveryInformation" page
    And user navigate to "<url3>" page
    And user get all the store text keys of "ROHSLegislation" page
    And user navigate to "<url4>" page
    And user get all the store text keys of "PricingAndAvailability" page
    And user navigate to "<url5>" page
    And user get all the store text keys of "TechnicalSupport" page
    And user navigate to "<url6>" page
    And user get all the store text keys of "ReturnProductForm" page
    And user navigate to "<url7>" page
    And user get all the store text keys of "ReturnPolicy" page
    And user navigate to "<url8>" page
    And user get all the store text keys of "CancelAnOrder" page
    And user navigate to "<url9>" page
    And user get all the store text keys of "TermsOfPurchase" page
    And user navigate to "<url10>" page
    And user get all the store text keys of "AboutCookies" page
    And user navigate to "<url11>" page
    And user get all the store text keys of "CookiesSettings" page
    And user navigate to "<url12>" page
    And user get all the store text keys of "CustomerTesterProgram" page
    And user navigate to "<url13>" page
    And user get all the store text keys of "FAQs" page
    And user navigate to "<url14>" page
    And user get all the store text keys of "EngineeringGlossary" page
    And user navigate to "<url15>" page
    And user get all the store text keys of "Sitemap" page
    And user navigate to "<url16>" page
    And user get all the store text keys of "ProductInformation" page
    Examples:
    | url1  | url2| url3|url4|url5|url6|url7|url8|url9|url10|url11|url12|url13|url14|url15|url16|
    | help-request-an-invoice | help-delivery-information | help-rohs-legislation |help-pricing-availability|help-technical-support|help-how-to-return-a-product|help-return-policy|help-cancel-an-order|terms-of-purchase|about-cookies|cookie-settings|user-research-signup|help-faqs|engineering-glossary|sitemap|help-product-information|

  @storetext @storetextNav
  Scenario Outline: To fetch store text keys from the links under my account
    Given web site is launched successfully and user "does" accept the cookies
    And user navigate to "<url1>" page
    And User enters credentials to login to the application
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And user get all the store text keys of "AccountSummary" page
    And user click on "MyAccount.orderHistoryTracking_link"
    And user get all the store text keys of "TrackOrders" page
    And user click on "MyAccount.billOfMaterialsUpload_link"
    And user get all the store text keys of "BOMUpload" page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And user click on "MyAccount.profileInformation_link"
    And user get all the store text keys of "ProfileInformation" page
    And user click on "MyAccount.addresses_link"
    And user get all the store text keys of "Addresses" page
    And user click on "MyAccount.paymentCards_link"
    And user get all the store text keys of "PaymentCards" page
    And user click on "MyAccount.orderPreferences_link"
    And user get all the store text keys of "OrderPreference" page
    And user click on "MyAccount.favourites_link"
    And user get all the store text keys of "Favourites" page
    And user click on "MyAccount.notificationPreferences_link"
    And user get all the store text keys of "NotificationPreference" page
    And user click on "MyAccount.requestAQuote_link"
    And user get all the store text keys of "RequestAQuote" page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And user click on "MyAccount.savedBaskets_link"
    And user get all the store text keys of "SavedBaskets" page
   	Examples:
    | url1  |
    |login|
