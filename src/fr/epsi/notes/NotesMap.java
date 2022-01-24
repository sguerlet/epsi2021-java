package fr.epsi.notes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMap {
    

    public static void main(String[] args) throws IOException {
        
        Map<String, List<Double>> eleves = new HashMap<>();

        List<String> lines = Files.readAllLines(Path.of("./resources/notesMap.txt"));
        for(String line : lines) {
            String[] lineSplitted = line.split(":");
            String nom = lineSplitted[0];
            String noteAsString = lineSplitted[1];
            Double note = Double.parseDouble(noteAsString);

            
            if (eleves.get(nom) == null) {
                // Eleve non présent dans la Map
                List<Double> notes = new ArrayList<>();
                notes.add(note);
                eleves.put(nom,notes);
            } else {
                // Eleve déjà présent dans la Map
                List<Double> notes = eleves.get(nom);
                notes.add(note);
            }

        }

        for(String nom : eleves.keySet()) {
            List<Double> notes = eleves.get(nom);
            System.out.println("Notes pour "+nom+" : "+ notes);


        }
    }
}
