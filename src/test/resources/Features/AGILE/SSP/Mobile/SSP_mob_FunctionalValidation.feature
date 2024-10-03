@mob
Feature: Functional Validations in Mobile

  #Author: Raji Kambar
  @Sprint62 @GoogleBot @ui
  Scenario Outline: Verify GoogleBot for hreflang check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I verify the "Home.geoLocationNo_button" functionality if exists on page
    And user verify GoogleBot Hreflang for "<Store>" of "<Name>" attribute on the link "<URL>"

    @eu
    Examples: 
      | Store | URL                                            | Name                          |
      | uk    | 555-timer-calculator                           | 555 Timer Calculator          |
      | uk    | awg-conversion-calculator                      | AWG Calculator                |
      | uk    | capacitor-charge-calculator                    | Capacitor Charge Calculator   |
      | uk    | buy-raspberry-pi                               | Raspberry pi Page             |
      | de    | impedanzanpassungsrechner                      | impedance-matching-calculator |
      | de    | masse-gewicht                                  | Mass and Weight Calculator    |
      | de    | industry-4-solutions-for-smart-production-line | IOT Page                      |

    @nwk
    Examples: 
      | Store  | URL                                      | Name                             |
      | us     | led-series-resistor-calculator           | LED Series Resistor              |
      | us     | impedance-matching-calculator            | Impedance Matching Calculator    |
      | us     | inductance-conversion                    | Inductance Conversion Calculator |
      | us     | achieving-universal-standards-compliance | IOT Page                         |
      | mexico | calculadora-conversion-volumen           | Volume Calculator                |
      | mexico | convertidor-temperatura                  | Temperature Calculator           |

    @apac
    Examples: 
      | Store | URL                                                   | Name                     |
      | au    | improving-maintenance-and-safety-performance-with-iot | IOT Page                 |
      | au    | temperature-converter                                 | Temperature Calculator   |
      | au    | length-conversion-calculator                          | Length Calculator        |
      | au    | power-conversion-calculator                           | Power Calculator         |
      | au    | ohms-law-calculator                                   | Ohms Law Calculator      |
      | au    | time-constant-calculator                              | Time Constant Calculator |

  #Author: Soumen Maity
  @pdp @Sprint63 @SSP980 @ui
  Scenario Outline: To verify the MPN in the link on "<alternativeType>" in "<store>" store.
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When user enter value "<partNo>" in textbox "Header.searchBox_textbox"
    And user clicks on "Header.searchIcon_button"
    Then user verifies if the product availability is "<availabilityType>" and get the MPN details for "<partNo>" part no and click on it in mobile
    And user wait "medium" duration for "PDPBuyBox.availabilityAltContainer_element" element to "appear"
    And verify text "<alternativeType>" is visible for "PDPBuyBox.suggestedSubstitutes_text"
    And I scroll till "PDPBuyBox.availabilityAltContainer_element"
    And I take screenshot
    Then I verify the MPN is displayed after the Manufacturername on "<alternativeType>" container in mobile

    @eu
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | uk    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | lv    | 1183117 | Suggested Alternatives | No Longer Manufactured |
      | nl    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | no    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | pl    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | pt    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | ro    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | ru    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | sk    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | es    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | se    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | tr    | 1625210 | Suggested Alternatives | No Longer Stocked      |

    @apac
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | nz    | 1184649 | Suggested Alternatives | No Longer Manufactured |
      | ph    | 1179738 | Exact Alternative      | No Longer Manufactured |
      | sg    | 1183117 | Suggested Alternatives | No Longer Manufactured |
      | th    | 1179738 | Exact Alternative      | No Longer Manufactured |

    @nwk
    Examples: 
      | store  | partNo  | alternativeType        | availabilityType    |
      | us     | 98Y0214 | Suggested Alternatives | No Longer Available |
      | mexico | 18X3915 | Suggested Alternatives | No Longer Available |
      | es-us  | 93F2637 | Suggested Alternatives | No Longer Available |

    @eu @live
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | uk    | 1651026 | Suggested Alternatives | No Longer Stocked      |
      | lv    | 7016920 | Exact Alternative      | No Longer Manufactured |
      | nl    | 1198829 | Suggested Alternatives | No Longer Manufactured |
      | no    | 7070470 | Exact Alternative      | No Longer Manufactured |
      | pl    | 1717336 | Suggested Alternatives | No Longer Stocked      |
      | pt    | 7047538 | Exact Alternative      | No Longer Manufactured |
      | ro    | 1204126 | Suggested Alternatives | No Longer Stocked      |
      | ru    | 1639577 | Exact Alternative      | No Longer Manufactured |
      | sk    | 1198829 | Suggested Alternatives | No Longer Manufactured |
      | es    | 7016920 | Exact Alternative      | No Longer Manufactured |
      | se    | 1651026 | Suggested Alternatives | No Longer Stocked      |
      | tr    | 7070470 | Exact Alternative      | No Longer Manufactured |

    @apac @live
    Examples: 
      | store | partNo  | alternativeType        | availabilityType       |
      | nz    |  161548 | Suggested Alternatives | No Longer Stocked      |
      | ph    | 1664878 | Suggested Alternatives | No Longer Manufactured |
      | sg    | 1610398 | Suggested Alternatives | No Longer Stocked      |
      | th    | 1611492 | Suggested Alternatives | No Longer Manufactured |

    @nwk @live
    Examples: 
      | store | partNo  | alternativeType        | availabilityType      |
      | us    | 06M7469 | Suggested Alternatives | No Longer Available   |
      | es-us | 51R4998 | Exact Alternative      | Not Currently Stocked |

  #Author: Hrishikesh Shinde
  @pdp @Sprint66 @SSP-1059 @ui
  Scenario Outline: Open image by default on mobile if one present
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    And I verify element "Header.searchBox_textbox" is visible in DOM
    #--------------positive scenario------------------
    Then user enter the value "<orderCode1>" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I verify element "PDP.imageSectionExpanded_section" is visible in DOM
    Then I verify element "PDP.productImage_image" is present on page
    And I take screenshot
    #--------------negative scenario------------------
    And I clears text from textbox "Header.searchBox_textbox"
    Then user enter the value "<orderCode2>" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I verify element "PDP.imageSectionExpanded_section" is not visible in DOM
    Then I verify absence of element "PDP.productImage_image"
    And I take screenshot

    @eu
    Examples: 
      | store | orderCode1 | orderCode2 |
      | uk    |    1299885 |    2706532 |
      | ie    |    3471147 |    2345930 |
      | it    |    2008332 |    2728855 |
      | ru    |    1303933 |    2610490 |
      | se    |    2334077 |    2581686 |
      | en-CZ |    2081164 |    2544821 |
      | en-AT |    4723880 |    2617655 |
      | fr-BE |    9338152 |    2689938 |
      | en-FR |    2070341 |    2318322 |
      | en-DE |    1201896 |    2531303 |

    @apac
    Examples: 
      | store | orderCode1 | orderCode2 |
      | au    |    2064610 |    2544821 |
      | cn    |    9338152 |    2345930 |
      | in    |     519315 |    2613615 |
      | kr    |    2532209 |    2617349 |
      | sg    |    1900073 |    2544821 |
      | tw    |    2083824 |    2617259 |
      | th    |    1171467 |    1580507 |

    @nwk
    Examples: 
      | store  | orderCode1 | orderCode2 |
      | us     | 59Y6767    | 05AC1689   |
      | pt-BR  | 24M0615    | 10M8896    |
      | canada | 20M0539    | 13M4772    |
      | en-MX  | 72Y1900    | 18AC8057   |

  @mfr @Sprint66 @SSP1068 @eu @ui @api
  Scenario Outline: Migration of manufacturer CMS page to /b/ URL structure
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    And navigate to "manufacturers" page
    And wait "medium" duration for "BurgerNavigation.manufacturerHeading_element" element to "appear"
    When customer clicks on "ManufacturerListPage.ManufacturerC_section"
    And clicks on "ManufacturerListPage.CODEBUGManufacturer_link"
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

  @raspberryPi @mfr @Sprint68 @SSP991 @eu @ukonly @ui @api
  Scenario: Verify Product Listing/New Products Links to /buy-raspberry-pi
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And navigate to "buy-raspberry-pi" page
    And wait "medium" duration for "RaspberryPi.nav_element" element to "appear"
    And scroll till "RaspberryPi.footer_element"
    And scroll up the page by pixels "500"
    Then customer verify text "Product Listing from Raspberry PI" is visible for "RaspberryPi.productListingSectionHeader_text"
    And element "RaspberryPi.showAllProduct_button" is present on page
    Then customer stores all the urls under "RaspberryPi.product_links" in Raspberry PI page mobile
    And verify response status code for hyperlinks is "200"
    And take screenshot
    When customer clicks on "RaspberryPi.backToTop_link"
    Then verifies element "RaspberryPi.header_element" is present on page
    And take screenshot

  #Author: Soumen Maity
  @calc @Sprint72 @SSP1133 @eu @ukonly @ui
  Scenario Outline: Verify Parallel Resistance Calculator in mobile
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And navigate to "calculators-conversion-tools" page
    And wait "medium" duration for "CalcuatorsAndCharts.calculatorContainer_element" element to "appear"
    Then verifies "<calculator>" is present in the calculator and charts page in mobile
    And I wait for "3" seconds
    And verifies "<shortDesc>" as short Description and "<calculator>" as button text and image with link "<link>" in mobile
    Then customer captures screenshot of the calculator section in mobile
    When customer navigate to "parallel-resistance-calculator" page
    And wait "medium" duration for "CalcuatorsAndChartsHeading_element" element to "appear"
    And verify text "<calculator>" in page "CalcuatorsAndCharts.calculatorHeading_text"
    And verify text "<metaDesc>" in page "CalcuatorsAndCharts.metaDescription_text" with attribute "content"
    And verify text "<desc>" in page "CalcuatorsAndCharts.description_text"
    And verify text "Please enter your values below." in page "CalcuatorsAndCharts.enterValue_text"
    Then customer verifies Parallel Resistor Calculator inputs in mobile
    And scroll till "CalcuatorsAndCharts.formulaHeading_text"
    And verify text "Formulas" in page "CalcuatorsAndCharts.formulaHeading_text"
    And verify element "CalcuatorsAndCharts.formula_image" is visible in DOM
    And verify text "<formulaDesc>" in page "CalcuatorsAndCharts.formulaDesc_text"
    And verify text "Diagram View" in page "CalcuatorsAndCharts.diagramHeading_text"
    And verify element "CalcuatorsAndCharts.diagram_image" is visible in DOM
    Then verify text "Calculator & Conversion Charts Menu" in page "CalcuatorsAndCharts.calcConvMenu_button"
    And take screenshot
    When customer clicks on "CalcuatorsAndCharts.calcConvMenu_button"
    And wait "medium" duration for "CalcuatorsAndCharts.calculatorContainer_element" element to "appear"
    And verify element "CalcuatorsAndCharts.calculatorContainer_element" is visible in DOM

    Examples: 
      | calculator                     | shortDesc                                                               | metaDesc                                                                                                        | link                           | desc                                                                                                                                  | formulaDesc                                                              |
      | Parallel Resistance Calculator | Calculate the equivalent resistance of resistors connected in parallel. | This parallel resistance calculator will let you calculate the total resistance of a parallel resistor circuit. | parallel-resistance-calculator | Use our parallel resistance calculator to determine the total equivalent resistance of a circuit with up to 10 resistors in parallel. | Rtotal = The total equivalent parallel resistance of the resistor array. |

  #Author: Soumen Maity
  @category @L1 @Sprint73 @SSP1272 @live @api
  Scenario Outline: Passives - Internal Linking
    Verify Keyword in Popular Searches will display before the bottom pagination and would link to the target URL

    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<category>" category from json "InternalLinking_EN.json" in mobile
    And wait "medium" duration for "CategoryPage.category_heading" element to "appear"
    And scroll till "CategoryPage.popularSearchHeading_text"
    And I wait for "3" seconds
    Then verify text "Popular Searches" in page "CategoryPage.popularSearchHeading_text"
    And verify "<category>" popular searches description with "CategoryPage.popularSearch_text" in mobile
    And verify hyperlinked text in the description with "CategoryPage.popularSearch_links" for Passive category "<category>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    Then I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report

    @eu
    Examples: 
      | store | category             |
      | uk    | Resistor Fixed Value |
      | en-AT | Resistor Fixed Value |
      | en-HU | Resistor Fixed Value |
      | en-DK | Resistor Fixed Value |
      | en-PT | Resistor Fixed Value |
      | en-RO | Resistor Fixed Value |
      | en-SK | Resistor Fixed Value |
      | en-PL | Resistor Fixed Value |
      | en-BE | Resistor Fixed Value |
      | en-ES | Resistor Fixed Value |
      | en-CZ | Resistor Fixed Value |
      | en-FR | Resistor Fixed Value |
      | en-DE | Resistor Fixed Value |
      | il    | Resistor Fixed Value |
      | en-IT | Resistor Fixed Value |
      | en-NL | Resistor Fixed Value |
      | en-NO | Resistor Fixed Value |
      | en-SE | Resistor Fixed Value |
      | en-CH | Resistor Fixed Value |
      | ie    | Resistor Fixed Value |

    @apac
    Examples: 
      | store | category             |
      | au    | Resistor Fixed Value |
      | en-CN | Resistor Fixed Value |
      | in    | Resistor Fixed Value |
      | hk    | Resistor Fixed Value |
      | sg    | Resistor Fixed Value |
      | my    | Resistor Fixed Value |
      | en-TW | Resistor Fixed Value |
      | nz    | Resistor Fixed Value |
      | ph    | Resistor Fixed Value |

    @nwk
    Examples: 
      | store  | category             |
      | us     | Resistor Fixed Value |
      | en-MX  | Resistor Fixed Value |
      | canada | Resistor Fixed Value |

  #Author: Soumen Maity
  @plp @Sprint75 @SSP1345 @live
  Scenario Outline: Self referencing links in breadcrumbs displays as text
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "userType" user
    When user clicks on "Header.searchIcon_button"
    And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
    And I wait for "2" seconds
    Then select any random product link having less than "10000" products from "BrowseForProducts.allSubCategory_links" and click on it
    And user wait "medium" duration for "PLP.header_text" element to "appear"
    Then validates in mobile only self referencing link in breadcrumb is displaying as text
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | at    |
      | bg    |
      | cpc   |
      | cz    |
      | pl    |
      | ee    |
      | fi    |
      | it    |
      | pt    |

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
      | en-PT |
      | en-RO |
      | en-SK |
      | en-SE |
      | en-CH |
      | en-BE |
      | en-PL |
      | en-FI |
      | en-ES |

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

  #Author: Sandhya Seelam
  @category @L1 @sprint_81 @SSP1594 @live @api
  Scenario Outline: Inductors - Internal Linking
    Verify the Keywords displayed in Popular Searches at the bottom of pagination and its respective target URLs

    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<category>" category from json "SSP_1549_InternalLinkingForInductors_Mobile.json" in mobile
    And wait "medium" duration for "CategoryPage.category_heading" element to "appear"
    And scroll till "CategoryPage.popularSearchHeading_text"
    And I wait for "3" seconds
    Then verify text "Popular Searches" in page "CategoryPage.popularSearchHeading_text"
    And verify "<category>" popular searches description with "CategoryPage.popularSearch_text" in mobile
    And verify hyperlinked text in the description with "CategoryPage.popularSearch_links" for Passive category "<category>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    Then I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report

    @eu
    Examples: 
      | store | category                      |
      | uk    | Inductors                     |
      | en-AT | Charging Coil Arrays          |
      | en-HU | Charging Coils                |
      | en-DK | Coupled Inductors             |
      | en-PT | Fixed Value Inductors         |
      | en-RO | SMD Power Inductors           |
      | en-SK | Power Inductors               |
      | en-PL | WireWound Inductors           |
      | en-BE | Radial Leaded Power Inductors |
      | en-ES | Charging Coils                |
      | en-CZ | Coupled Inductors             |
      | en-FR | Power Inductors               |
      | en-DE | Radial Leaded Power Inductors |
      | il    | Inductors                     |
      | en-IT | Fixed Value Inductors         |
      | en-NL | SMD Power Inductors           |
      | en-NO | Coupled Inductors             |
      | en-SE | WireWound Inductors           |
      | en-CH | Charging Coils                |
      | ie    | Inductors                     |
      | en-FR | Inductors                     |
      | en-DE | Charging Coils                |
      | il    | SMD Power Inductors           |
      | en-IT | Inductors                     |
      | en-SE | Power Inductors               |
      | en-CH | WireWound Inductors           |
      | en-AT | Coupled Inductors             |
      | en-HU | SMD Power Inductors           |
      | en-DK | Charging Coil Arrays          |
      | en-PT | Fixed Value Inductors         |
      | en-DE | WireWound Inductors           |
      | il    | Charging Coil Arrays          |
      | en-IT | Radial Leaded Power Inductors |
      | en-NL | Charging Coils                |

    @apac
    Examples: 
      | store | category                      |
      | au    | Inductors                     |
      | en-CN | Charging Coil Arrays          |
      | in    | Charging Coils                |
      | hk    | Radial Leaded Power Inductors |
      | sg    | SMD Power Inductors           |
      | my    | Power Inductors               |
      | en-TW | WireWound Inductors           |
      | nz    | Fixed Value Inductors         |
      | ph    | Coupled Inductors             |
      | en-CN | SMD Power Inductors           |
      | in    | Inductors                     |
      | hk    | Charging Coil Arrays          |
      | sg    | Inductors                     |
      | en-TW | Radial Leaded Power Inductors |
      | nz    | Power Inductors               |
      | ph    | WireWound Inductors           |
      | in    | Coupled Inductors             |
      | hk    | Fixed Value Inductors         |
      | sg    | Radial Leaded Power Inductors |
      | my    | Coupled Inductors             |
      | en-TW | Charging Coil Arrays          |
      | ph    | Fixed Value Inductors         |

    @nwk
    Examples: 
      | store  | category                      |
      | us     | Inductors                     |
      | en-MX  | Charging Coil Arrays          |
      | canada | Charging Coils                |
      | en-MX  | Radial Leaded Power Inductors |
      | canada | SMD Power Inductors           |
      | us     | Power Inductors               |
      | us     | WireWound Inductors In Newark |
      | en-MX  | Fixed Value Inductors         |
      | canada | Coupled Inductors             |
      | en-MX  | SMD Power Inductors           |
      | en-MX  | Charging Coil Arrays          |
      | canada | Inductors                     |
      | us     | Radial Leaded Power Inductors |
      | canada | Power Inductors               |
      | en-MX  | WireWound Inductors In Newark |
      | en-MX  | Coupled Inductors             |
      | canada | Fixed Value Inductors         |
      | canada | Inductors                     |
      | canada | Radial Leaded Power Inductors |

  #Author: Soumen Maity
  @homepage @sprint_84 @live @SSP-1704
  Scenario Outline: "<store>" - ICIDs on mobile homepage – test
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And customer accesses the website as "guest" user
    And I verify the "Home.geoLocationNo_button" functionality
    And scroll till "Home.allCategory_link"
    And wait for "2" seconds
    Then user validates category innerlinks with updated tracking ID url for "Home.allCategory_link"
    And scroll till "Home.help_link"
    And wait for "2" seconds
    And scroll till "Home.manufacture_label"
    And wait for "1" seconds
    Then user validates manufacturer list innerlinks with updated tracking ID url for "Home.manufacturerList_image"

    @eu @eu
    Examples: 
      | store |
      | uk    |
      | at    |
      | bg    |
      | es    |
      | cz    |
      | pl    |
      | ee    |
      | fi    |
      | it    |
      | pt    |

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
      | th    |
      | tw    |
      | en-TW |
      | vn    |

    @nwk
    Examples: 
      | store  |
      | us     |
      | pt-BR  |
      | canada |
      | mexico |
      | es-us  |

  @plp @sprint_82 @live @api @SSP-1594
  Scenario Outline: Popular Links - Resistance
    Keywords will link to the URL across all of the EN locals in the “popular searches” spots across Mobile.

    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<category>" category from json "PopularLinksResistance_S82.json" in mobile
    And wait "medium" duration for "CategoryPage.category_heading" element to "appear"
    And scroll till "CategoryPage.popularSearchHeading_text"
    And I wait for "3" seconds
    Then verify text "Popular Searches" in page "CategoryPage.popularSearchHeading_text"
    And verify "<category>" popular searches description with "CategoryPage.popularSearch_text" in mobile
    And verify hyperlinked text in the description with "CategoryPage.popularSearch_links" for Passive category "<category>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    Then I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report

    @eu
    Examples: 
      | store | category         |
      | uk    | 0.1ohm           |
      | en-AT | 1.5 ohm resistor |
      | en-HU | resistor 100k    |
      | en-DK | 100ohm resistor  |
      | en-PT | 10k resistor     |
      | en-RO | 10m resistor     |
      | en-SK | 0.1ohm           |
      | en-PL | 1.5 ohm resistor |
      | en-BE | resistor 100k    |
      | en-ES | 100ohm resistor  |
      | en-CZ | 10k resistor     |
      | en-FR | 10m resistor     |
      | en-DE | 0.1ohm           |
      | il    | 1.5 ohm resistor |
      | en-IT | resistor 100k    |
      | en-NL | 100ohm resistor  |
      | en-NO | 10k resistor     |
      | en-SE | 10m resistor     |
      | en-CH | 0.1ohm           |
      | ie    | 100ohm resistor  |

    @apac
    Examples: 
      | store | category         |
      | au    | 0.1ohm           |
      | en-CN | 1.5 ohm resistor |
      | in    | resistor 100k    |
      | hk    | 100ohm resistor  |
      | sg    | 10k resistor     |
      | my    | 10m resistor     |
      | en-TW | 0.1ohm           |
      | nz    | 100ohm resistor  |
      | ph    | 10k resistor     |

    @nwk
    Examples: 
      | store  | category         |
      | us     | 0.1ohm           |
      | en-MX  | 1.5 ohm resistor |
      | canada | resistor 100k    |
      | en-MX  | 100ohm resistor  |
      | canada | 10k resistor     |
      | us     | 10m resistor     |

  @plp @sprint_83 @live @api @SSP-1597 @SSP-1598
  Scenario Outline: Popular Links - Resistance
    Keywords will link to the URL across all of the EN locals in the “popular searches” spots across Mobile.

    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<category>" category from json "PopularLinksResistance_S83.json" in mobile
    And wait "medium" duration for "CategoryPage.category_heading" element to "appear"
    And scroll till "CategoryPage.popularSearchHeading_text"
    And I wait for "3" seconds
    Then verify text "Popular Searches" in page "CategoryPage.popularSearchHeading_text"
    And verify "<category>" popular searches description with "CategoryPage.popularSearch_text" in mobile
    And verify hyperlinked text in the description with "CategoryPage.popularSearch_links" for Passive category "<category>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    Then I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report

    @eu
    Examples: 
      | store | category         |
      | uk    | 120 ohm resistor |
      | en-AT | 150 ohm resistor |
      | en-HU | 1k resistor      |
      | en-DK | 1m resistor      |
      | en-PT | 1 ohm resistor   |
      | en-RO | 20k resistor     |
      | en-SK | 220k resistor    |
      | en-PL | 220 ohm resistor |
      | en-BE | 22 ohm resistor  |
      | en-ES | 250 ohm resistor |
      | en-CZ | 27k resistor     |
      | en-FR | 2k resistor      |
      | en-DE | 120 ohm resistor |
      | il    | 150 ohm resistor |
      | en-IT | 1k resistor      |
      | en-NL | 1m resistor      |
      | en-NO | 1 ohm resistor   |
      | en-SE | 20k resistor     |
      | en-CH | 220k resistor    |
      | ie    | 220 ohm resistor |

    @apac
    Examples: 
      | store | category         |
      | au    | 120 ohm resistor |
      | en-CN | 150 ohm resistor |
      | in    | 1k resistor      |
      | hk    | 1m resistor      |
      | sg    | 1 ohm resistor   |
      | my    | 20k resistor     |
      | en-TW | 220k resistor    |
      | nz    | 220 ohm resistor |
      | ph    | 22 ohm resistor  |
      | au    | 250 ohm resistor |
      | en-CN | 27k resistor     |
      | in    | 2k resistor      |

    @nwk
    Examples: 
      | store  | category         |
      | us     | 120 ohm resistor |
      | en-MX  | 150 ohm resistor |
      | canada | 1k resistor      |
      | en-MX  | 1m resistor      |
      | canada | 1 ohm resistor   |
      | us     | 20k resistor     |
      | en-MX  | 220k resistor    |
      | canada | 220 ohm resistor |
      | en-MX  | 22 ohm resistor  |
      | canada | 250 ohm resistor |
      | us     | 27k resistor     |
      | en-MX  | 2k resistor      |

  #Author: Soumen Maity
  @cms @btf @sprint_84 @live @SSP-1705
  Scenario Outline: Content Page Template Optimisation - Industrial Automation Control page
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And customer accesses the website as "guest" user
    When user navigate to "industrial-automation-control" page
    And wait "medium" duration for "Header.companylogo_element" element to "appear"
    Then user validates whether "industrial-automation-control-btf" ajax call is not happening in Industrial Automation Control page while page is in above the fold
    And take screenshot
    And scroll down the page by pixels "1500"
    And wait for "3" seconds
    Then user validates whether "industrial-automation-control-btf" ajax call is happening in Industrial Automation Control page
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | ie    |
      | it    |
      | lv    |
      | no    |
      | pl    |
      | pt    |
      | ro    |
      | se    |
      | sk    |
      | tr    |

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
    Then user validates whether "transportation-solutions-btf" ajax call is not happening in Industrial Automation Control page while page is in above the fold
    And wait for "3" seconds
    And take screenshot
    And scroll down the page by pixels "700"
    And wait for "3" seconds
    Then user validates whether "transportation-solutions-btf" ajax call is happening in Industrial Automation Control page
    And user verify absence of element "CMS.tsReadLess_link"
    And take screenshot

    @eu
    Examples: 
      | store |
      | uk    |
      | ie    |
      | it    |
      | lv    |
      | no    |
      | pl    |
      | pt    |
      | ro    |
      | se    |
      | sk    |
      | tr    |

  @plp @sprint_84 @live @api @SSP-1599 @SSP-1595
  Scenario Outline: Popular Links - Resistance
    Keywords will link to the URL across all of the EN locals in the “popular searches” spots across Mobile.

    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<category>" category from json "PopularLinksResistance_S84.json" in mobile
    And wait "medium" duration for "CategoryPage.category_heading" element to "appear"
    And scroll till "CategoryPage.popularSearchHeading_text"
    And I wait for "3" seconds
    And I take screenshot of the 'Popular Searches' content
    Then verify text "Popular Searches" in page "CategoryPage.popularSearchHeading_text"
    And verify "<category>" popular searches description with "CategoryPage.popularSearch_text" in mobile
    And verify hyperlinked text in the description with "CategoryPage.popularSearch_links" for Passive category "<category>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    Then I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report

    @eu
    Examples: 
      | store | category          |
      | uk    | 470_Ohm_Resistor  |
      | en-AT | 47_Ohm_Resistor   |
      | en-HU | 50_Ohm_Resistor   |
      | en-DK | 5k_Ohm_Resistor   |
      | en-PT | 47_Ohm_Resistor   |
      | en-RO | 5_Ohm_Resistor    |
      | en-SK | 3k3_Ohm_Resistor  |
      | en-PL | 30k_Ohm_Resistor  |
      | en-BE | 5k_Ohm_Resistor   |
      | en-ES | 50_Ohm_Resistor   |
      | en-CZ | 3k3_Ohm_Resistor  |
      | en-FR | 30k_Ohm_Resistor  |
      | en-DE | 330_Ohm_Resistor  |
      | il    | 4k7_Ohm_Resistor  |
      | en-IT | 330_Ohm_Resistor  |
      | en-NL | 33k_Ohm_Resistor  |
      | en-NO | 5_Ohm_Resistor    |
      | en-SE | 3k3_Ohm_Resistor  |
      | en-CH | 470k_Ohm_Resistor |
      | ie    | 33k_Ohm_Resistor  |
      | en-SE | 470k_Ohm_Resistor |
      | en-DK | 4k7_Ohm_Resistor  |

    @apac
    Examples: 
      | store | category          |
      | au    | 470_Ohm_Resistor  |
      | en-CN | 5k_Ohm_Resistor   |
      | in    | 47_Ohm_Resistor   |
      | hk    | 50_Ohm_Resistor   |
      | sg    | 47_Ohm_Resistor   |
      | my    | 5k_Ohm_Resistor   |
      | en-TW | 5_Ohm_Resistor    |
      | nz    | 3k3_Ohm_Resistor  |
      | ph    | 30k_Ohm_Resistor  |
      | au    | 3k3_Ohm_Resistor  |
      | en-CN | 470_Ohm_Resistor  |
      | in    | 5_Ohm_Resistor    |
      | ph    | 30k_Ohm_Resistor  |
      | sg    | 330_Ohm_Resistor  |
      | en-CN | 33k_Ohm_Resistor  |
      | my    | 470k_Ohm_Resistor |
      | nz    | 4k7_Ohm_Resistor  |

    @nwk
    Examples: 
      | store  | category          |
      | us     | 470_Ohm_Resistor  |
      | en-MX  | 4k7_Ohm_Resistor  |
      | canada | 5k_Ohm_Resistor   |
      | en-MX  | 5_Ohm_Resistor    |
      | canada | 470k_Ohm_Resistor |
      | us     | 3k3_Ohm_Resistor  |
      | en-MX  | 33k_Ohm_Resistor  |
      | canada | 33k_Ohm_Resistor  |
      | en-MX  | 5k_Ohm_Resistor   |
      | canada | 3k3_Ohm_Resistor  |
      | us     | 30k_Ohm_Resistor  |
      | en-MX  | 330_Ohm_Resistor  |
      | us     | 47_Ohm_Resistor   |
      | canada | 47_Ohm_Resistor   |
      | en-MX  | 50_Ohm_Resistor   |
