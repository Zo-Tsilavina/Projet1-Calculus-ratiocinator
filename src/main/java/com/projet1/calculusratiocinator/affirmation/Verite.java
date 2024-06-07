package com.projet1.calculusratiocinator.affirmation;

public final class Verite extends Affirmation {
    public Verite(String texte) {
        super(texte);
    }

    @Override
    public boolean estVraie() {
        return true;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Verite other = (Verite) obj;
        return texte.equals(other.texte);
    }

    @Override
    public int hashCode() {
        return texte.hashCode();
    }
}
