package Translation.EU_Countries;

import java.util.HashMap;

public class FI_Translation {

    // ############Austria############

    public String fiTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Ei valmisteta enää");
            map.put("Suggested Alternatives", "Ehdotetut vaihtoehdot");
            map.put("Exact Alternative", "Tarkka vaihtoehto");

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
