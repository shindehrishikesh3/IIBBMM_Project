package Translation.EU_Countries;

import java.util.HashMap;

public class PL_Translation {

    // ############Belgium############

    public String plTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Wycofano z produkcji");
            map.put("Suggested Alternatives", "Sugerowane rozwiązania alternatywne");
            map.put("Exact Alternative", "Odpowiednik");

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
