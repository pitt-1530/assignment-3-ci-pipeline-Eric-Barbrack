package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class PlaylistRecommenderTest {

    // classifyEnergy

    @Test
    public void testClassifyEnergy_High() {
        List<Integer> bpms = Arrays.asList(150, 145, 160);
	assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergy_Medium() {
        List<Integer> bpms = Arrays.asList(110, 105, 120);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergy_Low() {
        List<Integer> bpms = Arrays.asList(80, 90, 70);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergy_InvalidEmptyList() {
        List<Integer> bpms = new ArrayList<>();
        assertEquals("INVALID", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergy_InvalidNullList() {
        assertEquals("INVALID", PlaylistRecommender.classifyEnergy(null));
    }

    //isValidTrackTitle

    @Test
    public void testIsValidTrackTitle_Valid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Summer Breeze"));
    }

    @Test
    public void testIsValidTrackTitle_MinLength() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("A"));
    }

    @Test
    public void testIsValidTrackTitle_MaxLength() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("A".repeat(30)));
    }

    @Test
    public void testIsValidTrackTitle_TooLong() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("B".repeat(31)));
    }

    @Test
    public void testIsValidTrackTitle_SpecialCharacters() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Hello!"));
    }

    @Test
    public void testIsValidTrackTitle_Digits() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Track 123"));
    }

    @Test
    public void testIsValidTrackTitle_Null() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void testIsValidTrackTitle_OnlySpaces() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("     "));
    }

    // normalizeVolume

    @Test
    public void testNormalizeVolume_TooHigh() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
    }

    @Test
    public void testNormalizeVolume_TooLow() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
    }

    @Test
    public void testNormalizeVolume_InRange() {
        assertEquals(55, PlaylistRecommender.normalizeVolume(55));
    }
}
