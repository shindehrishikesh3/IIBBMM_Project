# Cucumber Automated Test for Premier Farnell

### Framework Design Approach

Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. Framework
has been built using Page Object Model and Page Factory. Page Object Model is a design pattern which has become popular
in test automation for enhancing test maintenance and reducing code duplication. Page Factory is an inbuilt Page Object
Model concept for Selenium WebDriver, but it is very optimized. With the help of PageFactory class, we use Repository_obj
class file store to find WebElement and use initElements method to initialize web elements. WebDriverManager library is used,
which allows to automate the management of the binary drivers (e.g. chromedriver, geckodriver, etc.) required by
Selenium WebDriver.

### Tools And Environment

1. Any IDE( Eclipse, IntelliJ, VStudio)
2. Java-8
3. Maven
4. Install Cucumber plugin in the respective IDE
5. Gitlab

If using Windows OS, Configure JAVA_HOME and MAVEN_HOME in the Environmental Variables : Follow the setup instructions
specified in here https://www.mkyong.com/maven/how-to-install-maven-in-windows/

### The project directory structure

The project has build scripts for Maven and below is describes the directory structure of the project

~~~~
src
  + main
    + Translation Files             To capture Non-English text in kep-value pair
    + Object Repository             To Store all the Web Elements
    + Headless web obj Repository   To Store web elements in headless pages
    + Properties File               To store valued for Environment and different users
    + Constants                     To store resuable values in step file
  + test
    + java
      + Common Utils, helper        Test runners and supporting code
      + Step Definitions            Steps defintion code
      + Pages			    Modular methods maintained per page
    + resources
      + features                    Feature files for Regression, BAU Projects and Agile
      + Test Data                   Test data across all the regions EU, APAC, NEWARK in excel sheet
          All featurefiles.feature
      runconfig.properties          This will help in running the test

~~~~

### **Executing the tests**

Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

**Step-1**: Clone the repository from  https://gitlab.com/premier-farnell/commerce.git

**Step-2**: Use the following maven commands to run the tests.

Run all tests (default: chrome and web)

~~~~

mvn clean test -Denv={envValue} -Dcucumber.filter.tags={scenario or feature to be executed} -Dtest={runner file to be executed} -DsiteUrl={website you want to launch} -DuserType={user you want to run} -DappName={application type (web/mobile)}

e.g
mvn clean test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DuserType=Guest -DappName=web
~~~~

Run all tests (default: chrome and web) by passing url and usertype from Examples of feature file

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DappName=web
~~~~

Run all UI tests with firefox

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DbrowserName=firefox -DuserType=Guest -DappName=web
~~~~

Run all UI tests with Edge

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DbrowserName=edge -DuserType=Guest
~~~~

Run all UI tests with Chrome or any browser as Headless

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DHeadless=true -DuserType=Guest
~~~~

Run all UI tests with Chrome or any browser with runner file to take Screenshot after everystep

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=Screenshot_After_Each_Step.java -DsiteUrl=https://uk.farnell.com/ -DuserType=Guest
~~~~

Run all tests (default: chrome and mobile)

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@mobsmoketest and @SearchLookAhead" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DappName=mobile -DuserType=Guest
~~~~

### **Features**

1. **Performance logging** : To enable performance logging in chrome browser, add @enablePerfLogs tag to the scenario.
Run a demo script

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@PerfLog" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DappName=web
~~~~

2. **Soft Assertions** :To add soft asserts in your tests, use this.context.softAssertions instead of  Assert.assert*. Run/Refer a test with softAsserts

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@homepagepdp" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DappName=web
~~~~

3. **Add Request Header** : Modheader extension is integrated in the framework. It works with Chrome and firefox browser. It is enabled using additional parameter 'request-header' through command-line. Refer a test execution command below:
Documentation - https://docs.modheader.com/advanced/selenium-webdriver

~~~~
mvn test -Denv=ft -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://www-uk-ftprdeu.farnell.com/ -DappName=web -browserName=chrome -Drequest-header=PF_ENABLE_ROUTING=true
~~~~

4. **Headless Updates** :For headless pages, the element locators are maintained in Repo_Headless_WEB_Objs and Repo_Headless_MOB_Objs.

	a. There is a slight change in locator value format in the hasmap. Format : *({locator key},{locatorType:LocatorString})*.
	Refer example below:

	     Repository_WEB_Objs: ("login_buttin","//*[@id='submitLogin']");

	     Repo_Headless_WEB_Objs: ("login_button","xpath:.//*[@data-testid='authentication.login.form__submit-button']");
	Possible values for *LocatorType* :{"xpath","css","id","className","tagName","linkText","partialLinkText","name"}

	This means we can add element locator string of any of the above type and not restricted to just xpaths.

	b. Headless side-by-side configuration is enabled for IEFT at the moment.

### Cucumber Test Reports

A Spark Dashboard HTML report is generated in `target/test-output/Spark` directory

Screenshots are captured in `target/test-output/screenshots` directory

~~~~
overview-features.html - The graphs show passing and failing statistics for features in web format
overview-steps.html    - The graph shows step statistics for this build
~~~~

Link to Download the Chrome Driver matching to your browser version:
https://chromedriver.chromium.org/downloads
