package com.company.classes.personne;

import com.company.classes.Note;
import com.company.classes.personne.Eleve;

import java.util.ArrayList;

public class EleveDigitale extends Eleve {
    private ArrayList<Note> notes;
    public EleveDigitale(String nom, String prenom) {
        super(nom, prenom);
        this.notes = new ArrayList<Note>();
    }
    public EleveDigitale(String nom, String prenom, String numSecu, String ine, int promo, int annee) {
        super(nom, prenom, numSecu, ine, promo, annee);
        this.notes = new ArrayList<Note>();
    }
    public EleveDigitale(String nom, String prenom, String numSecu, String ine, int promo, int annee, ArrayList<Note> notes) {
        super(nom, prenom, numSecu, ine, promo, annee);
        this.notes = notes;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
    public void ajoutNote(Note note){
        notes.add(note);
    }
    public Note getNote(int index){
        return notes.get(index);
    }
}
