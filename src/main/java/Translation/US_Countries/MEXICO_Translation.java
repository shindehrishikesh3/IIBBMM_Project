package Translation.US_Countries;

import java.util.HashMap;

public class MEXICO_Translation {

    // ############MEXICO############

    public String mexicoTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("Email Sent", "Correo electrónico enviado");
        map.put("If you have a registered account with us, you will receive the reset password link to your email.", "Si tiene una cuenta registrada con nosotros, recibirá en su correo electrónico el enlace para restablecer la contraseña.");
        map.put("Did not receive the email? Check the spelling of the email address and also your spam folder.", "¿No lo recibió?  Compruebe la ortografía de la dirección de correo electrónico y revise su carpeta de correo no deseado.");
        map.put("Try to register", "Intente registrarse");
       

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_MEXICO=" + value);

        return (value);
    }
}
