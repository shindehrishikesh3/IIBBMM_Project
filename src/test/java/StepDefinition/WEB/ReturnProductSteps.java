package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class ReturnProductSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public ReturnProductSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*fill return of product form using given file \"([^\"]*)\"$")
    public void fillReturnForm(String FileName) throws Exception {
        String path = FilePath + FileName;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String Quantity = testData.get(0).get("Quantity");
        String reason = testData.get(0).get("reason");
        String Telephone = testData.get(0).get("Telephone");
        String CompanyName = testData.get(0).get("CompanyName");
        String AccountNumber = testData.get(0).get("AccountNumber");
        String cid = testData.get(0).get("cid");
        String DespatchNoteNumber = testData.get(0).get("DespatchNoteNumber");
        String Comments = testData.get(0).get("Comments");
        String OrderCode = this.context.constants.getOrderCode();
        actionMethods.enterText(OrderCode, "ReturnProduct.firstOrderCode_textbox");
        Thread.sleep(2000);
        actionMethods.enterText(Quantity, "ReturnProduct.firstQuantity_textbox");
        actionMethods.enterText(reason, "ReturnProduct.firstReason_textbox");
        actionMethods.enterText(Telephone, "ReturnProduct.telephone_textbox");
        actionMethods.enterText(CompanyName, "ReturnProduct.compnayName_textbox");
        actionMethods.enterText(AccountNumber, "ReturnProduct.accountNumber_textbox");
        actionMethods.enterText(cid, "ReturnProduct.customerID_textbox");
        actionMethods.enterText(
            DespatchNoteNumber,
            "ReturnProduct.despatchNoteNumber_textbox"
        );
        actionMethods.enterText(Comments, "ReturnProduct.comments_textbox");
        actionMethods.click("ReturnProduct.agreeTerms_checkbox");
    }
}
