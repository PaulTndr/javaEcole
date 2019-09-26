package com.company.classes.enfant;

public class Collegien extends Enfant implements Scolaire {
    private static String [] niveauList = {"6e", "5e", "4e", "3e"};
    private String niveau;
    private boolean examen;

    public Collegien(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau, boolean examen) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
        setExamen();
    }
    public boolean petit() {
        return niveau.equals("6e");
    }

    public boolean grand() {
        return (niveau.equals("3e"));
    }

    public boolean moyen() {
        return !niveau.equals("6e")&&!niveau.equals("3e");
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
        this.examen = grand();
    }
}
