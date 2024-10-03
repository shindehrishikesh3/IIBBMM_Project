package Translation.EU_Countries;

import java.util.HashMap;

public class CH_FR_Translation {

    // ############SWITZERLAND############
    // Dedicated for switzerland-France

    public String chFRTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "En stock";
        } else {
            map.put("View All Products", "Afficher tous les produits");
            map.put("Shopping Cart", "Panier");
            map.put("My Account", "Mon compte");
            map.put("Order History & Tracking", "Historique et suivi des commandes");
            map.put("Calculators & Charts", "Historique et suivi des commandes");
            map.put("View all manufacturers", "Voir tous les fabricants");
            map.put("Contact Us", "Contactez-nous");
            map.put("About Us", "À propos de nous");
            map.put("Apply for a Trade Account Today", "Faites une demande d'ouverture de compte client dès aujourd'hui");
            map.put("Your Trade Account application has been received.", "Nous accusons réception de votre demande d'ouverture de compte client.");
            map.put("Add to Favourites List", "Ajouter à la liste de favoris");
            map.put("Your email has been sent.", "Votre email a été envoyé.");  
            map.put("Direct", "Direct");
            map.put("Suggested", "Suggéré");
            map.put("Re-Reel", "Bobine");
            map.put("Full Reel", "Bobine complète");
            map.put("Cut Tape", "Bandes découpées");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_switzerland_France=" + value);
        }

        return (value);
    }
}
