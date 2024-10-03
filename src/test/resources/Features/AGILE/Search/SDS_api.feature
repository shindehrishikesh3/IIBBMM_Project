@Agile_Search @SearchAPI @API
Feature: Search and SOLR - API searches

  @SDS-813 @Sprint_80 @SDS-809 @Sprint_82 @web 
  Scenario Outline: read in list of searches and output a file with the count of results returned by those searches
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "usertype" user
    Then user reads in terms from file "<filename>" and collect counts with special chars in "<storename>" store

    @eu
    Examples: 
      | storename | filename                                 |
      | uk        | SearchKeywords//Regression_Keywords.xlsx |
      | uk        | SearchKeywords//Search_MPNs.xlsx         |

    @nwk
    Examples: 
      | storename | filename                                 |
      | us        | SearchKeywords//Regression_Keywords.xlsx |
      | us        | SearchKeywords//Search_MPNs.xlsx         |

    @apac
    Examples: 
      | storename | filename                                 |
      | sg        | SearchKeywords//Regression_Keywords.xlsx |
