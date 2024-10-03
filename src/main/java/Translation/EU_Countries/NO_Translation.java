package Translation.EU_Countries;

import java.util.HashMap;

public class NO_Translation {

    // ############Norway############

    public String noTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Produseres ikke lenger");
            map.put("Suggested Alternatives", "Foreslåtte alternativer");
            map.put("Exact Alternative", "Eksakt alternativ");

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
