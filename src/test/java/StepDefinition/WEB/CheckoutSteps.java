package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.ReadContext;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class CheckoutSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CheckoutSteps(ContextStore context) {
        this.context = context;
    }

    @And(".*selects Title for EU and APAC regions$")
    public void select_title(String title) throws Exception {
        if (!getRegionName().equalsIgnoreCase("NEWARK")) {
            actionMethods.selectValueByIndex(3, title);
        }
    }

    @And(".*would like to open a new Trade Account.*$")
    public void open_new_trade_Account() throws Exception {
        actionMethods.click("Checkout.wouldLikeToOpenNewTradeAcc_radio");
        if (store.equalsIgnoreCase("uk")||store.equalsIgnoreCase("ie")) {
            actionMethods.click("Checkout.newTradeAcc_radio");
        }
    }

    @And(".*click on \"([^\"]*)\" option in section 1 payment method if presented.*$")
    public void select_checkout_section1_tile(String locator) throws Exception {
        if (
            this.context.constants.getCreditCardTileSection1DisabledStores()
                .contains(store)
        ) {
            this.context.scenario.log("NA for current store:" + store);
        } else {
            actionMethods.click(locator);
        }
    }

    @And(
        ".*select trade account radio button and click continue button in section 4 payment method.*$"
    )
    public void select_trade_account_section4() throws Exception {
        if (store.equalsIgnoreCase("cn")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.tradeAccountChina_radio"
            );
            actionMethods.click("Checkout.tradeAccountChina_radio");
            if (uiMethods.isElementDisplayed("Checkout.invoiceTypeChina_radio")) {
                actionMethods.click("Checkout.invoiceTypeChina_radio");
                actionMethods.enterText(
                    this.context.constants.getInVoiceLocalName(),
                    "Checkout.invoiceLocalNameChina_radio"
                );
                actionMethods.enterText(
                    this.context.constants.getInVoiceLocalName(),
                    "Checkout.invoiceLocalEnglishNameChina_textbox"
                );
            }
            actionMethods.clickUsingJSExecutor(
                "Checkout.paymentDetailsSectionContinue_button"
            );
        } else if (store.equalsIgnoreCase("ph")) {
            this.context.scenario.log("Payment method section is N/A for this store");
        } else if (store.equalsIgnoreCase("cpc")) {
        	this.context.scenario.log("Payment method section is N/A for this store");
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.tradeAccount_radio"
            );
            actionMethods.click("Checkout.tradeAccount_radio");
            actionMethods.clickUsingJSExecutor(
                "Checkout.paymentDetailsSectionContinue_button"
            );
        }
    }
    
    @And("^.*user click on paypal or existing business account radio button in section 1*$")
    public void click_paypal_or_existing_business_button_section1() throws Exception {
            if (store.equalsIgnoreCase("cpc")) {
                actionMethods.waitForElementToAppear(
                    this.context.constants.getShortWaitSeconds(),
                    "Checkout.paypalPayment_radio"
                );
                actionMethods.clickUsingJSExecutor("Checkout.paypalPayment_radio");
            }else if (store.equalsIgnoreCase("de")||store.equalsIgnoreCase("cz"))
            {
            	actionMethods.waitForElementToAppear(
                        this.context.constants.getShortWaitSeconds(),
                        "Checkout.existingBusinessAcc_radio"
                    );
                actionMethods.clickUsingJSExecutor("Checkout.existingBusinessAcc_radio");
            }else
            {
            	actionMethods.waitForElementToAppear(
                        this.context.constants.getShortWaitSeconds(),
                        "Checkout.creditcardPaypal_radio"
                    );
                actionMethods.clickUsingJSExecutor("Checkout.creditcardPaypal_radio");
          }
      }
    
    @And("^.*user click on credit card or existing business account radio button in section 1*$")
    public void click_creditcard_or_existing_business_button_section1() throws Exception {
	    	if (store.equalsIgnoreCase("cpc")) {
	    		actionMethods.waitForElementToAppear(
	                     this.context.constants.getShortWaitSeconds(),"Checkout.creditCardCPC_radio");
	    		actionMethods.clickUsingJSExecutor("Checkout.creditCardCPC_radio");
	    	}else if (store.equalsIgnoreCase("de")||store.equalsIgnoreCase("cz"))
            {
            	actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(),
                        "Checkout.existingBusinessAcc_radio");
                actionMethods.clickUsingJSExecutor("Checkout.existingBusinessAcc_radio");
            }else
            {
            	actionMethods.waitForElementToAppear(
                        this.context.constants.getShortWaitSeconds(),
                        "Checkout.creditcardPaypal_radio"
                    );
                actionMethods.clickUsingJSExecutor("Checkout.creditcardPaypal_radio");
          }
      }
    
    @And("^.*user select paypal radio button and click continue button in section 4 payment method if presented*$")
    public void click_paypal_button_section4() throws Exception {
            if (!store.equalsIgnoreCase("cpc")) {
                actionMethods.waitForElementToAppear(
                    this.context.constants.getShortWaitSeconds(),
                    "Checkout.payPalPaymentDetails_radio"
                );
                actionMethods.clickUsingJSExecutor("Checkout.payPalPaymentDetails_radio");
                actionMethods.waitForElementToAppear(
                        this.context.constants.getShortWaitSeconds(),
                        "Checkout.paymentDetailsSectionContinue_button"
                    );
                actionMethods.clickUsingJSExecutor("Checkout.paymentDetailsSectionContinue_button");
            }
      }

    @And("^.*fill Checkout Your details section form using given file \"([^\"]*)\"$")
    public void enter_your_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        
        String emailTemp = actionMethods.generateRandomNumberString("guest_");
        String emailAddress = emailTemp + this.context.constants.getLocalEmailDomain();
        this.context.mailbox = emailTemp;
        
        logger.info("File values: " + firstName + "," + lastName + "," + emailAddress);

        if (
            !(getRegionName().equalsIgnoreCase("newark")) && !store.equalsIgnoreCase("ee")
        ) {
            context.scenario.log("User selects title for Guest user : Mr");
            actionMethods.selectValueByIndex(1, "Checkout.title_dropdown");
        }

        actionMethods.enterText(firstName, "Checkout.firstName_textbox");
        context.scenario.log("First Name : " + firstName);
        actionMethods.enterText(lastName, "Checkout.lastName_textbox");
        context.scenario.log("Last Name : " + lastName);
        actionMethods.enterText(emailAddress, "Checkout.email_textbox");
        context.scenario.log("Email : " + emailAddress);
        ContextStore.ORDER_TRACKING_EMAIL = emailAddress;
        if(store.equalsIgnoreCase("au")|| store.equalsIgnoreCase("nz")) {
        	actionMethods.click("Checkout.privacypolicy_checkbox");
        }
        // As part of STM4-1867, below fields are removed
        // actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
        // context.scenario.log("primaryRole dropdown value index 3");
        // actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
        // context.scenario.log("primary use dropdown value index 3");

    }

    @And("^.*fill Checkout Invoice address manually using given file \"([^\"]*)\"$")
    public void enter_Invoice_address(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String companyName = testData.get(0).get("billCompanyName");
        String officeName = testData.get(0).get("billOfficeName");
        String officePhone = testData.get(0).get("billOfficePhone");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String province = testData.get(0).get("billProvince");
        String zipCode = testData.get(0).get("billPostCode");

        if (!this.context.currentUserType.equalsIgnoreCase("guest")) {
            actionMethods.enterText(companyName, "Checkout.companyName_textbox");
            context.scenario.log("CompanyName :" + companyName);
        }

        actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
        context.scenario.log("AddressLine1 :" + addressLine1);
        actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
        context.scenario.log("AddressLine2 :" + addressLine2);
        actionMethods.enterText(city, "Checkout.townCity_textbox");
        context.scenario.log("City :" + city);

        if (officeName != null && !officeName.equalsIgnoreCase("skip")) {
            actionMethods.enterText(officeName, "Checkout.officeName_textbox");
            context.scenario.log("officeName :" + officeName);
            actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
            context.scenario.log("officePhone :" + officePhone);
        }

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
    }

    @And("^.*fill Credit Card Details using given file \"([^\"]*)\"$")
    public void enter_CreditCard_Details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String creditCardNum = testData.get(0).get("billCardNumber");
        String expiryMonth = testData.get(0).get("billCardExpiryMonth");
        String expiryYear = testData.get(0).get("billCardExpiryYear");
        String securityNum = testData.get(0).get("billCardSecurityNumber");
        String nameOnCard = testData.get(0).get("billNameOnCard");
        String cardHolderPhone = testData.get(0).get("billCardHolderPhone");
        String expirationDate = testData.get(0).get("expirationDate");

        if (!xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays.asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())) 
        {
            actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
        } else {
            int count=1;
            do {
                if(uiMethods.isElementDisplayed("Checkout.cardNumberWebtokenizeError_text"))
                {
                    driver.navigate().refresh();
                    actionMethods.waitForPageLoad(5);
                    }
                driver.switchTo().frame("webtokenize-iframeframe-card-1");
                if (uiMethods.isElementDisplayed("Checkout.tokenizeServiceError_text"))
                {
                    	driver.navigate().refresh();
                        actionMethods.waitForPageLoad(5);
                        driver.switchTo().frame("webtokenize-iframeframe-card-1");
                    }
                actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),
                        "Checkout.creditCardNumWebtokenize_textbox");
                actionMethods.clearText("Checkout.creditCardNumWebtokenize_textbox");
                actionMethods.enterText(creditCardNum,"Checkout.creditCardNumWebtokenize_textbox");
                actionMethods.pressTabKey("Checkout.creditCardNumWebtokenize_textbox");
                actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),
                        "Checkout.cardImage_element");
                logger.info("Loop count: "+count);
                driver.switchTo().parentFrame();
                count++;
            }
            while(!verifyCardImgInCreditCardField() && count < 4);
        }
        context.scenario.log("CreditCardNum :" + creditCardNum);
        if (uiMethods.isElementDisplayed("Checkout.expirationDate_textbox")) {
            actionMethods.enterText(expirationDate, "Checkout.expirationDate_textbox");
            context.scenario.log("expirationDate :" + expirationDate);
        } else {
            actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
            context.scenario.log("expiryMonth :" + expiryMonth);
            actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
            context.scenario.log("expiryYear :" + expiryYear);
        }

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-new");
            if (uiMethods.isElementDisplayed("Checkout.cvvWebtokenizeError_text"))
            {
            	driver.navigate().refresh();
                Thread.sleep(5000);
            }
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
        "^.*fill Additional Information Details for New Trade Account using given file \"([^\"]*)\"$"
    )
    public void enter_additional_information_Details(String FileName) throws Exception {
        if (region.equalsIgnoreCase("europe") || store.equalsIgnoreCase("hk")) {
            String path = FilePath + FileName;

            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

            String monthlySpend = testData.get(0).get("monthlySpend");
            String fullCompanyNameBuisness = testData
                .get(0)
                .get("fullCompanyNameBuisness");
            String legalEntity = testData.get(0).get("legalEntity");
            String accountsEmailBuisness = testData.get(0).get("accountsEmailBuisness");
            String companyRegistrationBusiness = testData
                .get(0)
                .get("companyRegistrationBusiness");
            String formVatNumberBuisness = testData.get(0).get("formVatNumberBuisness");
            String landlinenumber = testData.get(0).get("landLineNumber");
            String companyIncDate = testData.get(0).get("companyIncDate");
            actionMethods.enterText(monthlySpend, "Checkout.averageMonthlySpend_textbox");
            context.scenario.log(
                "Anticipated average monthly spend in GBP(given currency) :" +
                monthlySpend
            );
            actionMethods.enterText(
                fullCompanyNameBuisness,
                "Checkout.companyTradingName_textbox"
            );
            context.scenario.log("Full Company Trading Name :" + fullCompanyNameBuisness);
            actionMethods.selectValueByIndex(
                1,
                "Checkout.legalTradingEntry_list"
            );
            String legalTradingEntity = actionMethods.getValueUsingAttribute("Checkout.legalTradingEntry_list","value");
            context.scenario.log("Legal Trading Entity :" + legalTradingEntity);
            actionMethods.enterText(
                accountsEmailBuisness,
                "Checkout.accountPayableEmail_textbox"
            );
            context.scenario.log(
                "Finance/Accounts Payable Email Address :" + accountsEmailBuisness
            );
            actionMethods.enterText(landlinenumber, "Checkout.landLineNumber_textbox");
            context.scenario.log("Landline number:" + landlinenumber);

            if (
                companyRegistrationBusiness != null &&
                !companyRegistrationBusiness.equalsIgnoreCase("skip")
            ) {
                actionMethods.enterText(
                    companyRegistrationBusiness,
                    "Checkout.companyRegistrationBusiness_textbox"
                );
                context.scenario.log(
                    "company Registration Business SIRET:" + companyRegistrationBusiness
                );
            }
            if (
                formVatNumberBuisness != null && !formVatNumberBuisness.equalsIgnoreCase("skip")
            ) {
                actionMethods.enterText(
                    formVatNumberBuisness,
                    "Checkout.formVatNumberBuisness_textbox"
                );
                context.scenario.log("form Vat Number Buisness:" + formVatNumberBuisness);
            }
            if (store.equalsIgnoreCase("cpc")) {
            	actionMethods.enterText(
            			companyIncDate,
                    "Checkout.companyIncDate_textbox"
                );
                context.scenario.log("company incorporation date:" + companyIncDate);
            }
            actionMethods.clickUsingJSExecutor(
                "Checkout.additionalInformationContinue_button"
            );
            Thread.sleep(4000);
            context.scenario.log(
                "I verify Additional Information Details section edit button element" +
                uiMethods.isElementDisplayed(
                    "Checkout.editAdditionalInformation_button"
                ) +
                "is present on page"
            );
        } else {
            this.context.scenario.log(
                    "Additional Details Section is N/A for Newark and apac region"
                );
        }
    }

    @And(
        "^.*fill Checkout Invoice address by entering four characters in auto Search textbox.* \"([^\"]*)\"$"
    )
    public void invoice_address_using_autosearch(String textToSearch) throws Exception {
        // address vertification service has unlimited calls for specific stores,
        // if current store part of the list, go ahead else enter address
        // manually

        if (
            !this.getEnv().equalsIgnoreCase("pp") &&
            !this.getEnv().equalsIgnoreCase("cicd") &&
            this.context.constants.getAddressVerificationStores().contains(getStore())
        ) {
            actionMethods.enterText(
                textToSearch,
                "Checkout.billingAddressSearch_textbox"
            );
            Thread.sleep(7000);
            actionMethods.click("Checkout.firstBillingAddressSearch_link");
            Thread.sleep(3000);
            actionMethods.enterText("ABC Pvt Ltd", "Checkout.companyName_textbox");
        } else {
            if (
                xcomregConfig.getProperty("AV_ENABLED_N").isEmpty() ||
                !Arrays
                    .asList(xcomregConfig.getProperty("AV_ENABLED_N").split(","))
                    .contains(getStore())
            ) {
                actionMethods.click("Checkout.addAddressManually_link");
            }
            enter_Invoice_address("OrderInformation.xlsx");
        }
    }

    @And(
        "^.*enter Trade account Account number and CID details using given file \"([^\"]*)\"$"
    )
    public void enter_account_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String tradeAccountNumber = testData.get(0).get("billAccountNumber");
        String CIDNumber = testData.get(0).get("billCustomerID");
        if (region.equalsIgnoreCase("newark") || store.equalsIgnoreCase("cpc")) {
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
        } else {
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
            actionMethods.enterText(CIDNumber, "Checkout.cid_textbox");
        }
        context.scenario.log("trade account number: " + tradeAccountNumber);
        context.scenario.log("Customer ID (CID): " + CIDNumber);
    }

    @And(".*enter random PO Number on Order Review section$")
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

    @And("^.*checks terms and conditions checkbox and click on Submit Order button$")
    public void check_TandC_and_click_on_SubmitOrder_button() throws Exception {
        //Enter VAT Number if mandatory
        if (
            Arrays
                .asList(
                    xcomregConfig
                        .getProperty("VAT_NUMBER_AS_MANDITORY_FLAG_TRUE")
                        .split(",")
                )
                .contains(getStore())
        ) {
            String VATNo = this.context.constants.getValidVATNumber();
            actionMethods.enterText(VATNo, "Checkout.paymentVatNumber_textbox");
            this.context.scenario.log("VAT Number: " + VATNo);
        }

        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            if (!(getRegionName().equalsIgnoreCase("NEWARK"))) {
                actionMethods.click("Checkout.termsAndConditions_checkbox");
            }
            Thread.sleep(5000);
            actionMethods.clickUsingJSExecutor("Checkout.submitOrder_button");
        }
    }

    @And("^.*gets Order confirmation Number$")
    public void get_order_confirmation_number() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            String orderConfirmationNo = null;
            orderConfirmationNo =
                actionMethods.getValue("Checkout.orbitOrderConfirmationText_text");            
            context.scenario.log("Order confirmation No: " + orderConfirmationNo);
            if (orderConfirmationNo.contains("STUB_")) {
                ContextStore.STUB_ENABLED = true;
            }
            ContextStore.ORDER_TRACKING_ORDER_CONFIRMATION_NUM = orderConfirmationNo;
        }
    }

    @And(
        "^.*verify order confirmation message is present on page and display.*in report$"
    )
    public void verify_order_confirmation_display_in_report() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            actionMethods.waitForByElementToAppear(
                this.context.constants.getLongWaitSeconds(),
                "Checkout.orderConfirmationTitle_text"
            );
            Assert.assertTrue(
                uiMethods.isElementDisplayed("Checkout.orderConfirmationTitle_text")
            );
            String value = actionMethods.getValue("Checkout.orderConfirmationTitle_text");
            Assert.assertFalse("Text is missing", value.isEmpty());
            this.context.scenario.log(
                    "The value of the element verified on page: " + value
                );
        }
    }

    @And("I continue only if guest checkout feature is enabled")
    public void check_Guest_checkout_feature_flag() {
        if (
            Arrays
                .asList(
                    xcomregConfig.getProperty("ENABLE_GUEST_CHECKOUT_FALSE").split(",")
                )
                .contains(getStore())
        ) {
            assumeTrue("NA for this store:" + store, false);
        }
    }

    @And("^.*check terms and conditions checkbox and click on Paypal button$")
    public void check_TandC_and_click_on_Paypal_button() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            if ((getRegionName().equalsIgnoreCase("APAC"))) {
                this.context.scenario.log("Paypal NA for APAC");
            }else if(!(getRegionName().equalsIgnoreCase("NEWARK"))) {
                actionMethods.click("Checkout.termsAndConditions_checkbox");
            }
            actionMethods.click("Checkout.payPal_button");
            Thread.sleep(10000);
        }
    }

    @And("^.*enter cvv number \"([^\"]*)\"$")
    public void enter_cvv_number(String securityNum) throws Exception {
        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-express");
            actionMethods.enterText(securityNum, "Checkout.cvvWebtokenize_textbox");
            driver.switchTo().parentFrame();
        }
        context.scenario.log("securityNum :" + securityNum);
    }

    @And("^I check if the order is sent$")
    public void check_if_order_send() throws Exception {
        if (uiMethods.isElementDisplayed("Checkout.shareOrderUnavailable_message")) {
            assumeTrue("The Order is still processing message is dispalyed!!", false);
            context.scenario.log("The order is still processing message is displayed!");
        }
    }

    @And(
        "^.*select Shipping method option.* and display its name in report$"
    )
    public void select_shipping_option() throws Exception {
    	actionMethods.click("Checkout.partialDeliveryCharge_text");
    	String deliveryCharge=actionMethods.getValue("Checkout.partialDeliveryCharge_text");
    	String deliveryMethod=actionMethods.getValue("Checkout.partialDeliveryOption_text");
 
        this.context.scenario.log("The Delivery Method title is : " + deliveryMethod);
        this.context.scenario.log(
                "The Delivery/Shipping charge for selected delivery method is : " +
                deliveryCharge
            );
        ContextStore.shippingCharge = deliveryCharge;
    }

    @And("^.* verify shipping charge is applied in Order Total$")
    public void verify_shiping_charge_applied() throws Exception {
        String actualCharge = actionMethods
            .getValue("Checkout.shippingChargePrice")
            .trim();
        this.context.scenario.log(
                "The applied Delivery/Shipping charge from order total is : " +
                actualCharge
            );
        Assert.assertEquals(actualCharge, ContextStore.shippingCharge);
    }

    @And("^.*enter \"([^\"]*)\" credit card details from json \"([^\"]*)\"$")
    public void enter_CreditCard_Details_json(String cardType, String FileName)
        throws Exception {
        String path = FilePath + FileName;
        ReadContext rx = JsonUtil.getJsonDocument(path);

        String creditCardNum = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".cardnumber"
        );
        String expiryMonth = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".expirymonth"
        );
        String expiryYear = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".expiryyear"
        );
        String securityNum = JsonUtil.getKeyValueFromCommonJson(rx, cardType + ".cv2");
        String nameOnCard = JsonUtil.getKeyValueFromCommonJson(rx, cardType + ".name");
        String cardHolderPhone = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".phonenumber"
        );
        String expirationDate = expiryMonth + "/" + expiryYear;

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
        if (uiMethods.isElementDisplayed("Checkout.expirationDate_textbox")) {
            actionMethods.enterText(expirationDate, "Checkout.expirationDate_textbox");
            context.scenario.log("expirationDate :" + expirationDate);
        } else {
            actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
            context.scenario.log("expiryMonth :" + expiryMonth);
            actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
            context.scenario.log("expiryYear :" + expiryYear);
        }

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-new");
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

    /*method for unionpay taking details from json credit card file */
    @And(
        "^.*enter the \"([^\"]*)\" card \"([^\"]*)\" in textbox \"([^\"]*)\" from json \"([^\"]*)\"$"
    )
    public void enter_UnionPayCreditCard_Details_json(
        String cardType,
        String value,
        String locator,
        String FileName
    ) throws Exception {
        String path = FilePath + FileName;
        ReadContext rx = JsonUtil.getJsonDocument(path);

        String outputValue = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + "." + value
        );

        actionMethods.enterText(outputValue, locator);
    }

    /**
     * Method to submit details on 3D auth screen, it is somtimes asked for visa credit cards.
     * @param cardType
     * @param FileName
     * @throws Exception
     */
    @And(
        "^.*submit details on 3D Auth screen to verify \"([^\"]*)\" credit card if asked$"
    )
    public void enter_password_auth_screen(String cardType) throws Exception {
        if (cardType.equalsIgnoreCase("visa")) {
            actionMethods.waitForURLContains(
                this.context.constants.getMediumWaitSeconds(),
                "ThreedAuthView"
            );
            if (driver.getCurrentUrl().contains("ThreedAuthView")) {
                try {
                    driver.switchTo().frame("cardframe");
                    actionMethods.enterText(
                        this.context.constants.getThreedAuthPassword(),
                        "ThreedAuthView.password_textbox"
                    );
                    actionMethods.click("ThreedAuthView.submit_button");
                } catch (Exception e) {}
            } else {
                this.context.scenario.log("3d auth screen is not displayed");
            }
        } else {
            this.context.scenario.log("NA for card type - " + cardType);
        }
    }

    @And("I select credit card or paypal Payment method in section one for DE store")
    public void select_payment_method() throws Exception {
        String path = FilePath + "OrderInformation.xlsx";

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String tradeAccountNumber = testData.get(0).get("billAccountNumber");
        String CIDNumber = testData.get(0).get("billCustomerID");

        if (store.equalsIgnoreCase("de")) {
            actionMethods.click("Checkout.existingTradeAcc_radio");
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
            actionMethods.enterText(CIDNumber, "Checkout.cid_textbox");
        } else {
            actionMethods.click("Checkout.creditcardPaypal_radio");
        }
    }

	//creditCardCPC_radio
    @And("I select credit card Payment method in section one for CPC store and continue")
    public void select_cc_in_CPC() throws Exception {
    	if (store.equalsIgnoreCase("cpc")) {
    		actionMethods.click("Checkout.creditCardCPC_radio");
    		actionMethods.click("Checkout.paymentdetailContinue_button");
    	}
    }
    
    @And("^.*fill Additional Information Details for iBuy Account user$")
    public void enter_additional_information_ibuy() throws Exception {
        actionMethods.enterText("01XY-%A22", "Checkout.customFieldTwo_textbox");
        if (!(getRegionName().equalsIgnoreCase("newark"))) {
            actionMethods.selectValueByValue("PCABC", "Checkout.costcode_dropdown");
        }
    }
    
    @And("user register itself on Order Confirmation Page and click on Create Account button")
    public void enter_registration_detail_on_OCP_Page() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
        	 actionMethods.waitForElementToAppear(
                     this.context.constants.getShortWaitSeconds(),
                     "Checkout.creatingOnlineAccount_text"
                 );
        	
        	 String path = "";
             String emailAddress = null;
             path = FilePath + "OCPRegistration.xlsx";
             
             List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
             Thread.sleep(6000);
             String username = actionMethods.generateRandomNumberString(
                 testData.get(0).get("username")
             );
             emailAddress = username + this.context.constants.getEmailDomain();
             
             String primaryJob = testData.get(0).get("primaryJob");
             String primaryUse = testData.get(0).get("primaryUse");
             String phoneNumber = testData.get(0).get("phoneNumber");
             String password = this.context.constants.getPassword();
             
             actionMethods.clearText("Checkout.emailAddress_textbox");
             actionMethods.enterText(emailAddress, "Checkout.emailAddress_textbox");
             context.scenario.log("Email for new user: " + emailAddress);
             this.context.currentUser = emailAddress;
             
             if (primaryJob == null || primaryJob.equalsIgnoreCase("skip")) {} else {
                 actionMethods.selectValueByValue(primaryJob, "Checkout.primaryRole_dropdown");
             }
             if (primaryUse == null || primaryUse.equalsIgnoreCase("skip")) {} else {
                 actionMethods.selectValueByValue(primaryUse, "Checkout.primaryUse_dropdown");
             }
             if (phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")) {} else {
                 actionMethods.enterText(phoneNumber, "Checkout.phoneNumber_textbox");
             }
             
             actionMethods.enterText(password, "Checkout.password_textbox");
             context.scenario.log("Password for new user: " + password);
             actionMethods.click("Checkout.createAccount_button");
        }
    }
    
    @And("user verifies that it lands on the Account Summary Page")
    public void verify_account_summary_page() throws Exception {
    	 if (getEnv().equalsIgnoreCase("live")) {
             this.context.scenario.log("NA for LIVE sites");
         } else {
             actionMethods.waitForElementToAppear(
                 this.context.constants.getLongWaitSeconds(),
                 "AccountSummary.myAccountSummary_text"
             );
             Assert.assertTrue(
                 uiMethods.isElementDisplayed("AccountSummary.myAccountSummary_text")
             );
             String value = actionMethods.getValue("AccountSummary.myAccountSummary_text");
             Assert.assertFalse("Text is missing", value.isEmpty());
             this.context.scenario.log(
                     "The value of the element verified on page: " + value
                 );
         }
    }
    
    @And("user verifies tax exempt texts on Order Review section")
	public void verify_tax_exempt_text_on_Order_Review() throws Exception {

			String text = checkoutConfig.getProperty("taxExemptSubtitle_text");
			logger.info("Tax Exempt text: " + text);
			actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(),
					"Checkout.taxExemptSubtitle_text");
			Assert.assertTrue(uiMethods.isElementDisplayed("Checkout.taxExemptSubtitle_text"));
			uiMethods.verifyTextExistence(text, "Checkout.taxExemptSubtitle_text");
	
			uiMethods.verifyTextExistence("Apply Tax Exempt for this order","Checkout.taxExemptLabel_text");
			  actionMethods.clickUsingJSExecutor("Checkout.taxExemptTooltip_element");
			  actionMethods.waitForElementToAppear(
			  this.context.constants.getLongWaitSeconds(),
			  "Checkout.taxExemptTooltip_text");
			  Assert.assertTrue(uiMethods.isElementDisplayed(
			  "Checkout.taxExemptTooltip_text")); uiMethods.
			  verifyTextExistence("You must have a Tax Exemption certificate on file with the Tax Department in order to be Tax Exempt"
			 + " for this order.", "Checkout.taxExemptTooltip_text");
			  actionMethods.clickUsingJSExecutor("Checkout.taxExemptTooltip_element");
			  actionMethods.waitForElementToAppear(
			  this.context.constants.getLongWaitSeconds(), "Checkout.taxExemptDesc_text");
			  uiMethods.
			  verifyTextExistence("Note: If Tax Exempt status is set for your account, it can't be changed for an individual order. "
			  +
			  "If you think the tax exempt status of your order or account is incorrect, please contact us at 1-800-463-9275."
			  , "Checkout.taxExemptDesc_text");
		 
	}

	@And("user checks its tax exempt status on Order Review")
	public void verify_tax_exempt_status() throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(),
				"Checkout.taxExemptNotVerifiedIcon_element");
		Assert.assertTrue(uiMethods.isElementDisplayed("Checkout.taxExemptNotVerifiedIcon_element"));
		uiMethods.verifyTextExistence("Tax exempt status is not verified yet.", "Checkout.taxExemptNotVerified_text");
		uiMethods
				.verifyTextExistence(
						"We will verify your Tax Exempt status within 7 days and if applicable, you get a refund."
								+ " The status will be saved for later purchases.",
						"Checkout.taxExemptNotVerifiedDesc_text");
	}
	
	/* Method to verify the exact text on page (handles the translated text for non-English store) 
	 * Fetches text value from the property file
	 * */
	@And("^.*verify text.* \"([^\"]*)\" on .* \"([^\"]*)\"$")
	public void verifyActualText(String value, String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		String exp_Value = storeText.getStoreText(checkoutConfig.getProperty(value));
		String act_Value = actionMethods.getValue(locator);
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertEquals(exp_Value, act_Value);
	}
	
	/* Method to verify the partial text on page(handles the translated text for non-English store) 
	 * Fetches text value from the property file
	 **/
	@And("^.*verify.*contains.* \"([^\"]*)\" .*on.* \"([^\"]*)\"$")
	public void verifyPartialText(String value, String locator) throws Exception {
		actionMethods.waitForElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		WebElement elementObj = getLocator(locator);
		String exp_Value = storeText.getStoreText(checkoutConfig.getProperty(value));
		actionMethods.waitForAttributeToContain(this.context.constants.getShortWaitSeconds(), locator, "innerText",exp_Value);
		String act_Value = elementObj.getText();
		logger.info("Actual text obtained from the page: " + act_Value);
		Assert.assertTrue("Partial string is not present in the expected message", act_Value.contains(exp_Value));
	}
	
	 @And("^.*verify export website link txt is present*$")
	    public void verify_Export_Website_Linktxt() throws Exception {
	        String actualexportlinktxt = actionMethods
	            .getValue("Checkout.invoiceDeliveryAddressExportWebsite_LinkTxt")
	            .trim();
	      String  expectedexportlinktxt=storeText.getStoreText("If you want to ship to a country that is not listed, use our export website.");
	    		  
	        if (actualexportlinktxt.equalsIgnoreCase(expectedexportlinktxt)) {
	            Assert.assertTrue(true);
	           
	        this.context.scenario.log(
	                "Export Website link Txt :" +
	                		actualexportlinktxt
	            );
	       
	    }
	}
	    
	    
	    @And(".*I click on export website link*$")
	    public void click_export_website_link() throws Exception 
	    { 
	    
	    WebElement element = driver.findElement(By.xpath("//*[@class='export-website-msg']//a"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    }    
	    
	    @And(".*I click on delivery address checkbox*$")
	    public void click_delivery_address_checkbox() throws Exception 
	    {
	    	
	    	 WebElement elementchkbox = driver.findElement(By.xpath("//div[@class=' col-lg-6 shippingAddress']/div/label/p/input"));
	       JavascriptExecutor jse = (JavascriptExecutor)driver;
	       jse.executeScript("arguments[0].click();", elementchkbox );

	         
	        
	    }
	    
	    public Boolean verifyCardImgInCreditCardField() throws Exception
        {
	        String cardIconClassName = actionMethods.getValueUsingAttribute("Checkout.creditCardNum_textbox","class");
	        logger.info("Card Name: "+cardIconClassName);
            if(cardIconClassName.contains("hasCard"))
            {
                return true;
            }else
                return false;
        }


}
