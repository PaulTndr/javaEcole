package com.company.classes.enfant;

import com.company.interfaces.IScolaire;

public class Lyceen extends Enfant implements IScolaire {
    private static String [] niveauList = {"2nd", "1ere", "term"};
    private String niveau;
    private boolean examen;

    public Lyceen(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
        setExamen();
    }

    public boolean petit() {
        return niveau.equals("2nd");
    }

    public boolean grand() {
        return (niveau.equals("term"));
    }

    public boolean moyen() {
        return niveau.equals("1ere");
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public boolean isExamen() {
        return examen;
    }

    public void setExamen() {
        this.examen = grand() || moyen();
    }


}
