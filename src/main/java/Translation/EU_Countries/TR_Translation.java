package Translation.EU_Countries;

import java.util.HashMap;

public class TR_Translation {

    // ############Turkey############

    public String trTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Satıştan kaldırıldı");
            map.put("Suggested Alternatives", "Önerilen Alternatifler");
            map.put("Exact Alternative", "Tam Alternatif");

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
