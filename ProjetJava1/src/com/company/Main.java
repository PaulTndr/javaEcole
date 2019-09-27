package com.company;
import com.company.classes.Note;
import com.company.classes.enfant.Collegien;
import com.company.classes.enfant.Enfant;
import com.company.classes.magasin.*;
import com.company.classes.personne.*;
import com.company.classes.personnel.Enseignant;

public class Main {

    public static void main(String[] args) throws pasEntre0Et100Exception {
        //Création d'une personne
        System.out.print("---- PERSONNES ----");
        Personne paul = new Personne("Tondereau", "Paul", "197046212000522");
        System.out.print(paul.toString());
        System.out.print("Age de Paul: " + paul.calculAge());

        System.out.print("---- COMPTE BANCAIRE ----");
        CompteBanq comptePaul = new CompteBanq("01", paul, "0000", "1234");
        comptePaul.versement("0000", 1500);
        System.out.println("Solde: " + comptePaul.getSolde());
        comptePaul.setDecouvertAutorise(300, "1234");
        comptePaul.retrait("0000",1700);
        System.out.println("Solde: " +comptePaul.getSolde());

        System.out.print("---- ELEVES ----");
        EleveDigitale audrey = new EleveDigitale("Tordjmann", "Audrey", "297021312000522", "123456789I", 2017, 3);
        Note noteSport = new Note("sport", 17, 3, true);
        audrey.ajoutNote(noteSport);
        System.out.println("Notes: " + audrey.getListeNotes());

        Collegien matheo = new Collegien("Tordjmann", "Mathéo", 2007, 'm', 13, "5e");
        System.out.println("Examen :" + matheo.isExamen());

        //Création du magasin
        System.out.println("---- MAGASIN ----");
	    Magasin monoprix = new Magasin("Monoprix Marseille République", "3 rue de la République", 3, 600);
	    monoprix.print();

        //Création des articles
	    Habit pull = new Habit("Pull",40);
        Electromenager frigo = new Electromenager("Réfrigérateur",300);
        Primeur pomme = new Primeur("Pomme",1);
        //Article pour majeurs
        Alcool vodka = new Alcool("Vodka",10);
	    pull.print();
        vodka.print();
        frigo.print();
        pomme.print();

        //On fait acheter des articles au magasin
        monoprix.achete(frigo,1);
        monoprix.achete(pomme,5);
        System.out.println(monoprix.getListQuantiteArticles().toString());
        monoprix.achete(frigo,1);

        //On va lancer une solde sur les pommes
        monoprix.lancerSoldes(frigo,20);
        //On lance maintenant une solde impossible
        monoprix.lancerSoldes(frigo,120);

        //On va vendre des pommes
        monoprix.print();
        monoprix.vendre(pomme, 3);
        monoprix.print();

        // Prof avec compte bancaire vient acheter des habits
        Enseignant prof = new Enseignant("Dumbledore", "Albus", "121051312000520",1950,100,"PROF",20,50,96);
        System.out.println("Salaire: " + prof.calculSalaire());
        CompteBanq compteProf = new CompteBanq("02", prof, "0102", "3040");
        compteProf.versement("0102", (float) prof.calculSalaire());

        monoprix.vendreAClient(prof,compteProf,"0102",pull,1);
        Article chanel = new Article("Sac Chanel", "sac", 20000);
        Magasin bonmarche = new Magasin("Le Bon Marché Paris", "Paris", 30, 60000000);
        bonmarche.achete(chanel,10);
        bonmarche.vendreAClient(prof,compteProf,"0102",chanel,1);
        Personne enfant = new Personne("Potter", "Harry", "11502650255890");
        monoprix.vendreAClient(enfant, compteProf,"0101", frigo,1);
    }
}
