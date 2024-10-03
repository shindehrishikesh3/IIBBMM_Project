package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.ReadContext;

public class SearchSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public SearchSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*verify the \"([^\"]*)\" listed for \"([^\"]*)\" has atleast \"([^\"]*)\" rows of data$"
    )
    public void verify_attributes(
        String titleOfCategory,
        String lookaheadList,
        int expectedCount
    ) throws Exception {
        // Title could be- Attributes, Manufactures, Categories and Products
        Assert.assertTrue(uiMethods.isElementDisplayed(titleOfCategory));
        this.context.scenario.log(
                "Text present in lookahead: " +
                actionMethods.getValue(titleOfCategory).trim()
            );
        List<WebElement> list_attributes = getMutipleLocators(lookaheadList);
        Assert.assertTrue(
            "Count of Search look ahead is not >= " + expectedCount,
            ((list_attributes.size()) >= expectedCount)
        );
    }

    @And("^.*verify searchlookahead header and data row count$")
    public void verify_attributes() throws Exception {
        // Title could be- Attributes, Manufactures, Categories and Products
        int expCOUNT = this.context.constants.getSearchLookaheadHeadingCount();
        List<WebElement> actSLHeaders = getMutipleLocators(
            "Search.searchLookAheadHeaders_list"
        );
        actSLHeaders.forEach(e -> {
            this.context.scenario.log(e.getText() + ", ");
        });
        Assert.assertEquals(
            "Search lookahead header count mismatch",
            expCOUNT,
            actSLHeaders.size()
        );
        for (int i = 1; i < expCOUNT; i++) {
            Assert.assertTrue(
                "Rows missing under lookahead header #" + i,
                driver
                    .findElements(
                        By.xpath(
                            "//*[@id='lookAheadResponse']/div/ul[" +
                            i +
                            "]/table/tbody/tr"
                        )
                    )
                    .size() >
                0
            );
        }
        Assert.assertTrue(
            "No Products displayed in searchlookahead",
            uiMethods.verifyElementExistence("Search.products_list")
        );
    }

    @And("^.*verify searchlookahead data matching for manufacturer$")
    public void verify_searchlookaheadData() throws Exception {
        List<WebElement> actSLHeaders = getMutipleLocators(
            "Search.searchLookAheadHeaders_list"
        );
        actSLHeaders.forEach(e -> {
            if (e.getText().equalsIgnoreCase("MANUFACTURERS")) {
                this.context.scenario.log(e.getText() + ", ");
                try {
                    List<WebElement> manufacturersList = getMutipleLocators(
                        "Search.manufacturers_list"
                    );
                    int countofManufacturers = manufacturersList.size();
                    for (int i = 0; i < countofManufacturers; i++) {
                        this.context.scenario.log(manufacturersList.get(i).getText());
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        Assert.assertTrue(
            "No Products displayed in searchlookahead",
            uiMethods.verifyElementExistence("Search.manufacturers_list")
        );
    }

    @And(
        "^.*User Enters SearchTerm from \"([^\"]*)\" and collects the ProductCount Results in Excel$"
    )
    public void ExcelOutput(String InputFileName) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYMMddHHmm");
        String FilePath1 =
                System.getProperty("user.dir") +
                "//src//test//resources//TestData//" +
                getEnv().toUpperCase() +
                "//SearchKeywords//";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sdf1.format(timestamp);
        String s = sdf1.format(timestamp) + getStore().toUpperCase() + InputFileName;
        String OutputFileName = s;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(s);
        String OutputFilePath =
            System.getProperty("user.dir") + "//target//test-output//";
        String outputpath = OutputFilePath + OutputFileName;
        String path = FilePath1 + InputFileName;
        Map<String, String> ProductCount = new HashMap<String, String>();
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        int rowid = 0;

        for (i = 0; i < count; i++) {
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm = testData.get(i).get("SearchTerm");
            String act_Value = "";
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue(
                    "Data missing.NA for this store. product Type:" + "SearchTerm",
                    false
                );
            } else {
                context.scenario.log(searchterm);
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm, "Header.searchBox_textbox");
                actionMethods.click("Header.searchIcon_button");
                Thread.sleep(2000);

                if (
                    actionMethods.uiMethods.isElementPresent("Search.productCount_text")
                ) {
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    act_Value =
                        actionMethods
                            .getValue("Search.productCount_text")
                            .replaceAll("[,'. ]", "");
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "CategoryPage.showAllProducts_button"
                    )
                ) {
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    actionMethods.scrollDownPage(300);
                    uiMethods.scrollToAnyWhere("CategoryPage.showAllProducts_button");
                    actionMethods.click("CategoryPage.showAllProducts_button");
                    Thread.sleep(2000);
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    act_Value =
                        actionMethods
                            .getValue("Search.productCount_text")
                            .replaceAll("[,'. ]", "");
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "PDP.legislationEnvironmentalTableLabels_element"
                    )
                ) {
                    act_Value = "1";
                    context.scenario.log("Only 1 Product is Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    int tableSize = getMutipleLocators(
                        "PDP.legislationEnvironmentalTableLabels_element"
                    )
                        .size();
                    Assert.assertTrue("Legislation Section has headers", tableSize > 0);
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "ManufacturePage.manufacturerPageTitle"
                    )
                ) {
                    act_Value = "Manufacturer";
                    context.scenario.log("Only 1 Product is Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                } else {
                    act_Value = "0";
                    context.scenario.log("No Product Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                }
                Thread.sleep(2000);
                ProductCount.put(searchterm, act_Value);
            }

            XSSFRow row;
            row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue((String) searchterm);
            int cellid = 1;
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String) act_Value);

            FileOutputStream out = new FileOutputStream(new File(outputpath));
            workbook.write(out);
            out.close();
        }
    }

    @Given(
        "^User enters \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox and I verify data matching for manufacturer in Searchahead$"
    )
    public void enter_Searchcode_from_file(String key, String filename) throws Exception {
        String path = FilePath + filename;
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        for (i = 0; i < count; i++) {
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm1 = testData.get(i).get(key);
            String searchterm2 = testData.get(i).get("secondCharacter");
            String searchterm = searchterm1 + searchterm2;
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue("Data missing.NA for this store. product Type:" + key, false);
            } else {
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm1, "Header.searchBox_textbox");
                Thread.sleep(2000);
                actionMethods.enterText(searchterm2, "Header.searchBox_textbox");
                Thread.sleep(4000);
                this.context.scenario.log("searchterm :" + searchterm);
                context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "test"
                );
                List<WebElement> actSLHeaders = getMutipleLocators(
                    "Search.searchLookAheadHeaders_list"
                );
                actSLHeaders.forEach(e -> {
                    if (e.getText().equalsIgnoreCase("MANUFACTURERS")) {
                        // this.context.scenario.log("Manufacturers for SearchTerm " + searchterm);
                        try {
                            List<WebElement> manufacturersList = getMutipleLocators(
                                "Search.manufacturers_list"
                            );
                            int countofManufacturers = manufacturersList.size();
                            this.context.scenario.log(
                                    "Manufacturers for SearchTerm " +
                                    searchterm +
                                    " is " +
                                    countofManufacturers
                                );
                            for (int x = 0; x < countofManufacturers; x++) {
                                this.context.scenario.log(
                                        manufacturersList.get(x).getText()
                                    );
                                Thread.sleep(4000);
                            }
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Given(
        "^User enters \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox and I verify Searchahead Suggestions$"
    )
    public void Search_Suggestions(String key, String filename) throws Exception {
        String FilePath1 =
            System.getProperty("user.dir") +
            "//src//test//resources//TestData//" +
            getEnv().toUpperCase() +
            "//SearchKeywords" +
            "//";
        String path = FilePath1 + filename;
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        for (i = 0; i < count; i++) {
   
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm = testData.get(i).get(key);
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue("Data missing.NA for this store. product Type:" + key, false);
            } else {
                this.context.scenario.log("searchterm :" + searchterm);
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm, "Header.searchBox_textbox");
                Thread.sleep(2000);
                context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "test"
                );
                List<WebElement> SuggestionsList = getMutipleLocators(
                    "Search.response_search"
                );
                this.context.scenario.log(SuggestionsList.get(0).getText());
                Thread.sleep(2000);
            }
        }
    }
    
    @And ("^user reads in terms from file \"([^\"]*)\" and collect counts with special chars in \\\"([^\\\"]*)\\\" store$")
    public void collect_keyword_result_count_special(String filename, String storeName) throws Exception {
        this.context.scenario.log("collecting keyword counts");
        
        String[] lookupTerm;
        long[][] keywordTimeCounts;
        boolean specialFound;
        int specialCount;
        int alphaCount;
        String[] specialLookup = null;
        String[] alphaLookup = null;
        long specials[][] = null;
        long alphaNumerics[][] = null;
        
        System.out.print("reading keywords from excel \n");
        //call the read for excel and retun the array of search terms
        lookupTerm = read_excel_file_and_return_array(filename, storeName);
                    
        System.out.print("searching for keywords and recording counts \n");
        //call the API to search for given keywords (lookupTerm[])
        keywordTimeCounts = get_search_result_count_for_keywords_with_time(storeName, lookupTerm);
                
        //split by whether there's special chars
        specialLookup = new String[lookupTerm.length];
        alphaLookup = new String[lookupTerm.length];
        
        specials = new long[keywordTimeCounts.length][2];
        alphaNumerics = new long[keywordTimeCounts.length][2];
        
        specialFound = false;
        specialCount = 0;
        alphaCount = 0;
        
        for (int i=0; i<lookupTerm.length; i++) {
            //check for specials
            if (lookupTerm[i] == null) {
                System.out.print("possible error, skipping \n");
            } else {
                for (int c=0; c<lookupTerm[i].length(); c++) {
                    if ( !(  ( lookupTerm[i].charAt(c) >= '0' && lookupTerm[i].charAt(c) <= '9' )
                           || ( lookupTerm[i].charAt(c) >= 'a' && lookupTerm[i].charAt(c) <= 'z' )
                           || ( lookupTerm[i].charAt(c) >= 'A' && lookupTerm[i].charAt(c) <= 'Z' )
                           || ( lookupTerm[i].charAt(c) == ' ' ) ) ) {
                        //special found
                        specialFound = true;
                        break;
                    }
                }
            }
            if (specialFound) {
                specials[specialCount][0] = keywordTimeCounts[i][0];
                specials[specialCount][1] = keywordTimeCounts[i][1];
                specialLookup[specialCount] = lookupTerm[i];
                specialCount++;
            } else {
                alphaNumerics[alphaCount][0] = keywordTimeCounts[i][0];
                alphaNumerics[alphaCount][1] = keywordTimeCounts[i][1];
                alphaLookup[alphaCount] = lookupTerm[i];
                alphaCount++;
            }
            specialFound = false;
        }
        
        System.out.print("saving keyword counts \n");
        this.context.scenario.log("saving keyword counts - alphanumerics " + alphaCount + " -- special chars " + specialCount);
        //call the write for excel and output the two arrays
        output_excel_file_with_search_and_time_counts(specialLookup,specials,"specials_");
        output_excel_file_with_search_and_time_counts(alphaLookup,alphaNumerics,"alphanumerics_");
        
    }

    private String[] read_excel_file_and_return_array(String filename, String storeName) throws Exception{
        //open excel & read in all lines into an array
        //set the path of the excel file 
        //set the path of the excel file 
        System.out.print("get excel function initiated\n");
        String path = FilePath + filename;
        System.out.print("file path = " + path + "\n");
        //open the file and get row count
        int count = ExcelUtil.getWorkbook(path).getSheet(storeName).getLastRowNum();
        System.out.print("count = " + count + "\n");
        //loop to get all search terms
        String[] tempArray = new String[count];
        System.out.print("set term array" + "\n");
        //get the data from the excel file
        List<Map<String, String>> testData = ExcelUtil.getData(path, storeName);
        System.out.print("got excel data" + "\n");
        int i;
        for (i = 0; i < count; i++) {
            //String searchterm = testData.get(i).get("SearchTerm");
            tempArray[i] = testData.get(i).get("SearchTerm");
            if (tempArray[i] == "") {
                    System.out.print("Search Term " + i + " blank, no further terms will be added \n");
                    count = i;
            }
        }
        System.out.print("total search terms to be processed: " + count + " \n");
        //get rid of extra lines not needed
        String[] lookupTerm = new String[count];
        for (i = 0; i < count; i++) {
            lookupTerm[i] = tempArray[i];
        }

        return lookupTerm;
    }
    
    private long[][] get_search_result_count_for_keywords_with_time(String storeName, String[] lookupTerm) throws FileNotFoundException {
      //set up the API
        HashMap<String, String> headers = new HashMap<String, String>();
        HashMap<String, String> queryParams = new HashMap<String, String>();
        // prepare environment
        apiBaseMethods.setRestAssuredProxy();
        setBaseURI(storeName);
        baseURI = baseURI + "search";
        //in a loop, call the API for each term
        int count = lookupTerm.length;
        String pathParameter = "";
        this.context.config = RestAssuredConfig
                .config().redirect(RedirectConfig.redirectConfig().followRedirects(true));        
        long[][] itemsReturned = new long[count][2];
        long timeElapsed = 0;
        Response apiResponse;
        String body;
        int returnCode;
        Document doc;
        Element element;
        long numOfItemsReturned;
        
        for (int i=0; i<count; i++) {
            if (lookupTerm[i] == "" || lookupTerm[i] == null) {
                //blank so no more terms to process
                i=count;
            } else {
                queryParams.put("st", lookupTerm[i]);
                apiResponse = apiBaseMethods.getRequest(this.context.config, headers, queryParams, pathParameter);
                body = apiResponse.getBody().asString();
                timeElapsed = apiResponse.getTime(); 
                returnCode = apiResponse.getStatusCode();
                // Parse the html string into a document
                doc = Jsoup.parse(body, "UTF-8");

                /*   Product Detail:Product View
                     Search:No Search Results
                     Search:Product Lister - Leaf
                     Search:Multi-Category   
                     also look out for 403 response (or any non-200?)*/
                
                String value = "";
                
                if (returnCode != 200) {
                    value = "9999" + Integer.toString(returnCode);
                } else {
                    element = doc.getElementById("_DT_omniturePageName");
                
                    if (element.text() != null) {
                        switch(element.text()) {
                            case "Product Detail:Product View":
                                //product detail page means only one result has been found
                                value = "1";
                                break;
                            case "Search:No Search Results":
                                value = "0";
                                break;
                            case "Search:Product Lister - Leaf":
                                //get the value from the element in question
                                element = doc.getElementById("titleProdCount");
                                if (element != null) {
                                    value = element.text();
                                } else {
                                    value = "9999";
                                }
                                break;
                            case "Search:Multi-Category":
                                //get the value from the element in question
                                element = doc.getElementById("titleProdCount");
                                if (element != null) {
                                    value = element.text();
                                } else {
                                    value = "9999";
                                }
                                break;
                            default:
                               value = "9999";    
                        }
                    }
                }
                
                String tempValue;
                
                if (value.indexOf(",") > 0) {
                    //get rid of the comma!
                    tempValue = value.substring(0,value.indexOf(","));
                    tempValue = tempValue + value.substring(value.indexOf(",")+1,value.length());
                    value = tempValue;
                }
                numOfItemsReturned = Long.parseLong(value); 
                itemsReturned[i][0] = numOfItemsReturned;
                itemsReturned[i][1] = timeElapsed;
                System.out.print("array size = " + itemsReturned.length + " number of elements counted = " + i + "\n");
                
                
            }
        }
        
        //return results
        return itemsReturned;
    }
    
    private void output_excel_file_with_search_and_time_counts(String[] lookupTerm, long[][] keywordTimeCounts, String fileText) throws FileNotFoundException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String outputTime = new SimpleDateFormat("yyyyMMdd hhmm").format(timestamp);
        String OutputFileName = fileText + getStore().toUpperCase() + "_" + outputTime +".xlsx";
        String OutputFilePath =
                System.getProperty("user.dir") + "//target//test-output//";
        OutputFilePath = OutputFilePath + OutputFileName;
        System.out.print("******file path = " + OutputFilePath + "\n");
        int rowno;
        XSSFWorkbook workbook;
        XSSFSheet spreadsheet;
        FileOutputStream file;
        
        //Creating a workbook
        workbook = new XSSFWorkbook();

        //Making sure a spreadSheet exists before retrieving it
        if (workbook.getNumberOfSheets() == 0) {
            workbook.createSheet();
        }
        spreadsheet = workbook.getSheetAt(0);

        rowno=0;
        
        for(int i=0; i< lookupTerm.length; i++) {
            XSSFRow row=spreadsheet.createRow(rowno++);
            row.createCell(0).setCellValue(lookupTerm[i]);
            row.createCell(1).setCellValue(keywordTimeCounts[i][0]);
            row.createCell(2).setCellValue(keywordTimeCounts[i][1]);
        }
   
        file = new FileOutputStream(OutputFilePath);
        try {
            workbook.write(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Data Copied to Excel " + lookupTerm.length + " items\n");
        this.context.scenario.log("Data Copied to Excel " + lookupTerm.length + " items");

    }
    
	@And("^.*verify zero search results page \"([^\"]*)\" in \"([^\"]*)\" from \"([^\"]*)\" file for \"([^\"]*)\"$")
	public void verify_Component(String key, String locator, String jsonFileName, String store) throws Exception {

		String path = fileOperations.getEnvFolderPath() + jsonFileName;
		ReadContext rx = JsonUtil.getJsonDocument(path);
		actionMethods.waitForByElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		String actualHeading = actionMethods.getValue(locator).trim();
		String expectedHeading = JsonUtil.getKeyValueFromCommonJson(rx, store + "." + key);
		this.context.softAssertions.assertThat(actualHeading)
				.overridingErrorMessage("store:%s key: %s Expected:%s Actual:%s", store, key, expectedHeading,
						actualHeading)
				.isEqualTo(expectedHeading);

	}

	@And("^.*validate zero search results page content \"([^\"]*)\"in \"([^\"]*)\" from \"([^\"]*)\" file for \"([^\"]*)\"$")
	public void validate_ComponentContent(String component, String locator, String jsonFileName, String store)
			throws Exception {

		String path = fileOperations.getEnvFolderPath() + jsonFileName;
		ReadContext rx = JsonUtil.getJsonDocument(path);
		List<String> actualContent = new ArrayList<String>();
		List<String> expContent = new ArrayList<String>();
		String Content = null;
		Content = JsonUtil.getKeyValueFromCommonJson(rx, store + "." + component);
		expContent = Arrays.asList(Content.split("!"));
		actionMethods.waitForByElementToAppear(this.context.constants.getShortWaitSeconds(), locator);
		List<WebElement> ContentElement = actionMethods.getMutipleLocators(locator);
		Object[] objects = ContentElement.toArray();
		int ContentElementcount = getMutipleLocators(locator).size();
		if (component.equalsIgnoreCase("LeftComponentContent")) {
			ContentElementcount = ContentElementcount - 1;
		}
		for (int i = 0; i < ContentElementcount; i++) {
			WebElement element = (WebElement) objects[i];
			String actualContentText = element.getText().trim();
			actualContent.add(actualContentText);
		}

		this.context.softAssertions.assertThat(actualContent)
				.overridingErrorMessage("store:%s key:%s Expected:%s Actual:%s", store, component, expContent,
						actualContent)
				.isEqualTo(expContent);

	}

	@And("^.*verify link \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_Links(String key, String store) throws Exception {
		String expectedURL = null;
		String actualURL = driver.getCurrentUrl();
		if (key.equalsIgnoreCase("EnquireNowButtonLink")) {
			expectedURL = "/custom-components?ICID=I-CT-LP-MPRO_CUSTOM_SERVICES-WF2226648";

		} else if (key.equalsIgnoreCase("RequestAQuoteButtonLink")) {
			expectedURL = "https://premierfarnell.getfeedback.com/r/dBGpdYF5/q/1";

		}
		this.context.softAssertions.assertThat(actualURL)
				.overridingErrorMessage("store:%s Link:%s Expected:%s Actual:%s", store, key, expectedURL, actualURL)
				.contains(expectedURL);

	}
}