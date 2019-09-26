package com.company.classes.personne;

import com.company.classes.personne.Personne;

public class Eleve extends Personne {
        private String ine;
        private int promo;
        private int annee;

        public Eleve(String nom, String prenom) {
            super(nom, prenom);
            this.ine = "";
            this.promo = 0;
            this.annee = 0;
        }
        public Eleve(String nom, String prenom, String numSecu, String ine, int promo, int annee) {
            super(nom, prenom, numSecu);
            this.ine = ine;
            this.promo = promo;
            this.annee = annee;
        }

        public String getIne() {
            return ine;
        }

        public void setIne(String ine) {
            this.ine = ine;
        }

        public void setPromo(int promo) {
            this.promo = promo;
        }

        public void setAnnee(int annee) {
            this.annee = annee;
        }

        public int getPromo() {
            return promo;
        }

        public int getAnnee() {
            return annee;
        }
}
