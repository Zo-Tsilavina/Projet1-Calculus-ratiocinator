package com.projet1.calculusratiocinator.affirmation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public sealed abstract class Affirmation permits
        Mensonge, Verite{
    protected String texte;

    public abstract boolean estVraie();
}
