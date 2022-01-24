package fr.epsi.vendeurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.epsi.vendeurs.comparators.ParDateComparateur;
import fr.epsi.vendeurs.comparators.ParVenteComparateur;

public class Utilitaire {

    public static List<Vendeur> lireVendeursDepuisFichier(Path path) throws IOException {
        
        List<Vendeur> vendeurs = new ArrayList<>();

        List<String> lines = Files.readAllLines(path);
        for(String line : lines) {

           String[] lineSplitted = line.split(":");
           String nom = lineSplitted[0];
           String dateAsString = lineSplitted[1];
           String ventesAsString = lineSplitted[2];

           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDate date = LocalDate.parse(dateAsString, dtf);
           Vendeur vendeur = new Vendeur(nom, date);

           for (String venteAsString : ventesAsString.split(";")) {
             Integer vente = Integer.parseInt(venteAsString);
             vendeur.addVente(vente);
           }
           vendeurs.add(vendeur);
        }

        return vendeurs;
    }

    public static void trierParDate(List<Vendeur> vendeurs) {

        Collections.sort(vendeurs, new ParDateComparateur());
        Collections.reverse(vendeurs);
    }

    public static void trierParVente(List<Vendeur> vendeurs) {
        Collections.sort(vendeurs, new ParVenteComparateur());
        Collections.reverse(vendeurs);
    }

}
