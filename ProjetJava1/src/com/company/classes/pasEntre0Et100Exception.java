package com.company.classes;

public class pasEntre0Et100Exception extends Exception{

    pasEntre0Et100Exception(int tauxError){
        super("(!) Attention, la solde n'a pas été lancée car "+tauxError+"% n'est pas un taux de solde acceptable (!)");
    }
}
