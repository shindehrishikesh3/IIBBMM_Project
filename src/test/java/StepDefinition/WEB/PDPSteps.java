package StepDefinition.WEB;

import static org.junit.Assert.assertEquals;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class PDPSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(PDPSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public PDPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify the SEO title for the PDP page$")
    public void verify_seo_title() throws Exception {
        int counter = 0;
        String seo_description = null;
        String[] description = new String[7];
        String manufDesc = ""; 
        if (store.equalsIgnoreCase("cpc")) {
        	manufDesc = actionMethods.getValue("PDP.productTitle_text");
        } else {
        	manufDesc = actionMethods.getValue("PDP.manufDescription_text");
        }
        String manuf = actionMethods.getValue("PDP.manuf_text");
        String manufPartNo = actionMethods.getValue("PDP.manufPartNo_text");
        for (Character c : manufDesc.toCharArray()) {
            if (c.equals(',')) {
                counter = counter + 1;
            }
        }
        logger.info("Total comma present in description: " + counter);

        this.context.scenario.log("Actual SEO Title of PDP page: " + driver.getTitle());

        if (counter >= 3) {
            description = manufDesc.split(",");
        }

        if (region.equalsIgnoreCase("europe")) {
            if (counter >= 3) {
                switch (store) {
                    case "pt":
                    case "ro":
                    case "lt":
                    case "ee":
                    case "hu":
                    case "lv":
                    case "tr":
                    case "ru":
                    case "il":
                    case "cz":
                    case "pl":
                    case "bg":
                    case "si":
                    case "be":
                    case "fi":
                    case "nl":
                    case "dk":
                    case "sk":
                    case "se":
                        seo_description =
                            manufPartNo +
                            " - " +
                            manuf +
                            " - " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2];
                        break;
                    case "ie":
                        seo_description =
                            manufPartNo +
                            " - " +
                            manuf +
                            " - " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " Farnell Ireland";
                        break;
                    case "at":
                        seo_description = manufPartNo + " - " + manuf + " | Farnell AT";
                        break;
                    case "ch":
                        seo_description = manufPartNo + " - " + manuf + " | Farnell CH";
                        break;
                    case "uk":
                        seo_description =
                            manufPartNo +
                            " " +
                            manuf +
                            "," +
                            " " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " | Farnell UK";
                        break;
                    case "fr":
                        seo_description =
                            manufPartNo +
                            " " +
                            manuf +
                            "," +
                            " " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " | Farnell FR";
                        break;
                    case "it":
                        seo_description =
                            manufPartNo +
                            " - " +
                            manuf +
                            " - " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " Farnell Italia";
                        break;
                    case "no":
                        seo_description =
                            manufPartNo +
                            " - " +
                            manuf +
                            " " +
                            manufPartNo +
                            " - " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2];
                        break;
                    case "es":
                        seo_description =
                            manufPartNo +
                            " " +
                            manuf +
                            "," +
                            " " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " | Farnell ES";
                        break;
                    case "de":
                        seo_description =
                            manufPartNo +
                            " " +
                            manuf +
                            "," +
                            " " +
                            description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " | Farnell DE";
                        break;
                    case "cpc":
                    	seo_description = 
                    		description[0] +
                            "," +
                            description[1] +
                            "," +
                            description[2] +
                            " - " +
                            manuf +
                            " | CPC UK";
                    	break;
                }
            } else {
                seo_description =
                    manufPartNo + " " + manuf + "," + " " + manufDesc + " | Farnell";
            }
            this.context.scenario.log(
                    "Expected SEO Title of PDP page: " + seo_description
                );
        } else {
            if (counter >= 3) {
                if (store.equalsIgnoreCase("KR")) seo_description =
                    manufPartNo +
                    " - " +
                    manuf +
                    " - " +
                    description[0] +
                    "," +
                    description[1] +
                    "," +
                    description[2] +
                    " | element14 Korea"; else if (
                    store.equalsIgnoreCase("CANADA")
                ) seo_description =
                    manufPartNo +
                    " " +
                    manuf +
                    ", " +
                    description[0] +
                    "," +
                    description[1] +
                    "," +
                    description[2]; else seo_description =
                    manufPartNo +
                    " - " +
                    manuf +
                    " - " +
                    description[0] +
                    "," +
                    description[1] +
                    "," +
                    description[2];
            } else {
                seo_description = manufPartNo + " - " + manuf + " - " + manufDesc;
            }
            this.context.scenario.log(
                    "Expected SEO Title of PDP page: " + seo_description
                );
        }

        Assert.assertTrue(
            "SEO Title of PDP is not matching",
            seo_description.equalsIgnoreCase(driver.getTitle())
        );
    }

    @And("^.*verify technical documents count matches with the header")
    public void verify_count_on_technical_documents_section() throws Exception {
        int countBody = getMutipleLocators("PDP.techicalDocuments_list").size();
        String countHeader = actionMethods
            .getValue("PDP.techDocsCountInHeader_text")
            .replace("(", "")
            .replace(")", "");
        this.context.scenario.log("No. of technical documents in body:" + countBody);
        assertEquals(
            "No. of Tech docs:" +
            countBody +
            "failed to match with the count provided in the tech docs heading: " +
            countHeader,
            Integer.parseInt(countHeader),
            countBody
        );
    }

    @And("^.*verify Legislation And Environmental section table is not empty.*")
    public void verifyLegislationTableNonEmpty() throws Exception {
        int tableSize = getMutipleLocators(
            "PDP.legislationEnvironmentalTableLabels_element"
        )
            .size();

        Assert.assertTrue("Legislation Section has headers", tableSize > 0);
        Assert.assertFalse(
            "Legislation Section rows value not displayed",
            actionMethods.getValue("PDP.legEnvTablefirstRowvalue_text").isEmpty()
        );
    }

    //Applicable only for Newark Region (SD-2346)
    @And(
        "^.*click on random product link and verify if request a quote feature link is removed$"
    )
    public void randomProductLink() throws Exception {
        for (int i = 2; i >= 0; i--) {
            Random r = new java.util.Random();
            List<WebElement> locator = actionMethods.getMutipleLocators(
                "BrowseForProducts.allProducts_links"
            );
            WebElement randomElement = locator.get(r.nextInt(locator.size()));
            randomElement.click();
            if (
                actionMethods.uiMethods.verifyElementExistence(
                    "PLP.firstManufacturerPartNo_link"
                ) ==
                true
            ) {
                actionMethods.click("PLP.firstManufacturerPartNo_link");
            } else {
                actionMethods.click("CategoryPage.showAllProducts_button");
                actionMethods.click("PLP.firstManufacturerPartNo_link");
            }
            actionMethods.scrollDownPage(100);
            Boolean value = uiMethods.isElementDisplayed("PDPBuyBox.requestaQuote_link");
            Assert.assertFalse(value);
            actionMethods.click("Home.allProducts_link");
            actionMethods.click("Home.viewAllProducts");
            Thread.sleep(1000);
        }
    }
    
  //Applicable only for CPC/CPC Ireland Region (SD-2537)
    @And("^.*User verify product info section on PDP of store \"([^\"]*)\"$")
    public void verifyproduct(String store) throws Exception {
    	
    	 if(!uiMethods.isElementPresent("PDP.productOverviewBody_text")){
    		if(uiMethods.isElementPresent("PDP.productInfoSection_text")){
    			 this.context.scenario.log("Product Info Section is available on PDP");
    		}else{
    			Assert.fail("In Absence of product F and B , Product info also not displayed");
    		}
    }
}
    
    //Applicable only for (SD-2209)
    //Verify MPN number on url of the configurator page
    @And("^User verify MPN in the URL on navigating to EAO Configurator Page from PDP of product \"([^\"]*)\"$")
    public void verifyManufacturerNum(String product) throws Exception {
    	
    	String manufacturerNum = actionMethods.getValue("PDP.manufPartNo_text");
        actionMethods.clickUsingJSExecutor("ManufacturerDetailsPage.EaoBanner_link");
    	Thread.sleep(3000);
    	actionMethods.switchToWindow();
        String act_Value = driver.getCurrentUrl();
        this.context.scenario.log("Value of the current URL: " + act_Value);
        Assert.assertTrue("Manufacturer Part Number is not present in the URL ", act_Value.contains(manufacturerNum));
        
}
}
