package com.company.classes.personne;

import java.text.SimpleDateFormat;

public class Personne {
    private String nom;
    private String prenom;
    private String numSecu;
    private int anneeNaissance;
    private int moisNaissance;
    private char sexe;
    private int deptNaissance;

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.numSecu = "000000";
        this.anneeNaissance = 0;
        this.moisNaissance = 0;
        this.sexe = 'n';
        this.deptNaissance = 0;
    }

    public Personne(String nom, String prenom, String numSecu){
        this.nom = nom;
        this.prenom = prenom;
        this.setNumSecu(numSecu);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                (numSecu != "000000" ? ", numSecu='" + numSecu + '\'' : "") +
                (moisNaissance != 0 ? ", moisNaissance=" + moisNaissance + '\'' : "") +
                (anneeNaissance != 0 ? ", anneeNaissance=" + anneeNaissance + '\'' : "") +
                (sexe != 'n' ? ", sexe=" + sexe : "") +
                (deptNaissance != 0 ? ", deptNaissance=" + deptNaissance + '\'' : "") +
                '}';
    }

    private int anneeNaissance(){
        int annee = Integer.parseInt(numSecu.substring(1,3));
        if(annee > 20)
            return 1900+annee;
        else
            return 2000+annee;
    }

    private int moisNaissance(){
        return Integer.parseInt(numSecu.substring(3,5));
    }

    private char sexe(){
        if(numSecu.substring(0,1).equals("1")){
            return 'm';
        }else if(numSecu.substring(0,1).equals("2")){
            return 'f';
        }
        else return 'n';
    }

    private int deptNaissance(){
        return Integer.parseInt(numSecu.substring(5, 7));
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
        this.deptNaissance = this.deptNaissance();
        this.moisNaissance = this.moisNaissance();
        this.anneeNaissance = this.anneeNaissance();
        this.sexe = this.sexe();
    }

    public int calculAge(){
        java.util.Date now = new java.util.Date();
        SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        int annee = Integer.parseInt(yearFormat.format(now));
        int mois = Integer.parseInt(monthFormat.format(now));
        if(mois > this.moisNaissance){
            return annee - this.anneeNaissance;
        }
        else{
            return annee - this.anneeNaissance - 1;
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public int getMoisNaissance() {
        return moisNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public int getDeptNaissance() {
        return deptNaissance;
    }
}
