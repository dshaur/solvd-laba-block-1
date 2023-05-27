package com.solvd.block1.lab2;

import com.solvd.block1.lab2.exceptions.TeamNotFoundException;
import com.solvd.block1.lab2.interfaces.Celebratable;
import com.solvd.block1.lab2.interfaces.PlayerFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class Team implements Celebratable {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Team.class);

    // Attributes and variables
    private String name;
    private ArrayList<Player> players;
    private Coach coach;

    // Constructor
    public Team(String name, ArrayList<Player> players, Coach coach) throws TeamNotFoundException {

        // The code checks if the name of the home or away team is empty. If it is empty, it throws a
        // "TeamNotFoundException" indicating that the team is not found. This is to ensure that both the home and
        // away teams are properly identified and accounted for.
        if (StringUtils.isEmpty(name)) {
            throw new TeamNotFoundException("Home team or away team not found.");
        }

        this.name = name;
        this.players = players;
        this.coach = coach;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    // celebrate() method
    @Override
    public void celebrate() {
        LOGGER.info(getName() + " players are celebrating!");
    }

    // Method that prints each team's lineup using Consumer lambda
    public void printTeamLineup() {
        players.forEach(player -> LOGGER.info((player.getName())));
    }

    // Method that filters players
    public ArrayList<Player> filterPlayers(PlayerFilter filter) {
        ArrayList<Player> filteredPlayers = new ArrayList<Player>();
        for (Player player : players) {
            if (filter.filterPlayer(player)) {
                filteredPlayers.add(player);
            }
        }
        return filteredPlayers;
    }

    // Method to display filtered players (java.util Lambdas)
    // public void displayFilteredPlayers(ArrayList<Player> filteredPlayers) {
    //   LOGGER.info("Players over 30 in " + this.getName() + ":");
    //   for (Player player : filteredPlayers) {
    //       LOGGER.info(player.getName());
    //  }
    // }

    // Method to display filtered players (Custom Lambdas)
    public void displayFilteredPlayers(ArrayList<Player> filteredPlayers) {
        LOGGER.info("Best Defenders in " + this.getName() + ":");
        for (Player player : filteredPlayers) {
            LOGGER.info(player.getName());
        }
    }

    public double calculateAverageAge() {
        return players.stream()
                .mapToInt(Player::getAge)
                .average()
                .orElse(0.0);
    }

    public void sortPlayers(Comparator<Player> comparator) {
        players.sort(comparator);
    }
}
