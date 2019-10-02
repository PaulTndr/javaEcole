package com.company.interfaces;
import com.company.classes.magasin.Article;
import com.company.classes.magasin.pasEntre0Et100Exception;
import com.company.classes.magasin.pasStockSuffisantException;

public interface ISolde {

    void printTaux(Article oneArticle);
    void lancerSoldes(Article oneArticle, int tauxSoldePercent) throws pasEntre0Et100Exception, pasStockSuffisantException;
    void stopSoldes(Article oneArticle);
}
