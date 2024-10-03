package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class PunchoutHeader_Objs {

    // Creation of HashMap
    private static final Map<String, String> PunchoutHeader;

    static {
        PunchoutHeader = new HashMap<String, String>();

        PunchoutHeader.put(
            "userFirstName_text",
            "//*[@id='loggedInPar' and @class!='displayNone']"
        );
        PunchoutHeader.put("companylogo_element", "//*[@id='storeLogosEu']");
    }

    public String findLocator(String elementName) {
        if (PunchoutHeader.containsKey(elementName)) {
            return (PunchoutHeader.get(elementName.trim()));
        }

        return null;
    }
}
