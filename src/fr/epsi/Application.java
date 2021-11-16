package fr.epsi;

import fr.epsi.util.StringUtil;

public class Application {
    public static void main(String[] args) {
    
        if (args.length == 0)
            throw new IllegalArgumentException("Un paramètre est attendu pour exécuter le programme");
        // On lit la chaine de caractère à partir du premier paramètre
        String origine = args[0];

        System.out.println("Chaine de caractères lue depuis la ligne de commande");
        System.out.println(origine);

        StringUtil util = new StringUtil();
        System.out.println("Utilisation de l'objet avec le constructeur par défaut");
        System.out.println(util.insertCaractere(origine));

        util.setInsert('-');
        System.out.println("Ré-utilisation de l'objet après avoir changé le caractère avec le \"setter\"");
        System.out.println(util.insertCaractere(origine));

        util = new StringUtil('=');
        System.out.println("Utilisation de l'objet avec le constructeur permettant de fixer le caractère à insérer");
        System.out.println(util.insertCaractere(origine));

    }
}
