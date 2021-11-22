package fr.epsi.poly;

public class Carre extends Quadrilatere {

    private int cote;

    // Le seul constructeur de cette classe prend uniquement 
    // la valeur d'un côté en paramètre, forçant ainsi le renseignement
    // des valeurs de 'largeur' et 'longueur'
    public Carre(int cote) {
       this.cote = cote;
       largeur = cote;
       longueur = cote;
    }
    
    // La surcharge de le méthode getSurface reste possible
    // même si inutile ici, puisque donnant le même résultat
    // que la classe mère. 
    public int getSurface() {
       return cote * cote;
    }

    // Toute classe en Java hérite de java.lang.Object qui 
    // défini cette méthode toString. Elle est ici surchargée
    // pour pouvoir être appelée dans les opération d'affichage
    // comme par exemple System.out.print(monCarre)
    public String toString() {
       return "Carre de coté "+cote;
    }
}
