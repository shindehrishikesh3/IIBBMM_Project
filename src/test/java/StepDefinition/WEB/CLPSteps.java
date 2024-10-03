package StepDefinition.WEB;

import Common.UTILS.ContextStore;

import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CLPSteps extends WebDriverConfig {

	private ContextStore context;
	private ReadContext readContext;
	String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
			+ "//";

	public CLPSteps(ContextStore context) {
		this.context = context;
	}

	List<Map<String, String>> expectedLinks;

	@Then("^.*select any random product link having \"([^\"]*)\" \"([^\"]*)\" products as \"([^\"]*)\" categories and click on it$")
	public void click_on_random_link(String limit, int count, String catgory) throws Exception {
		List<String> urls = new ArrayList<String>();
		List<WebElement> locator;
		String mainLocator = "";
		String partialLocator = "";
		if (catgory.equalsIgnoreCase("L0")) {
			locator = actionMethods.getMutipleLocators("BrowseForProducts.allCategoryProductCount_text");
			mainLocator = actionMethods.getLocatorString("BrowseForProducts.allCategoryProductCount_text");
			partialLocator = "/preceding-sibling::h2/a";
		} else {
			locator = actionMethods.getMutipleLocators("BrowseForProducts.allSubCategoryProductCount_text");
			mainLocator = actionMethods.getLocatorString("BrowseForProducts.allSubCategoryProductCount_text");
			partialLocator = "/preceding-sibling::a";
		}
		for (int i = 0; i < locator.size(); i++) {
			String productCount_str = locator.get(i).getText().trim().replaceAll("[^0-9]", "").replaceAll(" ", "");
			System.out.println("productstring: " + productCount_str);
			int productCount = Integer.parseInt(productCount_str);
			if (limit.equalsIgnoreCase("minimum") && productCount >= count) {
				System.out.println("productcount stored: " + productCount);
				int j = i + 1;
				String value = "(" + mainLocator + ")[" + j + "]" + partialLocator;
				String url = driver.findElement(By.xpath(value)).getAttribute("href");
				urls.add(url);
			} else if (limit.equalsIgnoreCase("maximum") && (productCount > 40) && (productCount <= count)) {
				System.out.println("productcount stored: " + productCount);
				int j = i + 1;
				String value = "(" + mainLocator + ")[" + j + "]" + partialLocator;
				String url = driver.findElement(By.xpath(value)).getAttribute("href");
				urls.add(url);
			} else {
				System.out.println("Product count missing to filter");
			}
		}
		Random r = new java.util.Random();
		String randomCategory = urls.get(r.nextInt(urls.size()));
		driver.get(randomCategory);
		this.context.scenario.log("Navigated to: " + randomCategory);
	}

	@Then("^validates the child category links does not contains worthless tags$")
	public void verify_not_an_worthless_link() throws Exception {
		if (uiMethods.isElementDisplayed("CategoryPage.category_list")) {
			List<WebElement> urls = getMutipleLocators("CategoryPage.subCategory_urls");
			for (WebElement url : urls) {
				if (url.getAttribute("href").contains("/w/"))
					Assert.fail();
			}
			context.scenario.log(
					"Child categories with /prl/results url doesnot contains /w/ when a valuable filter is applied");
		} else {
			context.scenario.log("Navigated to PLP Page. Selecting next manufacturer filter");
		}
	}

	@Then("^validates the child category links contains worthless tags$")
	public void verify_worthless_link() throws Exception {
		if (uiMethods.isElementDisplayed("CategoryPage.category_list")) {
			List<WebElement> urls = getMutipleLocators("CategoryPage.subCategory_urls");
			for (WebElement url : urls) {
				if (!url.getAttribute("href").contains("categoryId")) {
					if (!url.getAttribute("href").contains("/w/")) {
						Assert.fail();
					}
				}
			}
			context.scenario
					.log("Child categories with /prl/results url contains /w/ when a non valuable filter is applied");
		} else {
			context.scenario.log("Navigated to PLP Page. Selecting next manufacturer filter");
		}
	}

	@And("^open \"([^\"]*)\" url for \"([^\"]*)\".*from json \"([^\"]*)\"$")
	public void open_url_from_category_json(String key, String categoryName, String jsonFileName) {
		String path = fileOperations.getEnvFolderPath() + jsonFileName;
		System.out.println("FilePath: " + path);
		readContext = JsonUtil.getJsonDocument(path);
		List<String> url = readContext.read("$.HEADERS[?(@.TITLE=='" + categoryName + "')]." + key);
		String finalurl = getSiteBaseUrl() + storeText.getStoreText(url.get(0));
		this.context.scenario.log("url: " + finalurl);
		driver.get(finalurl);
	}

	@And("^verify \"([^\"]*)\".*description with \"([^\"]*)\"$")
	public void verify_category_description(String categoryName, String locator) throws Exception {

		List<String> expectedContent = readContext.read("$.HEADERS[?(@.TITLE=='" + categoryName + "')].CONTENT");
		String actualContent;
		// int contentNum = getMutipleLocators(locator).size();
		if (uiMethods.isElementDisplayed("CategoryPage.moreText_link")) {
			actionMethods.click("CategoryPage.moreText_link");
			Thread.sleep(1000);
		}

		actualContent = actionMethods.getValue(locator).trim();
		String expcontent = expectedContent.get(0).replace("<br>", "\n");
		Assert.assertEquals("Description is not as expected", expcontent, actualContent);
	}

	@And("^verify hyperlinked text in the description with \"([^\"]*)\" for.*\"([^\"]*)\" if any$")
	public void verifyHyperLinkedTextAndLinks(String locator, String categoryName) throws Exception {
		List<WebElement> actualLinksWE;
		String productResultsHeader = actionMethods.getValue("PLP.header_text");
		if (!productResultsHeader.contains(storeText.getStoreText("0 Products Found"))) {
			// Get expected data from json
			List<Boolean> hrefPresent = readContext.read("$.HEADERS[?(@.TITLE=='" + categoryName + "')].HYPERLINK?");

			HashMap<String, String> expectedWordAndUrls = new HashMap<String, String>();
			if (hrefPresent.get(0).equals(true)) {

				expectedLinks = readContext.read("$.HEADERS[?(@.TITLE=='" + categoryName + "')].LINKS");

				for (String key : expectedLinks.get(0).keySet()) {
					String url = storeText.getStoreText(expectedLinks.get(0).get(key));
					String value = key.contains("Source_3rd Party") ? url : getSiteBaseUrl() + url;

					if (key.contains("Source_3rd Party")) {
						key = key.replaceAll("\\[.*?\\]", "");

					}

					expectedWordAndUrls.put(key, value);
				}

				// Get actual urls
				actualLinksWE = actionMethods.getMutipleLocators(locator);

				for (WebElement element : actualLinksWE) {
					context.urls.put(element.getText(), element.getAttribute("href").trim());
				}
				this.context.scenario.log("Actual word=url pairs:" + context.urls);

				// compare expected and actual
				this.context.softAssertions.assertThat(context.urls)
						.overridingErrorMessage("Category: %s, Actual:%s \n Expected: %s", categoryName, context.urls,
								expectedWordAndUrls)
						.isEqualTo(expectedWordAndUrls);
			}
		}

	}

	@And("^verify innerlinks are doesnot contain \"([^\"]*)\"$")
	public void innerlinks_not_worthless(String value) {
		if (!context.urls.isEmpty()) {
			for (String key : context.urls.keySet()) {
				context.softAssertions.assertThat(context.urls.get(key))
						.overridingErrorMessage("Innerlink: %s contains worthless url", context.urls.get(key))
						.doesNotContain(value);
			}
		} else
			this.context.scenario.log("No hyperlinks to validate");
	}

	@And("^verif.*\"([^\"]*)\".*header for \"([^\"]*)\"$")
	public void verify_content_header(String value, String locator) throws Exception {
		List<String> contentHeader = readContext.read("$.HEADERS[?(@.TITLE=='" + value + "')].HEADER");
		String actualContentHeader = actionMethods.getValueUsingAttribute(locator, "innerText").trim();
		String expectedContentHeader = contentHeader.get(0);
		this.context.softAssertions.assertThat(actualContentHeader).isEqualTo(expectedContentHeader);
	}

}
