package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.ReadContext;

public class iBuySteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(iBuySteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    String tradeAccountNumber;

    public iBuySteps(ContextStore context) {
        this.context = context;
    }

    @And("^.* enter new Company name.*$")
    public void enterNewCompanyName() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "iBuyAddCompany.addCompanyName_textbox"
        );

        String companyName = actionMethods.generateRandomNumberString("Cmp");
        ContextStore.iBuyCompanyName = companyName;
        actionMethods.enterText(companyName, "iBuyAddCompany.addCompanyName_textbox");
        context.scenario.log("iBuy Organisation : " + companyName);
    }

    @And("^.* enter new IBUY Company name.*$")
    public void enterNewCompanyNameforIBUY() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "iBuyAddCompany.addCompanyName_textbox"
        );

        String companyNameIBUY = actionMethods.generateRandomNumberString("TestCom_");
        ContextStore.iBuyCompanyName = companyNameIBUY;
        actionMethods.enterText(companyNameIBUY, "iBuyAddCompany.addCompanyName_textbox");
        context.scenario.log("iBuy Organisation : " + companyNameIBUY);
    }

    @And("^.*enter Trade account Account number using given file \"([^\"]*)\"$")
    public void enter_account_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);
        tradeAccountNumber = testData.get(0).get("billIBuyAccountNumber");
        actionMethods.enterText(
            tradeAccountNumber,
            "iBuyRetrieveAccount.accountNumber_textbox"
        );
        context.scenario.log("trade account number: " + tradeAccountNumber);
    }

    @SuppressWarnings("deprecation")
    @Then("^.* company name .* element \"([^\"]*)\".*$")
    public void verify_companyName(String locator) throws Throwable {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        //actionMethods.waitForAttributeToContain(this.context.constants.getShortWaitSeconds(), locator, "value", context.iBuyCompanyName);

        String act_Value = actionMethods.getValueUsingAttribute(locator, "innerText");
        if (act_Value.isEmpty()) {
            act_Value = actionMethods.getValueUsingAttribute(locator, "value");
        }
        logger.info("Actual Company name: " + act_Value);
        context.scenario.log("iBuy Company name : " + act_Value);
        Assert.assertTrue(
            "Company name is not as expected",
            act_Value.contains(ContextStore.iBuyCompanyName)
        );
    }

    @Then("^.* account number .* element \"([^\"]*)\".*$")
    public void verify_accountNumber(String locator) throws Throwable {
        String value = actionMethods.getValueUsingAttribute(locator, "innerText");
        context.scenario.log("iBuy Company Account number : " + value);
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        actionMethods.waitForAttributeToContain(
            this.context.constants.getShortWaitSeconds(),
            locator,
            "innerText",
            tradeAccountNumber
        );
    }

    @Then("^.* enter last registered company in textbox \"([^\"]*)\".*$")
    public void enter_company_name(String locator) throws Throwable {
        String iBuy_CompanyName = ContextStore.iBuyCompanyName;     		
        System.out.println("CompanySearched: " + iBuy_CompanyName);
        actionMethods.enterText(iBuy_CompanyName, "iBuyCompanyList.companyName_textbox");
        context.scenario.log("IBuy Company Name: " + iBuy_CompanyName);
    }

    @And("^.*set Custom fields using given file \"([^\"]*)\"$")
    public void set_custom_fields_details(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String fieldOneLabel = testData.get(0).get("fieldOneLabel");
        String fieldOneDropDown = testData.get(0).get("fieldOneDropDown");
        String fieldOneInstructionalText = testData
            .get(0)
            .get("fieldOneInstructionalText");
        String fieldTwoLabel = testData.get(0).get("fieldTwoLabel");
        String fieldTwoInputMask = testData.get(0).get("fieldTwoInputMask");
        String fieldTwoInstructionalText = testData
            .get(0)
            .get("fieldTwoInstructionalText");
        String fieldPONumberLabel = testData.get(0).get("fieldPONumberLabel");
        String fieldPONumberInputMask = testData.get(0).get("fieldPONumberInputMask");
        String fieldPONumberInstructionalText = testData
            .get(0)
            .get("fieldPONumberInstructionalText");
        String fieldCostCodeLabel = testData.get(0).get("fieldCostCodeLabel");
        String fieldCostcodeDropDown = testData.get(0).get("fieldCostcodeDropDown");
        String fieldCostcodeInstructionalText = testData
            .get(0)
            .get("fieldCostcodeInstructionalText");
        String fieldLineNoteLabel = testData.get(0).get("fieldLineNoteLabel");
        String fieldLineNoteDropDown = testData.get(0).get("fieldLineNoteDropDown");
        String fieldLineNoteInstructionalText = testData
            .get(0)
            .get("fieldLineNoteInstructionalText");
        Thread.sleep(1000);
        //field 1
        actionMethods.enterText(
            fieldOneLabel,
            "iBuyCustomFields.fieldLabelField1_textbox"
        );
        actionMethods.click("iBuyCustomFields.shoppingBasket_radio");
        actionMethods.click("iBuyCustomFields.requiredFieldsNo_radio");
        actionMethods.click("iBuyCustomFields.typeOfFieldDropdown_radio");
        actionMethods.enterText(
            fieldOneDropDown,
            "iBuyCustomFields.dropDownField1_textbox"
        );
        actionMethods.enterText(
            fieldOneInstructionalText,
            "iBuyCustomFields.instructionalTextField1_textbox"
        );
        //field 2
        actionMethods.enterText(
            fieldTwoLabel,
            "iBuyCustomFields.fieldLabelField2_textbox"
        );
        actionMethods.click("iBuyCustomFields.orderInformationPage_radio");
        actionMethods.click("iBuyCustomFields.requiredFieldYes2_radio");
        actionMethods.click("iBuyCustomFields.typeOfFieldtext2_radio");
        actionMethods.enterText(fieldTwoInputMask, "iBuyCustomFields.inputMask2_textbox");
        actionMethods.enterText(
            fieldTwoInstructionalText,
            "iBuyCustomFields.instructionalTextField2_textbox"
        );
        //PO
        actionMethods.enterText(
            fieldPONumberLabel,
            "iBuyCustomFields.fieldLabelField3_textbox"
        );
        actionMethods.click("iBuyCustomFields.requiredFieldYes3_radio");
        actionMethods.click("iBuyCustomFields.typeOfFieldtext3_radio");
        actionMethods.enterText(
            fieldPONumberInputMask,
            "iBuyCustomFields.inputMask3_textbox"
        );
        actionMethods.enterText(
            fieldPONumberInstructionalText,
            "iBuyCustomFields.instructionalTextField3_textbox"
        );
        //Cost Code
        if (!(getRegionName().equalsIgnoreCase("newark"))) {
            actionMethods.enterText(
                fieldCostCodeLabel,
                "iBuyCustomFields.fieldLabelField4_textbox"
            );
            actionMethods.click("iBuyCustomFields.requiredFieldNo4_radio");
            actionMethods.click("iBuyCustomFields.typeOfFieldDropdown4_radio");
            actionMethods.enterText(
                fieldCostcodeDropDown,
                "iBuyCustomFields.dropDownFieldCost_textbox"
            );
            actionMethods.enterText(
                fieldCostcodeInstructionalText,
                "iBuyCustomFields.instructionalTextField4_textbox"
            );
        }
        //Line Note
        actionMethods.enterText(
            fieldLineNoteLabel,
            "iBuyCustomFields.fieldLabelField5_textbox"
        );
        actionMethods.click("iBuyCustomFields.requiredFieldNo5_radio");
        actionMethods.click("iBuyCustomFields.typeOfFieldDropdown5_radio");
        actionMethods.enterText(
            fieldLineNoteDropDown,
            "iBuyCustomFields.dropDownFieldLineNote_textbox"
        );
        actionMethods.enterText(
            fieldLineNoteInstructionalText,
            "iBuyCustomFields.instructionalTextField5_textbox"
        );
    }


	@And("^.*fill iBuy \"([^\"]*)\" user details using given Jsonfile \"([^\"]*)\"$")
	public void enter_NewUser_Details_Json(String User, String FileName) throws Exception {
		String path = FilePath + FileName;
		ReadContext rx = JsonUtil.getJsonDocument(path);

		String personTitle = JsonUtil.getKeyValueFromCommonJson(rx, User + ".personTitle");
		String lastName = JsonUtil.getKeyValueFromCommonJson(rx, User + ".lastName");
		String email = JsonUtil.getKeyValueFromCommonJson(rx, User + ".email");
		String phoneNumber = JsonUtil.getKeyValueFromCommonJson(rx, User + ".phoneNumber");
		String usernamedata = JsonUtil.getKeyValueFromCommonJson(rx, User + ".username");
		
		String password = JsonUtil.getKeyValueFromCommonJson(rx, User + ".password");
		String role = JsonUtil.getKeyValueFromCommonJson(rx, User + ".UserRole");
		String approver = JsonUtil.getKeyValueFromCommonJson(rx, User + ".approver");
		String primaryJob = JsonUtil.getKeyValueFromCommonJson(rx, User + ".primaryJob");
		String primaryUse = JsonUtil.getKeyValueFromCommonJson(rx, User + ".primaryUse");
		logger.info("Product found in file: " + User);
		String username;
		if (FileName.equalsIgnoreCase("iBuyUserDetailsNegativeValidation.json")) {

			username = usernamedata;

		}
		else {

			username = actionMethods.generateRandomNumberString(usernamedata).toLowerCase();

			}
		

		actionMethods.selectValueByValue(personTitle, "iBuyAddUser.title_dropdown");
		actionMethods.enterText(username, "iBuyAddUser.firstName_textbox");
		context.scenario.log("FirstName for new iBuyuser: " + username);
		actionMethods.enterText(lastName, "iBuyAddUser.lastName_textbox");
		context.scenario.log("LastName for new iBuyuser: " + lastName);
		actionMethods.enterText(email, "iBuyAddUser.emailAddress_textbox");
		context.scenario.log("Email for new iBuyuser: " + email);
		actionMethods.enterText(phoneNumber, "iBuyAddUser.phoneNumber_textbox");
		actionMethods.enterText(username, "iBuyAddUser.username_textbox");
		this.context.newiBuyUser = username;
		context.scenario.log("UserName for new iBuyuser: " + username);
		uiMethods.scrollToAnyWhere("iBuyAddUser.password_textbox");
		actionMethods.enterText(password, "iBuyAddUser.password_textbox");
		//actionMethods.enterText(password, "iBuyAddUser.confirmPassword_textbox");
		if (role.equalsIgnoreCase("SuperAdministrator")) {
			actionMethods.selectValueByValue("2", "iBuyAddUser.assignedRole_dropdown");
		} else if (role.equalsIgnoreCase("TierAdministrator")) {
			actionMethods.selectValueByValue("3", "iBuyAddUser.assignedRole_dropdown");
		} else if (role.equalsIgnoreCase("User")) {
			actionMethods.selectValueByValue("4", "iBuyAddUser.assignedRole_dropdown");
		}

		if (approver.equalsIgnoreCase("Yes")) {
			String approverSelection = actionMethods.getLocatorString("iBuyAddUser.approver_radio") + "[1]";
			WebElement elementObj = driver.findElement(By.xpath(approverSelection));
			elementObj.click();
		} else if (approver.equalsIgnoreCase("No")) {
			String approverSelection = actionMethods.getLocatorString("iBuyAddUser.approver_radio") + "[2]";
			WebElement elementObj = driver.findElement(By.xpath(approverSelection));
			elementObj.click();

		}
		actionMethods.selectValueByValue(primaryJob, "iBuyAddUser.primaryRole_dropdown");
		actionMethods.selectValueByValue(primaryUse, "iBuyAddUser.primaryUse_dropdown");

	}

	@And("^.*save the created iBuy \"([^\"]*)\" user details$")
	public void save_created_iBuyuser(String User) {
		if (User.equalsIgnoreCase("SuperAdministrator")) {
			ContextStore.iBuySAUser = context.newiBuyUser;
			this.context.scenario.log("iBuySAUser:" + ContextStore.iBuySAUser);
		} else if (User.equalsIgnoreCase("TierAdministrator")) {
			ContextStore.iBuyTSAUser = context.newiBuyUser;
			this.context.scenario.log("iBuyTSAUser:" + ContextStore.iBuyTSAUser);
		} else if (User.equalsIgnoreCase("User")) {
			ContextStore.iBuyUser = context.newiBuyUser;
			this.context.scenario.log("iBuyUser:" + ContextStore.iBuyUser);
		}
	}

	@And("^I enter FirstName of user to be searched in UserSearch textbox$")
	public void enter_UsertoSearch() throws Exception {
		String iBuy_UserName = context.newiBuyUser;
		actionMethods.enterText(iBuy_UserName, "iBuyAddUser.userSearch_textbox");
		this.context.scenario.log("IBuy_CreatedUserName Searched: " + iBuy_UserName);
	}

	@SuppressWarnings("deprecation")
	@And("^I verify if new ibuy user is created$")
	public void verifyCreated_IbuyUser() throws Exception {
		String iBuy_UserName = context.newiBuyUser;
		actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(), "iBuyAddUser.editUser_label");
		String act_userName = actionMethods.getValue("iBuyAddUser.username_text");
		Assert.assertTrue("Created iBuyUser does not match:", act_userName.equals(iBuy_UserName));
