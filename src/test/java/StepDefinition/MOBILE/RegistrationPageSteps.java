package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPageSteps extends WebDriverConfig {

	private ContextStore context;
	String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
			+ "//";

	public RegistrationPageSteps(ContextStore context) {
		this.context = context;
	}

	public HashMap<String, String> getMandatoryFieldsInRegistraionPageForAGivenStore(String FileName)
			throws IllegalFormatException, IOException, InvalidFormatException {
		String path = FilePath + FileName;
		String sheetName = getStore();
		HashMap<String, String> mandatoryFieldList = new HashMap<String, String>();
		Map<String, String> keywordMap = new HashMap<String, String>();
		Map<String, String> mandatoryInputFieldMap = new HashMap<String, String>();

		List<Map<String, String>> testData = ExcelUtil.getData(path, sheetName);
		int mandatory_input_field_row = 0;
		int feature_file_keyword_row = 0;
		for (int row = 0; row < testData.size(); row++) {
			String rowType = testData.get(row).get("scenario");
			if (rowType.equalsIgnoreCase("MANDATORY_INPUT_FIELD_LABELS")) {
				mandatory_input_field_row = row;
			} else if (rowType.equalsIgnoreCase("FEATURE_FILE_KEYWORDS")) {
				feature_file_keyword_row = row;
			}
		}

		keywordMap = testData.get(feature_file_keyword_row);
		mandatoryInputFieldMap = testData.get(mandatory_input_field_row);
		for (Map.Entry<String, String> keyEntry : keywordMap.entrySet()) {
			for (Map.Entry<String, String> fieldEntry : mandatoryInputFieldMap.entrySet()) {
				if (keyEntry.getKey() == fieldEntry.getKey()) {
					String key = keyEntry.getValue();
					String value = fieldEntry.getValue();
					if (value.equalsIgnoreCase("MANDATORY_INPUT_FIELD_LABELS")
							&& key.equalsIgnoreCase("FEATURE_FILE_KEYWORDS")) {
					} else if (value == null || value.equals("skip")) {
					} else {
						mandatoryFieldList.put(key, value);
					}
				}
			}
		}

		return mandatoryFieldList;
	}

	@Then("^.*verify error message heading has \"([^\"]*)\" on \"([^\"]*)\" for \"([^\"]*)\" data entered.*$")
	public void verifyErrorMsgHeadingWithEitherInvalidOrBlankInputField(String locator, String errorMessageHeading,
			String customerInfo) throws Exception {
		WebElement elementObj = getLocator(locator);
		String err_msg_heading = elementObj.getText();
		System.out.println(err_msg_heading);
		if (customerInfo.equals("BLANK")
				|| customerInfo.equals("INVALID") && !customerInfo.equals("BLANK_AND_INVALID")) {
			if (errorMessageHeading.equals("Please correct fields")) {
				Assert.assertTrue(
						errorMessageHeading.equals(storeText.getStoreText("Please correct the following fields:")));
			} else if (errorMessageHeading.equals("Please enter required fields")) {
				Assert.assertTrue(errorMessageHeading.equals(storeText
						.getStoreText("Please enter all required information. The following was not entered:")));
			}
		}
	}

	@Then("^.* verify if the existing user error \"([^\"]*)\" displayed on page when \"([^\"]*)\" is entered using \"([^\"]*)\" file")
	public void verifyRegistrationWithExistingUserError(String locator, String customerInfo, String fileName)
			throws Exception {
		String actual_err_msg = actionMethods.getValue(locator);
		String path = FilePath + fileName;
		String username = "";
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		int totalRows = testData.size();
		for (int row = 1; row < totalRows; row++) {
			String cellValue = testData.get(row).get("scenario");
			if (cellValue.equals("EXISTING_REGISTERED_USERNAME")) {
				username = testData.get(row).get("username");
			}
		}

		String expected_err_msg = username + " "
				+ storeText.getStoreText("is not available. Please try a different username.");

		System.out.println(actual_err_msg);
		System.out.println(expected_err_msg);
		Assert.assertTrue(actual_err_msg.equals(expected_err_msg));
	}

	@Then("^.*verify if the invalid input fields \"([^\"]*)\" are displayed in the error message \"([^\"]*)\".*$")
	public void verifyInvalidInputFieldsInErrorMessage(String invalidInputFields, String locator) throws Exception {
		List<WebElement> err_message = getMutipleLocators(locator);
		List<String> actual_err_input_fields = new ArrayList<String>();
		List<String> expected_err_input_fields = new ArrayList<String>();
		for (WebElement e : err_message) {
			actual_err_input_fields.add(e.getText().trim());
		}
		String[] invalidFields = invalidInputFields.split("#");
		for (int i = 0; i < invalidFields.length; i++) {
			if (invalidFields[i].equalsIgnoreCase("email")) {
				expected_err_input_fields.add(storeText.getStoreText("Please enter a valid Email Address").trim());
			}

			if (invalidFields[i].equalsIgnoreCase("username")) {
				expected_err_input_fields.add(storeText
						.getStoreText("Please enter a username that has more than 6 characters and less than 20.")
						.trim());
			}

			if (invalidFields[i].equalsIgnoreCase("password")) {
				expected_err_input_fields.add(
						storeText.getStoreText("Password entered does not meet the criteria specified below.").trim());
			}

			if (invalidFields[i].equalsIgnoreCase("vat_reg_num")) {
			}
		}

		System.out.println("Actual: " + actual_err_input_fields);
		System.out.println("Expected: " + expected_err_input_fields);
		Collections.sort(actual_err_input_fields);
		Collections.sort(expected_err_input_fields);
		this.context.scenario.log("expected error msg: " + expected_err_input_fields);
		this.context.scenario.log("Actual error msg: " + actual_err_input_fields);
		Assert.assertTrue(actual_err_input_fields.equals(expected_err_input_fields));
	}

	@Then("^user verifies if \"([^\"]*)\" input fields displayed on blank error message \"([^\"]*)\" when user enters data from \"([^\"]*)\" file$")
	public void verifyBlankInputFieldsInErrorMessage(String blankInputFields, String locator, String fileName)
			throws Exception {
		List<WebElement> err_message = getMutipleLocators(locator);
		HashMap<String, String> mandatoryInputFields = getMandatoryFieldsInRegistraionPageForAGivenStore(fileName);
		List<String> actual_blank_input_fields = new ArrayList<String>();
		List<String> expected_blank_input_fields = new ArrayList<String>();
		if (!blankInputFields.equalsIgnoreCase("all")) {
			String[] blankFields = blankInputFields.split("#");
			for (int i = 0; i < blankFields.length; i++) {
				expected_blank_input_fields
						.add(storeText.getStoreText(mandatoryInputFields.get(blankFields[i])).trim());
				Collections.sort(expected_blank_input_fields);
			}
		} else if (blankInputFields.equalsIgnoreCase("all")) {
			List<String> expectedBlankFieldList = new ArrayList<String>(mandatoryInputFields.values());
			for (String e : expectedBlankFieldList) {
				if (!e.isEmpty()) {
					String translatedInputField = storeText.getStoreText(e).trim();
					expected_blank_input_fields.add(translatedInputField);
					Collections.sort(expected_blank_input_fields);
				}
			}
		}

		for (WebElement e : err_message) {
			if (!e.getText().isEmpty()) {
				actual_blank_input_fields.add(e.getText().trim());
				Collections.sort(actual_blank_input_fields);
			}
		}
		System.out.println("Actual: " + actual_blank_input_fields);
		System.out.println("Expected: " + expected_blank_input_fields);
		Assert.assertTrue(actual_blank_input_fields.containsAll(expected_blank_input_fields));
	}

	@And("^user enters customer data with \"([^\"]*)\" details in registration page from \"([^\"]*)\" file$")
	public void enterCustInfoInRegistrationPageFromExcelFile(String customerInfo, String FileName) throws Exception {
		String path = FilePath + FileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		// int totalRows = ExcelUtil.getRowCount(getStore());
		int totalRows = testData.size() - 1;
		for (int row = 1; row < totalRows; row++) {
			// String cellValue = ExcelUtil.getCellData(getStore(), row, 0);
			String cellValue = testData.get(row).get("scenario");
			if (customerInfo.equals(cellValue.trim())) {
				String accountType = testData.get(row).get("accountType");
				String username = testData.get(row).get("username");
				String password = testData.get(row).get("password");
				String fullName = testData.get(row).get("fullName");
				String personTitle = testData.get(row).get("personTitle");
				String firstName = testData.get(row).get("firstName");
				String lastName = testData.get(row).get("lastName");
				String emailAddress = testData.get(row).get("emailAddress");
				String phoneNumber = testData.get(row).get("phoneNumber");
				String phoneExtNumber = testData.get(row).get("phoneExtNumber");
				String postCode = testData.get(row).get("postCode");
				String country = testData.get(row).get("country");
				String companyName = testData.get(row).get("companyName");
				String vatRegistrationNumber = testData.get(row).get("vatRegistrationNumber");
				String salesTax = testData.get(row).get("salesTax");
				String primaryJob = testData.get(row).get("primaryJob");
				String primaryUse = testData.get(row).get("primaryUse");
				String accountNumber = testData.get(row).get("accountNumber");
				String mobileNumber = testData.get(row).get("mobileNumber");
				String contactYou = testData.get(row).get("contactYou");

				if (accountType.equalsIgnoreCase("skip") || fullName == null) {
				} else {
					actionMethods.click("Register.businessAccount_radio");
				}

				if (emailAddress == null || emailAddress.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
				}

				if (username == null || username.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(username, "Register.username_textbox");
					context.scenario.log("Username for new user: " + username);
				}

				if (password == null || password.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(password, "Register.password_textbox");
					context.scenario.log("Password for new user: " + password);
				}

				if (fullName == null || fullName.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(fullName, "Register.fullName_textbox");
				}
				if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.selectValueByValue(personTitle, "Register.title_dropdown");
					// actionMethods.selectValueByIndex(1, "Register.title_dropdown");
				}
				if (firstName == null || firstName.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(firstName, "Register.firstName_textbox");
				}
				if (lastName == null || lastName.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(lastName, "Register.lastName_textbox");
				}

				if (phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");
				}
				if (phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");
				}
				if (postCode == null || postCode.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(postCode, "Register.postalCode_textbox");
				}
				if (country == null || country.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(country, "Register.country_dropdown");
				}
				if (companyName == null || companyName.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(companyName, "Register.companyName_textbox");
				}
				if (vatRegistrationNumber == null || vatRegistrationNumber.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");
				}
				if (salesTax == null || salesTax.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(salesTax, "Register.salesTax_textbox");
				}
				if (primaryJob == null || primaryJob.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");
				}
				if (primaryUse == null || primaryUse.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");
				}
				if (accountNumber == null || accountNumber.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");
				}
				if (mobileNumber == null || mobileNumber.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
				}
				if (contactYou == null || contactYou.equalsIgnoreCase("skip")) {
				} else {
					actionMethods.enterText(contactYou, "Register.contactYou_textbox");
				}

				if (appName.equalsIgnoreCase("web")) {
					if (getStore().equalsIgnoreCase("kr")) {
						actionMethods.click("Register.consent_checkbox");
					}
				}
			}
		}
	}

	@Then("^.* verifies the name and address input labels \"([^\"]*)\" on the registration form using \"([^\"]*)\" file$")
	public void verifyNameAndAddressInputLabels(String locator, String fileName) throws Exception {
		String path = FilePath + fileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		List<String> expectedList = new ArrayList<String>();
		List<String> actualList = new ArrayList<String>();
		List<WebElement> inputLabels = getMutipleLocators(locator);
		Map<String, String> map = new HashMap<String, String>();
		int totalRows = testData.size() - 1;
		System.out.println(totalRows);
		for (int row = 0; row < totalRows; row++) {
			String cellValue = testData.get(row).get("scenario");
			if (!(cellValue == null) && cellValue.equals("NAME_AND_ADDRESS_FORM_FIELDS")) {
				map = testData.get(row);
				for (Map.Entry<String, String> Entry : map.entrySet()) {
					String value = Entry.getValue();
					if (!(value.isEmpty() || value.equalsIgnoreCase("skip")
							|| value.equalsIgnoreCase("NAME_AND_ADDRESS_FORM_FIELDS"))) {
						if (value.equals("Ext. Number") || value.equals("Zip / Postal Code")
								|| value.equals("Company Name")) {
						} else {
							value = "*" + value;
						}
						expectedList.add(storeText.getStoreText(value).trim());
					}
				}

				break;
			}
		}

		for (WebElement e : inputLabels) {
			if (!e.getText().isEmpty()) {
				actualList.add(e.getText().trim());
			}
		}

		List<String> sortedActualList = actualList.stream().sorted().collect(Collectors.toList());
		List<String> sortedExpectedList = expectedList.stream().sorted().collect(Collectors.toList());
		this.context.scenario.log("Actual List: " + actualList);
		this.context.scenario.log("Expected List: " + expectedList);
		Assert.assertTrue(sortedActualList.equals(sortedExpectedList));
	}

	@Then("^.* verifies the contact preference details \"([^\"]*)\" on the registration form using \"([^\"]*)\" file in \"([^\"]*)\" regions$")
	public void verifyContactPreferenceDetails(String locator, String fileName, String regions) throws Exception {
		String path = FilePath + fileName;
		String[] regionArray = regions.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(region) || Arrays.asList(regionArray).contains(store)) {
			List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
			List<String> expectedList = new ArrayList<String>();
			List<String> actualList = new ArrayList<String>();
			List<WebElement> inputLabels = getMutipleLocators(locator);
			Map<String, String> map = new HashMap<String, String>();
			int totalRows = testData.size() - 1;
			for (int row = 0; row < totalRows; row++) {
				String cellValue = testData.get(row).get("scenario");
				System.out.println(cellValue);
				if (!(cellValue == null) && cellValue.equals("CONTACT_PREFERENCE")) {
					map = testData.get(row);
					for (Map.Entry<String, String> Entry : map.entrySet()) {
						String value = Entry.getValue();
						if (!(value.isEmpty() || value.equalsIgnoreCase("skip")
								|| value.equalsIgnoreCase("CONTACT_PREFERENCE"))) {
							expectedList.add(storeText.getStoreText(value).trim());
							Collections.sort(expectedList);
						}
					}

					break;
				}
			}

			for (WebElement e : inputLabels) {
				if (!e.getText().isEmpty()) {
					actualList.add(e.getText().trim());
					Collections.sort(actualList);
				}
			}
			System.out.println("Actual List: " + actualList);
			System.out.println("Expected List: " + expectedList);
			Assert.assertTrue(actualList.equals(expectedList));
		}
	}

	@Then("^user verifies if \"([^\"]*)\" input fields displayed on blank error message \"([^\"]*)\" when user enters data from \"([^\"]*)\" file in \"([^\"]*)\" regions$")
	public void verifyBlankInputFieldsInErrorMessageForSpecificStores(String blankInputFields, String locator,
			String fileName, String regions) throws Exception {
		String[] regionArray = regions.toLowerCase().split(",");
		String region = getRegionName().toLowerCase();
		String store = getStore().toLowerCase();
		if (Arrays.asList(regionArray).contains(region) || Arrays.asList(regionArray).contains(store)) {
			List<WebElement> err_message = getMutipleLocators(locator);
			HashMap<String, String> mandatoryInputFields = getMandatoryFieldsInRegistraionPageForAGivenStore(fileName);
			List<String> actual_blank_input_fields = new ArrayList<String>();
			List<String> expected_blank_input_fields = new ArrayList<String>();
			if (!blankInputFields.equalsIgnoreCase("all")) {
				String[] blankFields = blankInputFields.split("#");
				for (int i = 0; i < blankFields.length; i++) {
					expected_blank_input_fields
							.add(storeText.getStoreText(mandatoryInputFields.get(blankFields[i])).trim());
					Collections.sort(expected_blank_input_fields);
				}
			} else if (blankInputFields.equalsIgnoreCase("all")) {
				List<String> expectedBlankFieldList = new ArrayList<String>(mandatoryInputFields.values());
				for (String e : expectedBlankFieldList) {
					if (!e.isEmpty()) {
						String translatedInputField = storeText.getStoreText(e).trim();
						expected_blank_input_fields.add(translatedInputField);
						Collections.sort(expected_blank_input_fields);
					}
				}
			}

			for (WebElement e : err_message) {
				if (!e.getText().isEmpty()) {
					actual_blank_input_fields.add(e.getText().trim());
					Collections.sort(actual_blank_input_fields);
				}
			}
			System.out.println("Actual: " + actual_blank_input_fields);
			System.out.println("Expected: " + expected_blank_input_fields);
			Assert.assertTrue(actual_blank_input_fields.containsAll(expected_blank_input_fields));
		}
	}
}
