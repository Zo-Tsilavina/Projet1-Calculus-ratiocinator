package com.projet1.calculusratiocinator;

import com.projet1.calculusratiocinator.affirmation.Affirmation;
import com.projet1.calculusratiocinator.affirmation.Mensonge;
import com.projet1.calculusratiocinator.affirmation.Verite;

import java.util.HashSet;
import java.util.Set;

public record CalculusRatiocinator(Set<Affirmation> event) {
    public CalculusRatiocinator{
        event = new HashSet<>(event);
    }
    public CalculusRatiocinator(){
        this(new HashSet<>());
    }

    public CalculusRatiocinator AjoutAffirmation(Affirmation affirmation){
        Set<Affirmation> nouvellesAffirmations = new HashSet<>(this.event);
        nouvellesAffirmations.add(affirmation);
        return new CalculusRatiocinator(nouvellesAffirmations);
    }

    public CalculusRatiocinator AffirmationAvecConjonction(Affirmation affirmation) {
        String texteAffirmation = affirmation.getTexte();

        if (texteAffirmation.contains(" et ")) {
            String[] parties = texteAffirmation.split(" et ");
            Affirmation affirmation1 = new Verite(parties[0]);
            Affirmation affirmation2 = new Verite(parties[1]);
            if (affirmation1.estVraie() && affirmation2.estVraie()) {
                return AjoutAffirmation(new Verite(texteAffirmation));
            } else {
                return AjoutAffirmation(new Mensonge(texteAffirmation));
            }
        } else if (texteAffirmation.contains(" ou ")) {
            String[] parties = texteAffirmation.split(" ou ");
            Affirmation affirmation1 = new Verite(parties[0]);
            Affirmation affirmation2 = new Verite(parties[1]);
            if (affirmation1.estVraie() || affirmation2.estVraie()) {
                return AjoutAffirmation(new Verite(texteAffirmation));
            } else {
                return AjoutAffirmation(new Mensonge(texteAffirmation));
            }
        } else if (texteAffirmation.contains(" donc ")) {
            String[] parties = texteAffirmation.split(" donc ");
            Affirmation affirmation1 = new Verite(parties[0]);
            Affirmation affirmation2 = new Verite(parties[1]);
            if (!affirmation1.estVraie() || affirmation2.estVraie()) {
                return AjoutAffirmation(new Verite(texteAffirmation));
            } else {
                return AjoutAffirmation(new Mensonge(texteAffirmation));
            }
        } else {
            throw new JeNeSaisPas();
        }
    }
}
