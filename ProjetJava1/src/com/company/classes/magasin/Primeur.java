package com.company.classes.magasin;

import com.company.classes.magasin.Article;

public class Primeur extends Article {
    
    private Boolean isKg;

    public Primeur(String name, int prixBase, Boolean isKg){
        super(name, "Primeur", prixBase);
        this.isKg = isKg;
    }
}
