package Repository_WEB_Objs;

import java.util.*;

public class Punchout_Objs {

    // Creation of HashMap
    private static final Map<String, String> Punchout;

    static {
        Punchout = new HashMap<String, String>();
        Punchout.put("option_prod_env", "//*[@id='env'][@value='env3']");
        Punchout.put("txt_password", "//*[@id='logonPassword']");
        Punchout.put("btn_submit", "//*[@value=' S U B M I T ']");

        // punchout custom iframe html
        Punchout.put("userFirstName_text", "//*[@id='loggedInPar']");
        Punchout.put("launch_link", "//*[@id='responseurl']");
    }

    public String findLocator(String elementName) {
        if (Punchout.containsKey(elementName)) {
            return (Punchout.get(elementName.trim()));
        }

        return null;
    }
}
