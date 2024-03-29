package com.company.classes.magasin;
import com.company.classes.personne.CompteBanq;
import com.company.classes.personne.Personne;
import com.company.classes.personne.pasCodeValideException;
import com.company.classes.personne.pasSoldeSuffisantRetraitException;
import com.company.interfaces.IPublicite;
import com.company.interfaces.ISolde;
import com.company.interfaces.IVendre;

import java.util.*;

public class Magasin implements IPublicite, ISolde, IVendre {
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

    public void achete(Article oneArticle, int quantite) throws pasSoldeSuffisantAchatException{
        //On check si on a l'argent pour acheter ce qui est demandé
        try{
            if(this.caisse<=quantite*oneArticle.getPrixBase()){
                throw new pasSoldeSuffisantAchatException();
            }
        }catch(pasSoldeSuffisantAchatException exc){
            System.out.println(exc.getMessage());
            return;
        }
        this.caisse -= quantite * oneArticle.getPrixBase();
        //Si on a déjà l'article en stock
        if (this.listQuantiteArticles.keySet().contains(oneArticle.getName())) {
            this.listQuantiteArticles.put(oneArticle.getName(),this.listQuantiteArticles.get(oneArticle.getName())+new  Long(quantite));
        } else { //Sinon
            this.listQuantiteArticles.put(oneArticle.getName(),new  Long(quantite));
            this.listTauxArticles.put(oneArticle.getName(),new  Long(100));
        }
    }



    public void printTaux(Article oneArticle){
        System.out.println(
                        "Actuellement le taux pour l'article "+ oneArticle.getName()+
                        " est de "+ this.listTauxArticles.get(oneArticle.getName())+
                        " ce qui équivaut à un prix de " +oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100)
        );
    };
    public void lancerSoldes(Article oneArticle, int tauxSoldePercent) throws pasEntre0Et100Exception, pasStockSuffisantException {
        try{
            if (tauxSoldePercent<0 || tauxSoldePercent>=100){
                throw new pasEntre0Et100Exception(tauxSoldePercent);
            }
            if(!this.listQuantiteArticles.keySet().contains(oneArticle.getName())){
                throw new pasStockSuffisantException(0);
            }
        } catch (pasEntre0Et100Exception exc){
            System.out.println(exc.getMessage());
            return;
        }catch(pasStockSuffisantException exc){
            System.out.println(exc.getMessage());
            return;
        }

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

    public boolean estVentePossible(Article oneArticle, int quantite) throws pasStockSuffisantException{
        try{
            if (!this.listQuantiteArticles.keySet().contains(oneArticle.getName())) {
                throw new pasStockSuffisantException(0);
            }
            if(this.listQuantiteArticles.get(oneArticle.getName())<quantite){
                throw new pasStockSuffisantException(Math.toIntExact(this.listQuantiteArticles.get(oneArticle.getName())));
            }
        }catch(pasStockSuffisantException exc){
            System.out.println(exc.getMessage());
            return false;
        }
        return true;
    }

    public void vendre(Article oneArticle, int quantite) throws pasStockSuffisantException {
        //Les checking sont fait en amont pour savoir si on peut vendre normalement mais autant recheck ici pour le moment
        if (!this.estVentePossible(oneArticle,quantite)){
            System.out.println("La vente est impossible");
            return;
        }
        Long remainQuantite = this.listQuantiteArticles.get(oneArticle.getName())-quantite;
        this.listQuantiteArticles.put(oneArticle.getName(), remainQuantite);
        if(remainQuantite==0){
            //On arrête les soldes sur cet articles

            //On supprime l'article du magasin
            this.listQuantiteArticles.remove(oneArticle.getName());
            this.listTauxArticles.remove(oneArticle.getName());
        }
        this.caisse+=quantite*oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100);
        System.out.println("La vente s'est déroulée avec succès");
    }

    public void vendreAClient(Personne client, CompteBanq compte, String code1, Article oneArticle, int quantite) throws pasStockSuffisantException, pasAgeLegalException, pasCodeValideException, pasSoldeSuffisantRetraitException {
        //Les checking sont fait en amont pour savoir si on peut vendre normalement mais autant recheck ici pour le moment
        try{
            if(client.calculAge() < oneArticle.getAgeMinimum()){
                throw new pasAgeLegalException(oneArticle.getAgeMinimum());
            }
        }catch(pasAgeLegalException exc){
            System.out.println(exc.getMessage());
            return;
        }
        if(this.estVentePossible(oneArticle,quantite)) {
            float prix = quantite*oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100);
            if(compte.getSolde() < prix ){
            System.out.print("Paiement refusé, votre solde est insuffisant.");
            return;
        }
        vendre(oneArticle, quantite);
        compte.retrait(code1, prix);
        }
    }


    public void rembourser(Article oneArticle, int quantite){
        if (this.caisse<quantite*oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100)){
            System.out.println("C'est la faillite on ne peut pas rembourser désolé");
            return;
        }
        if (!this.listQuantiteArticles.keySet().contains(oneArticle.getName())){
            this.listQuantiteArticles.put(oneArticle.getName(),new Long(0));
            this.listTauxArticles.put(oneArticle.getName(),new Long(100));
        }
        Long remainQuantite = this.listQuantiteArticles.get(oneArticle.getName())+quantite;
        this.listQuantiteArticles.put(oneArticle.getName(), remainQuantite);
        this.caisse-=quantite*oneArticle.getPrixBase()*((float) this.listTauxArticles.get(oneArticle.getName())/100);
        System.out.println("Le remboursement s'est déroulé avec succès");
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
