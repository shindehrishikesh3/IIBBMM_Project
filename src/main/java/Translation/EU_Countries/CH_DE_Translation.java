package Translation.EU_Countries;

import java.util.HashMap;

public class CH_DE_Translation {

    // ############SWITZERLAND############
    // Dedicated for switzerland-germany

    public String chDETranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        map.put("Checkout Now", "Jetzt zur Kasse gehen");
        map.put("My Account Summary", " Kontoübersicht");
        map.put("Order History & Tracking", "Bestellverlauf & -verfolgung");
        map.put("Manufacturer List", "Herstellerliste");
        map.put("Contact Us", "Kontakt");
        map.put("About Us", "Über uns");
        map.put("Apply for a Trade Account Today", "Geschäftskonto beantragen");
        map.put("Your Trade Account application has been received.", "Ihre Anmeldung für ein Geschäftskonto ist bei uns eingegangen.");
        map.put("Add to Favourites List", "Zur Favoritenliste hinzufügen");
        map.put("Your email has been sent.", "Ihre E-Mail wurde gesendet.");
        map.put("Add Address", "Adresse hinzufügen");
        map.put("your password", "Passwort vergessen");
        map.put("Email Sent", "Reset-E-Mail wurde gesendet");
        map.put("Forgotten your username?", "Haben Sie Ihren Benutzernamen vergessen?");
        map.put("help", "hilfezentrum");
        map.put("Manufacturer Part Number", "Hersteller-Teilenr.");
        map.put("Order Code", "Bestellnummer");
        map.put("Manufacturer / Description", "Hersteller / Beschreibung");
        map.put("Availability", "Verfügbarkeit");
        map.put("Quantity", "Menge");
        map.put("We couldn’t find any products matching", "Ihre Suchanfrage für");
        map.put("Search Tips", "Such-Tipps");
        map.put("Popular Product Categories", "Die beliebtesten Produktkategorien");
        map.put("Successfully saved", "Warenkorb wurde erfolgreich");
        map.put("Direct", "Direkt");
        map.put("Suggested", "Empfohlen");
        map.put("Re-Reel", "Re-Reel");
        map.put("Full Reel", "Ganze Rolle");
        map.put("Cut Tape", "Gurtabschnitte");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_switzerland_Germany=" + value);

        return (value);
    }
}
