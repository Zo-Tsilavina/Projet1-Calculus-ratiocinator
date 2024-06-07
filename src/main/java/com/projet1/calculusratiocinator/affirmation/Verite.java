package com.projet1.calculusratiocinator.affirmation;

public final class Verite extends Affirmation {
    public Verite(String texte) {
        super(texte);
    }

    @Override
    public boolean estVraie(String texte) {
        return true;
    }
}
