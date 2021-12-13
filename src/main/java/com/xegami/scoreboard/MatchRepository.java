package com.xegami.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class MatchRepository {

    private static final List<Match> matches = new ArrayList<>();
    private static MatchRepository instance;

    public static MatchRepository getInstance() {
        if (instance == null) {
            instance = new MatchRepository();
        }

        return instance;
    }

    private MatchRepository() {
        
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void saveMatch(Match match) {
        matches.add(match);
    }
}
