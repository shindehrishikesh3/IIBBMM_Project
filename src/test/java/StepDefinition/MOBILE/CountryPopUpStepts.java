package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

public class CountryPopUpStepts extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public CountryPopUpStepts(ContextStore context) {
        this.context = context;
    }

    @Then("^.*select \"([^\"]*)\" language for dual language store$")
    public void selectLanguage(String language) throws Exception {
        List<String> dualLanguageStore = Arrays.asList(
            "be",
            "dk",
            "fi",
            "fr",
            "de",
            "it",
            "nl",
            "no",
            "pl",
            "pt",
            "es",
            "se",
            "ch",
            "cn",
            "tw",
            "us",
            "canada"
        );
        Thread.sleep(2000);
        if (dualLanguageStore.contains(getStore())) {
            if (language.equalsIgnoreCase("First")) {
                actionMethods.click("CountryPopUp.languageFirst_button");
            } else if (language.equalsIgnoreCase("Second")) {
                actionMethods.click("CountryPopUp.languageSecond_button");
            } else if (language.equalsIgnoreCase("Third")) {
                actionMethods.click("CountryPopUp.languageThird_button");
            }
        } else {
            this.context.scenario.log("Not applicable for this store");
        }
    }
}
