package com.company.classes.personnel;

public class IATOS extends Personnel {
    private double fixe;
    private int heuresSup;
    private double tauxHeuresSup;

    public IATOS(String nom, String prenom, String numSecu, int entree, int tempsTravail, double fixe, int heuresSup, double tauxHeuresSup) {
        super(nom, prenom, numSecu, entree, tempsTravail);
        this.fixe = fixe;
        this.heuresSup = heuresSup;
        this.tauxHeuresSup = tauxHeuresSup;
    }

    @Override
    public double calculSalaire() {
        return fixe + (heuresSup * tauxHeuresSup);
    }

    public double getFixe() {
        return fixe;
    }

    public void setFixe(double fixe) {
        this.fixe = fixe;
    }

    public int getHeuresSup() {
        return heuresSup;
    }

    public void setHeuresSup(int heuresSup) {
        this.heuresSup = heuresSup;
    }

    public double getTauxHeuresSup() {
        return tauxHeuresSup;
    }

    public void setTauxHeuresSup(double tauxHeuresSup) {
        this.tauxHeuresSup = tauxHeuresSup;
    }
}
