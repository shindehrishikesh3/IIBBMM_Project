package Translation.APAC_Countries;

import java.util.HashMap;

public class AU_Translation {

    // ############Australia############

    public String auTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "total stock globally";
        } else {
            map.put("£", "$");
            map.put("* Email", "* Email Address");
            map.put("Forgot your password", "Forgotten your password");
            map.put(
                "Farnell has sent an email with a link to reset your password to:",
                "Element14 has sent an email with a link to reset your password to:"
            );
            map.put(
                "Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.",
                "Did not receive the email? Please check that you have an Element14 account, the spelling of the email address and your spam folder."
            );
            map.put("Popular Product Categories", "Most popular product categories");
            map.put("Price (ex VAT)", "Price (Incl GST)");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_Australia=" + value);
        }

        return (value);
    }
}
