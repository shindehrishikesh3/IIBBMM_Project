package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class LoginPageSteps extends WebDriverConfig {

    private ContextStore context;
    String env;
    String region;

    public LoginPageSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*enter registered username$")
    public void enter_registered_username() throws Exception {
        String username = ContextStore.USER_NAME;
        actionMethods.enterText(username, "ForgotPassword.username_textbox");
    }

    @And("^.*enter.*in \"([^\"]*)\" for \"([^\"]*)\".*$")
    public void enter_details_forgot_password(String loc, String usertype)
        throws Exception {
        String username = "";
        String email = "";
        String store = getStore();
        region = getRegionName();
        switch (usertype.toLowerCase()) {
            case "single":
                email = forgotPwdConfig.getProperty(store + "_email_single_username");
                break;
            case "multiple":
                email = forgotPwdConfig.getProperty(store + "_email_multi_username");
                break;
            case "username":
                username = forgotPwdConfig.getProperty(store + "_username");
                break;
        }

        Thread.sleep(5000);
        if (usertype.equalsIgnoreCase("username")) {
            actionMethods.enterText(username, loc);
            context.scenario.log("Username: " + email);
        } else {
            actionMethods.enterText(email, loc);
            context.scenario.log("Email: " + email);
        }
    }
}
