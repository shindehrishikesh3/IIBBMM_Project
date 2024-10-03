package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class eInvoicing extends WebDriverConfig {
	private int invoiceCount = 0;
    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(eInvoicing.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public eInvoicing(ContextStore context) {
        this.context = context;
    }

    @Then("Verify that invoices related to the {string} displayed")
    public void verify_invoices_for_order(String orderConfirmationNumber) throws Exception {
    	boolean bFlag = false;
    	List<WebElement> invoices_rows = uiMethods.getMutipleLocators("eInvoicing.searchedordernumber_link");
    	for (int iLoop=0;iLoop<invoices_rows.size();iLoop++) {
    		if (invoices_rows.get(iLoop).getText().equalsIgnoreCase(orderConfirmationNumber)) {
    			bFlag = true;
    			invoiceCount++;
    		}
    	}
    	Assert.assertTrue("Invoices displayed are not related to "+orderConfirmationNumber, bFlag);
    }

    @Then("Verify that search parameters in eInvoicing page are enabled")
    public void verify_search_parameters_enabled() throws Exception {
    	Assert.assertTrue("Order number field is not enabled", uiMethods.isElementEnabled("eInvoicing.ordernumber_text"));
    	Assert.assertTrue("PO number field is not enabled", uiMethods.isElementEnabled("eInvoicing.ponumber_text"));
    	Assert.assertTrue("Invoice number field is not enabled", uiMethods.isElementEnabled("eInvoicing.invoicenumber_text"));
    	Assert.assertTrue("End date field is not enabled", uiMethods.isElementEnabled("eInvoicing.enddate_text"));
    	Assert.assertTrue("Start date field is not enabled", uiMethods.isElementEnabled("eInvoicing.startdate_text"));
    	Assert.assertTrue("Status field is not enabled", uiMethods.isElementEnabled("eInvoicing.status_list"));
    	Assert.assertTrue("Invoice type field is not enabled", uiMethods.isElementEnabled("eInvoicing.invoicetype_list"));
    }

    @Then("Verify that order confirmation number in eInvoicing page is disabled")
    public void verify_search_parameters_disabled() throws Exception {
    	Assert.assertTrue("Order number field is not disabled", !(uiMethods.isElementEnabled("eInvoicing.ordernumber_text")));
    }

    @Then("Verify that order number field is blanked out and all the invoices are displayed")
    public void verify_order_number_blank() throws Exception {
    	Assert.assertTrue("Order number field is not blanked out", actionMethods.getValueUsingAttribute("eInvoicing.ordernumber_text", "value").isEmpty());
    	List<WebElement> invoices_rows = uiMethods.getMutipleLocators("eInvoicing.searchedordernumber_link");
    	Assert.assertTrue("All the invoices are not displayed for the user", invoices_rows.size()>invoiceCount);
    }

    @Then("Verify that order number field is not blanked out")
    public void verify_order_number_not_blank() throws Exception {
    	Assert.assertTrue("Order number field is blanked out", !(actionMethods.getValueUsingAttribute("eInvoicing.ordernumber_text", "value").isEmpty()));
    }

    @When("User navigates to eInvoicing page")
    public void navigate_eInvoicing_page() throws Exception {
    	actionMethods.hoverOnElement("Header.myAccount_dropdown");
    	Thread.sleep(1000);
    	actionMethods.click("Header.accountSummary_link");
    	Thread.sleep(1000);
    	actionMethods.click("MyAccount.retrieveInvoices_link");
    }
}
