package Pages.WEB;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;

import Common.UTILS.BaseTest;
import Common.UTILS.ContextStore;

public class RegistrationPage implements BaseTest {
	private ContextStore context;

	public RegistrationPage(ContextStore context) {
		this.context = context;

	}

	public void populate_form(String user, String path) throws Exception {
		String emailAddress = null;
		List<Map<String, String>> testData = ExcelUtil.getData(path, driverConfig.getStore());
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
		String accountType = testData.get(0).get("accountType");
		String username = actionMethods.generateRandomNumberString(testData.get(0).get("username"));

		if (user.equalsIgnoreCase("register")) {
			this.context.mailbox = username;
			emailAddress = username + this.context.constants.getLocalEmailDomain();
			this.context.userEmail = emailAddress;
		} else {
			emailAddress = testData.get(0).get("emailAddress");
		}
		context.scenario.log("Email Address for new user is: " + emailAddress);

		if (!(accountType.equalsIgnoreCase("skip") || fullName == null)) {
			actionMethods.click("Register.businessAccount_radio");
		}

		actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
		context.scenario.log("Email for new user: " + emailAddress);
		this.context.currentUser = emailAddress;

		actionMethods.enterText(password, "Register.password_textbox");
		context.scenario.log("Password for new user: " + password);

		if (!(fullName == null || fullName.equalsIgnoreCase("skip")))
			actionMethods.enterText(fullName, "Register.fullName_textbox");

		if (!(personTitle == null || personTitle.equalsIgnoreCase("skip")))
			actionMethods.selectValueByIndex(1, "Register.title_dropdown");

		if (!(firstName == null || firstName.equalsIgnoreCase("skip")))
			actionMethods.enterText(firstName, "Register.firstName_textbox");

		if (!(lastName == null || lastName.equalsIgnoreCase("skip")))
			actionMethods.enterText(lastName, "Register.lastName_textbox");

		if (!(phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")))
			actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");

		if (!(phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip")))
			actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");

		if (!(postCode == null || postCode.equalsIgnoreCase("skip")))
			actionMethods.enterText(postCode, "Register.postalCode_textbox");

		if (!(country == null || country.equalsIgnoreCase("skip")))
			actionMethods.enterText(country, "Register.country_dropdown");

		if (!(companyName == null || companyName.equalsIgnoreCase("skip")))
			actionMethods.enterText(companyName, "Register.companyName_textbox");

		if (!(vatRegistrationNumber == null || vatRegistrationNumber.equalsIgnoreCase("skip")))
			actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");

		if (!(salesTax == null || salesTax.equalsIgnoreCase("skip")))
			actionMethods.enterText(salesTax, "Register.salesTax_textbox");

		if (!(primaryJob == null || primaryJob.equalsIgnoreCase("skip")))
			actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");

		if (!(primaryUse == null || primaryUse.equalsIgnoreCase("skip")))
			actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");

		if (!(accountNumber == null || accountNumber.equalsIgnoreCase("skip")))
			actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");

		if (uiMethods.isElementDisplayed("Register.mobileNumber_textbox")) {
			if (!(mobileNumber == null || mobileNumber.equalsIgnoreCase("skip")))
				actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
		}

		if (!(contactYou == null || contactYou.equalsIgnoreCase("skip")))
			actionMethods.enterText(contactYou, "Register.contactYou_textbox");

		if (driverConfig.getStore().equalsIgnoreCase("kr")) {
			actionMethods.click("Register.consent_checkbox");
		}
		// use below method only to skip captcha
		JavascriptExecutor js = (JavascriptExecutor) driverConfig.getDriver();
		js.executeScript("document.getElementById('Register').submit();");

		if (user.equalsIgnoreCase("synch") && driverConfig.getRegionName().equalsIgnoreCase("newark")) {
			populate_form_with_username(username);
		}

	}

	public void populate_form_with_username(String username) throws Exception {
		// click register with username
		actionMethods.click("Register.registerWithUserName_link");
		// enter username & password
		actionMethods.enterText(username, "Register.username_textbox");
		context.scenario.log("Username for new user: " + username);
		this.context.currentUser = username;
		actionMethods.enterText(this.context.constants.getPassword(), "Register.password_textbox");
		// click register button
		JavascriptExecutor js = (JavascriptExecutor) driverConfig.getDriver();
		js.executeScript("document.getElementById('Register').submit();");

	}

}
