package Translation.EU_Countries;

import java.util.HashMap;

public class DE_Translation {

    // ############GERMANY############

    public String deTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        if (text.contains("We will get your quote to you as soon as possible.")) {
            value = "Ihre Angebotsanfrage ist bei uns eingegangen.";
            }else if (text.contains("Please enter a valid email address")) {
                value = "E-Mail-Adresse ein";
            }
        else {
        map.put("Checkout Now", "Jetzt zur Kasse gehen");
        map.put("My Account Summary", " Kontoübersicht");
        map.put("Order History & Tracking", "Bestellverlauf & -verfolgung");
        map.put("Manufacturer List", "Herstellerliste");
        map.put("Contact Us", "Kontakt");
        map.put("About Us", "Über uns");

        map.put("Add to Favourites List", "Zur Favoritenliste hinzufügen");
        map.put("Your email has been sent.", "Ihre E-Mail wurde gesendet.");
        map.put("Your changes have been saved.", "Ihre Änderungen wurden gespeichert.");
        map.put("Add Address", "Adresse hinzufügen");
        map.put("was successfully added.", "wurde erfolgreich hinzugefügt.");
        map.put("was successfully updated.", "wurde erfolgreich aktualisiert.");
        map.put("was successfully deleted.", "wurde erfolgreich gelöscht.");
        map.put("Order scheduled!", "Bestellung terminiert!");

        map.put("Thankyou for your Order", "Vielen Dank für Ihren Auftrag");
        map.put("Requested Delivery Date", "Wunschliefertermin");
        map.put("Thank You", "Vielen Dank");
        map.put(
            "Your new payment card details have been saved.",
            "Die Daten für die neue Kreditkarte wurden gespeichert."
        );
        map.put(
            "Your new order preferences have been saved.",
            "Die neuen Voreinstellungen für Bestellungen wurden gespeichert."
        );
        map.put("help", "hilfezentrum");
        map.put("Successfully saved", "Warenkorb wurde erfolgreich gespeichert");
        map.put("Welcome", "Willkommen");
        map.put("No Longer Manufactured", "Wird nicht mehr hergestellt.");
        map.put("Suggested Alternatives", "Vorgeschlagene Alternativen");
        map.put("Exact Alternative", "Genaue Alternative");
        map.put("Discount Price", "Rabattpreis:");
        map.put("Voucher Discount", "Gutscheinrabatt");
        map.put("your password", "Passwort vergessen");
        map.put("Reset email sent", "Reset-E-Mail wurde gesendet");
        map.put("Forgotten your username?", "Haben Sie Ihren Benutzernamen vergessen?");
        map.put("Username has been sent", "Benutzername wurde gesendet");
        map.put("Apply for a Trade Account Today", "Geschäftskonto beantragen");
        map.put(
            "Your Trade Account application has been received.",
            "Ihre Anmeldung für ein Geschäftskonto ist bei uns eingegangen."
        );
        map.put("Contact Sales for a quote", "Wenden Sie sich an den Verkauf, um ein Angebot anzufordern");
        map.put("Request quote", "Angebot anfordern");
        map.put("Thank you", "Vielen Dank");
        map.put("Yes sign me up for marketing emails, including exclusive special offers, new products and suppliers, event invitations and the latest content from the Premier Farnell Group.",
        		"Ja, ich möchte Marketing-E-Mails erhalten, einschließlich Informationen zu exklusiven Sonderangeboten, neuen Produkten und Lieferanten, Einladungen zu Veranstaltungen und die neuesten Inhalte der Premier Farnell-Gruppe");
        map.put("Terms of Access", "Terms of Access");
        map.put("See our privacy policy for more information", "Weitere Informationen finden Sie in unserer Datenschutzerklärung");
        map.put("Privacy", "Datenschutzhinweise");
        map.put("Sign up for marketing emails", "Melden Sie sich für den Erhalt von Marketing-E-Mails an");
        map.put("Sign up for marketing emails", "Melden Sie sich für den Erhalt von Marketing-E-Mails an");
        map.put("Email Sent", "E-Mail gesendet");
        map.put("If you have a registered account with us, you will receive the reset password link to your email.", "Wenn Sie ein registriertes Konto bei uns haben, wird Ihnen der Link zum Zurücksetzen des Passworts an Ihre E-Mail-Adresse geschickt.");
        map.put("Did not receive the email? Check the spelling of the email address and also your spam folder.", "Haben Sie die E-Mail nicht erhalten? Überprüfen Sie bitte, ob die E-Mail-Adresse richtig geschrieben ist und sehen Sie auch in Ihrem Spam-Ordner nach.");
        map.put("Try to register", "Versuchen Sie, sich zu registrieren");
        map.put("Direct", "Direkt");
        map.put("Suggested", "Empfohlen");
        map.put("Re-Reel", "Re-Reel");
        map.put("Full Reel", "Ganze Rolle");
        map.put("Cut Tape", "Gurtabschnitte  ");
        map.put("We couldn’t find any products matching", "Ihre Suchanfrage für");
        map.put("Search Tips", "Such-Tipps");
        map.put("Popular Product Categories", "Die beliebtesten Produktkategorien");
        map.put("Products Found","Produkte gefunden");
        map.put("0 Products Found", "0 Produkte gefunden");

        
        
        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_Germany=" + value);

      
    }
        return (value);	
}
}