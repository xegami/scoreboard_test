package com.xegami.scoreboard;

public class Team {

    private String name;
    private int score;

    private Team(){}

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
