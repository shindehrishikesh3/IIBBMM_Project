@mob @content @glossery
Feature: Glossery content validations in Mobile

  #Author: Soumen Maity
  @Sprint66 @SSP1065 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S66.json" in mobile
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text" in mobile
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    And take screenshot

    @eu
    Examples:
      | store | glossery                        |
      | uk    | Z-parameters                    |
      | en-DK | What is Small-Scale Integration |
      | en-HU | What is a Paired cable          |
      | en-PT | What is a Cable jacket          |
      | en-SK | What is Acceptor Impurity       |
      | en-BE | Z-parameters                    |
      | en-PL | What is Small-Scale Integration |
      | en-FI | What is a Paired cable          |
      | en-ES | What is a Cable jacket          |
      | en-CH | What is Acceptor Impurity       |

    @apac
    Examples:
      | store | glossery                        |
      | au    | What is Acceptor Impurity       |
      | en-CN | What is a Cable jacket          |
      | in    | What is a Paired cable          |
      | hk    | What is Small-Scale Integration |
      | sg    | Z-parameters                    |
      | my    | What is Acceptor Impurity       |
      | en-TW | What is a Cable jacket          |
      | nz    | What is a Paired cable          |
      | ph    | What is Small-Scale Integration |

    @nwk
    Examples:
      | store  | glossery                        |
      | us     | What is Acceptor Impurity       |
      | en-MX  | What is a Cable jacket          |
      | canada | What is a Paired cable          |
      | us     | What is Small-Scale Integration |
      | canada | Z-parameters                    |

  #Author: Soumen Maity
  @Sprint68 @SSP1069 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S68.json" in mobile
    And wait "medium" duration for "TechnicalResources.glosseryContent_text" element to "appear"
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text" in mobile
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any in mobile
    And verify response status code for hyperlinks is "200" in mobile
    And take screenshot

    @eu
    Examples:
      | store | glossery                              |
      | uk    | Actuating force                       |
      | en-DK | Absolute Maximum Rating               |
      | en-HU | Advanced very large-scale integration |
      | en-PT | Application specific standard product |
      | en-SK | Advanced very large-scale integration |
      | en-BE | Actuating force                       |
      | en-PL | Absolute Maximum Rating               |
      | en-FI | Advanced very large-scale integration |
      | en-ES | Application specific standard product |
      | en-CH | Band-Elimination Filter               |

    @apac
    Examples:
      | store | glossery                              |
      | au    | Band-Elimination Filter               |
      | en-CN | Application specific standard product |
      | in    | Advanced very large-scale integration |
      | hk    | Absolute Maximum Rating               |
      | sg    | Actuating force                       |
      | my    | Band-Elimination Filter               |
      | en-TW | Application specific standard product |
      | nz    | Advanced very large-scale integration |
      | ph    | Absolute Maximum Rating               |

    @nwk
    Examples:
      | store  | glossery                              |
      | us     | Band-Elimination Filter               |
      | en-MX  | Application specific standard product |
      | canada | Advanced very large-scale integration |
      | us     | Absolute Maximum Rating               |
      | canada | Actuating force                       |

  #Author: Sandhya Seelam
  @Sprint69 @SSP1166 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S69.json"
    And wait "medium" duration for "TechnicalResources.glosseryContent_text" element to "appear"
    Then verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                   |
      | uk    | IF Bandwidth               |
      | en-CZ | Case Temperature           |
      | en-FR | Fast Time-Constant Circuit |
      | en-DE | IF Bandwidth               |
      | ie    | Case Temperature           |
      | il    | Gain-Bandwidth Product     |
      | en-IT | Half-Power Point           |
      | en-NL | Case Temperature           |
      | en-NO | Fast Time-Constant Circuit |
      | en-SE | Gain-Bandwidth Product     |

    @apac
    Examples:
      | store | glossery                   |
      #| au    | Fast Time-Constant Circuit |
      | en-CN | Case Temperature           |
      | in    | Half-Power Point           |
      | hk    | IF Bandwidth               |
      | sg    | Gain-Bandwidth Product     |
      | my    | Case Temperature           |
      | en-TW | Case Temperature           |
      | nz    | Fast Time-Constant Circuit |
      | ph    | Gain-Bandwidth Product     |

    @nwk
    Examples:
      | store  | glossery                   |
      | us     | Half-Power Point           |
      | en-MX  | Case Temperature           |
      | canada | IF Bandwidth               |
      | us     | Gain-Bandwidth Product     |
      | canada | Fast Time-Constant Circuit |

  #Author: Sandhya Seelam
  @Sprint69 @SSP1166 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S69.json"
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                   |
      | uk    | Fast Time-Constant Circuit |
      | en-CZ | Half-Power Point           |
      | en-FR | Gain-Bandwidth Product     |
      | en-DE | Case Temperature           |
      | ie    | Z-parameters               |
      | il    | IF Bandwidth               |
      | en-IT | Gain-Bandwidth Product     |
      | en-NL | Case Temperature           |
      | en-NO | Half-Power Point           |
      | en-SE | Fast Time-Constant Circuit |
      | en-CH | Case Temperature           |

    @apac
    Examples:
      | store | glossery                   |
      | au    | IF Bandwidth               |
      | en-CN | Gain-Bandwidth Product     |
      | in    | IF Bandwidth               |
      | hk    | Case Temperature           |
      | sg    | Half-Power Point           |
      | my    | Gain-Bandwidth Product     |
      | en-TW | Fast Time-Constant Circuit |
      | nz    | Case Temperature           |
      | ph    | IF Bandwidth               |

    @nwk
    Examples:
      | store  | glossery                   |
      | us     | Case Temperature           |
      | en-MX  | IF Bandwidth               |
      | canada | Gain-Bandwidth Product     |
      | us     | Fast Time-Constant Circuit |
      | canada | Half-Power Point           |

  @Sprint72 @SSP1238 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S72.json"
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                        |
      | uk    | Temperature Sensor              |
      | en-AT | Tapped Resistor                 |
      | en-HU | What is Small-Scale Integration |
      | en-DK | Satellite Eclipse               |
      | en-PT | Tertiary Winding                |
      | en-RO | Temperature Sensor              |
      | en-SK | Tapped Resistor                 |
      | en-PL | What is Small-Scale Integration |
      | en-BE | Satellite Eclipse               |
      | en-ES | Tertiary Winding                |

    @apac
    Examples:
      | store | glossery                        |
      | au    | Temperature Sensor              |
      | en-CN | Tapped Resistor                 |
      | in    | What is Small-Scale Integration |
      | hk    | Satellite Eclipse               |
      | sg    | Tertiary Winding                |
      | my    | Temperature Sensor              |
      | en-TW | Tapped Resistor                 |
      | nz    | What is Small-Scale Integration |
      | ph    | Satellite Eclipse               |

    @nwk
    Examples:
      | store  | glossery                        |
      | us     | Temperature Sensor              |
      | en-MX  | Tapped Resistor                 |
      | canada | What is Small-Scale Integration |
      | us     | Satellite Eclipse               |
      | canada | Tertiary Winding                |

  @Sprint73 @SSP1245 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S73.json"
    And I wait for "5" seconds
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                    |
      | uk    | Multiplexing                |
      | en-AT | What is a Paired cable      |
      | en-HU | Quiescent Power Consumption |
      | en-DK | Rack and Panel Connector    |
      | en-PT | Sampling rate               |
      | en-RO | Multiplexing                |
      | en-SK | What is a Paired cable      |
      | en-PL | Quiescent Power Consumption |
      | en-BE | Rack and Panel Connector    |
      | en-ES | Sampling rate               |

    @apac
    Examples:
      | store | glossery                    |
      | au    | Multiplexing                |
      | en-CN | What is a Paired cable      |
      | in    | Quiescent Power Consumption |
      | hk    | Rack and Panel Connector    |
      | sg    | Sampling rate               |
      | my    | Multiplexing                |
      | en-TW | What is a Paired cable      |
      | nz    | Quiescent Power Consumption |
      | ph    | Rack and Panel Connector    |

    @nwk
    Examples:
      | store  | glossery                        |
      | us     | Multiplexing (NEWARK)           |
      | en-MX  | What is a Paired cable (NEWARK) |
      | canada | Quiescent Power Consumption     |
      | us     | Rack and Panel Connector        |
      | canada | Sampling rate                   |
