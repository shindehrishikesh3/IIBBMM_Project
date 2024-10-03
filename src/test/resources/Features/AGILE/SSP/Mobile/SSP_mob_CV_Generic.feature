@mob @content
Feature: Content validations in Mobile

  #Author: Soumen Maity
  @Sprint76 @SSP1397 @mfr @live
  Scenario Outline: Ni content - storefront page in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<mfr>" manufacturer from json "ManufacturerContents_EN.json"
    And user wait "medium" duration for "ManufacturerDetailsPage.mfrContent_text" element to "appear"
    Then verify "<mfr>" manufacturer header for "ManufacturerDetailsPage.mfrContentHeader_text"
    And verify "<mfr>" manufacturer description with "ManufacturerDetailsPage.mfrContent_text"
    And take screenshot

    @eu
    Examples: 
      | store | mfr |
      | uk    | ni  |
      | en-DK | ni  |
      | en-PT | ni  |
      | en-HU | ni  |
      | ie    | ni  |
      | il    | ni  |
      | en-SK | ni  |
      | en-DE | ni  |
      | en-ES | ni  |

    @apac
    Examples: 
      | store | mfr |
      | en-CN | ni  |
      | in    | ni  |
      | sg    | ni  |
      | ph    | ni  |
      | en-TW | ni  |
      | my    | ni  |

    @nwk
    Examples: 
      | store  | mfr |
      | us     | ni  |
      | en-MX  | ni  |
      | canada | ni  |

  @pdp @sprint_82 @live @api @SSP-1441
  Scenario Outline: Popular Search content below Pagination in PDP for Mobile
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    When customer accesses the website as "guest" user
    And open "TITLE_LINK" url for "<pdp>" category from json "SSP_1441_PDP_Espot_Popular_Searches_EN_S82.json" in mobile
    And wait "medium" duration for "PDP.productTitle_text" element to "appear"
    And scroll down the page by pixels "1500"
    And I wait for "15" seconds
    Then verify text "Popular Searches" in page "PDP.popularSearchHeadingOfProduct_text"
    And verify "<pdp>" popular searches description with "PDP.popularSearchOfProduct_text" in mobile
    And verify hyperlinked text in the description with "PDP.popularSearchOfProduct_links" for Passive category "<pdp>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile

    @eu
    Examples: 
      | store   | pdp                        |
      | uk      | Boxes_SMD_Boxes1           |
      | en-CZ   | Boxes_Storage_Box          |
      | en-FR   | Assorter                   |
      | en-CH   | Boxes_SMD_Boxes2           |
      | ie      | Tool_Case                  |
      | il      | Storage_Cabinet1           |
      | en-IT   | Storage_Cabinet2           |
      | en-NL   | Storage_Cabinet3           |
      | en-SE   | Storage_Cabinet4           |
      | en-DE   | Storage_Cabinet5           |
      | en-BE   | Packaging_Tape             |
      | en-PL   | Tape_Conductive_Shielding1 |
      | en-NO   | Masking_Tape               |
      | en-ES   | Tape_Conductive_Shielding2 |
      | en-SE   | Tape_Conductive_Shielding3 |
      | en-FI   | Plug_Soldering_Iron1       |
      | en-DK   | Plug_Soldering_Iron2       |
      | onecall | Plug_Soldering_Iron3       |
      | export  | Plug_Soldering_Iron4       |
      | il      | Boxes_Storage_Box          |
      | en-NO   | Masking_Tape               |
      | en-SE   | Boxes_SMD_Boxes2           |
      | en-DE   | Tool_Case                  |
      | en-ES   | Storage_Cabinet2           |
      | en-PL   | Masking_Tape               |
      | en-NO   | Assorter                   |

    @apac
    Examples: 
      | store | pdp                        |
      | kr    | Boxes_Storage_Box          |
      | in    | Plug_Soldering_Iron2       |
      | sg    | Tool_Case                  |
      | ph    | Storage_Cabinet2           |
      | my    | Boxes_SMD_Boxes2           |
      | en-CN | Plug_Soldering_Iron4       |
      | nz    | Tape_Conductive_Shielding1 |
      | au    | Storage_Cabinet3           |
      | in    | Tape_Conductive_Shielding2 |
      | nz    | Boxes_SMD_Boxes1           |
      | en-TW | Plug_Soldering_Iron5       |
      | ph    | Plug_Soldering_Iron1       |
      | my    | Plug_Soldering_Iron2       |
      | en-CN | Tape_Conductive_Shielding3 |
      | th    | Plug_Soldering_Iron3       |
      | au    | Storage_Cabinet1           |
      | in    | Masking_Tape               |
      | my    | Assorter                   |
      | en-TW | Storage_Cabinet4           |
      | sg    | Storage_Cabinet5           |
      | in    | Boxes_SMD_Boxes2           |
      | en-CN | Tool_Case                  |
      | ph    | Boxes_Storage_Box          |
      | sg    | Plug_Soldering_Iron3       |
      | my    | Boxes_Storage_Box          |
      | en-CN | Packaging_Tape             |
      | tw    | Packaging_Tape             |

    @nwk
    Examples: 
      | store  | pdp                               |
      | us     | Packaging_Tape_Newark             |
      | en-MX  | Boxes_Storage_Box_Newark          |
      | canada | Plug_Soldering_Iron5_Newark       |
      | us     | Masking_Tape_Newark               |
      | en-MX  | Tape_Conductive_Shielding3_Newark |
      | us     | Tool_Case_Newark                  |
      | en-MX  | Storage_Cabinet4_Newark           |
      | canada | Boxes_SMD_Boxes1_Newark           |
      | us     | Plug_Soldering_Iron2_Newark       |
      | canada | Tape_Conductive_Shielding1_Newark |
      | us     | Packaging_Tape_Newark             |
      | us     | Storage_Cabinet2_Newark           |
      | en-MX  | Masking_Tape_Newark               |
      | canada | Tape_Conductive_Shielding2_Newark |
      | us     | Boxes_SMD_Boxes2_Newark           |
      | en-MX  | Plug_Soldering_Iron4_Newark       |
      | us     | Boxes_Storage_Box_Newark          |
      | en-MX  | Storage_Cabinet3_Newark           |
      | canada | Plug_Soldering_Iron1_Newark       |
      | us     | Boxes_SMD_Boxes1_Newark           |
      | canada | Plug_Soldering_Iron3_Newark       |
      | en-MX  | Tape_Conductive_Shielding2_Newark |
      | us     | Storage_Cabinet2_Newark           |
