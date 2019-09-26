package com.company.classes.personnel;

import com.company.classes.personne.Personne;

public abstract class Personnel extends Personne {
    private int anneeEntree;
    private int tempsTravail;

    public Personnel(String nom, String prenom) {
        super(nom, prenom);
        this.anneeEntree = 0;
        this.tempsTravail = 0;
    }
    public Personnel(String nom, String prenom, String numSecu) {
        super(nom, prenom, numSecu);
        this.anneeEntree = 0;
        this.tempsTravail = 0;
    }
    public Personnel(String nom, String prenom, String numSecu, int entree, int tempsTravail) {
        super(nom, prenom, numSecu);
        this.anneeEntree = entree;
        this.tempsTravail = tempsTravail;
    }
    abstract double calculSalaire();
}
