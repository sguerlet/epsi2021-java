package fr.epsi.poly;

public class Rectangle extends Quadrilatere {
    
    public Rectangle(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public String toString() {
        return "Rectangle de longueur "+longueur+" et de largeur "+largeur;
     }
}
