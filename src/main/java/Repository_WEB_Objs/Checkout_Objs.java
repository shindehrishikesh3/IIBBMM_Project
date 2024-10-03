package Repository_WEB_Objs;

import java.util.*;

public class Checkout_Objs {

    // Creation of HashMap
    private static final Map<String, String> Checkout;

    static {
        Checkout = new HashMap<String, String>();

        // Your Details Section
        Checkout.put("yourDetails_form", "//form[@id= 'area0']");
        Checkout.put("title_dropdown", "//*[@id = 'guestUserTitle']");
        Checkout.put("firstName_textbox", "//*[@id='billingfirstname']");
        Checkout.put("lastName_textbox", "//*[@id='billinglastname']");
        Checkout.put("email_textbox", "//*[@id='billEmail']");
        Checkout.put("primaryRole_dropdown", "//*[@id='primaryRole']");
        Checkout.put("primaryUse_dropdown", "//*[@id='primaryUse']");
        Checkout.put("yourDetailsSectionContinue_button", "//*[@id='area0Continue']");
        Checkout.put(
            "greenTickMarkSection1_icon",
            "//*[@id='area0Accordion']//*[name()='svg']"
        );
        
      //  Checkout.put("privacypolicy_checkbox","//div[@id='agreePrivacyPolicyDiv']/p/input");
        Checkout.put("privacypolicy_checkbox","//*[@id='agreePrivacyPolicy']");
        Checkout.put("privacypolicy_labeltxt","//span[@id='agreePrivacyPolicyLabel']");
        Checkout.put("privacypolicy_link","//span[@id='agreePrivacyPolicyLabel']/a[1]");
        Checkout.put("privacyPolicyTitle_text", "//h1");
        Checkout.put("requiredfield_text", "//label[@id='agreePrivacyPolicy-error']");
        Checkout.put("marketingOptIn_text", "//*[@id='agreePrivacyPolicyLabel']");
        Checkout.put("premierFarnellGroup_link", "//*[@id='agreePrivacyPolicyLabel']/a");
        Checkout.put("termsOfAccessTitle_text", "//h1");
        Checkout.put("privacyMoreInfo_text", "//*[@class='privacyMoreInfo']");
        Checkout.put("privacyPolicy_link", "//*[@class='privacyMoreInfo']/a");
        Checkout.put("signUpMarketingEmail_text", "//*[@id='area0Review']//div[3]//div[@class='bx--col-4']");
      
        //Payment Method Section 1
        Checkout.put("paymentMethod_text", "//*[@id='area1Accordion']//h4");
        Checkout.put(
            "editPaymentMethod_button",
            "//*[@id='area1Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("tradeAccountOption_radio", "//*[@id='selectAccount_tradeAccount']");
        Checkout.put(
            "existingTradeAcc_radio",
            "//*[@id='tradeAccountOptions_addExistingAccount']"
        );
        Checkout.put("existingBusinessAcc_radio","//*[@id='addExistingTradeAccount']");
        Checkout.put(
            "wouldLikeToOpenNewTradeAcc_radio",
            "//*[contains(@class,'openNewTradeAccount')]"
        );
        Checkout.put("newTradeAcc_radio", "//*[@id='newTradeAcc_businessCredit']");
        Checkout.put("tradeAccno_textbox", "//*[@id='busiAccNo']");
        Checkout.put("cid_textbox", "//*[@id='customerId']");
        Checkout.put(
            "creditcardPaypal_radio",
            "//div[contains(@data-trck-payment-method,'Credit card')]"
        );
        Checkout.put(
            "creditcardPayment_radio",
            "//div[contains(@class,'creditCardPayment')]"
        );
        Checkout.put(
                "paypalPayment_radio",
                "//div[contains(@data-trck-payment-method,'PayPal')]"
            );
        Checkout.put("syncAccount_radio", "//input[@id='tradeAccountOptions_1']");
        Checkout.put("paymentdetailContinue_button", "//*[@id='area1Continue']");
        Checkout.put("creditCardCPC_radio", "//*[@id='selectAccount_nonTradeAccount']");
        Checkout.put("tradeaccount_header", "//*[@id='paymentOptionsContainer']/fieldset/legend");
        Checkout.put("tradeaccount_tooltip", "//*[@id='paymentOptionsContainer']/fieldset/legend/a/span[@class='icon icon-info-circled']");
        Checkout.put("tradeaccount_tooltiptext", "//*[@class='tooltip']/span");

        // Invoice and Delivery address Section
        Checkout.put("invoiceAndDeliveryAddress_text", "//*[@id='area2Accordion']//h4");
        Checkout.put(
            "editInvoiceAndDeliveryAddress_button",
            "//*[@id='area2Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("editInvoiceAddress_button","//*[@id='billingAddress1']//*[@name='editBtn']");
        Checkout.put("addAddressManually_link", "//a[@id='addAddressManually']");
        Checkout.put("companyName_textbox", "//input[@id='billingOrganizationName']");
        Checkout.put("attentionOf_textbox", "//*[@id='billingOfficeAddress']");
        Checkout.put("officeName_textbox", "//input[@id='billingOfficeName']");
        Checkout.put("officePhone_textbox", "//input[@id='billingOfficePhone1']");
        //Checkout.put("addressLaneOne_textbox", "//input[@id='billingAddress1']");
        //Checkout.put("addressLaneOne_textbox", "(//input[@name='billingAddress1'])[1]");
        //Checkout.put("addressLaneTwo_textbox", "//input[@id='billingAddress2']");
        Checkout.put(
            "addressLaneOne_textbox",
            "//input[@id='billingAddress1' or @name='billingAddress1']"
        );
        Checkout.put(
            "addressLaneTwo_textbox",
            "//input[@id='billingAddress2' or @name='billingAddress2']"
        );

        Checkout.put("townCity_textbox", "//input[@id='billingCity']");
        Checkout.put("countryProvince_textbox", ".//input[@id='billingState']");
        Checkout.put("state_dropdown", ".//select[@name='billingState']");
        Checkout.put("country_dropdown", "//select[@id='billingCountry']");
        Checkout.put("zipCode_textbox", "//input[@id='billingZipCode']");
        Checkout.put("zipCodeError_textbox", "//*[@id='billingZipCode-error']");
        Checkout.put(
            "addressSectionContinue_button",
            "//div[contains(@class,'addressPanel')]/div[2]/button"
        );
        Checkout.put(
            "greenTickMarkSection2_icon",
            "//*[@id='area2Accordion']//*[contains(@class,'indicator--svg')]"
        );
        Checkout.put(
            "invoiceDeliveryAddressContinue_button",
            "//*[@class='btn btnPrimary continueBtn']"
        );
        Checkout.put(
                "invoiceDeliveryAddressExportWebsite_LinkTxt",
                "//div[@class='export-website-msg']/span"
            );
        Checkout.put(
                "invoiceDeliveryAddressExport_Link",
                "//div[@class='export-website-msg']/span/a"
            );
        Checkout.put("deliveryAddress_Checkbox","//div[@id='deliveryAddressContainer']/div/div[1]/div/div/div/div[2]");
        Checkout.put("addBillingAddress_link", "//*[@id='addBillingAddressLink']");
        Checkout.put("addAddress_button", "//*[@class='btn btnPrimary addAddressBtn']");
        Checkout.put("saveAddress_button", "//*[@class='btn btnPrimary saveAddressBtn']");
        
        // To select the Address using experion search
        Checkout.put("billingCountry_dropdown", "//*[@id='billingCountry']");
        Checkout.put("billingAddressSearch_textbox", "//*[@id='billingAddressSearch']");
        Checkout.put(
            "firstBillingAddressSearch_link",
            "(//*[@id='billingAddressSearchautocomplete-list']/div)[1]"
        );

        // Delivery options/instructions Section
        Checkout.put("deliveryOptions_text", "//*[@id='area3Accordion']//h4");
        Checkout.put(
            "editDeliveryOptions_button",
            "//*[@id='area3Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("deliveryMethodSecond_radio", "//*[@id='recDeliveryMethodId_2']");
        Checkout.put(
            "deliveryInstructions_textbox",
            "//*[@id='deliveryInstructionsForCarrier' or @id='additionalDeliveryNotes']"
        );
        Checkout.put(
            "deliverySectionContinue_button",
            "//*[@id='deliveryOptionContinue']"
        );
        Checkout.put(
            "greenTickMarkSection3_icon",
            "//*[@id='area3Accordion']//*[name()='svg']"
        );
        Checkout.put("partialDeliveryCharge_text", "//*[@class='deliveryCharge']");
        Checkout.put("partialDeliveryOption_text", "(//span[@class='shippingTitle'])");

        // Payment Details Section-4
        Checkout.put("paymentDetails_text", "//*[@id='area4Accordion']//h4");
        Checkout.put(
            "editPaymentDetails_button",
            "//*[@id='area4Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("tradeAccount_radio", "//span[@class='tradeAccHeading']");
        Checkout.put("tradeAccountChina_radio", "//*[@id='paymentType_TradeAccount']");
        Checkout.put("invoiceTypeChina_radio", ".//*[@id='invoiceType']/div[2]");
        Checkout.put("invoiceLocalNameChina_radio", "//*[@id='invoiceLocalName-b']");
        Checkout.put(
            "invoiceLocalEnglishNameChina_textbox",
            "//*[@id='invoiceEnglishName-b']"
        );
        Checkout.put(
            "billingAddress_checkbox",
            "//input[@id='billingInvoiceAddressMatchId']"
        );
        Checkout.put(
            "payPalPaymentDetails_radio",
            "//div[contains(@class,'payPalPayment')]"
        );
        Checkout.put("creditCardNum_textbox", "//*[@id='cardNumber']");
        Checkout.put(
            "creditCardNumWebtokenize_textbox",
            "//*[@class='show']/*[@id='PAN']"
        );
        Checkout.put("expirationDate_textbox", "//*[@id='validExpiry']");
        Checkout.put("expiryMonth_dropdown", "//*[@id='validExpiryMonth']");
        Checkout.put("expiryYear_dropdown", "//*[@id='validExpiryYear']");
        Checkout.put("cvv_textbox", "//*[@id='paymentMethodCardIssueCv2']");
        Checkout.put("cvvWebtokenize_textbox", "//*[@class='show']/*[@id='CVV2']");
        Checkout.put("nameOnCard_textbox", "//*[@id='nameOnCard']");
        Checkout.put("cardHolderPhone_textbox", "//*[@id='cardHolderPhone']");
        Checkout.put("phoneNumberError_text", "//label[@id='cardHolderPhone-error']");
        Checkout.put(
            "paymentDetailsSectionContinue_button",
            "//button[contains(@class,'btn btnPrimary continueBtn')]"
        );
        Checkout.put("cashOnDelivery_radio", "//*[@id='paymentType_CashOnDelivery']");
        Checkout.put("unionPay_radio", "//*[@id='paymentType_Unionpay']");
        Checkout.put("bankTransfer_radio", "//*[@id='paymentType_BankTransfer']");
        Checkout.put("cardOnDelivery_radio", "//*[@id='paymentType_CardOnDelivery']");
        Checkout.put("paypalDisablemsg_text", "//*[@id='paymentDetailsContainer']/p");

        //Checkout.put("freeTextInvoice_radio", ".//*[@id='invoiceType']/div[2]");
        Checkout.put("freeTextInvoice_text", "//*[@id='invoiceLocalName-b']"); //shares id with "invoiceLocalNameChina_radio"
        Checkout.put("invoiceEnglishName_text", "//*[@id='invoiceEnglishName-b']");
        //unionpay
        Checkout.put("unionPayWindow_element", "//*[@class='insecure-form']");
        Checkout.put("sendAnyway_button", "//*[@id='proceed-button']");
        Checkout.put("next_button", "//*[@id='btnNext']");
        Checkout.put("expireMonth_textbox", "//*[@id='expireMonth']");
        Checkout.put("expireYear_textbox", "//*[@id='expireYear']");
        Checkout.put("cvn2_textbox", "//*[@id='cvn2']");
        Checkout.put("smsCode_textbox", "//*[@id='smsCode']");
        Checkout.put("getSMSCode_button", "//*[@id='btnGetCode']");
        Checkout.put("agreement_checkbox", "//*[@id='isCheckAgreement']");
        Checkout.put("completeUnionPay_button", "//*[@id='btnCardPay']");
        Checkout.put("unionPaySuccess_element", "//*[@id='successIcon']");
        Checkout.put("returnToMerchant_button", "//*[@id='btnBack']");
        Checkout.put("cardNumberWebtokenizeError_text", "//*[@id='webtokenize-error-frame-card-1']");
        Checkout.put("cvvWebtokenizeError_text", "//*[@id='webtokenize-error-frame-cvv-new']");
        Checkout.put("tokenizeServiceError_text", "//*[contains(text(),'An error occurred while processing your request.')]");
        Checkout.put("cardImage_element", "//*[@class='cardImagesWrapper']");
        
        //Additional information for New Trade Account
        Checkout.put("averageMonthlySpend_textbox", "//*[@id='monthlySpend']");
        Checkout.put(
            "editAdditionalInformation_button",
            "//*[@id='area5Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("companyTradingName_textbox", "//*[@id='fullCompanyNameBuisness']");
        Checkout.put("legalTradingEntry_list", "//*[@id='legalEntity']");
        Checkout.put("accountPayableEmail_textbox", "//*[@id='accountsEmailBuisness']");
        Checkout.put(
            "additionalInformationContinue_button",
            "//*[@id='area5']/div[2]/div/button"
        );
        Checkout.put(
            "companyRegistrationBusiness_textbox",
            "//*[@id='companyRegistrationBuisness']"
        );
        Checkout.put("formVatNumberBuisness_textbox", "//*[@id='formVatNumberBuisness']");
        Checkout.put("companyIncDate_textbox", "//*[@id='companyIncorporationDate']");

        // Order Review Section
        Checkout.put("poNumber_textbox", "//input[@name='poNumberId']");
        Checkout.put("termsAndConditions_checkbox", "//*[@name='termsConditions3']");
        Checkout.put(
            "submitOrder_button",
            "(//*[contains(@class,'checkout-side')])//button[contains(@class,'submitOrder')]"
        );
        Checkout.put(
            "payPal_button",
            "(//div[@class='stickySidebar enhanceCartStickySidebar']//div[contains(@class,'paypal')])"
        );
        // Checkout.put("paypalLoginWindow_element", "//section[@data-title='Log in to your PayPal account']");
        Checkout.put("paypalLoginWindow_element", "//h1[@id='headerText']");
        Checkout.put("taxExemptSubtitle_text", "//*[@class='order-review-subtitle'][2]");
        Checkout.put("taxExemptLabel_text", "//*[@id='tax-exmpt-label']");
        Checkout.put("taxExemptTooltip_element", "//*[@id='tax-exmpt-label']//*[@class='tooltipIconCircle']");
        Checkout.put("taxExemptTooltip_text", "//*[@id='tax-exmpt-label']//*[@class='tooltip-content']");
        Checkout.put("taxExemptDesc_text", "//*[@id='taxExemptDesc']");
        Checkout.put("taxExempt_checkbox", "//*[@name='paymentMethodExemptionAnswer']");
        Checkout.put("taxExemptVerifiedIcon_element", "//*[@id='taxExemptVerifiedIcon']");
        Checkout.put("taxExemptVerified_text", "//*[@id='taxExemptVerified']");
        Checkout.put("taxExemptNotVerifiedIcon_element", "//*[@id='taxExemptNotVerifiedIcon']");
        Checkout.put("taxExemptNotVerified_text", "//*[@id='taxExemptNotVerifiedIcon']");
        Checkout.put("taxExemptNotVerifiedDesc_text", "//*[@id='taxExemptNotVerifiedDesc']");
        
        // Order Confirmation Page
        Checkout.put(
            "orderConfirmationTitle_text",
            "//div[@id='orderConfirmation']//h1[@class='bx--row__title']"
        );
        Checkout.put(
            "orbitOrderConfirmationText_text",
            "//*[contains(@class,'confirmationContainer')]//strong/span"
        );
        Checkout.put("phoneNumber_textbox", "//input[@name='phone1']");
        Checkout.put("username_textbox", "//*[@id='logonId']");
        Checkout.put("password_textbox", "//*[@id='logonPassword']");
        Checkout.put("createAccount_button", "//button[@class='btn btnPrimary']");
        Checkout.put("scheduleConfirmation_message", "(//tr[@class='dateGroupLine'])[2]");
        Checkout.put(
            "scheduleConfirmationdate_message",
            "(//tr[@class='dateGroupLine'])[2]//td//h2//input"
        );
        Checkout.put("landLineNumber_textbox", "//*[@id='landLinePhoneNumber']");
        Checkout.put(
            "shareOrder_button",
            "//*[@class='checkout-cta continueBtnSpinner']//a[@class='btn btnTertiary']"
        );
        Checkout.put("creatingOnlineAccount_text", "//*[@class='guestOneStep']");
        Checkout.put("emailAddress_textbox", "//input[@id='email1']");
        Checkout.put("primaryRole_dropdown", "//select[@id='primaryRole']");
        Checkout.put("primaryUse_dropdown", "//select[@id='primaryUse']");
        Checkout.put("orderSentToApproval_text", "//*[@class='small']");

        
        
        
        // Share order pop up elements
        Checkout.put("emailOnPopup_textbox", "//*[@id='email']");
        Checkout.put("shareOrder_checkbox", "//*[@id='shareOverlayTC']");
        Checkout.put(
            "shareOrder_button",
            "//*[@class='checkout-cta continueBtnSpinner']//a[2]"
        );
        Checkout.put("sendOrder_button", "//*[@id='shareOrderForm']//button");
        Checkout.put("trackOrder_button", "//*[@id='trackOrder']");
        Checkout.put(
            "closeShareOrder_button",
            "//*[@class='btn btnTertiary closeSharedOverlay']"
        );
        Checkout.put("shareOrderUnavailable_message", "//*[@id='shareOrderUnavailable']");

        //order pricing sticky side bar
        Checkout.put("totalprice_element", "//span[@id='Total_price']");
        Checkout.put("merchandiseSubTotalPrice_element", "//span[@id='subTotal_price']");
        Checkout.put("shippingChargePrice", "//*[@id='basicShippingCharge_price']");
        Checkout.put("paymentVatNumber_textbox", "//*[@name='paymentVatNumberId']");
        Checkout.put("taxPrice_element", "//*[@id='tax_price']");

        //addition information for ibuy
        Checkout.put("customFieldTwo_textbox", "//*[@class='oiIbuyRule form-control']");
        Checkout.put("costcode_dropdown", "//*[@id='ibuyfield4_1']");
        Checkout.put("selectApprover_dropdown", "//*[@id='selectApprover']");
        Checkout.put("requireApprovalMsg_text", "//*[@class='boldFont orangeTextColor clearfix']");
        Checkout.put("budgetExceedMsg_text", "//*[contains(@class,'budgetExceedMsg')]");
        
        //Email Verification - Successful Activation
        Checkout.put("regActivateSuccessTitle_text", "(//*[@id='checkout-activate-success-container']//div[@class='pf_row'])[1]");
        Checkout.put("regActivateSuccess_text", "(//*[@id='checkout-activate-success-container']//div[@class='pf_row'])[2]");
        Checkout.put("checkoutSuccessCloseIcon_element", "//*[@class='checkout-activate-success__icon--close']");
    }

    public String findLocator(String elementName) {
        if (Checkout.containsKey(elementName)) {
            return (Checkout.get(elementName.trim()));
        }

        return null;
    }
}
