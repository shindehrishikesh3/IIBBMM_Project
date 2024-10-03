package Repository_WEB_Objs;

import java.util.*;

public class ThreedAuthView_Objs {

    // Creation of HashMap
    private static final Map<String, String> ThreedAuthView;

    static {
        ThreedAuthView = new HashMap<String, String>();
        ThreedAuthView.put("cardframe_element", "//*[@name='cardframe']");
        ThreedAuthView.put("password_textbox", "//*[@id='password']");
        ThreedAuthView.put("submit_button", "//*[@name='UsernamePasswordEntry']");
    }

    public String findLocator(String elementName) {
        if (ThreedAuthView.containsKey(elementName)) {
            return (ThreedAuthView.get(elementName.trim()));
        }

        return null;
    }
}
