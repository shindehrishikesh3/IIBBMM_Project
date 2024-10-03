@web
Feature: Functional Validations on Desktop

  #Author: Soumen Maity
  @pdp @Sprint63 @SSP980 @ui
  Scenario Outline: To verify the MPN in the link on "<alternativeType>" container in "<store>" store.
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    Then user verifies if the product availability is "<availabilityType>" and get the MPN details for "<partNo>" part no and click on it
    And user wait "medium" duration for "PDPBuyBox.availabilityPriceContainer_element" element to "appear"
    And verify text "<alternativeType>" is visible for "PDPBuyBox.suggestedSubstitutes_text"
    And I take screenshot
    Then I verify the MPN is displayed after the Manufacturername on "<alternativeType>" container

    @eu
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | uk    | 1183117 | Suggested Alternatives | No Longer Manufactured |
      | nl-BE | 1179738 | Exact Alternative      | No Longer Manufactured |
      | bg    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | cz    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | dk    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | ee    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | fi    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | fr    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | de    | 1183117 | Suggested Alternatives | No Longer Manufactured |
      | hu    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | ie    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | il    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | it    | 1184649 | Suggested Alternatives | No Longer Manufactured |

    @apac
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | au    | 1183117 | Suggested Alternatives | No Longer Manufactured |
      | cn    | 1202736 | Suggested Alternatives | No Longer Stocked      |
      | in    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | hk    | 1184649 | Suggested Alternatives | No Longer Manufactured |

    @nwk
    Examples: 
      | store  | partNo  | alternativeType        | availabilityType    |
      | us     | 92f293  | Suggested Alternatives | No Longer Available |
      | pt-BR  | 98Y0214 | Suggested Alternatives | No Longer Available |
      | canada | 93F2637 | Suggested Alternatives | No Longer Available |

    @eu @live
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | uk    | 7016920 | Exact Alternative      | No Longer Manufactured |
      | nl-BE | 1651026 | Suggested Alternatives | No Longer Stocked      |
      | bg    | 7070470 | Exact Alternative      | No Longer Manufactured |
      | cz    | 1717336 | Suggested Alternatives | No Longer Stocked      |
      | dk    | 7047538 | Exact Alternative      | No Longer Manufactured |
      | ee    | 1204126 | Suggested Alternatives | No Longer Stocked      |
      | fi    | 1639577 | Exact Alternative      | No Longer Manufactured |
      | fr    | 1198829 | Suggested Alternatives | No Longer Manufactured |
      | de    | 7016920 | Exact Alternative      | No Longer Manufactured |
      | hu    | 2065043 | Suggested Alternatives | No Longer Manufactured |
      | ie    | 7016920 | Exact Alternative      | No Longer Manufactured |
      | il    | 2043015 | Suggested Alternatives | No Longer Manufactured |
      | it    | 7070470 | Exact Alternative      | No Longer Manufactured |

    @apac @live
    Examples: 
      | store | partNo    | alternativeType        | availabilityType       |
      | au    |   4320268 | Suggested Alternatives | No Longer Manufactured |
      | cn    | 1685357RL | Exact Alternative      | No Longer Manufactured |
      | in    |   1610398 | Suggested Alternatives | No Longer Stocked      |
      | hk    |   1294241 | Exact Alternative      | No Longer Manufactured |

    @nwk @live
    Examples: 
      | store  | partNo  | alternativeType   | availabilityType      |
      | us     | 17M9320 | Exact Alternative | No Longer Available   |
      | pt-BR  | 10N9641 | Exact Alternative | Not Currently Stocked |
      | canada | 17M9320 | Exact Alternative | No Longer Available   |

  #Author: Soumen Maity
  @mfr @Sprint66 @SSP1068 @eu @ui @api
  Scenario Outline: Migration of manufacturer CMS page to /b/ URL structure
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    And navigate to "manufacturers" page
    And wait "medium" duration for "ManufacturePage.menuSectionAll_link" element to "appear"
    When customer clicks on "ManufacturePage.CODEBUGManufacturer_link"
    And wait "medium" duration for "ManufacturerDetailsPage.ManufacturerDescription_element" element to "appear"
    Then verify url parameter value as "b/codebug"
    And make get request in "<store>" store to fetch the response for "b/codebug" parameter without auto redirection
    Then status code "200"
    And take screenshot
    When customer navigate to "codebug-storefront" page
    And wait "medium" duration for "ManufacturerDetailsPage.ManufacturerDescription_element" element to "appear"
    Then verify url parameter value as "b/codebug"
    And make get request in "<store>" store to fetch the response for "codebug-storefront" parameter without auto redirection
    Then status code "301"
    And take screenshot

    Examples: 
      | store |
      | uk    |

  #Author: Soumen Maity
  @raspberryPi @mfr @Sprint68 @SSP991 @eu @ukonly @ui @api
  Scenario: Verify Product Listing/New Products Links to /buy-raspberry-pi
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And navigate to "buy-raspberry-pi" page
    And wait "medium" duration for "RaspberryPi.nav_element" element to "appear"
    And scroll till "RaspberryPi.productListingSection_element"
    Then customer verify text "Product Listing from Raspberry PI" is visible for "RaspberryPi.productListingSectionHeader_text"
    Then customer stores all the urls under "RaspberryPi.productListingAllUrls_link" in Raspberry PI page
    And verify response status code for hyperlinks is "200"
    And take screenshot
    When customer clicks on "RaspberryPi.backToTop_link"
    Then verifies element "RaspberryPi.header_element" is present on page
    And take screenshot

  #Author: Soumen Maity
  @calc @Sprint72 @SSP1133 @eu @ukonly @ui
  Scenario Outline: Verify Parallel Resistance Calculator in desktop
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And navigate to "calculators-conversion-tools" page
    And wait "medium" duration for "CalculatorPage.calculatorContainer_element" element to "appear"
    Then verifies "<calculator>" is present in the calculator and charts page
    And I wait for "3" seconds
    And verifies "<shortDesc>" as short Description and "<calculator>" as button text and image with link "<link>"
    Then customer captures screenshot of the calculator section
    When customer navigate to "parallel-resistance-calculator" page
    And wait "medium" duration for "calculatorPageHeading_element" element to "appear"
    And verify text "<calculator>" in page "CalculatorPage.calculatorHeading_text"
    And verify text "<metaDesc>" in page "CalculatorPage.metaDescription_text" with attribute "content"
    And verify text "<desc>" in page "CalculatorPage.description_text"
    And verify text "Please enter your values below." in page "CalculatorPage.enterValue_text"
    Then customer verifies Parallel Resistor Calculator inputs
    And scroll till "CalculatorPage.formulaHeading_text"
    And verify text "Formulas" in page "CalculatorPage.formulaHeading_text"
    And verify element "CalculatorPage.formula_image" is visible in DOM
    And verify text "<formulaDesc>" in page "CalculatorPage.formulaDesc_text"
    And verify text "Diagram View" in page "CalculatorPage.diagramHeading_text"
    And verify element "CalculatorPage.diagram_image" is visible in DOM
    Then verify text "Calculator & Conversion Charts Menu" in page "CalculatorPage.calcConvMenu_button"
    And take screenshot
    When customer clicks on "CalculatorPage.calcConvMenu_button"
    And wait "medium" duration for "CalculatorPage.calculatorContainer_element" element to "appear"
    And verify element "CalculatorPage.calculatorContainer_element" is visible in DOM

    Examples: 
      | calculator                     | shortDesc                                                               | metaDesc                                                                                                        | link                           | desc                                                                                                                                  | formulaDesc                                                              |
      | Parallel Resistance Calculator | Calculate the equivalent resistance of resistors connected in parallel. | This parallel resistance calculator will let you calculate the total resistance of a parallel resistor circuit. | parallel-resistance-calculator | Use our parallel resistance calculator to determine the total equivalent resistance of a circuit with up to 10 resistors in parallel. | Rtotal = The total equivalent parallel resistance of the resistor array. |

  #Author: Soumen Maity
  @plp @category @Sprint75 @SSP1345 @live
  Scenario Outline: Self referencing links in breadcrumbs displays as text
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    When user clicks on "Header.searchIcon_button"
    And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
    Then select any random product link having "minimum" "100" products as "L1" categories and click on it
    And user wait "medium" duration for "PLP.header_text" element to "appear"
    Then validates only self referencing link in breadcrumb is displaying as text
    And take screenshot
    When user clicks on "Header.searchIcon_button"
    And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
    Then select any random product link having "minimum" "1000" products as "L0" categories and click on it
    And user wait "medium" duration for "PLP.header_text" element to "appear"
    Then validates only self referencing link in breadcrumb is displaying as text
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | fr    |
      | de    |
      | cpc   |
      | es    |
      | ie    |
      | dk    |
      | sk    |
      | hu    |
      | ro    |

    @apac
    Examples: 
      | store |
      | au    |
      | cn    |
      | sg    |
      | hk    |
      | in    |
      | kr    |
      | tw    |
      | th    |
      | vn    |

    @nwk
    Examples: 
      | store  |
      | us     |
      | pt-BR  |
      | canada |
      | mexico |
      | es-us  |

  #Author: Soumen Maity
  @cookie @Sprint75 @SSP813 @eu @live
  Scenario Outline: 'more information' link on dual lang stores navigates to proper language
    Given user navigate to "<store>" store homepage and "does not" accept the cookies
    And take screenshot
    And clicks on "CookieSetting.moreinfo_link"
    And wait "medium" duration for "CookieSetting.aboutCookies_element" element to "appear"
    Then user verifies current url contains "<store>"
    And take screenshot

    Examples: 
      | store |
      | en-AT |
      | en-CZ |
      | en-DK |
      | en-FR |
      | en-DE |
      | en-HU |
      | en-IT |
      | en-NL |
      | en-NO |

  #Author: Soumen Maity
  @schemaValidaton @homepage @sprint_81 @apac @live @SSP-1594
  Scenario Outline: "<store>" - Site Name in Google search
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And customer accesses the website as "guest" user
    Then website structured data should be present and it should be as per the schema structure in "SiteNameJSONSchema.json" file
    And validate value of "@context" is present as "https://schema.org"
    And validate value of "@type" is present as "WebSite"
    And validate value of "name" is present as "<name>"
    And validate value of "url" is present as "<url>"

    Examples: 
      | store | name                  | url                       |
      | au    | element14 Australia   | https://au.element14.com/ |
      | cn    | element14 China       | https://cn.element14.com/ |
      | en-CN | element14 China       | https://cn.element14.com/ |
      | hk    | element14 Hong Kong   | https://hk.element14.com/ |
      | in    | element14 India       | https://in.element14.com/ |
      | kr    | element14 Korea       | https://kr.element14.com/ |
      | my    | element14 Malaysia    | https://my.element14.com/ |
      | nz    | element14 New Zealand | https://nz.element14.com/ |
      | ph    | element14 Philippines | https://ph.element14.com/ |
      | th    | element14 Thailand    | https://th.element14.com/ |
      | tw    | element14 Taiwan      | https://tw.element14.com/ |
      | en-TW | element14 Taiwan      | https://tw.element14.com/ |
      | vn    | element14 Vietnam     | https://vn.element14.com/ |

  #Author: Soumen Maity
  @cms @btf @sprint_84 @live @SSP-1705
  Scenario Outline: Content Page Template Optimisation - Industrial Automation Control page
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And customer accesses the website as "guest" user
    When user navigate to "industrial-automation-control" page
    And wait "medium" duration for "Header.companylogo_element" element to "appear"
    Then user validates whether "industrial-automation-control-btf" ajax call is not happening in Industrial Automation Control page while page is in above the fold
    And take screenshot
    And scroll down the page by pixels "500"
    And wait for "3" seconds
    Then user validates whether "industrial-automation-control-btf" ajax call is happening in Industrial Automation Control page
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | at    |
      | bg    |
      | nl-BE |
      | de-CH |
      | cz    |
      | de    |
      | dk    |
      | ee    |
      | fi    |
      | fr    |
      | hu    |

    @apac
    Examples: 
      | store |
      | au    |
      | cn    |
      | hk    |
      | in    |
      | kr    |
      | my    |
      | nz    |
      | ph    |
      | th    |
      | tw    |
      | vn    |

    @nwk
    Examples: 
      | store  |
      | us     |
      | pt-BR  |
      | mexico |
      | canada |
      
  #Author: Soumen Maity
  @cms @btf @sprint_84 @live @SSP-1706
  Scenario Outline: Content Page Template Optimisation - Transportation Solutions page
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And customer accesses the website as "guest" user
    When user navigate to "transportation-solutions" page
    And wait "medium" duration for "Header.companylogo_element" element to "appear"
    Then user validates whether "transportation-solutions-btf" ajax call is not happening in Transportation Solutions page while page is in above the fold
    And validates "transportation-solutions_banner" image size is compressed from "109.0"
    And take screenshot
    And scroll down the page by pixels "1000"
    And wait for "3" seconds
    Then user validates whether "transportation-solutions-btf" ajax call is happening in Transportation Solutions page
    And user validates whether element "CMS.tsReadLess_link" is present on page
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | at    |
      | bg    |
      | nl-BE |
      | de-CH |
      | cz    |
      | de    |
      | dk    |
      | ee    |
      | fi    |
      | fr    |
      | hu    |

  