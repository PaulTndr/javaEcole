package com.company.classes.personne;

public class pasSoldeSuffisantRetraitException extends Exception {
    pasSoldeSuffisantRetraitException(){
        super("Votre solde est insuffisant pour effectuer ce retrait");
    }
}
