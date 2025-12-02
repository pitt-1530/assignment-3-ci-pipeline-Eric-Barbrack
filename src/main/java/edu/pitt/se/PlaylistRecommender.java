package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {
 

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()
	if (bpms == null || bpms.isEmpty()) {
        	return "INVALID";
        }

        int total = 0;
        for (int bpm : bpms) {
		total += bpm;
        }

	int decider = total / bpms.size();

        if (decider >= 140) {
            return "HIGH";
        } else if (decider >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
	if (title == null) {
        	return false;
    	}
	String trimmed = title.trim();
	if(trimmed.length() < 1 || trimmed.length() > 30) {
		return false;
	}
	return trimmed.matches("[A-Za-z ]+");
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
	if(volumeDb > 100) {
		return 100;
	} else if(volumeDb < 0) {
		return 0;
	} else {
		return volumeDb;
	}
    }
}
