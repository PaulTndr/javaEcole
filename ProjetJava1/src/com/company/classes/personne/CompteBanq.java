package com.company.classes.personne;

public class CompteBanq {
    private String num;
    private Personne client;
    private float solde;
    private float decouvertAutorise;
    private String code1;
    private String code2;

    public CompteBanq(String num, Personne client, String code1, String code2){
        this.num = num;
        this.client = client;
        this.decouvertAutorise = 0;
        this.solde = 0;
        this.code1 = code1;
        this.code2 = code2;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Personne getClient() {
        return client;
    }

    public void setClient(Personne client) {
        this.client = client;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde, String code1) {
        if(code1.equals(this.code1)) {
            this.solde = solde;
        }
        else{
            System.out.print("Mauvais code");
        }
    }

    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(float decouvertAutorise, String code2) {
        if(code2.equals(this.code2)) {
            this.decouvertAutorise = decouvertAutorise;
        }
        else{
            System.out.print("Mauvais code");
        }
    }

    public void versement(String code1, float somme){
        this.setSolde(this.solde + somme, code1);
    }

    public void retrait(String code1, float somme){
        if(this.solde < somme){
            if(this.decouvertAutorise + this.solde > somme){
                this.setSolde(this.solde - somme, code1);
            }
            else{
                System.out.print("Solde insuffisant");
            }
        }
        else{
            this.setSolde(this.solde - somme, code1);
        }
    }
}
