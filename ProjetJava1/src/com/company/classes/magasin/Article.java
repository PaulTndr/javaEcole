package com.company.classes.magasin;

public class Article {

    private String name;
    private String categorie;
    private int prixBase;
    private static int ageMinimum = 10;

    public static int getAgeMinimum() {
        return ageMinimum;
    }

    public Article(String name, String categorie, int prixBase){
        this.name=name;
        this.categorie = categorie;
        this.prixBase=prixBase;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prixBase=" + prixBase +
                '}';
    }

    public void print(){
        System.out.println(this.toString());
    }
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

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
}
