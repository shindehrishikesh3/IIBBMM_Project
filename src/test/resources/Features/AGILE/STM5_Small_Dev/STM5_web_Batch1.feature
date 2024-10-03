#Author: Rashmi P
@desktop
Feature: Scripts for Sprint67 Stories

  @Sprint67 @STM5-2325
  Scenario Outline: To Verify that Request a quote link and send a request links are removed from pdp
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And verify element "PDPBuyBox.futureStock_text" is not visible in DOM
    And verify element "PDPBuyBox.sendRequest_link" is not visible in DOM
    And verify element "PDPBuyBox.requestQuote_link" is not visible in DOM

    @eu
    Examples: 
      | store | partNo  |
      | uk    | 1000096 |

    @eu @live
    Examples: 
      | store | partNo    |
      | uk    | 2302519RL |

  @Sprint69 @STM5-2386 @EUPortal
  Scenario Outline: To Verify the redirect of PDP page from Geo location
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    Then I verify the "Home.geoLocationremember_checkbox" remember me functionality
    And user clicks on "Home.geoLocationYes_button"
    And I wait for "10" seconds
    And verify current url contains baseurl "<baseurl>" and "?pf_custSiteRedirect=true"
    Then I verify element "PDP.productTitle_text" is present on "europe,apac" region/store.
    Then I verify element "PLP.withinSearch_button" is present on "newark" region/store.

    @eu @newark @ft
    Examples: 
      | store | partNo  | baseurl                             |
      | sg    | 1215561 | https://www-uk-ftprdeu.farnell.com/ |
      | us    | 83C2425 | https://www-uk-ftprdeu.farnell.com/ |

    @eu @newark @live
    Examples: 
      | store | partNo  | baseurl                 |
      | sg    | 1215561 | https://uk.farnell.com/ |
      | us    | 83C2425 | https://uk.farnell.com/ |

  @Sprint69 @STM5-2386 @apacPortal
  Scenario Outline: To Verify the redirect of PDP page from Geo location
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    Then I verify the "Home.geoLocationremember_checkbox" remember me functionality
    And user clicks on "Home.geoLocationYes_button"
    And I wait for "10" seconds
    And verify current url contains baseurl "<baseurl>" and "?pf_custSiteRedirect=true"
    Then I verify element "PDP.productTitle_text" is present on "europe,apac" region/store.
    Then I verify element "Home.marketLeadingTitle_element" is present on "apac" region/store.

    @apac @eu @ft
    Examples: 
      | store | partNo  | baseurl                               |
      | uk    | 1215561 | https://www-in-ftprdap.element14.com/ |
      | us    | 58M3990 | https://www-in-ftprdap.element14.com/ |

    @apac @eu @live
    Examples: 
      | store | partNo  | baseurl                   |
      | uk    | 1215561 | https://in.element14.com/ |
      | us    | 58M3990 | https://in.element14.com/ |

  @Sprint69 @STM5-2386 @usPortal
  Scenario Outline: To Verify the redirect of PDP page from Geo location
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    Then I verify the "Home.geoLocationremember_checkbox" remember me functionality
    And user clicks on "Home.geoLocationYes_button"
    And I wait for "10" seconds
    And verify current url contains baseurl "<baseurl>" and "?pf_custSiteRedirect=true"
    Then I verify element "PDP.productTitle_text" is present on "newark" region/store.
    Then I verify element "PLP.withinSearch_button" is present on "apac" region/store.

    @newark @apac @ft
    Examples: 
      | store | partNo  | baseurl                         |
      | uk    | 1081212 | https://www-ftprdus.newark.com/ |
      | sg    | 1215561 | https://www-ftprdus.newark.com/ |

    @newark @apac @live
    Examples: 
      | store | partNo  | baseurl                 |
      | uk    | 1081212 | https://www.newark.com/ |
      | sg    | 1215561 | https://www.newark.com/ |

  @Sprint70 @STM5-2386 @NICreuqestquote
  Scenario Outline: To Verify the NIC request quote shows getfeedback form
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I wait for "10" seconds
    And I verify text "Contact Sales for a quote" is visible for "PDPBuyBox.pdpQuote_label"
    And I verify text contains "Request quote" in "PDPBuyBox.futureStock_text"
    And I click on "PDPBuyBox.sendRequest_link" using js
    And I wait for "20" seconds
    And I switch to  child window
    And I enter value "<name>" in textbox "PDPBuyBox.fullname_textbox" for "europe,apac,newark" region/store
    And I enter value "<email>" in textbox "PDPBuyBox.emailaddress_textbox" for "europe,apac,newark" region/store
    And I enter value "<company name>" in textbox "PDPBuyBox.companyname_textbox" for "europe,apac,newark" region/store
    And user clicks on "PDPBuyBox.country_dropdown"
    And I select by index "3" from dropdown "PDPBuyBox.country_dropdown"
    And I enter value "<manufacturename>" in textbox "PDPBuyBox.manufacturename_textbox" for "europe,apac,newark" region/store
    And I enter value "<MPN>" in textbox "PDPBuyBox.MPN_textbox" for "europe,apac,newark" region/store
    And I enter value "<Quantity>" in textbox "PDPBuyBox.Qty_textbox" for "europe,apac,newark" region/store
    And I enter value "<TPC>" in textbox "PDPBuyBox.targetpricecurrency_textbox" for "europe,apac,newark" region/store
    And user clicks on "PDPBuyBox.submit_button"
    And I wait for "10" seconds
    And I verify text "Thank you" is visible for "PDPBuyBox.thankyou_text"
    And I verify text "We will get your quote to you as soon as possible." is visible for "PDPBuyBox.thankyou2_text"

    @eu
    Examples: 
      | store | partNo  | name | email          | company name | manufacturename | MPN  | Quantity | TPC |
      | at    |  146633 | Test | test@gmail.com | example      | TE              | test |       30 | 500 |
      | it    | 1469367 | Test | test@gmail.com | itexample    | vishay          | test |      -20 | 200 |
      | de    | 1774066 | Test | test@gmail.com | deexample    | panduit         | test |       40 | 400 |

  #negative scenarios - No fields are filled and clicked on submit
  @Sprint70 @STM5-2386 @NICreuqestquote @disablesubmit
  Scenario Outline: To Verify disability of submit cta in getfeedback form
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I wait for "10" seconds
    And I verify text "Contact Sales for a quote" is visible for "PDPBuyBox.pdpQuote_label"
    And I verify text contains "Request quote" in "PDPBuyBox.futureStock_text"
    And I click on "PDPBuyBox.sendRequest_link" using js
    And I wait for "20" seconds
    And I switch to  child window
    And I verify element "PDPBuyBox.submit_button" is not Clickable

    @eu
    Examples: 
      | store | partNo  |
      | at    |  146633 |
      # | it    | 1469367 |
      | de    | 1774066 |

  #negative scenarios - Invalid email address
  @Sprint70 @STM5-2386 @NICreuqestquote @invalidemail
  Scenario Outline: To Verify Error message for invalid email address in getfeedback form
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    And I wait for "10" seconds
    And I click on "PDPBuyBox.sendRequest_link" using js
    And I wait for "20" seconds
    And I switch to  child window
    And I enter value "<email>" in textbox "PDPBuyBox.emailaddress_textbox" for "europe,apac,newark" region/store
    And I press shift and tab in "PDPBuyBox.emailaddress_textbox"
    And I verify text "Please enter a valid email address" is visible for "PDPBuyBox.emailerror_text"

    @eu
    Examples: 
      | store | partNo  | name | email |
      | at    |  146633 | Test | test  |
      #  | it    | 1469367 | Test | test  |
      | de    | 1774066 | Test | test  |

  @Sprint80 @STM5-2751 @STM5-2780 @BOMRereelMulticomproProduct
  Scenario Outline: To Verify BOM Matching logic for Removal of Rereel Products and Multicomp pro Products
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user
    And I wait for "10" seconds
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
    And I choose worksheet to read store specific data
    And I wait for "4" seconds
    When I take screenshot of BOM result page
    And verify href url of BOM matched product on BOM result page

    @eu @apac
    Examples: 
      | bomFileName                          |
      | BOM_File_RereelProducts_EU_APAC.xlsx |
