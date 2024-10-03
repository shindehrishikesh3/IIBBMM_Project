package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class ChangeCountrySteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(ChangeCountrySteps.class);
    private ContextStore context;
    String store = getStore();

    public ChangeCountrySteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify Expected URL matches with Current URL$")
    public void verifyURL() throws Exception {
        String expectedStore;
        if (!store.equalsIgnoreCase("au")) {
            expectedStore = "au";
        } else {
            expectedStore = "hk";
        }
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(
            "string is not present in the URL ",
            currentURL.contains(expectedStore)
        );
    }

    @And("^.*select Country from dropdown \"([^\"]*)\"$")
    public void enter_account_details(String locator) throws Exception {
        if (!actionMethods.getStore().equalsIgnoreCase("au")) {
            actionMethods.selectValueByIndex(0, locator);
        } else actionMethods.selectValueByIndex(13, locator);

        context.scenario.log("Selected Country Name " + getStore());
    }
}
