package Translation.EU_Countries;

import java.util.HashMap;

public class FR_Translation {

    // ############FRANCE############

    public String frTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("£", "");
            map.put("Username has been sent", "Le nom d'utilisateur a été envoyé");
            map.put("No Longer Manufactured", "Modèle arrêté");
            map.put("Suggested Alternatives", "Produits de remplacement proposés");
            map.put("Exact Alternative", "Alternative exacte");
            map.put("My Orders", "Mes commandes");
            map.put("Buying Tools", "Outils d’achat");
            map.put("My Profile", "Mon profil");
            map.put("Popular Manufacturers", "Fabricants les plus recherchés");
            map.put("Quick Buy", "Commande rapide");
            map.put("Request a Quote", "Demander une cotation");
            map.put("All Buying Tools", "Tous les outils d’aide à l’achat");
            map.put(
                "Automation & Process Control",
                "Automatismes et Contrôle de process"
            );
            map.put("Passives", "Composants passifs");
            map.put("Interconnect", "Produits d’interconnexion");
            map.put("Semiconductors", "Semi-conducteurs");
            map.put("Optoelectronics", "Produits optoélectroniques");
            map.put("Electromechanical", "Electromécanique");
            map.put("Embedded Systems", "Systèmes intégrés");
            map.put("Power", "Alimentation");
            map.put("Tools", "Outils");
            map.put("Customer Service", "Service client");
            map.put("Quick Links", "Liens rapides");
            map.put("About Us", "À propos de nous");
            map.put("Manufacturer", "Fabricant");
            map.put("Manufacturer Part No", "Réf. Fabricant");
            map.put("Order Code", "Code Commande");
            map.put("Technical Datasheet", "Fiche technique");
            map.put("Price For", "Prix pour");
            map.put("Technical Documents", "Documents techniques");
            map.put("Product Overview", "Aperçu du produit");
            map.put("content", "Contenu");
            map.put("Community", "Communauté");
            map.put("Customer Reviews", "Avis des clients");
            map.put("Customer Q&A Exchange", "Echange de questions/réponses des clients");
            map.put("Manufacturer Part Number", "Référence du fabricant");
            map.put("Manufacturer / Description", "Fabricant / Description");
            map.put("Availability", "Disponibilité");
            map.put("Quantity", "Quantité");
            map.put("Cut Tape", "Bandes découpées");
            map.put(
                "*Note: If you have selected a re-reeled item a £3.50 charge will be applied.",
                "*Remarque : si vous avez sélectionné un article mis en bobine, des frais de 5,00 € seront appliqués."
            );
            map.put("Description / Manufacturer", "Description / Fabricant");
            map.put("Price (ex VAT)", "Prix (sans TVA)");
            map.put("saw oscillators", "Oscillateurs SAW");
            map.put(
                "You've selected 11 products. You can compare up to 10 products at a time. The most recent 10 products will be shown.",
                "Vous avez sélectionné 11 produits. Vous pouvez comparer jusqu'à 10 produits à la fois. Les 10 produits les plus récents s'affichent."
            );
            map.put("manufacturers", "fabricants");
            map.put("Add Address", "Ajouter adresse");
            map.put("contact-us", "contactez-nous");
            map.put("help", "centre-daide");
            map.put("New Products", "Nouveaux produits");
            map.put("Great Deals", "Offres exceptionnelles");
            map.put("Featured Products", "Produits phares");
            map.put("leading manufacturers", "fabricants leaders sur le marché");
            map.put(
                "Legislation and Environmental",
                "Législation et Questions environnementales"
            );
            map.put("Re-Reel", "Mise en bobine");
            map.put(
                "We couldn’t find any products matching",
                "Nous sommes désolés, nous n'avons trouvé aucun produit correspondant à"
            );
            map.put("Search Tips", "Astuces de recherche");
            map.put("Can We Help?", "Pouvons-nous vous aider ?");
            map.put(
                "Popular Product Categories",
                "Catégories produits les plus populaires"
            );
            map.put("Successfully saved", "Panier enregistré avec succès");
            map.put("was successfully added.", "a bien été ajoutée.");
            map.put(
                "Your new payment card details have been saved.",
                "Les informations de votre nouvelle carte de paiement ont été enregistrées."
            );
            map.put(
                "Your new order preferences have been saved.",
                "Vos nouvelles préférences de commande ont été enregistrées."
            );
            map.put("Thank you for your order", "Merci pour votre commande.");
            map.put("Order History & Tracking", "Historique et suivi des commandes");
            map.put("Order Preferences", "Préférences de commande");
            map.put("Quotes", "Cotations");
            map.put("BOM Upload", "Téléchargement de nomenclature");
            map.put("Saved Basket", "Paniers sauvegardés");
            map.put("Favourites", "Favoris");
            map.put("Account Summary", "Résumé de compte");
            map.put("Profile Information", "Informations de profil");
            map.put("Full Reel", "Bobine complète");
            map.put("Quick Add", "Ajout rapide");
            map.put("Refine Results", "Affiner les résultats");
            map.put("Categories", "Catégories");
            map.put("Apply Filters", "Appliquer les filtres");
            map.put("browse-for-products", "rechercher-des-produits");
            map.put("Back to Main Menu", "Retour au menu principal");
            map.put("View All Products", "Afficher tous les produits");
            map.put("Manufacturers", "Fabricants");
            map.put("This item has been added to your basket", "Cet article a été ajouté à votre panier");
            map.put("Voucher Discount", "Remise promotionnelle");
            map.put("Trade Account", "Compte Client");
            map.put("Login / Register", "Connectez-vous / Enregistrez-vous");
            map.put("Shopping Cart", "Panier");
            map.put("My Account", "Mon compte");
            map.put("Order History & Tracking", "Historique et suivi des commandes");
            map.put("Calculators & Charts", "Calculatrices et tableaux");
            map.put("View All Manufacturers", "Voir tous les fabricants");
            map.put("Contact Us", "Contactez-nous");
            map.put("Log In", "Connectez-vous");
            map.put("New customer?", "Nouveau client ?");
            map.put("Returning Customer", "Déjà client");
            map.put("You have already registered to this site, please log in. If you need help please contact us on contact customer service.", "Si vous êtes déjà inscrit(e) sur ce site, connectez-vous. Pour obtenir de l'aide, veuillez contacter le service clientèle.");
            map.put("Register Now", "Enregistrez-vous maintenant");
            map.put("*Required Field", "*Champ obligatoire");
            map.put("Email or username", "E-mail ou nom d'utilisateur");
            map.put("*Password", "*Mot de passe");
            map.put("Forgotten your password?", "Vous avez oublié votre mot de passe ?");
            map.put("Forgotten your username?", "Vous avez oublié votre nom d'utilisateur ?");
            map.put("> Contact Us", "> Contactez-nous");
            map.put("Please enter all required information. The following was not entered:", "Veuillez saisir toutes les informations requises. Les informations suivantes n'ont pas été fournies :");
            map.put("Username", "Nom d'utilisateur");
            map.put("Password", "Mot de passe");
            map.put("Please correct the following fields:", "Veuillez corriger les champs suivants :");
            map.put("Either the email/username or password is incorrect. Please check and re-enter the information again.", "L'e-mail/le nom d'utilisateur ou le mot de passe est incorrect. Veuillez le vérifier et ressaisir les informations.");
            map.put("Retrieve Username", "Récupérer votre nom d'utilisateur");
            map.put("It happens from time to time. We're here to help you.", "Cela arrive. Nous sommes ici pour vous aider.");
            map.put("Enter your email and we will recover your username for you.", "Saisissez votre adresse e-mail et nous effectuerons la récupération de votre nom d'utilisateur pour vous.");
            map.put("* Email", "* Adresse e-mail");
            map.put("If the name and email you entered belongs to a Premier Farnell account, we will recover your username.", "Si le nom et l'adresse e-mail que vous avez saisis appartiennent à un compte Premier Farnell, nous effectuerons la récupération de votre nom d'utilisateur.");
            map.put("Please enter a valid Email Address", "Veuillez indiquer une adresse e-mail valide");
            map.put("Forgot your password", "Vous avez oublié votre mot de passe ?");
            map.put("It happens from time to time. We are here to help you.", "Cela arrive. Nous sommes ici pour vous aider.");
            map.put("Enter your email and we'll send you instructions on how to reset your password. Reset links are valid for 24 hours.", "Saisissez votre adresse e-mail et nous vous enverrons des instructions pour réinitialiser votre mot de passe. Les liens de réinitialisation sont valables pendant 24 heures.");
            map.put("Send Reset Link", "Envoyer un lien de réinitialisation");
            map.put("We found multiple accounts", "Nous avons trouvé plusieurs comptes");
            map.put("In order to reset your password please supply the username for which you need to reset", "Afin de réinitialiser votre mot de passe, veuillez fournir le nom d'utilisateur pour lequel vous devez réinitialiser");
            map.put("Reset email sent", "Réinitialiser l'e-mail envoyé");
            map.put("Farnell has sent an email with a link to reset your password to:", "Farnell a envoyé un e-mail avec un lien pour réinitialiser votre mot de passe à :");
            map.put("Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.", "Vous n'avez pas reçu l'e-mail ? Veuillez vérifier que vous avez un compte Farnell, l'orthographe de l'adresse e-mail et votre dossier spam.");
            map.put("Enter a valid username", "Veuillez fournir un nom d'utilisateur valide");
            map.put("Check your email", "Vous avez oublié votre mot de passe ?");
            map.put("Email Sent", "Email envoyé");
            map.put("Enter a valid username", "Entrez un nom d'utilisateur valide");
            map.put("Email Sent", "E-mail envoyé");
            map.put("If you have a registered account with us, you will receive the reset password link to your email.", "Si vous possédez un compte enregistré chez nous, vous recevrez par e-mail le lien de réinitialisation du mot de passe.");
            map.put("Did not receive the email? Check the spelling of the email address and also your spam folder.", "Vous n'avez pas reçu l'e-mail ? Vérifiez l'orthographe de l'adresse e-mail ainsi que votre dossier des spams.");
            map.put("Try to register", "Essayez de vous inscrire");
            map.put("Temporary Password", "Mot de passe temporaire");
            map.put("Confirm Password", "Confirmer le mot de passe");
            map.put("Apply for a Trade Account Today", "Faites une demande d'ouverture de compte client dès aujourd'hui");
            map.put("Your Trade Account application has been received.", "Nous accusons réception de votre demande d'ouverture de compte client.");
            map.put("Products Found", "produit(s) trouvé(s)");
            map.put("0 Products Found", "0 produit(s) trouvé(s)");

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
