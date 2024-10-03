package Translation.APAC_Countries;

import java.util.HashMap;

public class TH_Translation {

    // ############Thailand############

    public String thTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "total stock globally";
        } else {
            map.put("No Longer Manufactured", "ไม่ได้ผลิตแล้ว");
            map.put("Suggested Alternatives", "ทางเลือกที่แนะนำ");
            map.put("Exact Alternative", "ผลิตภัณฑ์อื่นที่เหมือนกัน");
            map.put("If you want to ship to a country that is not listed, use our export website. ", "หากคุณต้องการจัดส่งไปยังประเทศที่ไม่อยู่ในรายการ ให้ใช้ เว็บไซต์ส่งออก ของเรา");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_Australia=" + value);
        }

        return (value);
    }
}
