package com.company.classes.enfant;

public class Enfant {
    private String Nom;
    private String Prenom;
    private int anneeNaissance;
    private char sexe;
    private int deptNaissance;

    public Enfant(String nom, String prenom){
        this.Nom = nom;
        this.Prenom = prenom;
        this.anneeNaissance = 0;
        this.sexe = ' ';
        this.deptNaissance = 0;
    }
    public Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance){
        this.Nom = nom;
        this.Prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.deptNaissance = deptNaissance;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public int getDeptNaissance() {
        return deptNaissance;
    }

    public void setDeptNaissance(int deptNaissance) {
        this.deptNaissance = deptNaissance;
    }
}
