package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;

import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CheckoutSteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    HashMap<String, String> invoiceAddressMap = new HashMap<String, String>();
	HashMap<String, String> deliveryAddressMap = new HashMap<String, String>();

    public CheckoutSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*fill mobile checkout your details in address section using given file \"([^\"]*)\"$"
    )
    public void enter_your_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String emailAddress = testData.get(0).get("billEmail");

        logger.info("File values :" + firstName + "," + lastName + "," + emailAddress);

        actionMethods.enterText(firstName, "Checkout.firstName_textbox");
        context.scenario.log("First Name : " + firstName);
        actionMethods.enterText(lastName, "Checkout.lastName_textbox");
        context.scenario.log("Last Name : " + lastName);
        actionMethods.enterText(emailAddress, "Checkout.email_textbox");
        context.scenario.log("Email : " + emailAddress);
        ContextStore.ORDER_TRACKING_EMAIL = emailAddress;

        actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
        actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
    }

    @And(
        "^.*fill mobile checkout Invoice or billing address manually using given file \"([^\"]*)\"$"
    )
    public void enter_Invoice_address(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String companyName = testData.get(0).get("billCompanyName");
        String officeName = testData.get(0).get("billOfficeName");
        String officePhone = testData.get(0).get("billOfficePhone");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String province = testData.get(0).get("billProvince");
        String zipCode = testData.get(0).get("billPostCode");
        String email = testData.get(0).get("accountsEmailBuisness");

        if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
            actionMethods.enterText(firstName, "Checkout.firstName_textbox");
            context.scenario.log("FirstName :" + firstName);
        }

        if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
            actionMethods.enterText(lastName, "Checkout.lastName_textbox");
            context.scenario.log("LastName :" + lastName);
        }

        if (uiMethods.verifyElementExistence("Checkout.companyName_textbox")) {
            actionMethods.enterText(companyName, "Checkout.companyName_textbox");
            context.scenario.log("CompanyName :" + companyName);
        }

        // for china condition
        if (officeName == null || officeName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(officeName, "Checkout.officeName_textbox");
            actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
        }
        actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
        context.scenario.log("AddressLine1 :" + addressLine1);
        actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
        context.scenario.log("AddressLine2 :" + addressLine2);
        actionMethods.enterText(city, "Checkout.townCity_textbox");
        context.scenario.log("City :" + city);

        if (province == null || province.equalsIgnoreCase("skip")) {} else {
            if (context.constants.getStateDropdownStores().contains(getStore())) {
                actionMethods.selectValueByValue(
                    province.trim(),
                    "Checkout.state_dropdown"
                );
            } else {
                actionMethods.enterText(province, "Checkout.countryProvince_textbox");
            }
            context.scenario.log("Province :" + province);
        }
        actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
        context.scenario.log("Zipcode :" + zipCode);
        ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

        if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
            actionMethods.enterText(email, "Checkout.email_textbox");
            context.scenario.log("Email :" + email);
        }
    }

    @And("^.*fill Credit Card Details in mobile using given file \"([^\"]*)\"$")
    public void enter_CreditCard_Details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String creditCardNum = testData.get(0).get("billCardNumber");
        String expiryMonth = testData.get(0).get("billCardExpiryMonth");
        String expiryYear = testData.get(0).get("billCardExpiryYear");
        String securityNum = testData.get(0).get("billCardSecurityNumber");
        String nameOnCard = testData.get(0).get("billNameOnCard");
        String cardHolderPhone = testData.get(0).get("billCardHolderPhone");

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-card-1");
            actionMethods.enterText(
                creditCardNum,
                "Checkout.creditCardNumWebtokenize_textbox"
            );
            driver.switchTo().parentFrame();
        }
        context.scenario.log("CreditCardNum :" + creditCardNum);

        actionMethods.selectValueByText(expiryMonth, "Checkout.expiryMonth_dropdown");
        context.scenario.log("expiryMonth :" + expiryMonth);
        actionMethods.selectValueByText(expiryYear, "Checkout.expiryYear_dropdown");
        context.scenario.log("expiryYear :" + expiryYear);

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframe");
            actionMethods.enterText(securityNum, "Checkout.cvvWebtokenize_textbox");
            driver.switchTo().parentFrame();
        }
        context.scenario.log("securityNum :" + securityNum);

        actionMethods.enterText(nameOnCard, "Checkout.nameOnCard_textbox");
        context.scenario.log("nameOnCard :" + nameOnCard);
        actionMethods.enterText(cardHolderPhone, "Checkout.cardHolderPhone_textbox");
        context.scenario.log("cardHolderPhone :" + cardHolderPhone);
        Thread.sleep(3000);
    }

    @And(
        ".*selects special instructions \"([^\"]*)\" from dropdown and enter instructions if any$"
    )
    public void select_special_instructions(String value) throws Exception {
        if (!getRegionName().equalsIgnoreCase("newark")) {
            actionMethods.selectValueByValue(
                value,
                "Checkout.specialInstruction_dropdown"
            );
            if (value.equalsIgnoreCase("other")) {
                actionMethods.enterText(
                    this.context.constants.getSpecialInstructions(),
                    "Checkout.specialDeliveryInstructions_textbox"
                );
            }
        }
    }
    
    @And("^.*fill mobile checkout with specific \"([^\"]*)\" as Invoice or billing address  using given file \"([^\"]*)\"$")
	public HashMap<String, String> enter_invoice_or_billing_address_specifically(String address, String FileName)
			throws Exception {
		int row = 0;
		String path = FilePath + FileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, store);
		for (int i = 0; i < testData.size(); i++) {
			String addressType = testData.get(i).get("addressType");
			if (addressType.equalsIgnoreCase(address)) {

				row = i;
			}

		}

		String firstName = testData.get(row).get("firstName");
		String lastName = testData.get(row).get("lastName");
		String companyName = testData.get(row).get("billCompanyName");
		String officeName = testData.get(row).get("billOfficeName");
		String officePhone = testData.get(row).get("billOfficePhone");
		String addressLine1 = testData.get(row).get("billAddressLine1");
		String addressLine2 = testData.get(row).get("billAddressLine2");
		String city = testData.get(row).get("billCity");
		String province = testData.get(row).get("billProvince");
		String zipCode = testData.get(row).get("billPostCode");
		String email = testData.get(row).get("accountsEmailBuisness");
		String country = testData.get(row).get("billCountry");
		String attentionOf = testData.get(row).get("billAttention");

		invoiceAddressMap.put("firstName", firstName);
		invoiceAddressMap.put("lastName", lastName);
		invoiceAddressMap.put("companyName", companyName);
		invoiceAddressMap.put("officeName", officeName);
		invoiceAddressMap.put("officePhone", officePhone);
		invoiceAddressMap.put("addressLine1", addressLine1);
		invoiceAddressMap.put("addressLine2", addressLine2);
		invoiceAddressMap.put("city", city);
		invoiceAddressMap.put("province", province);
		invoiceAddressMap.put("zipCode", zipCode);
		invoiceAddressMap.put("email", email);
		invoiceAddressMap.put("country", country);
		invoiceAddressMap.put("Attention of", attentionOf);

		if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
			actionMethods.enterText(firstName, "Checkout.firstName_textbox");
			context.scenario.log("FirstName :" + firstName);
		}

		if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
			actionMethods.enterText(lastName, "Checkout.lastName_textbox");
			context.scenario.log("LastName :" + lastName);
		}

		if (uiMethods.verifyElementExistence("Checkout.companyName_textbox")) {
			actionMethods.enterText(companyName, "Checkout.companyName_textbox");
			context.scenario.log("CompanyName :" + companyName);
		}

		// for china condition
		if (officeName == null || officeName.equalsIgnoreCase("skip")) {
		} else {
			actionMethods.enterText(officeName, "Checkout.officeName_textbox");
			actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
		}
		actionMethods.enterText(attentionOf, "Checkout.attentionOf_textbox");
		context.scenario.log("AttentionOf :" + attentionOf);
		actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
		context.scenario.log("AddressLine1 :" + addressLine1);
		actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
		context.scenario.log("AddressLine2 :" + addressLine2);
		actionMethods.enterText(city, "Checkout.townCity_textbox");
		context.scenario.log("City :" + city);

		if (province == null || province.equalsIgnoreCase("skip")) {
		} else {
			if (context.constants.getStateDropdownStores().contains(getStore())) {
				actionMethods.selectValueByText(province.trim(), "Checkout.state_dropdown");
			} else {
				actionMethods.enterText(province, "Checkout.countryProvince_textbox");
			}
			context.scenario.log("Province :" + province);
		}
		actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
		context.scenario.log("Zipcode :" + zipCode);
		ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

		if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
			actionMethods.enterText(email, "Checkout.email_textbox");
			context.scenario.log("Email :" + email);
		}

		return invoiceAddressMap;
	}

	@And("^.*verify if address entered \"([^\"]*)\" from \"([^\"]*)\" file is displayed correct \"([^\"]*)\"$")
	public void verify_invoice_or_delivery_address_entered(String address, String fileName, String locator)
			throws Exception {
		List<WebElement> addressLines = getMutipleLocators(locator);
		HashMap<String, String> map = new HashMap<String, String>();
		if (address.contains("Delivery")) {

			map = deliveryAddressMap;

		} else if (address.contains("Invoice")) {

			map = invoiceAddressMap;
		}

		for (int i = 0; i < addressLines.size(); i++) {

			WebElement addressLine = getLocator("(" + addressLines + ")[" + i + "]");
			String addressLineText = addressLine.getText().trim();
			switch (i) {

			case 1:

				Assert.assertEquals(map.get("addressLine1"), addressLineText);
				break;
			case 2:

				Assert.assertEquals(map.get("companyName"), addressLineText);
				break;
			case 3:

				Assert.assertEquals("For the Attention Of:" + map.get("Attention of"), addressLineText);
				break;
			case 4:

				String expectedAddress = map.get("addressLine1") + "\r\n" + map.get("addressLine2") + "\r\n"
						+ map.get("city") + "," + map.get("province") + "\r\n" + map.get("country") + ","
						+ map.get("zipCode") + "\r\n" + map.get("email");

				Assert.assertEquals(expectedAddress, addressLineText);
				break;
			}
		}
	}

	@And(".*enters the ordercode \"([^\"]*)\" to the basket from file \"([^\"]*)\".*$")
	public void enter_order_code_in_cartpage(String key, String fileName) throws Exception {

		String path = FilePath + fileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		String productToAdd = testData.get(0).get(key);
		if (productToAdd == null || productToAdd.equalsIgnoreCase("")) {
			assumeTrue("Data missing.NA for this store. product Type:" + key, false);
		} else {
			actionMethods.enterText(productToAdd, "Checkout.firstOrderCode_textbox");
			this.context.scenario.log("Product Added :" + productToAdd);
		}
	}

	@And("^.*fill mobile checkout with specific \"([^\"]*)\" as Delivery or Shipping address  using given file \"([^\"]*)\"$")
	public HashMap<String, String> enter_delivery_or_shipping_address_specifically(String address, String FileName)
			throws Exception {
		int row = 0;
		String path = FilePath + FileName;
		HashMap<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> testData = ExcelUtil.getData(path, store);
		for (int i = 0; i < testData.size(); i++) {
			String addressType = testData.get(i).get("addressType");
			if (addressType.equalsIgnoreCase(address)) {

				row = i;
			}

		}

		String firstName = testData.get(row).get("firstName");
		String lastName = testData.get(row).get("lastName");
		String companyName = testData.get(row).get("billCompanyName");
		String officeName = testData.get(row).get("billOfficeName");
		String officePhone = testData.get(row).get("billOfficePhone");
		String addressLine1 = testData.get(row).get("billAddressLine1");
		String addressLine2 = testData.get(row).get("billAddressLine2");
		String city = testData.get(row).get("billCity");
		String province = testData.get(row).get("billProvince");
		String zipCode = testData.get(row).get("billPostCode");
		String email = testData.get(row).get("accountsEmailBuisness");
		String country = testData.get(row).get("billCountry");
		String attentionOf = testData.get(row).get("billAttention");

		deliveryAddressMap.put("firstName", firstName);
		deliveryAddressMap.put("lastName", lastName);
		deliveryAddressMap.put("companyName", companyName);
		deliveryAddressMap.put("officeName", officeName);
		deliveryAddressMap.put("officePhone", officePhone);
		deliveryAddressMap.put("addressLine1", addressLine1);
		deliveryAddressMap.put("addressLine2", addressLine2);
		deliveryAddressMap.put("city", city);
		deliveryAddressMap.put("province", province);
		deliveryAddressMap.put("zipCode", zipCode);
		deliveryAddressMap.put("email", email);
		deliveryAddressMap.put("country", country);
		deliveryAddressMap.put("Attention of", attentionOf);

		if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
			actionMethods.enterText(firstName, "Checkout.firstName_textbox");
			context.scenario.log("FirstName :" + firstName);
		}

		if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
			actionMethods.enterText(lastName, "Checkout.lastName_textbox");
			context.scenario.log("LastName :" + lastName);
		}

		if (companyName == null || companyName.equalsIgnoreCase("skip")) {
		} else if (uiMethods.verifyElementExistence("Checkout.companyNameOfShippingAddress_textbox")) {
			actionMethods.enterText(companyName, "Checkout.companyNameOfShippingAddress_textbox");
			context.scenario.log("CompanyName :" + companyName);
		}

		// for china condition
		if (officeName == null || officeName.equalsIgnoreCase("skip")) {
		} else {
			actionMethods.enterText(officeName, "Checkout.officeName_textbox");
			actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
		}
		if (attentionOf == null || attentionOf.equalsIgnoreCase("skip")) {

		} else {
			actionMethods.enterText(attentionOf, "Checkout.attentionOfShippingAddress_textbox");
			context.scenario.log("AttentionOf :" + attentionOf);
		}
		if (addressLine1 == null || addressLine1.equalsIgnoreCase("skip")) {

		} else {
			actionMethods.enterText(addressLine1, "Checkout.addressLineOneOfShippingAddress_textbox");
			context.scenario.log("AddressLine1 :" + addressLine1);
		}
		if (addressLine2 == null || addressLine2.equalsIgnoreCase("skip")) {

		} else {
			actionMethods.enterText(addressLine2, "Checkout.addressLineTwoOfShippingAddress_textbox");
			context.scenario.log("AddressLine2 :" + addressLine2);
		}

		actionMethods.enterText(city, "Checkout.townCityOfShippingAddress_textbox");
		context.scenario.log("City :" + city);

		if (province == null || province.equalsIgnoreCase("skip")) {
		} else {
			if (context.constants.getStateDropdownStores().contains(getStore())) {
				actionMethods.selectValueByText(province.trim(), "Checkout.state_dropdown");
			} else {
				actionMethods.enterText(province, "Checkout.provinceOfShippingAddress_textbox");
			}
			context.scenario.log("Province :" + province);
		}
		actionMethods.enterText(zipCode, "Checkout.zipCodeOfShippingAddress_textbox");
		context.scenario.log("Zipcode :" + zipCode);
		ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

		if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
			actionMethods.enterText(email, "Checkout.email_textbox");
			context.scenario.log("Email :" + email);
		}

		return deliveryAddressMap;
	}

	@And("^.*clear all items from basket in mobile$")
	public void clear_all_items_from_basket() throws Exception {
		List<WebElement> deleteIconsInCart = getMutipleLocators("Checkout.deleteIcons_list");
		for (WebElement e : deleteIconsInCart) {
			e.click();
			Thread.sleep(1500);
		}

	}
	
	 @And(".*enter random PO Number on account$")
	    public void enter_PO_Number() throws Exception {
	        actionMethods.waitForElementToAppear(
	            this.context.constants.getLongWaitSeconds(),
	            "Checkout.poNumber_textbox"
	        );
	        String poNumber_random = actionMethods.generateRandomNumberString(
	            this.context.constants.getOrderRefString()
	        );
	        logger.info("Random PO number is: " + poNumber_random);
	        ContextStore.ORDER_TRACKING_PO_NUM = poNumber_random.toUpperCase();

	        actionMethods.enterText(poNumber_random, "Checkout.poNumber_textbox");
	        context.scenario.log("PONumber_random :" + poNumber_random.toUpperCase());
	    }

}
