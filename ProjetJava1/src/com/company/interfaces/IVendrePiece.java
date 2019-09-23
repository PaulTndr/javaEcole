package com.company.interfaces;

import com.company.classes.Article;

public interface IVendrePiece {

    boolean estVentePossible(Article oneArticle, int quantite);
    void vendre(Article oneArticle, int quantite);
    void rembourser(Article oneArticle, int quantite);
}
