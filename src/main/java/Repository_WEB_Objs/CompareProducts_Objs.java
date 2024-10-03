package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class CompareProducts_Objs {

    // Creation of HashMap
    private static final Map<String, String> CompareProducts;

    static {
        CompareProducts = new HashMap<String, String>();
        CompareProducts.put("CompareProducts_text", "//*[@class='section']//h1");
        CompareProducts.put("orderCode_text", "//*[@id='compareTable']/tbody/tr[1]/td");
        CompareProducts.put(
            "manufacturerAndPartNumber_text",
            "//*[@id='compareTable']/tbody/tr[3]/td"
        );
        CompareProducts.put("addToCart_button", "(//*[contains(@id,'splAddToCart')])[1]");
        CompareProducts.put("deleteAll_link", "//*[@class='feature']/a");
        CompareProducts.put("backToPreviousPage_link", "//a[@class='backBtn']");
        CompareProducts.put("CompareMessage_text", "//div[@class='titleHolder']");
        CompareProducts.put("firstDelete_link", "(//a[@class='compRemove'])[2]");
        CompareProducts.put(
            "orderCodeItem_text",
            "(//*[@id='compareTable']//tbody//tr[1]/td/a)"
        );
        CompareProducts.put(
            "rohsCertificateOfCompliance_icons",
            "//div[starts-with(@class, 'pfIcon pfRohsCompliance')]"
        );
        CompareProducts.put(
            "rohsCertificateOfCompliance_link",
            "(//div[starts-with(@class, 'pfIcon pfRohsCompliance')])[1]"
        );
        CompareProducts.put("htmlCertificate_link", "//span[@class='pfIcon pfBrowser']");
    }

    public String findLocator(String elementName) {
        if (CompareProducts.containsKey(elementName)) {
            return (CompareProducts.get(elementName.trim()));
        }

        return null;
    }
}
