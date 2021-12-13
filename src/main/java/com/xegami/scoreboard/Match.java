package com.xegami.scoreboard;

public class Match {

    private Team homeTeam;
    private Team awayTeam;

    private Match() {
    }

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }
}
