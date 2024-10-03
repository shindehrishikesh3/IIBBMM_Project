package Repository_WEB_Objs;

import java.util.*;

public class OrderReview_Objs {

    // Creation of HashMap
    private static final Map<String, String> OrderReview;

    static {
        OrderReview = new HashMap<String, String>();
        OrderReview.put("", "");
    }

    public String findLocator(String elementName) {
        if (OrderReview.containsKey(elementName)) {
            return (OrderReview.get(elementName.trim()));
        }

        return null;
    }
}
