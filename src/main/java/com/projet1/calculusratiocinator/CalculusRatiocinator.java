package com.projet1.calculusratiocinator;

import com.projet1.calculusratiocinator.affirmation.Affirmation;

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
}
