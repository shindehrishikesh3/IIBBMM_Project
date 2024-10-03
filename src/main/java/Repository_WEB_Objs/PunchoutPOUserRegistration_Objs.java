package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class PunchoutPOUserRegistration_Objs {

    // Creation of HashMap
    private static final Map<String, String> PunchoutPOUserRegistration;

    static {
        PunchoutPOUserRegistration = new HashMap<String, String>();

	PunchoutPOUserRegistration.put("firstName_textbox", "//*[@id='firstName']");
	PunchoutPOUserRegistration.put("lastName_textbox", "//*[@id='lastName']");

        PunchoutPOUserRegistration.put("emailAddress_textbox", "//*[@id='emailAddress']");
        PunchoutPOUserRegistration.put("phoneNumber_textbox", "//*[@id='telephoneNumber']");
	PunchoutPOUserRegistration.put("register_button", "//input[@value='Register']");
	PunchoutPOUserRegistration.put("cancel_button", "//*[@id='regCancel']");
    }

    public String findLocator(String elementName) {
        if (PunchoutPOUserRegistration.containsKey(elementName)) {
            return (PunchoutPOUserRegistration.get(elementName.trim()));
        }

        return null;
    }
}
