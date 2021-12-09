package fr.epsi.notes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProgrammeObjet {
    
    // Cette approche un peu plus orientée objet du programme précédent
    // a au moins le mérite d'être plus lisible
    // Une prochaine étape serait de créer un parser qui saurait extraire les 
    // données d'un élèves selon différentes sources (fichier, appel HTTP, ...)
    // et selon différent format (CSV, JSON, XML, ...)
    public static void main(String[] args) {
        Path filePath = Path.of("./resources/notes.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
              System.out.println(Eleve.fromLine(line));
            } 
        } catch (IOException e) {
            
                e.printStackTrace();
        }
    }
}
