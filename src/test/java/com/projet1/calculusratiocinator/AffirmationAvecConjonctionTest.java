package com.projet1.calculusratiocinator;

import com.projet1.calculusratiocinator.affirmation.Affirmation;
import com.projet1.calculusratiocinator.affirmation.Mensonge;
import com.projet1.calculusratiocinator.affirmation.Verite;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AffirmationAvecConjonctionTest {

    @Test
    void testAffirmationAvecConjonction() {
        Set<Affirmation> affirmations = new HashSet<>();
        CalculusRatiocinator ratiocinator = new CalculusRatiocinator(affirmations);


        Affirmation affirmationEt = new Verite("Lou est pauvre et Lou est généreux.");
        ratiocinator = ratiocinator.AffirmationAvecConjonction(affirmationEt);
        assertTrue(ratiocinator.event().contains(new Verite("Lou est pauvre et Lou est généreux.")));


        Affirmation affirmationOu = new Verite("Lou est beau ou Lou est généreux.");
        ratiocinator = ratiocinator.AffirmationAvecConjonction(affirmationOu);
        assertTrue(ratiocinator.event().contains(new Verite("Lou est beau ou Lou est généreux.")));


        Affirmation affirmationDonc = new Verite("Lou est pauvre donc Lou est généreux.");
        ratiocinator = ratiocinator.AffirmationAvecConjonction(affirmationDonc);
        assertTrue(ratiocinator.event().contains(new Mensonge("Lou est pauvre donc Lou est généreux.")));

    }
}
