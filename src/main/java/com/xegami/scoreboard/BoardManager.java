package com.xegami.scoreboard;

import java.util.*;
import java.util.stream.Collectors;

public class BoardManager {

    public void start() {
        System.out.println("Type 1 to see recorded matches. ");
        System.out.println("Type 2 to record a new match. ");
        System.out.print("Type 3 to exit.\n> ");

        final Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String line = scanner.nextLine();

                switch (line) {
                    case "1":
                        showMatches();
                        break;
                    case "2":
                        recordMatch(scanner);
                        break;
                    case "3":
                        System.out.println("Leaving program.");
                        return;
                    default:
                        System.out.println("Unknown input.");
                }

                System.out.print("What do you want to do now?\n> ");
            }

        } catch (IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("Unexpected error.");
        }

    }

    private void showMatches() {
        if (MatchRepository.getInstance().getMatches().size() == 0) {
            System.out.println("No matches to show.");
            return;
        }

        MatchRepository.getInstance().getMatches().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getHomeTeam().getScore() + o2.getAwayTeam().getScore(), o1.getHomeTeam().getScore() + o1.getAwayTeam().getScore()))
                .collect(Collectors.toList())
                .forEach(m -> System.out.println(m.getHomeTeam().getName() + " - " + m.getAwayTeam().getName() + ": " + m.getHomeTeam().getScore() + " - " + m.getAwayTeam().getScore()));
    }

    private void recordMatch(Scanner scanner) {
        String htName, atName;
        int htScore, atScore;

        System.out.print("Home team name:\n> ");
        htName = scanner.nextLine();
        System.out.print("Home team score:\n> ");
        htScore = scanner.nextInt();
        scanner.nextLine(); // scanner behaviour

        System.out.print("Away team name:\n> ");
        atName = scanner.nextLine();
        System.out.print("Away team score:\n> ");
        atScore = scanner.nextInt();
        scanner.nextLine(); // scanner behaviour

        MatchRepository.getInstance().saveMatch(new Match(new Team(htName, htScore), new Team(atName, atScore)));

        System.out.println("Match saved successfully.");
    }
}
