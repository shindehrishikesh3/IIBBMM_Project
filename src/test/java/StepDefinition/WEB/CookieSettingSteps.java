package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class CookieSettingSteps extends WebDriverConfig {

    private ContextStore context;

    public CookieSettingSteps(ContextStore context) {
        this.context = context;
    }

    @And("^User save cookie preferences$")
    public void save_Cookie_Preferences() throws Exception {
        if (region.equalsIgnoreCase("EUROPE")) {
            actionMethods.click("CookieSetting.cookieSettings_link");
            actionMethods.click("CookieSetting.savePreferences_button");
        } else {
            this.context.scenario.log("NA for APAC and US");
        }
    }
}
