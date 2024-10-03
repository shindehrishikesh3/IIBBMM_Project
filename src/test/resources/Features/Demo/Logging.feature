Feature: logging

  @Consolelogs
  Scenario: Get browser logs for a page
    Given web site is launched successfully and user "does" accept the cookies
    And I wait for "10" seconds
    Then I can see the log entry of the page

  @PerfLog @enablePerfLogs
  Scenario: Verify performance logs
    Given web site is launched successfully and user "does" accept the cookies
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call exists
