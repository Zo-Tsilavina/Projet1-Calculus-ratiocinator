package com.projet1.calculusratiocinator.affirmation;

public final class Mensonge extends Affirmation {
    public Mensonge(String texte) {
        super(texte);
    }

    @Override
    public boolean estVraie() {
        return false;
    }
}
