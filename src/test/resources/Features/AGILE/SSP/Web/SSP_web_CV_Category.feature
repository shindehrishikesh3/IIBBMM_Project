@web @content @category
Feature: Category content validations in Desktop

  #Author: Soumen Maity
  @Sprint65 @Sprint66 @SSP1061 @SSP1062 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN.json"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                        |
      | uk    | Aerials                                         |
      | en-CZ | AC / DC LED Power Supplies                      |
      | en-FR | AC / DC DIN Rail Mount Power Supplies           |
      | en-DE | AC / DC External Plug In Adaptor Power Supplies |
      | ie    | AC / DC Enclosed Power Supplies                 |
      | il    | Batteries - Non-Rechargeable                    |
      | en-IT | Threadlock & Retaining Compounds                |
      | en-NL | Batteries & Chargers                            |
      | en-NO | Batteries - Rechargeable                        |
      | en-SE | Chemicals & Adhesives                           |
      | en-CH | Battery Accessories                             |
      | uk    | Back & Mounting Boxes                           |
      | en-CZ | Attenuators                                     |
      | en-FR | Antennas – RFID                                 |
      | en-DE | Antenna Mounting Kits                           |
      | ie    | Bell Boxes                                      |
      | il    | Battery Holders                                 |
      | en-IT | Battery contacts – modular                      |
      | en-NL | Battery Contacts                                |
      | en-NO | Battery Chargers                                |
      | en-SE | Battery Accessories                             |

    @apac
    Examples: 
      | store | category                   |
      | au    | Battery Accessories        |
      | en-CN | Back & Mounting Boxes      |
      | in    | Attenuators                |
      | hk    | Antennas – RFID            |
      | sg    | Antenna Mounting Kits      |
      | my    | Bell Boxes                 |
      | en-TW | Battery Holders            |
      | nz    | Battery contacts – modular |
      | ph    | Battery Contacts           |
      | au    | Battery Chargers           |

    @nwk
    Examples: 
      | store  | category                   |
      | us     | Battery Accessories        |
      | en-MX  | Back & Mounting Boxes      |
      | canada | Attenuators                |
      | us     | Antennas – RFID            |
      | canada | Antenna Mounting Kits      |
      | us     | Bell Boxes                 |
      | en-MX  | Battery Holders            |
      | canada | Battery contacts – modular |
      | us     | Battery Contacts           |
      | canada | Battery Chargers           |

  #Author: Sandhya Seelam
  @Sprint69 @SSP1135 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_Sprint69.json"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                                                |
      | uk    | Chemical Assortments and Kits                                           |
      | en-CZ | DC / DC Converters - LED Driver                                         |
      | en-FR | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | en-DE | DC / DC Converters - LED Driver                                         |
      | ie    | Chemical Assortments and Kits                                           |
      | il    | Detectors/Sensors                                                       |
      | en-IT | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | en-NL | Chemical Assortments and Kits                                           |
      | en-NO | Detectors/Sensors                                                       |
      | en-SE | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |
      | en-CH | DC / DC Converters - LED Driver                                         |
      | uk    | Chemical Assortments and Kits                                           |
      | en-CZ | DC / DC Converters - LED Driver                                         |
      | en-FR | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | en-DE | Detectors/Sensors                                                       |
      | ie    | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |
      | il    | DC / DC Converters - LED Driver                                         |
      | en-IT | C / DC Converters - Modules / DIN Rail / Front End                      |
      | en-NL | Chemical Assortments and Kits                                           |
      | en-NO | Detectors/Sensors                                                       |
      | en-SE | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |

    @apac
    Examples: 
      | store | category                                                                |
      | au    | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |
      | en-CN | DC / DC Converters - LED Drivers                                        |
      | in    | Chemical Assortments and Kits                                           |
      | hk    | Detectors/Sensors                                                       |
      | sg    | DC / DC Converters - LED Driver                                         |
      | my    | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | en-TW | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | nz    | Chemical Assortments and Kits                                           |
      | ph    | Detectors/Sensors                                                       |
      | au    | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |

    @nwk
    Examples: 
      | store  | category                                                                |
      | us     | Chemical Assortments and Kits                                           |
      | en-MX  | Detectors/Sensors                                                       |
      | canada | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |
      | us     | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | canada | DC / DC Converters - LED Driver                                         |
      | us     | Chemical Assortments and Kits                                           |
      | en-MX  | DC / DC Converters - Non Isolated Point of Load (POL) Adjustable Output |
      | canada | Detectors/Sensors                                                       |
      | us     | DC / DC Converters - Modules / DIN Rail / Front End                     |
      | canada | Chemical Assortments and Kits                                           |

  @Sprint71 @SSP1163 @SSP1164 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S71.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category            |
      | uk    | Electromagnetic     |
      | en-CZ | Earthing            |
      | en-FR | Dusters             |
      | en-CH | Domestic Switches   |
      | ie    | Developers          |
      | il    | Locks & Accessories |
      | en-IT | Line Reactors       |
      | en-NL | Line Conditioners   |
      | en-SE | Latches             |

    @apac
    Examples: 
      | store | category            |
      | au    | Developers          |
      | en-CN | Domestic Switches   |
      | in    | Earthing            |
      | au    | Dusters             |
      | sg    | Line Conditioners   |
      | ph    | Electromagnetic     |
      | en-TW | Locks & Accessories |
      | my    | Latches             |
      | nz    | Line Reactors       |

    @nwk
    Examples: 
      | store  | category          |
      | us     | Domestic Switches |
      | en-MX  | Earthing          |
      | canada | Dusters           |
      | us     | Electromagnetic   |
      | canada | Latches           |
      | en-MX  | Line Reactors     |
      | canada | Line Conditioners |

  @Sprint73 @SSP1247 @SSP1166 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S73.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                        |
      | uk    | Potting Compounds               |
      | en-CZ | Steel Cable                     |
      | en-FR | Security – Alarm Access Control |
      | en-CH | Steel Cable                     |
      | ie    | Potting Compounds               |
      | il    | Security – Alarm Access Control |
      | en-IT | Potting Compounds               |
      | en-NL | Steel Cable                     |
      | en-SE | Potting Compounds               |
      | en-DE | Security – Alarm Access Control |
      | en-IT | Surge Protectors                |
      | en-ES | Steel Cable                     |
      | en-CH | Ferric Chloride                 |
      | ie    | Hasp/Staple                     |
      | en-FR | Surge Protectors                |
      | il    | Ferric Chloride                 |
      | en-IT | Key Cabinets & Storage          |
      | uk    | Hasp/Staple                     |
      | en-CZ | Key Cabinets & Storage          |
      | en-FR | Ferric Chloride                 |
      | en-CH | Hasp/Staple                     |
      | ie    | Fillers                         |
      | uk    | Surge Protectors                |

    @apac
    Examples: 
      | store | category                        |
      | au    | Security – Alarm Access Control |
      | en-CN | Key Cabinets & Storage          |
      | in    | Potting Compounds               |
      | au    | Ferric Chloride                 |
      | sg    | Potting Compounds               |
      | in    | Surge Protectors                |
      | ph    | Hasp/Staple                     |
      | en-TW | Security – Alarm Access Control |
      | my    | Fillers                         |
      | nz    | Key Cabinets & Storage          |
      | in    | Hasp/Staple                     |
      | au    | Key Cabinets & Storage          |
      | sg    | Hasp/Staple                     |
      | my    | Surge Protectors                |
      | au    | Fillers                         |
      | en-TW | Key Cabinets & Storage          |
      | my    | Hasp/Staple                     |
      | en-CN | Potting Compounds               |
      | nz    | Security – Alarm Access Control |
      | in    | Key Cabinets & Storage          |
      | en-TW | Surge Protectors                |

    @nwk
    Examples: 
      | store  | category                        |
      | us     | Potting Compounds               |
      | en-MX  | Security – Alarm Access Control |
      | canada | Potting Compounds               |
      | us     | Potting Compounds               |
      | en-MX  | Security – Alarm Access Control |
      | canada | Fillers                         |
      | us     | Key Cabinets & Storage          |
      | en-MX  | Fillers                         |
      | canada | Key Cabinets & Storage          |
      | us     | Hasp/Staple                     |
      | canada | Fillers                         |
      | en-MX  | Hasp/Staple                     |

  @Sprint73 @SSP1312 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S73.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category  |
      | uk    | USB C     |
      | en-CZ | USB C 3.1 |
      | en-FR | USB C 3.1 |
      | en-CH | USB C     |
      | ie    | USB C 3.1 |
      | il    | USB C 3.1 |
      | en-IT | USB C     |
      | en-NL | USB C 3.1 |
      | en-SE | USB C     |

    @apac
    Examples: 
      | store | category  |
      | au    | USB C     |
      | en-CN | USB C 3.1 |
      | in    | USB C     |
      | au    | USB C     |
      | sg    | USB C 3.1 |
      | ph    | USB C     |
      | en-TW | USB C 3.1 |
      | my    | USB C     |
      | nz    | USB C 3.1 |

    @nwk
    Examples: 
      | store  | category  |
      | us     | USB C     |
      | en-MX  | USB C 3.1 |
      | canada | USB C 3.1 |
      | us     | USB C 3.1 |
      | en-MX  | USB C     |

  #Author: Soumen Maity
  @Sprint74 @SSP1346 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S74.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.specificCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category     |
      | uk    | Raspberry PI |
      | en-CZ | Raspberry PI |
      | en-FR | Raspberry PI |
      | en-CH | Raspberry PI |
      | ie    | Raspberry PI |
      | il    | Raspberry PI |
      | en-IT | Raspberry PI |
      | en-NL | Raspberry PI |
      | en-SE | Raspberry PI |

    @apac
    Examples: 
      | store | category     |
      | au    | Raspberry PI |
      | en-CN | Raspberry PI |
      | in    | Raspberry PI |
      | au    | Raspberry PI |
      | sg    | Raspberry PI |
      | ph    | Raspberry PI |
      | en-TW | Raspberry PI |
      | my    | Raspberry PI |
      | nz    | Raspberry PI |

    @nwk
    Examples: 
      | store  | category            |
      | us     | Raspberry PI NEWARK |
      | en-MX  | Raspberry PI NEWARK |
      | canada | Raspberry PI NEWARK |

  @Sprint74 @SSP1285 @SSP1294 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S74.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                               |
      | uk    | Lubricants, Greases & Cutting Fluids   |
      | en-CZ | Paints & Coatings                      |
      | en-FR | Padlocks                               |
      | en-CH | Paints & Coatings                      |
      | ie    | Photoelectric/Infrared                 |
      | uk    | PIR – Wired                            |
      | en-IT | Linear Power Supplies                  |
      | en-NL | Power Supplies - Uninterruptible (UPS) |
      | en-SE | Linear Power Supplies                  |
      | en-DE | Torches                                |
      | en-IT | Lubricants, Greases & Cutting Fluids   |
      | en-ES | Photoelectric/Infrared                 |
      | en-CH | Padlocks                               |
      | uk    | Paints & Coatings                      |
      | en-FR | Photoelectric/Infrared                 |
      | il    | PIR – Wired                            |
      | en-NL | Linear Power Supplies                  |
      | uk    | Power Supplies - Uninterruptible (UPS) |
      | en-CZ | PIR – Wired                            |
      | en-FR | Torches                                |
      | en-CH | Lubricants, Greases & Cutting Fluids   |
      | ie    | Paints & Coatings                      |
      | uk    | Padlocks                               |

    @apac
    Examples: 
      | store | category                               |
      | au    | Lubricants, Greases & Cutting Fluids   |
      | en-CN | Paints & Coatings                      |
      | in    | Padlocks                               |
      | au    | Paints & Coatings                      |
      | sg    | Photoelectric/Infrared                 |
      | in    | PIR – Wired                            |
      | ph    | Linear Power Supplies                  |
      | en-CN | Power Supplies - Uninterruptible (UPS) |
      | my    | PIR – Wired                            |
      | nz    | Torches                                |
      | in    | Lubricants, Greases & Cutting Fluids   |
      | au    | Photoelectric/Infrared                 |
      | sg    | Padlocks                               |
      | my    | Paints & Coatings                      |
      | ph    | Photoelectric/Infrared                 |
      | au    | PIR – Wired                            |
      | sg    | Linear Power Supplies                  |
      | my    | Power Supplies - Uninterruptible (UPS) |
      | en-CN | PIR – Wired                            |
      | nz    | Torches                                |
      | my    | Lubricants, Greases & Cutting Fluids   |
      | in    | Photoelectric/Infrared                 |
      | en-TW | Padlocks                               |

    @nwk
    Examples: 
      | store  | category                               |
      | us     | Lubricants, Greases & Cutting Fluids   |
      | en-MX  | Paints & Coatings                      |
      | canada | Padlocks                               |
      | us     | Paints & Coatings                      |
      | canada | Photoelectric/Infrared                 |
      | en-MX  | PIR – Wired                            |
      | canada | Linear Power Supplies                  |
      | us     | Power Supplies - Uninterruptible (UPS) |
      | en-MX  | Linear Power Supplies                  |
      | canada | Flashlights                            |
      | canada | Lubricants, Greases & Cutting Fluids   |
      | en-MX  | Photoelectric/Infrared                 |
      | us     | Padlocks                               |

  @Sprint75 @SSP1367 @SSP1370 @live @api
  Scenario Outline: To verify contents of the category pages <store> <category>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S75.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                                  |
      | uk    | Cameras                                                   |
      | en-CZ | Ceiling Roses and Lampholders                             |
      | en-FR | Cleaners                                                  |
      | en-CH | DC / DC Converters - Linear Regulator Drop In Replacement |
      | ie    | DC to DC Converters                                       |
      | uk    | DC/AC Inverters                                           |
      | en-IT | DC / DC Converters - External Plug In Adaptor             |
      | en-CH | Cameras                                                   |
      | en-SE | Ceiling Roses and Lampholders                             |
      | en-DE | Cleaners                                                  |
      | en-IT | DC / DC Converters - Linear Regulator Drop In Replacement |
      | en-ES | DC to DC Converters                                       |
      | en-CH | DC/AC Inverters                                           |
      | uk    | DC / DC Converters - External Plug In Adaptor             |
      | en-FR | Cameras                                                   |
      | il    | Ceiling Roses and Lampholders                             |
      | en-NL | Cleaners                                                  |
      | uk    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | en-CZ | DC to DC Converters                                       |
      | en-FR | DC/AC Inverters                                           |
      | en-CH | DC / DC Converters - External Plug In Adaptor             |
      | ie    | Cameras                                                   |
      | uk    | Ceiling Roses and Lampholders                             |

    @apac
    Examples: 
      | store | category                                                  |
      | en-CN | Cleaners                                                  |
      | in    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | au    | DC to DC Converters                                       |
      | sg    | DC/AC Inverters                                           |
      | in    | DC / DC Converters - External Plug In Adaptor             |
      | au    | Cleaners                                                  |
      | ph    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | en-CN | DC to DC Converters                                       |
      | my    | DC/AC Inverters                                           |
      | nz    | DC / DC Converters - External Plug In Adaptor             |
      | in    | Cleaners                                                  |
      | au    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | sg    | DC to DC Converters                                       |
      | my    | DC/AC Inverters                                           |
      | ph    | DC / DC Converters - External Plug In Adaptor             |
      | au    | Cleaners                                                  |
      | sg    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | my    | DC to DC Converters                                       |
      | en-CN | DC/AC Inverters                                           |
      | nz    | DC / DC Converters - External Plug In Adaptor             |
      | my    | Cleaners                                                  |
      | in    | DC / DC Converters - Linear Regulator Drop In Replacement |
      | en-TW | DC to DC Converters                                       |

    @nwk
    Examples: 
      | store  | category                                                  |
      | us     | Cleaners                                                  |
      | us     | DC / DC Converters - Linear Regulator Drop In Replacement |
      | us     | DC/AC Inverters                                           |
      | us     | DC / DC Converters - External Plug In Adaptor             |
      | canada | Cleaners                                                  |
      | canada | DC / DC Converters - Linear Regulator Drop In Replacement |
      | canada | DC/AC Inverters                                           |
      | canada | DC / DC Converters - External Plug In Adaptor             |
      | en-MX  | Cleaners                                                  |
      | en-MX  | DC / DC Converters - Linear Regulator Drop In Replacement |
      | en-MX  | DC/AC Inverters                                           |
      | en-MX  | DC / DC Converters - External Plug In Adaptor             |

  @Sprint76 @SSP1404 @SSP1395 @live @api
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S76.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                              |
      | uk    | Test Equipment Software               |
      | en-CZ | Signal Generators & Counters          |
      | en-FR | NI Training Courses                   |
      | en-CH | NI Signal generators and counters     |
      | il    | NI Calibration services               |
      | en-IT | NI Controllers                        |
      | en-NL | NI Data Acquisition & Control Modules |
      | en-SE | Calibration Services                  |
      | uk    | NI Control Accessories                |
      | uk    | NI Test Equipment Software            |

    @apac
    Examples: 
      | store | category                              |
      | au    | Test Equipment Software               |
      | en-CN | Signal Generators & Counters          |
      | in    | NI Training Courses                   |
      | sg    | NI Signal generators and counters     |
      | sg    | NI Calibration services               |
      | en-TW | NI Controllers                        |
      | my    | NI Data Acquisition & Control Modules |
      | sg    | Calibration Services                  |
      | sg    | NI Control Accessories                |
      | sg    | NI Test Equipment Software            |

    @nwk
    Examples: 
      | store  | category                              |
      | us     | Test Equipment Software               |
      # | en-MX  | Signal Generators & Counters          |
      | canada | NI Training Courses                   |
      | us     | NI Signal generators and counters     |
      | canada | NI Calibration services               |
      | us     | NI Controllers                        |
      | en-MX  | NI Data Acquisition & Control Modules |
      | canada | Calibration Services                  |
      | us     | NI Control Accessories                |
      | us     | NEWARK NI Test Equipment Software     |

  @Sprint77 @SSP1442 @SSP1450 @SSP1451 @live @api
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S77.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                 |
      | uk    | controller-accessories                   |
      | en-CZ | controllers                              |
      | en-FR | data-acquistion-control-modules          |
      | en-CH | trainings-courses                        |
      | ie    | modules                                  |
      | il    | controller-accessories                   |
      | en-IT | controllers                              |
      | en-NL | data-acquistion-control-modules          |
      | en-SE | trainings-courses                        |
      | en-DE | modules                                  |
      | en-IT | controller-accessories                   |
      | en-ES | controllers                              |
      | uk    | microcontrollers                         |
      | en-CZ | embedded-development-kits                |
      | en-FR | cable-assemblies                         |
      | en-CH | Embedded Single Board Computers - SBC    |
      | ie    | Embedded Single Board Computers -SBC- Pi |
      | il    | embedded-development-kit-accessories     |
      | en-IT | microcontrollers                         |
      | en-NL | embedded-development-kits                |
      | en-SE | cable-assemblies                         |
      | en-DE | Embedded Single Board Computers - SBC    |
      | en-IT | Embedded Single Board Computers -SBC- Pi |
      | en-ES | embedded-development-kit-accessories     |

    @apac
    Examples: 
      | store | category                                 |
      | au    | trainings-courses                        |
      | en-CN | controllers                              |
      | in    | data-acquistion-control-modules          |
      | sg    | trainings-courses                        |
      | ph    | modules                                  |
      | my    | controller-accessories                   |
      | nz    | trainings-courses                        |
      | au    | microcontrollers                         |
      | en-CN | embedded-development-kits                |
      | in    | cable-assemblies                         |
      | sg    | Embedded Single Board Computers - SBC    |
      | ph    | Embedded Single Board Computers -SBC- Pi |
      | my    | embedded-development-kit-accessories     |
      | nz    | microcontrollers                         |
      | in    | embedded-development-kits                |
      | sg    | cable-assemblies                         |
      | ph    | Embedded Single Board Computers - SBC    |
      | my    | Embedded Single Board Computers -SBC- Pi |
      | nz    | embedded-development-kit-accessories     |

    @nwk
    Examples: 
      | store  | category                                 |
      | us     | controller-accessories                   |
      | en-MX  | controllers                              |
      | canada | data-acquistion-control-modules          |
      | us     | trainings-courses                        |
      | us     | Embedded Single Board Computers - SBC    |
      | en-MX  | embedded-development-kits                |
      | canada | embedded-development-kit-accessories     |
      | us     | Embedded Single Board Computers - SBC    |
      | us     | Embedded Single Board Computers -SBC- Pi |
      | en-MX  | embedded-development-kit-accessories     |

  @Sprint78 @SSP1481 @SSP1482 @live @api
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S78.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                             |
      | uk    | Analogue Switches                    |
      | en-CZ | Drivers & Controllers                |
      | en-FR | IC Temperature Sensors               |
      | en-CH | Real Time Clocks                     |
      | ie    | RS232, RS485, RS422 Transceivers     |
      | il    | Embedded Development Kit Accessories |
      | en-IT | Supervisors & Monitors               |
      | en-NL | Voltage References                   |
      | en-SE | Voltage Regulators                   |
      | en-DE | Analogue Switches                    |
      | en-IT | Drivers & Controllers                |
      | en-ES | IC Temperature Sensors               |
      | uk    | Real Time Clocks                     |
      | en-CZ | RS232, RS485, RS422 Transceivers     |
      | en-FR | Embedded Development Kit Accessories |
      | en-CH | Supervisors & Monitors               |
      | ie    | Voltage References                   |
      | il    | Voltage Regulators                   |
      | en-IT | Analogue Switches                    |
      | en-NL | Drivers & Controllers                |
      | en-SE | IC Temperature Sensors               |
      | en-DE | Real Time Clocks                     |
      | en-IT | RS232, RS485, RS422 Transceivers     |
      | en-ES | Embedded Development Kit Accessories |
      | uk    | Supervisors & Monitors               |
      | en-CZ | Voltage References                   |
      | en-FR | Voltage Regulators                   |

    @apac
    Examples: 
      | store | category                             |
      | au    | Analogue Switches                    |
      | en-CN | Drivers & Controllers                |
      | in    | IC Temperature Sensors               |
      | sg    | Real Time Clocks                     |
      | ph    | RS232, RS485, RS422 Transceivers     |
      | my    | Embedded Development Kit Accessories |
      | nz    | Supervisors & Monitors               |
      | au    | Voltage References                   |
      | en-CN | Voltage Regulators                   |
      | in    | Analogue Switches                    |
      | sg    | Drivers & Controllers                |
      | ph    | IC Temperature Sensors               |
      | my    | Real Time Clocks                     |
      | nz    | RS232, RS485, RS422 Transceivers     |
      | in    | Embedded Development Kit Accessories |
      | sg    | Supervisors & Monitors               |
      | ph    | Voltage References                   |
      | my    | Voltage Regulators                   |

    @nwk
    Examples: 
      | store  | category                             |
      | us     | Analog Switches                      |
      | en-MX  | Drivers & Controllers                |
      | canada | IC Temperature Sensors               |
      | us     | Real Time Clocks                     |
      | us     | Embedded Development Kit Accessories |
      | en-MX  | Supervisors & Monitors               |
      | canada | Voltage References                   |
      | us     | Voltage Regulators                   |
      | canada | Analog Switches                      |
      | us     | Drivers & Controllers                |
      | en-MX  | IC Temperature Sensors               |
      | canada | Real Time Clocks                     |
      | en-MX  | Embedded Development Kit Accessories |
      | canada | Supervisors & Monitors               |
      | us     | Voltage References                   |
      | en-MX  | Voltage Regulators                   |

  @Sprint79 @SSP1509 @SSP1510 @SSP1511 @live @api
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S79.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.categoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.categoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                            |
      | uk    | antennas-dual-band-chip             |
      | en-CZ | antennas-single-band-chip           |
      | en-FR | capacitors                          |
      | en-CH | emc-rfi-suppression                 |
      | ie    | filters                             |
      | il    | potentiometers-trimmers-accessories |
      | en-IT | resistors-fixed-value               |
      | en-NL | rheostats                           |
      | en-SE | inductors                           |
      | en-DE | charging-coil-arrays                |
      | en-IT | charging-coils                      |
      | en-ES | antennas-dual-band-chip             |
      | uk    | antennas-single-band-chip           |
      | en-CZ | capacitors                          |
      | en-FR | emc-rfi-suppression                 |
      | en-CH | filters                             |
      | ie    | potentiometers-trimmers-accessories |
      | il    | resistors-fixed-value               |
      | en-IT | rheostats                           |
      | en-NL | inductors                           |
      | en-SE | charging-coil-arrays                |
      | en-DE | charging-coils                      |
      | en-IT | antennas-dual-band-chip             |
      | en-ES | antennas-single-band-chip           |
      | uk    | capacitors                          |
      | en-CZ | emc-rfi-suppression                 |
      | en-FR | filters                             |
      | uk    | potentiometers-trimmers-accessories |
      | en-CZ | resistors-fixed-value               |
      | en-FR | rheostats                           |
      | en-CH | inductors                           |
      | ie    | charging-coil-arrays                |
      | il    | charging-coils                      |

    @apac
    Examples: 
      | store | category                            |
      | au    | antennas-dual-band-chip             |
      | en-CN | antennas-single-band-chip           |
      | in    | capacitors                          |
      | sg    | emc-rfi-suppression                 |
      | ph    | filters                             |
      | my    | potentiometers-trimmers-accessories |
      | nz    | resistors-fixed-value               |
      | au    | rheostats                           |
      | en-CN | inductors                           |
      | in    | charging-coil-arrays                |
      | sg    | charging-coils                      |
      | ph    | antennas-dual-band-chip             |
      | my    | antennas-single-band-chip           |
      | nz    | capacitors                          |
      | in    | emc-rfi-suppression                 |
      | sg    | filters                             |
      | ph    | potentiometers-trimmers-accessories |
      | my    | resistors-fixed-value               |
      | nz    | rheostats                           |
      | sg    | inductors                           |
      | en-CN | charging-coil-arrays                |
      | in    | charging-coils                      |

    @nwk
    Examples: 
      | store  | category                            |
      | us     | antennas-dual-band-chip             |
      | en-MX  | antennas-single-band-chip           |
      | canada | capacitors                          |
      | us     | emc-rfi-suppression                 |
      | en-MX  | filters                             |
      | canada | potentiometers-trimmers-accessories |
      | us     | resistors-fixed-value               |
      | en-MX  | rheostats                           |
      | canada | inductors                           |
      | us     | charging-coil-arrays                |
      | en-MX  | charging-coils                      |
      | canada | antennas-dual-band-chip             |
      | us     | antennas-single-band-chip           |
      | en-MX  | capacitors                          |
      | canada | emc-rfi-suppression                 |
      | us     | filters                             |
      | en-MX  | potentiometers-trimmers-accessories |
      | canada | resistors-fixed-value               |
      | us     | rheostats                           |
      | en-MX  | inductors                           |
      | canada | charging-coil-arrays                |
      | us     | charging-coils                      |

  @sprint_80 @live @api @SSP-1550 @SSP-1551 @SSP-1565 @SSP-1566
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S80.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                               |
      | uk    | Axial Leaded Power Inductors           |
      | en-CZ | Power Inductors                        |
      | en-FR | Radial Leaded Power Inductors          |
      | en-CH | RF Inductors                           |
      | ie    | SMD Power Inductors                    |
      | il    | Coupled Inductors                      |
      | en-IT | Fixed Value Inductors                  |
      | en-NL | High Frequency Inductors               |
      | en-SE | Inductor Kits & Assortments            |
      | en-DE | Power Factor Correction Chokes         |
      | uk    | Air Core Inductors                     |
      | en-CZ | Axial Leaded High Frequency Inductors  |
      | en-FR | Multilayer Inductors                   |
      | en-CH | Radial Leaded High Frequency Inductors |
      | ie    | Thin Film Inductors                    |
      | il    | Common Mode Chokes / Filters           |
      | en-IT | EMI Noise Filters                      |
      | en-NL | Ferrites & Ferrite Assortments         |
      | en-SE | Filtered IEC Power Entry Modules       |
      | en-DE | Wirewound Inductors                    |

    @apac
    Examples: 
      | store | category                               |
      | au    | Axial Leaded Power Inductors           |
      | en-CN | Power Inductors                        |
      | in    | Radial Leaded Power Inductors          |
      | sg    | RF Inductors                           |
      | ph    | SMD Power Inductors                    |
      | my    | Coupled Inductors                      |
      | nz    | Fixed Value Inductors                  |
      | en-CN | Inductor Kits & Assortments            |
      | in    | Power Factor Correction Chokes         |
      | au    | Air Core Inductors                     |
      | en-CN | Axial Leaded High Frequency Inductors  |
      | in    | Multilayer Inductors                   |
      | sg    | Radial Leaded High Frequency Inductors |
      | ph    | Thin Film Inductors                    |
      | my    | Common Mode Chokes / Filters           |
      | nz    | EMI Noise Filters                      |
      | au    | Ferrites & Ferrite Assortments         |
      | en-CN | Filtered IEC Power Entry Modules1      |
      | in    | Wirewound Inductors1                   |

    @nwk
    Examples: 
      | store  | category                               |
      | us     | Axial Leaded Power Inductors           |
      | en-MX  | Power Inductors                        |
      | canada | Radial Leaded Power Inductors          |
      | us     | RF Inductors                           |
      | en-MX  | SMD Power Inductors                    |
      | canada | Coupled Inductors                      |
      | us     | Fixed Value Inductors                  |
      | canada | Inductor Kits & Assortments            |
      | us     | Power Factor Correction Chokes         |
      | us     | Air Core Inductors                     |
      | en-MX  | Axial Leaded High Frequency Inductors  |
      | canada | Multilayer Inductors1                  |
      | us     | Radial Leaded High Frequency Inductors |
      | en-MX  | Thin Film Inductors1                   |
      | canada | Common Mode Chokes / Filters           |
      | us     | EMI Noise Filters                      |
      | en-MX  | Ferrites & Ferrite Assortments         |
      | canada | Filtered IEC Power Entry Modules2      |
      | us     | Wirewound Inductors2                   |

  @sprint_81 @live @api @SSP-1592 @SSP-1593
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S81.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                     |
      | uk    | Integrated Passive Filters   |
      | en-CZ | Power Line Filters           |
      | en-FR | RF Filters                   |
      | en-CH | SAW Filters                  |
      | ie    | Shielding Gaskets & Material |
      | il    | Diplexers                    |
      | en-IT | Duplexers                    |
      | en-NL | Feedthrough Capacitors       |
      | en-SE | Filters - Kits & Assortments |
      | en-DE | Infrared Filters             |

    @apac
    Examples: 
      | store | category                     |
      | au    | Integrated Passive Filters   |
      | in    | Power Line Filters1          |
      | sg    | RF Filters                   |
      | ph    | SAW Filters                  |
      | my    | Shielding Gaskets & Material |
      | en-CN | Diplexers                    |
      | nz    | Duplexers                    |
      | au    | Feedthrough Capacitors       |
      | in    | Filters - Kits & Assortments |
      | il    | Infrared Filters             |

    @nwk
    Examples: 
      | store  | category                     |
      | us     | Integrated Passive Filters   |
      | en-MX  | Power Line Filters2          |
      | canada | RF Filters                   |
      | us     | SAW Filters                  |
      | en-MX  | Shielding Gaskets & Material |
      | us     | Diplexers                    |
      | en-MX  | Duplexers                    |
      | canada | Feedthrough Capacitors       |
      | us     | Filters - Kits & Assortments |
      | canada | Infrared Filters             |

  @sprint_82 @live @api @SSP-1631 @SSP-1632
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S82.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                          |
      | uk    | Aluminium Electrolytic Capacitors |
      | en-CZ | Capacitor Kits & Assortments      |
      | en-FR | Ceramic Capacitors                |
      | en-CH | Film Capacitors                   |
      | ie    | Mica Capacitors                   |
      | il    | Niobium Oxide Capacitors          |
      | en-IT | Polymer Capacitors                |
      | en-NL | RF Capacitors                     |
      | en-SE | Silicon Capacitors                |
      | en-DE | Supercapacitors                   |
      | uk    | Supercapacitors                   |
      | en-CZ | Silicon Capacitors                |
      | en-FR | RF Capacitors                     |
      | en-CH | Polymer Capacitors                |
      | ie    | Niobium Oxide Capacitors          |
      | il    | Mica Capacitors                   |
      | en-IT | Film Capacitors                   |
      | en-NL | Ceramic Capacitors                |
      | en-SE | Capacitor Kits & Assortments      |
      | en-DE | Aluminium Electrolytic Capacitors |

    @apac
    Examples: 
      | store | category                          |
      | au    | Aluminium Electrolytic Capacitors |
      | in    | Capacitor Kits & Assortments      |
      | sg    | Ceramic Capacitors                |
      | ph    | Film Capacitors                   |
      | my    | Mica Capacitors                   |
      | en-CN | Niobium Oxide Capacitors          |
      | nz    | Polymer Capacitors                |
      | au    | RF Capacitors                     |
      | il    | Supercapacitors                   |
      | au    | Supercapacitors                   |
      | sg    | RF Capacitors                     |
      | ph    | Polymer Capacitors                |
      | my    | Niobium Oxide Capacitors          |
      | en-CN | Mica Capacitors                   |
      | nz    | Film Capacitors                   |
      | au    | Ceramic Capacitors                |
      | in    | Capacitor Kits & Assortments      |
      | il    | Aluminium Electrolytic Capacitors |

    @nwk
    Examples: 
      | store  | category                          |
      | us     | Aluminium Electrolytic Capacitors |
      | en-MX  | Capacitor Kits & Assortments      |
      | canada | Ceramic Capacitors                |
      | us     | Film Capacitors                   |
      | en-MX  | Mica Capacitors                   |
      | us     | Niobium Oxide Capacitors          |
      | en-MX  | Polymer Capacitors                |
      | canada | RF Capacitors                     |
      | canada | Supercapacitors                   |
      | us     | Supercapacitors                   |
      | us     | RF Capacitors                     |
      | us     | Polymer Capacitors                |
      | en-MX  | Niobium Oxide Capacitors          |
      | us     | Mica Capacitors                   |
      | en-MX  | Film Capacitors                   |
      | en-MX  | Ceramic Capacitors                |
      | us     | Capacitor Kits & Assortments      |
      | canada | Aluminium Electrolytic Capacitors |

  @sprint_83 @live @api @SSP-1661 @SSP-1662 @SSP-1670
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S83.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                             |
      | uk    | Digital Display Potentiometers       |
      | en-CZ | Linear Motion Potentiometers         |
      | en-FR | Potentiometer Accessories            |
      | en-CH | Potentiometer Dials                  |
      | ie    | Rotary Potentiometers                |
      | il    | Slide Potentiometers                 |
      | en-IT | Tantalum Capacitors                  |
      | en-NL | Transmission Line MIM Capacitors     |
      | en-SE | Trimmer Capacitors                   |
      | en-DE | Trimmer Potentiometers               |
      | uk    | Chip SMD Resistors                   |
      | en-CZ | Current Sense SMD Resistors          |
      | en-FR | Current Sense Through Hole Resistors |
      | en-CH | Fixed Network Resistors              |
      | ie    | Fixed Precision Resistor Networks    |

    @apac
    Examples: 
      | store | category                             |
      | au    | Digital Display Potentiometers       |
      | in    | Linear Motion Potentiometers         |
      | sg    | Potentiometer Accessories            |
      | ph    | Potentiometer Dials                  |
      | my    | Rotary Potentiometers                |
      | en-CN | Slide Potentiometers                 |
      | nz    | Tantalum Capacitors                  |
      | au    | Transmission Line MIM Capacitors     |
      | il    | Trimmer Capacitors                   |
      | au    | Trimmer Potentiometers               |
      | sg    | Chip SMD Resistors                   |
      | ph    | Current Sense SMD Resistors          |
      | my    | Current Sense Through Hole Resistors |
      | en-CN | Fixed Network Resistors              |
      | nz    | Fixed Precision Resistor Networks    |

    @nwk
    Examples: 
      | store  | category                             |
      | us     | Digital Display Potentiometers       |
      | en-MX  | Linear Motion Potentiometers         |
      | canada | Potentiometer Accessories            |
      | us     | Potentiometer Dials                  |
      | en-MX  | Rotary Potentiometers                |
      | us     | Slide Potentiometers                 |
      | en-MX  | Tantalum Capacitors                  |
      | canada | Transmission Line MIM Capacitors     |
      | canada | Trimmer Capacitors                   |
      | us     | Trimmer Potentiometers               |
      | us     | Chip SMD Resistors                   |
      | us     | Current Sense SMD Resistors          |
      | en-MX  | Current Sense Through Hole Resistors |
      | us     | Fixed Network Resistors              |
      | en-MX  | Fixed Precision Resistor Networks    |

  @sprint_84 @live @api @SSP-1690
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S84.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                        |
      | uk    | MELF SMD Resistors              |
      | en-CZ | Panel / Chassis Mount Resistors |
      | en-FR | Resistor Accessories            |
      | en-CH | Resistor Kits & Assortments     |
      | ie    | RF Resistors                    |
      | il    | MELF SMD Resistors              |
      | en-IT | Panel / Chassis Mount Resistors |
      | en-NL | Resistor Accessories            |
      | en-SE | Resistor Kits & Assortments     |
      | en-DE | RF Resistors                    |

    @apac
    Examples: 
      | store | category                        |
      | au    | MELF SMD Resistors              |
      | in    | Panel / Chassis Mount Resistors |
      | sg    | Resistor Accessories            |
      | ph    | Resistor Kits & Assortments     |
      | my    | RF Resistors                    |
      | en-CN | MELF SMD Resistors              |
      | nz    | Panel / Chassis Mount Resistors |
      | au    | Resistor Accessories            |
      | il    | Resistor Kits & Assortments     |
      | au    | RF Resistors                    |

    @nwk
    Examples: 
      | store  | category                        |
      | us     | MELF SMD Resistors              |
      | en-MX  | Panel / Chassis Mount Resistors |
      | canada | Resistor Accessories            |
      | us     | Resistor Kits & Assortments     |
      | en-MX  | RF Resistors                    |
      | us     | MELF SMD Resistors              |
      | en-MX  | Panel / Chassis Mount Resistors |
      | canada | Resistor Accessories            |
      | canada | Resistor Kits & Assortments     |
      | us     | RF Resistors                    |

  @sprint_85 @live @api @SSP-1738 @SSP-1739
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_EN_S85.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                   |
      | uk    | Cylindrical Core Ferrites                  |
      | en-CZ | Ferrite Assortments                        |
      | en-FR | Radial Leaded Common Mode Chokes / Filters |
      | en-CH | SMD Common Mode Chokes / Filters           |
      | ie    | SMD Toroidal Inductors                     |
      | il    | Through Hole Resistors                     |
      | en-IT | Through Hole Toroidal Inductors            |
      | en-NL | Toroidal Inductors                         |
      | en-SE | Zero Ohm Network Resistors                 |
      | en-DE | Zero Ohm Resistors                         |

    @apac
    Examples: 
      | store | category                                   |
      | au    | Cylindrical Core Ferrites                  |
      | in    | Ferrite Assortments                        |
      | sg    | Radial Leaded Common Mode Chokes / Filters |
      | ph    | SMD Common Mode Chokes / Filters           |
      | my    | SMD Toroidal Inductors                     |
      | en-CN | Through Hole Resistors                     |
      | nz    | Through Hole Toroidal Inductors            |
      | au    | Toroidal Inductors                         |
      | il    | Zero Ohm Network Resistors                 |
      | au    | Zero Ohm Resistors                         |

    @nwk
    Examples: 
      | store  | category                                   |
      | us     | Cylindrical Core Ferrites                  |
      | en-MX  | Ferrite Assortments                        |
      | canada | Radial Leaded Common Mode Chokes / Filters |
      | us     | SMD Common Mode Chokes / Filters           |
      | en-MX  | SMD Toroidal Inductors                     |
      | canada | Through Hole Resistors                     |
      | us     | Through Hole Toroidal Inductors            |
      | en-MX  | Toroidal Inductors1                        |
      | canada | Zero Ohm Network Resistors                 |
      | us     | Zero Ohm Resistors                         |

  @sprint_86 @live @api @SSP-1760 @SSP-1761
  Scenario Outline: Verify new content of <category> in <store>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_NativeLang_S86.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples: 
      | store | category                                                 |
      | uk    | Ferrite Beads                                            |
      | en-CZ | Ferrite Tiles                                            |
      | en-FR | Flat Cable Core Ferrites                                 |
      | en-CH | Split Core Ferrites                                      |
      | ie    | Capacitor Arrays                                         |
      | il    | Hybrid Polymer Aluminium Electrolytic Capacitors         |
      | en-IT | Leaded Aluminium Electrolytic Capacitors                 |
      | en-NL | Leaded MLCC Multilayer Ceramic Capacitors                |
      | en-SE | SMD Aluminium Electrolytic Capacitors                    |
      | en-DE | Snap In/Screw Terminal Aluminium Electrolytic Capacitors |

    @apac
    Examples: 
      | store | category                                                 |
      | au    | Ferrite Beads                                            |
      | in    | Ferrite Tiles                                            |
      | sg    | Flat Cable Core Ferrites                                 |
      | ph    | Split Core Ferrites                                      |
      | my    | Capacitor Arrays                                         |
      | en-CN | Hybrid Polymer Aluminium Electrolytic Capacitors         |
      | nz    | Leaded Aluminium Electrolytic Capacitors                 |
      | au    | Leaded MLCC Multilayer Ceramic Capacitors                |
      | il    | SMD Aluminium Electrolytic Capacitors                    |
      | au    | Snap In/Screw Terminal Aluminium Electrolytic Capacitors |

    @nwk
    Examples: 
      | store  | category                                                 |
      | us     | Ferrite Beads                                            |
      | en-MX  | Ferrite Tiles                                            |
      | canada | Flat Cable Core Ferrites                                 |
      | us     | Split Core Ferrites                                      |
      | en-MX  | Capacitor Arrays                                         |
      | canada | Hybrid Polymer Aluminium Electrolytic Capacitors         |
      | us     | Leaded Aluminium Electrolytic Capacitors                 |
      | en-MX  | Leaded MLCC Multilayer Ceramic Capacitors                |
      | canada | SMD Aluminium Electrolytic Capacitors                    |
      | us     | Snap In/Screw Terminal Aluminium Electrolytic Capacitors |

  @sprint_86 @live @api @SSP-1796
  Scenario Outline: Verify content added for Categories in Native language for German,Spanish,Italian and French stores
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<category>" category from json "CategoryContents_NativeLang_S86.json"
    And user wait "medium" duration for "CategoryPage.categoryPLP_label" element to "appear"
    And verify "<category>" category description with "CategoryPage.altCategoryContent_text"
    And verify hyperlinked text in the description with "CategoryPage.altCategoryContentURL_link" for category "<category>" if any
    And verify innerlinks are doesnot contain "/w/"
    And verify response status code for hyperlinks is "200"
    And take screenshot
    And scroll down the page by pixels "400"
    And take screenshot
    And scroll down the page by pixels "400"
    And take screenshot

    @eu
    Examples: 
      | store | category                    |
      | de    | Rheostate                   |
      | de    | Festwiderstände             |
      | de    | Kondensatoren               |
      | de    | Induktivitäten              |
      | at    | Rheostate                   |
      | at    | Festwiderstände             |
      | at    | Kondensatoren               |
      | at    | Rheostate                   |
      | ch    | Induktivitäten              |
      | ch    | Festwiderstände             |
      | ch    | Kondensatoren               |
      | ch    | Rheostate                   |
      | it    | Reostati                    |
      | it    | Resistori a valore fisso    |
      | it    | Induttori                   |
      | it    | Condensatori                |
      | fr    | Condensateurs               |
      | fr    | Rhéostats                   |
      | fr    | Résistances – Valeur fixe   |
      | fr    | Inductances                 |
      | es    | Resistencias: de valor fijo |
      | es    | Reóstatos                   |
      | es    | Condensadores               |
      | es    | Inductores                  |
      | fr-CH | Condensateurs               |
      | fr-BE | Rhéostats                   |
      | fr-BE | Résistances – Valeur fixe   |
      | fr-CH | Inductances                 |
      | fr-BE | Condensateurs               |
      | fr-CH | Rhéostats                   |

    @nwk
    Examples: 
      | store  | category                          |
      | es-us  | Resistencias: de valor fijo       |
      | es-us  | Reóstatos                         |
      | es-us  | Condensadores_Newark_ES           |
      | es-us  | Inductores_Newark_ES              |
      | fr-CA  | Condensateurs_Canada_FR           |
      | fr-CA  | Rhéostats_Canada_FR               |
      | mexico | Condensadores_Newark_ES           |
      | mexico | Inductores_Newark_ES              |
      | fr-CA  | Résistances_Valeur_fixe_Canada_FR |
      | fr-CA  | Inductances_Canada_FR             |
      | mexico | Resistencias: de valor fijo       |
      | mexico | Reóstatos                         |
