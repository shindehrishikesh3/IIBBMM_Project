package Common.CONSTANTS;

import java.util.Arrays;

public class ConstantsEUROPE extends Constants {

    public ConstantsEUROPE() {
        // OrderCode which will Search for Instock PDP across all env/stores
        orderCode = "9338152";
        nullResultsMessage = "We couldn’t find any products matching";

        // Store specific variables
        switch (getStore().toLowerCase()) {
            case "uk":
                lhsCategories = Arrays.asList("uk1", "uk2");
                myAccountlistItems =
                    Arrays.asList(
                        "Order History & Tracking",
                        "Order Preferences",
                        "Quotes",
                        "BOM Upload",
                        "Saved Basket",
                        "Favourites",
                        "Account Summary",
                        "Profile Information",
                        "Apply for a Trade Account"
                    );

                break;
            case "cpc":
                orderCode = "CA07463";
                break;
            case "cpcireland":
                orderCode = "CA07463";
                break;    
            case "pt":
                validVATNumber = "1234567890123";
                break;
            case "es":
                validVATNumber = "1234567890123";
                break;
        }
        
        meganavTotalProducts = 12;
    }
}
