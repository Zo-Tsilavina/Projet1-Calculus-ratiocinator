package com.projet1.calculusratiocinator;

import com.projet1.calculusratiocinator.affirmation.Mensonge;
import com.projet1.calculusratiocinator.affirmation.Verite;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AjoutAffirmationTest {

    @Test
    void testDAjout(){
        CalculusRatiocinator cr = new CalculusRatiocinator();
        Mensonge mensonge1 = new Mensonge("Lou est pauvre");
        Verite verite1 = new Verite("Lou est beau");

        cr = cr.AjoutAffirmation(mensonge1);
        cr = cr.AjoutAffirmation(verite1);

        Set<String> affTexte = new HashSet<>();
        for (var affirmation : cr.event()){
            affTexte.add(affirmation.getTexte());
        }

        assertEquals(2, affTexte.size());
        assertEquals(true, affTexte.contains("Lou est pauvre"));
        assertEquals(true, affTexte.contains("Lou est beau"));
    }
}
