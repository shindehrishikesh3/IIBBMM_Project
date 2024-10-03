package Translation.US_Countries;

import java.util.HashMap;

public class CANADA_Translation {

    // ############CANADA############

    public String canadaTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("Add to Favourites List", "Add to Favorites List");
        map.put("c/audio-visual/antennas/antenna-mounting-kits", "c/audio-video/antennas/antenna-mounting-kits");
        map.put("c/audio-visual/antennas/antennas-rfid", "c/audio-video/antennas/antennas-rfid");
        map.put("c/audio-visual/antennas/attenuators", "c/audio-video/antennas/attenuators");
        map.put("c/semiconductors-ics/more-integrated-circuits", "c/semiconductors-discretes/more-semiconductors-discretes");
        map.put("c/audio-visual", "c/audio-video");
        map.put("c/audio-visual/antennas", "c/security-audio-visual/aerials-aerials-management");
        map.put("If you have a registered account with us, you will receive the reset password link to your email.", "Si vous possédez un compte enregistré chez nous, vous recevrez par e-mail le lien de réinitialisation du mot de passe.");
        
        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_CANADA=" + value);

        return (value);
    }
}
