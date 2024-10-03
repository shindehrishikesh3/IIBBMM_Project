#Author: Sandhya Seelam
#Keywords Summary :
@mobValidationTests
Feature: Perform regression on 'Order Information' and 'Order Review' sections in the checkout page

  @editcheckoutsections
  Scenario Outline: User places first order using trade account
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "register" user
    And user save the newly registered "regular" user details
    When user enter "instock" ordercode from file "PDPRegressionOrderCodes.xlsx" in searchbox
    And user click the "Header.searchIcon_button"
    And user wait for "3" seconds
    And user click on "PDP.addToCart_button"
    Then user wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
    And user take screenshot of the addToCartPopup appeared
    When user click on "PDP.checkout_button" using js
    And user wait "medium" duration for "ShoppingCart.checkoutNow_button" element to "appear"
    And user take screenshot of the Shopping cart page
    When user click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    #VERIFICATION OF ORDER INFORMATION SECTION
    #1.ACCOUNT SECTION
    Then user verify text "Account" in page "Checkout.accountSectionTitle_text"
    And user verify if element "Checkout.selectTradeAccountNo_radio" is selected on page
    And user click to select Yes for Tradeaccount "Checkout.selectTradeAccountYes_radio"
    When user click on link use an existing Trade account "Checkout.existingTradeAccount_link"
    And user wait for "4" seconds
    And user enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
    And user enter PO number value "TradeTestOrder" in textbox "Checkout.poNumber_textbox"
    And user take screenshot of the Account section
    And user click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    #2.PAYMENT DETAILS SECTION
    Then user verify text as  "Payment Details" in page "Checkout.paymentDetails_text"
    When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
    #Invoice/Billing Address Details Section
    And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
    And user verify text as  "Add Invoice Address" in page "Checkout.addInvoiceAddressTitle_text"
    And user fill mobile checkout with specific "Invoice Address" as Invoice or billing address  using given file "OrderInformationForCheckoutRegression.xlsx"
    And user verify element "Checkout.setInvAddressAsPreferredAddress_checkbox" is selected on page
    And user click to deselect the 'Set this as my preferred invoice address' checkbox "Checkout.setInvAddressAsPreferredAddress_checkbox"
    And user take screenshot of the Invoice/Billing Address
    And user scroll till "Checkout.billingAddress_icon"
    And user hover on element to verify its pop up "Checkout.billingAddress_icon"
    When user click on Continue button "Checkout.paymentDetailsSectionContinue_button"
    #3.DELIVERY ADDRESS SECTION
    Then user verify text of Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text" for "EUROPE,APAC" region/store
    And user verify text of Delivery addresss Section title as  "Shipping Address(es)" in page "Checkout.deliveryAddressSectionTitle_text" for "NEWARK" region/store
    And user click to deselect the 'My delivery address is the same as my invoice address' checkbox "Checkout.setDelAddressSameAsInv_checkbox"
    And user verify element "Checkout.setDelAddressAsPreferredAddress_checkbox" is selected on page
    And user click to deselect the 'Set this as my preferred delivery address' checkbox "Checkout.setDelAddressAsPreferredAddress_checkbox"
    And user fill mobile checkout with specific "Delivery Address" as Delivery or Shipping address  using given file "OrderInformationForCheckoutRegression.xlsx"
    And user take screenshot of the Delivery Address section
    And user scroll till "Checkout.deliveryAddressToolTip_icon"
    When user hover on element to verify its popup text "Checkout.deliveryAddressToolTip_icon"
    When user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
    #4.DELIVERY METHOD
    Then user verify text of Delivery Method title as  "Delivery Method" in page "Checkout.deliveryMethodSectionTitle_text"
    And user verify text as  "Delivery Instructions" in page "Checkout.deliveryInstructionsTitle_text"
    When user enter value "Test Order[Del Instructions]" in textbox "Checkout.deliveryInstructions_textbox"
    And user verify text of Special Instructions section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text" for "EUROPE,APAC" region/store
    When user select by visible text in Special Instructions as "Other" from dropdown "Checkout.specialInstruction_dropdown" for "EUROPE,APAC" region/store
    And user enter value "Test Order[Spl Instructions]" in textbox "Checkout.specialDeliveryInstructions_textbox" for "EUROPE,APAC" region/store
    And user take screenshot of the Delivery Method section
    When user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
    And user wait for "5" seconds
    #VERIFICATION OF ORDER REVIEW SECTION
    And user verify text related to the 'Standard FREE delivery of products' as "FREE Standard next working day delivery on all UK online orders. Excludes offline orders, Newark Direct Ship products and other non standard delivery methods. Next working day delivery cannot be guaranteed." in page "Checkout.stdFreeDelivery_text" for "EUROPE" region/store
    And user verify text of 'Order Review' page heading as "Review Your Order Before Submitting" in page "Checkout.reviewYourOrder_text"
    And user verify if the 'Terms&Conditions' checkbox element "Checkout.termsAndConditions_checkbox" is present on page
    And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox" for "EUROPE,APAC" region/store
    #PAYMENTS DETAILS ON ORDER REVIEW SECTION
    And user verify 'Payment Details' Section contains "Payment Details" in its title "Checkout.paymentDetailsTitle_text"
    And user verify below are displayed in 'Payment Details' as labels "Checkout.paymentDetailsOfOrder_list" table
      | Order Date     |
      | Account Number |
      | Placed By      |
      | Email Address  |
      | Billing Method |
    #INVOICE DETAILS ON ORDER REVIEW SECTION
    And user verify 'Invoice Address' Section contains "Invoice Address" in its title "Checkout.invoiceAddressTitleInOrderReview_text"
    And user verify text of Invoice and Tax details heading as "Invoice and Tax Details" in page "Checkout.invoiceAndTaxDetailsSectionTitle_text"
    Then user verify if address entered "Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
    #DELIVERY ADDRESS DETAILS ON ORDER REVIEW SECTION
    And user verify 'Delivery Address' Section contains "Delivery Address" in its title "Checkout.deliveryAddressSectionTitleInOrderReview_text"
    Then user verify text of Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSubTitleInOrderReview_text" for "EUROPE,APAC" region/store
    And user verify text of Delivery addresss Section title as  "Shipping address" in page "Checkout.deliveryAddressSubTitleInOrderReview_text" for "NEWARK" region/store
    Then user verify if address entered "Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
    #DELIVERY SELECTION DETAILS ON ORDER REVIEW SECTION
    And user verify 'Delivery Selection' Section contains "Delivery Selection & Order Options" in its title "Checkout.deliverySelectionTitle_text"
    And user verify text of label under Delivery Selection section is "Delivery Method:" in page "Checkout.deliveryMethod_label"
    #DELIVERY/SPECIAL INSTRUCTIONS DETAILS ON ORDER REVIEW SECTION
    And user verify text of section title as  "Delivery Instructions" in page "Checkout.deliveryInstructionTitle_text"
    And user verify text of section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text" for "EUROPE,APAC" region/store
    #ITEMS TO BE SHIPPED ON ORDER REVIEW SECTION
    And user verify text of section title as  "Items To Be Shipped" in page "Checkout.itemToBeShippedTitle_text"
    And user verify text of 'Item number in order' as "1" in page "Checkout.itemNumber_text"
    And user verify if the Product Description link "Checkout.productDesc_link" is present
    And user verify below are displayed in 'Order Details' as headers in "Checkout.orderCodeTableHeader_list" table
      | Order Code               |
      | Manufacturer Part Number |
    And user verify values in the "Checkout.orderCodeTableBody_list" table are not empty
    And user verify text of collapsable section under order details table as "Additional Information" in page "Checkout.additionalInformationCollapsable_element"
    And user verify absence of element "Checkout.addtlInfoExpandedSection_element"
    And user click the collapsable section "Checkout.additionalInformationCollapsable_element"
    And user verify below are displayed in 'Additional Information' as labels "Checkout.addtlInfoCollapseElements_list" table
      | Manufacturer       |
      | Avail.             |
      | Scheduled Quantity |
      | Delivery Date      |
      | Unit Price         |
      | Line Note          |
      | Your Part No       |
      | Availability       |
    And user verify below are displayed in 'Quantity And Line price' as labels in "Checkout.QtyAndLinePriceTableHeaders_list" table
      | Qty        |
      | Line Price |
    And user verify values in the "Checkout.QtyAndLinePriceTableValues_list" table are not empty
    And user verify text over 'Edit Basket' button "Edit Basket" in page "Checkout.editBasket_button"
    And user verify below are displayed in 'Order Summary table' as labels "Checkout.orderSummaryTableLabel_list" table
      | All Items Total |
      | Delivery        |
      | <other charges> |
      | VAT             |
      | Total           |
    And user verify values in the "Checkout.orderSummaryTableValues_list" table are not empty
    And user take screenshot of the Order Review page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Review page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Review page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Review page
    And user scroll till "Checkout.acceptTermsAndConditionsInBottom_checkbox"
    And user wait for "8" seconds
    And user verify element "Checkout.acceptTermsAndConditionsInBottom_checkbox" is selected on page
    And user scroll till "Checkout.submitOrder_button"
    And user wait for "3" seconds
    When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrder_button" using js
    #VERIFICATION ON ORDER CONFIRMATION PAGE
    And user wait for "10" seconds
    Then user verify text on successful order placement as "Order Confirmation" in page "Checkout.orderConfirmationTitle_text"
    And user verify text as  "Thank You" in page "Checkout.thankYouInNewark_text" for "NEWARK" region/store
    And user verify text as  "Thank you" in page "Checkout.thankYou_text" for "EUROPE,APAC" region/store
    And user verify text of 'email sent confirmation' as "An email has been sent confirming the order you have just placed." in page "Checkout.emailSentConfirmation_text"
    And user verify text "Track the status of your order by accessing Order Status & Tracking in the My Account section." in page "Checkout.trackOrderStatus_text"
    And user verify link "Checkout.termsAndConditionsOfOrderTracking_link" is present
    And user verify text as "Continue Shopping" in page "Checkout.continueShoppingInTop_button"
    And user verify text as "Share Your order" in page "Checkout.shareYourOrder_button"
    And user verify below are displayed in 'Payment Details' as labels "Checkout.paymentDetailsOfOrder_list" table
      | Order Date     |
      | Account Number |
      | Placed By      |
      | Email Address  |
      | Billing Method |
    And user verify text of 'PO Number' label as "PO Number:" in page "Checkout.poNumberInOrderReview_label"
    And user verify if the link "Checkout.termsAndConditionsForBilling_link" is present
    And user verify text over link is "Terms & Conditions of Purchase, including Privacy Statement and Data Protection Policy" in page "Checkout.termsAndConditionsForBilling_link"
    #INVOICE ADDRESS DETAILS ON ORDER CONFIRMATION PAGE
    And user verify text of title as  "Invoice Address" in page "Checkout.invoiceAddressTitleInOrderConfirmation_text"
    And user verify text of Invoice and Tax details heading as "Invoice and Tax Details" in page "Checkout.invoiceAndTaxDetailsTitleInOrderConfirmation_text"
    #DELIVERY ADDRESS DETAILS ON ORDER CONFIRMATION PAGE
    Then user verify text of Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressTitleInOrderConfirmation_text" for "EUROPE,APAC" region/store
    And user verify text of Delivery addresss Section title as  "Shipping Address(es)" in page "Checkout.deliveryAddressTitleInOrderConfirmation_text" for "NEWARK" region/store
    #DELIVERY SELECTION  DETAILS ON ORDER CONFIRMATION PAGE
    And user verify text Delivery selection section title as  "Delivery Selection & Order Options" in page "Checkout.deliverySelectionTitleInOrderConfirmation_text"
    #DELIVERY/SPECIAL INSTRUCTIONS DETAILS ON ORDER CONFIRMATION PAGE
    And user verify text of section title as  "Delivery Instructions" in page "Checkout.deliveryInstructionTitle_text"
    And user verify text of section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text" for "EUROPE,APAC" region/store
    And user verify text of section title as  "Items To Be Shipped" in page "Checkout.itemToBeShippedTitle_text"
    And user verify below are displayed in 'Items to be shipped' as labels "Checkout.orderSummaryTableLabel_list" table
      | All Items Total |
      | Delivery        |
      | <other charges> |
      | VAT             |
      | Total           |
    And user verify values in the "Checkout.orderSummaryTableValues_list" table are not empty
    And user verify text of 'sales tax info added to order total' as "*Calculated based on your preferences or selected shipping" in page "Checkout.salesTaxCalcInfo_text"
    And user verify text of button as "Continue Shopping" in page "Checkout.continueShoppingInBottom_button"
    And user take screenshot of the Order Confirmation page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Confirmation page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Confirmation page
    And user scroll down the page by pixels "200"
    And user take screenshot of the Order Confirmation page

    @eu
    Examples: 
      | other charges   |
      | Handling Charge |

    @nwk
    Examples: 
      | other charges                          |
      | Order Total (excl. Tax and/or Freight) |

    @apac
    Examples: 
      | other charges |
      | n/a           |

  @apac @eu @nwk
  Scenario: Edit Information on Order Review Page
    Given web site is launched successfully and user "does" accept the cookies
    And user click to log in "Header.login_link"
    And user wait for "3" seconds
    When last registered "regular" user login to website successfully
    And user wait for "3" seconds
    And user take screenshot of the home page of the customer logged in
    When user click 'Shopping Basket' icon on the header "Header.miniBasket_link"
    Then user wait for "3" seconds
    And user clear all items from basket in mobile
    And user wait for "5" seconds
    When user enters the ordercode "productvideo" to the basket from file "PDPRegressionOrderCodes.xlsx"
    And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
    Then user wait for "3" seconds
    And user take screenshot of the cart page with the product added
    When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button" using js
    Then user wait for "9" seconds
    And user enter PO number value "PO-Test Order" in textbox "Checkout.poNumber_textbox"
    And user take screenshot of the Account section
    And user click on Continue button on Account section "Checkout.continueAccountSection_button"
    Then user wait for "5" seconds
    #Payment Details Section
    Then user verify text as  "Payment Details" in page "Checkout.paymentDetails_text"
    And user verify text as  "*Payment Method" in page "Checkout.paymentMethod_text"
    And user verify element "Checkout.tradeAccountOptionOnDropdown_element" is present except in "Newark" region/store
    And user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown" for "Newark" region/store
    And user take screenshot of the Payment Details section
    #Invoice/Billing Address Details Section
    And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
    #Add address verification
    And user take screenshot of the Invoice/Billing Address Details section
    When user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button"
    #Delivery Address Details Section
    And user take screenshot of the Delivery Address Details section
    When user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
    #Delivery Method Section
    Then user verify text of Delivery Method title as  "Delivery Method" in page "Checkout.deliveryMethodSectionTitle_text"
    And user verify if the 'default carrier' radio button element "Checkout.defaultDeliveryMethod_radio" is selected on page in "EUROPE,APAC" region/store
    And user verify if the 'default carrier' radio button element "Checkout.defaultDeliveryMethodInNewark_radio" is selected on page in "Newark" region/store
    And user verify text of 'default carrier' label as "Same day dispatch (free)" in page "Checkout.defaultDeliveryMethod_label" for "EUROPE" region/store
    And user verify text of 'default carrier' label as "Standard Delivery" in page "Checkout.defaultDeliveryMethod_label" for "APAC" region/store
    And user verify text of 'default carrier' label as "Newark Flat Rate (Over $150 USD Ships Free) (Order by 9:00 PM EST)" in page "Checkout.defaultDeliveryMethod_label" for "Newark" region/store
    And user verify text as  "Delivery Instructions" in page "Checkout.deliveryInstructionsTitle_text"
    When user enter value "Del. Instrctns for Test Order" in textbox "Checkout.deliveryInstructions_textbox"
    And user verify text of Special Instructions section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text" for "EUROPE,APAC" region/store
    When user select by visible text in Special Instructions as  "Other" from dropdown "Checkout.specialInstruction_dropdown" for "EUROPE,APAC" region/store
    And user enter value "Spl. Instrctns for Test Order" in textbox "Checkout.specialDeliveryInstructions_textbox" for "EUROPE,APAC" region/store
    And user take screenshot of the Delivery Method section
    When user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
    #Order Review Section
    And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
    And user click 'Edit' button to edit the Payment Details "Checkout.editPaymentMethod_button"
    And user take screenshot of the section navigated to
    And user verify if the Trade Account 'Yes' radio button element "Checkout.selectTradeAccountYes_radio" is selected on page in "EUROPE,APAC" region/store
    When user clears text from textbox "Checkout.poNumber_textbox"
    And user enter value "PO Amended" in textbox "Checkout.poNumber_textbox"
    And user click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    And user take screenshot of the section navigated to
    And user wait for "10" seconds
    And user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button" using js
    And user take screenshot of the section navigated to
    And user wait for "10" seconds
    And user click on Continue Shopping button "Checkout.deliverySectionContinue_button" using js
    And user take screenshot of the section navigated to
    And user wait for "10" seconds
    And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button" using js
    And user take screenshot of the order review page
    And user verify if PO comment text contains "PO Amended" in  "Checkout.poNumberInOrderReview_text"
    And user click 'Edit' button to edit the Invoice Address Details "Checkout.invoiceAddressEdit_button"
    And user wait for "10" seconds
    And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressHeading_text"
    And user take screenshot of the section navigated to
    And user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button" using js
    And user wait for "10" seconds
    And user take screenshot of the section navigated to
    And user click on Continue Shopping button "Checkout.deliverySectionContinue_button" using js
    And user wait for "8" seconds
    And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button" using js
    And user click 'Edit' button to edit the Delivery Address Details "Checkout.editDeliveryAddress_button"
    And user wait for "10" seconds
    Then user verify text of Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text" for "EUROPE,APAC" region/store
    And user verify text of Delivery addresss Section title as  "Shipping Address(es)" in page "Checkout.deliveryAddressSectionTitle_text" for "NEWARK" region/store
    And user take screenshot of the section navigated to
    And user click on Continue Shopping button "Checkout.deliverySectionContinue_button" using js
    And user wait for "2" seconds
    And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button" using js
    And user wait for "8" seconds
    And user click 'Edit' button to edit the Delivery Selection Details "Checkout.editDeliverySelection_button"
    And user wait for "10" seconds
    And user enter value "Del. Instrctns Amended" in textbox "Checkout.deliveryInstructions_textbox"
    When user select by visible text in Special Instructions as  "Other" from dropdown "Checkout.specialInstruction_dropdown" for "EUROPE,APAC" region/store
    And user enter value "Spl. Instrctns Amended" in textbox "Checkout.specialDeliveryInstructions_textbox" for "EUROPE,APAC" region/store
    And user wait for "10" seconds
    And user take screenshot of the section navigated to
    And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button" using js
    And user wait for "10" seconds
    And user verify text added in the 'Delivery Instructions' textbox as "Del. Instrctns Amended" in page "Checkout.deliveryInstructionsComment_text"
    And user verify text added in the 'Special Instructions' textbox as "Spl. Instrctns Amended" in page "Checkout.specialInstructionsComment_text" for "EUROPE,APAC" region/store
    And user take screenshot of the section navigated to
    And user click "Checkout.editBasket_button"
    And user wait for "8" seconds
    When user enters the ordercode "productImage360" to the basket from file "PDPRegressionOrderCodes.xlsx"
    And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
    Then user wait for "3" seconds
    And user take screenshot of the cart page with the product added
    When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button" using js
    Then user wait for "10" seconds
    And user verify text of 'Item number in order' as "2" in page "Checkout.itemNumberOfSecProduct_text"
    And user verify if the Product Description link "Checkout.productDescOfSecProduct_link" is present
    And user take screenshot of the order review page
    And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
    When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrderInBottom_button"
    And user wait for "7" seconds
    Then user verify text on successful order placement as "Order Confirmation" in page "Checkout.orderConfirmationTitle_text"
    And user verify text as  "Thank You" in page "Checkout.thankYouInNewark_text" for "NEWARK" region/store
    And user verify text as  "Thank you" in page "Checkout.thankYou_text" for "EUROPE,APAC" region/store
    And user verify text of 'email sent confirmation' as "An email has been sent confirming the order you have just placed." in page "Checkout.emailSentConfirmation_text"
    And user take screenshot of the order confirmation page
