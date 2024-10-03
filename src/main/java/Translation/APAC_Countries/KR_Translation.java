package Translation.APAC_Countries;

import java.util.HashMap;

public class KR_Translation {

    // ############Korea############

    public String krTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "In stock";
        } else {
            map.put("*Required fields", "*필수 필드");
            //map.put("Note: It is currently not possible to input Korean characters in this form. We apologize for the inconvenience.",
            //		"주의: 현재 이 양식에서는 한국어 문자 입력이 불가능합니다. 불편을 끼쳐 죄송합니다.");
            
            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_Korea=" + value);
        }

        return (value);
    }
}
