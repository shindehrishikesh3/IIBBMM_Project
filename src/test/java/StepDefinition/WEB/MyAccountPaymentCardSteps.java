package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyAccountPaymentCardSteps extends WebDriverConfig {

    private ContextStore context;

    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public MyAccountPaymentCardSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*fill Payment Card Details on Add Payment Card page using given file \"([^\"]*)\"$"
    )
    public void enter_payment_card_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String cardType = testData.get(0).get("billCardType");
        String cardNumber = testData.get(0).get("billCardNumber");
        this.context.creditCardNum = cardNumber;
        String expiryMonth = testData.get(0).get("billCardExpiryMonth");
        String expiryYear = testData.get(0).get("billCardExpiryYear");
        String nameOnCard = testData.get(0).get("billNameOnCard");
        String cardHolderPhoneNo = testData.get(0).get("billCardHolderPhone");
        String cardHolderPhoneExt = testData.get(0).get("billCardHolderPhoneExt");
        String companyName = testData.get(0).get("fullCompanyNameBuisness");
        String forTheAttentionOf = testData.get(0).get("billAttention");
        String nickName = testData.get(0).get("nickName");

        context.scenario.log(
            "User Payment Cards details are :" +
            cardType +
            " " +
            cardNumber +
            " " +
            expiryMonth +
            " " +
            expiryYear +
            " " +
            nameOnCard +
            " " +
            cardHolderPhoneNo +
            " " +
            cardHolderPhoneExt +
            " " +
            companyName +
            " " +
            forTheAttentionOf +
            " " +
            nickName
        );

        actionMethods.selectValueByText(
            cardType,
            "MyAccountPaymentCard.cardType_dropdown"
        );

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(
                cardNumber,
                "MyAccountPaymentCard.cardNumber_textbox"
            );
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-card-1");
            actionMethods.enterText(
                cardNumber,
                "MyAccountPaymentCard.cardNumberWebTokenize_textbox"
            );
            driver.switchTo().parentFrame();
        }

        actionMethods.selectValueByText(
            expiryMonth,
            "MyAccountPaymentCard.expiryMonth_dropdown"
        );
        actionMethods.selectValueByText(
            expiryYear,
            "MyAccountPaymentCard.expiryYear_dropdown"
        );
        actionMethods.enterText(nameOnCard, "MyAccountPaymentCard.nameOnCard_textbox");
        actionMethods.enterText(
            cardHolderPhoneNo,
            "MyAccountPaymentCard.cardHolderPhone_textbox"
        );
        actionMethods.enterText(
            cardHolderPhoneExt,
            "MyAccountPaymentCard.phoneExtension_textbox"
        );
        actionMethods.enterText(
            companyName,
            "MyAccountPaymentCard.organizationName_textbox"
        );
        actionMethods.enterText(
            forTheAttentionOf,
            "MyAccountPaymentCard.forTheAttentionOff_textbox"
        );
        actionMethods.selectValueByText(
            nickName,
            "MyAccountPaymentCard.selectAddress_dropdown"
        );
        Thread.sleep(3000);
    }
}
