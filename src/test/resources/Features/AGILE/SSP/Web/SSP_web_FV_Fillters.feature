@web @filter
Feature: Functional Validations for Filters on Desktop

    #Author: Soumen Maity
    @Sprint64 @SSP894 @ui
    Scenario Outline: To Verify in "<store>" Child categories with '/prl/results' should not contain a '/w/' when valuable
        Given user navigate to "<store>" store homepage and "does" accept the cookies
        When user clicks on "Header.searchIcon_button"
        And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
        Then select any random product link having "minimum" "10000" products as "L0" categories and click on it
        And user wait "medium" duration for "CategoryPage.category_list" element to "appear"
        And scroll till "CategoryPage.showAllProducts_button"
        Then clicks on "CategoryPage.showAllProducts_button" without wait
        And user wait "medium" duration for "PLP.PLP_element" element to "appear"
        And scroll till "Filters.manufacturerFilters_section"
        #----------positive scenario------------------
        When user select any valuable filter having minimum "300" products
        And clicks on "Filters.showResult_button"
        Then validates the child category links does not contains worthless tags
        #----------negetive scenario------------------
        And scroll till "Filters.clearAllFilters_link"
        Then clicks on "Filters.clearAllFilters_link" without wait
        But user select any non valuable filter having minimum "300" products
        And clicks on "Filters.showResult_button"
        Then validates the child category links contains worthless tags

        @eu @live
        Examples:
            | store |
            | uk    |
            | cz    |
            | dk    |
            | fr    |
            | de    |
            | hu    |
            | it    |
            | pl    |
            | pt    |
            | es    |
            | tr    |

        @apac @live
        Examples:
            | store |
            | au    |
            | cn    |
            | in    |
            | kr    |
            | sg    |
            | th    |

        @nwk @live
        Examples:
            | store  |
            | pt-BR  |
            | canada |
            | mexico |
            | us     |
            | es-us  |

    @PLP @Sprint77 @SSP1434 @live
    Scenario Outline: H1s on brand & category Filter URLs in "<store>"
        Given user navigate to "<store>" store homepage and "does" accept the cookies
        Then customer accesses the website as "guest" user
        When user clicks on "Header.searchIcon_button"
        And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
        Then select any random product link having "maximum" "100" products as "L1" categories and click on it
        And user wait "medium" duration for "PLP.header_text" element to "appear"
        And I save the PLP category name in the PLP page
        #----------Positive scenario------------------
        And I wait for "2" seconds
        When user select any valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        Then user validates PLP page header when a "single valueable" filter is selected
        And I wait for "2" seconds
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "disappear"
        #----------Negative scenario #1------------------
        When user select any valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        And user again select any valuable filter having minimum "2" products
        And I wait for "2" seconds
        Then user validates PLP page header when "multiple valueable" filters are selected
        And I wait for "2" seconds
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "disappear"
        #----------Negative scenario #2------------------
        When user select any non valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        Then user validates PLP page header when "a non valueable" filter is selected
        And I wait for "2" seconds
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "disappear"

        @eu
        Examples:
            | store |
            | uk    |
            | fr    |
            | de    |
            | it    |

        @apac
        Examples:
            | store |
            | au    |
            | sg    |
            | cn    |
            | in    |

        @nwk
        Examples:
            | store  |
            | us     |
            | canada |
            | mexico |

    @PLP @Sprint78 @SSP1449 @live
    Scenario Outline: "<store>" - Extend breadcrumb navigation trail for filter URLs
        Given user navigate to "<store>" store homepage and "does" accept the cookies
        Then customer accesses the website as "guest" user
        When user clicks on "Header.searchIcon_button"
        And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
        Then select any random product link having "maximum" "100" products as "L1" categories and click on it
        And user wait "medium" duration for "PLP.header_text" element to "appear"
        And I save the PLP category name in the PLP page
        #----------Positive scenario #1------------------
        When user select any valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        Then validates only self referencing link in breadcrumb is displaying as text
        And validates the breadcrumb when single valuable filter is selected
        And user take screenshot
        Then validates applied filters are removed while clicking on previous breadcrumb link
        And user take screenshot
        #----------Positive scenario #2------------------
        When user select any valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        And user select any parametric valuable filter having minimum "2" products
        And wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        Then validates only self referencing link in breadcrumb is displaying as text
        And validates the breadcrumb when multiple valuable filter is selected and result page is not worthless
        And user take screenshot
        #----------Negative scenario #1------------------
        Then user again select any valuable filter having minimum "2" products
        And I wait for "2" seconds
        Then validates only self referencing link in breadcrumb is displaying as text
        And validates the breadcrumb when multiple valuable filter is selected and result page is worthless
        And user take screenshot
        Then user clears filter if clear link available
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "disappear"
        #----------Negative scenario #2------------------
        When user select any non valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        Then validates only self referencing link in breadcrumb is displaying as text
        And validates the breadcrumb when a non valuable filter is selected
        And user take screenshot

        @eu
        Examples:
            | store |
            | uk    |
            | fr    |
            | de    |
            | it    |

        @apac
        Examples:
            | store |
            | au    |
            | sg    |
            | cn    |
            | in    |

        @nwk
        Examples:
            | store  |
            | us     |
            | canada |
            | mexico |

    @PLP @Sprint78 @SSP1474 @live
    Scenario Outline: "<store>" - Update breadcrumb schema markup for filter URLs
        Given user navigate to "<store>" store homepage and "does" accept the cookies
        Then customer accesses the website as "guest" user
        When user clicks on "Header.searchIcon_button"
        And user wait "medium" duration for "BrowseForProducts.allProducts_links" element to "appear"
        Then select any random product link having "maximum" "100" products as "L1" categories and click on it
        And user wait "medium" duration for "PLP.header_text" element to "appear"
        #----------Positive scenario #1------------------
        When user select any valuable filter having minimum "2" products
        And user wait "medium" duration for "PLP.appliedFilter_element" element to "appear"
        And I wait for "2" seconds
        And validates breadcrumb schema is updated as per applied filter
        #----------Positive scenario #2------------------
        And user select any parametric valuable filter having minimum "2" products
        And I wait for "2" seconds
        And validates breadcrumb schema is updated as per applied filter
        # #----------Negative scenario------------------
        Then user again select any valuable filter having minimum "2" products
        And I wait for "2" seconds
        And validates breadcrumb schema is updated as per applied filter

        @eu
        Examples:
            | store |
            | uk    |
            | fr    |
            | de    |
            | it    |

        @apac
        Examples:
            | store |
            | au    |
            | sg    |
            | cn    |
            | in    |

        @nwk
        Examples:
            | store  |
            | us     |
            | canada |
            | mexico |