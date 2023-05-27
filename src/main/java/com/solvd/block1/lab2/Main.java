package com.solvd.block1.lab2;

/*
 * This program is used to create a match between two teams.
 * It instantiates two teams, a referee, a stadium and a match, and then calls the start() method on the match.
 */


import com.solvd.block1.lab2.collections.LinkedList;
import com.solvd.block1.lab2.exceptions.CoachNotFoundException;
import com.solvd.block1.lab2.exceptions.RefereeNotFoundException;
import com.solvd.block1.lab2.exceptions.StadiumCapacityException;
import com.solvd.block1.lab2.exceptions.TeamNotFoundException;
import com.solvd.block1.lab2.interfaces.PlayerFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    // Static block to display the initialization of the program
    static {
        // Code to be executed in the static block
        LOGGER.info("Initializing the application...");
        // Additional initialization code can be added here
    }

    public static void main(String[] args) {

        // Initialize objects
        Stadium stadium = null;
        Coach homeCoach = null;
        Coach awayCoach = null;
        Team homeTeam = null;
        Team awayTeam = null;
        LinkedList<Referee> referees = null;

        // Create a stadium
        try {
            stadium = new Stadium("Santiago Bernabeu", 50000);
        } catch (StadiumCapacityException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }

        // Create a referee
        try {
            referees = new LinkedList<>();
            referees.add(new Referee("John Smith", 45, Referee.RefereeRole.MAIN));
            referees.add(new Referee("Jane Doe", 35, Referee.RefereeRole.ASSISTANT));
            referees.add(new Referee("Bob Johnson", 40, Referee.RefereeRole.LINE));
            referees.add(new Referee("Alice Williams", 38, Referee.RefereeRole.LINE));
            referees.get(0).setNextReferee(referees.get(1));
            referees.get(1).setNextReferee(referees.get(2));
            referees.get(2).setNextReferee(referees.get(3));
        } catch (RefereeNotFoundException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }

        /* ******************************* ArrayLists operations for players ******************************** */

        // Create players for home team ArrayList
        ArrayList<Player> homePlayers = new ArrayList<>();
        homePlayers.add(new Striker("Benedetto", 25, 9, "Home Team"));
        homePlayers.add(new Striker("Villa", 28, 10, "Home Team"));
        homePlayers.add(new Midfielder("Pol", 30, 8, "Home Team"));
        homePlayers.add(new Midfielder("Medina", 27, 6, "Home Team"));
        homePlayers.add(new Midfielder("Varela", 26, 12, "Home Team"));
        homePlayers.add(new Midfielder("Ramirez", 22, 11, "Home Team"));
        homePlayers.add(new Defender("Barco", 29, 5, "Home Team"));
        homePlayers.add(new Defender("Figal", 32, 4, "Home Team"));
        homePlayers.add(new Defender("Valentini", 24, 3, "Home Team"));
        homePlayers.add(new Defender("Chelo", 24, 2, "Home Team"));
        homePlayers.add(new Goalkeeper("Romero", 33, 1, "Home Team"));

        // Create players for away team ArrayList
        ArrayList<Player> awayPlayers = new ArrayList<>();
        awayPlayers.add(new Striker("Tom", 23, 9, "Away Team"));
        awayPlayers.add(new Striker("Richard", 27, 10, "Away Team"));
        awayPlayers.add(new Midfielder("Harry", 29, 8, "Away Team"));
        awayPlayers.add(new Midfielder("Max", 25, 6, "Away Team"));
        awayPlayers.add(new Midfielder("Sam", 24, 12, "Away Team"));
        awayPlayers.add(new Midfielder("Fer", 19, 7, "Away Team"));
        awayPlayers.add(new Defender("Will", 30, 5, "Away Team"));
        awayPlayers.add(new Defender("Doug", 28, 4, "Away Team"));
        awayPlayers.add(new Defender("Tim", 26, 3, "Away Team"));
        awayPlayers.add(new Defender("Casco", 31, 2, "Away Team"));
        awayPlayers.add(new Goalkeeper("Kevin", 32, 1, "Away Team"));

        // Create coaches
        try {
            homeCoach = new Coach("Peter", 56);
            awayCoach = new Coach("Edward", 49);
        } catch (CoachNotFoundException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }

        // Create the teams
        try {
            homeTeam = new Team("Boca Juniors", homePlayers, homeCoach);
            awayTeam = new Team("River Plate", awayPlayers, awayCoach);
        } catch (TeamNotFoundException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }

        // Create a match
        Match match = new Match(homeTeam, awayTeam, stadium, referees);

        // ************** Display the Referees ****************** //
        LOGGER.info("The Referees for today's match are: ");
        for (int i = 0; i < referees.size(); i++) {
            referees.get(i).displayReferees();
        }

        // ************************************** Lambda functions (java.util.function package) ************************************** //
        // ************** Display Lineups ****************** //
        // Home Lineup
        //LOGGER.info(homeTeam.getName() + " lineup:");
        //homeTeam.printTeamLineup();

        // Away Lineup
        // LOGGER.info(awayTeam.getName() + " lineup:");
        // awayTeam.printTeamLineup();

        // ************** Display team stats ************** //
        // Home Team Stats
        // LOGGER.info(homeTeam.getName() + " stats");
        // ArrayList<Player> homeFilteredPlayers = homeTeam.filterPlayers(player -> player.getAge() > 30);
        // homeTeam.displayFilteredPlayers(homeFilteredPlayers);

        // Away Team Stats
        // LOGGER.info(awayTeam.getName() + " stats");
        // ArrayList<Player> awayFilteredPlayers = awayTeam.filterPlayers(player -> player.getAge() > 30);
        // awayTeam.displayFilteredPlayers(awayFilteredPlayers);


        // ************************************** Custom Lambda functions ************************************** //


        // Create a Comparator object that sorts players based on their position
        // LOGGER.info("Creating position comparator");
        Comparator<Player> positionComparator = Comparator.comparing(Player::getPosition);

        // ****************** Display Lineups ****************** //

        // Home Lineup
        // Sort the home team's players based on the created Comparator
        LOGGER.info(homeTeam.getName() + " lineup:");
        homeTeam.sortPlayers(positionComparator);
        for (Player player : homeTeam.getPlayers()) {
            LOGGER.info(player.getName() + " - " + player.getPosition());
        }

        // Away Lineup
        // Sort the away team's players based on the created Comparator
        LOGGER.info(awayTeam.getName() + " lineup:");
        awayTeam.sortPlayers(positionComparator);
        for (Player player : awayTeam.getPlayers()) {
            LOGGER.info(player.getName() + " - " + player.getPosition());
        }

        // Create a PlayerFilter object that filters players based on their position
        // LOGGER.info("Creating player filter based on position");
        PlayerFilter filter = (player) -> player.getPosition().equals("Defender");

        // Filter the home team's players based on the created filter
        // LOGGER.info("Filtering home team's players based on position");
        ArrayList<Player> homeFilteredPlayers = homeTeam.filterPlayers(filter);
        homeTeam.displayFilteredPlayers(homeFilteredPlayers);

        // Filter the away team's players based on the created filter
        // LOGGER.info("Filtering home team's players based on position");
        ArrayList<Player> awayFilteredPlayers = awayTeam.filterPlayers(filter);
        awayTeam.displayFilteredPlayers(awayFilteredPlayers);


        // ************** Display teams' stats ************** //

        // Calculate the average age of the home team's players
        LOGGER.info("Teams' Stats:");
        double homeAverageAge = homeTeam.calculateAverageAge();
        double awayAverageAge = awayTeam.calculateAverageAge();
        LOGGER.info(homeTeam.getName() + " average age: " + (int) homeAverageAge);
        LOGGER.info(awayTeam.getName() + " average age: " + (int) awayAverageAge);

        // Play the match
        match.playMatch();

    }
}