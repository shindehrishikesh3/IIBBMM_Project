package Translation.US_Countries;

import java.util.HashMap;

public class US_Translation {

    // ############US############

    public String usTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("Order Code", "Newark Part No.");
        map.put("Credit / Debit Card", "Credit/Debit Card");
        map.put("Trade Account", "Newark Account");
        map.put("Price For (ex VAT)", "Price For");
        map.put("Forgotten your username?", "Forgot username?");
        map.put("Requested Delivery Date", "Requested Ship Date");
        map.put("Add to Favourites List", "Add to Favorites List");
        //map.put("8-20 Characters", "8 Characters");
        map.put("Include a lower case letter (a-z)", "One lowercase letter (a-z)");
        map.put("Include a uppercase character (A-Z)", "One uppercase letter (A-Z)");
        map.put("Include a number (0-9)", "One number (0-9)");
        map.put(
            "Include a special character (!&#@,..)",
            "One special character (!@#&...)"
        );
        map.put("Your information", "What we do with the information you provide");
        map.put(
            "We need this information from you to provide you with the products and services you order and to manage your account.",
            "We need this information to understand your needs and provide you with a better service."
        );
        map.put("Popular Product Categories", "Most popular product categories");
        map.put(
            "This item has been added to your basket",
            "This item has been added to your cart"
        );
        map.put("Forgotten your password?", "Forgot password?");
        map.put("* Email", "* Email Address");
        map.put(
            "Farnell has sent an email with a link to reset your password to:",
            "Newark has sent an email with a link to reset your password to:"
        );
        map.put(
            "Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.",
            "Did not receive the email? Please check that you have a Newark account, the spelling of the email address and your spam folder."
        );

        map.put("Order Code", "Newark Part No.");
        map.put("Price For", "Price for");
        map.put("Price (ex VAT)", "Price");
        map.put("Favourites", "Favorites");
        map.put("Suggested Alternatives", "Suggested Substitutes");
        map.put("c/audio-visual/antennas/antenna-mounting-kits", "c/audio-video/antennas/antenna-mounting-kits");
        map.put("c/audio-visual/antennas/antennas-rfid", "c/audio-video/antennas/antennas-rfid");
        map.put("c/audio-visual/antennas/attenuators", "c/audio-video/antennas/attenuators");
        map.put("c/semiconductors-ics/more-integrated-circuits", "c/semiconductors-discretes/more-semiconductors-discretes");
        map.put("c/audio-visual", "c/audio-video");
        map.put("c/audio-visual/antennas", "c/security-audio-visual/aerials-aerials-management");
        map.put("Order Code", "Newark Part No.");
        map.put("Price For", "Price for");
        map.put("Price (ex VAT)", "Price");
        map.put("Do you have a Trade Account?", "Do you have an account?");
        map.put("I would like to open a new trade account", "I would like to open a new account");
        map.put("* A Trade Account allows business customers to pay for goods on trade terms.", "An account allows a customer to purchase merchandise and be billed upon delivery");
        map.put("You may enter a PO number for your reference. This field is optional.", "You may overwrite the system generated PO number. The PO release field is optional.");
        map.put("*Payment Method", "*Billing Method");
        map.put("Trade Account", "Newark Account");
        map.put("Invoice Address", "Billing Address");
        map.put("Add Invoice Address", "Add Billing Address");
        map.put("Set this as my preferred invoice address for future orders", "Set this as my preferred billing address for future orders");
        map.put("Delivery Address", "Shipping Address(es)");
        map.put("My delivery address is the same as my invoice address", "My shipping address is the same as my billing address");
        map.put("Add Delivery Address", "Add Shipping Address");
        map.put("Special Instructions", "Add Order Notes");
        map.put("Add any special instructions for the carrier (maximum 30 characters).", "Add notes for your internal records (maximum 30 characters).");
        map.put("Delivery", "Shipping");
        map.put("VAT", "Tax");
        map.put("Delivery Selection & Order Options", "Shipping Selection & Order Options");
        map.put("Set this as my preferred delivery address for future orders", "Set this as my preferred shipping address for future orders");
        map.put("Delivery Method", "Shipping Method");
        map.put("Delivery Instructions", "Add Order Notes");
        map.put("Characters left: 20", "Characters left: 50");
        map.put("terms and conditions", "terms & conditions");
        map.put("I accept the terms & conditions . By completing transaction, you agree you are separately contracting for the purchase of goods & for the delivery thereof.",
        		"I accept the terms & conditions. By completing transaction, you agree you are separately contracting for the purchase of goods & for the delivery thereof.");
        map.put("Delivery Method:", "Shipping Method:");
        map.put("Delivery Date", "Ship Date");
        map.put("Edit Basket", "Edit Cart");
        map.put("c/audio-visual/antennas", "c/audio-video/antennas");
        map.put("Your basket will be returned to your purchasing system.","Your cart will be returned to your purchasing system.");
        map.put("OrderCode:ascending","NewarkPartNo.:ascending");
        map.put("OrderCode:descending","NewarkPartNo.:descending");
        map.put("*Email","*Email Address");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_US=" + value);

        return (value);
    }
}