//		Assert.assertEquals(iBuy_UserName, act_userName);
		context.scenario.log("Created iBuyUser verified successfully: " + act_userName);
		actionMethods.click("iBuyAddUser.editUserCancel_button");
	}
	
	 @Given("^.*enter iBuyUser \"([^\"]*)\" to be searched$")
	    public void search_IBuyuser(String iBuyUser) throws Exception {
	       	       
		 	String iBuy_UserName;
		 	
	        if (iBuyUser.contains("iBuy user")) {
	        	iBuy_UserName = ContextStore.iBuyUser;
	        } else if (iBuyUser.contains("iBuy SA user")) {
	        	iBuy_UserName = ContextStore.iBuySAUser;
	        } else if (iBuyUser.contains("iBuy TSA user")) {
	        	iBuy_UserName = ContextStore.iBuyTSAUser;
		     } else {
		    	 iBuy_UserName = ContextStore.USER_NAME;
	        }

	        actionMethods.enterText(iBuy_UserName, "iBuyAddUser.userSearch_textbox");
			this.context.scenario.log("IBuy_CreatedUserName Searched: " + iBuy_UserName);	        
	        actionMethods.click("iBuyAddUser.userSearch_button");
	        
	    }
	 @Then("^.* enter last registered user in textbox.*$")
	    public void enter_user_name() throws Throwable {
		    String iBuy_UserName = context.newiBuyUser;
	        System.out.println("CompanySearched: " + iBuy_UserName);
	        
	        actionMethods.enterText(iBuy_UserName, "iBuyAddUser.username_textbox");
	        context.scenario.log("IBuy user Name: " + iBuy_UserName);
	    }
	 @And("^.*Clear the Edit form text fields.*$")

     public void clearEditformFields() throws Exception {
     actionMethods.selectValueByValue("", "iBuyAddUser.title_dropdown");
     actionMethods.clearText("iBuyAddUser.firstName_textbox");
     actionMethods.clearText("iBuyAddUser.lastName_textbox");
     actionMethods.clearText("iBuyAddUser.emailAddress_textbox");
     actionMethods.clearText("iBuyAddUser.phoneNumber_textbox");
     actionMethods.selectValueByValue("", "iBuyAddUser.primaryUse_dropdown");
     actionMethods.selectValueByValue("", "iBuyAddUser.primaryRole_dropdown");
	 }
     
	
}

