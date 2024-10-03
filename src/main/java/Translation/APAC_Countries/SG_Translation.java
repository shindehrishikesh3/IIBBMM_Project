package Translation.APAC_Countries;

import java.util.HashMap;

public class SG_Translation {

    // ############SINGAPORE############

    public String sgTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "In stock";
        } else {
            map.put("£", "S$");
            map.put("8-20 Characters", "8 Characters");
            map.put("Include a lower case letter (a-z)", "One lowercase letter (a-z)");
            map.put("Include a uppercase character (A-Z)", "One uppercase letter (A-Z)");
            map.put("Include a number (0-9)", "One number (0-9)");
            map.put(
                "Include a special character (!&#@,..)",
                "One special character (!@#&...)"
            );
            map.put(
                "Register now and enjoy features",
                "Register now and enjoy features such as faster checkouts, saved shopping baskets for repeat or planned orders, order tracking and order history."
            );
            map.put("Popular Product Categories", "Most popular product categories");
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

            map.put("Price (ex VAT)", "Price (Incl GST)");
            map.put("Popular Product Categories", "Most popular product categories");
            map.put("Price (ex VAT)", "Price (Incl GST)");
            map.put("Unit Price", "Unit Price (excl GST)");
            map.put("Line Price","Line Price (excl GST)");
            map.put("All Items Total", "All Items Total (excl GST)");
            map.put("VAT","GST");
            map.put("Price", "Price (Incl GST)");
            map.put("Price:ascending", "Price(InclGST):ascending");
            map.put("Price:descending", "Price(InclGST):descending");
            map.put("*Email", "*Email Address");
            map.put("What is the primary use for the products you purchase from FARNELL?", "What is the primary use for the products you purchase from ELEMENT14?");
            map.put("Mobile Number", "Mobile Phone Number");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_Singapore=" + value);
        }

        return (value);
    }
}
