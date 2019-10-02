package com.company.interfaces;

import com.company.classes.magasin.Article;
import com.company.classes.magasin.pasStockSuffisantException;

public interface IVendrePiece {

    boolean estVentePossible(Article oneArticle, int quantite) throws pasStockSuffisantException;
    void vendre(Article oneArticle, int quantite) throws pasStockSuffisantException;
    void rembourser(Article oneArticle, int quantite);
}
