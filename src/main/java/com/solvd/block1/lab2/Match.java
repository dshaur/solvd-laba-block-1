package com.solvd.block1.lab2;

/*
 * This is the class for representing matches. It has four fields,
 * homePlayers, awayPlayers, referee, and stadium, to store related objects.
 * The playMatch() method is provided to start the match, which involves
 * letting both homePlayers and awayPlayers play against each other.
 */

import com.solvd.block1.lab2.collections.LinkedList;
import com.solvd.block1.lab2.exceptions.MissingParameterException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

class Match {

    private static final Logger LOGGER = LogManager.getLogger(Match.class);

    // Attributes and variables
    private final Team HOME_TEAM;
    private final Team AWAY_TEAM;

    private LinkedList<Referee> referees;
    private Stadium stadium;

    private static final Score SCORE = new Score();
    private static final Random RANDOM = new Random();

    // Constructor
    public Match(Team homeTeam, Team awayTeam, Stadium stadium, LinkedList<Referee> referees) {

        // The code checks if any of the required parameters (homeTeam, awayTeam, stadium, referees) are null using
        // the ObjectUtils.anyNull() method. If any parameter is null, a MissingParameterException is thrown.
        if (ObjectUtils.anyNull(homeTeam, awayTeam, stadium, referees)) {
            throw new MissingParameterException("One or more required parameters are missing.");
        }

        this.HOME_TEAM = homeTeam;
        this.AWAY_TEAM = awayTeam;
        this.stadium = stadium;
        this.referees = referees;
    }

    // Setters and Getters from hw2 practice

    public LinkedList<Referee> getReferee() {
        return referees;
    }


    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    /*
     * This class represents a single match between two teams.
     */
    public void playMatch() {


        LOGGER.info("The match between " + HOME_TEAM.getName() + " and " + AWAY_TEAM.getName() + " starts now at the " + stadium.getName() + " stadium!");


        // Coaches instruct their teams
        HOME_TEAM.getCoach().instructTeam();
        AWAY_TEAM.getCoach().instructTeam();


        // Referee starts the game
        referees.get(0).whistle();

        // Randomly determine which team gets possession first
        ArrayList<Player> teamWithPossession;
        if (RANDOM.nextBoolean()) {

            teamWithPossession = HOME_TEAM.getPlayers();

            LOGGER.info(HOME_TEAM.getPlayers().get(10).getName() + " starts with possession!");

        } else {

            teamWithPossession = AWAY_TEAM.getPlayers();

            LOGGER.info(AWAY_TEAM.getPlayers().get(10).getName() + " starts with possession!");
        }

        // Counter of actions performed to finalize the match
        int count = 0;

        // Play the match
        while (true) {
            count++;
            Player playerWithPossession = teamWithPossession.get(RANDOM.nextInt(teamWithPossession.size()));
            LOGGER.info(playerWithPossession.getName() + " has the ball.");
            // Simulate player actions
            playerWithPossession.performAction();
            // Randomly determine if the opposing team takes possession next
            if (RANDOM.nextBoolean()) {
                if (teamWithPossession == HOME_TEAM.getPlayers()) {
                    teamWithPossession = AWAY_TEAM.getPlayers();
                } else {
                    teamWithPossession = HOME_TEAM.getPlayers();
                }
            }
            // Check if the match is over according to the counter
            if (count == 20) {

                // The referee ends the match
                referees.get(0).whistle();
                LOGGER.info("The match is over!");

                // Once the match ends, coaches cheer up their teams
                HOME_TEAM.getCoach().cheer();
                AWAY_TEAM.getCoach().cheer();
                break;
            }
        }

        // Report the final score
        LOGGER.info(HOME_TEAM.getName() + " " + SCORE.getHomeScore() + " - " + SCORE.getAwayScore() + " " + AWAY_TEAM.getName());

        // Make the winner celebrate, otherwise it is a draw
        if (SCORE.getHomeScore() > SCORE.getAwayScore()) {
            HOME_TEAM.celebrate();
        } else if (SCORE.getHomeScore() < SCORE.getAwayScore()) {
            AWAY_TEAM.celebrate();
        } else {
            LOGGER.info("It's a draw!");
        }

    }

    public static Score getScore() {
        return SCORE;
    }
}