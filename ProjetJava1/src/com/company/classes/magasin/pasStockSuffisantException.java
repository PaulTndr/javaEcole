package com.company.classes.magasin;

public class pasStockSuffisantException extends Exception {
    pasStockSuffisantException(int stock){
        super("Le magasin ne dispose pas d'un stock suffisant pour effectuer la vente. Il reste " + stock + " article(s)");
    }
}
