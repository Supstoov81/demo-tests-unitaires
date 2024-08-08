package fr.diginamic.utils;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringUtilsTest {

    @Test
    public void testSameStrings() {
        // Cas où les deux chaînes sont identiques
        assertEquals(0, StringUtils.levenshteinDistance("test", "test"));
    }

    @Test
    public void testAddLetter() {
        // Cas où une lettre est ajoutée
        assertEquals(1, StringUtils.levenshteinDistance("chat", "chats"));
    }

    @Test
    public void testRemoveLetter() {
        // Cas où une lettre est supprimée
        assertEquals(1, StringUtils.levenshteinDistance("chats", "chat"));
    }

    @Test
    public void testReplaceLetter() {
        // Cas où une lettre est remplacée
        assertEquals(1, StringUtils.levenshteinDistance("machins", "machine"));
    }

    @Test
    public void testDistanceBetweenDifferentWords() {
        // Cas où les deux chaînes sont similaires mais avec une substitution nécessaire
        assertEquals(1, StringUtils.levenshteinDistance("avion", "aviron"));
    }

    @Test
    public void testEmptyStrings() {
        // Distance entre "aviron" (6 caractères) et une chaîne vide devrait être 6, pas 7.
        assertEquals(6, StringUtils.levenshteinDistance("aviron", ""));
        assertEquals(0, StringUtils.levenshteinDistance("", ""));
    }
    @Test
    public void testDistanceBetweenDistanceAndInstance() {
        // Test pour la distance entre "distance" et "instance"
        assertEquals(2, StringUtils.levenshteinDistance("distance", "instance"));
    }

    @Test
    public void testDistanceBetweenChienAndChine() {
        // Test pour la distance entre "Chien" et "Chine"
        assertEquals(2, StringUtils.levenshteinDistance("Chien", "Chine"));
    }

    @Test
    public void testWithNullValues() {
        // Attendre une IllegalArgumentException au lieu d'une NullPointerException
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance(null, "test");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance("test", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance(null, null);
        });
    }
}
