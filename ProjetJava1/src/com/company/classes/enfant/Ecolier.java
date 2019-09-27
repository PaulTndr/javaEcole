package com.company.classes.enfant;

import com.company.interfaces.IScolaire;

public class Ecolier extends Enfant implements IScolaire {
    public static String niveauList [] = {"CP", "CE1", "CE2", "CM1", "CM2"};
    public String niveau;
    public Ecolier(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
    }
    public boolean petit() {
        return niveau.equals("CP");
    }

    public boolean grand() {
        return (niveau.equals("CM2"));
    }

    public boolean moyen() {
        return !niveau.equals("CP")&&!niveau.equals("CM2");
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
