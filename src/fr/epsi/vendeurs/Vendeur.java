package fr.epsi.vendeurs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Vendeur {
    

    private String nom;
    
    private List<Integer> ventes = new ArrayList<>();

    private LocalDate dateDerniereVente;

    public Vendeur(String nom, LocalDate date) {
        this.nom = nom;
        this.dateDerniereVente = date;
    }

    public void addVente(Integer vente) {
        ventes.add(vente);
    }

    public void setDateDerniereVente(LocalDate date) {
        this.dateDerniereVente = date;
    }

    public LocalDate getDateDerniereVente() {
        return dateDerniereVente;
    }
    
    public Integer getTotalVente() {
        Integer sum = 0;
        for(Integer uneVente : ventes) {
            sum += uneVente;
        }
        return sum;
    }

    public String toString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRANCE);
        return nom + " a vendu pour " + getTotalVente() + " en date du " + dateDerniereVente.format(dtf);
    }
}
