package fr.epsi.poly;

import java.util.List;
import java.util.ArrayList;

public class Test {
    
    public static void main(String... args) {
        

        Carre carre = new Carre(4);
        Rectangle rectangle = new Rectangle(5,3);
        
        // L'objet 'carre' est tout à la fois 
        // - une instance de Carre (sa propre classe)
        // - une instance de Quadrilatere (sa classe parente)
        // - une instance de Polygone (l'interface qu'il implémet via sa classe parente)
        System.out.println("Test de type de classe");
        System.out.println("carre instanceof Carre : " + (carre instanceof Carre));
        System.out.println("carre instanceof Quadrilatere : " + (carre instanceof Quadrilatere));
        System.out.println("carre instanceof Polygone : " + (carre instanceof Polygone));
        System.out.println("Polygone.class.isAssignableFrom(carre.getClass()) : " + Polygone.class.isAssignableFrom(carre.getClass()));

        // les classes Carre et Rectangle héritant de Quadrilatere,
        // on peut les ajouter typée 'Quadrilatere'
        List<Quadrilatere> liste = new ArrayList<Quadrilatere>();
        liste.add(carre);
        liste.add(rectangle);

        System.out.println("\nAffichage des quadrilatères et de leur surface");
        for(Quadrilatere quad : liste) {
            // L'affichage d'un objet utilise la méthode toString
            // qu'on a choisi de surcharger dans les classes Carre et Rectangle
            System.out.print(quad);
            System.out.print(" | ");
            // Les classes Carre et Rectangle peuvent être utilisée
            // en tant qu'interface Polygone puisqu'elles l'implementent
            // au travers de leur classe parente Quadrilatere
            printSurface(quad);
        }

    }


    private static void printSurface(Polygone poly) {

        System.out.println("Surface :" + poly.getSurface());
    }
}
