package Translation.EU_Countries;

import java.util.HashMap;

public class CZ_Translation {

    // ############Czech Republic############

    public String czTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Již se nevyrábí");
            map.put("Suggested Alternatives", "Doporučené alternativní produkty");
            map.put("Exact Alternative", "Přesná alternativa");
            map.put("Email Sent", "E-mail odeslán");
            map.put("If you have a registered account with us, you will receive the reset password link to your email.", "Pokud máte u nás registrovaný účet, obdržíte odkaz na obnovení hesla na svůj e-mail.");
            map.put("Did not receive the email? Check the spelling of the email address and also your spam folder.", "Nedostali jste e-mail? Zkontrolujte pravopis e-mailové adresy a také složku spamu.");
            map.put("Try to register", "Zkuste se zaregistrovat");
            

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_France=" + value);
        }

        return (value);
    }
}
