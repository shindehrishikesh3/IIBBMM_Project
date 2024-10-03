#Author: Shilpa
Feature: Personalisation Sprint stories automation tests for web

  #To verify digitaldata bloomreach values from browser console
  @Sprint67 @STM7-1670 @validateViewIdDomainKey @live
  Scenario Outline: To verify viewId and DomainKey in "<store>" store.
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    And I take screenshot
    #HomePage
    And I Execute digitaldata command for "homepage-pageload"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"
    #ContentPage
    Then I navigate to "help-delivery-information" page for "<store>"
    And I wait for "3" seconds
    And I take screenshot
    And I Execute digitaldata command for "Content-pageLoad"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"
    #CLP
    Then I navigate to "c/passive-components/capacitors" page for "<store>"
    And I wait for "3" seconds
    And I take screenshot
    And I Execute digitaldata command for "CLP-pageLoad"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"
    #PLP
    Then I navigate to "c/passive-components/capacitors/prl/results" page for "<store>"
    And I wait for "3" seconds
    And I take screenshot
    And I Execute digitaldata command for "PLP-pageLoad"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"
    #PDP
    Then I enter ordercode in Searchbox to navigate to PDP page
    And I click the "Header.searchIcon_button"
    And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
    And I take screenshot
    And I Execute digitaldata command for "PDP-pageLoad"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"
    #Shopping-cart
    When I click on "PDPBuyBox.addToCart_button" using js
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I wait for "6" seconds
    And I take screenshot
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot
    And I Execute digitaldata command for "Shopping cart-pageLoad"
    Then verify bloomreach digitaldata values are exact match in page node from "bloomreachDigitalData.json" file for "<store>"

    @newark
    Examples: 
      | store  |
      | canada |
      | fr-CA  |
      | mexico |
      | us     |
      | en-MX  |
      | es-us  |
      | pt-BR  |

    @apac
    Examples: 
      | store |
      | au    |
      | hk    |
      | in    |
      | kr    |
      | my    |
      | nz    |
      | ph    |
      | sg    |
      | th    |
      | tw    |
      | en-TW |
      | vn    |

    @eu
    Examples: 
      | store   |
      | fr      |
      | en-FR   |
      | uk      |
      | at      |
      | en-AT   |
      | nl-BE   |
      | en-BE   |
      | fr-BE   |
      | de-CH   |
      | en-CH   |
      | fr-CH   |
      | cpc     |
      | cz      |
      | en-CZ   |
      | de      |
      | en-DE   |
      | bg      |
      | hu      |
      | en-HU   |
      | ie      |
      | it      |
      | en-IT   |
      | pl      |
      | en-PL   |
      | dk      |
      | en-DK   |
      | nl      |
      | en-NL   |
      | fi      |
      | en-FI   |
      | ee      |
      | es      |
      | en-ES   |
      | export  |
      | il      |
      | lt      |
      | lv      |
      | no      |
      | onecall |
      | pt      |
      | ro      |
      | ru      |
      | se      |
      | si      |
      | sk      |
      | tr      |
      | cpc-ie  |

  #To verify digitaldatalayer values for  JobRole and ProductUsage
  @Sprint69 @STM7-1689 @validateUserRoleandUsage
  Scenario Outline: To verify JobRole and ProductUsage in digitaldatalayer for"<store>" store.
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "register" user
    And I take screenshot
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "2" seconds
    And I take screenshot
    When I click on "Header.companylogo_element"
    And I wait for "5" seconds
    And I take screenshot
    #HomePageLoad-1
    And I Execute digitaldata command for "homepage-pageload"
    Then verify digitaldata values- role and usage in user node from "Registration.xlsx" file
    #CLP
    Then I navigate to "c/passive-components/capacitors" page
    And I wait for "4" seconds
    And I Execute digitaldata command for "CLP pageLoad"
    Then verify digitaldata values- role and usage in user node from "Registration.xlsx" file
    #PLP
    Then I navigate to "c/passive-components/capacitors/prl/results" page
    And I wait for "4" seconds
    And I Execute digitaldata command for "PLP pageLoad"
    Then verify digitaldata values- role and usage in user node from "Registration.xlsx" file
    #PDP
    Then I enter ordercode in Searchbox to navigate to PDP page
    And I click the "Header.searchIcon_button"
    And I wait "short" duration for "PDPBuyBox.addToCart_button" element to "appear"
    And I take screenshot
    And I Execute digitaldata command for "PDP-pageLoad"
    Then verify digitaldata values- role and usage in user node from "Registration.xlsx" file
    #ShoppingCart
    When I click on "PDPBuyBox.addToCart_button" using js
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I wait for "6" seconds
    And I take screenshot
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot
    And I Execute digitaldata command for "Shopping cart-pageLoad"
    Then verify digitaldata values- role and usage in user node from "Registration.xlsx" file
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.profileInfo_link"
    And I wait for "6" seconds
    And I take screenshot
    And I edit Job Role and Product Primary Usage Details using given file "EditJobRolePrimaryUsage.xlsx"
    And I take screenshot
    And I click Save button on Profile Information page "MyAccountProfileInformation.save_button"
    And I wait for "2" seconds
    And I take screenshot
    When I click on "Header.companylogo_element"
    And I wait for "5" seconds
    And I take screenshot
    #HomePageLoad-2
    And I Execute digitaldata command for "homepage-pageload-2"
    Then verify digitaldata values- role and usage in user node from "EditJobRolePrimaryUsage.xlsx" file

    @nwk
    Examples: 
      | store  |
      | us     |
      | canada |
      | mexico |

    @apac
    Examples: 
      | store |
      | au    |
      | sg    |
      | hk    |
      | in    |
      | kr    |
      | my    |
      | nz    |
      | ph    |
      | tw    |
      | vn    |

    @eu
    Examples: 
      | store |
      | uk    |
      | fr    |
      | at    |
      | en-BE |
      | en-CH |
      | cz    |
      | de    |
      | ru    |
      | hu    |

  #To validate new Zero/Nil Results Page Component
  @Sprint85 @STM7-2034 @validateZeroResultPage @live
  Scenario Outline: To validateZeroResultPage component in "<store>" store.
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    And I take screenshot
    And I verify element "Header.searchBox_textbox" is present on page
    And user enter the value "ghghghgjklkl" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "2" seconds
    And I take screenshot
    And I append link "&at_preview_token=QfyVOosaJAnipvqpYD1dXMJI4aRvduw4wBf86ide7eI&at_preview_index=1_2&at_preview_listed_activities_only=true&at_preview_evaluate_as_true_audience_ids=8700301" to current URL
    And I wait for "3" seconds
    And I refresh browser.
    And I wait for "3" seconds
    And I wait "short" duration for "Search.noSearchResultsleft_element" element to "appear"
    And I take screenshot
    And I verify zero search results page "LeftComponentHeader" in "Search.noSearchResultsleft_element" from "zeroresultspage.json" file for "<store>"
    And I validate zero search results page content "LeftComponentContent"in "Search.noSearchResultsleft_text" from "zeroresultspage.json" file for "<store>"
    And I verify zero search results page "RequestAQuoteButton" in "Search.requestAQuote_btn" from "zeroresultspage.json" file for "<store>"
    And I verify zero search results page "RightComponentHeader" in "Search.noSearchResultsright_element" from "zeroresultspage.json" file for "<store>"
    And I validate zero search results page content "RightComponentContent"in "Search.noSearchResultsright_text" from "zeroresultspage.json" file for "<store>"
    And I verify zero search results page "EnquireNowButton" in "Search.enquireNow_btn" from "zeroresultspage.json" file for "<store>"
    And I click on Request a quote button "Search.requestAQuote_btn"
    And I wait "medium" duration for "Search.surveyPage_element" element to "appear"
    And I take screenshot
    And I verify link "RequestAQuoteButtonLink" for "<store>"
    And I verify element "Search.surveyPage_element" is present on page
    And I navigates back in the browser
    And I take screenshot
    And I wait "short" duration for "Search.enquireNow_btn" element to "appear"
    And I click on EnquireNow button "Search.enquireNow_btn"
    And I wait "short" duration for "Search.customcomponentPage_element" element to "appear"
    And I take screenshot
    And I verify link "EnquireNowButtonLink" for "<store>"
    And I verify element "Search.customcomponentPage_element" is present on page
    And I verify element "Search.customcomponentPageHeader_element" is present on page and display page header in report
    And I navigates back in the browser

    @eu
    Examples: 
      | store |
      | es    |
      | nl    |
      | pt    |
      | it    |
      | nl-BE |
      | fi    |
      | dk    |
      | se    |
      | no    |
      | pl    |
      | sk    |
      | cz    |
      | si    |
      | de-CH |
      | ie    |
      | il    |
      | bg    |
      | at    |
      | hu    |
      | ee    |
      | lv    |
      | lt    |
      | tr    |
      | ro    |
      | en-ES |
      | en-NL |
      | en-PT |
      | en-IT |
      | en-FI |
      | en-DK |
      | en-SE |
      | en-NO |
      | en-PL |
      | en-SK |
      | en-CZ |
      | en-AT |
      | en-HU |
      | en-RO |
      | fr-CH |
      | en-CH |
      | en-BE |
      | fr-BE |
