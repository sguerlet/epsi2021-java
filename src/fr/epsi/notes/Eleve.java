package fr.epsi.notes;

import java.util.ArrayList;
import java.util.List;

public class Eleve {
    
    private String nom;

    // La liste des notes de l'élève, initialisé à une liste vide de type Double
    private List<Double> noteList = new ArrayList<>();

    // Cette méthode statique permet de créer un objet Eleve
    // depuis une chaine de caractère respectant le format "nom|note|note|..."
    // Il s'agit de l'implémentation du pattern "Factory"
    public static Eleve fromLine(String line) {

        String nom = line.substring(0, line.indexOf("|"));
        Eleve eleve = new Eleve(nom);
        String notesAsString = line.substring(line.indexOf("|")+1);
        String[] notesAsStringArray = notesAsString.split("\\|");
        
        for(String noteAsString : notesAsStringArray) {
            eleve.addNote(Double.parseDouble(noteAsString));
        }
        return eleve;
    }

    // Exemple d'une autre factory (non utilisée dans le TP)
    public static Eleve withName(String name) {
        return new Eleve(name);
    }

    // Après construction de l'objet, il s'agit de l'unique moyen
    // pour ajouter une note à l'élève
    public void addNote(Double note) {
        noteList.add(note);
    }

    // Unique constructeur de l'objet Eleve
    // on s'assure ainsi que les objets de type Eleve sont crées 
    // uniquement depuis les factory ci-dessus
    private Eleve(String nom) {
        this.nom = nom;
    }

    // La moyenne n'est pas un attribut de l'objet 
    // mais bien une une valeur fournie à chaque appel à cette méthode
    // Une alternative serait d'en faire un attribut privé, dont on 
    // mettrait à jour la valeur à chaque appel à "addNote"
    public Double getMoyenne() {
        Double somme = 0.0;
        for (Double note : noteList) {
            somme += note;
        }
        return somme / noteList.size();
    }

    @Override
    public String toString() {
        return "La moyenne pour ["+nom+"] est de ["+getMoyenne()+"]";
    }
}
