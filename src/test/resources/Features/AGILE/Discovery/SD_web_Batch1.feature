@Agile_Discovery
Feature: Discovery - Enhancing customer satisfaction through User Experience Design

  Background: Launch homepage for Disovery functionalities check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @SD-2346 @Sprint_57
  Scenario: Verifying if request quote feature is removed for 4 Random Products in PDP page.
    Given I navigate to "browse-for-products" page
    And I wait for "3" seconds
    And I click on random product link and verify if request a quote feature link is removed
    And I wait for "5" seconds
    And I take screenshot

  @SD-1807 @Sprint_61
  Scenario: Verify promotional products WAS / NOW pricing on PDP buy box
    Given I enter "promotionProductCode" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
    When I click the "Header.searchIcon_button"
    Then Verify Was and Now prices on PDP buybox
    And I take screenshot

  #Author: Raji Kambar
  @SD_2536 @Sprint_63
  Scenario Outline: Verify Avnet Stock Link Removed
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I refresh browser
    And I verify the "Home.geoLocationNo_button" functionality if exists on page
    And User Navigates to PLP of store "<Store>" by searching "<SearchElement>"
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I verify element "PDP.avnetBox_element" is not visible in DOM

    Examples: 
      | Store | SearchElement                            | Product |
      | uk    | bridge-rectifier-diodes                  | 1611584 |
      | ro    | standard-single-colour-leds-under-75ma   | 2449822 |
      | bg    | fast-ultrafast-recovery-rectifier-diodes | 1843675 |
      | cz    | chip-smd-resistors                       | 9236708 |
      | hu    | bridge-rectifier-diodes                  | 1611584 |
      | si    | fast-ultrafast-recovery-rectifier-diodes | 1843675 |

  #Author: Raji Kambar
  @SD_2537 @Sprint_65
  Scenario Outline: CPC Data Correction
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I refresh browser
    And I verify the "Home.geoLocationNo_button" functionality if exists on page
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And User verify product info section on PDP of store "<Store>"
    And I scroll till "PDP.productInfoSection_text"
    And I wait for "5" seconds
    And I take screenshot

    Examples: 
      | Store  | Product |
      | cpc    | SC07296 |
      | cpc    | SC07492 |
      | cpc-ie | 2KBP08M |

  #Author: Raji Kambar
  #Applicable only for UK, US, AU (English Only)stores
  @SD_2209 @Sprint_66
  Scenario Outline: EAO Digital Product Selector
    And I click the "Home.manufacturers_link"
    And I click the "ManufacturePage.viewAllManufacturers_link"
    And I wait for "5" seconds
    And I click the "ManufacturePage.EAOManufacturer_link"
    And I wait for "5" seconds
    And I verify element "ManufacturerDetailsPage.EaoBanner_link" is visible in DOM
    And I click the "ManufacturerDetailsPage.EaoBanner_link"
    And verify current url contains "eao"
    And I wait for "5" seconds
    And I take screenshot
    And I switch back to parent window
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I verify element "ManufacturerDetailsPage.EaoBanner_link" is visible in DOM
    And I scroll till "ManufacturerDetailsPage.EaoBanner_link"
    And I wait for "3" seconds
    And I take screenshot
    And I wait for "2" seconds
    And User verify MPN in the URL on navigating to EAO Configurator Page from PDP of product "<Product>"
    And I wait for "5" seconds
    And I take screenshot

    @eu @apac
    Examples: 
      | Product |
      | 2770664 |
      | 2770666 |

    @us
    Examples: 
      | Product |
      | 45T6990 |

  #Author: Raji Kambar
  #Applicable only for Brazil Store
  @SD_2640 @Sprint_68
  Scenario Outline: Suppress NI products from Brazil
    And User navigates to url "<PLPURL>"
    And I verify element "PLP.addToCart_button" is not Clickable
    And I take screenshot
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I verify element "PDP.addtoOrder_link" is not Clickable
    And I scroll till "PDP.addtoOrder_link"
    And I take screenshot

    @NVE
    Examples: 
      | Store | PLPURL                                                            | Product |
      | pt-BR | https://www-ftprdus.newark.com/pt-BR/search/prl/results?brand=nve | 92K0619 |

    @NI
    Examples: 
      | Store | PLPURL                                                           | Product  |
      | pt-BR | https://www-ftprdus.newark.com/pt-BR/search/prl/results?brand=ni | 13AJ1678 |
      | pt-BR | https://www-ftprdus.newark.com/pt-BR/search/prl/results?brand=ni | 13AJ1681 |

  #Author: Raji Kambar
  #Applicable only for uk Store
  @SD_2845 @Sprint_73
  Scenario Outline: Banners on RaspberryPi
    And User navigates to url "<PLPURL>"
    And I take screenshot
    And I verify element "RaspberryPi.raspiBanner_image" is visible in DOM
    And I scroll till "RaspberryPi.raspiBanner3_link"
    And I take screenshot
    And I click on the embedded computers banner "RaspberryPi.raspiBanner3_link"
    And I wait for "5" seconds
    Then I verify current url contains "<EmbeddedBanner>"
    And I wait for "5" seconds
    And I take screenshot
    And I navigates back in the browser
    And I wait for "5" seconds
    And I scroll till "RaspberryPi.raspiBanner4_link"
    And I take screenshot
    And I click on the Micro:bit banner "RaspberryPi.raspiBanner4_link"
    And I wait for "5" seconds
    Then I verify current url contains "<Microbit>"
    And I wait for "5" seconds
    And I take screenshot
    And I navigates back in the browser
    And I wait for "5" seconds
    And I click on the BeagleBoard banner "RaspberryPi.raspiBanner5_link"
    And I wait for "5" seconds
    Then I verify current url contains "<BeagleBorad>"
    And I wait for "5" seconds
    And I take screenshot
    And I navigates back in the browser
    And I wait for "5" seconds
    And I scroll till "RaspberryPi.raspiBanner6_link"
    And I take screenshot
    And I click on the Hackster.io banner "RaspberryPi.raspiBanner6_link"
    And I wait for "5" seconds
    Then I verify current url contains "<HacksterIo>"
    And I wait for "5" seconds
    And I take screenshot
    And I navigates back in the browser
    And I wait for "5" seconds
    And I click on the Element14 community banner "RaspberryPi.raspiBanner7_link"
    And I wait for "5" seconds
    Then I verify current url contains "<Element14Comm>"
    And I wait for "5" seconds
    And I take screenshot
    And I navigates back in the browser
    And I wait for "5" seconds

    @FT
    Examples: 
      | PLPURL                                            | EmbeddedBanner                | Microbit                               | BeagleBorad                                     | HacksterIo  | Element14Comm           |
      | https://www-uk-ftprdeu.farnell.com/b/raspberry-pi | industrial-embedded-computers | bbc-microbit?searchref=searchlookahead | beaglebone?ost=beagle%20board&rd=beagle%20board | hackster.io | community.element14.com |

    @Live
    Examples: 
      | PLPURL                                | EmbeddedBanner                | Microbit                               | BeagleBorad                                     | HacksterIo  | Element14Comm           |
      | https://uk.farnell.com/b/raspberry-pi | industrial-embedded-computers | bbc-microbit?searchref=searchlookahead | beaglebone?ost=beagle%20board&rd=beagle%20board | hackster.io | community.element14.com |

  #Author: Raji Kambar
  #Applicable only on Italy
  @SD_2882 @Sprint_74
  Scenario Outline: Back Order Translations
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I refresh browser
    And I verify the "Home.geoLocationNo_button" functionality if exists on page
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And verify text "<Translation>" is visible for "PDPBuyBox.pdpBackOrder_text"
    And I verify text of Back order is Bold "PDPBuyBox.pdpBackOrder_text"

    Examples: 
      | Store | Product   | Translation                                                             |
      | it    |   2069339 | Attualmente non disponibile. Stock in arrivo la settimana a partire dal |
      | it    |   1843683 | Attualmente non disponibile. Stock in arrivo la settimana a partire dal |
      | en-IT | 2069339RL | Back order today stock arriving week commencing                         |

  #Applicable only on BE , NL
  @SD_2910 @Sprint_74
  Scenario Outline: Re-Reeling Translation Change
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    Given User navigates to url "<PLPURL>"
    And I refresh browser
    And I wait for "5" seconds
    And I scroll till "PLP.reReelCaution_text"
    And I wait for "2" seconds
    And I take screenshot
    And verify text "<Translations>" is visible for "PLP.reReelCaution_text"
    And I wait for "5" seconds
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And verify text "<Translations>" is visible for "PDPBuyBox.reReelCharges_text"
    And I scroll till "PDPBuyBox.reReelCharges_text"
    And I wait for "2" seconds
    And I take screenshot

    @FT
    Examples: 
      | Store | PLPURL                                                                                                                  | Product   | Translations                                                    |
      | nl    | https://www-nl-ftprdeu.farnell.com/w/search/prl/resultaten?packaging=rereel&st=reel                                     | 1469156RL | Voor dit product wordt een rereeling kost toegevoegd van € 5,00 |
      | nl-BE | https://www-be-ftprdeu.farnell.com/w/c/semiconductors-ics/power-management-ics-pmic/voltage-references?packaging=rereel | 2464416RL | Voor dit product wordt een rereeling kost toegevoegd van 5,00 € |

    @Live
    Examples: 
      | Store | PLPURL                                                                                                      | Product   | Translations                                                    |
      | nl    | https://nl.farnell.com/w/search/prl/resultaten?packaging=rereel&st=reel                                     | 1469156RL | Voor dit product wordt een rereeling kost toegevoegd van € 5,00 |
      | nl-BE | https://be.farnell.com/w/c/semiconductors-ics/power-management-ics-pmic/voltage-references?packaging=rereel | 2464416RL | Voor dit product wordt een rereeling kost toegevoegd van 5,00 € |

  #Applicable only on all Newark (US, Canada, Mexico and Brazil)
  @SD_2800 @Sprint_75
  Scenario Outline: Hazardous delivery message in Newark
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    Given User navigates to url "<PLPURL>"
    And I refresh browser
    And I wait for "5" seconds
    And I verify element "PLP.stockAvailability_link" is visible in DOM
    And I click on the Instock availability link "PLP.stockAvailability_link"
    And I wait for "2" seconds
    And I take screenshot
    And verify text "<Text>" is NOT visible for "PLP.toolTip_text"
    And I wait for "5" seconds
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I verify element "PDPBuyBox.samedayShipping_text" is not visible in DOM
    And I wait for "2" seconds
    And I take screenshot

    @FT
    Examples: 
      | Store  | PLPURL                                                                                                                                 | Product | Text              |
      | us     | https://www-ftprdus.newark.com/search?st=13c2&gs=true                                                                                  | 13C2846 | same day shipping |
      | pt-BR  | https://www-ftprdus.newark.com/pt-BR/c/semiconductors-ics/clock-timing-frequency-management/battery-ic?st=m4t32-br12s&showResults=true | 89K0824 | no mesmo dia      |
      | canada | https://www-canada-ftprdus.newark.com/c/batteries-chargers/batteries-non-rechargeable                                                  | 87F6408 | same day shipping |

    @Live
    Examples: 
      | Store | PLPURL                                                                                          | Product | Text              |
      | us    | https://www.newark.com/w/c/batteries-chargers/batteries-non-rechargeable?range=inc-in-stock     | 87F6402 | same day shipping |
      | pt-BR | https://www.newark.com/pt-BR/c/batteries-chargers/batteries-non-rechargeable?range=inc-in-stock | 53M2867 | no mesmo dia      |

  #Applicable only on UK
  @SD_3032 @Sprint_78
  Scenario Outline: Northern Ireland repeating delivery message PDP
    Given user navigate to "<Store>" store homepage and "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I refresh browser
    And I wait for "5" seconds
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I refresh browser
    And I wait for "5" seconds
    And verify text "<Text1>" is NOT visible for "PDPBuyBox.cutOffTimeA_text"
    And I wait for "5" seconds
    And I click on the search Icon button "PDPBuyBox.cutOffTimeTooltip_icon"
    And I wait for "10" seconds
    And verify text "<Text2>" is visible for "PDPBuyBox.tooltipContent_text"
    And I wait for "5" seconds
    And I take screenshot

    @FT
    Examples: 
      | Store | Product | Text1                  | Text2                   |
      | uk    | 1667878 | (Northern Ireland 6pm) | 6pm in Northern Ireland |
      | uk    | 2085346 | (Northern Ireland 6pm) | 6pm in Northern Ireland |

    @Live
    Examples: 
      | Store | Product | Text1                  | Text2                   |
      | uk    | 1282951 | (Northern Ireland 6pm) | 6pm in Northern Ireland |
      | uk    | 2319947 | (Northern Ireland 6pm) | 6pm in Northern Ireland |

  #Author: Raji Kambar
  @Sprint_83 @SD-3222
  Scenario Outline: Removal of best seller tag on PLP and PDP
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And I navigate to "<categoryPage>" page
    And I wait for "5" seconds
    And I verify element "PLP.bestSeller_element" is not visible in DOM
    And I take screenshot
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I verify element "PDPBuyBox.bestSeller_element" is not visible in DOM
    And I wait for "2" seconds
    And I take screenshot

    @eu
    Examples: 
      | store | categoryPage                                                                     | Product |
      | uk    | c/semiconductors-discretes/diodes?st=bav99&showResults=true                      | 1651159 |
      | de    | c/gleichrichter-transistoren-thyristoren-dioden/dioden?st=bav99&showResults=true | 2069339 |

    @nwk
    Examples: 
      | store  | categoryPage                                          | Product |
      | us     | w/search?st=bav99&pf_custSiteRedirect=true            | 67R2004 |
      | mexico | c/semiconductors-discretes/diodes/small-signal-diodes | 58M3990 |

    @apac
    Examples: 
      | store | categoryPage                                          | Product |
      | in    | c/semiconductors-discretes/diodes/small-signal-diodes | 1843683 |

  #Author: Raji Kambar
  @Sprint_85 @SD-3246
  Scenario Outline: Display NCNR Message on ALL Hazardous products EMEA
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And user clears text from textbox "Header.searchBox_textbox"
    And User enter the value "<Product>" in textbox "Header.searchBox_textbox"
    And I wait for "2" seconds
    And I verify element "Search.response_search" is visible in DOM
    And I click on the search Icon button "Header.searchIcon_button"
    And I wait for "5" seconds
    And I take screenshot
    And I wait for "2" seconds
    And verify text "<Text>" in page "PDPBuyBox.nCNR_text"
    And I wait for "2" seconds
    And I click on the Info Icon "PDPBuyBox.nCNRinfo_element"
    And I wait for "2" seconds
    And I take screenshot
    And I wait for "2" seconds
    And verify text "<InfoText>" in page "PDPBuyBox.nCNRinfotooltip_link"
    And I click on the tooltip link "PDPBuyBox.nCNRinfotooltip_link"
    And I wait for "5" seconds
    Then user verifies current url contains "terms-of-purchase"
    And I take screenshot
    And I wait for "2" seconds

    @eu
    Examples: 
      | store | Product | Text                                    | InfoText                                                                                         |
      | uk    | 1467740 | Non-Cancellable / Non Returnable        | Please review our Terms of Purchase warranty and guarantee for further details                   |
      | de    | 1467820 | Nicht stornierbar / nicht rückgabefähig | Für weitere Einzelheiten lesen Sie bitte unsere Verkaufsgarantie- und Gewährleistungsbedingungen |
      | fr    | 1391519 | Ni annulation ni retour possible        | Veuillez consulter nos conditions d'achat et de garantie pour plus de détails                    |
