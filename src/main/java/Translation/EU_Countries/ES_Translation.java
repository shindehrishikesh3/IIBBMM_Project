package Translation.EU_Countries;

import java.util.HashMap;

public class ES_Translation {

    // ############Spain############

    public String esTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("No Longer Manufactured", "Fuera de producción");
            map.put("Suggested Alternatives", "Alternativas sugeridas");
            map.put("Exact Alternative", "Alternativas Exactas");
            map.put("Quick Add", "Añadir rápidamente");
            map.put("Products Found","productos encontrados");
            map.put("0 Products Found", "0 productos encontrados");

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
