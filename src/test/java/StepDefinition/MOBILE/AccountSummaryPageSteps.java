package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPageSteps extends WebDriverConfig {

    WebDriver driver = getDriver();
    String store = getStore();
    private ContextStore context;

    public AccountSummaryPageSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*enter password type as \"([^\"]*)\" password in \"([^\"]*)\" field$")
    public void enter_old_password(String pwdType, String pwdLoc) throws Exception {
        String password;
        switch (pwdType) {
            case "old":
                password = loginConfig.getProperty(store + "_password");
                actionMethods.enterText(password, pwdLoc);
                break;
            case "new":
                actionMethods.enterText("Avnet@1234", pwdLoc);
                break;
            case "invalid":
                actionMethods.enterText("abc", pwdLoc);
                break;
            case "different":
                actionMethods.enterText("FTuser@1234", pwdLoc);
                break;
            case "current":
                password = context.constants.getPassword();
                actionMethods.enterText(password, pwdLoc);
                break;
            default:
                System.out.println("Password type mising");
        }
    }
}
