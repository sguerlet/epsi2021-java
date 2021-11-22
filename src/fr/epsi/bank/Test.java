package fr.epsi.bank;

public class Test {
    
    public static void main(String[] args) {
        
        BankAccount ba = new BankAccount(300, 0.95); 
        System.out.println("Solde initial : " + ba.getSolde());       
        ba.depot(500.0);
        System.out.println("Solde après dépot de 500 : " + ba.getSolde());
        ba.retrait(200);
        System.out.println("Solde après retrait de 200 : " + ba.getSolde());
    }
}
