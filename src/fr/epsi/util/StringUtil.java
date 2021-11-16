package fr.epsi.util;

public class StringUtil {
    
    // Caractère à insérer, initié à '.' par défaut
    private char insert = '.';

    // "Setter" permettant de mettre à jour
    // le caractère à insérer
    public void setInsert(char newInsert) {
        insert = newInsert;
    }

    /**
    * Retourne une nouvelle chaine de caractères, composée
    * de la chaine de caractères passée en paramètre dans
    * laquelle on insère le caractère choisi entre chaue caractère
    * (via constructeur ou setter) 
    *
    * @param  origine  la chaine de caractères à modifier
    * @return  la chaine de caractères d'origine 
    */
    public String insertCaractere(String origine) {

        StringBuffer result = new StringBuffer();
        for(char c : origine.toCharArray()) {
            result.append(c);
            result.append(insert);
        }
        // retrait du dernier caractère "en trop" 
        // avant de retourner le résultat 
        return result.substring(0, result.length()-1).toString();
    }

    // Constructeur permettant d'initialiser
    // le caractère à insérer
    public StringUtil(char insertVoulu) {
        insert = insertVoulu;
    }

    // Constructeur par défaut (explicite)
    public StringUtil() {}
}
