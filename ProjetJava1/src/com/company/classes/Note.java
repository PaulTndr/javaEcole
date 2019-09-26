package com.company.classes;

public class Note {
    private String matiere;
    private float note;
    private int credits;
    private boolean validation;
    public Note(String matiere, float note, int credits, boolean validation){
        this.matiere = matiere;
        this.note = note;
        this.credits = credits;
        this.validation = validation;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public boolean getValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
}
