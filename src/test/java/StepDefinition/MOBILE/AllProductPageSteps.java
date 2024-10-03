package StepDefinition.MOBILE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class AllProductPageSteps extends WebDriverConfig {
    private ContextStore context;
    public AllProductPageSteps(ContextStore context) {
        this.context = context;
    }

    @And ("^.*random product link having less than \"([^\"]*)\" products from \"([^\"]*)\" and click on it")
    public void click_on_random_link_mobile(int count, String loc) throws Exception {
		List<String> urls = new ArrayList<String>();
		List<WebElement> locator = actionMethods.getMutipleLocators("BrowseForProducts.allSubCategoryProductCount_text");
		
		for (int i = 0; i < locator.size(); i++) {
			String productCount_str = locator.get(i).getText().trim().replaceAll("[^0-9]", "").replaceAll(" ", "");
			System.out.println("productstring: " + productCount_str);
			int productCount = Integer.parseInt(productCount_str);
            if ((productCount > 0) && (productCount < count)) {
                System.out.println("productcount stored: " + productCount);
                int j = i + 1;
                String value = "(" + actionMethods.getLocatorString("BrowseForProducts.allSubCategoryProductCount_text")
                        + ")[" + j + "]/preceding-sibling::a";
                String url = driver.findElement(By.xpath(value)).getAttribute("href");
                urls.add(url);
            }			
		}
		Random r = new java.util.Random();
		String randomCategory = urls.get(r.nextInt(urls.size()));
		driver.get(randomCategory);
	}
}
