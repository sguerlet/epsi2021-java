package fr.epsi.poly;

// Une interface permet de définir et de forcer un
// "contrat de service" envers les classes qui l'implémente.
// On sait donc qu'on pourra demander la valeur de sa surface
// à toute classe qui implémente Polygone
public interface Polygone {
    
    // Les méthodes des interfaces sont des définitions uniquement,
    // c'est à dire qu'on n'écrit que leur signature, sans 'corps'
    public int getSurface();
}
