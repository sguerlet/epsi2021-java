package fr.epsi.bank;

public class Test {
    
    public static void main(String[] args)  {

        BankAccount ba = new BankAccount(300, 0.95); 
        System.out.println("Solde initial : " + ba.getSolde());       
        ba.depot(500.0);
        System.out.println("Solde après un dépot de 500 : " + ba.getSolde());
        try {
            // Tentative d'un retrait inférieur au solde
            ba.retrait(200);
        }catch (BankAccountException bae) {
            System.out.println(bae.getMessage());
        }
        System.out.println("Solde après un retrait de 200 : " + ba.getSolde());
        try {
            // Tentative d'un retrait supérieur au solde
            ba.retrait(40000);
        }catch (BankAccountException bae) {
            // L'appel à la méthode "retrait" doit ici lever une exception
            // on exécute donc ce block "catch" dans le quel on pourrait 
            // imaginer l'envoi d'une notification au service des fraudes...
            System.out.println(bae.getMessage());
        }
        System.out.println("Solde après une tentative de retrait de 40000 : " + ba.getSolde());
        
    }
}
