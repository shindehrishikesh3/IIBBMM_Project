package Translation.EU_Countries;

import java.util.HashMap;

public class EE_Translation {

    // ############Estonia############

    public String eeTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Ei toodeta enam");
            map.put("Suggested Alternatives", "Pakutud alternatiivid");
            map.put("Exact Alternative", "Täpne alternatiiv");

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
