package com.company.classes.magasin;

public class pasSoldeSuffisantAchatException extends Exception {
    pasSoldeSuffisantAchatException(){
        super("Vous ne disposez pas d'un solde suffisant, l'achat est impossible");
    }
}
