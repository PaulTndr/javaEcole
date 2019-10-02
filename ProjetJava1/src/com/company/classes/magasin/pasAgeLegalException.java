package com.company.classes.magasin;

public class pasAgeLegalException extends Exception {

    pasAgeLegalException(int ageLegal) {
        super("Vous ne pouvez pas acheter cet article car l'âge minimum légal est de " + ageLegal + " ans");
    }
}
