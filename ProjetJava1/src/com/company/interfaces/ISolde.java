package com.company.interfaces;
import com.company.classes.Article;

public interface ISolde {

    void printTaux(Article oneArticle);
    void lancerSoldes(Article oneArticle, int tauxSoldePercent);
    void stopSoldes(Article oneArticle);
}
