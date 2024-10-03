package Common.CONSTANTS;

import java.util.Arrays;

public class ConstantsAPAC extends Constants {

    public ConstantsAPAC() {
        // Region level variables
        nullResultsMessage = "Sorry, we couldn’t find any products matching";
        // OrderCode which will Search for Instock PDP across all env/stores
        orderCode = "1299885";

        // store level variables
        switch (getStore().toLowerCase()) {
            case "sg":
	    	orderDetailsHeaders = Arrays.asList("Line No.","Order Code","Manufacturer Part Number", "Manufacturer / Description","Avail.","Qty","Unit Price (excl GST)","Line Price (excl GST)");
                orderCode = "1651159";
                break;
            case "in":
                validVATNumber = "1234567890123";
                break;
            case "cn":
                searchLookaheadHeadingCount = 3;
                break;
        }
        
        meganavTotalProducts = 12;
        
        
    }
}
