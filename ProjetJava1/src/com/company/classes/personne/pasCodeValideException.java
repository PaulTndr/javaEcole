package com.company.classes.personne;

public class pasCodeValideException extends Exception {
    pasCodeValideException(){
        super("Code invalide, l'opération est impossible");
    }
}
