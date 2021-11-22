package fr.epsi.poly;

public abstract class Quadrilatere implements Polygone {

    // Les attributs ont la visibilité 'protected'
    // afin de n'être accessible que depuis les classes enfants
    protected int longueur = 0;
    protected int largeur = 0;


    public int getSurface() {
        return longueur * largeur;
    }


}