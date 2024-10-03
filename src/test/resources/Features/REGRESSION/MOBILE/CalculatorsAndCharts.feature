@mobAgileRegression @mobValidationTests
Feature: Calculators & Conversion Charts page

@Calculators @eu @apac @nwk @live @api
Scenario: Calculators & Conversion Charts page and their listed product page verification
Given web site is launched successfully and user "does" accept the cookies
Then customer accesses the website as "userType" user
And I verify the "Home.geoLocationNo_button" functionality if exists on page
And user click on navigation bar "Home.navigationToggleBar_button"
And I scroll till "Home.resources_link"
And I wait for "2" seconds
Then I click on Resources "Home.resources_link"
And I click on CalculatorsAndCharts "Home.calculators_link"
And user wait "medium" duration for "CalcuatorsAndCharts.header_element" element to "appear"
And I wait for "4" seconds
And I take screenshot of Calcuators And Charts page
Then I verify all calculators are displaying
And I store urls of all the calculators 
Then I verify all the calculators are opening properly
When I click on company logo "Header.companylogo_element"
And I wait for "2" seconds
And I take screenshot of Home page
And I scroll till "CalcuatorsAndCharts.calculatorAndCharts_link"
And I take screenshot of Footer link on Home page
And I click on CalculatorsAndCharts "CalcuatorsAndCharts.calculatorAndCharts_link"
And user wait "medium" duration for "CalcuatorsAndCharts.header_element" element to "appear"
Then verify url parameter value as "calculators-conversion-tools"
And I take screenshot of Calcuators And Charts page