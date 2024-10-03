@agileRegression
Feature: Category Lister Page Tests

@clp @eu @apac @nwk
Scenario: Verifying a category lister page.
Given web site is launched successfully and user "does" accept the cookies
Then customer accesses the website as "userType" user
And I navigate to "c/automation-process-control/prl/results" page
And  User verify presence of categories section
Then I take screenshot.
Then Verify list of categories in category section
Then Verify the static header inside Category section
Then I Click on any link in category section
Then I take screenshot.
Then Verify the category images on category page
Then I take screenshot.
