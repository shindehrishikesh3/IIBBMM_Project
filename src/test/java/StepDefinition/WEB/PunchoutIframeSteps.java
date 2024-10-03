package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class PunchoutIframeSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public PunchoutIframeSteps(ContextStore context) {
        this.context = context;
    }

    @Given("^verify user \"([^\"]*)\" is logged in$")
    public void user_logged_In(String firstNameLocator) throws Exception {
        actionMethods.waitForByElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            firstNameLocator
        );

        String value = actionMethods.getValue(firstNameLocator);
        context.scenario.log("User is logged in to its account:" + value);
        Assert.assertTrue(!value.equalsIgnoreCase(""));
    }

    @And("^switch to \"([^\"]*)\" iframe")
    public void switch_To_Frame(String iframeIdName) {
        this.getDriver().switchTo().frame(iframeIdName);
    }

    @And("^verify order details table headers")
    public void verify_order_detail_table_headers() throws Exception{
        List<WebElement> headers = actionMethods.getMutipleLocators("Punchout_SubmitShoppingCart.poOrderDetailsTableHeaders_elements");
        List<String> headerText = new ArrayList<String>();
	headers.stream().forEach((e) -> headerText.add(e.getText()));
	this.context.softAssertions.assertThat(headerText)
	.overridingErrorMessage("Table headers are incorrect. ACTUAL: %s Expected: %s",headerText, this.context.constants.getOrderDetailsHeaders())
	.isEqualTo(this.context.constants.getOrderDetailsHeaders());
    }

    @And("^verify \"([^\"]*)\" product rows in order details table")
    public void verify_order_detail_table_body(int rowCount) throws Exception{
    	 // Take a screenshot...
	     final byte[] screenshot =
	     screenshotUtil.getByteFullScreenshot();
	 // embed it in the report.
	 this.context.scenario.attach(screenshot, "image/png", "Submit Cart page");
	Thread.sleep(3000);
	List<WebElement> headers = actionMethods.getMutipleLocators("Punchout_SubmitShoppingCart.poOrderDetailsTableBodyRows_elements");

	this.context.softAssertions.assertThat(headers.size())
	.overridingErrorMessage("Table body rows are incorrect. ACTUAL: %s Expected: %s",headers.size(), rowCount*2)
	.isEqualTo(rowCount*2);
    }

    @And("^register external user only if \"([^\"]*)\" newly registered")
    public void register_new_user(String userType) throws Exception{
	if(userType.equalsIgnoreCase("Newly registered")){

	actionMethods.enterText(ContextStore.USER_NAME, "PunchoutPOUserRegistration.firstName_textbox");
	actionMethods.enterText("Punchout", "PunchoutPOUserRegistration.lastName_textbox");
	actionMethods.enterText(this.context.userEmail, "PunchoutPOUserRegistration.emailAddress_textbox");
	actionMethods.enterText("1234567890", "PunchoutPOUserRegistration.phoneNumber_textbox");
	context.scenario.attach(ScreenshotUtil.getByteScreenshot(), "image/png", "registration page");
	actionMethods.click("PunchoutPOUserRegistration.register_button");
	actionMethods.waitForByElementToAppear(this.context.constants.getMediumWaitSeconds(), "PunchoutHeader.userFirstName_text");
	Thread.sleep(3000);
	} else {
		this.context.scenario.log("Step NA for "+userType);
	}

    }

    /**
     * No longer needed as GetFeedback Homepage pop-up is disabled now
     * @throws Exception
     */
    @And("skip feedback form if any")
    public void skip_feedbackForm() throws Exception{
	actionMethods.setLocalStorageToSkipFeedbackForms();
	actionMethods.clickUsingJSExecutor("Header.companylogo_element");
    }
}
