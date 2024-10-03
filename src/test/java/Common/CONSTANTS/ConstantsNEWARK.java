package Common.CONSTANTS;

import java.util.Arrays;
import java.util.List;

public class ConstantsNEWARK extends Constants {

    public ConstantsNEWARK() {
        // OrderCode which will Search for Instock PDP across all env/stores
        //orderCode = "50B5163";
        orderCode = "12T1459";
	orderDetailsHeaders = Arrays.asList("Line No.","Newark Part No.","Manufacturer Part Number", "Manufacturer / Description","Avail.","Qty","Unit Price","Line Price");
        nullResultsMessage = "No exact product matches found for";

        // Store specific variables
        switch (getStore().toLowerCase()) {
            case "us":
                break;
            case "canada":
                break;
            case "mexico":
                validVATNumber = "1234567890123";
                break;
        }
        
        meganavTotalProducts = 12;
    }

    @Override
    public List<String> getLhsCategories() {
        return lhsCategories;
    }
}
