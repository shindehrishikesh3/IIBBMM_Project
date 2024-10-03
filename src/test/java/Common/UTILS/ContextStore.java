package Common.UTILS;

import Common.CONSTANTS.Constants;
import io.cucumber.java.Scenario;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

public class ContextStore {

    public static String USER_NAME;
    public static String SYNCH_USER_NAME;
    public String currentUser;
    public String password;
    public Scenario scenario;
    public Constants constants;
    public static String ORDER_TRACKING_ORDER_CONFIRMATION_NUM;
    public static String ORDER_TRACKING_PO_NUM;
    public static String ORDER_TRACKING_EMAIL;
    public static String ORDER_TRACKING_ZIPCODE;
    public static String DEPLOYMENT_VERSION;
    public static boolean STUB_ENABLED = false;
    public String ORDER_CODE;
    public String PRE_FILTER_COUNT;
    public String POST_FILTER_COUNT;
    public String currentUserType = "guest";
    public String PRE_EVOUCHER_PRICE;
    public String POST_EVOUCHER_PRICE;
    public String POST_FILTERCLEAR_COUNT;
    public String POST_FILTER_COUNT_PDP;
    public String creditCardNum;
    public String tradeAccountNum;
    public static String iBuyCompanyName;
    public static String iBuyUserName;
    public String ProductCount;
    public String ProductCountInitial;
    public String ProductCountLater;
    public HashMap<String, List<String>> productDetails = new HashMap<String, List<String>>();
    public static String shippingCharge;
    public static String storeTextResultsPatStoreTextPath;
    public SoftAssertions softAssertions;
    public Map<String, String> urls = new HashMap<String, String>();
    public String userEmail;
    public String mailbox;
    public String CATEGORY_NAME;

    //API related
    public RestAssuredConfig config;
    public Response response;
    public String punchooutResponseURL;

    //iBuy
	public String newiBuyUser;
	public static String iBuySAUser;
	public static String iBuyTSAUser;
	public static String iBuyUser;

}
