package StepDefinition.GENERIC;

import static Common.CONSTANTS.GlobalConstants.CATALOG_ID_CONST;
import static Common.CONSTANTS.GlobalConstants.PROP_KEY_PREFIX;
import static Common.CONSTANTS.GlobalConstants.SITE_CONFIDENCE_NAME;
import static Common.CONSTANTS.GlobalConstants.STORE_ID_CONST;
import static Common.CONSTANTS.GlobalConstants.ZERO_CONST;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import Pages.MOBILE.LoginRegistrationPage;
import Pages.WEB.RegistrationPage;

import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSteps extends WebDriverConfig {

	private WebDriver driver = null;
	private ContextStore context;
	private String companyID;
	private RegistrationPage webRegistration;
	private LoginRegistrationPage mobLoginRegistration;

	String env;
	String region;
	String parametricUrl = "";
	String FilePath = System.getProperty("user.dir") +
			"//src//test//resources//TestData//" +
			getEnv().toUpperCase() +
			"//";

	private static final Logger logger = LogManager.getLogger(BaseSteps.class);

	public BaseSteps(ContextStore context, RegistrationPage webReg, LoginRegistrationPage mobLoginReg) {
		this.context = context;
		this.webRegistration = webReg;
		this.mobLoginRegistration = mobLoginReg;
	}

	public String storeWSCVerson(String baseURL) throws Exception {
		String ecommerceDeployedVersionValue = "";

		// System properties for constants.
		Properties props = System.getProperties();

		final String siteConfidenceUrlText = "/webapp/wcs/stores/servlet/SiteConfidenceCmd?storeId=0&catalogId=0";
		String siteConfidenceURL = null;

		// Get siteconfidence html content
		String siteConfidenceHtmlContent = "";
		if (baseURL != null) {
			siteConfidenceURL = baseURL.concat(siteConfidenceUrlText);
			// siteConfidenceHtmlContent =
			// getsiteConfidenceHtmlContent(siteConfidenceURL);

			driver.get(siteConfidenceURL);
			Thread.sleep(3000);
			siteConfidenceHtmlContent = driver.getPageSource();
			// driver.close(); // This causes SeleniumWatchdog to echo
			// Destroying forcefully (v2). FF >v30 bug
		}

		if (!siteConfidenceHtmlContent.isEmpty()) {
			final Pattern pattern = Pattern.compile(
					"[0-9]{1,}\\.[0-9]{1,}\\.[0-9]{2,}\\.[0-9]{1,}\\.?[0-9]{0,}\\.?[0-9]{0,}");

			Matcher matcher = pattern.matcher(siteConfidenceHtmlContent);

			if (matcher.find()) {
				String ecommerceDeployedVersionKey = "ecommerceDeployedVersion";
				ecommerceDeployedVersionValue = matcher.group().toString().trim();
				// Store WSC version in session
				props.setProperty(
						ecommerceDeployedVersionKey,
						ecommerceDeployedVersionValue);
			} else {
				// throw new GeneralFrameworkException(
				Assert.fail("Match for deployed version is not found");
			}
		} else {
			// throw new GeneralFrameworkException(
			Assert.fail("Can not retrieve Ecommerce build version information");
		}

		return ecommerceDeployedVersionValue;
	}

	/**
	 * Verify the deployed version
	 */
	@Given("user is validating the correct deployed build version of the site$")
	public void storeWSCVersonInProperties() throws Throwable {
		if (ContextStore.DEPLOYMENT_VERSION == null) {
			ContextStore.DEPLOYMENT_VERSION = storeWSCVerson(getSiteBaseUrl());
			logger.info("WSC Version captured from site confidence");
		}
		// No longer needed as GetFeedback Homepage pop-up is disabled now
		// else {
		// getDriver().get(getSiteBaseUrl()+SITE_CONFIDENCE_URL);
		// }
		// actionMethods.setLocalStorageToSkipFeedbackForms();
	}

	@And("^user navigate to \"([^\"]*)\" store homepage and \"([^\"]*)\" accept the cookies$")
	public void navigate_to_site_with_user(String store, String isCookieAccepted)
			throws Throwable {
		setEnv();
		// load properties files
		configUtil.loadProperty();
		// Get the base url from properties file
		String baseUrl = envConfig.getProperty(store);
		// Set the system variable with url value
		System.setProperty("siteUrl", baseUrl);
		driver = getDriver();
		storeWSCVersonInProperties();

		// Setup the browser for execution
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(getWidth(), getHeight()));
		// driver.manage().deleteAllCookies();

		// Launch the url & handle cookie banner if any
		driver.get(baseUrl);
		if (!isCookieAccepted.contains("not")) {
			this.acceptCookie();
		}
		Thread.sleep(2000);

		// Add a cookie to avoid geo location pop-up
		driver.manage().addCookie(new Cookie("pf_siteRedirectOffered", "yes"));

		// Set the dynamic constants object based on region
		this.context.constants = getConstantTypeObject();

		printExecutionDetailsInReport();

		// Wait until homepage is loaded
		actionMethods.waitForElementToAppear(
				this.context.constants.getLongWaitSeconds(),
				"Header.companylogo_element");
	}

	/**
	 * Common Step to Open the site with device
	 *
	 * @param isCookieAccepted
	 *                         For your project to define page type url / init page
	 *                         object
	 * @throws Throwable
	 */

	@Given("^web site is launched successfully and user \"([^\"]*)\" accept the cookies$")
	public void the_web_site_is_opened(String isCookieAccepted) throws Throwable {
		driver = getDriver();
		storeWSCVersonInProperties();
		// Setup the browser for execution
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(getWidth(), getHeight()));
		// driver.manage().deleteAllCookies();

		driver.get(getSiteBaseUrl());

		if (!isCookieAccepted.contains("not")) {
			this.acceptCookie();
		}
		Thread.sleep(2000);

		// Add a cookie to avoid geo location pop-up
		driver.manage().addCookie(new Cookie("pf_siteRedirectOffered", "yes"));

		// Add a cookie to avoid Feedback pop-up in checkout page
		driver
				.manage()
				.addCookie(new Cookie("UZ_TI_S_2C0082D28598EC11AA778B512CC5224C", "yes"));

		// Add a cookie to avoid Feedback pop-up in checkout page in US PP
		driver
				.manage()
				.addCookie(new Cookie("UZ_TI_S_DF0C70785DEDEC11AA7B899E75EAE93B", "yes"));

		// load properties files
		configUtil.loadProperty();
		// Set the dynamic constants object based on region
		this.context.constants = getConstantTypeObject();

		printExecutionDetailsInReport();

		// Wait until homepage is loaded
		actionMethods.waitForElementToAppear(
				this.context.constants.getLongWaitSeconds(),
				"Header.companylogo_element");
	}

	/**
	 * Common Step to Open the site with device
	 *
	 * @param isCookieAccepted
	 *                         For your project to define page type url / init page
	 *                         object
	 * @throws Throwable
	 */

	@Given("^\"([^\"]*)\" page is launched and user \"([^\"]*)\" accept the cookies$")
	public void the_web_site_is_opened(String pageName, String isCookieAccepted)
			throws Throwable {
		driver = getDriver();
		storeWSCVersonInProperties();
		// Setup the browser for execution
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(getWidth(), getHeight()));
		// driver.manage().deleteAllCookies();

		ReadContext rx = JsonUtil.getJsonDocument(FilePath + "pageUrls.json");
		String path = JsonUtil.getStringKeyValueFromStoreSpecificJson(rx, getStore(), pageName);
		if (path == null) {
			path = JsonUtil.getStringKeyValueFromStoreSpecificJson(rx, getRegionName(), pageName);
		}
		driver.get(getSiteBaseUrl() + path);

		if (!isCookieAccepted.contains("not")) {
			this.acceptCookie();
		}
		Thread.sleep(2000);

		// load properties files
		configUtil.loadProperty();
		// Set the dynamic constants object based on region
		this.context.constants = getConstantTypeObject();

		printExecutionDetailsInReport();

		// Wait until webiste is loaded
		actionMethods.waitForElementToAppear(
				this.context.constants.getLongWaitSeconds(),
				"Header.companylogo_element");
	}

	public void printExecutionDetailsInReport() {
		context.scenario.log("WSC version: " + ContextStore.DEPLOYMENT_VERSION);
		context.scenario.log("Test URL: " + getSiteBaseUrl());
		context.scenario.log("Environment : " + getEnv());
		context.scenario.log("Region: " + getRegionName());
		context.scenario.log("Store: " + getStore());
		context.scenario.log("Browser: " + getBrowserType());
		context.scenario.log("Application: " + getAppType());
	}

	@And("^customer accesses the website as \"([^\"]*)\" user$")
	public void customer_accesses_website_as_usertype(String userType) throws Exception {
		if (userType.equalsIgnoreCase("userType")) {
			userType = getUserType();
			context.scenario.log("Test Executed for user: " + getUserType());
		}
		switch (userType.toLowerCase()) {
			case "guest":
				guest_user();
				break;
			case "contract":
				this.context.currentUserType = "contract";
				login_user("contract");
				break;
			case "ibuy":
				this.context.currentUserType = "ibuy";
				login_user("ibuy");
				break;
			case "ibuy pfsa admin":
				this.context.currentUserType = "ibuy pfsa admin";
				login_user("ibuy_pfsa_admin");
				break;
			case "login":
				this.context.currentUserType = "login";
				login_user("regular");
				break;
			case "punchout":
				this.context.currentUserType = "punchout";
				punchout_user();
				break;
			case "register":
				this.context.currentUserType = "register";
				register_user("register");
				break;
			case "register as synch":
				this.context.currentUserType = "register as synch";
				register_user("synch");
				break;
			case "orders_login":
				this.context.currentUserType = "orders_login";
				login_user("orders_login");
				break;
			case "orders_ibuy":
				this.context.currentUserType = "orders_ibuy";
				login_user("orders_ibuy");
				break;
			default:
				throw new AssertionError("Given user is not found");
		}
	}

	public void guest_user() throws Exception {
		logger.info("Welcome as Guest user");
	}

	/**
	 * Method to click login link, enter credentials and verify user is logged in
	 * using firstname in header
	 *
	 * @param loginUserType
	 * @throws Exception
	 */
	public void login_user(String loginUserType) throws Exception {
		context.scenario.log("Verify user is login with valid credentials");
		actionMethods.click("Header.login_link");
		actionMethods.waitForElementToAppear(
				this.context.constants.getMediumWaitSeconds(),
				"Login.login_element");
		submit_login_user_credentials(loginUserType);
		userIsLoggedIn();
	}

	@And("login as \"([^\"]*)\" user$")
	public void submit_login_user_credentials(String loginUserType) throws Exception {
		String username = "";
		String password = "";
		String store = getStore();
		String region = getRegionName();
		String appName = getAppType();
		switch (loginUserType.toLowerCase()) {
			case "regular":
				username = loginConfig.getProperty(store + "_username");
				password = loginConfig.getProperty(store + "_password");
				break;
			case "ibuy":
				username = ibuyConfig.getProperty(store + "_username");
				password = ibuyConfig.getProperty(store + "_password");
				break;
			case "ibuy_pfsa_admin":
				username = ibuyPfsaAdminConfig.getProperty(region + "_username");
				password = ibuyPfsaAdminConfig.getProperty(region + "_password");
				break;
			case "contract":
				username = contractConfig.getProperty(store + "_username");
				password = contractConfig.getProperty(store + "_password");
				break;
			case "orders_login":
				username = ordersConfig.getProperty(store + "_username");
				password = ordersConfig.getProperty(store + "_password");
				break;
			case "orders_ibuy":
				username = ordersibuyConfig.getProperty(store + "_username");
				password = ordersibuyConfig.getProperty(store + "_password");
				break;
			default:
				throw new AssertionError("Given user is not found");
		}

		if (appName.equalsIgnoreCase("mobile")) {
			driver.navigate().refresh();
			Thread.sleep(5000);
		}
		Thread.sleep(5000);
		actionMethods.enterText(username, "Login.username_textbox");
		context.scenario.log("Username: " + username);
		actionMethods.enterText(password, "Login.password_textbox");
		context.scenario.log("Password: " + password);
		Thread.sleep(3000);
		// actionMethods.click("Login.login_button");

		if (isHeadleassPage) {
			actionMethods.click("Login.login_button");

		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('Logon').submit();");
		}
		Thread.sleep(9000);
	}

	public void punchout_user() throws Exception {
		String appName = getAppType();
		String store = getStore();

		if (appName.equalsIgnoreCase("mobile")) {
			context.scenario.log("Punchout is not applicable for mobile view");
		} else {
			if (store.equalsIgnoreCase("us")) {
				driver
						.navigate()
						.to(
								"http://www.admin.ftprdus.element14.com:8080/EprocTester/punchBuster.jsp");
				companyID = "7000000000000189472";
			}
			if (store.equalsIgnoreCase("uk")) {
				driver
						.navigate()
						.to(
								"http://www.admin.ftprdeu.element14.com:8080/EprocTester/punchBuster.jsp");
				companyID = "170000636502";
			}

			if (store.equalsIgnoreCase("au")) {
				driver
						.navigate()
						.to(
								"http://www.admin.ftprdap.element14.com:8080/EprocTester/punchBuster.jsp");
				companyID = "370000278001";
			}

			context.scenario.log("User selects Production environment.");
			actionMethods.click("Punchout.env_option_prod");

			context.scenario.log("User clicks on Submit button.");
			actionMethods.click("Punchout.submit_button");

			context.scenario.log("User selects the company by Id:" + companyID);
			selectCompanyById(companyID);

			context.scenario.log(
					"User clicks on Submit button to login as punchout user");
			actionMethods.click("Punchout.submit_button");
		}
	}

	public void selectCompanyById(String companyId) {
		List<WebElement> companyList = getDriver().findElements(By.tagName("option"));
		for (WebElement option : companyList) {
			if (option.getText().contains(companyId)) {
				String companyInfo = option.getAttribute("value");
				driver
						.findElement(By.xpath("//option[@value='" + companyInfo + "']"))
						.click();
			}
		}
	}

	public void register_user(String user) throws Exception {

		submit_registration_form(user);

		// activation link feature validations
		String emailProperty = WebDriverConfig.xcomregConfig.getProperty("PF_ACCOUNT_ACTIVATE_BY_EMAIL_Y");
		if (emailProperty != null && !emailProperty.isEmpty() && Arrays.asList(emailProperty.split(",")).contains(driverConfig.getStore())) {
			actionMethods.waitForByElementToAppear(this.context.constants.getMediumWaitSeconds(), "Register.thankYouTitle_text");
			Boolean value = uiMethods.isElementDisplayed("Register.thankYouTitle_text");
			Assert.assertTrue(value);
			click_on_email_verification_link();
		}

		// Verify user logged in successfully
		userIsLoggedIn();
	}

	@Given(".*accept all cookies if asked$")
	public void acceptCookie() throws Exception {
		String region = getRegionName();
		if (region.equalsIgnoreCase("europe")) {
			if (uiMethods.isElementDisplayed("CookieSetting.oneTrustCookie_button"))
				actionMethods.click("CookieSetting.oneTrustCookie_button");
		} else {
			logger.info("Cookie banner is not applicable");
		}
	}

	@Given("^Verify user is logged in on Home page successfully$")
	public void userIsLoggedIn() throws Exception {
		actionMethods.waitForElementToAppear(
				this.context.constants.getLongWaitSeconds(),
				"Header.userFirstName_text");
		String value = actionMethods.getValue("Header.userFirstName_text");
		context.scenario.log("User is logged in to its account:" + value);
		Assert.assertTrue(!value.equalsIgnoreCase(""));
	}

	@And("^.*save the newly registered \"([^\"]*)\" user details$")
	public void save_current_user(String userType) {
		if (userType.contains("sync")) {
			ContextStore.SYNCH_USER_NAME = context.currentUser;
		} else {
			ContextStore.USER_NAME = context.currentUser;
		}
	}

	@And("^.*assume environment stub is disabled in PP environment$")
	public void assume_PP_env_stub_disabled() {
		if (getEnv().equalsIgnoreCase("pp") && ContextStore.STUB_ENABLED) {
			Assume.assumeTrue("Environment is stubbed", false);
		}
	}

	@And("^.* enter ordercode .* in \"([^\"]*)\"$")
	public void enterOrdercode(String locator) throws Exception {
		String expectedOrderCode = this.context.constants.getOrderCode();
		actionMethods.enterText(expectedOrderCode, locator);
	}

	@Given(".*^\"([^\"]*)\" environment is setup$")
	public void prepare_environment(String store) throws Throwable {
		setEnv();
		// load properties files
		configUtil.loadProperty();
		// prepare environment
		setBaseURI(store);
		initEnvironment();

		// Set the dynamic constants object based on region
		this.context.constants = getConstantTypeObject();

		apiBaseMethods.setRestAssuredProxy();

		// rest assured global config
		this.context.config = RestAssuredConfig
				.config()
				.encoderConfig(
						EncoderConfig
								.encoderConfig()
								.appendDefaultContentCharsetToContentTypeIfUndefined(false));
		getDeploymentVersion();
		printExecutionDetailsInReport();
	}

	public void getDeploymentVersion() {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put(STORE_ID_CONST, ZERO_CONST);
		queryParams.put(CATALOG_ID_CONST, ZERO_CONST);

		String resourcePath = applicationConfig.getProperty(
				PROP_KEY_PREFIX.concat(SITE_CONFIDENCE_NAME));
		Response res = apiBaseMethods.getRequest(
				this.context.config,
				null,
				queryParams,
				resourcePath);
		if (res.statusCode() == 200) {
			Document doc = Jsoup.parse(res.body().asString());
			Elements elements = doc.getElementsByTag("p");
			for (Element e : elements) {
				if (e.html().contains("Deployed Version")) {
					ContextStore.DEPLOYMENT_VERSION = e.html().split(":")[1];
					break;
				}
			}
		} else {
			Assert.fail("Something went wrong, Website might be down");
		}
	}

	// BOM
	@And("^.*register new \"([^\"]*)\" user when last registered user details are unavailable$")
	public void register_new_user_if_registered_user_deatils_absent(String userType) throws Exception {
		String username = ContextStore.USER_NAME;
		String password = this.context.constants.getPassword();
		if (username == null) {
			register_user("register");
		} else {
			actionMethods.click("Header.login_link");
			Thread.sleep(1000);
			actionMethods.waitForElementToAppear(
					this.context.constants.getShortWaitSeconds(),
					"Login.username_textbox");
			actionMethods.enterText(username, "Login.username_textbox");
			context.scenario.log("Username: " + username);
			actionMethods.enterText(password, "Login.password_textbox");
			context.scenario.log("Password:" + password);
			Thread.sleep(1000);
			actionMethods.click("Login.login_button");
			Thread.sleep(2000);
		}
		userIsLoggedIn();
	}

	@And("^user clicks on the email verification link$")
	public void click_on_email_verification_link() throws Exception {

		String baseURI = applicationConfig.getProperty("pf.rest.api.ahem.localmailserver");
		String mailbox = this.context.mailbox;

		// POST Request - To get Access Token
		String accessToken = localServerMethods.getAccessToken(baseURI);
		
		// GET Request - To fetch Email ID
		String emailID = localServerMethods.getEmailId(baseURI, accessToken, mailbox);

		// GET Request - To fetch Email content body
		String body = localServerMethods.getEmailBody(baseURI, accessToken, mailbox, emailID);

		// Parsing JSON body to fetch all the links
		Document doc = Jsoup.parse(body);
		Elements links = doc.select("a[href]");

		List<String> hrefs = new ArrayList<>();
		for (Element link : links) {
			hrefs.add(link.attr("href"));
		}

		String activationLink = null;
		for (String href : hrefs) {
			if (href.contains("UserRegistrationEmailActivate")) {
				activationLink = href;
				this.context.scenario.log("Activation link: " + activationLink);
				break;
			}
		}
		if (activationLink != null) {
			driver.get(activationLink);
			this.context.scenario.log("Activation link is clicked");
		} else {
			this.context.scenario.log("No activation link is present on the page");
		}
	}

	@And("user submits registration form as {string} user")
	public void submit_registration_form(String user) throws Exception {
		String path = "";

		switch (appName.toLowerCase()) {
			case "web":
				// select correct file for corresponding user
				String filename = user.equalsIgnoreCase("synch") ? "SynchUserRegistration.xlsx" : "Registration.xlsx";
				path = FilePath + filename;

				// Navigate to register page
				actionMethods.click("Register.register_link");
				actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(),"Register.registerTitle_text");

				// Populate form
				webRegistration.populate_form(user, path);
				break;

			case "mobile":
				path = FilePath + "MobileRegistration.xlsx";

				//Navigate to register page on mobile
				actionMethods.click("Register.register_link");
				actionMethods.waitForElementToAppear(this.context.constants.getMediumWaitSeconds(),"Login.login_element");
				actionMethods.click("Login.loginTitle_text");
				actionMethods.click("Login.registerNow_button");
				actionMethods.waitForElementToAppear(this.context.constants.getLongWaitSeconds(),"Register.registerTitle_text");

				// populate register form
				mobLoginRegistration.populate_form(user, path);
				break;

			default:
				Assert.fail("Appname is incorrectly set");
				break;
		}

	}
	
	   @And(
		        "^.*fill details in create account section on Order Confirmation form using given file \"([^\"]*)\"$"
		    )
		    public void create_account_for_guest(String FileName) throws Exception {
		        String path = FilePath + FileName;

		        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

		        actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
		        context.scenario.log("primaryRole dropdown value index 3");
		        actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
		        context.scenario.log("primary use dropdown value index 3");

		        String username = actionMethods.generateRandomNumberString(
		            testData.get(0).get("username")
		        );
		        this.context.currentUser = username;
		        String password = this.context.constants.getPassword();
		        String phoneNumber = testData.get(0).get("phoneNumber");

		        actionMethods.enterText(phoneNumber, "Checkout.phoneNumber_textbox");
		        context.scenario.log("phoneNumber for new user: " + phoneNumber);

		        actionMethods.enterText(password, "Checkout.password_textbox");
		        context.scenario.log("Password for new user: " + password);
		        actionMethods.click("Checkout.createAccount_button");
		        Thread.sleep(6000);
		        click_on_email_verification_link();
		    }

}
