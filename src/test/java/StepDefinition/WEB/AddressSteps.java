package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddressSteps extends WebDriverConfig {

    private ContextStore context;

    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String region = getRegionName();

    public AddressSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*fill Address Information Details on Address Page using given file \"([^\"]*)\"$"
    )
    public void enter_additional_information_Details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String nickName = testData.get(0).get("nickName");
        String forTheAttentionOf = testData.get(0).get("billAttention");
        String companyName = testData.get(0).get("billCompanyName");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String accountNumber = testData.get(0).get("billAccountNumber");
        this.context.tradeAccountNum = accountNumber;
        String zipCode = testData.get(0).get("billPostCode");
        String province = testData.get(0).get("billProvince");

        context.scenario.log(
            "User details are :" +
            nickName +
            " " +
            forTheAttentionOf +
            " " +
            companyName +
            " " +
            addressLine1 +
            " " +
            addressLine2 +
            " " +
            city
        );

        actionMethods.clearText("MyAccountAddress.addressNickname_textbox");
        actionMethods.clearText("MyAccountAddress.forTheAttentionOf_textbox");
        actionMethods.clearText("MyAccountAddress.companyName_textbox");
        actionMethods.clearText("MyAccountAddress.addressLine1_textbox");
        actionMethods.clearText("MyAccountAddress.addressLine2_textbox");
        actionMethods.clearText("MyAccountAddress.city_textbox");
        actionMethods.scrollDownPage(10000);
        actionMethods.clearText("MyAccountAddress.zipCode_textbox");

        actionMethods.enterText(nickName, "MyAccountAddress.addressNickname_textbox");
        actionMethods.enterText(
            forTheAttentionOf,
            "MyAccountAddress.forTheAttentionOf_textbox"
        );
        actionMethods.enterText(companyName, "MyAccountAddress.companyName_textbox");
        actionMethods.enterText(addressLine1, "MyAccountAddress.addressLine1_textbox");
        actionMethods.enterText(addressLine2, "MyAccountAddress.addressLine2_textbox");
        actionMethods.enterText(city, "MyAccountAddress.city_textbox");
        actionMethods.enterText(zipCode, "MyAccountAddress.zipCode_textbox");

        if (context.constants.getStateDropdownStores().contains(getStore())) {
            actionMethods.selectValueByIndex(4, "MyAccountAddress.state_dropdown");
        } else if (
            uiMethods.isElementDisplayed("MyAccountAddress.countryProvince_textbox")
        ) {
            actionMethods.clearText("MyAccountAddress.countryProvince_textbox");
            actionMethods.enterText(province, "MyAccountAddress.countryProvince_textbox");           
            context.scenario.log("Province :" + province);
        }
    }
    
    @And(".*click You Entered if address validation pop-up is displayed*$")    
    public void click_youEntered_Address() throws Exception {
    	if(xcomregConfig.getProperty("ADDRESS_VALIDATION_POPUP").equalsIgnoreCase("true"))
    	{
    		List<WebElement> elements = getDriver().findElements(By.xpath("//div/legend"));
    		int size = elements.size();
    		System.out.println("The size is : "+size);
    		getDriver().findElement(By.xpath("(//div/legend)["+size+"]")).click();    		
    		actionMethods.click("MyAccountAddress.confirmAddress_button");
    	}
    	else
    	{
    		context.scenario.log("Address Validation is not enabled on the store :" +store);
    	}
    }

}
