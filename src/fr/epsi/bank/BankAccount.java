package fr.epsi.bank;

public class BankAccount {
    
    // En choisissant la visibilité 'private'
    // on s'assure que les attributs qui représentent 
    // l'état du compte bancaire ne sont pas accessible directement
    // et ne seront mis à jour que à partir de méthodes qu'on maîtrise
    // De plus, l'attribut 'pourcentage' sera forcément renseigné
    // lors de l'instanciation de l'objet (voir les constructeurs)
    private double pourcentage;
    private double solde;

    // Cette méthode permet de lire de solde du compte
    // En ne proposant pas son équivalent pour la modification,
    // on s'assure de son accès en lecture seule
    public double getSolde() {
        return solde;
    }

    // Ce constructeur permet de s'assurer qu'on crée une instance en 
    // renseignant de manière obligatoire le pourcentage et le solde
    // En écrivant un constructeur explicite, le constructeur 'vide' implicite n'existe plus
    public BankAccount(double soldeInitial, double newPourcentage) {
        this.pourcentage = newPourcentage;
        solde = soldeInitial;
    }

    // Ce constructeur appelle le constructeur plus générique 
    // en fixant le solde à zéro
    public BankAccount(double newPourcentage) {
        this(0, newPourcentage);
    }

    // Le dépot doit forcément passer par cette méthode
    // qui prélève le pourcentage, il n'existe pas d'autre manière 
    // d'ajouter au solde 
    public void depot(double somme) {
        solde += somme*pourcentage;
    }

    // Cette méthode retire simplement la somme du solde
    // Une vérification du solde est réalisé avant le retrait effectif,
    // une exception est levée le cas échéant
    public void retrait(double somme) throws BankAccountException {
        if (solde > somme) { 
            solde -= somme;
        } else {
            throw new BankAccountException("L'opération de retrait n'est pas réalisable : solde insuffisant");
        }
    }

}
