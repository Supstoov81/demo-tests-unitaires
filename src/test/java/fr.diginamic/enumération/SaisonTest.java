package fr.diginamic.enumération;

import fr.diginamic.enumerations.Saison;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SaisonTest {

    @Test
    public void testValueOfLibelleNominalCases() {
        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("Printemps"));
        assertEquals(Saison.ETE, Saison.valueOfLibelle("Eté"));
        assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("Automne"));
        assertEquals(Saison.HIVER, Saison.valueOfLibelle("Hiver"));
    }

    @Test
    public void testValueOfLibelleCaseInsensitive() {
        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("printemps"));
        assertEquals(Saison.ETE, Saison.valueOfLibelle("été"));
        assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("automne"));
        assertEquals(Saison.HIVER, Saison.valueOfLibelle("hiver"));
    }

    @Test
    public void testValueOfLibelleInvalidCases() {
        assertThrows(IllegalArgumentException.class, () -> {
            Saison.valueOfLibelle("NonExistentSaison");
        });
    }

    @Test
    public void testValueOfLibelleNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Saison.valueOfLibelle(null);
        });
    }

    @Test
    public void testValueOfLibelleEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            Saison.valueOfLibelle("");
        });
    }
}