package com.company.classes.personnel;

public class Enseignant extends Personnel {
    private String echelon;
    private double fixe;
    private int tempsMissions;
    private int heuresSup;
    private int heuresTravail;
    static double prime;
    static double tauxHeuresSup = 1.7;
    static double fixePRAG = 2200;
    static double fixeMDC = 3100;
    static double fixePROF = 2000;

    public Enseignant(String nom, String prenom) {
        super(nom, prenom);
        this.echelon = "";
        this.fixe = 0;
        this.tempsMissions = 0;
        this.heuresSup = 0;
    }

    public Enseignant(String nom, String prenom, String numSecu, int entree, int tempsTravail, String echelon, int tempsMissions, int heuresSup, int heuresTravail) {
        super(nom, prenom, numSecu, entree, tempsTravail);
        this.echelon = echelon;
        this.tempsMissions = tempsMissions;
        this.heuresSup = heuresSup;
        this.heuresTravail = heuresTravail;
        if(echelon.equals("PRAG")){
            this.fixe = fixePRAG;
        }
        else if(echelon.equals("MDC")){
            this.fixe = fixeMDC;
        }
        else if (echelon.equals("PROF")){
            this.fixe = fixePROF;
        }
    }

    @Override
    public double calculSalaire() {
        double salaire = fixe + (heuresSup * tauxHeuresSup);
        if(echelon.equals("PRAG") && heuresTravail >= 384 - tempsMissions ){
            salaire += prime;
        }
        else if(echelon.equals("MDC") && heuresTravail >= 192 - tempsMissions ){
            salaire += prime;
        }
        else if(echelon.equals("PROF") && heuresTravail >= 96 - tempsMissions ){
            salaire += prime;
        }
        return salaire;
    }

    public void setTempsMissions(int tempsMissions) {
        this.tempsMissions = tempsMissions;
    }

    public void setHeuresSup(int heuresSup) {
        this.heuresSup = heuresSup;
    }

    public void setHeuresTravail(int heuresTravail) {
        this.heuresTravail = heuresTravail;
    }

    public static void setPrime(double prime) {
        Enseignant.prime = prime;
    }

    public static void setTauxHeuresSup(double tauxHeuresSup) {
        Enseignant.tauxHeuresSup = tauxHeuresSup;
    }

    public static void setFixePRAG(double fixePRAG) {
        Enseignant.fixePRAG = fixePRAG;
    }

    public static void setFixeMDC(double fixeMDC) {
        Enseignant.fixeMDC = fixeMDC;
    }

    public static void setFixePROF(double fixePROF) {
        Enseignant.fixePROF = fixePROF;
    }

    public String getEchelon() {
        return echelon;
    }

    public double getFixe() {
        return fixe;
    }

    public int getTempsMissions() {
        return tempsMissions;
    }

    public int getHeuresSup() {
        return heuresSup;
    }

    public int getHeuresTravail() {
        return heuresTravail;
    }

    public static double getPrime() {
        return prime;
    }

    public static double getTauxHeuresSup() {
        return tauxHeuresSup;
    }

    public static double getFixePRAG() {
        return fixePRAG;
    }

    public static double getFixeMDC() {
        return fixeMDC;
    }

    public static double getFixePROF() {
        return fixePROF;
    }

    public void setEchelon(String echelon) {
        this.echelon = echelon;
    }
}
