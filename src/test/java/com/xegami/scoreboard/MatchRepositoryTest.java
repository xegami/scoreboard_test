package com.xegami.scoreboard;

import org.junit.Test;

public class MatchRepositoryTest {

    @Test
    public void shouldReturnAnEmptyListTest() {
        assert MatchRepository.getInstance().getMatches().size() == 0;
    }

    @Test
    public void shouldAddAMatchSuccessfully() {
        MatchRepository.getInstance().getMatches().add(new Match(new Team("spain", 1), new Team("germany", 0)));
        assert MatchRepository.getInstance().getMatches().size() == 1;
    }
}
