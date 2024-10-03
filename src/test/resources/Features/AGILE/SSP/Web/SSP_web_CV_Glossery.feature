@web @content @glossery
Feature: Content validations in Desktop

  #Author: Soumen Maity
  @Sprint66 @SSP1065 @live @api
  Scenario Outline: To verify contents of the engineering glossery pages <store> <glossery>
    Given user navigate to "<store>" store homepage and "does" accept the cookies
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S66.json"
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                        |
      | uk    | What is Acceptor Impurity       |
      | en-CZ | What is a Cable jacket          |
      | en-FR | What is a Paired cable          |
      | en-DE | What is Small-Scale Integration |
      | ie    | Z-parameters                    |
      | il    | What is Acceptor Impurity       |
      | en-IT | What is a Cable jacket          |
      | en-NL | What is a Paired cable          |
      | en-NO | What is Small-Scale Integration |
      | en-SE | Z-parameters                    |
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
    And open "TITLE_LINK" url for "<glossery>" glossery from json "GlosseryContent_S68.json"
    And wait "medium" duration for "TechnicalResources.glosseryContent_text" element to "appear"
    Then verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                              |
      | uk    | Band-Elimination Filter               |
      | en-CZ | Application specific standard product |
      | en-FR | Advanced very large-scale integration |
      | en-DE | Absolute Maximum Rating               |
      | ie    | Actuating force                       |
      | il    | Band-Elimination Filter               |
      | en-IT | Application specific standard product |
      | en-NL | Advanced very large-scale integration |
      | en-NO | Absolute Maximum Rating               |
      | en-SE | Actuating force                       |

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
      | uk    | Case Temperature           |
      | en-CZ | Half-Power Point           |
      | en-FR | IF Bandwidth               |
      | en-DE | Fast Time-Constant Circuit |
      | ie    | Case Temperature           |
      | il    | Gain-Bandwidth Product     |
      | en-IT | Half-Power Point           |
      | en-NL | Gain-Bandwidth Product     |
      | en-SE | IF Bandwidth               |
      | en-NO | Fast Time-Constant Circuit |

    @apac
    Examples:
      | store | glossery                   |
      | au    | Case Temperature           |
      | en-CN | Gain-Bandwidth Product     |
      | in    | Fast Time-Constant Circuit |
      | hk    | IF Bandwidth               |
      | sg    | Half-Power Point           |
      | my    | Gain-Bandwidth Product     |
      | en-TW | Case Temperature           |
      | nz    | Fast Time-Constant Circuit |
      | ph    | IF Bandwidth               |

    @nwk
    Examples:
      | store  | glossery                   |
      | us     | IF Bandwidth               |
      | en-MX  | Half-Power Point           |
      | canada | Case Temperature           |
      | canada | Gain-Bandwidth Product     |
      | us     | Fast Time-Constant Circuit |

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
      | us     | Gain-Bandwidth Product     |
      | en-MX  | IF Bandwidth               |
      | canada | Case Temperature           |
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
      | en-CZ | Tapped Resistor                 |
      | en-FR | What is Small-Scale Integration |
      | en-DE | Satellite Eclipse               |
      | il    | Tertiary Winding                |
      | en-IT | Temperature Sensor              |
      | en-NL | Tapped Resistor                 |
      | en-NO | What is Small-Scale Integration |
      | en-SE | Satellite Eclipse               |
      | en-CH | Tertiary Winding                |

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
    And verify "<glossery>" glossery description with "TechnicalResources.glosseryContent_text"
    And verify hyperlinked text in the description with "TechnicalResources.glosseryContentInner_links" for glossery "<glossery>" if any
    And verify response status code for hyperlinks is "200"
    And take screenshot

    @eu
    Examples:
      | store | glossery                    |
      | uk    | Multiplexing                |
      | en-CZ | What is a Paired cable      |
      | en-FR | Quiescent Power Consumption |
      | en-DE | Rack and Panel Connector    |
      | il    | Sampling rate               |
      | en-IT | Multiplexing                |
      | en-NL | What is a Paired cable      |
      | en-NO | Quiescent Power Consumption |
      | en-SE | Rack and Panel Connector    |
      | en-CH | Sampling rate               |

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
