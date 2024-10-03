package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class ProfileInformationSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public ProfileInformationSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*edit Profile Information Deatails form using given file \"([^\"]*)\"$")
    public void edit_profile_information_new(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String phoneNumber = testData.get(0).get("billPhone");
        String phoneExtNumber = testData.get(0).get("billPhoneExt");
        String mobileNumber = testData.get(0).get("landLineNumber");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String postcode = testData.get(0).get("billPostCode");
        String province = testData.get(0).get("billProvince");

        if (region.equalsIgnoreCase("europe")) {
            actionMethods.selectValueByIndex(
                3,
                "MyAccountProfileInformation.personTitle_dropdown"
            );
            actionMethods.click("MyAccountProfileInformation.specialOffers_checkbox");

            actionMethods.enterText(
                phoneNumber,
                "MyAccountProfileInformation.phoneNumber_textbox"
            );
            context.scenario.log("phoneNumber :" + phoneNumber);

            actionMethods.clearText(
                    "MyAccountProfileInformation.extensionNumber_textbox");
            actionMethods.enterText(
                phoneExtNumber,
                "MyAccountProfileInformation.extensionNumber_textbox"
            );
            context.scenario.log("phoneExtNumber :" + phoneExtNumber);

            actionMethods.click("MyAccountProfileInformation.selectAll_checkbox");
            actionMethods.enterText(
                mobileNumber,
                "MyAccountProfileInformation.mobileNumber_textbox"
            );
            actionMethods.enterText(
                addressLine1,
                "MyAccountProfileInformation.addressLineOne_textbox"
            );
            actionMethods.enterText(
                addressLine2,
                "MyAccountProfileInformation.addressLineTwo_textbox"
            );
            actionMethods.enterText(city, "MyAccountProfileInformation.city_textbox");
            if (
                uiMethods.isElementDisplayed(
                    "MyAccountProfileInformation.province_textbox"
                )
            ) actionMethods.enterText(
                province,
                "MyAccountProfileInformation.province_textbox"
            );
            actionMethods.enterText(
                postcode,
                "MyAccountProfileInformation.postcode_textbox"
            );
        }
        if (region.equalsIgnoreCase("newark")) {
            actionMethods.click("MyAccountProfileInformation.email_checkbox");
        }
    }

    @And("^.*enter.* current password in textbox \"([^\"]*)\"$")
    public void enter_current_password(String locator) throws Exception {
        String currentPassword = this.context.constants.getPassword();
        actionMethods.enterText(currentPassword, locator);
        context.scenario.log("currentPassword :" + currentPassword);
    }

    @And("^.*enter.* new password in textbox \"([^\"]*)\"$")
    public void enter_new_password(String locator) throws Exception {
        String newPassword = this.context.constants.getNewPassword();
        actionMethods.enterText(newPassword, locator);
        context.scenario.log("newPassword :" + newPassword);
    }
    
    @And("^.*edit Job Role and Product Primary Usage Details using given file \"([^\"]*)\"$")
	public void edit_JobRoleAndPrimaryUse(String FileName) throws Exception {
		String path = FilePath + FileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, store);
		String primaryJob = testData.get(0).get("primaryJob");
		String primaryUse = testData.get(0).get("primaryUse");
		String vatRegistrationNumber = testData.get(0).get("vatRegistrationNumber");
		String personTitle = testData.get(0).get("personTitle");
		String phoneNumber = testData.get(0).get("phoneNumber");
		actionMethods.selectValueByValue(primaryJob, "MyAccountProfileInformation.primaryRole_dropdown");
		actionMethods.selectValueByValue(primaryUse, "MyAccountProfileInformation.primaryUse_dropdown");
		if (vatRegistrationNumber == null ||vatRegistrationNumber.equalsIgnoreCase("skip")) {} 
		else {
	    actionMethods.enterText(vatRegistrationNumber, "MyAccountProfileInformation.vatNumber_textbox");
	    }
		if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByIndex(1, "MyAccountProfileInformation.personTitle_dropdown");
        }
		if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(personTitle, "MyAccountProfileInformation.phoneNumber_textbox");
        }
    }
}
