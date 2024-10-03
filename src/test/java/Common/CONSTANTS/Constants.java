package Common.CONSTANTS;

import Common.UTILS.WebDriverConfig;
import java.util.Arrays;
import java.util.List;

public class Constants extends WebDriverConfig {

    protected String orderCode;
    protected String nullResultsMessage;
    protected List<String> lhsCategories;
    protected String password = "Farnell@1234";
    protected String newPassword = "Farnell@702";
    protected String threedAuthPassword = "1234";
    protected String orderRefString = "Ref";
    protected String emailDomain = "@testpft.com";
    protected String localEmailDomain = "@farnelltesting.com";
    protected int longWaitSeconds = 240;
    protected int mediumWaitSeconds = 60;
    protected int shortWaitSeconds = 30;
    protected String specialInstructions = "This is a Test Order";
    protected String companyName = "ABC Pvt Ltd";
    protected int searchLookaheadHeadingCount = 4;
    protected String inVoiceLocalName = "test";
    protected String validVATNumber;
    protected List<String> myAccountlistItems = Arrays.asList(
		"Order History & Tracking",
        "Order Preferences",
        "Quotes",
        "BOM Upload",
        "Saved Basket",
        "Favourites",
        "Account Summary",
        "Profile Information"
    );
    protected List<String> PLPsortlist = Arrays.asList(
        "SortBy",
        "OrderCode:ascending",
        "OrderCode:descending",
        "ManufacturerPartNo:ascending",
        "ManufacturerPartNo:descending",
        "Manufacturer/Description:ascending",
        "Manufacturer/Description:descending",
        "Availability:ascending",
        "Availability:descending",
        "Price:ascending",
        "Price:descending"
    );

    // Lists of stores based on features
    protected List<String> addressVerificationStores = Arrays.asList(
        "uk",
        "us",
        "au",
        "Canada",
        "fr",
        "nz"
    );
    protected List<String> stateDropdownStores = Arrays.asList("us", "mexico", "canada","ie");
    protected List<String> creditCardTileSection1DisabledStores = Arrays.asList(
        "de",
        "cn",
        "at",
        "ph"
    );

    protected List<String> orderDetailsHeaders = Arrays.asList("Line No.","Order Code","Manufacturer Part Number", "Manufacturer / Description","Avail.","Qty","Unit Price","Line Price");

    //Paypal Credentials
    protected String payPalUsername = "pshinde@test.com";
    protected String payPalPassword = "Test@1234";
    
    protected int meganavTotalProducts;

    public List<String> getStateDropdownStores() {
        return stateDropdownStores;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getThreedAuthPassword() {
        return threedAuthPassword;
    }

    public List<String> getAddressVerificationStores() {
        return addressVerificationStores;
    }

    public List<String> getLhsCategories() {
        return lhsCategories;
    }

    public String getOrderRefString() {
        return orderRefString;
    }

    public int getLongWaitSeconds() {
        return longWaitSeconds;
    }

    public int getShortWaitSeconds() {
        return shortWaitSeconds;
    }

    public int getMediumWaitSeconds() {
        return mediumWaitSeconds;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public List<String> getCreditCardTileSection1DisabledStores() {
        return creditCardTileSection1DisabledStores;
    }

    public int getSearchLookaheadHeadingCount() {
        return searchLookaheadHeadingCount;
    }

    public String getInVoiceLocalName() {
        return inVoiceLocalName;
    }

    public List<String> getMyAccountlistItems() {
        return myAccountlistItems;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPaypalUsername() {
        return payPalUsername;
    }

    public String getPaypalPassword() {
        return payPalPassword;
    }

    public String getNullResultsMessage() {
        return nullResultsMessage;
    }

    public List<String> getPLPSortListItems() {
        return PLPsortlist;
    }

    public String getEmailDomain() {
        return emailDomain;
    }
    
    public String getLocalEmailDomain() {
        return localEmailDomain;
    }

    public String getValidVATNumber() {
        return validVATNumber;
    }

    public List<String> getOrderDetailsHeaders() {
        return orderDetailsHeaders;
    }
    
    public int getMeganavTotalProducts() {
    	return meganavTotalProducts;
    }
}
