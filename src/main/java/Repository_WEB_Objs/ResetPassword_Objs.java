package Repository_WEB_Objs;

import java.util.*;

public class ResetPassword_Objs {

    // Creation of HashMap
    private static final Map<String, String> ResetPassword;

    static {
        ResetPassword = new HashMap<String, String>();

        ResetPassword.put("resetYourPassword_text", "//*[@id='enhance_resetHeadr']");
        ResetPassword.put("temporaryPassword_textbox", "//*[@id='logonPasswordOld']");
        ResetPassword.put("createNewPassword_textbox", "//*[@id='logonPassword']");
        ResetPassword.put(
            "resetPassword_textbox",
            "//*[@class='btn btnPrimary sentUsernameSubmit v2']"
        );
    }

    public String findLocator(String elementName) {
        if (ResetPassword.containsKey(elementName)) {
            return (ResetPassword.get(elementName.trim()));
        }

        return null;
    }
}
