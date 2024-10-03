package StepDefinition.MOBILE;

import static org.junit.Assert.assertEquals;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PDPSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public PDPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify number of technical documents matches with the header$")
    public void verifyCountforTechnicalDocumentsSection() throws Exception {
        int countBody1 = getMutipleLocators("PDP.techDocSheetList_list").size();
        int countBody2 = getMutipleLocators("PDP.techDocCadInfoDoc_list").size();
        int totalCount = countBody1 + countBody2;

        String countHeader = actionMethods
            .getValue("PDP.techDocsCountInHeader_text")
            .replace("(", "")
            .replace(")", "");
        this.context.scenario.log("No. of technical documents in body:" + totalCount);
        assertEquals(
            "No. of Tech docs:" +
            totalCount +
            "failed to match with the count provided in the tech docs heading: " +
            countHeader,
            Integer.parseInt(countHeader),
            totalCount
        );
    }

    @Then(
        "^.*verif.* MPN is displayed after the Manufacturername on.* container in mobile$"
    )
    public void verify_manufacturer_name_for_NLM_products_mobile() throws Exception {
        String currentMfgName = actionMethods.getValue(
            "PDPBuyBox.nlmManufacturerName_text"
        );
        actionMethods.click("PDPBuyBox.nlmManufacturerDesc_link");
        Thread.sleep(3000);
        String partNo = actionMethods.getValue("PDP.mnp_text");
        String manufacturerName = actionMethods.getValue("PDP.mfgName_text");
        Assert.assertTrue(
            "MPN: " +
            partNo +
            " is not displaying in the updated manufacturer tilte: " +
            currentMfgName,
            currentMfgName.contains(partNo)
        );
        Assert.assertTrue(
            "Manufacturer name: " +
            manufacturerName +
            " is not displaying in the updated manufacturer title: " +
            currentMfgName,
            currentMfgName.contains(manufacturerName)
        );
    }
}
