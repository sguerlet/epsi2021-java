package fr.epsi.notes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Programme {
    
    // Ce programme fait le travail demandé 
    // (lecture du fichier des notes des élèves et affichage de leur moyenne)
    // mais est bien trop procédural et n'offre pas de moyen simples de 
    // le rendre modulable, réutilisable, en plus d'être difficilement lisible
    // Une approche déjà plus "orientée objet" est proposée dans ProgrammeObjet
    // elle pourrait évidemment être plus poussée :)
    public static void main(String[] args) {
        Path filePath = Path.of("./resources/notes.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String nom = line.substring(0, line.indexOf("|"));
                String notesAsString = line.substring(line.indexOf("|")+1);
                String[] noteAsStringArray = notesAsString.split("\\|");
                List<Double> noteList = new ArrayList<>();
                for(String noteAsString : noteAsStringArray) {
                    try {
                        noteList.add(Double.parseDouble(noteAsString));
                    } catch(NumberFormatException nfe) {
                        System.out.println(nfe.getMessage());;
                    }
                }
                Double somme = 0.0;
                for (Double note : noteList) {
                    somme += note;
                }
                double moyenne = somme / noteList.size();
                System.out.println("La moyenne pour ["+nom+"] est de ["+moyenne+"]");

            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
