package com.company.interfaces;
import com.company.classes.Article;

public interface ISolde {

    public void printTaux(Article oneArticle);
    public void lancerSoldes(Article oneArticle, int tauxSoldePercent);
    public void stopSoldes(Article oneArticle);
}
