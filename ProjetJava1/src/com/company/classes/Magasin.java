package com.company.classes;
import com.company.interfaces.IPublicite;
import com.company.interfaces.ISolde;
import com.company.interfaces.IVendreKilo;
import com.company.interfaces.IVendrePiece;

import java.util.*;

public class Magasin implements IPublicite, ISolde, IVendrePiece, IVendreKilo {
    private String nom;
    private String adresse;
    private int nbrVendeurs;
    private HashMap<String, Long> listQuantiteArticles;
    private HashMap<String, Long> listTauxArticles;
    private int caisse;

    public Magasin(String nom, String adresse, int nbrVendeurs, int caisseInitiale){
        this.nom = nom;
        this.adresse = adresse;
        this.nbrVendeurs = nbrVendeurs;
        this.caisse = caisseInitiale;
        this.listQuantiteArticles = new HashMap<String, Long>();
        this.listTauxArticles = new HashMap<String, Long>();
    }

    public void achete(Article oneArticle, int quantite){
        //On check si on a l'argent pour acheter ce qui est demandé
        if (this.caisse>=quantite*oneArticle.getPrixBase()){
            this.caisse -= quantite * oneArticle.getPrixBase();
            //Si on a déjà l'article en stock
            if (this.listQuantiteArticles.keySet().contains(oneArticle.getName())) {
                this.listQuantiteArticles.put(oneArticle.getName(),this.listQuantiteArticles.get(oneArticle.getName())+new  Long(quantite));
            } else { //Sinon
                this.listQuantiteArticles.put(oneArticle.getName(),new  Long(quantite));
                this.listTauxArticles.put(oneArticle.getName(),new  Long(100));
            }
        } else{
            System.out.println("Le magasin n'a pas assez d'argent pour procéder à l'achat de "+quantite+" "+oneArticle.getName()+".s");
        }
    }

    public void printTaux(Article oneArticle){
        System.out.println(
                        "Actuellement le taux pour l'article "+ oneArticle.getName()+
                        " est de "+ this.listTauxArticles.get(oneArticle.getName())+
                        " ce qui équivaut à un prix de " +oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100)
        );
    };
    public void lancerSoldes(Article oneArticle, int tauxSoldePercent){
        //On remplace le taux peu importe les soldes précédentes
        this.listTauxArticles.put(oneArticle.getName(), new Long(100-tauxSoldePercent));
        //On fait la pub de cette nouvelle solde
        this.fairePublicite(oneArticle);
    };

    public void stopSoldes(Article oneArticle){
        this.listTauxArticles.put(oneArticle.getName(), new Long(100));
    };

    public void fairePublicite(Article oneArticle){
        System.out.println("##################################");
        System.out.println("Votre attention svp");
        System.out.println("Nous vendons nos "+oneArticle.getName()+"s à -"+(100-this.listTauxArticles.get(oneArticle.getName()))+"%");
        System.out.println("Cela les fait au prix de seulement "+oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100)+"€");
        System.out.println("Dépéchez vous, il ne reste que "+this.listQuantiteArticles.get(oneArticle.getName())+" articles");
        System.out.println("##################################");
    };

    public boolean estVentePossible(Article oneArticle, int quantite){
        if (!this.listQuantiteArticles.keySet().contains(oneArticle.getName())){
            System.out.println("Le magasin n'a pas cet article en stock");
            return false;
        } else {
            if (this.listQuantiteArticles.get(oneArticle.getName())<quantite){
                System.out.println("Le magasin n'a pas assez d'exemplaire de cet article en stock");
                return false;
            }
        }
        return true;
    }

    public void vendre(Article oneArticle, int quantite){
        //Les checking sont fait en amont pour savoir si on peut vendre normalement mais autant recheck ici pour le moment
        if (!this.estVentePossible(oneArticle,quantite)){
            System.out.println("La vente est impossible");
            return;
        }
        Long remainQuantite = this.listQuantiteArticles.get(oneArticle.getName())-quantite;
        this.listQuantiteArticles.put(oneArticle.getName(), remainQuantite);
        this.caisse+=quantite*oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100);
        System.out.println("La vente s'est déroulée avec succès");
    }

    public void rembourser(Article oneArticle, int quantite){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbrVendeurs() {
        return nbrVendeurs;
    }

    public void setNbrVendeurs(int nbrVendeurs) {
        this.nbrVendeurs = nbrVendeurs;
    }

    public HashMap<String, Long> getListQuantiteArticles() {
        return listQuantiteArticles;
    }

    public void setListQuantiteArticles(HashMap<String, Long> listQuantiteArticles) {
        this.listQuantiteArticles = listQuantiteArticles;
    }

    public HashMap<String, Long> getListTauxArticles() {
        return listTauxArticles;
    }

    public void setListTauxArticles(HashMap<String, Long> listTauxArticles) {
        this.listTauxArticles = listTauxArticles;
    }

    public int getCaisse() {
        return caisse;
    }

    public void setCaisse(int caisse) {
        this.caisse = caisse;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nbrVendeurs=" + nbrVendeurs +
                ", listQuantiteArticles=" + listQuantiteArticles +
                ", listTauxArticles=" + listTauxArticles +
                ", caisse=" + caisse +"€"+
                '}';
    }

    public void print(){
        System.out.println(this.toString());
    }
}
