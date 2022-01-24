package fr.epsi.vendeurs;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Programme {
    
    public static void main(String[] args) throws IOException {
        
        Path path = Path.of("./resources/vendeurs.txt");
        // Lire les vendeurs depuis le fichier
        List<Vendeur> vendeurs = Utilitaire.lireVendeursDepuisFichier(path);
        // Trier selon date
        Utilitaire.trierParDate(vendeurs);
        // Aficher la liste
        System.out.println("Tri par date");
        afficher(vendeurs);
        System.out.println();
        // Trier selon le montant des ventes
        Utilitaire.trierParVente(vendeurs);
        // Aficher la liste
        System.out.println("Tri par montant de ventes");
        afficher(vendeurs);
    }

    public static void afficher(List<Vendeur> vendeurs) {

        for(Vendeur vendeur : vendeurs) {
            System.out.println(vendeur);
        }
    }
}
