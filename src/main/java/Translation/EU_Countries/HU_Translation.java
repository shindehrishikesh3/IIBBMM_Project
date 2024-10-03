package Translation.EU_Countries;

import java.util.HashMap;

public class HU_Translation {

    // ############Austria############

    public String huTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Továbbiakban nem gyártják");
            map.put("Suggested Alternatives", "Ajánlott helyettesítők");
            map.put("Exact Alternative", "Megegyező alternatíva");

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
