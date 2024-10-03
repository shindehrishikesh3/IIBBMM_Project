package StepDefinition.WEB;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;


public class RegisterSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    
    private static final Logger logger = LogManager.getLogger(RegisterSteps.class);

    public RegisterSteps(ContextStore context) {
        this.context = context;
    }

    @And("user enter details on the registration page with {string} as {string}")
    public void user_enter_details_on_the_registration_page_with_field(String field, String value) throws Exception {
    String path = "";
    String emailAddress = null;
    String fieldValue = value;

    if (appName.equalsIgnoreCase("mobile")) {
        path = FilePath + "MobileRegistration.xlsx";
    } else {
        path = FilePath + "Registration.xlsx";
    }

    List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
    String password = this.context.constants.getPassword();
    String fullName = testData.get(0).get("fullName");
    String personTitle = testData.get(0).get("personTitle");
    String firstName = testData.get(0).get("firstName");
    String lastName = testData.get(0).get("lastName");
    String phoneNumber = testData.get(0).get("phoneNumber");
    String phoneExtNumber = testData.get(0).get("phoneExtNumber");
    String country = testData.get(0).get("country");
    String companyName = testData.get(0).get("companyName");
    String vatRegistrationNumber = testData.get(0).get("vatRegistrationNumber");
    String salesTax = testData.get(0).get("salesTax");
    String primaryJob = testData.get(0).get("primaryJob");
    String primaryUse = testData.get(0).get("primaryUse");
    String accountNumber = testData.get(0).get("accountNumber");
    String mobileNumber = testData.get(0).get("mobileNumber");
    String contactYou = testData.get(0).get("contactYou");
    String accountType = testData.get(0).get("accountType");
    String username = actionMethods.generateRandomNumberString(testData.get(0).get("username"));
    emailAddress = username + this.context.constants.getEmailDomain();

    if (appName.equalsIgnoreCase("mobile")) {
        actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(), "Login.login_element");
        actionMethods.click("Login.loginTitle_text");
        actionMethods.click("Login.registerNow_button");
    }

    actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(), "Register.registerTitle_text");
    Thread.sleep(5000);
    actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
    context.scenario.log("Email for new user: " + emailAddress);
    this.context.currentUser = emailAddress;

    actionMethods.enterText(password, "Register.password_textbox");
    context.scenario.log("Password for new user: " + password);

    if (!(accountType.equalsIgnoreCase("skip") || fullName == null)) {
        actionMethods.click("Register.businessAccount_radio");
    }

    if (!(fullName == null || fullName.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(fullName, "Register.fullName_textbox");
    }

    if (!(personTitle == null || personTitle.equalsIgnoreCase("skip"))) {
        actionMethods.selectValueByIndex(1, "Register.title_dropdown");
    }

    if (!(firstName == null || firstName.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(firstName, "Register.firstName_textbox");
    }

    if (!(lastName == null || lastName.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(lastName, "Register.lastName_textbox");
    }

    if (!(phoneNumber == null || phoneNumber.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");
    }

    if (!(phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");
    }

    if (!(fieldValue == null || fieldValue.equalsIgnoreCase("skip"))) {
        if (field.equalsIgnoreCase("zipcode")) {
            actionMethods.enterText(fieldValue, "Register.postalCode_textbox");
        } else if (field.equalsIgnoreCase("phonenumber")) {
        	actionMethods.clearText("Register.phoneNumber_textbox");
            actionMethods.enterText(fieldValue, "Register.phoneNumber_textbox");
        }
    }

    if (!(country == null || country.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(country, "Register.country_dropdown");
    }

    if (!(companyName == null || companyName.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(companyName, "Register.companyName_textbox");
    }

    if (!(vatRegistrationNumber == null || vatRegistrationNumber.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");
    }

    if (!(salesTax == null || salesTax.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(salesTax, "Register.salesTax_textbox");
    }

    if (!(primaryJob == null || primaryJob.equalsIgnoreCase("skip"))) {
        actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");
    }

    if (!(primaryUse == null || primaryUse.equalsIgnoreCase("skip"))) {
        actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");
    }

    if (!(accountNumber == null || accountNumber.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");
    }

    if (!(mobileNumber == null || mobileNumber.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
    }

    if (!(contactYou == null || contactYou.equalsIgnoreCase("skip"))) {
        actionMethods.enterText(contactYou, "Register.contactYou_textbox");
    }

    if (appName.equalsIgnoreCase("web")) {
        if (getStore().equalsIgnoreCase("kr")) {
            actionMethods.click("Register.consent_checkbox");
        }
    }

    if (appName.equalsIgnoreCase("mobile")) {
        actionMethods.click("Register.register_button");
    }
    }

        @And("^customer registers and login to the website without activation$")
        public void customer_registers_and_login_to_the_website()  throws Exception {

        	 String path = "";

                 if (appName.equalsIgnoreCase("mobile")) {
                     path = FilePath + "MobileRegistration.xlsx";
                 } else path = FilePath + "Registration.xlsx";
             List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

             actionMethods.click("Register.register_link");

             if (appName.equalsIgnoreCase("mobile")) {
                 actionMethods.waitForElementToAppear(
                     this.context.constants.getMediumWaitSeconds(),
                     "Login.login_element"
                 );
                 actionMethods.click("Login.loginTitle_text");
                 actionMethods.click("Login.registerNow_button");
             }
             actionMethods.waitForElementToAppear(
                 this.context.constants.getLongWaitSeconds(),
                 "Register.registerTitle_text"
             );
             Thread.sleep(6000);
             String accountType = testData.get(0).get("accountType");
             String username = actionMethods.generateRandomNumberString(
                 testData.get(0).get("username")
             );
             String emailAddress = username + this.context.constants.getEmailDomain();
             String password = this.context.constants.getPassword();
             String fullName = testData.get(0).get("fullName");
             String personTitle = testData.get(0).get("personTitle");
             String firstName = testData.get(0).get("firstName");
             String lastName = testData.get(0).get("lastName");
             String phoneNumber = testData.get(0).get("phoneNumber");
             String phoneExtNumber = testData.get(0).get("phoneExtNumber");
             String postCode = testData.get(0).get("postCode");
             String country = testData.get(0).get("country");
             String companyName = testData.get(0).get("companyName");
             String vatRegistrationNumber = testData.get(0).get("vatRegistrationNumber");
             String salesTax = testData.get(0).get("salesTax");
             String primaryJob = testData.get(0).get("primaryJob");
             String primaryUse = testData.get(0).get("primaryUse");
             String accountNumber = testData.get(0).get("accountNumber");
             String mobileNumber = testData.get(0).get("mobileNumber");
             String contactYou = testData.get(0).get("contactYou");

             if (accountType.equalsIgnoreCase("skip") || fullName == null) {} else {
                 actionMethods.click("Register.businessAccount_radio");
             }

             actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
             context.scenario.log("Email for new user: " + emailAddress);
             this.context.currentUser = emailAddress;
             actionMethods.enterText(password, "Register.password_textbox");
             context.scenario.log("Password for new user: " + password);

             if (fullName == null || fullName.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(fullName, "Register.fullName_textbox");
             }
             if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {} else {
                 actionMethods.selectValueByIndex(1, "Register.title_dropdown");
             }
             if (firstName == null || firstName.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(firstName, "Register.firstName_textbox");
             }
             if (lastName == null || lastName.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(lastName, "Register.lastName_textbox");
             }
             if (phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");
             }
             if (phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");
             }
             if (postCode == null || postCode.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(postCode, "Register.postalCode_textbox");
             }
             if (country == null || country.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(country, "Register.country_dropdown");
             }
             if (companyName == null || companyName.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(companyName, "Register.companyName_textbox");
             }
             if (
                 vatRegistrationNumber == null ||
                 vatRegistrationNumber.equalsIgnoreCase("skip")
             ) {} else {
                 actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");
             }
             if (salesTax == null || salesTax.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(salesTax, "Register.salesTax_textbox");
             }
             if (primaryJob == null || primaryJob.equalsIgnoreCase("skip")) {} else {
                 actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");
             }
             if (primaryUse == null || primaryUse.equalsIgnoreCase("skip")) {} else {
                 actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");
             }
             if (accountNumber == null || accountNumber.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");
             }
             if (mobileNumber == null || mobileNumber.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
             }
             if (contactYou == null || contactYou.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(contactYou, "Register.contactYou_textbox");
             }

             if (appName.equalsIgnoreCase("web")) {
                 if (getStore().equalsIgnoreCase("kr")) {
                     actionMethods.click("Register.consent_checkbox");
                 }
                 // use below method only to skip captcha
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("document.getElementById('Register').submit();");
             }

                 if (appName.equalsIgnoreCase("mobile")) {
                 actionMethods.click("Register.register_button");

        }
             // login with same user name and password after registration
             if (appName.equalsIgnoreCase("web"))
             {
            	 actionMethods.click("Header.login_link");
            	 actionMethods.enterText(emailAddress, "Login.username_textbox");
            	 actionMethods.enterText(password, "Login.password_textbox");
            	 actionMethods.click("Login.login_button");

             }
             if(appName.equalsIgnoreCase("mobile"))
             {
            	 actionMethods.click("Register.register_link");
            	 actionMethods.enterText(emailAddress, "Login.username_textbox");
            	 actionMethods.enterText(password, "Login.password_textbox");
            	 actionMethods.click("Login.login_button");

             }
     }


     @And("^user verify successful registraion email is received$")
    public void verify_successful_registraion_email_received() throws Exception {
        String baseURI = applicationConfig.getProperty("pf.rest.api.ahem.localmailserver");
        String mailbox = this.context.mailbox;

        //POST Request - To get Access Token
        String accessToken = localServerMethods.getAccessToken(baseURI);

        //GET Request - To fetch second Email ID
        String emailID = localServerMethods.getEmailId(baseURI, accessToken, mailbox);

        //GET Request - To fetch Email content body
        String body = localServerMethods.getEmailBody(baseURI, accessToken, mailbox, emailID);

        //Find the element with the text "Thank you for registering with Farnell"
        Document document = Jsoup.parse(body);
        Elements element;

        if(getStore().equalsIgnoreCase("cpc")||getStore().equalsIgnoreCase("cpcireland"))
        {
        	element = document.select("td");
        	String htmlTableText = element.text();
        	this.context.scenario.log("Text present in the email: "+htmlTableText);
        	Assert.assertTrue(htmlTableText.contains("Thank you for registering with CPC"));
        	this.context.scenario.log("User has received successfull registration email");
        }else
         {
        	element = document.getElementsByClass("title");
        	String emailSuccessText = element.text();
        	this.context.scenario.log("Text present in the email: "+emailSuccessText);

        	if (emailSuccessText != null) {
        		Assert.assertEquals("Thank you for registering with Farnell", emailSuccessText);
        		this.context.scenario.log("User has received successfull registration email");
        	} else {
        		Assert.fail("User has not received successfull registration email");
        	}
       }
    }
     
    @And("user verifies Thank You page of email verification for {string}")
 	public void verifyThankYouPageEmailVerification(String value) throws Exception {
     	String configProperty= "Registration";
     	String objectFile= "Register";
     	actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(),"Register.thankYouTitle_text");
     	Assert.assertTrue(uiMethods.isElementDisplayed("Register.thankYouTitle_text"));
 		// verify thank you page elements
     	verifyActualTextFromProperties("thankYouTitleText", objectFile+".thankYouTitle_text", configProperty);
     	verifyActualTextFromProperties("thankYouHeaderText",objectFile+".thankYouHeader_text",configProperty);
     	verifyPartialTextFromProperties("firstStepText",objectFile+".firstStep_text",configProperty);
     	verifyActualTextFromProperties("secondStepText",objectFile+".secondStep_text",configProperty);
     	if(value.equalsIgnoreCase("Register"))
     		verifyActualTextFromProperties("thirdStepText",objectFile+".thirdStep_text",configProperty);
     	else if(value.equalsIgnoreCase("Checkout"))
     		verifyActualTextFromProperties("thirdStepCheckoutText",objectFile+".thirdStep_text",configProperty);	
     	Assert.assertTrue(uiMethods.isElementDisplayed("Register.resendActivation_button"));
     	verifyActualTextFromProperties("resendButtonText",objectFile+".resendActivation_button",configProperty);
     	verifyActualTextFromProperties("itemsFromBasketText",objectFile+".itemsFromBasket_text",configProperty);
     	verifyActualTextFromProperties("receiveEmailThankYouText",objectFile+".receiveEmailThankYou_text",configProperty);
 	}
     
     /* Method to verify the exact text on page (handles the translated text for non-English store) 
 	 * Fetches text value from the property file
 	 * */
 	@And("user verify text {string} on page {string} from {string} property file")
 	public void verifyActualTextFromProperties(String value, String locator, String properties) throws Exception {
 		String exp_Value;
 		actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
 		if(properties.equalsIgnoreCase("Registration"))
 		{
 			exp_Value = storeText.getStoreText(registrationConfig.getProperty(value));
 		}else {
 			exp_Value = storeText.getStoreText(checkoutConfig.getProperty(value));
 		}
 		String act_Value = actionMethods.getValue(locator);
 		logger.info("Actual text obtained from the page: " + act_Value);
 		Assert.assertEquals(exp_Value, act_Value);
 	}
 	
 	/* Method to verify the exact text on page (handles the translated text for non-English store) 
 	 * Fetches text value from the property file
 	 * */
 	@And("user verify contains {string} on page {string} from {string} property file")
 	public void verifyPartialTextFromProperties(String value, String locator, String properties) throws Exception {
 		String exp_Value;
 		actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
 		if(properties.equalsIgnoreCase("Registration"))
 		{
 			exp_Value = storeText.getStoreText(registrationConfig.getProperty(value));
 		}else {
 			exp_Value = storeText.getStoreText(checkoutConfig.getProperty(value));
 		}
 		String act_Value = actionMethods.getValue(locator);
 		logger.info("Actual text obtained from the page: " + act_Value);
 		Assert.assertTrue("Partial string is not present in the expected message", act_Value.contains(exp_Value));
 	}
 	    
}
