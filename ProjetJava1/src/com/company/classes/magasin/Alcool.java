package com.company.classes.magasin;

public class Alcool extends Article{
    private static int ageMinimum = 18;

    public static int getAgeMinimum() {
        return ageMinimum;
    }

    public Alcool(String name, int prixBase){
        super(name, "Alcool", prixBase);
    }
}
