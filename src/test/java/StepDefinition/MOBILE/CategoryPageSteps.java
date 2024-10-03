package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPageSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CategoryPageSteps(ContextStore context) {
        this.context = context;
    }

    private ReadContext readContext;
    String expectedTitle, actualTitle, expectedContent, actualContent, titleLink;
    List<String> expectedLinkWord = new ArrayList<String>();
    List<String> actualLinkWord = new ArrayList<String>();
    List<String> expectedURLs = new ArrayList<String>();
    List<String> actualURLs = new ArrayList<String>();

    @And(
        "^.*verify Categories with product count is present in descending order in Categories Section \"([^\"]*)\"$"
    )
    public void verifySubCategoriesInDescendingOrderOfProductCount(String locator)
        throws Exception {
        List<WebElement> elementObj = getMutipleLocators(locator);
        ArrayList<Integer> Count = new ArrayList<Integer>();
        int misCount = misCategCount(locator);

        /* - is done as Miscellaneous categories are excluded */
        for (int j = 1; j <= elementObj.size() - misCount; j++) {
            String productCount = "//*[@class='categories-1']/li[" + j + "]/span";
            String categoryProductCount = getDriver()
                .findElement(By.xpath(productCount))
                .getText();

            String substring = categoryProductCount.substring(
                1,
                categoryProductCount.length() - 1
            );
            String newString =
                ((substring.replace(",", "")).replace(".", "")).replace(" ", "");

            int number = Integer.parseInt(newString);
            boolean flag = number >= 1;
            Assert.assertEquals("Product Count is Less Than 1......", true, flag);

            Count.add(number);
        }

        ArrayList<Integer> ProductCountOrder = new ArrayList<Integer>();

        // COPY actual list to another list
        ProductCountOrder.addAll(Count);
        Comparator c = Collections.reverseOrder();
        Collections.sort(ProductCountOrder, c);
        boolean sorted = ProductCountOrder.equals(Count);
        Assert.assertEquals(
            "Product Count is not in desending order........",
            true,
            sorted
        );
        Count.clear();
        ProductCountOrder.clear();
    }

    @And(
        "^.*verify Miscellaneous Categories are present at the bottom in Categories Section \"([^\"]*)\"$"
    )
    public void verifyMiscellaneousCategoryAtBottom(String locator) throws Exception {
        /* Assertion for miscellaneous need to be done by checking logs only */
        List<WebElement> elementObj = getMutipleLocators(locator);
        context.scenario.log(
            "<------Verify that Categories are present as link followed by Space & product count in bracket------->"
        );
        for (WebElement ele : elementObj) {
            context.scenario.log(ele.getText());
        }
        context.scenario.log("<---------------------------------------------------->");
    }

    public int misCategCount(String locator) throws Exception {
        int misCount = 0;
        List<WebElement> elementObj = getMutipleLocators(locator);
        for (WebElement ele : elementObj) {
            if (
                ele.getText().contains(storeText.getStoreText("Miscellaneous")) ||
                ele.getText().contains(storeText.getStoreText("More"))
            ) {
                misCount++;
            }
        }
        return misCount;
    }

    @And("^.*verify Category lister page is not empty \"([^\"]*)\"$")
    public void categoryListerPageIsPresent(String locator) throws Exception {
        List<WebElement> elementObj = getMutipleLocators(locator);
        int productsOnListerPage = elementObj.size();
        Assert.assertTrue(productsOnListerPage <= 25);
        context.scenario.log("Total products found on page:" + productsOnListerPage);
    }

    @And(
        "^verifies \"([^\"]*)\" category content is displaying properly in mobile view with values in \"([^\"]*)\" json file$"
    )
    public void verify_multiple_category_page_content_mobile(
        String category,
        String fileName
    ) throws Exception {
        String path = FilePath + fileName;
        readContext = JsonUtil.getJsonDocument(path);
        int totalObjects = JsonUtil.getTotalObjectFromJsonArray(
            readContext,
            "CATEGORY_HEADERS"
        );
        String baseURL = driver.getCurrentUrl();
        for (int i = 0; i < totalObjects; i++) {
            validatedCategoryContents(readContext, i, category, baseURL);
        }
    }

    public void validatedCategoryContents(
        ReadContext rc,
        int i,
        String categoryName,
        String baseURL
    ) throws Exception {
        expectedTitle =
            JsonUtil.getValueFromJsonArray(rc, i, "CATEGORY_HEADERS", "TITLE");
        System.out.println("Manufacturer: " + expectedTitle);
        if (expectedTitle.equalsIgnoreCase(categoryName)) {
            fetchingDetailsFromJSON(rc, i, baseURL);
            navigateToCategoryPage(baseURL);
            fetchingActualContentsfromCategoryPage(baseURL, expectedTitle);
            contentValidation(
                expectedTitle,
                actualTitle,
                expectedContent,
                actualContent,
                expectedLinkWord,
                actualLinkWord,
                expectedURLs,
                actualURLs
            );
            context.scenario.log(
                "Content is displaying as expected for Supplier Category - " +
                categoryName
            );
        }
    }

    public void fetchingDetailsFromJSON(ReadContext rc, int i, String baseURL) {
        titleLink =
            JsonUtil.getValueFromJsonArray(rc, i, "CATEGORY_HEADERS", "TITLE_LINK");
        expectedContent =
            JsonUtil.getValueFromJsonArray(rc, i, "CATEGORY_HEADERS", "CONTENT");
        int totalInnerLinks = JsonUtil.getTotalValuesFromNestedJsonArray(
            rc,
            i,
            "CATEGORY_HEADERS",
            "LINKS"
        );
        for (int j = 0; j < totalInnerLinks; j++) {
            expectedLinkWord.add(
                JsonUtil.getValueFromNestedJsonArray(
                    rc,
                    i,
                    "CATEGORY_HEADERS",
                    "LINKS",
                    j,
                    "WORD"
                )
            );
            String url;
            if (baseURL.contains("en-")) {
                url =
                    baseURL +
                    "/" +
                    JsonUtil.getValueFromNestedJsonArray(
                        rc,
                        i,
                        "CATEGORY_HEADERS",
                        "LINKS",
                        j,
                        "URL"
                    );
                System.out.println("url added: " + url);
            } else url =
                baseURL +
                JsonUtil.getValueFromNestedJsonArray(
                    rc,
                    i,
                    "CATEGORY_HEADERS",
                    "LINKS",
                    j,
                    "URL"
                );

            expectedURLs.add(url);
        }
    }

    public void navigateToCategoryPage(String baseURL) throws IOException {
        System.out.println("Base URL during navigation: " + baseURL);
        if (baseURL.contains("en-")) {
            driver.get(baseURL + "//" + titleLink);
            System.out.println("Navigated to URL: " + baseURL + "/" + titleLink);
        } else {
            driver.get(baseURL + titleLink);
            System.out.println("Navigated to URL: " + baseURL + titleLink);
        }

        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            "PLP.PLP_element"
        );

        // Navigated to category page
        context.scenario.log(
            "Succesfully navigated to " + expectedTitle + " Product lister page"
        );
        context.scenario.attach(
            ScreenshotUtil.getByteScreenshot(),
            "image/png",
            "screenshot"
        );
    }

    public void fetchingActualContentsfromCategoryPage(String url, String category)
        throws Exception {
        actualTitle = actionMethods.getValue("CategoryPage.category_heading");
        if (uiMethods.isElementDisplayed("CategoryPage.moreText_link")) {
            actionMethods.getLocator("CategoryPage.moreText_link").click();
        }
        if (uiMethods.isElementDisplayed("CategoryPage.expandedContents_text")) {
            actualContent =
                actionMethods
                    .getValue("CategoryPage.expandedContents_text")
                    .replaceAll("[\\n ]", " ");
            List<WebElement> links = actionMethods.getMutipleLocators(
                "CategoryPage.expandedContentsInner_link"
            );
            if (links.size() > 0) {
                for (int k = 0; k < links.size(); k++) {
                    int idx = k + 1;
                    String loc_xpath =
                        actionMethods.getLocatorString(
                            "CategoryPage.expandedContentsInner_link"
                        ) +
                        "[" +
                        idx +
                        "]";
                    actualLinkWord.add(
                        driver.findElement(By.xpath(loc_xpath)).getText().trim()
                    );
                    String categoryLink = driver
                        .findElement(By.xpath(loc_xpath))
                        .getAttribute("href")
                        .trim();
                    actualURLs.add(categoryLink);

                    // checking the links whether it navigates to the correct page and not gives 404 error
                    driver.findElement(By.xpath(loc_xpath)).click();
                    actionMethods.waitForElementToAppear(
                        this.context.constants.getMediumWaitSeconds(),
                        "CategoryPage.categorylisterProducts_section"
                    );
                    Assert.assertTrue(
                        "Unable to navigate to the category page",
                        driver.getCurrentUrl().contains(categoryLink)
                    );
                    driver.navigate().back();
                    Thread.sleep(2000);
                    if (uiMethods.isElementDisplayed("CategoryPage.moreText_link")) {
                        actionMethods.getLocator("CategoryPage.moreText_link").click();
                    }
                }
            } else {
                actualLinkWord.add("NONE");
                if (url.contains("en-")) actualURLs.add(
                    url + "/NONE"
                ); else actualURLs.add(url + "NONE");
            }
        } else {
            actualContent = actionMethods.getValue("CategoryPage.contents_text");

            List<WebElement> links = actionMethods.getMutipleLocators(
                "CategoryPage.contentInner_link"
            );
            if (links.size() > 0) {
                for (WebElement link : links) {
                    actualLinkWord.add(link.getText().trim());
                    String categoryLink = link.getAttribute("href").trim();
                    actualURLs.add(categoryLink);

                    // checking the links whether it navigates to the correct page and not gives 404 error
                    link.click();
                    actionMethods.waitForElementToAppear(
                        this.context.constants.getMediumWaitSeconds(),
                        "CategoryPage.categoryContainer_section"
                    );
                    Assert.assertTrue(
                        "Unable to navigate to the category page",
                        driver.getCurrentUrl().contains(categoryLink)
                    );
                    driver.navigate().back();
                    Thread.sleep(2000);
                }
            } else {
                actualLinkWord.add("NONE");
                if (url.contains("en-")) actualURLs.add(
                    url + "/NONE"
                ); else actualURLs.add(url + "NONE");
            }
        }
    }

    public void contentValidation(
        String expectedTitle,
        String actualTitle,
        String expectedContent,
        String actualContent,
        List<String> expectedLinkWord,
        List<String> actualLinkWord,
        List<String> expectedURLs,
        List<String> actualURLs
    ) {
        context.softAssertions
            .assertThat(actualTitle)
            .as("Category Name")
            .isEqualTo(expectedTitle);
        context.scenario.log(
            "Category Name " + "'" + actualTitle + "'" + " is displyaing as expected"
        );
        context.softAssertions
            .assertThat(actualContent)
            .as("New Content")
            .isEqualTo(expectedContent);
        context.scenario.log(
            "Category content " + "'" + actualContent + "'" + " is displyaing as expected"
        );
        context.softAssertions
            .assertThat(actualLinkWord)
            .as("Link Texts")
            .isEqualTo(expectedLinkWord);
        context.softAssertions.assertThat(actualURLs).as("Links").isEqualTo(expectedURLs);
        if (!expectedLinkWord.contains("NONE")) {
            context.scenario.log(
                "Embedded link texts " +
                "'" +
                actualLinkWord +
                "'" +
                " are displyaing as expected"
            );
            context.scenario.log(
                "Embedded links " + "'" + actualURLs + "'" + " are displyaing as expected"
            );
        } else context.scenario.log("There are no embedded lionks for this category");
        context.softAssertions.assertAll();
        context.scenario.log(
            "Content, category name and all embedded links are displaying as expected for Category: " +
            "'" +
            expectedTitle +
            "'"
        );
    }
}
