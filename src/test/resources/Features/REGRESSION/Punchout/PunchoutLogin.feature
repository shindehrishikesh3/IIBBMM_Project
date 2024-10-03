@punchout @api
Feature: Punchout Login Smoke tests

    @cxml
    Scenario Outline: Scenario Outline name: cXML punchout login tests <store> <punchoutloginBody>
        Given "<store>" environment is setup
        When post "punchoutLogin" request for "cxml" protocol with body "<punchoutloginBody>"
        Then status code "200"
        And response body contains status code "200" and text "OK"
        And response body contains cxml login url
        When I open response url in browser in iframe
        And click "Punchout.launch_link"
        And I wait for "5" seconds
        And switch to "iframe_a" iframe
        And take screenshot
        Then accept all cookies if asked
        And take screenshot
	And I wait "medium" duration for "PunchoutHeader.companylogo_element" element to "appear"
        And verify element "PunchoutHeader.companylogo_element" is present on page
        And verify user "PunchoutHeader.userFirstName_text" is logged in
        And take screenshot
        @ft @uat @eu
        Examples:
            | store | punchoutloginBody                  |
            | uk    | punchoutloginBody.xml              |
            | uk    | PunchoutLoginBody_NonAnonymous.xml |

        @ft  @uat @apac
        Examples:
            | store | punchoutloginBody                  |
            | sg    | punchoutloginBody.xml              |
            | sg    | PunchoutLoginBody_NonAnonymous.xml |

        @ft @uat @nwk
        Examples:
            | store | punchoutloginBody                  |
            | us    | punchoutloginBody.xml              |
            | us    | PunchoutLoginBody_NonAnonymous.xml |

        @live @eu
        Examples:
            | store | punchoutloginBody     |
            | fr    | punchoutloginBody.xml |

        @live @apac
        Examples:
            | store | punchoutloginBody     |
            | au    | punchoutloginBody.xml |

        @live @nwk
        Examples:
            | store | punchoutloginBody                      |
            | us    | punchoutloginBody-POSR.xml             |
            | us    | punchoutloginBody-BOSE.xml             |
            | us    | punchoutloginBody-Signify.xml          |
            | us    | punchoutloginBody-Signify-Customer.xml |


    @oci
    Scenario Outline: OCI punchout login tests <store>
        Given "<store>" environment is setup
        When get punchoutSAPLogin url for "<companyType>" company with oci protocol
        When I open response url in browser in iframe
        And click "Punchout.launch_link"
        And I wait for "10" seconds
        And switch to "iframe_a" iframe
        And take screenshot
        Then accept all cookies if asked
        And take screenshot
        And verify element "PunchoutHeader.companylogo_element" is present on page
        And verify user "PunchoutHeader.userFirstName_text" is logged in
        And take screenshot
        @ft @uat @live @eu
        Examples:
            | store | companyType |
            | uk    | anonymous   |

        @ft @uat @apac
        Examples:
            | store |companyType |
            | sg    |anonymous   |

        @live @apac
        Examples:
            | store |companyType |
            | ph    |anonymous   |


        @ft @uat @live @nwk
        Examples:
            | store |companyType |
            | us    |anonymous   |
