package com.company.classes;

public class Article {

    private String name;
    private int prixBase;
    private int tauxSoldePercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(int prixBase) {
        this.prixBase = prixBase;
    }

    public int getTauxSoldePercent() {
        return tauxSoldePercent;
    }

    public void setTauxSoldePercent(int tauxSoldePercent) {
        this.tauxSoldePercent = tauxSoldePercent;
    }
}
