package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class StoreTextKeysSteps extends WebDriverConfig {

    String dir_StoreTextKeys = "";
    static String storeTextfileName = "";
    static String storeTextfileNameTemp = "";
    CSVReader reader = null;
    List<String> StoreTextKey_temp = new ArrayList<String>();
    private ContextStore context;

    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    String StoreTextPath = System.getProperty("user.dir") + "//src//test//resources//";

    public StoreTextKeysSteps(ContextStore context) {
        this.context = context;
    }

    @And("^user get the store text keys of \"([^\"]*)\" page for element \"([^\"]*)\"$")
    public void getTextOnPage(String fileName, String locator) throws Exception {
        String text = actionMethods.getValue(locator);
        String storeTextfileName = StoreTextPath + fileName + ".csv";
        try (FileWriter writecsv = new FileWriter(storeTextfileName)) {
            writecsv.append(text);
        }
    }

    @And("^user get all the store text keys of \"([^\"]*)\" page$")
    public void getAllTextOnPage(String fileName) throws Exception {
        //Capture screenshot of the current page
        captureScreenshot();
        //Getting the store text results path from constants
        dir_StoreTextKeys = ContextStore.storeTextResultsPatStoreTextPath;

        // filtered storetext keys
        String value = "";
        List<String> StoreTextKey = new ArrayList<String>();
        List<WebElement> textList = driver.findElements(
            By.xpath(
                "//*[starts-with(text(),'???') or starts-with(text(),' ???') or contains(text(),'???') ]"
            )
        );
        System.out.println("Text List Size = " + textList.size());
        for (WebElement e : textList) {
            value = e.getAttribute("innerText").trim();
            StoreTextKey.add(value.trim());
        }
        File dir_StoreKeys = new File(dir_StoreTextKeys + "\\StoreTextKeys\\");
        dir_StoreKeys.mkdir();

        storeTextfileName = dir_StoreKeys + "\\" + fileName + ".csv";
        try (FileWriter writecsv = new FileWriter(storeTextfileName, true)) {
            for (int i = 0; i < StoreTextKey.size(); i++) {
                if (
                    StoreTextKey.get(i).startsWith("???") ||
                    StoreTextKey.get(i).startsWith("(???")
                ) {
                    if (StoreTextKey_temp.contains(StoreTextKey.get(i).trim()) == false) {
                        writecsv.append(StoreTextKey.get(i).trim());
                        writecsv.append("\n");
                        StoreTextKey_temp.add(StoreTextKey.get(i).trim());
                    }
                }
            }
            writecsv.flush();
            writecsv.close();
        }

        saveStoreKeys(fileName);
        saveSourceCode(fileName);
        saveHTMLInnerText(fileName);
        saveHTMLSourceCode(fileName);
    }

    @And("User enters credentials to login to the application")
    public void LoginStoretext() throws Exception {
        context.scenario.log("Verify user is login with valid credentials");
        String username = "";
        String password = "";
        String store = getStore();
        String region = getRegionName();
        String appName = getAppType();
        //username = loginConfig.getProperty(store+"_username");
        //password = loginConfig.getProperty(store+"_password");

        actionMethods.enterText("ppst_test_uk", "Login.username_textbox");
        //context.scenario.log("Username: " + username);
        actionMethods.enterText("Farnell@1234", "Login.password_textbox");
        //context.scenario.log("Password: " + password);
        Thread.sleep(3000);
        actionMethods.click("Login.login_button");
        Thread.sleep(9000);
    }

    //Method to save the store keys value to CSV file
    public void saveStoreKeys(String fileName)
        throws CsvValidationException, IOException {
        List<String> allKeys_list = new ArrayList<String>();
        int iCounter = 0;
        FileWriter storeTextFile_temp = null;
        String alltext = driver.findElement(By.tagName("body")).getText();
        File dir_AllKeys = new File(dir_StoreTextKeys + "\\AllKeys\\");
        dir_AllKeys.mkdir();

        storeTextfileName = dir_AllKeys + "\\" + fileName + ".csv";
        storeTextfileNameTemp = dir_AllKeys + "\\" + fileName + "_temp.csv";
        try {
            storeTextFile_temp = new FileWriter(storeTextfileNameTemp);
            storeTextFile_temp.append(alltext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        storeTextFile_temp.flush();
        storeTextFile_temp.close();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(storeTextfileNameTemp));
            String[] cell = null;
            while ((cell = reader.readNext()) != null) {
                allKeys_list.add(cell[iCounter].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        try (FileWriter storeTextFile  = new FileWriter(storeTextfileName)) {
            for (int i = 0; i < allKeys_list.size(); i++) {
                if (
                    allKeys_list.get(i).startsWith("???") ||
                    allKeys_list.get(i).startsWith("(???")
                ) {
                    if (StoreTextKey_temp.contains(allKeys_list.get(i).trim()) == false) {
                        storeTextFile.write(allKeys_list.get(i).trim());
                        storeTextFile.append("\n");
                        StoreTextKey_temp.add(allKeys_list.get(i).trim());
                    }
                }
            }
            storeTextFile.flush();
            storeTextFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File storeTextTemp = new File(storeTextfileNameTemp);
        //storeTextTemp.delete();
    }

    //Method to save source code to CSV file
    public void saveSourceCode(String fileName) {
        // store the source code of the page
        String sourcetext = driver.getPageSource();
        File dir_SourceCode = new File(dir_StoreTextKeys + "\\SourceCode\\");
        dir_SourceCode.mkdir();
        storeTextfileName = dir_SourceCode + "\\" + fileName + ".csv";
        try (FileWriter writecsv1 = new FileWriter(storeTextfileName)) {
            writecsv1.append(sourcetext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to save HTML inner text to CSV file
    public void saveHTMLInnerText(String fileName) throws CsvValidationException {
        FileWriter innerTextFile = null;
        List<String> innerTextKeys_list = new ArrayList<String>();
        String htmlInnerText = driver
            .findElement(By.tagName("body"))
            .getAttribute("innerText");
        System.out.println(htmlInnerText.trim());
        File dir_HTMLInnerText = new File(dir_StoreTextKeys + "\\HTMLInnerText\\");
        dir_HTMLInnerText.mkdir();
        storeTextfileName = dir_HTMLInnerText + "\\" + fileName + ".csv";
        storeTextfileNameTemp = dir_HTMLInnerText + "\\" + fileName + "_temp.csv";
        try (FileWriter innerTextFile_temp = new FileWriter(storeTextfileNameTemp)) {
            innerTextFile_temp.append(htmlInnerText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            reader = new CSVReader(new FileReader(storeTextfileNameTemp));
            String[] cell = reader.readNext();
            while ((cell = reader.readNext()) != null) {
                int i = 0;
                innerTextKeys_list.add(cell[i].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter innerTextFile_temp = new FileWriter(storeTextfileNameTemp)) {
            for (int i = 0; i < innerTextKeys_list.size(); i++) {
                if (
                    innerTextKeys_list.get(i).startsWith("???") ||
                    innerTextKeys_list.get(i).startsWith("(???")
                ) {
                    innerTextFile.write(innerTextKeys_list.get(i).trim());
                    innerTextFile.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File storeTextTemp = new File(storeTextfileNameTemp);
        storeTextTemp.delete();
    }

    //Method to save HTML source code to CSV file
    public void saveHTMLSourceCode(String fileName) throws CsvValidationException {
        String htmlsourcetext = driver
            .findElement(By.tagName("body"))
            .getAttribute("innerHTML");

        File dir_HTMLCode = new File(dir_StoreTextKeys + "\\HTMLCode\\");
        dir_HTMLCode.mkdir();
        storeTextfileName = dir_HTMLCode + "\\" + fileName + ".csv";
        try (FileWriter htmlSourceCode = new FileWriter(storeTextfileName)) {
            htmlSourceCode.append(htmlsourcetext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to save HTML source code to CSV file
    public void captureScreenshot() throws IOException, InterruptedException {
        context.scenario.attach(
            ScreenshotUtil.getFullPageScreenshot(),
            "image/png",
            "screenshot"
        );
    }

    //Method to check if store code is already available in the file
    /*
     * public static boolean readStoreText(String textToCheck) throws IOException,
     * CsvValidationException { CSVReader storeTextReader = null; int iLoop = 0;
     * boolean bFlag = false; storeTextReader = null; try { storeTextReader = new
     * CSVReader(new FileReader(storeTextfileNameTemp)); String[] cell = null; while
     * ((cell = storeTextReader.readNext()) != null) {
     * System.out.println("Cell value "+cell[0].trim());
     * System.out.println("text to check " +textToCheck);
     * System.out.println(cell[0].trim().equalsIgnoreCase(textToCheck)); if
     * (cell[0].trim().equalsIgnoreCase(textToCheck)) { bFlag = true; break; } iLoop
     * = iLoop + 1; } } catch (IOException e) { e.printStackTrace(); }
     * storeTextReader.close(); return bFlag; }
     */

    @And(
        "^User enters incorrect username \"([^\"]*)\" and password \"([^\"]*)\" to login to the application$"
    )
    public void LoginStoretextWithIncorrectCredentials(String username, String password)
        throws Exception {
        context.scenario.log("Verify user is login with valid credentials");
        String store = getStore();
        String region = getRegionName();
        String appName = getAppType();

        actionMethods.enterText(username, "Login.username_textbox");
        context.scenario.log("Username: " + username);
        actionMethods.enterText(password, "Login.password_textbox");
        context.scenario.log("Password: " + password);
        Thread.sleep(3000);
        actionMethods.click("Login.login_button");
        Thread.sleep(9000);
    }

    @And("^customer accesses the website as \"([^\"]*)\" user storetext$")
    public void customer_accesses_website_as_usertype_storetext(String userType)
        throws Throwable {
        if (userType.equalsIgnoreCase("userType")) {
            userType = getUserType();
            context.scenario.log("Test Executed for user: " + getUserType());
        }
        switch (userType.toLowerCase()) {
            case "guest":
                context.scenario.log("Welcome as Guest user");
                break;
            case "contract":
                actionMethods.navigateToPage("login");
                LoginStoretext();
                break;
            case "register":
                this.context.currentUserType = "register";
                register_user_storetext("register");
                break;
            case "register as synch":
                this.context.currentUserType = "register as synch";
                register_user_storetext("synch");
                break;
            default:
                throw new AssertionError("Given user is not found");
        }
    }

    @And("^Register user as \"([^\"]*)\" to the application$")
    public void register_user_storetext(String user) throws Throwable {
        String path = "";

        if (user.equalsIgnoreCase("register")) {
            if (appName.equalsIgnoreCase("mobile")) {
                path = FilePath + "MobileRegistration.xlsx";
            } else path = FilePath + "Registration.xlsx";
        } else if (user.contains("synch")) {
            path = FilePath + "SynchUserRegistration.xlsx";
        }

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String CurrentURL = actionMethods.getSiteBaseUrl();
        System.out.println("current URL = " + CurrentURL);
        System.out.println("move to URL = " + CurrentURL + "register");
        
        
        actionMethods.navigateToPage("register");
        
        
        if (appName.equalsIgnoreCase("mobile")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getMediumWaitSeconds(),
                "Login.login_element"
            );
            actionMethods.click("Register.registerNow_button");
        }
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Register.registerTitle_text"
        );
        Thread.sleep(6000);
        String accountType = testData.get(0).get("accountType");
        String username = actionMethods.generateRandomNumberString(
            testData.get(0).get("username")
        );
        this.context.currentUser = username;

        String password = this.context.constants.getPassword();
        String fullName = testData.get(0).get("fullName");
        String personTitle = testData.get(0).get("personTitle");
        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String emailAddress = testData.get(0).get("emailAddress");
        String phoneNumber = testData.get(0).get("phoneNumber");
        String phoneExtNumber = testData.get(0).get("phoneExtNumber");
        String postCode = testData.get(0).get("postCode");
        String country = testData.get(0).get("country");
        String companyName = testData.get(0).get("companyName");
        String vatRegistrationNumber = testData.get(0).get("vatRegistrationNumber");
        String salesTax = testData.get(0).get("salesTax");
        String primaryJob = testData.get(0).get("primaryJob");
        String primaryUse = testData.get(0).get("primaryUse");
        String accountNumber = testData.get(0).get("accountNumber");
        String mobileNumber = testData.get(0).get("mobileNumber");
        String contactYou = testData.get(0).get("contactYou");

        if (accountType.equalsIgnoreCase("skip") || fullName == null) {} else {
            actionMethods.click("Register.businessAccount_radio");
        }

        //actionMethods.enterText(username, "Register.username_textbox");
        //context.scenario.log("Username for new user: " + username);

        actionMethods.enterText(password, "Register.password_textbox");
        context.scenario.log("Password for new user: " + password);

        if (fullName == null || fullName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(fullName, "Register.fullName_textbox");
        }
        if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByIndex(1, "Register.title_dropdown");
        }
        if (firstName == null || firstName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(firstName, "Register.firstName_textbox");
        }
        if (lastName == null || lastName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(lastName, "Register.lastName_textbox");
        }
        if (emailAddress == null || emailAddress.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
        }
        if (phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");
        }
        if (phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");
        }
        if (postCode == null || postCode.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(postCode, "Register.postalCode_textbox");
        }
        if (country == null || country.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(country, "Register.country_dropdown");
        }
        if (companyName == null || companyName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(companyName, "Register.companyName_textbox");
        }
        if (
            vatRegistrationNumber == null ||
            vatRegistrationNumber.equalsIgnoreCase("skip")
        ) {} else {
            actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");
        }
        if (salesTax == null || salesTax.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(salesTax, "Register.salesTax_textbox");
        }
        if (primaryJob == null || primaryJob.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");
        }
        if (primaryUse == null || primaryUse.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");
        }
        if (accountNumber == null || accountNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");
        }
        if (mobileNumber == null || mobileNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
        }
        if (contactYou == null || contactYou.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(contactYou, "Register.contactYou_textbox");
        }

        if (appName.equalsIgnoreCase("web")) {
            if (getStore().equalsIgnoreCase("kr")) {
                actionMethods.click("Register.consent_checkbox");
            }
            // use below method only to skip captcha
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('Register').submit();");
        } else if (appName.equalsIgnoreCase("mobile")) {
            actionMethods.click("Register.register_button");
        }
    }
    
    @And("User create a URL and navigate to checkout page")
    public void generateCheckoutURL() {
    	String strCurrentURL = null;
    	String strCheckoutURL = null;
    	String strTempURL = null;
    	String[] strSplittedURL = null;
    	
    	strCurrentURL = driver.getCurrentUrl();
    	strTempURL = strCurrentURL.replace("AjaxOrderItemDisplayView?", "CheckoutFlow?default=true&");
    	strSplittedURL = strTempURL.split("krypto");
    	strCheckoutURL = strSplittedURL[0]+"BASE_URL=BasketPage&shipmentType=single&section=area2&action=show";
    	driver.navigate().to(strCheckoutURL);
    }
}
